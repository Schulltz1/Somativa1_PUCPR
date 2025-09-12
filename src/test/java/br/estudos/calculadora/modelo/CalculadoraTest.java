package br.estudos.calculadora.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    void testSomar() {
        double resultado = calculadora.somar(5.0, 3.0);
        assertEquals(8.0, resultado, 0.0001);
        assertEquals(8.0, calculadora.getUltimoResultado(), 0.0001);
    }

    @Test
    void testSomarComNumerosNegativos() {
        double resultado = calculadora.somar(-2.0, -3.0);
        assertEquals(-5.0, resultado, 0.0001);
        assertEquals(-5.0, calculadora.getUltimoResultado(), 0.0001);
    }

    @Test
    void testSubtrair() {
        double resultado = calculadora.subtrair(5.0, 3.0);
        assertEquals(2.0, resultado, 0.0001);
        assertEquals(2.0, calculadora.getUltimoResultado(), 0.0001);
    }

    @Test
    void testSubtrairComResultadoNegativo() {
        double resultado = calculadora.subtrair(3.0, 5.0);
        assertEquals(-2.0, resultado, 0.0001);
        assertEquals(-2.0, calculadora.getUltimoResultado(), 0.0001);
    }

    @Test
    void testMultiplicar() {
        double resultado = calculadora.multiplicar(4.0, 3.0);
        assertEquals(12.0, resultado, 0.0001);
        assertEquals(12.0, calculadora.getUltimoResultado(), 0.0001);
    }

    @Test
    void testMultiplicarPorZero() {
        double resultado = calculadora.multiplicar(10.0, 0.0);
        assertEquals(0.0, resultado, 0.0001);
        assertEquals(0.0, calculadora.getUltimoResultado(), 0.0001);
    }

    @Test
    void testDividir() {
        double resultado = calculadora.dividir(10.0, 2.0);
        assertEquals(5.0, resultado, 0.0001);
        assertEquals(5.0, calculadora.getUltimoResultado(), 0.0001);
    }

    @Test
    void testDividirPorZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calculadora.dividir(10.0, 0.0);
        });
        assertEquals("Não é possível dividir por zero!", exception.getMessage());
        assertEquals(0.0, calculadora.getUltimoResultado(), 0.0001);
    }

    @Test
    void testPotencia() {
        double resultado = calculadora.potencia(2.0, 3.0);
        assertEquals(8.0, resultado, 0.0001);
        assertEquals(8.0, calculadora.getUltimoResultado(), 0.0001);
    }

    @Test
    void testPotenciaComExpoenteZero() {
        double resultado = calculadora.potencia(5.0, 0.0);
        assertEquals(1.0, resultado, 0.0001);
        assertEquals(1.0, calculadora.getUltimoResultado(), 0.0001);
    }

    @Test
    void testRaizQuadrada() {
        double resultado = calculadora.raizQuadrada(16.0);
        assertEquals(4.0, resultado, 0.0001);
        assertEquals(4.0, calculadora.getUltimoResultado(), 0.0001);
    }

    @Test
    void testRaizQuadradaDeZero() {
        double resultado = calculadora.raizQuadrada(0.0);
        assertEquals(0.0, resultado, 0.0001);
        assertEquals(0.0, calculadora.getUltimoResultado(), 0.0001);
    }

    @Test
    void testRaizQuadradaDeNumeroNegativo() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadora.raizQuadrada(-4.0);
        });
        assertEquals("Não é possível calcular raiz quadrada de número negativo!", exception.getMessage());
        assertEquals(0.0, calculadora.getUltimoResultado(), 0.0001);
    }

    @Test
    void testLimpar() {
        calculadora.somar(5.0, 3.0);
        calculadora.limpar();
        assertEquals(0.0, calculadora.getUltimoResultado(), 0.0001);
    }
}