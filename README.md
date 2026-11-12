# Calculadora em Java — POO

**Aluno:** Arthur Gabriel Solidonio Alves Da Silva  
**RA:** 0024440  
**Disciplina:** Programação Orientada a Objetos (POO)

## Sobre o trabalho

Neste trabalho, fiz uma calculadora em Java para colocar em prática os métodos que estudamos em POO. Organizei as contas na classe `Calculadora` e usei Java Swing para montar uma tela onde dá para digitar dois números e escolher a operação.

Além das quatro operações básicas, acrescentei a potência. Também coloquei meu nome completo e RA no título da janela, como foi pedido.

## Operações da calculadora

- **Adição:** `somar()`
- **Subtração:** `subtrair()`
- **Multiplicação:** `multiplicar()`
- **Divisão:** `dividir()`
- **Potência:** `potencia()`

O programa também verifica quando alguém tenta dividir por zero.

## Print da tela

![Tela da calculadora com as cinco operações, meu nome e RA](Calculadora/prints/tela_calculadora.png)

## Como executar

Para rodar o projeto é necessário ter o Java JDK instalado. No Windows, dá para abrir o arquivo `Calculadora/executar.bat`.

Outra opção é abrir o terminal na pasta do repositório e executar:

```bash
cd Calculadora
javac -encoding UTF-8 -d build src/Calculadora.java src/Main.java src/TesteCalculadora.java
java -cp build Main
```

Para testar as cinco operações:

```bash
java -cp build TesteCalculadora
```

## Arquivos do projeto

- [`Calculadora/src/Calculadora.java`](Calculadora/src/Calculadora.java) — métodos das operações.
- [`Calculadora/src/Main.java`](Calculadora/src/Main.java) — tela da calculadora e título com nome e RA.
- [`Calculadora/src/TesteCalculadora.java`](Calculadora/src/TesteCalculadora.java) — testes das operações.
- [`Calculadora/prints/tela_calculadora.png`](Calculadora/prints/tela_calculadora.png) — print do programa.

O código e os demais arquivos estão na [pasta Calculadora](Calculadora/).
