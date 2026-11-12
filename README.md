# POO / Calculadora — Java Swing

**Aluno:** Arthur Gabriel Solidonio Alves Da Silva  
**RA:** 0024440  
**Disciplina:** Programação Orientada a Objetos (POO)

Este projeto dá continuidade à classe `Calculadora` trabalhada em exercícios anteriores de POO, que já possuía os métodos de soma, subtração, multiplicação e divisão. Foi incluído o método `potencia()` e criada uma interface gráfica usando Java Swing (`JFrame`).

## Funcionalidades obrigatórias

1. **Adição:** `somar(double a, double b)`
2. **Subtração:** `subtrair(double a, double b)`
3. **Multiplicação:** `multiplicar(double a, double b)`
4. **Divisão:** `dividir(double a, double b)` (impede divisão por zero)
5. **Potência:** `potencia(double base, double expoente)` (usa `Math.pow`)


## Print da tela

![Print real da calculadora Java Swing exibindo as cinco operações, nome e RA](prints/tela_calculadora.png)

## Como executar (JDK 8 ou superior)

Abra o terminal na pasta `Calculadora` e execute:

```bash
javac -encoding UTF-8 -d build src/Calculadora.java src/Main.java src/TesteCalculadora.java
java -cp build Main
```

No Windows, também é possível executar `executar.bat` (com Java JDK instalado e adicionado ao PATH).

## Como testar os cinco métodos

```bash
java -cp build TesteCalculadora
```

Os testes usam os valores `12` e `5` para conferir todas as operações e também verificam divisão por zero.

## Estrutura do projeto

```text
Calculadora/
├── src/
│   ├── Calculadora.java          # Métodos matemáticos
│   ├── Main.java                 # Tela Java Swing / TITLE FORM
│   └── TesteCalculadora.java     # Verificações das operações
├── prints/
│   └── tela_calculadora.png      # Captura real do programa
├── executar.bat
├── executar.sh
├── .gitignore
└── README.md




