package br.estudos.calculadora.servico;

import br.estudos.calculadora.modelo.Calculadora;
import br.estudos.calculadora.modelo.Operacao;
import br.estudos.calculadora.util.ValidadorEntrada;
import java.util.Scanner;

public class CalculadoraService {

    // Composição: CalculadoraService "tem uma" Calculadora
    private Calculadora calculadora;
    private ValidadorEntrada validador;

    // Construtor
    public CalculadoraService() {
        this.calculadora = new Calculadora();
        this.validador = new ValidadorEntrada();
    }

    public void executarOperacao(int opcao, Scanner scanner) {
        try {
            switch (opcao) {
                case 1:
                    executarOperacaoComDoisNumeros(Operacao.SOMA, scanner);
                    break;
                case 2:
                    executarOperacaoComDoisNumeros(Operacao.SUBTRACAO, scanner);
                    break;
                case 3:
                    executarOperacaoComDoisNumeros(Operacao.MULTIPLICACAO, scanner);
                    break;
                case 4:
                    executarOperacaoComDoisNumeros(Operacao.DIVISAO, scanner);
                    break;
                case 5:
                    executarOperacaoComDoisNumeros(Operacao.POTENCIA, scanner);
                    break;
                case 6:
                    executarOperacaoComUmNumero(Operacao.RAIZ_QUADRADA, scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void executarOperacaoComDoisNumeros(Operacao operacao, Scanner scanner) {
        System.out.print("Digite o primeiro número: ");
        double num1 = validador.lerNumero(scanner);

        System.out.print("Digite o segundo número: ");
        double num2 = validador.lerNumero(scanner);

        double resultado = 0;

        switch (operacao) {
            case SOMA:
                resultado = calculadora.somar(num1, num2);
                break;
            case SUBTRACAO:
                resultado = calculadora.subtrair(num1, num2);
                break;
            case MULTIPLICACAO:
                resultado = calculadora.multiplicar(num1, num2);
                break;
            case DIVISAO:
                resultado = calculadora.dividir(num1, num2);
                break;
            case POTENCIA:
                resultado = calculadora.potencia(num1, num2);
                break;
        }

        mostrarResultado(num1, num2, resultado, operacao);
    }

    private void executarOperacaoComUmNumero(Operacao operacao, Scanner scanner) {
        System.out.print("Digite o número: ");
        double numero = validador.lerNumero(scanner);

        double resultado = calculadora.raizQuadrada(numero);

        System.out.printf("%.2f %s = %.2f%n",
                numero, operacao.getSimbolo(), resultado);
    }

    private void mostrarResultado(double num1, double num2, double resultado, Operacao operacao) {
        System.out.printf("%.2f %s %.2f = %.2f%n",
                num1, operacao.getSimbolo(), num2, resultado);
    }
}