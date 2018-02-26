/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dominio;

import alquilervehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author lol
 */
public class Alquiler {

//Atributos    
    private Date fecha;
    private int dias;
    private boolean alquilerAbierto;
    private final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private final int MS_DIA = 1000 * 60 * 60 * 24;
    private final double PRECIO_DIA = 30;
    private Vehiculo vehiculo;
    private Cliente cliente;

//Constructor    
    public Alquiler(Cliente cliente, Vehiculo vehiculo) {
        if (vehiculo.getDisponible()) {
            alquilerAbierto = true;
            setVehiculo(vehiculo);
            setCliente(cliente);
            fecha = new Date();
            dias = 0;               
        } else {
            throw new ExcepcionAlquilerVehiculos("Vehículo no disponible.");
        }
    }

//Constructor copia
    public Alquiler(Alquiler alquilerCopia) {
        vehiculo = alquilerCopia.getVehiculo();
        cliente = alquilerCopia.getCliente();
        dias = alquilerCopia.getDias();
        fecha = alquilerCopia.getDate();
        
    }

    private void setVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null) {
            this.vehiculo = vehiculo;
            vehiculo.setDisponible(false);
        } else {
            throw new ExcepcionAlquilerVehiculos("Error turismo.");
        }
    }
    
    private void setCliente(Cliente cliente) {
        if (cliente != null) {
            this.cliente = cliente;
            cliente.setAlquilerVigente(true);
        } else {
            throw new ExcepcionAlquilerVehiculos("Error cliente.");
        }
    }
//Métodos get    

    public Date getDate() {
        return fecha;
    }

    public int getDias() {
        return difDias();
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public double getPrecioDia() {
        return PRECIO_DIA;
    }

    public Cliente getCliente() {
        return new Cliente(cliente);
    }

    public double getPrecio() {
        return PRECIO_DIA * difDias() + vehiculo.getPrecioEspecifico();
    }

    public double getPrecio(Vehiculo turismo, int dias) {
        return PRECIO_DIA * dias + turismo.getDatosTecnicos().getCilindrada() / 100;
    }
    
    public String getEstadoAlquiler(){
        String mensaje = alquilerAbierto ? "ABIERTO":"CERRADO";
        return mensaje;
    }

//Método toString    
    public String toString() {
        return String.format("ALQUILER %s%n Fecha inicio: %s%n Días: %d%n %s Cliente: %s%n Precio: %f€%n", getEstadoAlquiler(), fecha.toString(), getDias(), vehiculo.getTipoMatricula(), cliente.getDni(), getPrecio());
    }

//Método cerrar alquiler   
    public void close() {         
        if (dias == 0) {
            dias = difDias();
            vehiculo.setDisponible(true);
            alquilerAbierto = false;
        } else {
            throw new ExcepcionAlquilerVehiculos("El alquiler está cerrado");
        }
    }

//Método diferencia de días    
    public int difDias() {
        long tiempoAlquiler = new Date().getTime() - getDate().getTime();
        long diasAlquiler = tiempoAlquiler / MS_DIA;
        if (diasAlquiler < 1) {
            return 1;
        } else {
            return (int) diasAlquiler;
        }

    }

}
