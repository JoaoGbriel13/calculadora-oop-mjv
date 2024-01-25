package br.com.jg.Service;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class CalculadoraService {
    private Scanner scanner = new Scanner(System.in);
    public double add(){
        System.out.println("Insira o primeiro numero: ");
        double n1 = scanner.nextDouble();
        System.out.println("Insira o segundo numero: ");
        double n2 = scanner.nextDouble();
        return n1 + n2;
    }
    public double subtract(){
        System.out.println("Insira o primeiro numero: ");
        double n1 = scanner.nextDouble();
        System.out.println("Insira o segundo numero: ");
        double n2 = scanner.nextDouble();
        return n1 - n2;
    }
    public double multiply(){
        System.out.println("Insira o primeiro numero: ");
        double n1 = scanner.nextDouble();
        System.out.println("Insira o segundo numero: ");
        double n2 = scanner.nextDouble();
        return n1 * n2;
    }

    public double divide(){
        System.out.println("Insira o primeiro numero: ");
        double n1 = scanner.nextDouble();
        System.out.println("Insira o segundo numero: ");
        double n2 = scanner.nextDouble();
        if (n2 == 0){
            throw new InvalidParameterException("Não pode fazer divisão por 0!!");
        }
        return n1 / n2;
    }
}
