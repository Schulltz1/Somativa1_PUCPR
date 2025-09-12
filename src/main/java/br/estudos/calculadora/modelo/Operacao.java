package br.estudos.calculadora.modelo;

public enum Operacao {
    SOMA("+"),
    SUBTRACAO("-"),
    MULTIPLICACAO("*"),
    DIVISAO("/"),
    POTENCIA("^"),
    RAIZ_QUADRADA("√");

    private final String simbolo;

    // Construtor do enum
    Operacao(String simbolo) {
        this.simbolo = simbolo;
    }

    // Getter para o símbolo
    public String getSimbolo() {
        return simbolo;
    }
}