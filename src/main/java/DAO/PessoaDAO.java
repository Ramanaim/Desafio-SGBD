package DAO;

import Factory.ConnectionFactory;
import Model.Pessoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    private Connection connection;

    public PessoaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void tabelaPessoa() {
        String sql = "CREATE TABLE IF NOT EXISTS pessoas (" +
                "idPessoa INT PRIMARY KEY AUTO_INCREMENT," +
                "nomePessoa VARCHAR(50) NOT NULL," +
                "sexoPessoa VARCHAR(50) NOT NULL" + ")";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("Tabela criada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastrarPessoa(Pessoa pessoa) {

        String sql = "INSERT INTO pessoas" +
                "nomePessoa,sexoPessoa" +
                "VALEUs (?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, pessoa.getNomePessoa());
            stmt.setString(2, pessoa.getSexoPessoa());

            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();

            while (resultSet.next()) {
                pessoa.setIdPessoa(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Pessoa> listarPessoas() {
        String sql = "SELECT *FROM pessoas";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            List<Pessoa> pessoas = new ArrayList<>();
            Pessoa pessoa;

            while (resultSet.next()) {
                pessoa = new Pessoa();
                pessoa.setIdPessoa(Long.valueOf(resultSet.getInt("idPessoa")));
                pessoa.setNomePessoa(resultSet.getString("nomePessoa"));
                pessoa.setSexoPessoa(resultSet.getString("sexoPessoa"));
            }
            return pessoas;
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }
}