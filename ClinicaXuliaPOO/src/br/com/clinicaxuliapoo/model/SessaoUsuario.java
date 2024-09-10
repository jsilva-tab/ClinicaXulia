package br.com.clinicaxuliapoo.model;

public class SessaoUsuario {
    private static String cpfUsuarioLogado;
    
    public static String getCpfUsuarioLogado(){
        return cpfUsuarioLogado;
    }
    
    public static void setCpfUsuarioLogado(String cpf){
        cpfUsuarioLogado = cpf;
    }
}
