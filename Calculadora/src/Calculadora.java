/**
 * Classe de operações matemáticas do projeto de Programação Orientada a Objetos.
 * Aluno: Arthur Gabriel Solidonio Alves Da Silva | RA: 0024440
 * Continuação da classe Calculadora estudada anteriormente em POO.
 */
public class Calculadora {

    public double somar(double a, double b) {
        return a + b;
    }

    public double subtrair(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Não é possível dividir por zero.");
        }
        return a / b;
    }

    public double potencia(double base, double expoente) {
        return Math.pow(base, expoente);
    }
}
