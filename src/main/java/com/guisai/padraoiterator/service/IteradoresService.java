package com.guisai.padraoiterator.service;

import com.guisai.padraoiterator.iteradores.*;
import com.guisai.padraoiterator.model.Piloto;
import com.guisai.padraoiterator.ui.OpcaoIterador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class IteradoresService {
    private static List<String> linhas;

    public void carregarLinhas() throws FileNotFoundException {
        String arquivoNome = "./src/dados/DadosDosPilotosF1.csv";
        FileReader fr = new FileReader(arquivoNome);
        BufferedReader br  = new BufferedReader(fr);
        linhas = br.lines().toList();
    }

    public ObservableList<Piloto> carregarDados(OpcaoIterador opcao) {
        Iterador iterador = switch (opcao) {
            case DEQUE -> new DequeIterador();
            case FILA -> new FilaIterador();
            case MAP -> new MapIterador();
            case PILHA -> new PilhaIterador();
            case SET -> new SetIterador();
        };

        for (String linha : linhas) {
            String[] dados = linha.split(",");
            iterador.adicionarPiloto(new Piloto(Integer.parseInt(dados[0]), dados[1], dados[2], Integer.parseInt(dados[3]), dados[4], dados[5], Integer.parseInt(dados[6])));
        }

        ObservableList<Piloto> resultado = FXCollections.observableArrayList();
        while (iterador.temProximo()) {
            resultado.add(iterador.itemAtual());
            iterador.proximo();
        }

        return resultado;
    }
}
