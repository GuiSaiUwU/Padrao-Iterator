package com.guisai.padraoiterator.iteradores;

import com.guisai.padraoiterator.model.Piloto;

import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class DequeIterador implements Iterator {
    private Deque<Piloto> deque = new LinkedBlockingDeque<>();
    private int indice;

    @Override
    public Piloto next() {
        indice++;
        return itemAtual();
    }

    @Override
    public boolean hasNext() {
        return indice < deque.size();
    }

    private Piloto itemAtual() {
        int meio = deque.size() / 2;

        Iterator<Piloto> it;
        if (indice <= meio) {
            it = deque.iterator();
            for (int i = 0; i < indice; i++) {
                it.next();
            }
        } else {
            it = deque.descendingIterator();
            int posDoFim = deque.size() - 1 - indice;
            for (int i = 0; i < posDoFim; i++) {
                it.next();
            }
        }

        return it.next();
    }

    public DequeIterador(List<String> linhas) {
        linhas.forEach(l -> {
            String[] dados = l.split(",");
            adicionarPiloto(new Piloto(Integer.parseInt(dados[0]), dados[1], dados[2], Integer.parseInt(dados[3]), dados[4], dados[5], Integer.parseInt(dados[6])));
        });
    }

    private void adicionarPiloto(Piloto piloto) {
        deque.add(piloto);
    }
}