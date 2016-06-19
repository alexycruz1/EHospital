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
public class Emergencia {
    String Ranking;
    String Ubicacion;

    public Emergencia() {
    }

    public Emergencia(String Ranking, String Ubicacion) {
        this.Ranking = Ranking;
        this.Ubicacion = Ubicacion;
    }

    public String getRanking() {
        return Ranking;
    }

    public void setRanking(String Ranking) {
        this.Ranking = Ranking;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    @Override
    public String toString() {
        return "Emergencia{" + "Ranking=" + Ranking + ", Ubicacion=" + Ubicacion + '}';
    }
}
