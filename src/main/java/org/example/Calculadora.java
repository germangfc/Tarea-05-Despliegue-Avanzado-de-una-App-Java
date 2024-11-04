package org.example;

/**
 * Clase que implementa la calculadora
 */
public class Calculadora {

    /**
     * Suma dos enteros
     * @param a primer entero
     * @param b segundo entero
     * @return suma de a y b
     */
    public int suma (int a, int b) { return a + b; }

    /**
     * Resta dos enteros
     * @param a primer entero
     * @param b segundo entero
     * @return resta de a menos b
     */
    public int resta (int a, int b) { return a - b; }

    /**
     * Multiplica dos enteros
     * @param a primer entero
     * @param b segundo entero
     * @return producto de a y b
     */
    public int multiplicacion (int a, int b) { return a * b; }

    /**
     * Divide dos enteros
     * @param a primer entero
     * @param b segundo entero
     * @return división de a entre b
     * @throws IllegalArgumentException cuando b es cero
     */
    public int division (int a, int b) throws IllegalArgumentException {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        return a / b;
    }

}
