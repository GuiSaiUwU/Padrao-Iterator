package com.guisai.padraoiterator.iteradores;

import com.guisai.padraoiterator.model.Piloto;
import javafx.util.Pair;

import java.util.HashSet;

public class SetIterador implements Iterador {
    HashSet<Pair<Integer, Piloto>> pilotos = new HashSet<>();
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
        return pilotos.size() > indice;
    }

    @Override
    public Piloto itemAtual() {
        return pilotos.stream().filter(p -> p.getKey() == indice).findFirst().get().getValue();
    }

    @Override
    public void adicionarPiloto(Piloto piloto) {
        pilotos.add(new Pair<>(pilotos.size(), piloto));
    }
}
