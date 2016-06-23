/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehospital;

import javax.swing.JOptionPane;

/**
 *
 * @author Alexy jr
 */
public class Hilo extends Thread{
    double Tiempo;
    String Casa;
    boolean Vive;

    public Hilo(double Tiempo, String Casa, boolean Vive) {
        this.Tiempo = Tiempo;
        this.Casa = Casa;
        this.Vive = Vive;
    }
    
    @Override
    public void run() {
        try {
            this.verificar(Tiempo);
            JOptionPane.showMessageDialog(null,"Emergencia terminada en " + Casa);
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
