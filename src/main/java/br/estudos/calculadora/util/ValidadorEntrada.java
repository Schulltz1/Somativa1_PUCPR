package br.estudos.calculadora.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidadorEntrada {

    public double lerNumero(Scanner scanner) {
        while (true) {
            try {
                // Verifica se há próximo token antes de tentar ler
                if (scanner.hasNextDouble()) {
                    return scanner.nextDouble();
                } else if (scanner.hasNext()) {
                    // Se há um token mas não é um double, tenta limpar
                    System.out.print("Entrada inválida! Digite um número válido: ");
                    scanner.next(); // Limpa a entrada inválida
                } else {
                    // Não há mais tokens disponíveis
                    throw new java.util.NoSuchElementException("Não há mais entrada disponível");
                }
            } catch (InputMismatchException e) {
                System.out.print("Entrada inválida! Digite um número válido: ");
                if (scanner.hasNext()) {
                    scanner.next(); // Limpa a entrada inválida
                } else {
                    throw new java.util.NoSuchElementException("Não há mais entrada disponível");
                }
            }
        }
    }

    public boolean isNumeroValido(String entrada) {
        try {
            Double.parseDouble(entrada);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}