package br.com.jg.Utils;

import br.com.jg.Model.User;
import br.com.jg.Model.UserList;
import br.com.jg.Service.CalculadoraService;

import java.util.Scanner;

public class Menu {
    private final Scanner scan = new Scanner(System.in);
    private final UserList userList = new UserList();
    private final CalculadoraService calculadoraService = new CalculadoraService();

    public void exibirMenu(){
        iniciarMenu();
    }

    private void iniciarMenu(){
        System.out.println("Olá! Bem vindo ao sistema, o que deseja fazer?" +
                "\n 1 - Cadastrar usuario" +
                "\n 2 - Login" +
                "\n 3 - Sair");
        System.out.println();
        System.out.println();
        int escolha = scan.nextInt();

        switch (escolha){
            case 1 : cadastrarUser(); break;
            case 2 :
                User user = loginUser();
                if (user == null){
                    System.out.println("Usuario não encontrado, tente novamente");
                }else {
                    System.out.println("Iniciando calculadora...");
                    calcular(user);
                    break;
                }
            case 3 :
                System.out.println("Saindo da aplicação...");
                System.exit(1);
            default:
                System.out.println("Operação invalida");
                iniciarMenu();
        }
    }

    private void cadastrarUser(){
        System.out.println("Digite seu username desejado: ");
        String username = scan.next();
        System.out.println("Digite a sua senha: ");
        String password = scan.next();
        System.out.println("Digite o seu primeiro nome: ");
        String firstName = scan.next();
        System.out.println("Digite seu ultimo nome: ");
        String lastName = scan.next();
        System.out.println("Digite a sua idade: ");
        int age = scan.nextInt();
        System.out.println("Digite o seu email: ");
        String email = scan.next();

        userList.cadastrarUsuario(username,password,firstName,lastName,age,email);
        exibirMenu();
    }

    private User loginUser(){
        System.out.println("Digite seu username: ");
        String username = scan.next();
        System.out.println("Digite a sua senha:");
        String password = scan.next();
        User userLogin = userList.loginUsuario(username,password);
        if (userLogin != null){
            System.out.println("Login realizado com sucesso!");
            return userLogin;
        }else {
            System.out.println("Informações incorretas, tente novamente");
            return null;
        }
    }

    private void calcular(User user){
        System.out.printf("Olá %s! Bem vindo a calculadora orientada a objetos, selecione a operação desejada:" +
                "\n 1 : Adição" +
                "\n 2 : Subtração" +
                "\n 3 : Multiplicação" +
                "\n 4 : Divisão" +
                "\n 0 : Sair ", user.getFirstName());
        int escolha = scan.nextInt();
        switch (escolha){
            case 1:
                System.out.printf("O resultado é: %.2f", calculadoraService.add());
                calcular(user);
                break;
            case 2:
                System.out.printf("O resultado é: %.2f", calculadoraService.subtract());
                calcular(user);
                break;
            case 3:
                System.out.printf("O resultado é: %.2f", calculadoraService.multiply());
                calcular(user);
                break;
            case 4:
                System.out.printf("O resultado é: %.2f", calculadoraService.divide());
                calcular(user);
                break;
            case 0:
                iniciarMenu();
                break;
            default:
                System.out.println("Operação invalida, tente novamente");
                calcular(user);
        }
    }
}
