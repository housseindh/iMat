package org.imat.dbpedia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

import org.imat.service.DBPedia;
import org.imat.service.DBPedia.Candidates;
import org.json.JSONArray;
import org.json.JSONObject;

import com.hp.hpl.jena.query.ParameterizedSparqlString;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFactory;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.ResourceFactory;

public class DBPediaManager {
	private Candidates can;

	public DBPediaManager() {
		can = DBPedia.candidates();
	}
	
	public ArrayList<DBPediaType> findTypes(String paramNoun) {
		//List<String> types = new ArrayList<String>();
		ArrayList<DBPediaType> types = new ArrayList<DBPediaType>();
		
		paramNoun=paramNoun.replace(" ", "_");
		
		/*ParameterizedSparqlString qs = new ParameterizedSparqlString("" + 
				"prefix rdfs:    <http://www.w3.org/2000/01/rdf-schema#>\n"
				+ "prefix dbpedia-owl: <http://dbpedia.org/ontology/>\n" 
				+ "prefix dbpprop: <http://dbpedia.org/property/>\n"
				+ "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" 
				+"SELECT ?type (COUNT(?subType) as ?subTypeCount) WHERE {\n"
				+"?subType rdf:type ?type.\n"
				+"{SELECT  ?type \n" 
				+ "WHERE { \n"
				+ " ?resource  rdfs:label ?label ;\n"
				+ " rdf:type ?type .\n"
				+ "FILTER ( lang(?label) = 'en') }"
				+"}}\n"
				+"GROUP BY ?type ?subTypeCount  ORDER BY ?subTypeCount\n");*/
		ParameterizedSparqlString qs = new ParameterizedSparqlString("" + 
				"prefix rdfs:    <http://www.w3.org/2000/01/rdf-schema#>\n"
				+"prefix dbr:    <http://dbpedia.org/resource/> \n" 
				+ "prefix dbpedia-owl: <http://dbpedia.org/ontology/>\n" 
				+ "prefix dbpprop: <http://dbpedia.org/property/>\n"
				+ "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" 
				+"SELECT ?type (COUNT(?subType) as ?subTypeCount) WHERE {\n"
				+"?subType rdf:type ?type.\n"
				+"{SELECT  ?type \n" 
				+"WHERE { \n"
				+"?parameterNoun rdf:type ?type. \n"
				+"} }   \n"
				+"} GROUP BY ?type ?subTypeCount ORDER BY ?type ?subTypeCount\n"
				);

		
		//Literal literal = ResourceFactory.createLangLiteral(input, "en");
		//qs.setParam("label", literal);
		String queryString = qs.asQuery().toString().replace("?parameterNoun", "dbr:" + paramNoun);
		//System.out.println(queryString);
		//Query query = QueryFactory.create(queryString);
		//System.out.println(query);
		//QueryExecution qe = QueryExecutionFactory.create(query, model);

		 //System.out.println(qs.asQuery());

		QueryExecution exec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", queryString);
		ResultSet results = ResultSetFactory.copyResults(exec.execSelect());
		DBPediaType dbPediaType = null;
		while (results.hasNext()) {
			QuerySolution sol = (QuerySolution) results.next();
			RDFNode node = sol.get("?type");
			String type = node.toString();
			if (!type.contains("dbpedia.org"))
				continue;
			// System.out.println(type);
			type = type.substring(type.lastIndexOf("/") + 1, type.length()).replaceAll("\\d+.*", "");
			String[] r = type.split("(?=\\p{Upper})");

			String newType = "";
			for (String string : r) {
				newType += string + " ";

			}
			node = sol.get("?subTypeCount");
			 Literal C_12_literal = ((Literal) sol.get("subTypeCount"));
		      int  subTypeCount = C_12_literal.getInt();
		        
			System.out.println(newType + "\t" + subTypeCount);
			//if(!subTypeCount.equals("")) count=Integer.valueOf(subTypeCount);
			dbPediaType = new DBPediaType(newType.trim().replace(" ", "_").toLowerCase(), subTypeCount);
			types.add(dbPediaType);

		}		exec.close();
		// ResultSetFormatter.out(results);
		return types;
	}

	/*public Collection<DBPediaEntity> getEntities(String input) {

		PriorityQueue<DBPediaEntity> array = new PriorityQueue<DBPediaEntity>(new DBPediaEntityComparator());
		String s = can.getAsJson(input + ".", null, 0.1, 200, null, null, null, null, null, null, String.class);

		// System.out.println(s);

		try {
			JSONObject o1 = new JSONObject(s);
			if (o1.has("Resources") == false)
				return array;
			Object o2 = o1.get("Resources");
			if (o2 instanceof JSONArray) {
				JSONArray arr = (JSONArray) o2;

				for (int i = 0; i < arr.length(); i++) {
					JSONObject obj = (JSONObject) arr.get(i);
					String from = obj.getString("@surfaceForm");

					DBPediaEntity db = new DBPediaEntity(obj.getString("@URI"), from);

					// System.out.println(jo.getString("@types"));
					if (obj.has("@types")) {
						if (!tokenize(obj.getString("@types")).get(0).equals(""))
							db.addType(tokenize(obj.getString("@types")));
					}

					if (obj.has("@support"))
						db.setSupport(Integer.parseInt(obj.getString("@support")));
					else
						db.setSupport(0);
					array.add(db);
				}

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		
		 * for(DBPediaEntity e:array){ System.out.println(e.getTypes()); }
		 
		return array;
	}*/

	public static ArrayList<String> tokenize(String s) {
		ArrayList<String> tokens = new ArrayList<String>();
		ArrayList<String> tmp = new ArrayList<String>();

		String[] t1 = s.split(",");
		for (int i = 0; i < t1.length; i++) {
			String[] t2 = t1[i].split(":");
			tokens.add(t2[t2.length - 1]);
		}
		for (int i = 0; i < tokens.size(); i++) {
			String[] t3 = tokens.get(i).split("/");
			String r = t3[t3.length - 1].replace("_", " ");
			String[] t4 = r.split("(?=\\p{Lu})");
			if (t4.length > 0) {
				r = t4[0];
				for (int j = 1; j < t4.length; j++) {
					r += " " + t4[j];
				}
			}
			tokens.set(i, r.toLowerCase());
		}

		for (String e : tokens) {
			if (!tmp.contains(e))
				tmp.add(e);

		}
		return tokens;

	}


}
