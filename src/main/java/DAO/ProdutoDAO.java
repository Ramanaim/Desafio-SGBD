package DAO;

import Factory.ConnectionFactory;
import Model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

        Connection connection;

        public ProdutoDAO() {
            connection = new ConnectionFactory().getConnection();
        }

    public void criarTabela(){
        String sql = "create table if not exists produtos(idProduto int primary key auto_increment," +
                "nomeProduto VARCHAR(50) NOT NULL," +
                "quantidadeProduto INT," +
                "valorCusto INT," +
                "valorVenda INT)";
        try {
            PreparedStatement stml = connection.prepareStatement(sql);
            stml.execute();
            stml.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void cadastrarProduto(Produto produto){
        String sql = "insert into produtos(nomeProduto, quantidadeProduto, precoCusto, precoVenda) value (?,?,?,?)";
        try{
            PreparedStatement stml = connection.prepareStatement(sql);
            stml.setString(1, produto.getNomeProduto());
            stml.setLong(2, produto.getQuantidadeProduto());
            stml.setDouble(3, produto.getValorCusto());
            stml.setDouble(4, produto.getValorVenda());
            stml.execute();
            stml.close();
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }

    public List<Produto> listarProdutos(){
        String sql = "select * from produtos";
        try{
            PreparedStatement stml = connection.prepareStatement(sql);
            ResultSet resultSet = stml.executeQuery();
            List<Produto> produtos = new ArrayList<>();
            Produto produto;
            while (resultSet.next()){
                produto = new Produto();
                produto.setIdProduto(resultSet.getLong("idProduto"));
                produto.setNomeProduto(resultSet.getString("nomeProduto"));
                produto.setQuantidadeProduto(resultSet.getLong("quantidadeProduto"));
                produto.setValorCusto(resultSet.getDouble("precoCusto"));
                produto.setValorVenda(resultSet.getDouble("precoVenda"));
                produtos.add(produto);
            }
            return produtos;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void remover(Long id){
        try{
            String sql = "delete from produtos where idProduto = ?";
            PreparedStatement stml = connection.prepareStatement(sql);
            stml.setLong(1,id);
            stml.execute();
            stml.close();
            System.out.print("Produto removido com sucesso!");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void editar(Long id, String conteudo , int opcao){
        String sql = null;
        switch (opcao){
            case 1:
                sql = "update produtos set nomeProduto = ? where idProduto = ?";
                break;
            case 2:
                sql = "update produtos set quantidadeProduto = ? where idProduto = ?";
                break;
            case 3:
                sql = "update produtos set precoCusto = ? where idProduto = ?";
                break;
            case 4:
                sql = "update produtos set precoVenda = ? where idProduto = ?";
                break;
        }
        try{
            PreparedStatement stml = connection.prepareStatement(sql);
            stml.setString(1,conteudo);
            stml.setLong(2, id);
            stml.execute();
            stml.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}