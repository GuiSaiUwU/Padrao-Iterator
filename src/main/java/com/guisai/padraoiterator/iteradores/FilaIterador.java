package com.guisai.padraoiterator.iteradores;

import com.guisai.padraoiterator.model.Piloto;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class FilaIterador implements Iterador {
    Queue<Piloto> fila = new LinkedBlockingQueue<>();
    Queue<Piloto> filaReserva = new LinkedBlockingQueue<>();

    @Override
    public void primeiro() {
        while (!fila.isEmpty()) {
            filaReserva.add(fila.remove());
        }

        while (!filaReserva.isEmpty()) {
            fila.add(filaReserva.remove());
        }
    }

    @Override
    public void proximo() {
        filaReserva.add(fila.remove());
    }

    @Override
    public boolean temProximo() {
        return !fila.isEmpty();
    }

    @Override
    public Piloto itemAtual() {
        return fila.peek();
    }

    @Override
    public void adicionarPiloto(Piloto piloto) {
        fila.add(piloto);
    }
}
