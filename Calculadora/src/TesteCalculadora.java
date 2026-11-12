/** Testes simples, sem bibliotecas externas, para as cinco operações. */
public class TesteCalculadora {
    private static void verificar(String nome, double esperado, double atual) {
        if (Math.abs(esperado - atual) > 1e-9) {
            throw new AssertionError(nome + ": esperado " + esperado + ", obtido " + atual);
        }
        System.out.println("OK: " + nome + " = " + atual);
    }

    public static void main(String[] args) {
        Calculadora c = new Calculadora();
        verificar("Adição", 17, c.somar(12, 5));
        verificar("Subtração", 7, c.subtrair(12, 5));
        verificar("Multiplicação", 60, c.multiplicar(12, 5));
        verificar("Divisão", 2.4, c.dividir(12, 5));
        verificar("Potência", 248832, c.potencia(12, 5));

        boolean erroCorreto = false;
        try {
            c.dividir(12, 0);
        } catch (IllegalArgumentException ex) {
            erroCorreto = true;
            System.out.println("OK: divisão por zero bloqueada.");
        }
        if (!erroCorreto) throw new AssertionError("Faltou impedir divisão por zero.");
        System.out.println("TODOS OS TESTES PASSARAM!");
    }
}
