package com.guisai.padraoiterator.iteradores;

import com.guisai.padraoiterator.model.Piloto;

import java.util.Stack;

public class PilhaIterador implements Iterador{
    private Stack<Piloto> pilotos = new Stack<>();
    private Stack<Piloto> pilotosReserva = new Stack<>();

    @Override
    public void primeiro() {
        while (!pilotosReserva.isEmpty()) {
            pilotos.push(pilotosReserva.pop());
        }
    }

    @Override
    public void proximo() {
        pilotosReserva.push(pilotos.pop());
    }

    @Override
    public boolean temProximo() {
        return !pilotos.isEmpty();
    }

    @Override
    public Piloto itemAtual() {
        return pilotos.peek();
    }

    @Override
    public void adicionarPiloto(Piloto piloto) {
        pilotos.push(piloto);
    }
}
