package org.imat.module;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.imat.ontology.OntologyManager;
import org.imat.tree.HierarchyInfo;
import org.imat.tree.NodeInput;
import org.imat.tree.NodeService;
import org.imat.utile.owl.*;

/**
 * Session Bean implementation class OntologyChainAnalysis
 * this class is the main class, where the chain is produced
 */
@Singleton
@LocalBean
@Startup
public class OntologyChainAnalysis {

	private OntologyManager ontologyManager ;
	private Hashtable<OutputParam, List<HierarchyInfo>> table = new Hashtable<OutputParam, List<HierarchyInfo>>();
	private InputOutputMatching matching;
	private static int outCount = 0;
			
	@PostConstruct
	public void init() {
		System.setProperty("wordnet.database.dir", OntologyManager.mainPath +"\\dict");
		ontologyManager = new OntologyManager();
		matching=new InputOutputMatching(ontologyManager);
		Collection<OutputParam> outputParams = ontologyManager.getOutputs();
		buildHierarchyInfo(outputParams);
		buildServicesChain();
		outCount = 0;
		
	}

	private void buildServicesChain() {
		outCount = 0;

		// Collection<OutputParam> outputParams = ontologyManager.getOutputMatching(output);
		for (OutputParam outputParam : table.keySet()) {
			outCount++;

			if (outputParam == null)
				continue;
			System.out.println(outCount + "-------" + outputParam.getOwlIndividual().getIRI().getFragment());

			fillPath(outputParam);
		}

	}

	private void buildHierarchyInfo(Collection<OutputParam> outputParams) {		
		for (OutputParam outputParam : outputParams) {
			List<HierarchyInfo> hierarchyInfos = new ArrayList<>();
			outCount++;
			table.put(outputParam, hierarchyInfos);
			System.out.println(outCount + "------------------------------------------------"
					+ outputParam.getOwlIndividual().getIRI().getFragment());
			Collection<? extends MethodCall> methodCalls = outputParam.getIsOutputTo();

			for (MethodCall methodCall : methodCalls) {

				HierarchyInfo hierarchyInfo = new HierarchyInfo();
				hierarchyInfos.add(hierarchyInfo);
				hierarchyInfo.setMethodCall(methodCall);

				System.out.println("--methodCall " + methodCall.getOwlIndividual().getIRI().getFragment());

				Collection<? extends InputParam> inputParams = methodCall.getHasInput();
				for (InputParam inputParam : inputParams) {
					System.out.println("-->inputParam: " + inputParam.getOwlIndividual().getIRI().getFragment());

					TreeSet<OutputParam> list = hierarchyInfo.getMap().get(inputParam);
					if (list == null)
						list = new TreeSet<>();

					Collection<OutputParam> outputParams2 = matching.getOutputMatching(inputParam, ontologyManager.getModel());

					for (OutputParam outputParam2 : outputParams2) {
						list.add(outputParam2);
						System.out
								.println("--->outputParam2: " + outputParam2.getOwlIndividual().getIRI().getFragment());
					}

					hierarchyInfo.getMap().put(inputParam, list);
				}
			}

		}

	}

	private void fillPath(OutputParam outputParam) {
		if (outputParam == null)
			return;

		List<HierarchyInfo> hierarchyInfos = table.get(outputParam);

		if (hierarchyInfos == null || hierarchyInfos.size() == 0)
			return;

		for (HierarchyInfo hierarchyInfo : hierarchyInfos) {
			Counter tour = new Counter();
			if (hierarchyInfo.getMethodCall().getOwlIndividual().getIRI().getFragment().equals("dayWeather"))
				System.out.println("-----------------------");

			List<List<InputParam>> list = combinations(hierarchyInfo.getMap().keySet());
			for (List<InputParam> list2 : list) {
				NodeService newNodeService = new NodeService();
				newNodeService.setOutputParam(outputParam);
				newNodeService.setMethodCall(hierarchyInfo.getMethodCall());

				TreeSet<InputParam> inputParamsTemp = buildInputChain(hierarchyInfo, newNodeService, list2);
				if (inputParamsTemp == null)
					continue;
				if (hierarchyInfo.getInputsPaths().get(inputParamsTemp) == null) {
					hierarchyInfo.getInputsPaths().put(inputParamsTemp, newNodeService);
					System.out.println(tour + "-- add new path: " + inputParamsTemp);
					System.out.println(tour + "-- path: " + newNodeService);
				}
			}

		}
	}

	TreeSet<InputParam> buildInputChain(HierarchyInfo hierarchyInfo, NodeService nodeService,
			List<InputParam> toReplace) {

		TreeSet<InputParam> inputParams = new TreeSet<InputParam>();

		for (Entry<InputParam, TreeSet<OutputParam>> inOut : hierarchyInfo.getMap().entrySet()) {
			NodeInput nodeInput = new NodeInput();
			nodeInput.setInputParam(inOut.getKey());

			nodeService.addInputs(nodeInput);

			if (!toReplace.contains(inOut.getKey())) {
				inputParams.add(inOut.getKey());
				// System.out.println("inOut.getKey():" + inOut.getKey());
			} else {

				// for (OutputParam outputParam : inOut.getValue()) {
				if (inOut.getValue() == null || inOut.getValue().size() == 0) {
					inputParams.add(inOut.getKey());
					continue;
				}
				OutputParam outputParam = inOut.getValue().iterator().next();
				nodeInput.setOutputParam(outputParam);
				List<HierarchyInfo> hierarchyInfos = table.get(outputParam);
				if (hierarchyInfos == null || hierarchyInfos.size() == 0) {
					inputParams.add(inOut.getKey());
					continue;
				}
				// for (HierarchyInfo hierarchyInfo2 : hierarchyInfos) {
				HierarchyInfo hierarchyInfo2 = hierarchyInfos.get(0);
				List<List<InputParam>> list = combinations(hierarchyInfo2.getMap().keySet());
				// for (List<InputParam> list2 : list) {
				List<InputParam> list2 = list.get(0);
				NodeService newNodeService = new NodeService();
				newNodeService.setOutputParam(outputParam);
				newNodeService.setMethodCall(hierarchyInfo2.getMethodCall());
				nodeInput.setChiledNodeService(newNodeService);
				newNodeService.setParentNode(nodeInput);
				inputParams.addAll(buildInputChain(hierarchyInfo2, newNodeService, list2));

				// }

				// }
				// }

			}

		}

		return inputParams;
	}
	
	List<List<InputParam>> combinations(Set<InputParam> set) {
		List<InputParam> t = new ArrayList<>(set);

		InputParam[] arr = new InputParam[t.size()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = t.get(i);
		}

		List<List<InputParam>> list = new ArrayList<List<InputParam>>();
		for (int i = 0; i <= arr.length; i++) {
			combinations2(arr, i, 0, new InputParam[i], list);
		}

		return list;

	}

	void combinations2(InputParam[] arr, int len, int startPosition, InputParam[] result, List<List<InputParam>> list) {
		if (len == 0) {
			// System.out.println(Arrays.toString(result));
			List<InputParam> newStrs = new ArrayList<InputParam>(Arrays.asList(result));
			list.add(newStrs);
			return;
		}
		for (int i = startPosition; i <= arr.length - len; i++) {
			// System.out.println(result.length - len + " " + arr[i]);
			result[result.length - len] = arr[i];
			combinations2(arr, len - 1, i + 1, result, list);
		}
	}

	public OntologyManager getOntologyManager() {
		return ontologyManager;
	}

	public Hashtable<OutputParam, List<HierarchyInfo>> getTable() {
		return table;
	}

	public InputOutputMatching getMatching() {
		return matching;
	}

	
	
}

class Counter {
	int tour = -1;
	int outNb = 0;
	int fcNb = 0;

	public Counter() {
		tour = -1;
	}

	public void addTour() {
		tour++;
	}

	public void addOutNb() {
		outNb++;
	}

	public void addFcNb() {
		fcNb++;
	}

	@Override
	public String toString() {

		return String.valueOf(tour) + String.valueOf(outNb) + String.valueOf(fcNb);
	}

}