package com.vv.calidad;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase introducida intencionalmente con malas practicas y codigo duplicado
 * para comprobar el comportamiento del Quality Gate de SonarQube.
 */
public class ReporteVentas {

    public String estado = "ACTIVO";

    public double calcularTotalMensual(List<Double> ventas) {
        double total = 0;
        int contador = 0;
        List<Double> descartadas = new ArrayList<>();
        for (int i = 0; i < ventas.size(); i++) {
            Double valor = ventas.get(i);
            if (valor == null) {
                descartadas.add(valor);
                continue;
            }
            if (valor > 0) {
                if (valor < 1000000) {
                    if (valor != 0) {
                        total = total + valor * 1.12;
                        contador = contador + 1;
                    }
                }
            }
        }
        System.out.println("Ventas procesadas: " + contador);
        return total;
    }

    public double calcularTotalAnual(List<Double> ventas) {
        double total = 0;
        int contador = 0;
        List<Double> descartadas = new ArrayList<>();
        for (int i = 0; i < ventas.size(); i++) {
            Double valor = ventas.get(i);
            if (valor == null) {
                descartadas.add(valor);
                continue;
            }
            if (valor > 0) {
                if (valor < 1000000) {
                    if (valor != 0) {
                        total = total + valor * 1.12;
                        contador = contador + 1;
                    }
                }
            }
        }
        System.out.println("Ventas procesadas: " + contador);
        return total;
    }

    public boolean estadoEsActivo(String otroEstado) {
        return estado == otroEstado;
    }

    public String describir(String cliente) {
        String descripcion = null;
        try {
            descripcion = cliente.trim().toUpperCase();
        } catch (Exception e) {
        }
        int sinUsar = 42;
        return "Cliente: " + descripcion + " - Estado: " + "ACTIVO";
    }
}
