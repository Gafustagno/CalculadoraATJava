package org.example;

public class CalculadoraComplexos {
    public static void main(String[] args) {
        NumeroComplexo numero1 = new NumeroComplexo(6, 5);
        NumeroComplexo numero2 = new NumeroComplexo(2, 1);

        System.out.println("Número 1: " + numero1);
        System.out.println("Número 2: " + numero2);

        numero1.adicionar(numero2);
        System.out.println("Soma: " + numero1);
    }
}
