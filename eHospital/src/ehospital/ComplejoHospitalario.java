/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehospital;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Alexy jr
 */
public class ComplejoHospitalario implements Serializable{
    String Nombre;
    String Direccion;
    int Capacidad_paramedicos;
    int Capacidad_ambulancias;
    String Ranking_emergencias;
    ArrayList<Paramedico> paramedicos = new ArrayList();
    ArrayList<Ambulancia> ambulancias = new ArrayList();

    public ComplejoHospitalario() {
    }

    public ComplejoHospitalario(String Nombre, String Direccion, int Capacidad_paramedicos, int Capacidad_ambulancias, String Ranking_emergencias) {
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Capacidad_paramedicos = Capacidad_paramedicos;
        this.Capacidad_ambulancias = Capacidad_ambulancias;
        this.Ranking_emergencias = Ranking_emergencias;
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

    public int getCapacidad_paramedicos() {
        return Capacidad_paramedicos;
    }

    public void setCapacidad_paramedicos(int Capacidad_paramedicos) {
        this.Capacidad_paramedicos = Capacidad_paramedicos;
    }

    public int getCapacidad_ambulancias() {
        return Capacidad_ambulancias;
    }

    public void setCapacidad_ambulancias(int Capacidad_ambulancias) {
        this.Capacidad_ambulancias = Capacidad_ambulancias;
    }

    public String getRanking_emergencias() {
        return Ranking_emergencias;
    }

    public void setRanking_emergencias(String Ranking_emergencias) {
        this.Ranking_emergencias = Ranking_emergencias;
    }

    public ArrayList<Paramedico> getParamedicos() {
        return paramedicos;
    }

    public void setParamedicos(ArrayList<Paramedico> paramedicos) {
        this.paramedicos = paramedicos;
    }

    public ArrayList<Ambulancia> getAmbulancias() {
        return ambulancias;
    }

    public void setAmbulancias(ArrayList<Ambulancia> ambulancias) {
        this.ambulancias = ambulancias;
    }

    @Override
    public String toString() {
        return Nombre;
    }
}
