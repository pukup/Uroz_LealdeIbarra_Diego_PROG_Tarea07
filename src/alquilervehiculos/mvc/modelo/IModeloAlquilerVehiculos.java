/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo;

import alquilervehiculos.mvc.modelo.dominio.Alquiler;
import alquilervehiculos.mvc.modelo.dominio.Cliente;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

/**
 *
 * @author lol
 */
public interface IModeloAlquilerVehiculos {

    void abrirAlquiler(Cliente cliente, Vehiculo vehiculo);

    void anadirCliente(Cliente cliente);

    void anadirDatosPrueba();

    void anadirVehiculo(Vehiculo vehiculo);

    void borrarCliente(String dni);

    void borrarVehiculo(String matricula);

    Cliente buscarCliente(String dni);

    Vehiculo buscarVehiculo(String matricula);

    void cerrarAlquiler(Vehiculo vehiculo);

    Alquiler[] obtenerAlquileres();

    Cliente[] obtenerClientes();

    Vehiculo[] obtenerVehiculos();
    
}
