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
public class Paramedico {
    String Nombre;
    int Edad;
    int ID;
    String Ranking;
    String Complejo_asignado;

    public Paramedico() {
    }

    public Paramedico(String Nombre, int Edad, int ID, String Ranking, String Complejo_asignado) {
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.ID = ID;
        this.Ranking = Ranking;
        this.Complejo_asignado = Complejo_asignado;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRanking() {
        return Ranking;
    }

    public void setRanking(String Ranking) {
        this.Ranking = Ranking;
    }

    public String getComplejo_asignado() {
        return Complejo_asignado;
    }

    public void setComplejo_asignado(String Complejo_asignado) {
        this.Complejo_asignado = Complejo_asignado;
    }

    @Override
    public String toString() {
        return Nombre;
    }
}
