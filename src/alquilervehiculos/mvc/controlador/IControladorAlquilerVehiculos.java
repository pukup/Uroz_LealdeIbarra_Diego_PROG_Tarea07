/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.controlador;

import alquilervehiculos.mvc.modelo.dominio.Alquiler;
import alquilervehiculos.mvc.modelo.dominio.Cliente;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

/**
 *
 * @author lol
 */
public interface IControladorAlquilerVehiculos {

    void abrirAlquiler(Cliente cliente, Vehiculo turismo);

    void anadirCliente(Cliente cliente);

    void anadirVehiculo(Vehiculo turismo);

    void borrarCliente(String dni);

    void borrarVehiculo(String matricula);

    Cliente buscarCliente(String dni);

    Vehiculo buscarVehiculo(String matricula);

    void cerrarAlquiler(Vehiculo turismo);

    void comenzar();
    
    void salir();

    Alquiler[] obtenerAlquileres();

    Cliente[] obtenerClientes();

    Vehiculo[] obtenerTurismos();
    
}
