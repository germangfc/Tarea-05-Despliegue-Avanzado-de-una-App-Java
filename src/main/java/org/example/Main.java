package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Calculadora JavaApp Proxy Inverso");

        var calculadora = new Calculadora();

        System.out.println("Suma: " + calculadora.suma(2, 3));
        System.out.println("Resta: " + calculadora.resta(5, 3));
        System.out.println("Multiplicación: " + calculadora.multiplicacion(4, 2));
        try {
            System.out.println("División: " + calculadora.division(10, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            System.out.println("División: " + calculadora.division(10, 0));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}