package br.com.clinicaxuliapoo.model;

public class Pet {
    private int idPet;
    private String idDono;
    private String nome_pet;
    private String especie;
    private String raca;
    private int idade;
    private String sexo;

    public Pet(int idPet, String idDono, String nome_pet, String especie, String raca, int idade, String sexo) {
        this.idPet = idPet;
        this.idDono = idDono;
        this.nome_pet = nome_pet;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.sexo = sexo;
    }
    
    public Pet(String idDono, String nome_pet, String especie, String raca, int idade, String sexo) {
        this.idDono = idDono;
        this.nome_pet = nome_pet;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.sexo = sexo;
    }
    
    public Pet(){}

    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    public String getIdDono() {
        return idDono;
    }

    public void setIdDono(String idDono) {
        this.idDono = idDono;
    }

    public String getNome_pet() {
        return nome_pet;
    }

    public void setNome_pet(String nome_pet) {
        this.nome_pet = nome_pet;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
}
