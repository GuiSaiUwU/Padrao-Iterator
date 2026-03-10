package com.guisai.padraoiterator.iteradores;

import com.guisai.padraoiterator.model.Piloto;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class PilhaIterador implements Iterator {
    private Stack<Piloto> pilotos = new Stack<>();
    private Iterator<Piloto> it;

    public PilhaIterador(List<String> linhas) {
        linhas.forEach(l -> {
            String[] dados = l.split(",");
            adicionarPiloto(new Piloto(Integer.parseInt(dados[0]), dados[1], dados[2], Integer.parseInt(dados[3]), dados[4], dados[5], Integer.parseInt(dados[6])));
        });

        it = pilotos.stream().iterator();
    }

    @Override
    public Piloto next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    private void adicionarPiloto(Piloto piloto) {
        pilotos.push(piloto);
    }
}
