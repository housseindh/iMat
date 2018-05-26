package org.imat.utile.owl;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: Resource <br>
 * @version generated on Mon Apr 27 04:17:47 EEST 2015 by lenovo
 */

public interface Resource extends WrappedIndividual {

    /* ***************************************************
     * Property http://www.semanticweb.org/rami#hasMethodCall
     */
     
    /**
     * Gets all property values for the hasMethodCall property.<p>
     * 
     * @returns a collection of values for the hasMethodCall property.
     */
    Collection<? extends MethodCall> getHasMethodCall();

    /**
     * Checks if the class has a hasMethodCall property value.<p>
     * 
     * @return true if there is a hasMethodCall property value.
     */
    boolean hasHasMethodCall();

    /**
     * Adds a hasMethodCall property value.<p>
     * 
     * @param newHasMethodCall the hasMethodCall property value to be added
     */
    void addHasMethodCall(MethodCall newHasMethodCall);

    /**
     * Removes a hasMethodCall property value.<p>
     * 
     * @param oldHasMethodCall the hasMethodCall property value to be removed.
     */
    void removeHasMethodCall(MethodCall oldHasMethodCall);


    /* ***************************************************
     * Property http://www.semanticweb.org/rami#isPartOfService
     */
     
    /**
     * Gets all property values for the isPartOfService property.<p>
     * 
     * @returns a collection of values for the isPartOfService property.
     */
    Collection<? extends Service> getIsPartOfService();

    /**
     * Checks if the class has a isPartOfService property value.<p>
     * 
     * @return true if there is a isPartOfService property value.
     */
    boolean hasIsPartOfService();

    /**
     * Adds a isPartOfService property value.<p>
     * 
     * @param newIsPartOfService the isPartOfService property value to be added
     */
    void addIsPartOfService(Service newIsPartOfService);

    /**
     * Removes a isPartOfService property value.<p>
     * 
     * @param oldIsPartOfService the isPartOfService property value to be removed.
     */
    void removeIsPartOfService(Service oldIsPartOfService);


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
