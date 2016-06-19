/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehospital;

/**
 *
 * @author Alexy jr
 */
public class Ambulancia {
    String Numero_placa;
    int Año_vehiculo;
    int Velocidad_maxima;
    String Complejo_asignado;

    public Ambulancia() {
    }

    public Ambulancia(String Numero_placa, int Año_vehiculo, int Velocidad_maxima, String Complejo_asignado) {
        this.Numero_placa = Numero_placa;
        this.Año_vehiculo = Año_vehiculo;
        this.Velocidad_maxima = Velocidad_maxima;
        this.Complejo_asignado = Complejo_asignado;
    }

    public String getNumero_placa() {
        return Numero_placa;
    }

    public void setNumero_placa(String Numero_placa) {
        this.Numero_placa = Numero_placa;
    }

    public int getAño_vehiculo() {
        return Año_vehiculo;
    }

    public void setAño_vehiculo(int Año_vehiculo) {
        this.Año_vehiculo = Año_vehiculo;
    }

    public int getVelocidad_maxima() {
        return Velocidad_maxima;
    }

    public void setVelocidad_maxima(int Velocidad_maxima) {
        this.Velocidad_maxima = Velocidad_maxima;
    }

    public String getComplejo_asignado() {
        return Complejo_asignado;
    }

    public void setComplejo_asignado(String Complejo_asignado) {
        this.Complejo_asignado = Complejo_asignado;
    }

    @Override
    public String toString() {
        return "Ambulancia: " + Numero_placa;
    }
}
