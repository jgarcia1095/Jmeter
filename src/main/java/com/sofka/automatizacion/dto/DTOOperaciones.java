package com.sofka.automatizacion.dto;

public class DTOOperaciones {

    private String n1;
    private String n2;
    private String addResult;

    public DTOOperaciones(String n1, String n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public String getN1() {
        return n1;
    }

    public void setN1(String n1) {
        this.n1 = n1;
    }

    public String getN2() {
        return n2;
    }

    public void setN2(String n2) {
        this.n2 = n2;
    }

    public String getAddResult() {
        return addResult;
    }

    public void setAddResult(String addResult) {
        this.addResult = addResult;
    }
}
