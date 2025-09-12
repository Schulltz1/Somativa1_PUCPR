package br.estudos.calculadora.servico;

import br.estudos.calculadora.modelo.Calculadora;
import br.estudos.calculadora.util.ValidadorEntrada;

public class CalculadoraService {
    private final Calculadora calculadora;
    private final ValidadorEntrada validador;

    public CalculadoraService(Calculadora calculadora, ValidadorEntrada validador) {
        this.calculadora = calculadora;
        this.validador = validador;
    }

    public void executarOperacao(int opcao, java.util.Scanner scanner) {
        switch (opcao) {
            case 1: // Soma
                double num1 = validador.lerNumero(scanner);
                double num2 = validador.lerNumero(scanner);
                System.out.println("Resultado: " + calculadora.somar(num1, num2));
                break;
            case 2: // Subtração
                num1 = validador.lerNumero(scanner);
                num2 = validador.lerNumero(scanner);
                System.out.println("Resultado: " + calculadora.subtrair(num1, num2));
                break;
            case 3: // Multiplicação
                num1 = validador.lerNumero(scanner);
                num2 = validador.lerNumero(scanner);
                System.out.println("Resultado: " + calculadora.multiplicar(num1, num2));
                break;
            case 4: // Divisão
                num1 = validador.lerNumero(scanner);
                num2 = validador.lerNumero(scanner);
                try {
                    System.out.println("Resultado: " + calculadora.dividir(num1, num2));
                } catch (ArithmeticException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
                break;
            case 5: // Potência
                num1 = validador.lerNumero(scanner);
                num2 = validador.lerNumero(scanner);
                System.out.println("Resultado: " + calculadora.potencia(num1, num2));
                break;
            case 6: // Raiz Quadrada
                num1 = validador.lerNumero(scanner);
                try {
                    System.out.println("Resultado: " + calculadora.raizQuadrada(num1));
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
                break;
            case 0: // Sair
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
}