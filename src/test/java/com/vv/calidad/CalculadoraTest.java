package com.vv.calidad;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculadoraTest {

    private final Calculadora calculadora = new Calculadora();

    @Test
    @DisplayName("La suma de dos enteros positivos es correcta")
    void sumarDosPositivos() {
        assertEquals(12, calculadora.sumar(7, 5));
    }

    @Test
    @DisplayName("La suma admite numeros negativos")
    void sumarConNegativos() {
        assertEquals(-3, calculadora.sumar(-8, 5));
    }

    @Test
    @DisplayName("La division entera devuelve el cociente esperado")
    void dividirValoresValidos() {
        assertEquals(4, calculadora.dividir(20, 5));
    }

    @Test
    @DisplayName("Dividir para cero lanza IllegalArgumentException")
    void dividirParaCeroLanzaExcepcion() {
        IllegalArgumentException error =
                assertThrows(IllegalArgumentException.class, () -> calculadora.dividir(10, 0));
        assertEquals("El divisor no puede ser cero", error.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 97})
    @DisplayName("Los numeros primos se identifican correctamente")
    void reconocePrimos(int numero) {
        assertTrue(calculadora.esPrimo(numero));
    }

    @ParameterizedTest
    @ValueSource(ints = {-3, 0, 1, 4, 100})
    @DisplayName("Los numeros no primos se descartan correctamente")
    void descartaNoPrimos(int numero) {
        assertFalse(calculadora.esPrimo(numero));
    }

    @Test
    @DisplayName("El factorial de 0 es 1")
    void factorialDeCero() {
        assertEquals(1L, calculadora.factorial(0));
    }

    @Test
    @DisplayName("El factorial de 10 es 3628800")
    void factorialDeDiez() {
        assertEquals(3628800L, calculadora.factorial(10));
    }

    @Test
    @DisplayName("El factorial rechaza valores fuera de rango")
    void factorialFueraDeRango() {
        assertThrows(IllegalArgumentException.class, () -> calculadora.factorial(-1));
        assertThrows(IllegalArgumentException.class, () -> calculadora.factorial(21));
    }
}
