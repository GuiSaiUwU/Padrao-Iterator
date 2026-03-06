package com.guisai.padraoiterator.iteradores;

import com.guisai.padraoiterator.model.Piloto;

import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class DequeIterador implements Iterador {
    private Deque<Piloto> deque = new LinkedBlockingDeque<>();
    private int indice;

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
        return indice < deque.size();
    }

    @Override
    public Piloto itemAtual() {
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

    @Override
    public void adicionarPiloto(Piloto piloto) {
        deque.add(piloto);
    }
}