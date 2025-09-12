package br.estudos.calculadora.modelo;

public class Calculadora {

    // Atributo para armazenar o último resultado
    private double ultimoResultado;

    // Construtor
    public Calculadora() {
        this.ultimoResultado = 0.0;
    }

    // Método para soma
    public double somar(double a, double b) {
        ultimoResultado = a + b;
        return ultimoResultado;
    }

    // Método para subtração
    public double subtrair(double a, double b) {
        ultimoResultado = a - b;
        return ultimoResultado;
    }

    // Método para multiplicação
    public double multiplicar(double a, double b) {
        ultimoResultado = a * b;
        return ultimoResultado;
    }

    // Método para divisão
    public double dividir(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Não é possível dividir por zero!");
        }
        ultimoResultado = a / b;
        return ultimoResultado;
    }

    // Método para potência
    public double potencia(double base, double expoente) {
        ultimoResultado = Math.pow(base, expoente);
        return ultimoResultado;
    }

    // Método para raiz quadrada
    public double raizQuadrada(double numero) throws IllegalArgumentException {
        if (numero < 0) {
            throw new IllegalArgumentException("Não é possível calcular raiz quadrada de número negativo!");
        }
        ultimoResultado = Math.sqrt(numero);
        return ultimoResultado;
    }

    // Getter para último resultado
    public double getUltimoResultado() {
        return ultimoResultado;
    }

    // Método para limpar o último resultado
    public void limpar() {
        ultimoResultado = 0.0;
    }
}