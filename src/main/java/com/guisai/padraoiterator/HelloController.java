package com.guisai.padraoiterator;

import com.guisai.padraoiterator.model.Piloto;
import com.guisai.padraoiterator.service.IteradoresService;
import com.guisai.padraoiterator.ui.OpcaoIterador;
import javafx.animation.PauseTransition;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Duration;

import java.io.FileNotFoundException;

public class HelloController {
    @FXML private TableView<Piloto> tabela;
    @FXML private TableColumn<Piloto, Integer> colunaMatricula;
    @FXML private TableColumn<Piloto, String> colunaNome;
    @FXML private TableColumn<Piloto, String> colunaPais;
    @FXML private TableColumn<Piloto, Integer> colunaIdade;
    @FXML private TableColumn<Piloto, String> colunaEquipe;
    @FXML private TableColumn<Piloto, String> colunaMotor;
    @FXML  private TableColumn<Piloto, Integer> colunaPontuacao;

    @FXML
    ComboBox<OpcaoIterador> opcoes;

    private static final IteradoresService service = new IteradoresService();

    @FXML
    private void initialize() {
        try {
            service.carregarLinhas();
        } catch (FileNotFoundException e) {
            System.out.println("Não foi possivel carregar os dados");
            e.printStackTrace();
            return;
        }

        carregarOpcoes();
        carregarFactories();
    }

    private void carregarOpcoes() {
        opcoes.getItems().addAll(OpcaoIterador.values());
        opcoes.getSelectionModel().selectFirst();
        opcoes.setDisable(false);
    }


    private void carregarFactories() {
        colunaNome.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>(p.getValue().getNome()));
        colunaPais.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>(p.getValue().getPaisOrigem()));
        colunaEquipe.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>(p.getValue().getEquipe()));
        colunaMotor.setCellValueFactory(p->
                new ReadOnlyObjectWrapper<>(p.getValue().getMotor()));

        // os Ints
        colunaMatricula.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>(p.getValue().getMatricula()));
        colunaIdade.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>(p.getValue().getIdade()));
        colunaPontuacao.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>(p.getValue().getPontuacao()));
    }

    public void onCarregarDados(ActionEvent actionEvent) {
        tabela.getItems().clear();

        PauseTransition pause = new PauseTransition(Duration.millis(750));
        pause.setOnFinished(event -> {
            ObservableList<Piloto> dados = service.carregarDados(opcoes.getValue());
            tabela.setItems(dados);
        });
        pause.playFromStart();
    }
}