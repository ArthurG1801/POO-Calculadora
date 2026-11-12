package calculadora;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/** Continuação da calculadora feita na aula de 09/11. */
public class Calc {

    private JFrame frame;
    private JTextField JTFResultado;
    private JLabel tipoConta;
    private JLabel contaCompleta;

    private final Calculadora calculadora = new Calculadora();
    private Double valor1 = null;
    private String op = "";
    private boolean iniciarNovoNumero = true;
    private final DecimalFormat formato;

    private static final String ALUNO = "ARTHUR GABRIEL SOLIDONIO ALVES DA SILVA";
    private static final String RA = "0024440";
    private static final Color FUNDO = new Color(244, 247, 252);
    private static final Color AZUL = new Color(28, 47, 77);
    private static final Color VERDE = new Color(0, 139, 103);

    /** Inicia a aplicação, como no código visto no laboratório. */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    Calc window = new Calc();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /** Cria a aplicação. */
    public Calc() {
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols(new Locale("pt", "BR"));
        formato = new DecimalFormat("0.##########", simbolos);
        formato.setGroupingUsed(false);
        initialize();
    }

    /** Monta os elementos da janela, seguindo a estrutura da aula. */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("CALCULADORA POO - " + ALUNO + " - RA: " + RA);
        frame.setBounds(100, 100, 1040, 735);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(FUNDO);

        JPanel cabecalho = new JPanel(null);
        cabecalho.setBounds(0, 0, 1040, 98);
        cabecalho.setBackground(AZUL);
        frame.getContentPane().add(cabecalho);

        JLabel titulo = new JLabel("CALCULADORA POO");
        titulo.setFont(new Font("Arial", Font.BOLD, 26));
        titulo.setForeground(Color.WHITE);
        titulo.setBounds(42, 12, 620, 35);
        cabecalho.add(titulo);

        JLabel aluno = new JLabel("Aluno: Arthur Gabriel Solidonio Alves Da Silva  |  RA: 0024440");
        aluno.setFont(new Font("Arial", Font.PLAIN, 17));
        aluno.setForeground(new Color(213, 228, 246));
        aluno.setBounds(43, 52, 940, 27);
        cabecalho.add(aluno);

        JLabel legenda = new JLabel("Digite os números e escolha uma operação:");
        legenda.setFont(new Font("Arial", Font.BOLD, 15));
        legenda.setForeground(AZUL);
        legenda.setBounds(54, 109, 900, 23);
        frame.getContentPane().add(legenda);

        JTFResultado = new JTextField("0");
        JTFResultado.setHorizontalAlignment(SwingConstants.RIGHT);
        JTFResultado.setFont(new Font("Arial", Font.BOLD, 37));
        JTFResultado.setEditable(false);
        JTFResultado.setBackground(Color.WHITE);
        JTFResultado.setForeground(AZUL);
        JTFResultado.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(201, 213, 226)),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        JTFResultado.setBounds(53, 141, 930, 74);
        frame.getContentPane().add(JTFResultado);
        JTFResultado.setColumns(10);

        // Exibe o nome da operação e a conta realizada.
        JPanel painelConta = new JPanel(null);
        painelConta.setBounds(53, 226, 930, 66);
        painelConta.setBackground(new Color(232, 245, 241));
        painelConta.setBorder(BorderFactory.createLineBorder(new Color(174, 216, 203)));
        frame.getContentPane().add(painelConta);

        tipoConta = new JLabel("CONTA REALIZADA");
        tipoConta.setFont(new Font("Arial", Font.BOLD, 13));
        tipoConta.setForeground(VERDE);
        tipoConta.setBounds(18, 8, 875, 19);
        painelConta.add(tipoConta);

        contaCompleta = new JLabel("A conta completa vai aparecer aqui.");
        contaCompleta.setFont(new Font("Arial", Font.BOLD, 22));
        contaCompleta.setForeground(AZUL);
        contaCompleta.setBounds(18, 29, 875, 31);
        painelConta.add(contaCompleta);

        JLabel numeros = new JLabel("NÚMEROS");
        numeros.setBounds(57, 321, 385, 22);
        numeros.setFont(new Font("Arial", Font.BOLD, 13));
        numeros.setForeground(AZUL);
        frame.getContentPane().add(numeros);

        JLabel operacoes = new JLabel("OPERAÇÕES");
        operacoes.setBounds(493, 321, 470, 22);
        operacoes.setFont(new Font("Arial", Font.BOLD, 13));
        operacoes.setForeground(AZUL);
        frame.getContentPane().add(operacoes);

        // Botões numéricos: mesmas teclas do código feito no laboratório.
        adicionarNumero("7", 55, 356);
        adicionarNumero("8", 175, 356);
        adicionarNumero("9", 295, 356);
        adicionarNumero("4", 55, 417);
        adicionarNumero("5", 175, 417);
        adicionarNumero("6", 295, 417);
        adicionarNumero("1", 55, 478);
        adicionarNumero("2", 175, 478);
        adicionarNumero("3", 295, 478);
        adicionarNumero("0", 55, 539);
        adicionarDecimal(",", 175, 539);
        adicionarDecimal(".", 295, 539);

        // Cinco operações obrigatórias, incluindo potência.
        adicionarOperacao("+", "Soma", 491, 356);
        adicionarOperacao("−", "Subtracao", 613, 356);
        adicionarOperacao("×", "Multiplicacao", 735, 356);
        adicionarOperacao("÷", "Divisao", 857, 356);
        adicionarOperacao("xʸ", "Potencia", 491, 430);

        JButton btnIgual = criarBotao("=", 613, 430, 105, 57, VERDE, Color.WHITE);
        btnIgual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularResultado();
            }
        });

        JButton btnC = criarBotao("C", 735, 430, 105, 57, new Color(221, 228, 238), AZUL);
        btnC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpar();
            }
        });

        JButton btnApagar = criarBotao("⌫", 857, 430, 105, 57, new Color(221, 228, 238), AZUL);
        btnApagar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                apagarUltimo();
            }
        });

        JLabel dica = new JLabel("Exemplo: 12 + 5 = 17   |   2 xʸ 3 = 8");
        dica.setFont(new Font("Arial", Font.PLAIN, 14));
        dica.setForeground(new Color(87, 103, 123));
        dica.setBounds(492, 509, 480, 28);
        frame.getContentPane().add(dica);

        JLabel aviso = new JLabel("Divisão por zero e valores inválidos são tratados pelo programa.");
        aviso.setFont(new Font("Arial", Font.PLAIN, 13));
        aviso.setForeground(new Color(87, 103, 123));
        aviso.setBounds(492, 546, 500, 28);
        frame.getContentPane().add(aviso);

    }

    private JButton criarBotao(String texto, int x, int y, int largura, int altura, Color fundo, Color corTexto) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Arial", Font.BOLD, 20));
        botao.setBounds(x, y, largura, altura);
        botao.setBackground(fundo);
        botao.setForeground(corTexto);
        botao.setFocusPainted(false);
        botao.setOpaque(true);
        frame.getContentPane().add(botao);
        return botao;
    }

    private void adicionarNumero(String numero, int x, int y) {
        JButton botao = criarBotao(numero, x, y, 105, 53, Color.WHITE, AZUL);
        botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                digitar(numero);
            }
        });
    }

    private void adicionarDecimal(String separador, int x, int y) {
        JButton botao = criarBotao(separador, x, y, 105, 53, Color.WHITE, AZUL);
        botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                digitarDecimal();
            }
        });
    }

    private void adicionarOperacao(String simbolo, String operacao, int x, int y) {
        JButton botao = criarBotao(simbolo, x, y, 105, 57, new Color(223, 237, 248), AZUL);
        botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selecionarOperacao(operacao);
            }
        });
    }

    private void digitar(String numero) {
        String atual = JTFResultado.getText();
        if (iniciarNovoNumero || atual.equals("0") || atual.equals("Erro")) {
            if (valor1 == null) limparExplicacao();
            JTFResultado.setText(numero);
            iniciarNovoNumero = false;
        } else {
            JTFResultado.setText(atual + numero);
        }
    }

    private void digitarDecimal() {
        if (iniciarNovoNumero || JTFResultado.getText().equals("Erro")) {
            if (valor1 == null) limparExplicacao();
            JTFResultado.setText("0,");
            iniciarNovoNumero = false;
        } else if (!JTFResultado.getText().contains(",")) {
            JTFResultado.setText(JTFResultado.getText() + ",");
        }
    }

    private double lerResultado() {
        return Double.parseDouble(JTFResultado.getText().replace(',', '.'));
    }

    private void selecionarOperacao(String operacao) {
        try {
            // Se houver uma conta pendente e segundo valor, resolve antes da próxima operação.
            if (valor1 != null && !op.isEmpty() && !iniciarNovoNumero) {
                calcularResultado();
            }
            valor1 = lerResultado();
            op = operacao;
            iniciarNovoNumero = true;
            tipoConta.setText("OPERAÇÃO SELECIONADA: " + nomeOperacao(operacao));
            contaCompleta.setText(formato.format(valor1) + " " + simboloOperacao(operacao) + " ...");
        } catch (NumberFormatException erro) {
            mostrarErro("Digite um número válido.");
        }
    }

    private void calcularResultado() {
        if (valor1 == null || op.isEmpty()) {
            return;
        }
        try {
            double valor2 = lerResultado();
            double resultado;
            switch (op) {
                case "Soma":
                    resultado = calculadora.somar(valor1, valor2);
                    break;
                case "Subtracao":
                    resultado = calculadora.subtrair(valor1, valor2);
                    break;
                case "Multiplicacao":
                    resultado = calculadora.multiplicar(valor1, valor2);
                    break;
                case "Divisao":
                    resultado = calculadora.dividir(valor1, valor2);
                    break;
                case "Potencia":
                    resultado = calculadora.potencia(valor1, valor2);
                    break;
                default:
                    return;
            }
            if (!Double.isFinite(resultado)) {
                throw new ArithmeticException("O resultado não pode ser exibido.");
            }
            JTFResultado.setText(formato.format(resultado));
            String texto1 = formato.format(valor1);
            String texto2 = formato.format(valor2);
            String textoResultado = formato.format(resultado);
            tipoConta.setText("OPERAÇÃO REALIZADA: " + nomeOperacao(op));
            contaCompleta.setText(texto1 + " " + simboloOperacao(op) + " " + texto2 + " = " + textoResultado);
            valor1 = null;
            op = "";
            iniciarNovoNumero = true;
        } catch (IllegalArgumentException erro) {
            mostrarErro(erro.getMessage());
        } catch (ArithmeticException erro) {
            mostrarErro(erro.getMessage());
        }
    }

    private void apagarUltimo() {
        if (iniciarNovoNumero) {
            return;
        }
        String atual = JTFResultado.getText();
        JTFResultado.setText(atual.length() > 1 ? atual.substring(0, atual.length() - 1) : "0");
    }

    private void limpar() {
        JTFResultado.setText("0");
        valor1 = null;
        op = "";
        iniciarNovoNumero = true;
        limparExplicacao();
    }

    private void limparExplicacao() {
        tipoConta.setText("CONTA REALIZADA");
        contaCompleta.setText("A conta completa vai aparecer aqui.");
    }

    private String nomeOperacao(String operacao) {
        switch (operacao) {
            case "Soma": return "ADIÇÃO";
            case "Subtracao": return "SUBTRAÇÃO";
            case "Multiplicacao": return "MULTIPLICAÇÃO";
            case "Divisao": return "DIVISÃO";
            case "Potencia": return "POTÊNCIA";
            default: return "";
        }
    }

    private String simboloOperacao(String operacao) {
        switch (operacao) {
            case "Soma": return "+";
            case "Subtracao": return "−";
            case "Multiplicacao": return "×";
            case "Divisao": return "÷";
            case "Potencia": return "^";
            default: return "?";
        }
    }

    private void mostrarErro(String mensagem) {
        JOptionPane.showMessageDialog(frame, mensagem, "Erro na operação", JOptionPane.WARNING_MESSAGE);
        limpar();
    }
}
