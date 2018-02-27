/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dao;

import alquilervehiculos.mvc.modelo.dominio.Alquiler;
import alquilervehiculos.mvc.modelo.dominio.Cliente;
import alquilervehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author lol
 */
public class Alquileres {

    private final int MAX_ALQUILERES = 20;
    private Alquiler[] alquileres;
    private final String FICHERO_ALQUILERES = "datos/alquileres.dat";

    public Alquileres() {
        alquileres = new Alquiler[MAX_ALQUILERES];
    }

    public Alquiler[] getAlquileres() {
        return alquileres.clone();
    }

    public void leerAlquielres() {
        File fichero = new File(FICHERO_ALQUILERES);
        ObjectInputStream entrada;
        try {
            entrada = new ObjectInputStream(new FileInputStream(fichero));
            try {
                alquileres = (Alquiler[]) entrada.readObject();
                entrada.close();
                System.out.println("Fichero alauileres leido.");
            } catch (ClassNotFoundException e) {
                System.out.println("Clase no encontrada.");
            } catch (IOException e) {
                System.out.println("Error I/O");
            }
        } catch (IOException e) {
            System.out.println("No puede abrirse el fichero.");
        }
    }
    
    public void escribirAlquileres() {
        File fichero = new File(FICHERO_ALQUILERES);
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(fichero));
            salida.close();
            System.out.println("Fichero escrito correctamente.");
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado.");
        } catch (IOException e) {
            System.out.println("Error IO.");
        }
    }

    public void abrir(Cliente cliente, Vehiculo vehiculo) {
        int indice = buscarPrimerIndiceLibreComprobandoExistenciaOtroAbierto(vehiculo);
        if (indiceNoSuperaTamano(indice)) {
            alquileres[indice] = new Alquiler(cliente, vehiculo);
        } else {
            throw new ExcepcionAlquilerVehiculos("No hay espacio disponible.");
        }
    }

    public void cerrar(Vehiculo vehiculo) {
        int indice = buscarAlquilerAbierto(vehiculo);
        if (indiceNoSuperaTamano(indice)) {
            alquileres[indice].close();
        } else {
            throw new ExcepcionAlquilerVehiculos("Alquiler no encontrado.");
        }
    }

    private int buscarPrimerIndiceLibreComprobandoExistenciaOtroAbierto(Vehiculo vehiculo) {
        int indice = 0;
        boolean espacioEncontrado = false;
        while (indiceNoSuperaTamano(indice) && !espacioEncontrado) {
            if (alquileres[indice] == null) {
                espacioEncontrado = true;
            } else if (alquileres[indice].getVehiculo().getMatricula().equals(vehiculo.getMatricula())
                    && !alquileres[indice].getVehiculo().getDisponible()) {
                throw new ExcepcionAlquilerVehiculos("Ya existe un trabajo abierto para este vehículo");
            } else {
                indice++;
            }
        }
        return indice;
    }

    private boolean indiceNoSuperaTamano(int indice) {
        return indice < alquileres.length;
    }

    public int buscarAlquilerAbierto(Vehiculo vehiculo) {
        int indice = 0;
        boolean alquilerEncontrado = false;
        while (indiceNoSuperaTamano(indice) && !alquilerEncontrado) {
            if (alquileres[indice] != null && alquileres[indice].getVehiculo().getMatricula().equals(vehiculo.getMatricula()) && alquileres[indice].getEstadoAlquiler() == "ABIERTO") {
                alquilerEncontrado = true;
            } else {
                indice++;
            }
        }
        return indice;
    }

}
