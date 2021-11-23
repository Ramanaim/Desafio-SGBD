import DAO.ProdutoDAO;
import View.ProdutoView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.criarTabela();
        ProdutoView produtoView = new ProdutoView();
        Scanner input = new Scanner(System.in);

        while (true){
            System.out.print("\n1 - Cadastrar Produto\n2 - Listar Produtos\n3 - Editar Produto\n4 - Remover Produto\nDigite sua opção\n");
            switch (Integer.parseInt(input.nextLine())){
                case 1:
                    produtoView.cadastrarProduto();
                    break;
                case 2:
                    produtoView.listar();
                    break;
                case 3:
                   produtoView.editar();
                    break;
                case 4:
                    produtoView.remover();
                    break;
            }
        }

    }
}