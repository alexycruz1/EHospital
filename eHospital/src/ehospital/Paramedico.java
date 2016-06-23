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
public class Paramedico implements Comparable <Paramedico> , Serializable{
    String Nombre;
    int Edad;
    String ID;
    String Ranking;
    String Complejo_asignado;

    public Paramedico() {
    }

    public Paramedico(String Nombre, int Edad, String ID, String Ranking, String Complejo_asignado) {
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

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
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
    
    public boolean equals(Paramedico other){
        return this.getRanking().equals(other.getRanking());
    }
    
    @Override
    public int compareTo(Paramedico other){
        char este, otro;
        este = this.getRanking().charAt(0);
        otro = other.getRanking().charAt(0);
        
        if (this.equals(other)) {
            return 0;
        }else if (este > otro) {
            return 1;
        }else{
            return -1;
        }
    }

    @Override
    public String toString() {
        return Nombre + " : " + Complejo_asignado;
    }
}
