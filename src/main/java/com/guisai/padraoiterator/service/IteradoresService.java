package com.guisai.padraoiterator.service;

import com.guisai.padraoiterator.iteradores.*;
import com.guisai.padraoiterator.model.Piloto;
import com.guisai.padraoiterator.ui.OpcaoIterador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
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
        Iterator<Piloto> iterador = switch (opcao) {
            case DEQUE -> new DequeIterador(linhas);
            case FILA -> new FilaIterador(linhas);
            case MAP -> new MapIterador(linhas);
            case PILHA -> new PilhaIterador(linhas);
            case SET -> new SetIterador(linhas);
        };

        ObservableList<Piloto> resultado = FXCollections.observableArrayList();
        while (iterador.hasNext()) {
            resultado.add(iterador.next());
        }

        return resultado;
    }
}
