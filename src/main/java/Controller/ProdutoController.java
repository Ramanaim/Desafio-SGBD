package Controller;

import DAO.ProdutoDAO;
import Model.Produto;

import java.util.List;

public class ProdutoController {

    ProdutoDAO produtoDAO = new ProdutoDAO();

    public void cadastrar(Produto produto){
        produtoDAO.cadastrarProduto(produto);
    }

    public List<Produto> listar(){
        return produtoDAO.listarProdutos();
    }

    public void editar(Long id, String conteudo, int opcao){
        produtoDAO.editar(id,conteudo,opcao);
    }

    public void remover(Long id){
        produtoDAO.remover(id);
    }
}
