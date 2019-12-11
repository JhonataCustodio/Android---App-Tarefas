package br.ifms.exemplo.model;

import androidx.annotation.NonNull;

public class Curso {

    private Integer id;
    private String nome;
    private String descricao;
    private String botao_feito;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NonNull
    @Override
    public String toString() {
        return nome + "\n"+descricao;
    }

    public String getBotao_feito() {
        return botao_feito;
    }

    public void setBotao_feito(String botao_feito) {
        this.botao_feito = botao_feito;
    }
}
