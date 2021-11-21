package View;

import Controller.PessoaController;
import Model.Pessoa;

import java.util.Scanner;

public class PessoaView {

    Scanner input = new Scanner(System.in);
    PessoaController pessoaController = new PessoaController();

    public void menuPrincipal(){

        System.out.println("1- Cadastrar pessoa.");
        System.out.println("2- Editar pessoa.   ");
        System.out.println("3- Remover pessoa.  ");
        System.out.println("4- Listar pessoas.  ");
        System.out.println("--------------------");

        int opcao = input.nextInt();
        switch (opcao){
            case 1 :
                cadastrarPessoa();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                pessoaController.listarPessoas();
                break;
        }

    }


    public void cadastrarPessoa(){
        Pessoa pessoa = new Pessoa();
        System.out.println("Digite o nome da pessoa:");
        pessoa.setNomePessoa(input.next());
        input.nextLine();
        System.out.println("Digite o sexo da pessoa:");
        pessoa.setSexoPessoa(input.next());
        input.nextLine();

        System.out.println(pessoa);

    }

}
