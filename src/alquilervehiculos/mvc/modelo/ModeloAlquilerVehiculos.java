/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo;

import alquilervehiculos.mvc.modelo.dao.Alquileres;
import alquilervehiculos.mvc.modelo.dao.Clientes;
import alquilervehiculos.mvc.modelo.dao.Vehiculos;
import alquilervehiculos.mvc.modelo.dominio.Alquiler;
import alquilervehiculos.mvc.modelo.dominio.Cliente;
import alquilervehiculos.mvc.modelo.dominio.DireccionPostal;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.Autobus;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.Turismo;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

/**
 *
 * @author lol
 */
public class ModeloAlquilerVehiculos implements IModeloAlquilerVehiculos {

    private Vehiculos vehiculos;
    private Clientes clientes;
    private Alquileres alquileres;

//Constructor    
    public ModeloAlquilerVehiculos() {
        vehiculos = new Vehiculos();
        clientes = new Clientes();
        alquileres = new Alquileres();
    }

    @Override
    public void anadirCliente(Cliente cliente) {
        clientes.anadir(cliente);
    }

    @Override
    public void borrarCliente(String dni) {
        clientes.borrar(dni);
    }

    @Override
    public Cliente buscarCliente(String dni) {
        return clientes.buscar(dni);
    }

    @Override
    public Cliente[] obtenerClientes() {
        return clientes.getClientes();
    }

    @Override
    public void anadirVehiculo(Vehiculo vehiculo) {
        vehiculos.anadir(vehiculo);
    }

    @Override
    public void borrarVehiculo(String matricula) {
        vehiculos.borrar(matricula);
    }

    @Override
    public Vehiculo buscarVehiculo(String matricula) {
        return vehiculos.buscar(matricula);
    }

    @Override
    public Vehiculo[] obtenerVehiculos() {
        return vehiculos.getVehiculos();
    }

    @Override
    public void abrirAlquiler(Cliente cliente, Vehiculo vehiculo) {
        alquileres.abrir(cliente, vehiculo);
    }

    @Override
    public void cerrarAlquiler(Vehiculo vehiculo) {
        alquileres.cerrar(vehiculo);
    }

    @Override
    public Alquiler[] obtenerAlquileres() {
        return alquileres.getAlquileres();
    }

    @Override
    public void anadirDatosPrueba() {
        Cliente cliente0 = new Cliente("a", "00000000A", new DireccionPostal("a", "a", "00000"));
        Cliente cliente1 = new Cliente("z", "99999999Z", new DireccionPostal("z", "z", "00000"));

        Vehiculo turismo0 = new Turismo("0000BBB", "B", "B", 1, 1, 1);
        Vehiculo turismo1 = new Autobus("9999ZZZ", "Z", "Z", 500, 500, 500);

        anadirCliente(cliente0);
        anadirCliente(cliente1);

        anadirVehiculo(turismo0);
        anadirVehiculo(turismo1);
        
        abrirAlquiler(cliente0, turismo0);
        abrirAlquiler(cliente1, turismo1);
        
    }
}
