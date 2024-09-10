package br.com.clinicaxuliapoo.model;

import java.time.LocalDate;

public class Carteira {
        private int idPet;
        private String nomePet;
        private String nomeVacina;
        private LocalDate dataAplicacao;
        private String status;

     public Carteira(int idPet, String nomePet, String nomeVacina, LocalDate dataAplicacao, String status) {
            this.idPet = idPet;
            this.nomePet = nomePet;
            this.nomeVacina = nomeVacina;
            this.dataAplicacao = dataAplicacao;
            this.status = status;
        }
        
    public Carteira(){}

    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public LocalDate getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(LocalDate dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }
    
    public String getStatus(){
        return status;
    }
   
    public void setStatus(String status){
        this.status = status;
    }
}