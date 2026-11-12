@echo off
cd /d "%~dp0"
if not exist build mkdir build
javac -encoding UTF-8 -d build src\calculadora\Calculadora.java src\calculadora\Calc.java src\calculadora\TesteCalculadora.java
if errorlevel 1 (
  echo Erro ao compilar. Verifique se o Java JDK esta instalado.
  pause
  exit /b 1
)
java -cp build calculadora.Calc
