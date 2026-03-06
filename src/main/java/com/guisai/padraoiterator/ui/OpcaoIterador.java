package com.guisai.padraoiterator.ui;

public enum OpcaoIterador {
    DEQUE("Deque"),
    FILA("Fila"),
    PILHA("Pilha"),
    MAP("HashMap"),
    SET("HashSet");

    private final String str;
    OpcaoIterador(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    @Override
    public String toString() {
        return str;
    }
}
