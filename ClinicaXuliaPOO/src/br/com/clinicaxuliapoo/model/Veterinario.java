package br.com.clinicaxuliapoo.model;
import java.util.Date;

public class Veterinario{
   private String crmv;
   private String nome;
   private String email;
   private String senha;
   private String telefone;
   private String endereco;
   private String cpf;
   private Date data_nascimento;
   private boolean disponibilidade;
   private float salario;

    public Veterinario() {
    }

    public Veterinario(String crmv, String nome, String email, String senha, String telefone, String endereco, String cpf, Date data_nascimento, boolean disponibilidade, float salario) {
        this.crmv = crmv;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.disponibilidade = disponibilidade;
        this.salario = salario;
    }

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Override
    public String toString(){
        return this.getNome();
    }
}
