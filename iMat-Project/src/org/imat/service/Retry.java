
package org.imat.service;


public enum Retry {

    V_0("0"),
    V_1("1"),
    V_2("2"),
    V_3("3"),
    V_4("4");
    private String stringVal;

    private Retry(String v) {
        stringVal = v;
    }

    public String toString() {
        return stringVal;
    }

}
