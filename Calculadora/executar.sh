#!/usr/bin/env sh
set -e
mkdir -p build
javac -encoding UTF-8 -d build src/Calculadora.java src/Main.java src/TesteCalculadora.java
java -cp build Main
