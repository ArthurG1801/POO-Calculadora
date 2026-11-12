@echo off
chcp 65001 >nul
if not exist build mkdir build
javac -encoding UTF-8 -d build src\Calculadora.java src\Main.java src\TesteCalculadora.java
if errorlevel 1 (
    echo Nao foi possivel compilar. Verifique se o JDK esta instalado.
    pause
    exit /b 1
)
java -cp build Main
