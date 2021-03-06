package org.imat.utile.owl;

import java.io.Serializable;
import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: Parameter <br>
 * @version generated on Mon Apr 27 04:17:47 EEST 2015 by lenovo
 */

public interface Parameter extends WrappedIndividual ,Serializable{

    /* ***************************************************
     * Property http://www.semanticweb.org/rami#isEquivalent
     */
     
    /**
     * Gets all property values for the isEquivalent property.<p>
     * 
     * @returns a collection of values for the isEquivalent property.
     */
    Collection<? extends Noun> getIsEquivalent();

    /**
     * Checks if the class has a isEquivalent property value.<p>
     * 
     * @return true if there is a isEquivalent property value.
     */
    boolean hasIsEquivalent();

    /**
     * Adds a isEquivalent property value.<p>
     * 
     * @param newIsEquivalent the isEquivalent property value to be added
     */
    void addIsEquivalent(Noun newIsEquivalent);

    /**
     * Removes a isEquivalent property value.<p>
     * 
     * @param oldIsEquivalent the isEquivalent property value to be removed.
     */
    void removeIsEquivalent(Noun oldIsEquivalent);


    /* ***************************************************
     * Property http://www.semanticweb.org/rami#Label
     */
     
    /**
     * Gets all property values for the Label property.<p>
     * 
     * @returns a collection of values for the Label property.
     */
    Collection<? extends Object> getLabel();

    /**
     * Checks if the class has a Label property value.<p>
     * 
     * @return true if there is a Label property value.
     */
    boolean hasLabel();

    /**
     * Adds a Label property value.<p>
     * 
     * @param newLabel the Label property value to be added
     */
    void addLabel(Object newLabel);

    /**
     * Removes a Label property value.<p>
     * 
     * @param oldLabel the Label property value to be removed.
     */
    void removeLabel(Object oldLabel);



    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}
