package br.estudos.calculadora.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Locale;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ValidadorEntradaTest {

    private ValidadorEntrada validador;

    @BeforeEach
    void setUp() {
        validador = new ValidadorEntrada();
    }

    @Test
    void testLerNumeroValido() {
        String input = "5.5";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        scanner.useLocale(Locale.US); // Força locale americano para consistência

        double resultado = validador.lerNumero(scanner);
        assertEquals(5.5, resultado, 0.0001);
        scanner.close();
    }

    @Test
    void testLerNumeroInvalidoSeguidoDeValido() {
        String input = "abc 3.14";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        scanner.useLocale(Locale.US); // Força locale americano para consistência

        double resultado = validador.lerNumero(scanner);
        assertEquals(3.14, resultado, 0.0001);
        scanner.close();
    }

    @Test
    void testIsNumeroValidoComNumero() {
        boolean resultado = validador.isNumeroValido("123.45");
        assertTrue(resultado);
    }

    @Test
    void testIsNumeroValidoComTexto() {
        boolean resultado = validador.isNumeroValido("abc");
        assertFalse(resultado);
    }

    @Test
    void testIsNumeroValidoComVazio() {
        boolean resultado = validador.isNumeroValido("");
        assertFalse(resultado);
    }

    @Test
    void testIsNumeroValidoComNull() {
        boolean resultado = validador.isNumeroValido(null);
        assertFalse(resultado);
    }

    @Test
    void testIsNumeroValidoComEspacos() {
        boolean resultado = validador.isNumeroValido("  123.45  ");
        assertTrue(resultado);
    }
}