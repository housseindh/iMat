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
 * Source Class: DefaultService <br>
 * @version generated on Mon Apr 27 04:17:47 EEST 2015 by lenovo
 */
public class DefaultService extends WrappedIndividualImpl implements Service {

    public DefaultService(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
    }





    /* ***************************************************
     * Object Property http://www.semanticweb.org/rami#hasResource
     */
     
    public Collection<? extends Resource> getHasResource() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_HASRESOURCE,
                                               DefaultResource.class);
    }

    public boolean hasHasResource() {
	   return !getHasResource().isEmpty();
    }

    public void addHasResource(Resource newHasResource) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_HASRESOURCE,
                                       newHasResource);
    }

    public void removeHasResource(Resource oldHasResource) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_HASRESOURCE,
                                          oldHasResource);
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
