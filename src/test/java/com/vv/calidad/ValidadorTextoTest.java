package com.vv.calidad;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidadorTextoTest {

    private final ValidadorTexto validador = new ValidadorTexto();

    @Test
    @DisplayName("La normalizacion elimina acentos, espacios y signos")
    void normalizarTextoConAcentos() {
        assertEquals("anitalavalatina", validador.normalizar("Anita, lava la tina!"));
    }

    @Test
    @DisplayName("La normalizacion de un texto nulo devuelve cadena vacia")
    void normalizarTextoNulo() {
        assertEquals("", validador.normalizar(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Anita lava la tina", "reconocer", "Dabale arroz a la zorra el abad"})
    @DisplayName("Reconoce palindromos ignorando espacios y acentos")
    void reconocePalindromos(String texto) {
        assertTrue(validador.esPalindromo(texto));
    }

    @ParameterizedTest
    @ValueSource(strings = {"verificacion", "Jenkins", "SonarQube"})
    @DisplayName("Descarta cadenas que no son palindromos")
    void descartaNoPalindromos(String texto) {
        assertFalse(validador.esPalindromo(texto));
    }

    @Test
    @DisplayName("Una cadena vacia no se considera palindromo")
    void cadenaVaciaNoEsPalindromo() {
        assertFalse(validador.esPalindromo("   "));
    }

    @Test
    @DisplayName("Cuenta correctamente las vocales de una frase")
    void contarVocalesDeFrase() {
        assertEquals(6, validador.contarVocales("Jenkins y SonarQube"));
    }

    @Test
    @DisplayName("Cuenta cero vocales cuando el texto es nulo")
    void contarVocalesTextoNulo() {
        assertEquals(0, validador.contarVocales(null));
    }
}
