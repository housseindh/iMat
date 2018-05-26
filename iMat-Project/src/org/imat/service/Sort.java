package org.imat.service;



public enum Sort {

    MOST_ACTIVE("most-active"),
    PUBLICATION("publication"),
    MOST_CLICKED("most-clicked");
    private String stringVal;

    private Sort(String v) {
        stringVal = v;
    }

    public String toString() {
        return stringVal;
    }

}
