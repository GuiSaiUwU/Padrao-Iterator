package com.guisai.padraoiterator.iteradores;

import com.guisai.padraoiterator.model.Piloto;

public interface Iterador {
    void primeiro();
    void proximo();

    boolean temProximo();
    Piloto itemAtual();

    void adicionarPiloto(Piloto piloto);
}
