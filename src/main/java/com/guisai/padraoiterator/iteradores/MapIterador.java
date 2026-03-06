package com.guisai.padraoiterator.iteradores;

import com.guisai.padraoiterator.model.Piloto;

import java.util.HashMap;
import java.util.Map;

public class MapIterador implements Iterador {
    private Map<Integer, Piloto> pilotos = new HashMap<>();
    private Integer indice = 0;

    @Override
    public void primeiro() {
        indice = 0;
    }

    @Override
    public void proximo() {
        indice++;
    }

    @Override
    public boolean temProximo() {
        return pilotos.containsKey(indice);
    }

    @Override
    public Piloto itemAtual() {
        return pilotos.get(indice);
    }

    @Override
    public void adicionarPiloto(Piloto piloto) {
        pilotos.put(pilotos.size(), piloto);
    }
}
