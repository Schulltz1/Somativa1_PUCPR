package br.estudos.calculadora;

import br.estudos.calculadora.servico.CalculadoraService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CalculadoraService service = new CalculadoraService();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {

            System.out.println("\n-- CALCULADORA --");
            System.out.println("1. Soma");
            System.out.println("2. Subtração");
            System.out.println("3. Multiplicação");
            System.out.println("4. Divisão");
            System.out.println("5. Potência");
            System.out.println("6. Raiz Quadrada");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            service.executarOperacao(opcao, scanner);

        } while (opcao != 0);

        scanner.close();
        System.out.println("Calculadora encerrada com sucesso!");
    }
}