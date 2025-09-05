package br.estudos.calculadora.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidadorEntrada {

    public double lerNumero(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Entrada inválida! Digite um número válido: ");
                scanner.next(); // Limpa a entrada inválida
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