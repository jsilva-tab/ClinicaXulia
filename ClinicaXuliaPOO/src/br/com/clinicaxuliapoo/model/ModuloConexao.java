package br.com.clinicaxuliapoo.model;
import java.sql.*;

public class ModuloConexao {

    public static Connection conector() {
        java.sql.Connection conexao = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/db_vetclin_xulia";
        String user = "root";
        String password = "M!ch$#l,Sh##n<3";
        
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            //Esclarece o erro -> System.out.println(e);
            return null;
        }
    }
}
