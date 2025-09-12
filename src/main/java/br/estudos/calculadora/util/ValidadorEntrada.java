package br.estudos.calculadora.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidadorEntrada {

    public double lerNumero(Scanner scanner) {
        while (true) {
            try {
                if (scanner.hasNext()) {
                    String input = scanner.next();
                    // Tenta converter diretamente usando Double.parseDouble
                    double numero = Double.parseDouble(input);
                    return numero;
                } else {
                    throw new java.util.NoSuchElementException("Não há mais entrada disponível");
                }
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida! Digite um número válido: ");
                // Se chegou aqui, já consumiu o token inválido, continua o loop
            }
        }
    }

    public boolean isNumeroValido(String entrada) {
        if (entrada == null || entrada.trim().isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(entrada.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}