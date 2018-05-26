package org.imat.utile.owl.impl;

import org.imat.utile.owl.*;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;
import org.protege.owl.codegeneration.impl.WrappedIndividualImpl;

import org.protege.owl.codegeneration.inference.CodeGenerationInference;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;


/**
 * Generated by Protege (http://protege.stanford.edu).<br>
 * Source Class: DefaultMethodCall <br>
 * @version generated on Mon Apr 27 04:17:47 EEST 2015 by lenovo
 */
public class DefaultMethodCall extends WrappedIndividualImpl implements MethodCall {

    public DefaultMethodCall(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
    }





    /* ***************************************************
     * Object Property http://www.semanticweb.org/rami#hasInput
     */
     
    public Collection<? extends InputParam> getHasInput() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_HASINPUT,
                                               DefaultInputParam.class);
    }

    public boolean hasHasInput() {
	   return !getHasInput().isEmpty();
    }

    public void addHasInput(InputParam newHasInput) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_HASINPUT,
                                       newHasInput);
    }

    public void removeHasInput(InputParam oldHasInput) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_HASINPUT,
                                          oldHasInput);
    }


    /* ***************************************************
     * Object Property http://www.semanticweb.org/rami#hasOutput
     */
     
    public Collection<? extends OutputParam> getHasOutput() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_HASOUTPUT,
                                               DefaultOutputParam.class);
    }

    public boolean hasHasOutput() {
	   return !getHasOutput().isEmpty();
    }

    public void addHasOutput(OutputParam newHasOutput) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_HASOUTPUT,
                                       newHasOutput);
    }

    public void removeHasOutput(OutputParam oldHasOutput) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_HASOUTPUT,
                                          oldHasOutput);
    }


    /* ***************************************************
     * Object Property http://www.semanticweb.org/rami#isPartOfResource
     */
     
    public Collection<? extends Resource> getIsPartOfResource() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_ISPARTOFRESOURCE,
                                               DefaultResource.class);
    }

    public boolean hasIsPartOfResource() {
	   return !getIsPartOfResource().isEmpty();
    }

    public void addIsPartOfResource(Resource newIsPartOfResource) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_ISPARTOFRESOURCE,
                                       newIsPartOfResource);
    }

    public void removeIsPartOfResource(Resource oldIsPartOfResource) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_ISPARTOFRESOURCE,
                                          oldIsPartOfResource);
    }


    /* ***************************************************
     * Data Property http://www.semanticweb.org/rami#Label
     */
     
    public Collection<? extends Object> getLabel() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_LABEL, Object.class);
    }

    public boolean hasLabel() {
		return !getLabel().isEmpty();
    }

    public void addLabel(Object newLabel) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_LABEL, newLabel);
    }

    public void removeLabel(Object oldLabel) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_LABEL, oldLabel);
    }


}
