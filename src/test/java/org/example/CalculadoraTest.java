package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private Calculadora calculadora = new Calculadora();
    @Test
    void suma() {
        assertEquals(5, calculadora.suma(2, 3));
    }

    @Test
    void resta() {
        assertEquals(1, calculadora.resta(5, 4));
    }

    @Test
    void multiplicacion() {
        assertEquals(6, calculadora.multiplicacion(2, 3));
    }

    @Test
    void division() {
        assertEquals(2, calculadora.division(6, 3));
    }
    @Test
    void divisionPorCero(){
        assertThrows(IllegalArgumentException.class, () -> calculadora.division(6, 0));

    }
}