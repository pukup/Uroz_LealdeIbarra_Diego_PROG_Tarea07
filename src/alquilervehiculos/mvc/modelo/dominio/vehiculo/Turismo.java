/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dominio.vehiculo;

/**
 *
 * @author lol
 */
public class Turismo extends Vehiculo {
    
    public Turismo(String matricula, String marca, String modelo, int cilindrada, int numeroPlazas, int pma) {
        super(matricula, marca, modelo, new DatosTecnicosVehiculo(cilindrada, numeroPlazas, pma));
    }

    public Turismo(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {
        super(matricula, marca, modelo, datosTecnicos);
    }

    public Turismo(Vehiculo vehiculo) {
        super(vehiculo);
    }
    
    public TipoVehiculo getTipoVehiculo(){
        return TipoVehiculo.TURISMO;
    }
    
    public double getPrecioEspecifico(){
        return getDatosTecnicos().getCilindrada() / FACTOR_CILINDRADA + 1 * getDatosTecnicos().getNumeroPlazas();
    }
    
}
