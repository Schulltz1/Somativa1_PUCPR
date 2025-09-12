package br.estudos.calculadora.servico;

import br.estudos.calculadora.modelo.Calculadora;
import br.estudos.calculadora.modelo.Operacao;
import br.estudos.calculadora.util.ValidadorEntrada;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Scanner;

import static org.mockito.Mockito.*;

class CalculadoraServiceTest {

    @Mock
    private Calculadora calculadora;

    @Mock
    private ValidadorEntrada validador;

    private CalculadoraService service;
    private Scanner scanner;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new CalculadoraService(calculadora, validador);
        scanner = new Scanner(System.in); // Scanner real, mas não usado diretamente
    }

    @Test
    void testExecutarSoma() {
        when(validador.lerNumero(scanner)).thenReturn(5.0, 3.0);
        when(calculadora.somar(5.0, 3.0)).thenReturn(8.0);

        service.executarOperacao(1, scanner);

        verify(validador, times(2)).lerNumero(scanner);
        verify(calculadora).somar(5.0, 3.0);
    }

    @Test
    void testExecutarSubtracao() {
        when(validador.lerNumero(scanner)).thenReturn(5.0, 3.0);
        when(calculadora.subtrair(5.0, 3.0)).thenReturn(2.0);

        service.executarOperacao(2, scanner);

        verify(validador, times(2)).lerNumero(scanner);
        verify(calculadora).subtrair(5.0, 3.0);
    }

    @Test
    void testExecutarMultiplicacao() {
        when(validador.lerNumero(scanner)).thenReturn(4.0, 3.0);
        when(calculadora.multiplicar(4.0, 3.0)).thenReturn(12.0);

        service.executarOperacao(3, scanner);

        verify(validador, times(2)).lerNumero(scanner);
        verify(calculadora).multiplicar(4.0, 3.0);
    }

    @Test
    void testExecutarDivisao() {
        when(validador.lerNumero(scanner)).thenReturn(10.0, 2.0);
        when(calculadora.dividir(10.0, 2.0)).thenReturn(5.0);

        service.executarOperacao(4, scanner);

        verify(validador, times(2)).lerNumero(scanner);
        verify(calculadora).dividir(10.0, 2.0);
    }

    @Test
    void testExecutarDivisaoPorZero() {
        when(validador.lerNumero(scanner)).thenReturn(10.0, 0.0);
        when(calculadora.dividir(10.0, 0.0)).thenThrow(new ArithmeticException("Não é possível dividir por zero!"));

        service.executarOperacao(4, scanner);

        verify(validador, times(2)).lerNumero(scanner);
        verify(calculadora).dividir(10.0, 0.0);
    }

    @Test
    void testExecutarPotencia() {
        when(validador.lerNumero(scanner)).thenReturn(2.0, 3.0);
        when(calculadora.potencia(2.0, 3.0)).thenReturn(8.0);

        service.executarOperacao(5, scanner);

        verify(validador, times(2)).lerNumero(scanner);
        verify(calculadora).potencia(2.0, 3.0);
    }

    @Test
    void testExecutarRaizQuadrada() {
        when(validador.lerNumero(scanner)).thenReturn(16.0);
        when(calculadora.raizQuadrada(16.0)).thenReturn(4.0);

        service.executarOperacao(6, scanner);

        verify(validador).lerNumero(scanner);
        verify(calculadora).raizQuadrada(16.0);
    }

    @Test
    void testExecutarRaizQuadradaNegativa() {
        when(validador.lerNumero(scanner)).thenReturn(-4.0);
        when(calculadora.raizQuadrada(-4.0)).thenThrow(new IllegalArgumentException("Não é possível calcular raiz quadrada de número negativo!"));

        service.executarOperacao(6, scanner);

        verify(validador).lerNumero(scanner);
        verify(calculadora).raizQuadrada(-4.0);
    }

    @Test
    void testOpcaoInvalida() {
        service.executarOperacao(99, scanner);

        verify(validador, never()).lerNumero(scanner);
        verify(calculadora, never()).somar(anyDouble(), anyDouble());
        verify(calculadora, never()).subtrair(anyDouble(), anyDouble());
        verify(calculadora, never()).multiplicar(anyDouble(), anyDouble());
        verify(calculadora, never()).dividir(anyDouble(), anyDouble());
        verify(calculadora, never()).potencia(anyDouble(), anyDouble());
        verify(calculadora, never()).raizQuadrada(anyDouble());
    }

    @Test
    void testSair() {
        service.executarOperacao(0, scanner);

        verify(validador, never()).lerNumero(scanner);
        verify(calculadora, never()).somar(anyDouble(), anyDouble());
        verify(calculadora, never()).subtrair(anyDouble(), anyDouble());
        verify(calculadora, never()).multiplicar(anyDouble(), anyDouble());
        verify(calculadora, never()).dividir(anyDouble(), anyDouble());
        verify(calculadora, never()).potencia(anyDouble(), anyDouble());
        verify(calculadora, never()).raizQuadrada(anyDouble());
    }
}