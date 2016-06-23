/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehospital;

import java.io.Serializable;

/**
 *
 * @author Alexy jr
 */
public class Domicilio implements Serializable{
    String Nombre;
    String Direccion;

    public Domicilio() {
    }

    public Domicilio(String Nombre, String Direccion) {
        this.Nombre = Nombre;
        this.Direccion = Direccion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    @Override
    public String toString() {
        return Nombre;
    }
}
