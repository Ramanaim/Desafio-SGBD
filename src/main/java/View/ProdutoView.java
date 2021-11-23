package View;

import Controller.ProdutoController;
import Model.Produto;

import java.util.List;
import java.util.Scanner;

public class ProdutoView {

    Scanner input = new Scanner(System.in);
    ProdutoController produtoController = new ProdutoController();

    public void cadastrarProduto(){
        Produto produto = new Produto();

        System.out.print("Nome do Produto: ");
        produto.setNomeProduto(input.nextLine());
        System.out.print("Quantidade do Produto: ");
        produto.setQuantidadeProduto(Long.parseLong(input.nextLine()));
        System.out.print("Valor de Custo do Produto: R$");
        produto.setValorCusto(Double.parseDouble(input.nextLine()));
        System.out.print("Valor de Venda do Produto: R$");
        produto.setValorVenda(Double.parseDouble(input.nextLine()));

        produtoController.cadastrar(produto);

    }

    public void listar(){
        List<Produto> produtos = produtoController.listar();
        for (Produto produto : produtos){
            System.out.println(produto);
        }
    }

    public void editar(){
        this.listar();
        String conteudo = null;

        System.out.print("Para Editar um Produto digite o ID dele: ");
        Long id = Long.valueOf(input.nextLine());
        System.out.print("1 - Nome do Produto\n2 - Quantidade do Produto\n3 - Valor de Custo do Produto\n4 - Valor de Venda do Produto\n-> ");
        int opcao = Integer.parseInt(input.nextLine());

        switch (opcao){
            case 1:
                System.out.print("Digite o novo Nome do Produto: ");
                conteudo = input.nextLine();
                break;
            case 2:
                System.out.print("Digite a nova Quantidade do Produto: ");
                conteudo = String.valueOf(Long.valueOf(input.nextLine()));
                break;
            case 3:
                System.out.print("Digite o novo Valor de Custo do Produto: R$");
                conteudo = String.valueOf(Double.valueOf(input.nextLine()));
                break;
            case 4:
                System.out.print("Digite o novo Valor de Venda do Produto: R$");
                conteudo = String.valueOf(Double.valueOf(input.nextLine()));
                break;
            default:
                System.out.println("Opção Invalida.");
                return;
        }
        produtoController.editar(id,conteudo,opcao);
    }

    public void remover(){
        this.listar();
        System.out.print("Para Remover um Produto digite o ID dele: ");
        Long id = Long.valueOf(input.nextLine());
        produtoController.remover(id);
    }

}
