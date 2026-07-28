package com.vv.calidad;

/**
 * Operaciones aritmeticas basicas utilizadas para demostrar la ejecucion
 * automatica de pruebas unitarias dentro de un proceso de integracion continua.
 */
public class Calculadora {

    /**
     * Suma dos numeros enteros.
     *
     * @param a primer operando
     * @param b segundo operando
     * @return la suma de ambos operandos
     */
    public int sumar(int a, int b) {
        return a + b;
    }

    /**
     * Divide dos numeros enteros.
     *
     * @param dividendo numero que se divide
     * @param divisor   numero por el que se divide, distinto de cero
     * @return el cociente de la division entera
     * @throws IllegalArgumentException si el divisor es cero
     */
    public int dividir(int dividendo, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("El divisor no puede ser cero");
        }
        return dividendo / divisor;
    }

    /**
     * Determina si un numero es primo.
     *
     * @param numero valor a evaluar
     * @return {@code true} si el numero es primo
     */
    public boolean esPrimo(int numero) {
        if (numero < 2) {
            return false;
        }
        for (int divisor = 2; (long) divisor * divisor <= numero; divisor++) {
            if (numero % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Calcula el factorial de un numero no negativo.
     *
     * @param numero valor a evaluar, entre 0 y 20
     * @return el factorial del numero
     * @throws IllegalArgumentException si el numero es negativo o mayor que 20
     */
    public long factorial(int numero) {
        if (numero < 0 || numero > 20) {
            throw new IllegalArgumentException("El numero debe estar entre 0 y 20");
        }
        long resultado = 1L;
        for (int i = 2; i <= numero; i++) {
            resultado *= i;
        }
        return resultado;
    }
}
