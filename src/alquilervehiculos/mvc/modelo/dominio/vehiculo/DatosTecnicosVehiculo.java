/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dominio.vehiculo;

import alquilervehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import java.io.Serializable;

/**
 *
 * @author lol
 */
public class DatosTecnicosVehiculo implements Serializable {

    private int cilindrada, numeroPlazas, pma;
    private static final long serialVersionUID = 1L;

    public DatosTecnicosVehiculo(int cilindrada, int numeroPlazas, int pma) {

        setCilindrada(cilindrada);
        setNumeroPlazas(numeroPlazas);
        setPma(pma);
    }

    public DatosTecnicosVehiculo(DatosTecnicosVehiculo datosTecnicos) {

        cilindrada = datosTecnicos.getCilindrada();
        numeroPlazas = datosTecnicos.getNumeroPlazas();
        pma = datosTecnicos.getPma();
    }

    private void setCilindrada(int cilindrada) {
        if (cilindrada > 0) {
            this.cilindrada = cilindrada;
        } else {
            throw new ExcepcionAlquilerVehiculos("Cilindrada no válida");
        }
    }

    private void setNumeroPlazas(int numeroPlazas) {
        if (numeroPlazas > 0) {
            this.numeroPlazas = numeroPlazas;
        } else {
            throw new ExcepcionAlquilerVehiculos("Plazas no válidas");
        }
    }

    private void setPma(int pma) {
        if (pma > 0) {
            this.pma = pma;
        } else {
            throw new ExcepcionAlquilerVehiculos("PMA no válido");
        }
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public int getNumeroPlazas() {
        return numeroPlazas;
    }

    public int getPma() {
        return pma;
    }

    public String toString() {
        return String.format("Cilindrada: %s%n Número de plazas: %s%n PMA: %s", cilindrada, numeroPlazas, pma);
    }
}
