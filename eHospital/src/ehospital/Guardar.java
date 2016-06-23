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
public class Guardar implements Serializable{
    ArrayList<ComplejoHospitalario> complejos = new ArrayList();
    ArrayList<Ambulancia> ambulancias = new ArrayList();
    ArrayList<Paramedico> Paramedicos = new ArrayList();
    ArrayList<Domicilio> Domicilio = new ArrayList();
    ArrayList Ubicaciones =  new ArrayList();

    public void llenarcomplejos(ArrayList<ComplejoHospitalario> complejos_guardados) {
        for (int i = 0; i < complejos_guardados.size(); i++) {
            complejos.add(complejos_guardados.get(i));
        }
    }

    public void llenarambulancias(ArrayList<Ambulancia> ambulancias_guardadas) {
        for (int i = 0; i < ambulancias_guardadas.size(); i++) {
            ambulancias.add(ambulancias_guardadas.get(i));
        }
    }

    public void llenarParamedicos(ArrayList<Paramedico> paramedicos_guardados) {
        for (int i = 0; i < paramedicos_guardados.size(); i++) {
            Paramedicos.add(paramedicos_guardados.get(i));
        }
    }

    public void llenarDomicilios(ArrayList<Domicilio> domicilios_guardados) {
        for (int i = 0; i < domicilios_guardados.size(); i++) {
            Domicilio.add(domicilios_guardados.get(i));
        }
    }

    public void llenarUbicaciones(ArrayList ubicaciones_guardadas) {
        for (int i = 0; i < ubicaciones_guardadas.size(); i++) {
            Ubicaciones.add(ubicaciones_guardadas.get(i));
        }
    }
}
