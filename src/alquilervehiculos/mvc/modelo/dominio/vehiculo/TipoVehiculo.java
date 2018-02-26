/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dominio.vehiculo;

import alquilervehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import static alquilervehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo.values;

/**
 *
 * @author lol
 */
public enum TipoVehiculo {

    TURISMO("Turismo") {

        public Turismo getInstancia(String matricula, String marca, String modelo,
                DatosTecnicosVehiculo datosTecnicos) {
            return new Turismo(matricula, marca, modelo, datosTecnicos);
        }

    },
    DE_CARGA("DeCarga") {

        public DeCarga getInstancia(String matricula, String marca, String modelo,
                DatosTecnicosVehiculo datosTecnicos) {
            return new DeCarga(matricula, marca, modelo, datosTecnicos);
        }

    },
    AUTOBUS("Autobus") {

        public Autobus getInstancia(String matricula, String marca, String modelo,
                DatosTecnicosVehiculo datosTecnicos) {
            return new Autobus(matricula, marca, modelo, datosTecnicos);
        }

    };

    private String tipoVehiculo;

    private TipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public abstract Vehiculo getInstancia(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos);

    public String toString() {
        return tipoVehiculo;
    }

    public static TipoVehiculo getTipoVehiculoSegunOrdinal(int ordinal) {
        if (ordinalValido(ordinal)) {
            return values()[ordinal];
        } else {
            throw new ExcepcionAlquilerVehiculos("Tipo de vehículo inexsistente.");
        }
    }

    public static boolean ordinalValido(int ordinal) {
        return (ordinal >= 0 && ordinal <= values().length - 1);

    }
}
