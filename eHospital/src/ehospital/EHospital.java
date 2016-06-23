/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehospital;

import java.awt.Component;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.swing.JOptionPane;
import org.graphstream.algorithm.Dijkstra;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author Alexy jr
 */
public class EHospital extends javax.swing.JFrame {

    /**
     * Creates new form EHospital
     */
    public EHospital() {
        initComponents();
        cargar();
        setLocationRelativeTo(this);

        Viewer viewer = graph.display(true);
        View view = viewer.getDefaultView();
        this.jp_mapa.add((Component) view);
    }

    public void ActualizarComplejos() {
        jcb_ambulancias_complejo.removeAllItems();
        jcb_paramedicos_complejos.removeAllItems();
        jcb_complejo_a_mapa.removeAllItems();
        jcb_ch_eliminar.removeAllItems();

        jcb_ubicaciones1.removeAllItems();
        jcb_ubicaciones2.removeAllItems();
        jcb_emergencia_domicilios.removeAllItems();
        jcb_domiclio_a_mapa.removeAllItems();

        for (int i = 0; i < Complejos.size(); i++) {
            jcb_ambulancias_complejo.addItem(Complejos.get(i));
            jcb_paramedicos_complejos.addItem(Complejos.get(i));
            jcb_complejo_a_mapa.addItem(Complejos.get(i));
            jcb_ch_eliminar.addItem(Complejos.get(i));
        }

        for (int i = 0; i < Ubicaciones.size(); i++) {
            jcb_ubicaciones1.addItem(Ubicaciones.get(i));
            jcb_ubicaciones2.addItem(Ubicaciones.get(i));
        }

        for (int i = 0; i < Domicilios.size(); i++) {
            jcb_emergencia_domicilios.addItem(Domicilios.get(i));
            jcb_domiclio_a_mapa.addItem(Domicilios.get(i));
        }
    }

    public void ActualizarParamedicos() {
        jcb_paramedicos_eliminar_transferir.removeAllItems();

        for (int i = 0; i < Paramedicos.size(); i++) {
            jcb_paramedicos_eliminar_transferir.addItem(Paramedicos.get(i));
        }
    }

    public void ActualizarAmbulancias() {
        jcb_ambulancias_eliminar_transferir.removeAllItems();

        for (int i = 0; i < Ambulancias.size(); i++) {
            jcb_ambulancias_eliminar_transferir.addItem(Ambulancias.get(i));
        }
    }

    private void guardar() {
        objeto = new Guardar();
        objeto.llenarcomplejos(Complejos);
        objeto.llenarParamedicos(Paramedicos);
        objeto.llenarambulancias(Ambulancias);
        objeto.llenarDomicilios(Domicilios);
        objeto.llenarUbicaciones(Ubicaciones);
        try {
            File archivo = null;
            try {
                archivo = new File("./Binary.AOC");
                FileOutputStream fo = new FileOutputStream(archivo);
                ObjectOutputStream oo = new ObjectOutputStream(fo);
                oo.writeObject(objeto);
                oo.close();
                fo.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "no se guardó correctamente");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "no se guardó correctamente");
        }

    }

    private void cargar() {
        try {
            File archivo = null;
            try {
                archivo = new File("./Binary.AOC");
                FileInputStream fo = new FileInputStream(archivo);
                ObjectInputStream oo = new ObjectInputStream(fo);
                objeto = (Guardar) oo.readObject();

                for (int i = 0; i < objeto.complejos.size(); i++) {
                    Complejos.add(objeto.complejos.get(i));
                }

                for (int i = 0; i < objeto.Paramedicos.size(); i++) {
                    Paramedicos.add(objeto.Paramedicos.get(i));
                }

                for (int i = 0; i < objeto.ambulancias.size(); i++) {
                    Ambulancias.add(objeto.ambulancias.get(i));
                }

                for (int i = 0; i < objeto.Domicilio.size(); i++) {
                    Domicilios.add(objeto.Domicilio.get(i));
                }

                for (int i = 0; i < objeto.Ubicaciones.size(); i++) {
                    Ubicaciones.add(objeto.Ubicaciones.get(i));
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Archivo no se encontro");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "no se cargo el archivo");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jd_mapa = new javax.swing.JDialog();
        jp_mapa = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtf_ch_nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        js_ch_cap_paramedicos = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        js_ch_cap_ambulancias = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jcb_ch_ranking = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jta_ch_direccion_complejo = new javax.swing.JTextArea();
        jb_construir_complejo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jtf_paramedicos_nombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtf_paramedicos_edad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtf_paramedicos_ID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jcb_paramedicos_ranking = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jcb_paramedicos_complejos = new javax.swing.JComboBox();
        jb_registrar_paramedico = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jtf_ambulancias_numero_placa = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtf_ambulancias_año = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jtf_ambulancias_velocidad = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jcb_ambulancias_complejo = new javax.swing.JComboBox();
        jb_registrar_ambulancia = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jcb_paramedicos_eliminar_transferir = new javax.swing.JComboBox();
        jb_despedir_paramedico = new javax.swing.JButton();
        jcb_ch_eliminar = new javax.swing.JComboBox();
        jb_eliminar_complejo = new javax.swing.JButton();
        jb_transferir_paramedico = new javax.swing.JButton();
        jcb_ambulancias_eliminar_transferir = new javax.swing.JComboBox();
        jb_eliminar_ambulancia = new javax.swing.JButton();
        jb_transferir_ambulancia = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jcb_ranking_emergencia = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        jcb_emergencia_domicilios = new javax.swing.JComboBox();
        jButton5 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jcb_complejo_a_mapa = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jtf_domicilio_nombre = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtf_domicilio_direccion = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jcb_ubicaciones1 = new javax.swing.JComboBox();
        jcb_ubicaciones2 = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jtf_distancia_arista = new javax.swing.JTextField();
        jcb_domiclio_a_mapa = new javax.swing.JComboBox();
        jButton6 = new javax.swing.JButton();

        javax.swing.GroupLayout jp_mapaLayout = new javax.swing.GroupLayout(jp_mapa);
        jp_mapa.setLayout(jp_mapaLayout);
        jp_mapaLayout.setHorizontalGroup(
            jp_mapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 757, Short.MAX_VALUE)
        );
        jp_mapaLayout.setVerticalGroup(
            jp_mapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 566, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jd_mapaLayout = new javax.swing.GroupLayout(jd_mapa.getContentPane());
        jd_mapa.getContentPane().setLayout(jd_mapaLayout);
        jd_mapaLayout.setHorizontalGroup(
            jd_mapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jd_mapaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_mapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jd_mapaLayout.setVerticalGroup(
            jd_mapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_mapaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_mapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("eHospital ©");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Nombre del complejo");

        jLabel2.setText("Capacidad de paramedicos");

        js_ch_cap_paramedicos.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        jLabel3.setText("Capacidad de ambulancias");

        js_ch_cap_ambulancias.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        jLabel4.setText("Ranking de emergencias a tratar");

        jcb_ch_ranking.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D" }));

        jLabel5.setText("Direccion del complejo");

        jta_ch_direccion_complejo.setColumns(20);
        jta_ch_direccion_complejo.setRows(5);
        jScrollPane1.setViewportView(jta_ch_direccion_complejo);

        jb_construir_complejo.setText("Construir complejo");
        jb_construir_complejo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_construir_complejoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcb_ch_ranking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addGap(39, 39, 39)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtf_ch_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(js_ch_cap_ambulancias, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(js_ch_cap_paramedicos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jb_construir_complejo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtf_ch_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(js_ch_cap_paramedicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(js_ch_cap_ambulancias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jcb_ch_ranking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jb_construir_complejo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("Complejos Hospitalarios", jPanel1);

        jLabel6.setText("Nombre completo");

        jLabel7.setText("Edad");

        jLabel8.setText("ID");

        jLabel9.setText("Ranking de paramedico");

        jcb_paramedicos_ranking.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D" }));

        jLabel10.setText("Complejo asignado");

        jb_registrar_paramedico.setText("Registrar paramedico");
        jb_registrar_paramedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_registrar_paramedicoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcb_paramedicos_ranking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_paramedicos_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_paramedicos_edad, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_paramedicos_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcb_paramedicos_complejos, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jb_registrar_paramedico, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtf_paramedicos_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtf_paramedicos_edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_paramedicos_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jcb_paramedicos_ranking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jcb_paramedicos_complejos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jb_registrar_paramedico, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        jTabbedPane1.addTab("Paramedicos", jPanel2);

        jLabel11.setText("Numero de placa");

        jLabel12.setText("Año del vehiculo");

        jLabel13.setText("Velocidad maxima");

        jLabel14.setText("Km/h");

        jLabel15.setText("Complejo asignado");

        jb_registrar_ambulancia.setText("Registrar ambulancia");
        jb_registrar_ambulancia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_registrar_ambulanciaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(jcb_ambulancias_complejo, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jtf_ambulancias_numero_placa)
                                        .addComponent(jtf_ambulancias_año, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jtf_ambulancias_velocidad, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel14))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(jb_registrar_ambulancia, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(210, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jtf_ambulancias_numero_placa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jtf_ambulancias_año, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jtf_ambulancias_velocidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(58, 58, 58)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jcb_ambulancias_complejo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(jb_registrar_ambulancia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

        jTabbedPane1.addTab("Ambulancias", jPanel3);

        jb_despedir_paramedico.setText("Despedir paramedico");
        jb_despedir_paramedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_despedir_paramedicoMouseClicked(evt);
            }
        });

        jb_eliminar_complejo.setText("Eliminar complejo hospitalario");
        jb_eliminar_complejo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_eliminar_complejoMouseClicked(evt);
            }
        });

        jb_transferir_paramedico.setText("Transferir");
        jb_transferir_paramedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_transferir_paramedicoMouseClicked(evt);
            }
        });

        jb_eliminar_ambulancia.setText("Eliminar ambulancia");
        jb_eliminar_ambulancia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_eliminar_ambulanciaMouseClicked(evt);
            }
        });

        jb_transferir_ambulancia.setText("Transferir");
        jb_transferir_ambulancia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_transferir_ambulanciaMouseClicked(evt);
            }
        });

        jLabel16.setText("Emergencias");

        jLabel17.setText("Ranking");

        jcb_ranking_emergencia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D" }));

        jLabel20.setText("Ubicacion");

        jButton5.setText("Agregar emergencia");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jb_eliminar_complejo)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jb_despedir_paramedico)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jb_transferir_paramedico))
                                    .addComponent(jcb_paramedicos_eliminar_transferir, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jcb_ch_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jb_eliminar_ambulancia)
                                        .addGap(18, 18, 18)
                                        .addComponent(jb_transferir_ambulancia))
                                    .addComponent(jcb_ambulancias_eliminar_transferir, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(jcb_ranking_emergencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)
                        .addComponent(jLabel20)
                        .addGap(29, 29, 29)
                        .addComponent(jcb_emergencia_domicilios, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(jButton5))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(jLabel16)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jb_eliminar_complejo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcb_ch_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_despedir_paramedico)
                    .addComponent(jb_transferir_paramedico)
                    .addComponent(jb_eliminar_ambulancia)
                    .addComponent(jb_transferir_ambulancia))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcb_paramedicos_eliminar_transferir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcb_ambulancias_eliminar_transferir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel16)
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jcb_ranking_emergencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jcb_emergencia_domicilios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(61, 61, 61))
        );

        jTabbedPane1.addTab("Administracion", jPanel4);

        jButton1.setText("Agregar complejo al mapa");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel18.setText("Nombre");

        jLabel19.setText("Direccion");

        jtf_domicilio_direccion.setColumns(20);
        jtf_domicilio_direccion.setRows(5);
        jScrollPane2.setViewportView(jtf_domicilio_direccion);

        jButton2.setText("Agregar domicilio al mapa");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setText("Conectar");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setText("Ver mapa");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jLabel21.setText("Distancia");

        jButton6.setText("Agregar domicilio al mapa");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtf_distancia_arista, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jcb_ubicaciones1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jcb_ubicaciones2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator2)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_domicilio_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jButton2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcb_domiclio_a_mapa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcb_complejo_a_mapa, 0, 201, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcb_complejo_a_mapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcb_domiclio_a_mapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_domicilio_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton2)))
                .addGap(15, 15, 15)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcb_ubicaciones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcb_ubicaciones2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jtf_distancia_arista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(20, 20, 20))))
        );

        jTabbedPane1.addTab("Mapa", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_construir_complejoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_construir_complejoMouseClicked
        // TODO add your handling code here:
        boolean Campos_llenos = true;
        if ("".equals(jtf_ch_nombre.getText()) || "".equals(jta_ch_direccion_complejo.getText())) {
            Campos_llenos = false;
        }

        if (Campos_llenos) {
            String Nombre, Direccion, Ranking;
            int Capacidad_paramedicos, Capacidad_ambulancias;

            Nombre = jtf_ch_nombre.getText();
            Direccion = jta_ch_direccion_complejo.getText();
            Ranking = jcb_ch_ranking.getSelectedItem().toString();
            Capacidad_paramedicos = (int) js_ch_cap_paramedicos.getValue();
            Capacidad_ambulancias = (int) js_ch_cap_ambulancias.getValue();

            ComplejoHospitalario Nuevo_complejo = new ComplejoHospitalario(Nombre, Direccion, Capacidad_paramedicos, Capacidad_ambulancias, Ranking);

            jcb_ambulancias_complejo.addItem(Nuevo_complejo);
            jcb_ch_eliminar.addItem(Nuevo_complejo);
            jcb_paramedicos_complejos.addItem(Nuevo_complejo);
            jcb_complejo_a_mapa.addItem(Nuevo_complejo);
            Complejos.add(Nuevo_complejo);

            jtf_ch_nombre.setText("");
            jta_ch_direccion_complejo.setText("");
            js_ch_cap_paramedicos.setValue(1);
            js_ch_cap_ambulancias.setValue(1);

            JOptionPane.showMessageDialog(this, "Has construido un complejo hospitalario",
                    "OPERACION EXITOSA", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Porfavor llena todos los campos",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jb_construir_complejoMouseClicked

    private void jb_registrar_paramedicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_registrar_paramedicoMouseClicked
        // TODO add your handling code here:
        boolean Campos_llenos = true;
        boolean Exceso = false;
        ComplejoHospitalario Revisar_paramedicos = ((ComplejoHospitalario) jcb_paramedicos_complejos.getSelectedItem());

        if ("".equals(jtf_paramedicos_nombre.getText()) || "".equals(jtf_paramedicos_edad.getText())
                || "".equals(jtf_paramedicos_ID.getText()) || jcb_paramedicos_complejos.getItemCount() == 0) {
            Campos_llenos = false;
        }

        if (Revisar_paramedicos.getParamedicos().size() == Revisar_paramedicos.getCapacidad_paramedicos()) {
            Exceso = true;
        }

        if (Campos_llenos && !Exceso) {
            String Nombre, Ranking, Complejo_asignado;
            int Edad, ID;

            Nombre = jtf_paramedicos_nombre.getText();
            Ranking = jcb_paramedicos_ranking.getSelectedItem().toString();
            Complejo_asignado = ((ComplejoHospitalario) jcb_paramedicos_complejos.getSelectedItem()).getNombre();
            Edad = Integer.parseInt(jtf_paramedicos_edad.getText());
            ID = Integer.parseInt(jtf_paramedicos_ID.getText());

            Paramedico Nuevo_paramedico = new Paramedico(Nombre, Edad, ID, Ranking, Complejo_asignado);

            jcb_paramedicos_eliminar_transferir.addItem(Nuevo_paramedico);
            Paramedicos.add(Nuevo_paramedico);
            for (int i = 0; i < Complejos.size(); i++) {
                if (Complejos.get(i).getNombre().equals(Complejo_asignado)) {
                    Complejos.get(i).getParamedicos().add(Nuevo_paramedico);
                }
            }
            ActualizarComplejos();

            jtf_paramedicos_nombre.setText("");
            jtf_paramedicos_edad.setText("");
            jtf_paramedicos_ID.setText("");

            JOptionPane.showMessageDialog(this, "Has contratado a un paramedico",
                    "OPERACION EXITOSA", JOptionPane.INFORMATION_MESSAGE);
        } else if (Exceso) {
            JOptionPane.showMessageDialog(this, "No hay espacio para mas paramedicos en el " + Revisar_paramedicos.getNombre(),
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Detectamos campos vacios",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jb_registrar_paramedicoMouseClicked

    private void jb_registrar_ambulanciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_registrar_ambulanciaMouseClicked
        // TODO add your handling code here:
        boolean Campos_llenos = true;
        boolean Exceso = false;
        ComplejoHospitalario Revisar_ambulancias = ((ComplejoHospitalario) jcb_ambulancias_complejo.getSelectedItem());

        if ("".equals(jtf_ambulancias_numero_placa.getText()) || "".equals(jtf_ambulancias_año.getText())
                || "".equals(jtf_ambulancias_velocidad.getText()) || jcb_ambulancias_complejo.getItemCount() == 0) {
            Campos_llenos = false;
        }

        if (Revisar_ambulancias.getAmbulancias().size() == Revisar_ambulancias.getCapacidad_ambulancias()) {
            Exceso = true;
        }

        if (Campos_llenos && !Exceso) {
            String Numero_placa, Complejo_asignado;
            int Año_vehiculo, Velocidad_max;

            Numero_placa = jtf_ambulancias_numero_placa.getText();
            Complejo_asignado = ((ComplejoHospitalario) jcb_ambulancias_complejo.getSelectedItem()).getNombre();
            Año_vehiculo = Integer.parseInt(jtf_ambulancias_año.getText());
            Velocidad_max = Integer.parseInt(jtf_ambulancias_velocidad.getText());

            Ambulancia Nueva_ambulancia = new Ambulancia(Numero_placa, Año_vehiculo, Velocidad_max, Complejo_asignado);

            jcb_ambulancias_eliminar_transferir.addItem(Nueva_ambulancia);
            Ambulancias.add(Nueva_ambulancia);
            for (int i = 0; i < Complejos.size(); i++) {
                if (Complejos.get(i).getNombre().equals(Complejo_asignado)) {
                    Complejos.get(i).getAmbulancias().add(Nueva_ambulancia);
                }
            }
            ActualizarComplejos();

            jtf_ambulancias_numero_placa.setText("");
            jtf_ambulancias_año.setText("");
            jtf_ambulancias_velocidad.setText("");

            JOptionPane.showMessageDialog(this, "Has registrado una ambulancia",
                    "OPERACION EXITOSA", JOptionPane.INFORMATION_MESSAGE);
        } else if (Exceso) {
            JOptionPane.showMessageDialog(this, "No hay espacio para mas ambulanicas en el " + Revisar_ambulancias,
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Detectamos campos vacios",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jb_registrar_ambulanciaMouseClicked

    private void jb_eliminar_complejoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_eliminar_complejoMouseClicked
        // TODO add your handling code here:
        boolean Campos_llenos = true;
        if (jcb_ch_eliminar.getItemCount() == 0) {
            Campos_llenos = false;
        }

        if (Campos_llenos) {
            String Nombre_complejo;
            Nombre_complejo = ((ComplejoHospitalario) jcb_ch_eliminar.getSelectedItem()).getNombre();

            for (int i = 0; i < Complejos.size(); i++) {
                if (Complejos.get(i).getNombre().equals(Nombre_complejo)) {
                    Complejos.remove(i);
                }
            }

            for (int i = 0; i < Paramedicos.size(); i++) {
                if (Paramedicos.get(i).getComplejo_asignado().equals(Nombre_complejo)) {
                    Paramedicos.get(i).setComplejo_asignado("");
                }
            }

            for (int i = 0; i < Ambulancias.size(); i++) {
                if (Ambulancias.get(i).getComplejo_asignado().equals(Nombre_complejo)) {
                    Ambulancias.get(i).setComplejo_asignado("");
                }
            }

            for (int i = 0; i < Ubicaciones.size(); i++) {
                if (Ubicaciones.get(i).toString().equals(Nombre_complejo)) {
                    graph.removeNode(Nombre_complejo);
                    Ubicaciones.remove(i);

                }
            }

            ActualizarComplejos();
            ActualizarParamedicos();
            ActualizarAmbulancias();

            JOptionPane.showMessageDialog(this, "Ha eliminado un complejo hospitalario",
                    "OPERACION EXITOSA", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Detectamos campos vacios",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jb_eliminar_complejoMouseClicked

    private void jb_despedir_paramedicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_despedir_paramedicoMouseClicked
        // TODO add your handling code here:
        boolean Campos_llenos = true;

        if (jcb_paramedicos_eliminar_transferir.getItemCount() == 0) {
            Campos_llenos = false;
        }

        if (Campos_llenos) {
            String Nombre_paramedico;

            Nombre_paramedico = ((Paramedico) jcb_paramedicos_eliminar_transferir.getSelectedItem()).getNombre();

            for (int i = 0; i < Paramedicos.size(); i++) {
                Paramedicos.remove(jcb_paramedicos_eliminar_transferir.getSelectedIndex());
            }

            for (int i = 0; i < Complejos.size(); i++) {
                for (int j = 0; j < Complejos.get(i).getParamedicos().size(); j++) {
                    if (Complejos.get(i).getParamedicos().get(j).getNombre().equals(Nombre_paramedico)) {
                        Complejos.get(i).getParamedicos().remove(j);
                    }
                }
            }

            ActualizarComplejos();
            ActualizarParamedicos();

            JOptionPane.showMessageDialog(this, "Ha eliminado un paramedico",
                    "OPERACION EXITOSA", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Hemos detectado campos vacios",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jb_despedir_paramedicoMouseClicked

    private void jb_transferir_paramedicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_transferir_paramedicoMouseClicked
        // TODO add your handling code here:
        boolean Campos_llenos = true;

        if (jcb_paramedicos_eliminar_transferir.getItemCount() == 0 || jcb_ch_eliminar.getItemCount() == 0) {
            Campos_llenos = false;
        }

        if (Campos_llenos) {
            String Nombre_complejo, Nombre_paramedico;

            Nombre_complejo = ((ComplejoHospitalario) jcb_ch_eliminar.getSelectedItem()).getNombre();
            Nombre_paramedico = ((Paramedico) jcb_paramedicos_eliminar_transferir.getSelectedItem()).getNombre();
            Paramedico Paramedico_transferir = (Paramedico) jcb_paramedicos_eliminar_transferir.getSelectedItem();

            for (int i = 0; i < Complejos.size(); i++) {
                for (int j = 0; j < Complejos.get(i).getParamedicos().size(); j++) {
                    if (Complejos.get(i).getParamedicos().get(j).getNombre().equals(Nombre_paramedico)) {
                        Complejos.get(i).getParamedicos().remove(j);
                    }
                }
            }

            for (int i = 0; i < Complejos.size(); i++) {
                if (Complejos.get(i).getNombre().equals(Nombre_complejo)) {
                    for (int j = 0; j < Complejos.get(i).getParamedicos().size(); j++) {
                        Complejos.get(i).getParamedicos().add(Paramedico_transferir);
                    }
                }
            }

            for (int i = 0; i < Paramedicos.size(); i++) {
                if (Paramedicos.get(i).getNombre().equals(Nombre_paramedico)) {
                    Paramedicos.get(i).setComplejo_asignado(Nombre_complejo);
                }
            }

            ActualizarComplejos();
            ActualizarParamedicos();

            JOptionPane.showMessageDialog(this, "Ha trasnferido un paramedico",
                    "OPERACION EXITOSA", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Hemos detectado campos vacios",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jb_transferir_paramedicoMouseClicked

    private void jb_eliminar_ambulanciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_eliminar_ambulanciaMouseClicked
        // TODO add your handling code here:
        boolean Campos_llenos = true;

        if (jcb_ambulancias_eliminar_transferir.getItemCount() == 0) {
            Campos_llenos = false;
        }

        if (Campos_llenos) {
            String Numero_ambulancia;

            Numero_ambulancia = ((Ambulancia) jcb_ambulancias_eliminar_transferir.getSelectedItem()).getNumero_placa();

            for (int i = 0; i < Ambulancias.size(); i++) {
                if (Ambulancias.get(i).getNumero_placa().equals(Numero_ambulancia)) {
                    Ambulancias.remove(i);
                }
            }

            for (int i = 0; i < Complejos.size(); i++) {
                for (int j = 0; j < Complejos.get(i).getAmbulancias().size(); j++) {
                    if (Complejos.get(i).getAmbulancias().get(j).getNumero_placa().equals(Numero_ambulancia)) {
                        Complejos.get(i).getAmbulancias().remove(j);
                    }
                }
            }

            JOptionPane.showMessageDialog(this, "Ha eliminado una ambulancia",
                    "OPERACION EXITOSA", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Hemos detectado campos vacios",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jb_eliminar_ambulanciaMouseClicked

    private void jb_transferir_ambulanciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_transferir_ambulanciaMouseClicked
        // TODO add your handling code here:
        boolean Campos_llenos = true;

        if (jcb_ambulancias_eliminar_transferir.getItemCount() == 0 || jcb_ch_eliminar.getItemCount() == 0) {
            Campos_llenos = false;
        }

        if (Campos_llenos) {
            String Nombre_complejo, Numero_ambulancia;

            Nombre_complejo = ((ComplejoHospitalario) jcb_ch_eliminar.getSelectedItem()).getNombre();
            Numero_ambulancia = ((Ambulancia) jcb_ambulancias_eliminar_transferir.getSelectedItem()).getNumero_placa();
            Ambulancia Ambulancia_transferir = (Ambulancia) jcb_ambulancias_eliminar_transferir.getSelectedItem();

            for (int i = 0; i < Complejos.size(); i++) {
                for (int j = 0; j < Complejos.get(i).getAmbulancias().size(); j++) {
                    if (Complejos.get(i).getAmbulancias().get(j).getNumero_placa().equals(Numero_ambulancia)) {
                        Complejos.get(i).getAmbulancias().remove(j);
                    }
                }
            }

            for (int i = 0; i < Complejos.size(); i++) {
                if (Complejos.get(i).getNombre().equals(Nombre_complejo)) {
                    Complejos.get(i).getAmbulancias().add(Ambulancia_transferir);
                }
            }

            for (int i = 0; i < Ambulancias.size(); i++) {
                if (Ambulancias.get(i).getNumero_placa().equals(Numero_ambulancia)) {
                    Ambulancias.get(i).setComplejo_asignado(Nombre_complejo);
                }
            }

            ActualizarAmbulancias();
            ActualizarComplejos();

            JOptionPane.showMessageDialog(this, "Ha trasnferido una ambulancia",
                    "OPERACION EXITOSA", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Hemos detectado campos vacios",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jb_transferir_ambulanciaMouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        jd_mapa.setModal(true);
        jd_mapa.pack();
        jd_mapa.setLocationRelativeTo(this);
        jd_mapa.setVisible(true);

        jd_mapa.setMaximumSize(new Dimension(5000, 300));
        jp_mapa.setMaximumSize(new Dimension(5000, 300));
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        boolean Campos_llenos = true;

        if (jcb_complejo_a_mapa.getItemCount() == 0) {
            Campos_llenos = false;
        }

        if (Campos_llenos) {
            ComplejoHospitalario Complejo_a_mapa = ((ComplejoHospitalario) (jcb_complejo_a_mapa.getSelectedItem()));

            graph.addNode(Complejo_a_mapa.toString()).setAttribute("ui.label", Complejo_a_mapa.getNombre());

            Ubicaciones.add(Complejo_a_mapa);
            jcb_ubicaciones1.addItem(Complejo_a_mapa);
            jcb_ubicaciones2.addItem(Complejo_a_mapa);

            JOptionPane.showMessageDialog(this, "Se ha agregado un Complejo Hospitalario al mapa",
                    "OPERACION EXITOSA", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        String Nombre, Direccion;

        Nombre = jtf_domicilio_nombre.getText();
        Direccion = jtf_domicilio_direccion.getText();

        Domicilio Nuevo_domicilio = new Domicilio(Nombre, Direccion);

        graph.addNode(Nuevo_domicilio.toString()).setAttribute("ui.label", Nuevo_domicilio.getNombre());

        Domicilios.add(Nuevo_domicilio);
        Ubicaciones.add(Nuevo_domicilio);
        jcb_ubicaciones1.addItem(Nuevo_domicilio);
        jcb_ubicaciones2.addItem(Nuevo_domicilio);
        jcb_emergencia_domicilios.addItem(Nuevo_domicilio);

        JOptionPane.showMessageDialog(this, "Se ha agregado un Domicilio al mapa",
                "OPERACION EXITOSA", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        double Distancia;
        ID_EDGE += cont;

        Distancia = Double.parseDouble(jtf_distancia_arista.getText());

        graph.addEdge(ID_EDGE, jcb_ubicaciones1.getSelectedItem().toString(), jcb_ubicaciones2.getSelectedItem().toString()).setAttribute("ui.label", Distancia);
        jtf_distancia_arista.setText("");

        JOptionPane.showMessageDialog(this, "Se han conectado dos ubicaciones",
                "OPERACION EXITOSA", JOptionPane.INFORMATION_MESSAGE);
        cont++;
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
        ArrayList Complejos_cumplen = new ArrayList();
        ArrayList Caminos = new ArrayList();
        ArrayList Valor_camino = new ArrayList();
        double Minima_longitud = 9999999999.0;
        int Complejo_elegido = 0;
        double Tiempo;
        boolean vive = true;

        String Ranking;
        Domicilio domicilio;

        Ranking = jcb_ranking_emergencia.getSelectedItem().toString();
        domicilio = ((Domicilio) jcb_emergencia_domicilios.getSelectedItem());

        Dijkstra dijkstra = new Dijkstra(Dijkstra.Element.EDGE, null, "ui.label");

        for (int i = 0; i < Ubicaciones.size(); i++) {
            for (int j = 0; j < Complejos.size(); j++) {
                if (Ubicaciones.get(i).toString().equals(Complejos.get(j).getNombre())) {
                    Complejos_cumplen.add(Ubicaciones.get(i));
                }
            }
        }

        for (int i = 0; i < Complejos_cumplen.size(); i++) {
            if (((ComplejoHospitalario) Complejos_cumplen.get(i)).getParamedicos().size() < 3) {
                Complejos_cumplen.remove(i);
            }

            if ((((ComplejoHospitalario) Complejos_cumplen.get(i)).getAmbulancias()).size() < 1) {
                Complejos_cumplen.remove(i);
            }

            if (!((ComplejoHospitalario) Complejos_cumplen.get(i)).getRanking_emergencias().equals(Ranking)) {
                Complejos_cumplen.remove(i);
            }
        }

        System.out.println(Complejos_cumplen.toString());

        dijkstra.init(graph);
        dijkstra.setSource(graph.getNode(domicilio.getNombre()));
        dijkstra.compute();

        for (int i = 0; i < Complejos_cumplen.size(); i++) {
            Path camino = dijkstra.getPath(graph.getNode(((ComplejoHospitalario) Complejos_cumplen.get(i)).getNombre()));
            Caminos.add(camino);

            double Longitud_camino = camino.getPathWeight("ui.label");
            Valor_camino.add(Longitud_camino);
        }

        for (int i = 0; i < Valor_camino.size(); i++) {
            if (((double) Valor_camino.get(i)) < Minima_longitud) {
                Minima_longitud = ((double) (Valor_camino.get(i)));
                Complejo_elegido = i;
            }
        }

        for (int i = 0; i < Caminos.size(); i++) {
            System.out.println(Caminos.get(i).toString());
        }

        Tiempo = Minima_longitud / ((ComplejoHospitalario) Complejos_cumplen.get(Complejo_elegido)).getAmbulancias().get(0).getVelocidad_maxima();
        Hilo hilo = new Hilo(Tiempo, domicilio.getNombre(), vive);
        hilo.start();
        System.out.println("El camino elegido es " + Caminos.get(Complejo_elegido).toString());
        System.out.println(Minima_longitud + " esta es la minima longitud");
        System.out.println("");

        Orden_de_hospitales.add((ComplejoHospitalario) Complejos_cumplen.get(Complejo_elegido));
    }//GEN-LAST:event_jButton5MouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        ActualizarAmbulancias();
        ActualizarComplejos();
        ActualizarParamedicos();
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EHospital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EHospital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EHospital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EHospital.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EHospital().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jb_construir_complejo;
    private javax.swing.JButton jb_despedir_paramedico;
    private javax.swing.JButton jb_eliminar_ambulancia;
    private javax.swing.JButton jb_eliminar_complejo;
    private javax.swing.JButton jb_registrar_ambulancia;
    private javax.swing.JButton jb_registrar_paramedico;
    private javax.swing.JButton jb_transferir_ambulancia;
    private javax.swing.JButton jb_transferir_paramedico;
    private javax.swing.JComboBox jcb_ambulancias_complejo;
    private javax.swing.JComboBox jcb_ambulancias_eliminar_transferir;
    private javax.swing.JComboBox jcb_ch_eliminar;
    private javax.swing.JComboBox jcb_ch_ranking;
    private javax.swing.JComboBox jcb_complejo_a_mapa;
    private javax.swing.JComboBox jcb_domiclio_a_mapa;
    private javax.swing.JComboBox jcb_emergencia_domicilios;
    private javax.swing.JComboBox jcb_paramedicos_complejos;
    private javax.swing.JComboBox jcb_paramedicos_eliminar_transferir;
    private javax.swing.JComboBox jcb_paramedicos_ranking;
    private javax.swing.JComboBox jcb_ranking_emergencia;
    private javax.swing.JComboBox jcb_ubicaciones1;
    private javax.swing.JComboBox jcb_ubicaciones2;
    private javax.swing.JDialog jd_mapa;
    private javax.swing.JPanel jp_mapa;
    private javax.swing.JSpinner js_ch_cap_ambulancias;
    private javax.swing.JSpinner js_ch_cap_paramedicos;
    private javax.swing.JTextArea jta_ch_direccion_complejo;
    private javax.swing.JTextField jtf_ambulancias_año;
    private javax.swing.JTextField jtf_ambulancias_numero_placa;
    private javax.swing.JTextField jtf_ambulancias_velocidad;
    private javax.swing.JTextField jtf_ch_nombre;
    private javax.swing.JTextField jtf_distancia_arista;
    private javax.swing.JTextArea jtf_domicilio_direccion;
    private javax.swing.JTextField jtf_domicilio_nombre;
    private javax.swing.JTextField jtf_paramedicos_ID;
    private javax.swing.JTextField jtf_paramedicos_edad;
    private javax.swing.JTextField jtf_paramedicos_nombre;
    // End of variables declaration//GEN-END:variables
    ArrayList<ComplejoHospitalario> Complejos = new ArrayList();
    ArrayList<Paramedico> Paramedicos = new ArrayList();
    ArrayList<Ambulancia> Ambulancias = new ArrayList();
    ArrayList<Domicilio> Domicilios = new ArrayList();
    ArrayList Ubicaciones = new ArrayList();

    PriorityQueue<Paramedico> Paramedicos_en_orden = new PriorityQueue();
    Queue<ComplejoHospitalario> Orden_de_hospitales;

    Graph graph = new SingleGraph("Mapa");
    String ID_EDGE = "";
    int cont = 0;
    Guardar objeto;
}
