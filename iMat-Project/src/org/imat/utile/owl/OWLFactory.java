package org.imat.utile.owl;

import java.util.Collection;

import org.imat.utile.owl.impl.*;
import org.protege.owl.codegeneration.CodeGenerationFactory;
import org.protege.owl.codegeneration.WrappedIndividual;
import org.protege.owl.codegeneration.impl.FactoryHelper;
import org.protege.owl.codegeneration.impl.ProtegeJavaMapping;
import org.protege.owl.codegeneration.impl.WrappedIndividualImpl;
import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.protege.owl.codegeneration.inference.SimpleInference;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

public class OWLFactory implements CodeGenerationFactory {
    private OWLOntology ontology;
    private ProtegeJavaMapping javaMapping = new ProtegeJavaMapping();
    private FactoryHelper delegate;
    private CodeGenerationInference inference;

    public OWLFactory(OWLOntology ontology) {
	    this(ontology, new SimpleInference(ontology));
    }
    
    public OWLFactory(OWLOntology ontology, CodeGenerationInference inference) {
        this.ontology = ontology;
        this.inference = inference;
        javaMapping.initialize(ontology, inference);
        delegate = new FactoryHelper(ontology, inference);
    }

    public OWLOntology getOwlOntology() {
        return ontology;
    }
    
    public void saveOwlOntology() throws OWLOntologyStorageException {
        ontology.getOWLOntologyManager().saveOntology(ontology);
    }
    
    public void flushOwlReasoner() {
        delegate.flushOwlReasoner();
    }
    
    public boolean canAs(WrappedIndividual resource, Class<? extends WrappedIndividual> javaInterface) {
    	return javaMapping.canAs(resource, javaInterface);
    }
    
    public  <X extends WrappedIndividual> X as(WrappedIndividual resource, Class<? extends X> javaInterface) {
    	return javaMapping.as(resource, javaInterface);
    }
    
    public Class<?> getJavaInterfaceFromOwlClass(OWLClass cls) {
        return javaMapping.getJavaInterfaceFromOwlClass(cls);
    }
    
    public OWLClass getOwlClassFromJavaInterface(Class<?> javaInterface) {
	    return javaMapping.getOwlClassFromJavaInterface(javaInterface);
    }
    
    public CodeGenerationInference getInference() {
        return inference;
    }

    /* ***************************************************
     * Class http://www.semanticweb.org/rami#InputParam
     */

    {
        javaMapping.add("http://www.semanticweb.org/rami#InputParam", InputParam.class, DefaultInputParam.class);
    }

    /**
     * Creates an instance of type InputParam.  Modifies the underlying ontology.
     */
    public InputParam createInputParam(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_INPUTPARAM, DefaultInputParam.class);
    }

    /**
     * Gets an instance of type InputParam with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public InputParam getInputParam(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_INPUTPARAM, DefaultInputParam.class);
    }

    /**
     * Gets all instances of InputParam from the ontology.
     */
    public Collection<? extends InputParam> getAllInputParamInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_INPUTPARAM, DefaultInputParam.class);
    }


    /* ***************************************************
     * Class http://www.semanticweb.org/rami#MethodCall
     */

    {
        javaMapping.add("http://www.semanticweb.org/rami#MethodCall", MethodCall.class, DefaultMethodCall.class);
    }

    /**
     * Creates an instance of type MethodCall.  Modifies the underlying ontology.
     */
    public MethodCall createMethodCall(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_METHODCALL, DefaultMethodCall.class);
    }

    /**
     * Gets an instance of type MethodCall with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public MethodCall getMethodCall(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_METHODCALL, DefaultMethodCall.class);
    }

    /**
     * Gets all instances of MethodCall from the ontology.
     */
    public Collection<? extends MethodCall> getAllMethodCallInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_METHODCALL, DefaultMethodCall.class);
    }


    /* ***************************************************
     * Class http://www.semanticweb.org/rami#Noun
     */

    {
        javaMapping.add("http://www.semanticweb.org/rami#Noun", Noun.class, DefaultNoun.class);
    }

    /**
     * Creates an instance of type Noun.  Modifies the underlying ontology.
     */
    public Noun createNoun(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_NOUN, DefaultNoun.class);
    }

    /**
     * Gets an instance of type Noun with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Noun getNoun(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_NOUN, DefaultNoun.class);
    }

    /**
     * Gets all instances of Noun from the ontology.
     */
    public Collection<? extends Noun> getAllNounInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_NOUN, DefaultNoun.class);
    }


    /* ***************************************************
     * Class http://www.semanticweb.org/rami#OutputParam
     */

    {
        javaMapping.add("http://www.semanticweb.org/rami#OutputParam", OutputParam.class, DefaultOutputParam.class);
    }

    /**
     * Creates an instance of type OutputParam.  Modifies the underlying ontology.
     */
    public OutputParam createOutputParam(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_OUTPUTPARAM, DefaultOutputParam.class);
    }

    /**
     * Gets an instance of type OutputParam with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public OutputParam getOutputParam(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_OUTPUTPARAM, DefaultOutputParam.class);
    }

    /**
     * Gets all instances of OutputParam from the ontology.
     */
    public Collection<? extends OutputParam> getAllOutputParamInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_OUTPUTPARAM, DefaultOutputParam.class);
    }


    /* ***************************************************
     * Class http://www.semanticweb.org/rami#Parameter
     */

    {
        javaMapping.add("http://www.semanticweb.org/rami#Parameter", Parameter.class, DefaultParameter.class);
    }

    /**
     * Creates an instance of type Parameter.  Modifies the underlying ontology.
     */
    public Parameter createParameter(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_PARAMETER, DefaultParameter.class);
    }

    /**
     * Gets an instance of type Parameter with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Parameter getParameter(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_PARAMETER, DefaultParameter.class);
    }

    /**
     * Gets all instances of Parameter from the ontology.
     */
    public Collection<? extends Parameter> getAllParameterInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_PARAMETER, DefaultParameter.class);
    }


    /* ***************************************************
     * Class http://www.semanticweb.org/rami#Resource
     */

    {
        javaMapping.add("http://www.semanticweb.org/rami#Resource", Resource.class, DefaultResource.class);
    }

    /**
     * Creates an instance of type Resource.  Modifies the underlying ontology.
     */
    public Resource createResource(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_RESOURCE, DefaultResource.class);
    }

    /**
     * Gets an instance of type Resource with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Resource getResource(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_RESOURCE, DefaultResource.class);
    }

    /**
     * Gets all instances of Resource from the ontology.
     */
    public Collection<? extends Resource> getAllResourceInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_RESOURCE, DefaultResource.class);
    }


    /* ***************************************************
     * Class http://www.semanticweb.org/rami#Service
     */

    {
        javaMapping.add("http://www.semanticweb.org/rami#Service", Service.class, DefaultService.class);
    }

    /**
     * Creates an instance of type Service.  Modifies the underlying ontology.
     */
    public Service createService(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_SERVICE, DefaultService.class);
    }

    /**
     * Gets an instance of type Service with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Service getService(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_SERVICE, DefaultService.class);
    }

    /**
     * Gets all instances of Service from the ontology.
     */
    public Collection<? extends Service> getAllServiceInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_SERVICE, DefaultService.class);
    }


}
