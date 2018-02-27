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
public class DeCarga extends Vehiculo {
    
    private static final long serialVersionUID = 1L;
    
    public DeCarga(String matricula, String marca, String modelo, int cilindrada, int numeroPlazas, int pma) {
        super(matricula, marca, modelo, new DatosTecnicosVehiculo(cilindrada, numeroPlazas, pma));
    }

    public DeCarga(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {
        super(matricula, marca, modelo, datosTecnicos);
    }

    public DeCarga(Vehiculo vehiculo) {
        super(vehiculo);
    }
    
    public TipoVehiculo getTipoVehiculo(){
        return TipoVehiculo.DE_CARGA;
    }
    
    public double getPrecioEspecifico(){
        return getDatosTecnicos().getPma() / FACTOR_PMA;
    }
}
