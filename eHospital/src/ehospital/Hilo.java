/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehospital;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexy jr
 */
public class Hilo extends Thread{
    double Tiempo;
    String Casa;
    boolean Vive;
    /*ArrayList<Paramedico> p;
     ArrayList<Paramedico> p2;*/

    public Hilo(double Tiempo, String Casa, boolean Vive/*, ArrayList<Paramedico> p, ArrayList<Paramedico> p2*/) {
        this.Tiempo = Tiempo;
        this.Casa = Casa;
        this.Vive = Vive;
        /*this.p = p;
        this.p2 = p2;*/
    }
    
    @Override
    public void run() {
        try {
            this.verificar(Tiempo);
            /*for (int i = 0; i < p2.size(); i++) {
                p.add(p2.get(i));
            }*/
            JOptionPane.showMessageDialog(null, "Emergencia terminada en " + Casa,
                    "OPERACION EXITOSA", JOptionPane.INFORMATION_MESSAGE);
            this.setVive(false);
        } catch (Exception e) {
        }
    }

    private void verificar(double segundos) {
        try {
            Thread.sleep((long) (segundos * 1000));
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public boolean isVive() {
        return Vive;
    }

    public void setVive(boolean Vive) {
        this.Vive = Vive;
    }
}
