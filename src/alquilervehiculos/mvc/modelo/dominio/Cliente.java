/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dominio;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lol
 */
public class Cliente implements Serializable {

// Atributos para la clase
    private static final long serialVersionUID = 1L;
    private String nombre, dni;
    private DireccionPostal direccion;
    private int identificador;
    private static int ultimoIdentificador = 0;
    private boolean alquilerVigente;

//Constructor
    public Cliente(String nombre, String dni, DireccionPostal direccion) {
        setNombre(nombre);
        setDni(dni);
        setDireccionPostal(direccion);
        setAlquilerVigente(false);
        ultimoIdentificador++;
        identificador = ultimoIdentificador;
    }

//Constructor copia    
    public Cliente(Cliente clienteCopia) {
        nombre = clienteCopia.getNombre();
        direccion = clienteCopia.getDireccion();
        dni = clienteCopia.getDni();
        alquilerVigente = clienteCopia.getAlquilerVigente();
        identificador = clienteCopia.getIdentificador();
    }

    public static void aumentarUltimoIdentificador(int cantidad) {
        if (cantidad > 0) {
            ultimoIdentificador += cantidad;
        } else {
            throw new ExcepcionAlquilerVehiculos("Sólo puedo aumentar el último identificador");
        }
    }

//Métodos set    
    private void setNombre(String nombre) {
        if (nombre != null && !nombre.equals("")) {
            this.nombre = nombre;
        } else {
            throw new ExcepcionAlquilerVehiculos("Nombre incorrecto.");
        }
    }

    private void setDni(String dni) {
        if (compruebaDni(dni)) {
            this.dni = dni;
        } else {
            throw new ExcepcionAlquilerVehiculos("DNI incorrecto.");
        }
    }

    private void setDireccionPostal(DireccionPostal direccion) {
        this.direccion = new DireccionPostal(direccion);
    }

    public void setAlquilerVigente(boolean alquilerVigente) {
        this.alquilerVigente = alquilerVigente;
    }

//Métodos get   
    public String getNombre() {
        return nombre;
    }

    public DireccionPostal getDireccion() {
        return new DireccionPostal(direccion);
    }

    public String getDni() {
        return dni;
    }

    public int getIdentificador() {
        return identificador;
    }

    public int getUltimoIdentificador() {
        return ultimoIdentificador;
    }

    public boolean getAlquilerVigente() {
        return alquilerVigente;
    }

//Método toString    
    public String toString() {
        return String.format("CLIENTE %s%n Nombre: %s%n Dni: %s%n Alquiler abierto: %s%n %s ", identificador, nombre, dni, alquilerVigente, direccion);
    }

//Métodos de validación    
    private boolean compruebaDni(String dni) {
        Pattern regex = Pattern.compile("[0-9]{8}[A-Z]{1}");
        Matcher matcher = regex.matcher(dni);
        return matcher.matches();
    }

}
