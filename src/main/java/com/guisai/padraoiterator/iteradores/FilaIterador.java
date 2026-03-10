package com.guisai.padraoiterator.iteradores;

import com.guisai.padraoiterator.model.Piloto;

import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class FilaIterador implements Iterator {
    Queue<Piloto> fila = new LinkedBlockingQueue<>();
    private Iterator<Piloto> it;

    public FilaIterador(List<String> linhas) {
        linhas.forEach(l -> {
            String[] dados = l.split(",");
            adicionarPiloto(new Piloto(Integer.parseInt(dados[0]), dados[1], dados[2], Integer.parseInt(dados[3]), dados[4], dados[5], Integer.parseInt(dados[6])));
        });

        it = fila.iterator();
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
        fila.add(piloto);
    }
}
