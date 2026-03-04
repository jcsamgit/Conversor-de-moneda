package com.githubjcsam.conversor.modelo;

public enum Moneda {

    USD ("USD"),
    ARS ("ARS"),
    BRL ("BRL"),
    COP ("COP");

    private final String codigo;

    Moneda(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo(){
        return codigo;
    }
}
