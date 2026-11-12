# Calculadora em Java — POO

**Aluno:** Arthur Gabriel Solidonio Alves Da Silva  
**RA:** 0024440  
**Disciplina:** Programação Orientada a Objetos (POO)

## Sobre o trabalho

Neste trabalho, continuei a calculadora em Java iniciada no laboratório do dia 09/11. Mantive a estrutura usada na aula e completei as cinco operações pedidas pelo professor. Também ajustei os cálculos para a calculadora funcionar corretamente.

Meu nome completo e RA estão no título da janela, conforme pedido na atividade.

## Operações da calculadora

- Adição — `somar()`
- Subtração — `subtrair()`
- Multiplicação — `multiplicar()`
- Divisão — `dividir()`
- Potência — `potencia()`

A calculadora permite digitar números, usar vírgula ou ponto decimal, limpar a tela e calcular pelo botão `=`. O resultado aparece junto com a conta completa. Por exemplo, em uma multiplicação de 12 por 5, a tela mostra **12 × 5 = 60**. Também tem uma verificação para não permitir divisão por zero.

## Print da tela

![Calculadora em Java, com nome e RA no cabeçalho](Calculadora/prints/tela_calculadora.png)

O [print completo com o título da janela](Calculadora/prints/tela_calculadora_com_titulo.png) também está disponível para conferir o TITLE FORM.

## Como executar

É necessário ter o Java JDK instalado. No Windows, abra `Calculadora/executar.bat`.

Também é possível executar pelo terminal a partir da pasta principal do repositório:

```bash
cd Calculadora
javac -encoding UTF-8 -d build src/calculadora/Calculadora.java src/calculadora/Calc.java src/calculadora/TesteCalculadora.java
java -cp build calculadora.Calc
```

Para testar as cinco operações:

```bash
java -cp build calculadora.TesteCalculadora
```

## Arquivos

- [`src/calculadora/Calc.java`](Calculadora/src/calculadora/Calc.java) — tela e botões, continuando o código da aula.
- [`src/calculadora/Calculadora.java`](Calculadora/src/calculadora/Calculadora.java) — métodos das cinco operações.
- [`src/calculadora/TesteCalculadora.java`](Calculadora/src/calculadora/TesteCalculadora.java) — testes dos cálculos.
- [`prints/tela_calculadora.png`](Calculadora/prints/tela_calculadora.png) — print da calculadora funcionando.
[Ver a pasta completa da calculadora](Calculadora/).
