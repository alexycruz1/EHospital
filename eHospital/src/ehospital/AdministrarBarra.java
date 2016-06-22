/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehospital;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 *
 * @author alexy
 */
public class AdministrarBarra extends Thread{
    private JProgressBar barra;
    private boolean avanzar;
    private boolean vive;

    public AdministrarBarra(JProgressBar barra) {
        this.barra = barra;
        avanzar = true;
        vive = true;
    }

    public JProgressBar getBarra() {
        return barra;
    }

    public void setBarra(JProgressBar barra) {
        this.barra = barra;
    }

    public boolean isAvanzar() {
        return avanzar;
    }

    public void setAvanzar(boolean avanzar) {
        this.avanzar = avanzar;
    }

    public boolean isVive() {
        return vive;
    }

    public void setVive(boolean vive) {
        this.vive = vive;
    }
    
    public void setValue(){
        barra.setValue(0);
    }
    
    @Override
    public void run(){
        while(vive){
            if (avanzar) {
                barra.setValue(barra.getValue() + 1);
                if (barra.getValue() == barra.getMaximum()) {
                    vive = false;
                }
                try{
                    Thread.sleep(0);
                } catch(InterruptedException ex){
                    
                }
            }
        }
    }
}
