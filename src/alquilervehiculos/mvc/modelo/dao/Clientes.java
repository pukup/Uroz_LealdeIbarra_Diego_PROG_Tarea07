/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dao;

import alquilervehiculos.mvc.modelo.dominio.Cliente;
import alquilervehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

/**
 *
 * @author lol
 */
public class Clientes {

    private final int MAX_CLIENTES = 20;
    private Cliente[] clientes;

    public Clientes() {
        clientes = new Cliente[MAX_CLIENTES];
    }

    public Cliente[] getClientes() {
        return clientes.clone();
    }

    public Cliente buscar(String dni) {
        int posicion = buscarIndiceCliente(dni);
        if (indiceNoSuperaTamano(posicion)) {
            return new Cliente(clientes[posicion]);
        } else {
            return null;
        }
    }

    public void anadir(Cliente cliente) {
        int indice = buscarPrimerIndiceLibreComprobandoExistencia(cliente);
        if (indiceNoSuperaTamano(indice)) {                                       
            clientes[indice] = cliente;                                    
        } else {
            throw new ExcepcionAlquilerVehiculos("El array de clientes está lleno.");
        }
    }

    public void borrar(String dni) {
        int indice = buscarIndiceCliente(dni);
        if (indiceNoSuperaTamano(indice) && !clientes[indice].getAlquilerVigente()) {
            desplazarUnaPosicionHaciaIzquierda(indice);
        } else {
            throw new ExcepcionAlquilerVehiculos("El cliente no puede ser eliminado.");
        }
    }

    private int buscarIndiceCliente(String dni) {
        int indice = 0;
        boolean clienteEncontrado = false;
        while (indiceNoSuperaTamano(indice) && !clienteEncontrado) {
            if (clientes[indice] != null && clientes[indice].getDni().equals(dni)) {
                clienteEncontrado = true;
            } else {
                indice++;
            }
        }
        return indice;
    }

    private boolean indiceNoSuperaTamano(int indice) {
        return indice < clientes.length;
    }

    private int buscarPrimerIndiceLibreComprobandoExistencia(Cliente cliente) {
        int indice = 0;
        boolean clienteEncontrado = false;
        while (indiceNoSuperaTamano(indice) && !clienteEncontrado) {
            if (clientes[indice] == null) {
                clienteEncontrado = true;
            } else if (clientes[indice].getDni().equals(cliente.getDni())) {
                throw new ExcepcionAlquilerVehiculos("El cliente ya existe.");
            } else {
                indice++;
            }
        }
        return indice;
    }

    private void desplazarUnaPosicionHaciaIzquierda(int indice) {
        for (int i = indice; i < clientes.length - 1 && clientes[i] != null; i++) {
            clientes[i] = clientes[i + 1];
        }
    }

}
