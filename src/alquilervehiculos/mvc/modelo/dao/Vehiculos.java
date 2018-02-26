/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dao;

import alquilervehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

/**
 *
 * @author lol
 */
public class Vehiculos {

    private Vehiculo[] vehiculos;
    private final int MAX_TURISMOS = 20;

    public Vehiculos() {
        vehiculos = new Vehiculo[MAX_TURISMOS];
    }

    public Vehiculo[] getVehiculos() {
        return vehiculos.clone();
    }

    public Vehiculo buscar(String matricula) {
        int indice = buscarIndiceVehiculo(matricula);
        if (indiceNoSuperaTamano(indice)) {
            return vehiculos[indice];
        } else {
            return null;
        }
    }

    public void anadir(Vehiculo vehiculo) {
        int indice = buscarPrimerIndiceLibreComprobandoExistencia(vehiculo);
        if (indiceNoSuperaTamano(indice)) {
            vehiculos[indice] = vehiculo;
        } else {
            throw new ExcepcionAlquilerVehiculos("Array de turismos sin espacio.");
        }
    }

    public void borrar(String matricula) {
        int indice = buscarIndiceVehiculo(matricula);    
        if (indiceNoSuperaTamano(indice) && vehiculos[indice].getDisponible()) {
            desplazarUnaPosicionHaciaIzquierda(indice);
        } else {
            throw new ExcepcionAlquilerVehiculos("El turismo no está disponible.");
        }
    }

    private int buscarIndiceVehiculo(String matricula) {
        int indice = 0;
        boolean turismoEncontrado = false;
        while (indiceNoSuperaTamano(indice) && !turismoEncontrado) {
            if (vehiculos[indice] != null && vehiculos[indice].getMatricula().equals(matricula)) {
                turismoEncontrado = true;
            } else {
                indice++;
            }
        }
        return indice;
    }

    private boolean indiceNoSuperaTamano(int indice) {
        return indice < vehiculos.length;
    }

    private int buscarPrimerIndiceLibreComprobandoExistencia(Vehiculo turismo) {
        int indice = 0;
        boolean vehiculoEncontrado = false;
        while (indiceNoSuperaTamano(indice) && !vehiculoEncontrado) {
            if (vehiculos[indice] == null) {
                vehiculoEncontrado = true;
            } else if (vehiculos[indice].getMatricula().equals(turismo.getMatricula())) {
                throw new ExcepcionAlquilerVehiculos("La matrícula ya existe.");
            } else {
                indice++;
            }
        }
        return indice;
    }

    private void desplazarUnaPosicionHaciaIzquierda(int indice) {
        for (int i = indice; i < vehiculos.length - 1 && vehiculos[i] != null; i++) {
            vehiculos[i] = vehiculos[i + 1];
        }
    }

}
