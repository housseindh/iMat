package org.imat.ontology;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.protege.owl.codegeneration.inference.ReasonerBasedInference;
import org.semanticweb.HermiT.Reasoner;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;

import edu.smu.tspell.wordnet.NounSynset;
import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.WordNetDatabase;

import org.imat.utile.owl.*;

public class OntologyManager {
	private Collection<InputParam> inputs;
	private Collection<OutputParam> outputs;
	private OWLOntologyManager manager;
	private OWLFactory factory;
	private OntModel model;
	public static final String iri="http://www.semanticweb.org/rami#";
	public static final String mainPath="C:\\Users\\Rami\\git\\imat\\iMat-Project\\src";
	//public static final String mainPath="D:\\Java\\Eclipse IDE\\microservices\\iMat-Project\\src";
	public static final String path= mainPath + "\\owl\\Services-rdf.owl";
	WordNetDatabase database ;
	
	@SuppressWarnings("unchecked")
	public OntologyManager(){
		database = WordNetDatabase.getFileInstance();
		manager=OWLManager.createOWLOntologyManager();
		System.out.println(path);
		File file = new File(path);
		OWLOntology ontology;
		try {
			ontology = manager.loadOntologyFromOntologyDocument(file);
			OWLReasoner res=new Reasoner(ontology);
			
			CodeGenerationInference inf=new ReasonerBasedInference(ontology, res);
			
			factory=new OWLFactory(ontology,inf);
			inputs=(Collection<InputParam>) factory.getAllInputParamInstances();
			outputs= (Collection<OutputParam>) factory.getAllOutputParamInstances();
		} catch (OWLOntologyCreationException e) {			
			e.printStackTrace();
		}
		
	}
	public void addSysnonyms(Collection<String> wordform){
		Iterator<String> iterator = wordform.iterator();
		Noun no=factory.createNoun(iri+iterator.next().replace(" ","_"));
		while (iterator.hasNext()) {
			 no.addHasSynonym(factory.createNoun(iri+ iterator.next().replace(" ","_")));
		} 
	  	
	}
	
	public void addNoun(String noun,boolean save){
		try {
			//System.out.println("ont.addNoun: " + noun );
		Synset[] synsets = database.getSynsets(noun, SynsetType.NOUN);
		//  Display the word forms and definitions for synsets retrieved
		if(synsets.length>0){
	
			for(int i=0;i<synsets.length;i++){
			NounSynset n=((NounSynset)synsets[i]);
			this.traite(null, n);
			}
			
		}
		else{
			factory.createNoun(iri+noun.replace(" ","_"));
		}
			if(save) factory.saveOwlOntology();
			factory.flushOwlReasoner();
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	private Noun addSysnonyms(NounSynset n){
		String[] wordform=n.getWordForms();
	  	Noun no=factory.createNoun(iri+wordform[0].replace(" ","_"));
	  	for(int i=1;i<wordform.length;i++){
		  no.addHasSynonym(factory.createNoun(iri+wordform[i].replace(" ","_")));
		  //System.out.println("add: " + iri+wordform[i].replace(" ","_"));
	  	}
	  	return no;
	}
		
	private void traite(Noun c,NounSynset n){
		Noun no=this.addSysnonyms(n);
	  	if(c!=null) c.addIsTypeOf(no);
	  	NounSynset[] synsets=n.getHypernyms();
	  	for(int i=0;i<synsets.length;i++){
	  		 traite(no,synsets[i]);
	  	}
	}

	public static String getName(String s){
		String []s1=s.split("#");
		String []s2=s1[1].split(">");
		return s2[0];
	}

	public Collection<InputParam> getInputs() {
		return inputs;
	}

	public Collection<OutputParam> getOutputs() {
		return outputs;
	}

	public OWLOntologyManager getManager() {
		return manager;
	}

	public void setManager(OWLOntologyManager manager) {
		this.manager = manager;
	}

	public OWLFactory getFactory() {
		return factory;
	}

	public void setFactory(OWLFactory factory) {
		this.factory = factory;
	}

	
	public OntModel getModel() {
		if(model == null) reloadModel();
		return model;
	}

	public void setModel(OntModel model) {
		this.model = model;
	}

	public  OntModel reloadModel() {
		
		model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MICRO_RULE_INF);

		InputStream in = FileManager.get().open(OntologyManager.path);
		if (in == null) {
			throw new IllegalArgumentException("File: " + OntologyManager.path + " not found");
		}
		model.read(in, "TURTLE");
		return model;
	}


}
