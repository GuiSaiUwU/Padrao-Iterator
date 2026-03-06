package com.guisai.padraoiterator.model;

public class Piloto {
    private Integer matricula;
    private String nome;
    private String paisOrigem;
    private Integer idade;
    private String equipe;
    private String motor;
    private Integer pontuacao;

    public Piloto() {}

    public Piloto(Integer matricula, String nome, String paisOrigem, Integer idade, String equipe, String motor, Integer pontuacao) {
        this.matricula = matricula;
        this.nome = nome;
        this.paisOrigem = paisOrigem;
        this.idade = idade;
        this.equipe = equipe;
        this.motor = motor;
        this.pontuacao = pontuacao;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }
}
