package br.com.clinicaxuliapoo.dao;

import br.com.clinicaxuliapoo.model.Consulta;
import br.com.clinicaxuliapoo.model.ModuloConexao;
import br.com.clinicaxuliapoo.model.Carteira;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDAO {

    private Connection conn;

    public AgendamentoDAO() {
        // Estabelecer a conexão com o banco de dados
        this.conn = ModuloConexao.conector();
    }

    public List<Consulta> listarConsultasPendentes() {
        List<Consulta> consultasPendentes = new ArrayList<>();
        String sql = "SELECT idConsulta, data_consulta, idVeterinario, idCliente, idPet, status " +
                     "FROM tb_consultas " +
                     "WHERE status = 'Agendada'";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setIdConsulta(rs.getInt("idConsulta"));
                consulta.setDataHora(rs.getTimestamp("data_consulta").toLocalDateTime());
                consulta.setIdVeterinario(rs.getString("idVeterinario"));
                consulta.setIdCliente(rs.getString("idCliente"));
                consulta.setIdPet(rs.getInt("idPet"));
                consulta.setStatus(rs.getString("status"));

                consultasPendentes.add(consulta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return consultasPendentes;
    }

    public List<Carteira> listarVacinacoesPendentes() throws SQLException {
        List<Carteira> vacinacoesPendentes = new ArrayList<>();
        
        String sql = "SELECT va.idPet, p.nome_pet, v.nome_vac AS nomeVacina, va.data_aplicacao, va.status " +
                     "FROM tb_vacinas_aplicadas va " +
                     "JOIN tb_pets p ON va.idPet = p.idPet " +
                     "JOIN tb_vacinas v ON va.idVacina = v.idVacina " +
                     "WHERE va.status = 'pendente'";

        try (Connection conn = ModuloConexao.conector();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Carteira carteira = new Carteira();
                carteira.setIdPet(rs.getInt("idPet"));  // idPet como int
                carteira.setNomePet(rs.getString("nome_pet"));  // Convertido para String
                carteira.setNomeVacina(rs.getString("nomeVacina"));  // Convertido para String
                carteira.setDataAplicacao(rs.getDate("data_aplicacao").toLocalDate());
                carteira.setStatus(rs.getString("status"));
                vacinacoesPendentes.add(carteira);
            }
        }

        return vacinacoesPendentes;
    }
    
}
