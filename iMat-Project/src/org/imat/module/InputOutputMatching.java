package org.imat.module;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.imat.dbpedia.DBPediaType;
import org.imat.ontology.OntologyManager;
import org.imat.tree.NodeInput;
import org.imat.utile.owl.InputParam;
import org.imat.utile.owl.Noun;
import org.imat.utile.owl.OutputParam;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.RDFNode;

public class InputOutputMatching {
	public InputOutputMatching(OntologyManager ontologyManager) {
		this.ontologyManager =ontologyManager;
	}
	private OntologyManager ontologyManager;
	
	public Collection<OutputParam> getOutputMatching(InputParam inputParam, OntModel model) {

		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
				+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>" 
				+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
				+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
				+ "PREFIX mat: <http://www.semanticweb.org/rami#>" 
				+ "SELECT DISTINCT ?OutParam " 
				+ "WHERE{"
				+ "	?OutParam rdf:type mat:OutputParam ." 
				+ "?OutParam mat:isEquivalent ?outNoun ."
				+ "{?outNoun mat:isTypeOf* ?noun}" 
				+ "UNION{?outNoun (mat:hasSynonym|^mat:hasSynonym)* ?noun} ."
				+ "?noun (mat:hasSynonym|^mat:hasSynonym)* ?inNoun  ." 
				+ "?inParam mat:isEquivalent ?inNoun  ."
				+ "?inParam rdfs:Individual* mat:" + inputParam.getOwlIndividual().getIRI().getFragment() + " .}";

		Query query = QueryFactory.create(queryString);
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		com.hp.hpl.jena.query.ResultSet results = qe.execSelect();
		Set<OutputParam> res = new HashSet<OutputParam>();		
		while (results.hasNext()) {
			QuerySolution sol = (QuerySolution) results.next();
			RDFNode node = sol.get("OutParam");
			String word = node.toString();
			word = word.substring(word.lastIndexOf("#") + 1, word.length());

			OutputParam outputParam =ontologyManager.getFactory().getOutputParam(OntologyManager.iri + word);
			res.add(outputParam);
		}
		qe.close();

		return res;
	}
	
	public TreeSet<NodeInput> getInputMatching(List<DBPediaType> nouns, OntModel model) {
		TreeSet<NodeInput> res = new TreeSet<NodeInput>();
		for (DBPediaType noun : nouns) {
			try {

				String paramNoun = noun.getName();
				
				String queryString =  "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
						+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
						+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
						+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
						+ "PREFIX mat: <http://www.semanticweb.org/rami#>\n" 
						+ "SELECT DISTINCT ?InParam \n" 
						+ "WHERE{\n"
						+ "?InParam rdf:type mat:InputParam ." 
						+ "{?InParam mat:isEquivalent ?noun.\n}"
						+ "{ ?noun mat:isTypeOf*  ?parameterNoun  .\n}"
						+ "UNION { ?parameterNoun  mat:isTypeOf* ?noun .\n}"
						+ "UNION{?noun (mat:hasSynonym|^mat:hasSynonym)* ?parameterNoun.\n} "
						+ " .}";			
					
				queryString = queryString.replace("?parameterNoun", "mat:" + paramNoun);
				//System.out.println(queryString);
				Query query = QueryFactory.create(queryString);
				//System.out.println(query);
				QueryExecution qe = QueryExecutionFactory.create(query, model);
				ResultSet results = qe.execSelect();
				System.out.println("noun: " + paramNoun);
				// ResultSetFormatter.out(System.out, results, query);
				while (results.hasNext()) {
					QuerySolution sol = (QuerySolution) results.next();
					RDFNode node = sol.get("InParam");					
					// System.out.println(node);
					String word = node.toString();
					//word = word.substring(word.lastIndexOf("#") + 1, word.length());
					//System.out.println("---match:" + word);
					InputParam inputParam = ontologyManager.getFactory().getInputParam(word.toString());
					NodeInput nodeInput = getNodeInput(nouns, inputParam);
					res.add(nodeInput);
				}
				//qe.close();
			} catch (Exception e) {
				System.out.println(e);
			}

		}
		System.out.println("input parameter list: " + res);
		return res;
	}

	private NodeInput getNodeInput(List<DBPediaType> nouns, InputParam inputParam) {
		Collection<? extends Noun> equivalentInputNoun = inputParam.getIsEquivalent();
		int subTypeCount = Integer.MAX_VALUE;
		for (Noun noun2 : equivalentInputNoun) {
			DBPediaType dbPediaType = new DBPediaType(noun2.getOwlIndividual().getIRI().getFragment(), 1);
			int index = nouns.indexOf(dbPediaType);
			if(index>=0)
				if(subTypeCount > nouns.get(index).getSubTypeCount())
					subTypeCount=nouns.get(index).getSubTypeCount();							
		}
		NodeInput nodeInput = new NodeInput(inputParam, subTypeCount);
		return nodeInput;
	}
	
	
	public TreeSet<OutputParam> getOutputMatching(String noun, OntModel model) {
		TreeSet<OutputParam> res = new TreeSet<OutputParam>();
			try {
				String paramNoun = noun.trim().replace(" ", "_");
				String queryString =  "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
						+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
						+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
						+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
						+ "PREFIX mat: <http://www.semanticweb.org/rami#>\n" 
						+ "SELECT DISTINCT ?OutParam " 
						+ "WHERE{\n"
						+ "?OutParam rdf:type mat:OutputParam ." 
						+ "?OutParam mat:isEquivalent ?noun.\n"
						+ "{ ?noun mat:isTypeOf*  ?parameterNoun  .}"
						+ "UNION { ?parameterNoun  mat:isTypeOf* ?noun .}"
						+ "UNION{?noun (mat:hasSynonym|^mat:hasSynonym)* ?parameterNoun.} "
						+ " .}";

										
					
				queryString = queryString.replace("?parameterNoun", "mat:" + paramNoun);
				//System.out.println(queryString);
				Query query = QueryFactory.create(queryString);
				//System.out.println(query);
				QueryExecution qe = QueryExecutionFactory.create(query, model);
				ResultSet results = qe.execSelect();

				// ResultSetFormatter.out(System.out, results, query);
				while (results.hasNext()) {
					QuerySolution sol = (QuerySolution) results.next();
					RDFNode node = sol.get("OutParam");					
					// System.out.println(node);
					String word = node.toString();
					word = word.substring(word.lastIndexOf("#") + 1, word.length());

					OutputParam outputParam = ontologyManager.getFactory().getOutputParam(OntologyManager.iri + word);
					res.add(outputParam);
				}
				qe.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		
		System.out.println(res);
		return res;
	}
	
	public TreeSet<OutputParam> getOutputMatching(Collection<String> nouns, OntModel model) {
		TreeSet<OutputParam> res = new TreeSet<OutputParam>();
		for (String noun : nouns) {
			
			res.addAll(getOutputMatching(noun,  model));
			
		}
		System.out.println(res);
		return res;
	}

}
