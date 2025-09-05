<div align="center">
  <h1>🧮 Calculadora Java POO</h1>
  <p>Uma calculadora elegante desenvolvida em Java com foco em Programação Orientada a Objetos</p>

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Status](https://img.shields.io/badge/Status-Concluído-success?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)
</div>

---

## 📋 Informações sobre o Projeto

Este projeto foi desenvolvido como exercício prático de **Programação Orientada a Objetos** em Java, implementando uma calculadora com arquitetura bem estruturada e seguindo boas práticas de desenvolvimento back-end.

### 🎯 Objetivos de Aprendizado
- ✅ Aplicar conceitos fundamentais de POO
- ✅ Implementar separação de responsabilidades
- ✅ Praticar tratamento de exceções
- ✅ Estruturar projeto profissionalmente

---

## ⚡ Funcionalidades

<div align="center">
  <table>
    <tr>
      <td align="center">➕<br><b>Soma</b></td>
      <td align="center">➖<br><b>Subtração</b></td>
      <td align="center">✖️<br><b>Multiplicação</b></td>
    </tr>
    <tr>
      <td align="center">➗<br><b>Divisão</b></td>
      <td align="center">🔢<br><b>Potência</b></td>
      <td align="center">√<br><b>Raiz Quadrada</b></td>
    </tr>
  </table>
</div>

### 🛡️ Recursos Avançados
- **Validação de Entrada**: Previne erros de digitação
- **Tratamento de Exceções**: Divisão por zero e raiz de números negativos
- **Interface Intuitiva**: Menu interativo e user-friendly
- **Arquitetura Limpa**: Código organizado e fácil de manter

---

## 🎨 Conceitos de POO 

<details>
<summary><b>🔒 Encapsulamento</b></summary>

- Atributos privados com controle de acesso
- Métodos públicos para interação segura
- Getters e setters apropriados

</details>

<details>
<summary><b>🔗 Composição</b></summary>

- `CalculadoraService` **possui uma** `Calculadora`
- `CalculadoraService` **possui um** `ValidadorEntrada`
- Relacionamento "tem-um" entre classes

</details>

<details>
<summary><b>📋 Separação de Responsabilidades</b></summary>

- **Calculadora**: Operações matemáticas puras
- **Service**: Coordenação e fluxo de trabalho
- **Util**: Funcionalidades auxiliares
- **Main**: Interface com usuário

</details>

<details>
<summary><b>⚠️ Tratamento de Exceções</b></summary>

- `ArithmeticException`: Divisão por zero
- `IllegalArgumentException`: Operações inválidas
- `InputMismatchException`: Entrada incorreta

</details>

---

## 🚀 Como Executar

### 📋 Requisitos
- ☕ **Java 8+** instalado
- 💻 **IDE** (IntelliJ IDEA, Eclipse, VS Code) ou terminal

### 🏃‍♂️ Execução Rápida

**Via IDE:**
```bash
1. Clone o repositório
2. Abra o projeto na IDE
3. Execute Main.java
4. Calcule