
package org.imat.service;


public enum Max_pages {

    V_1("1"),
    V_2("2"),
    V_3("3"),
    V_4("4"),
    V_5("5");
    private String stringVal;

    private Max_pages(String v) {
        stringVal = v;
    }

    public String toString() {
        return stringVal;
    }

}
