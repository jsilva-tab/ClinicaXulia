package br.com.clinicaxuliapoo.model;

import java.time.LocalDate;

public class Vacina {
    private int idVacina;
    private String nome_vac;
    private String lote;
    private LocalDate validade;
    private String fabricante;
    private String descricao;

    public Vacina() {
    }

    public Vacina(int idVacina, String nome_vac, String lote, LocalDate validade, String fabricante, String descricao) {
        this.idVacina = idVacina;
        this.nome_vac = nome_vac;
        this.lote = lote;
        this.validade = validade;
        this.fabricante = fabricante;
        this.descricao = descricao;
    }

    public int getIdVacina() {
        return idVacina;
    }

    public void setIdVacina(int idVacina) {
        this.idVacina = idVacina;
    }

    public String getNome_vac() {
        return nome_vac;
    }

    public void setNome_vac(String nome_vac) {
        this.nome_vac = nome_vac;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
