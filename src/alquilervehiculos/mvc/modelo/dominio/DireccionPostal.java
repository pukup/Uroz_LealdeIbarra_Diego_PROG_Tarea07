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
public class DireccionPostal implements Serializable{

    private String calle, localidad, codigoPostal;
    private static final long serialVersionUID = 1L;

    public DireccionPostal(String calle, String localidad, String codigoPostal) {

        setCalle(calle);
        setLocalidad(localidad);
        setCodigoPostal(codigoPostal);
    }

    public DireccionPostal(DireccionPostal direccionCopia) {
        calle = direccionCopia.getCalle();
        localidad = direccionCopia.getLocalidad();
        codigoPostal = direccionCopia.getCodigoPostal();
    }

    private void setCalle(String calle) {
        if (calle != null && !calle.equals("")) {
            this.calle = calle;
        } else {
            throw new ExcepcionAlquilerVehiculos("Formato calle incorrecto.");
        }
    }

    private void setLocalidad(String localidad) {
        if (localidad != null && !localidad.equals("")) {
            this.localidad = localidad;
        } else {
            throw new ExcepcionAlquilerVehiculos("Formato localidad incorrecto.");
        }
    }

    private void setCodigoPostal(String codigoPostal) {
        if (compruebaCodigoPostal(codigoPostal)) {
            this.codigoPostal = codigoPostal;
        } else {
            throw new ExcepcionAlquilerVehiculos("Formato código postal incorrecto.");
        }
    }

    public String getCalle() {
        return calle;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String toString() {
        return String.format("Calle: %s%n Localidad: %s%n Código postal: %s%n", calle, localidad, codigoPostal);
    }

    private boolean compruebaCodigoPostal(String codigoPostal) {
        Pattern regex = Pattern.compile("[0-9]{5}");
        Matcher matcher = regex.matcher(codigoPostal);
        return matcher.matches();
    }

}
