package org.imat.module;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.*;

import org.apache.commons.lang3.text.WordUtils;
import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.core.StopFilter;
import org.apache.lucene.analysis.shingle.ShingleFilter;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.imat.dbpedia.DBPediaType;
import org.imat.dbpedia.DBPediaTypeComparator;
import org.imat.dbpedia.DBPediaManager;
import org.imat.ontology.OntologyManager;
import org.imat.tree.HierarchyInfo;
import org.imat.tree.NodeInput;
import org.imat.tree.NodeService;
import org.imat.utile.owl.*;
import org.imat.wordnet.WordNet;
import org.json.JSONArray;
import org.json.JSONObject;

public class RequestAnalyzer {
	private final static String REPLACED_INPUT = "ReplacedByMyInput";
	private DBPediaManager dbPediaManager = new DBPediaManager();
	private OntologyManager ontologyManager;
	private InputOutputMatching matching;

	public RequestAnalyzer(OntologyManager ontologyManager, InputOutputMatching inputOutputMatching) {
		this.ontologyManager = ontologyManager;
		matching = inputOutputMatching;
	}
	
	public String findInputs(String input, HashMap<String, ArrayList<DBPediaType>> inputParams) throws IOException {

		String regex = "([+-]?\\d+\\.?\\d+)\\s*,\\s*([+-]?\\d+\\.?\\d+)";

		Pattern compiledPattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = compiledPattern.matcher(input);
		while (matcher.find()) {
			int indexComma = matcher.group().indexOf(",");
			ArrayList<DBPediaType> temp = new ArrayList<DBPediaType>(); temp.add(new DBPediaType("latitude", 1) );
			inputParams.put(matcher.group().substring(0, indexComma), temp );
			temp =new ArrayList<DBPediaType>(); temp.add(new DBPediaType("longitude", 1) ); 
			inputParams.put(matcher.group().substring(indexComma + 1, matcher.group().length()), temp);
		}

		input = input.replaceAll(regex, REPLACED_INPUT);
		regex = "(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d";

		compiledPattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		matcher = compiledPattern.matcher(input);
		while (matcher.find()) {
			ArrayList<DBPediaType> temp = new ArrayList<DBPediaType>(); temp.add(new DBPediaType("date", 1) );
			inputParams.put(matcher.group(), temp);
		}
		input = input.replaceAll(regex, REPLACED_INPUT);

		// System.out.println(StopAnalyzer.ENGLISH_STOP_WORDS_SET);

		Tokenizer source = new StandardTokenizer();
		source.setReader(new StringReader(input));

		TokenStream tokenizer = new ShingleFilter(source, 2, 3);

		tokenizer = new StopFilter(tokenizer, StopAnalyzer.ENGLISH_STOP_WORDS_SET);
		CharTermAttribute charTermAttribute = tokenizer.addAttribute(CharTermAttribute.class);

		tokenizer.reset();
		while (tokenizer.incrementToken()) {
			String tempTokeniz = WordUtils.capitalize(charTermAttribute.toString());
			if (tempTokeniz.contains(REPLACED_INPUT))
				continue;
			System.out.println(tempTokeniz);

			ArrayList<DBPediaType> result = dbPediaManager.findTypes(tempTokeniz);

			if (result.size() > 0) {

				Iterator<String> iterate = inputParams.keySet().iterator();
				boolean addNewInput = true;
				while (iterate.hasNext()) {
					String key = iterate.next();
					if (tempTokeniz.equals(key))
						break;
					if (tempTokeniz.contains(key)) {
						iterate.remove();
						System.out.println("--remove: " + key);
						break;
					} else if (key.contains(tempTokeniz)) {
						addNewInput = false;
						break;
					}

				}
				if (addNewInput) {
					inputParams.put(tempTokeniz, result);
					System.out.println("++add: " + tempTokeniz);
				}

			}

		}
		tokenizer.close();
		return input;
	}

	public void findOutputs(String input, HashMap<String, ArrayList<DBPediaType>> inputParams, HashMap<String, TreeSet<NodeInput>> inparam,
			HashMap<String, TreeSet<OutputParam>> outparam) throws IOException {
		// System.out.println("----------------------------out");
		WordNet wdnet = new WordNet();
		HashMap<String, ArrayList<DBPediaType>> in = new HashMap<String, ArrayList<DBPediaType>>();
		ArrayList<String> out = new ArrayList<String>();

		Tokenizer source = new StandardTokenizer();
		source.setReader(new StringReader(input));
		TokenStream tokenizer = new StopFilter(source, StopAnalyzer.ENGLISH_STOP_WORDS_SET);
		CharTermAttribute charTermAttribute = tokenizer.addAttribute(CharTermAttribute.class);

		tokenizer.reset();
		tokeniz: while (tokenizer.incrementToken()) {
			if (charTermAttribute.toString().contains(REPLACED_INPUT))
				continue;
			String tempTokeniz = WordUtils.capitalize(charTermAttribute.toString());
			for (Entry<String, ArrayList<DBPediaType>> inp : inputParams.entrySet()) {
				if (inp.getKey().contains(tempTokeniz) && !inp.getKey().equals(tempTokeniz)) {
					ArrayList<DBPediaType> types =inp.getValue();// e.getTypes();

					if (wdnet.hasMeaning(inp.getKey())) {
						compareList(types, wdnet.getTypes(inp.getKey()));						
					}
					in.put(inp.getKey(), types);
					continue tokeniz;
				}

			}

			if (inputParams.get(tempTokeniz) == null || inputParams.get(tempTokeniz).size() == 0) {
				if (wdnet.hasMeaning(tempTokeniz)) {
					if (wdnet.isInstance(tempTokeniz))						
						in.put(tempTokeniz,compareList( new ArrayList<DBPediaType>(), wdnet.getTypes(tempTokeniz)));
					else
						out.add(tempTokeniz);

				}
			} else {
				
				ArrayList<DBPediaType> types = inputParams.get(tempTokeniz);
			
				if (wdnet.hasMeaning(tempTokeniz)) {

					if (wdnet.isInstance(tempTokeniz)) {
						types.addAll(compareList( new ArrayList<DBPediaType>(),wdnet.getTypes(tempTokeniz)));
						in.put(tempTokeniz, types);
					} else
						out.add(tempTokeniz);

				} else {

					in.put(tempTokeniz, types);
				}

			}

		}
		tokenizer.close();
		for (Entry<String, ArrayList<DBPediaType>> inp : inputParams.entrySet()) {
			if (!out.contains(inp.getKey()) && !in.containsKey(inp.getKey())) {
				in.put(inp.getKey(),inp.getValue());
			}

		}
		for (String ar : out)
			System.out.println("Out: " + ar);
		for (String ar : in.keySet())
			System.out.println("In: " + ar + "->" + in.get(ar));

		for (Entry<String, ArrayList<DBPediaType>> inp : in.entrySet()) {

			inparam.put(inp.getKey(), matching.getInputMatching(inp.getValue(), ontologyManager.getModel()));
		}

		for (String o : out) {
			outparam.put(o, matching.getOutputMatching(o.toLowerCase(), ontologyManager.getModel()));
		}

	}

	private ArrayList<DBPediaType> compareList(ArrayList<DBPediaType> baseList ,  Collection<String> newList){

		DBPediaType dbPediaType = null;
		for (String string : newList) {
			dbPediaType = new DBPediaType(string,1);
			if(baseList.contains(dbPediaType)) continue;
			baseList.add(dbPediaType);
		}
		return baseList;
	}
	/*private Collection<DBPediaEntity> createDBPediaEntity(String name, String from) {

		Collection<DBPediaEntity> collection = new PriorityQueue<DBPediaEntity>(new DBPediaEntityComparator());
		DBPediaEntity dp = new DBPediaEntity(name, from);
		ArrayList<String> types = new ArrayList<String>();
		types.add(from);
		dp.setTypes(types);
		collection.add(dp);
		return collection;
	}*/

	public String search(String input, Hashtable<OutputParam, List<HierarchyInfo>> table) throws Exception {

		HashMap<String, ArrayList<DBPediaType>> in = new HashMap<String, ArrayList<DBPediaType>>();
		
		HashMap<String, TreeSet<NodeInput>> inparams = new HashMap<String, TreeSet<NodeInput>>();
		HashMap<String, TreeSet<OutputParam>> outparams = new HashMap<String, TreeSet<OutputParam>>();
		TreeSet<NodeService> nodeServices = new TreeSet<NodeService>();
		ArrayList<JSONArray> last_obj = new ArrayList<JSONArray>();

		try {
			findOutputs(findInputs(input, in), in, inparams, outparams);
			for (Entry<String, TreeSet<OutputParam>> entry : outparams.entrySet()) {
				for (OutputParam outparam : entry.getValue()) {
					if (table.get(outparam) == null)
						continue;
					NodeService nodeService = findService(inparams, outparam, table);
					if (nodeService != null)
						nodeServices.add(nodeService);
				}
			}
			for (NodeService nodeService : nodeServices) {
				System.out.println("nodeService: " + nodeService);
				last_obj.addAll(calculateOutput(nodeService));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject resp = new JSONObject();

		try {
			// resp.put("type","type.toString()");
			resp.put("results", last_obj);
			System.out.println(resp.toString());
		} catch (Exception e) {
		}
		return resp.toString();

	}

	void fillInputDataInChain(NodeService nodeService, List<NodeInput> nodeInputs) {

		for (NodeInput nodeInput : nodeService.getInputs()) {

			if (nodeInput.getChiledNodeService() != null) {

				fillInputDataInChain(nodeInput.getChiledNodeService(), nodeInputs);
			} else {
				
				// return value of input
				NodeInput userNodeInput = nodeInputs.get(nodeInputs.indexOf(new NodeInput(nodeInput.getInputParam(), 0)));
				nodeInput.setValue(userNodeInput.getValue());
			}

		}

	}

	ArrayList<JSONArray> calculateOutput(NodeService nodeService) throws Exception {

		for (NodeInput nodeInput : nodeService.getInputs()) {

			if (nodeInput.getChiledNodeService() != null) {

				calculateOutput(nodeInput.getChiledNodeService());
			}
		}
	
		return callMethods(nodeService);

	}

	public ArrayList<JSONArray> callMethods(NodeService nodeService) throws Exception {
		ArrayList<JSONArray> result = new ArrayList<JSONArray>();
		// type.clear();

		Resource r = nodeService.getMethodCall().getIsPartOfResource().iterator().next();
		System.out.println("org.imat.service." + OntologyManager.getName(r.getIsPartOfService().iterator().next().getOwlIndividual().toString())
				+ "$" + OntologyManager.getName(r.getOwlIndividual().toString()));
		Class<?> c = Class.forName("org.imat.service."
				+ OntologyManager.getName(r.getIsPartOfService().iterator().next().getOwlIndividual().toString()) + "$"
				+ OntologyManager.getName(r.getOwlIndividual().toString()));
		System.out.println(OntologyManager.getName(nodeService.getMethodCall().getOwlIndividual().toString()));
		Method ma = c.getMethod(OntologyManager.getName(nodeService.getMethodCall().getOwlIndividual().toString()), HashMap.class);

		HashMap<String, String> map = new HashMap<String, String>();

		for (NodeInput nodeInput : nodeService.getInputs()) {
			map.put(nodeInput.getInputParam().getLabel().iterator().next().toString(), nodeInput.getValue());

		}

		// System.out.println(map);

		String o1 = (String) ma.invoke(c.newInstance(), map);
		JSONArray o = new JSONArray(o1);
		result.add(o);
		if (nodeService.getParentNode() == null)
			return result;
		for (int k = 0; k < o.length(); k++) {
			JSONObject obj = o.getJSONObject(k);
			HashMap<String, String> out = new HashMap<String, String>();
			nodeService.getParentNode().setValue(
					obj.get(nodeService.getParentNode().getOutputParam().getLabel().iterator().next().toString()).toString());

		}
		return result;
	}

	private NodeService findService(HashMap<String, TreeSet<NodeInput>> userInparams, OutputParam outputParam,
		Hashtable<OutputParam, List<HierarchyInfo>> table) throws Exception {
		List<NodeInput> nodeInputs = null;
		NodeService nodeService = null;
		long weight=0l;
		long minWeight=Long.MAX_VALUE;
		for (HierarchyInfo hierarchyInfo : table.get(outputParam)) {
			for (Entry<TreeSet<InputParam>, NodeService> inputsPaths : hierarchyInfo.getInputsPaths().entrySet()) {
				if (userInparams.size() == inputsPaths.getKey().size()) {
					int count = 0;
					nodeInputs = new ArrayList<NodeInput>();
					weight=0l;
					for (InputParam fcInputParam : inputsPaths.getKey()) {// input of chain
						for (Entry<String, TreeSet<NodeInput>> userinputParam : userInparams.entrySet()) {// User inputs						
							if (userinputParam.getValue().contains( new NodeInput(fcInputParam,0))) {//check if user input contain a input for fc input
								//for example beirut has multi-types: city, urban area, location
								//one of these type can be available for in input parameter of the chain.
								NodeInput temp = userinputParam.getValue().stream().filter(e->e.getInputParam().equals(fcInputParam)).findFirst().get();
								count++;
								temp.setValue(userinputParam.getKey());
								nodeInputs.add(temp);
								weight += temp.getWeight(); 
							}
						}

					}
					if (count == userInparams.size() && minWeight > weight) {
						minWeight = weight;
						nodeService = inputsPaths.getValue().copyObject(null);
						fillInputDataInChain(nodeService, nodeInputs);
						//return nodeService;
					}
				}

			}

		}
		return nodeService;
	}

}
