package org.imat.main;

import java.util.Scanner;

import org.imat.module.OntologyChainAnalysis;
import org.imat.module.RequestAnalyzer;
import org.imat.ontology.OntologyManager;
import org.imat.wordnet.WordNet;

public class MainTest {

	public static void main(String[] args) throws Exception {
		OntologyChainAnalysis analysis = new OntologyChainAnalysis();
		analysis.init();
		RequestAnalyzer requestAnalyzer = new RequestAnalyzer(analysis.getOntologyManager(), analysis.getMatching());
		
	String input="new york weather on friday";
	
		
		//String input = "barack hussein obama new york  24/12/2015 8.1384683,38.4527887  weather  on friday";
		 
	do {
		requestAnalyzer.search(input, analysis.getTable());
		//System.out.println(net.getTypes(input));
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextLine())
		input =	sc.nextLine();
		
		
	} while (!input.equals(("")));
		
		
		
		
	}

}
