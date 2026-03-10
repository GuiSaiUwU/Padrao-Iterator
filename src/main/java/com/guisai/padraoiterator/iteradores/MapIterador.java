package com.guisai.padraoiterator.iteradores;

import com.guisai.padraoiterator.model.Piloto;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MapIterador implements Iterator {
    private Map<Integer, Piloto> pilotos = new HashMap<>();
    private Integer indice = 0;

    public MapIterador(List<String> linhas) {
        linhas.forEach(l -> {
            String[] dados = l.split(",");
            adicionarPiloto(new Piloto(Integer.parseInt(dados[0]), dados[1], dados[2], Integer.parseInt(dados[3]), dados[4], dados[5], Integer.parseInt(dados[6])));
        });
    }

    @Override
    public Piloto next() {
        indice++;
        return pilotos.get(indice);
    }

    @Override
    public boolean hasNext() {
        return pilotos.containsKey(indice);
    }

    private void adicionarPiloto(Piloto piloto) {
        pilotos.put(pilotos.size(), piloto);
    }
}
