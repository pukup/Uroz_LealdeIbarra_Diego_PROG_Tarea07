/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dominio.vehiculo;

import java.io.Serializable;

/**
 *
 * @author lol
 */
public class Autobus extends Vehiculo {

    private static final long serialVersionUID = 1L;
        
    public Autobus(String matricula, String marca, String modelo, int cilindrada, int numeroPlazas, int pma) {
        super(matricula, marca, modelo, new DatosTecnicosVehiculo(cilindrada, numeroPlazas, pma));
    }

    public Autobus(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {
        super(matricula, marca, modelo, datosTecnicos);
    }

    public Autobus(Vehiculo vehiculo) {
        super(vehiculo);
    }

    public TipoVehiculo getTipoVehiculo() {
        return TipoVehiculo.AUTOBUS;
    }

    public double getPrecioEspecifico() {
        return getDatosTecnicos().getPma() / FACTOR_PMA;
    }
}
