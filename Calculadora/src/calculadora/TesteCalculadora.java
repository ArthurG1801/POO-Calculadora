package calculadora;

public class TesteCalculadora {
    private static int testes = 0;

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        conferir("Soma", calc.somar(12, 5), 17);
        conferir("Subtração", calc.subtrair(12, 5), 7);
        conferir("Multiplicação", calc.multiplicar(12, 5), 60);
        conferir("Divisão", calc.dividir(12, 5), 2.4);
        conferir("Potência", calc.potencia(2, 3), 8);
        conferir("Potência com expoente negativo", calc.potencia(2, -2), 0.25);
        conferir("Número decimal", calc.somar(2.5, 1.5), 4);
        boolean divisaoBloqueada = false;
        try {
            calc.dividir(3, 0);
        } catch (IllegalArgumentException esperado) {
            divisaoBloqueada = true;
        }
        if (!divisaoBloqueada) {
            throw new AssertionError("A divisão por zero deveria gerar erro.");
        }
        testes++;
        System.out.println("Divisão por zero: OK");
        System.out.println("Todos os " + testes + " testes passaram.");
    }

    private static void conferir(String nome, double resultado, double esperado) {
        if (Math.abs(resultado - esperado) > 0.0000001) {
            throw new AssertionError(nome + ": esperado " + esperado + ", mas foi " + resultado);
        }
        testes++;
        System.out.println(nome + ": OK");
    }
}
