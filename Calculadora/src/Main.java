import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

/**
 * Interface gráfica da Calculadora POO usando Java Swing.
 * O título do formulário (JFrame) identifica o aluno e o RA.
 */
public class Main extends JFrame {
    private static final long serialVersionUID = 1L;

    private static final String ALUNO = "ARTHUR GABRIEL SOLIDONIO ALVES DA SILVA";
    private static final String RA = "0024440";
    private static final String TITULO = "CALCULADORA POO - " + ALUNO + " - RA: " + RA;

    private static final Color FUNDO = new Color(243, 247, 252);
    private static final Color AZUL = new Color(15, 27, 48);
    private static final Color TEXTO = new Color(32, 45, 67);
    private static final Color CINZA = new Color(107, 124, 146);
    private static final Color VERDE = new Color(11, 159, 119);
    private static final Color BORDA = new Color(219, 228, 239);

    private final Calculadora calculadora = new Calculadora();
    private final JTextField primeiroNumero = new JTextField("12");
    private final JTextField segundoNumero = new JTextField("5");
    private final JLabel resultado = new JLabel("—", SwingConstants.LEFT);
    private final JLabel operacaoAtual = new JLabel("AGUARDANDO OPERAÇÃO");
    private final JLabel mensagem = new JLabel("Informe os números e escolha uma das cinco operações.");

    public Main() {
        super(TITULO);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(montarTela());
        setSize(1100, 650);
        setLocationRelativeTo(null);
    }

    private JPanel montarTela() {
        JPanel raiz = new JPanel(new BorderLayout());
        raiz.setBackground(FUNDO);
        raiz.add(criarCabecalho(), BorderLayout.NORTH);

        JPanel corpo = new JPanel();
        corpo.setBackground(FUNDO);
        corpo.setBorder(new EmptyBorder(25, 44, 23, 44));
        corpo.setLayout(new BoxLayout(corpo, BoxLayout.Y_AXIS));

        corpo.add(criarEntrada());
        corpo.add(Box.createVerticalStrut(22));
        corpo.add(criarBotoes());
        corpo.add(Box.createVerticalStrut(23));
        corpo.add(criarResultado());
        corpo.add(Box.createVerticalGlue());
        corpo.add(criarRodape());

        raiz.add(corpo, BorderLayout.CENTER);
        return raiz;
    }

    private JPanel criarCabecalho() {
        JPanel cabecalho = new JPanel();
        cabecalho.setBackground(AZUL);
        cabecalho.setLayout(new BoxLayout(cabecalho, BoxLayout.Y_AXIS));
        cabecalho.setBorder(new EmptyBorder(24, 44, 23, 44));

        JLabel subtitulo = texto("PROGRAMAÇÃO ORIENTADA A OBJETOS  /  JAVA SWING", 12, Font.BOLD, new Color(111, 224, 189));
        JLabel titulo = texto("CALCULADORA POO", 30, Font.BOLD, Color.WHITE);
        JLabel identificacao = texto(ALUNO + "   |   RA: " + RA, 16, Font.PLAIN, new Color(214, 225, 240));
        subtitulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        titulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        identificacao.setAlignmentX(Component.LEFT_ALIGNMENT);
        cabecalho.add(subtitulo);
        cabecalho.add(Box.createVerticalStrut(9));
        cabecalho.add(titulo);
        cabecalho.add(Box.createVerticalStrut(7));
        cabecalho.add(identificacao);
        return cabecalho;
    }

    private JPanel criarEntrada() {
        JPanel cartao = painelBranco();
        cartao.setLayout(new BorderLayout(0, 18));
        cartao.setMaximumSize(new Dimension(Integer.MAX_VALUE, 164));

        JLabel titulo = texto("01  •  DIGITE OS VALORES", 14, Font.BOLD, TEXTO);
        cartao.add(titulo, BorderLayout.NORTH);

        JPanel campos = new JPanel(new GridLayout(1, 2, 18, 0));
        campos.setOpaque(false);
        campos.add(criarCampo("PRIMEIRO NÚMERO (A)", primeiroNumero));
        campos.add(criarCampo("SEGUNDO NÚMERO (B)", segundoNumero));
        cartao.add(campos, BorderLayout.CENTER);
        return cartao;
    }

    private JPanel criarCampo(String legenda, JTextField campo) {
        JPanel painel = new JPanel(new BorderLayout(0, 8));
        painel.setOpaque(false);
        painel.add(texto(legenda, 12, Font.BOLD, CINZA), BorderLayout.NORTH);
        campo.setFont(new Font("SansSerif", Font.BOLD, 22));
        campo.setForeground(TEXTO);
        campo.setBackground(Color.WHITE);
        campo.setCaretColor(VERDE);
        campo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDA, 1, true),
                new EmptyBorder(8, 14, 8, 14)));
        campo.setPreferredSize(new Dimension(300, 48));
        campo.addActionListener((ActionEvent e) -> executar("somar"));
        painel.add(campo, BorderLayout.CENTER);
        return painel;
    }

    private JPanel criarBotoes() {
        JPanel bloco = new JPanel(new BorderLayout(0, 12));
        bloco.setOpaque(false);
        bloco.setAlignmentX(Component.LEFT_ALIGNMENT);
        bloco.setMaximumSize(new Dimension(Integer.MAX_VALUE, 94));
        bloco.add(texto("02  •  ESCOLHA UMA OPERAÇÃO", 14, Font.BOLD, TEXTO), BorderLayout.NORTH);
        JPanel grade = new JPanel(new GridLayout(1, 5, 12, 0));
        grade.setOpaque(false);
        adicionarBotao(grade, "+  ADIÇÃO", "somar");
        adicionarBotao(grade, "−  SUBTRAÇÃO", "subtrair");
        adicionarBotao(grade, "×  MULTIPLICAÇÃO", "multiplicar");
        adicionarBotao(grade, "÷  DIVISÃO", "dividir");
        adicionarBotao(grade, "xʸ  POTÊNCIA", "potencia");
        bloco.add(grade, BorderLayout.CENTER);
        return bloco;
    }

    private void adicionarBotao(JPanel grade, String titulo, String metodo) {
        JButton botao = new JButton(titulo);
        botao.setName("botao_" + metodo);
        botao.setFocusPainted(false);
        botao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        botao.setFont(new Font("SansSerif", Font.BOLD, 13));
        botao.setForeground(Color.WHITE);
        botao.setBackground(VERDE);
        botao.setOpaque(true);
        botao.setBorder(BorderFactory.createEmptyBorder(13, 5, 13, 5));
        botao.setMargin(new Insets(0, 0, 0, 0));
        botao.addActionListener((ActionEvent e) -> executar(metodo));
        grade.add(botao);
    }

    private JPanel criarResultado() {
        JPanel cartao = painelBranco();
        cartao.setLayout(new BorderLayout(0, 10));
        cartao.setMaximumSize(new Dimension(Integer.MAX_VALUE, 165));
        cartao.add(texto("03  •  RESULTADO", 14, Font.BOLD, TEXTO), BorderLayout.NORTH);

        JPanel area = new JPanel(new BorderLayout(12, 0));
        area.setOpaque(false);
        JPanel lado = new JPanel();
        lado.setOpaque(false);
        lado.setLayout(new BoxLayout(lado, BoxLayout.Y_AXIS));
        operacaoAtual.setFont(new Font("SansSerif", Font.BOLD, 13));
        operacaoAtual.setForeground(VERDE);
        resultado.setFont(new Font("SansSerif", Font.BOLD, 38));
        resultado.setForeground(AZUL);
        mensagem.setFont(new Font("SansSerif", Font.PLAIN, 12));
        mensagem.setForeground(CINZA);
        lado.add(operacaoAtual);
        lado.add(Box.createVerticalStrut(5));
        lado.add(resultado);
        lado.add(Box.createVerticalStrut(4));
        lado.add(mensagem);
        area.add(lado, BorderLayout.CENTER);

        JButton limpar = new JButton("LIMPAR");
        limpar.setFont(new Font("SansSerif", Font.BOLD, 12));
        limpar.setBackground(new Color(233, 239, 247));
        limpar.setForeground(TEXTO);
        limpar.setFocusPainted(false);
        limpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        limpar.setBorder(new EmptyBorder(12, 19, 12, 19));
        limpar.addActionListener(e -> limpar());
        JPanel painelLimpar = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 12));
        painelLimpar.setOpaque(false);
        painelLimpar.add(limpar);
        area.add(painelLimpar, BorderLayout.EAST);
        cartao.add(area, BorderLayout.CENTER);
        return cartao;
    }

    private JPanel criarRodape() {
        JPanel rodape = new JPanel(new BorderLayout());
        rodape.setOpaque(false);
        rodape.setAlignmentX(Component.LEFT_ALIGNMENT);
        rodape.setMaximumSize(new Dimension(Integer.MAX_VALUE, 28));
        rodape.add(texto("MÉTODOS: somar()  •  subtrair()  •  multiplicar()  •  dividir()  •  potencia()", 12, Font.PLAIN, CINZA), BorderLayout.WEST);
        rodape.add(texto("POO  /  RA: " + RA, 12, Font.BOLD, CINZA), BorderLayout.EAST);
        return rodape;
    }

    private JPanel painelBranco() {
        JPanel painel = new JPanel();
        painel.setBackground(Color.WHITE);
        painel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDA, 1, true),
                new EmptyBorder(18, 23, 18, 23)));
        painel.setAlignmentX(Component.LEFT_ALIGNMENT);
        return painel;
    }

    private JLabel texto(String valor, int tamanho, int estilo, Color cor) {
        JLabel label = new JLabel(valor);
        label.setFont(new Font("SansSerif", estilo, tamanho));
        label.setForeground(cor);
        return label;
    }

    private double lerValor(JTextField campo) {
        String conteudo = campo.getText().trim().replace(',', '.');
        double valor = Double.parseDouble(conteudo);
        if (!Double.isFinite(valor)) {
            throw new NumberFormatException("Número não finito.");
        }
        return valor;
    }

    void executar(String metodo) {
        try {
            double a = lerValor(primeiroNumero);
            double b = lerValor(segundoNumero);
            double calculo;
            String simbolo;
            String nome;
            switch (metodo) {
                case "somar":
                    calculo = calculadora.somar(a, b);
                    simbolo = "+";
                    nome = "ADIÇÃO";
                    break;
                case "subtrair":
                    calculo = calculadora.subtrair(a, b);
                    simbolo = "−";
                    nome = "SUBTRAÇÃO";
                    break;
                case "multiplicar":
                    calculo = calculadora.multiplicar(a, b);
                    simbolo = "×";
                    nome = "MULTIPLICAÇÃO";
                    break;
                case "dividir":
                    calculo = calculadora.dividir(a, b);
                    simbolo = "÷";
                    nome = "DIVISÃO";
                    break;
                case "potencia":
                    calculo = calculadora.potencia(a, b);
                    simbolo = "^";
                    nome = "POTÊNCIA";
                    break;
                default:
                    throw new IllegalArgumentException("Operação desconhecida.");
            }
            if (!Double.isFinite(calculo)) {
                throw new ArithmeticException("O resultado é grande demais para exibir.");
            }
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols(new Locale("pt", "BR"));
            DecimalFormat formatador = new DecimalFormat("0.##########", simbolos);
            operacaoAtual.setText(nome);
            resultado.setText(formatador.format(calculo));
            mensagem.setText(formatador.format(a) + " " + simbolo + " " + formatador.format(b) + " = " + formatador.format(calculo));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite dois números válidos (exemplo: 12 ou 2,5).", "Entrada inválida", JOptionPane.WARNING_MESSAGE);
        } catch (IllegalArgumentException | ArithmeticException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Não foi possível calcular", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void limpar() {
        primeiroNumero.setText("");
        segundoNumero.setText("");
        operacaoAtual.setText("AGUARDANDO OPERAÇÃO");
        resultado.setText("—");
        mensagem.setText("Informe os números e escolha uma das cinco operações.");
        primeiroNumero.requestFocusInWindow();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
            // Mantém o estilo padrão quando o sistema não oferece outro.
        }
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
