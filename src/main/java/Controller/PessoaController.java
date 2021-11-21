package Controller;

import DAO.PessoaDAO;
import Model.Pessoa;

import java.util.List;

public class PessoaController {

    PessoaDAO pessoaDAO = new PessoaDAO();

    public void adiconarPessoa(Pessoa pessoa){
        pessoaDAO.tabelaPessoa();
        pessoaDAO.cadastrarPessoa(pessoa);
    }

    public List<Pessoa> listarPessoas(){
        return pessoaDAO.listarPessoas();
    }

}
