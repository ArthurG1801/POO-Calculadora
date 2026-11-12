#!/bin/sh
set -e
cd "$(dirname "$0")"
mkdir -p build
javac -encoding UTF-8 -d build src/calculadora/Calculadora.java src/calculadora/Calc.java src/calculadora/TesteCalculadora.java
java -cp build calculadora.Calc
