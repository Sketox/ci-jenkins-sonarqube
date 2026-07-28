package com.vv.calidad;

import java.text.Normalizer;
import java.util.Locale;

/**
 * Utilidades de validacion de cadenas de texto empleadas como segundo modulo
 * del proyecto analizado por Jenkins y SonarQube.
 */
public class ValidadorTexto {

    private static final String VOCALES = "aeiou";

    /**
     * Elimina acentos, espacios y signos, y convierte el texto a minusculas.
     *
     * @param texto cadena de entrada, puede ser nula
     * @return la cadena normalizada; cadena vacia si la entrada es nula
     */
    public String normalizar(String texto) {
        if (texto == null) {
            return "";
        }
        String sinAcentos = Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        return sinAcentos.toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9]", "");
    }

    /**
     * Indica si una cadena es un palindromo, ignorando acentos, espacios,
     * signos de puntuacion y diferencias entre mayusculas y minusculas.
     *
     * @param texto cadena a evaluar
     * @return {@code true} si la cadena es un palindromo
     */
    public boolean esPalindromo(String texto) {
        String limpio = normalizar(texto);
        if (limpio.isEmpty()) {
            return false;
        }
        return limpio.contentEquals(new StringBuilder(limpio).reverse());
    }

    /**
     * Cuenta las vocales presentes en una cadena.
     *
     * @param texto cadena a evaluar, puede ser nula
     * @return numero de vocales encontradas
     */
    public int contarVocales(String texto) {
        String limpio = normalizar(texto);
        int total = 0;
        for (int i = 0; i < limpio.length(); i++) {
            if (VOCALES.indexOf(limpio.charAt(i)) >= 0) {
                total++;
            }
        }
        return total;
    }
}
