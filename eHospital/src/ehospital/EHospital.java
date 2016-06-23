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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;
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
                JOptionPane.showMessageDialog(this, "No se guardo correctamente",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No se guardo correctamente",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
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

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "No hay archivo guardado",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No se cargo el archivo",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
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
        jLabel22 = new javax.swing.JLabel();
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
        jLabel23 = new javax.swing.JLabel();
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
        jLabel24 = new javax.swing.JLabel();
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
        jLabel25 = new javax.swing.JLabel();
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
        jLabel26 = new javax.swing.JLabel();

        jd_mapa.setTitle("eHospital ©");

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

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Nombre del complejo");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 49, -1, -1));
        jPanel1.add(jtf_ch_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 46, 141, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Capacidad de paramedicos");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 104, -1, -1));

        js_ch_cap_paramedicos.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jPanel1.add(js_ch_cap_paramedicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 101, 39, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Capacidad de ambulancias");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 164, -1, -1));

        js_ch_cap_ambulancias.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jPanel1.add(js_ch_cap_ambulancias, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 161, 39, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Ranking de emergencias a tratar");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 218, -1, -1));

        jcb_ch_ranking.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D" }));
        jPanel1.add(jcb_ch_ranking, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Direccion del complejo");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 281, -1, -1));

        jta_ch_direccion_complejo.setColumns(20);
        jta_ch_direccion_complejo.setRows(5);
        jScrollPane1.setViewportView(jta_ch_direccion_complejo);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 321, 82));

        jb_construir_complejo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/designbuild-icon.png"))); // NOI18N
        jb_construir_complejo.setText("Construir complejo");
        jb_construir_complejo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_construir_complejoMouseClicked(evt);
            }
        });
        jPanel1.add(jb_construir_complejo, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 403, -1, 49));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/black-pattern-wallpaper.jpg"))); // NOI18N
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 470));

        jTabbedPane1.addTab("Complejos Hospitalarios", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Nombre completo");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 44, -1, -1));
        jPanel2.add(jtf_paramedicos_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 41, 239, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("Edad");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 103, -1, -1));
        jPanel2.add(jtf_paramedicos_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 100, 48, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("ID");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 164, -1, -1));
        jPanel2.add(jtf_paramedicos_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 161, 104, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(240, 240, 240));
        jLabel9.setText("Ranking de paramedico");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 223, -1, -1));

        jcb_paramedicos_ranking.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D" }));
        jPanel2.add(jcb_paramedicos_ranking, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 220, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(240, 240, 240));
        jLabel10.setText("Complejo asignado");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 293, -1, -1));

        jPanel2.add(jcb_paramedicos_complejos, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 290, 213, -1));

        jb_registrar_paramedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add_client_icon.png"))); // NOI18N
        jb_registrar_paramedico.setText("Registrar paramedico");
        jb_registrar_paramedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_registrar_paramedicoMouseClicked(evt);
            }
        });
        jPanel2.add(jb_registrar_paramedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 379, 191, 46));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/black-pattern-wallpaper.jpg"))); // NOI18N
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 470));

        jTabbedPane1.addTab("Paramedicos", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(240, 240, 240));
        jLabel11.setText("Numero de placa");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 52, -1, -1));
        jPanel3.add(jtf_ambulancias_numero_placa, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 49, 117, -1));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(240, 240, 240));
        jLabel12.setText("Año del vehiculo");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 108, -1, -1));
        jPanel3.add(jtf_ambulancias_año, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 105, 117, -1));

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(240, 240, 240));
        jLabel13.setText("Velocidad maxima");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 172, -1, -1));
        jPanel3.add(jtf_ambulancias_velocidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 169, 77, -1));

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(240, 240, 240));
        jLabel14.setText("Km/h");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 172, -1, -1));

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(240, 240, 240));
        jLabel15.setText("Complejo asignado");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 250, -1, -1));

        jPanel3.add(jcb_ambulancias_complejo, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 247, 233, -1));

        jb_registrar_ambulancia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add-icon.png"))); // NOI18N
        jb_registrar_ambulancia.setText("Registrar ambulancia");
        jb_registrar_ambulancia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_registrar_ambulanciaMouseClicked(evt);
            }
        });
        jPanel3.add(jb_registrar_ambulancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 347, 186, 50));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/black-pattern-wallpaper.jpg"))); // NOI18N
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 470));

        jTabbedPane1.addTab("Ambulancias", jPanel3);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.add(jcb_paramedicos_eliminar_transferir, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 161, 222, -1));

        jb_despedir_paramedico.setText("Despedir paramedico");
        jb_despedir_paramedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_despedir_paramedicoMouseClicked(evt);
            }
        });
        jPanel4.add(jb_despedir_paramedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 120, -1, -1));

        jPanel4.add(jcb_ch_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 61, 222, -1));

        jb_eliminar_complejo.setText("Eliminar complejo hospitalario");
        jb_eliminar_complejo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_eliminar_complejoMouseClicked(evt);
            }
        });
        jPanel4.add(jb_eliminar_complejo, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 27, -1, -1));

        jb_transferir_paramedico.setText("Transferir");
        jb_transferir_paramedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_transferir_paramedicoMouseClicked(evt);
            }
        });
        jPanel4.add(jb_transferir_paramedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 120, -1, -1));

        jPanel4.add(jcb_ambulancias_eliminar_transferir, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 161, 222, -1));

        jb_eliminar_ambulancia.setText("Eliminar ambulancia");
        jb_eliminar_ambulancia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_eliminar_ambulanciaMouseClicked(evt);
            }
        });
        jPanel4.add(jb_eliminar_ambulancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 120, -1, -1));

        jb_transferir_ambulancia.setText("Transferir");
        jb_transferir_ambulancia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_transferir_ambulanciaMouseClicked(evt);
            }
        });
        jPanel4.add(jb_transferir_ambulancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(459, 120, -1, -1));
        jPanel4.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 218, 590, 10));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(240, 240, 240));
        jLabel16.setText("Emergencias");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 269, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(240, 240, 240));
        jLabel17.setText("Ranking");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 326, -1, -1));

        jcb_ranking_emergencia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D" }));
        jPanel4.add(jcb_ranking_emergencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 323, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(240, 240, 240));
        jLabel20.setText("Ubicacion");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 326, -1, -1));

        jPanel4.add(jcb_emergencia_domicilios, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 323, 178, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add-icon.png"))); // NOI18N
        jButton5.setText("Agregar emergencia");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jPanel4.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, -1, -1));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/black-pattern-wallpaper.jpg"))); // NOI18N
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 470));

        jTabbedPane1.addTab("Administracion", jPanel4);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.add(jcb_complejo_a_mapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 30, 201, -1));
        jPanel5.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 92, 590, 10));

        jButton1.setText("Agregar complejo al mapa");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 29, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(240, 240, 240));
        jLabel18.setText("Nombre");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 132, -1, -1));
        jPanel5.add(jtf_domicilio_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 129, 169, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(240, 240, 240));
        jLabel19.setText("Direccion");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 189, -1, -1));

        jtf_domicilio_direccion.setColumns(20);
        jtf_domicilio_direccion.setRows(5);
        jScrollPane2.setViewportView(jtf_domicilio_direccion);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 189, 272, -1));

        jButton2.setText("Agregar domicilio al mapa");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel5.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 216, -1, -1));
        jPanel5.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 319, 590, 10));

        jPanel5.add(jcb_ubicaciones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 347, 186, -1));

        jPanel5.add(jcb_ubicaciones2, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 347, 186, -1));

        jButton3.setText("Conectar");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel5.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 428, 131, -1));

        jButton4.setText("Ver mapa");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jPanel5.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 437, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(240, 240, 240));
        jLabel21.setText("Distancia");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 393, -1, -1));
        jPanel5.add(jtf_distancia_arista, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 390, 100, -1));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/black-pattern-wallpaper.jpg"))); // NOI18N
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 470));

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
        boolean Nombre_repetido = false;
        if ("".equals(jtf_ch_nombre.getText()) || "".equals(jta_ch_direccion_complejo.getText())) {
            Campos_llenos = false;
        }

        for (int i = 0; i < Complejos.size(); i++) {
            if (Complejos.get(i).getNombre().equals(jtf_ch_nombre.getText())) {
                Nombre_repetido = true;
            }
        }

        if (Campos_llenos && !Nombre_repetido) {
            String Nombre, Direccion, Ranking;
            int Capacidad_paramedicos, Capacidad_ambulancias;

            Nombre = jtf_ch_nombre.getText();
            Direccion = jta_ch_direccion_complejo.getText();
            Ranking = jcb_ch_ranking.getSelectedItem().toString();
            Capacidad_paramedicos = (int) js_ch_cap_paramedicos.getValue();
            Capacidad_ambulancias = (int) js_ch_cap_ambulancias.getValue();

            for (int i = 0; i < Complejos.size(); i++) {
                if (Complejos.get(i).getNombre().equals(Nombre)) {

                }
            }

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
        } else if (Nombre_repetido) {
            JOptionPane.showMessageDialog(this, "Ya existe ese complejo hospitalario",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
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
            String ID;
            int Edad;

            Nombre = jtf_paramedicos_nombre.getText();
            Ranking = jcb_paramedicos_ranking.getSelectedItem().toString();
            Complejo_asignado = ((ComplejoHospitalario) jcb_paramedicos_complejos.getSelectedItem()).getNombre();
            Edad = Integer.parseInt(jtf_paramedicos_edad.getText());
            ID = (jtf_paramedicos_ID.getText());

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
                if (Paramedicos.get(i).getNombre().equals(Nombre_paramedico)) {
                    Paramedicos.remove(i);
                }
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

            ActualizarAmbulancias();
            ActualizarComplejos();
            ActualizarParamedicos();

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
        } else {
            JOptionPane.showMessageDialog(this, "Hemos detectado campos vacios",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        boolean Campos_llenos = true, Nombre_repetido = false;

        if (jtf_domicilio_nombre.getText().equals("") || jtf_domicilio_direccion.getText().equals("")) {
            Campos_llenos = false;
        }

        for (int i = 0; i < Domicilios.size(); i++) {
            if (Domicilios.get(i).getNombre().equals(jtf_domicilio_nombre.getText())) {
                Nombre_repetido = true;
            }
        }

        if (Campos_llenos && !Nombre_repetido) {
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

            jtf_domicilio_nombre.setText("");
            jtf_domicilio_direccion.setText("");

            JOptionPane.showMessageDialog(this, "Se ha agregado un Domicilio al mapa",
                    "OPERACION EXITOSA", JOptionPane.INFORMATION_MESSAGE);
        } else if (Nombre_repetido) {
            JOptionPane.showMessageDialog(this, "Ya existe este domicilio en el mapa",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Hemos detectado campos vacios",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }

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
        boolean Suficiente = true;
        ArrayList Complejos_cumplen = new ArrayList();
        ArrayList Caminos = new ArrayList();
        ArrayList Valor_camino = new ArrayList();
        double Minima_longitud = 9999999999.0;
        int Complejo_elegido = 0;
        double Tiempo;
        boolean vive = true;
        ArrayList<Paramedico> Paramedicos_atendiendo = new ArrayList();

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

        if (Complejos_cumplen.isEmpty()) {
            Suficiente = false;
        }

        if (Suficiente) {
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

            /*String Nombre_complejo_elegido = Complejos_cumplen.get(Complejo_elegido).toString();
             int Posicion_complejo_cumple = 0;
            

             for (int i = 0; i < Complejos.size(); i++) {
             if (Complejos.get(i).getNombre().equals(Nombre_complejo_elegido)) {
             Orden_de_hospitales.add(Complejos.get(i));
             Posicion_complejo_cumple = i;
             for (int j = 0; j < Complejos.get(i).getParamedicos().size(); j++) {
             Paramedicos_en_orden.add(Complejos.get(i).getParamedicos().get(j));
             }
             }
             }

             for (int i = 0; i < Paramedicos_en_orden.size(); i++) {
             Paramedicos_atendiendo.add(Paramedicos_en_orden.peek());
             Paramedicos_en_orden.remove();
             }

             for (int i = 0; i < Complejos.size(); i++) {
             if (Complejos.get(i).getNombre().equals(Nombre_complejo_elegido)) {
             for (int j = 0; j < Paramedicos_atendiendo.size(); j++) {
             for (int k = 0; k < Complejos.get(i).getParamedicos().size(); k++) {
             if (Complejos.get(i).getParamedicos().get(k).getNombre().equals(Paramedicos_atendiendo.get(j).getNombre())) {
             Complejos.get(i).getParamedicos().remove(k);
             }
             }
             }
             }
             }*/
            Tiempo = Minima_longitud / ((ComplejoHospitalario) Complejos_cumplen.get(Complejo_elegido)).getAmbulancias().get(0).getVelocidad_maxima();
            Hilo hilo = new Hilo(Tiempo * 2, domicilio.getNombre(), vive/*, Complejos.get(Posicion_complejo_cumple).getParamedicos(), Paramedicos_atendiendo*/);
            hilo.start();
            System.out.println("El camino elegido es " + Caminos.get(Complejo_elegido).toString());
            System.out.println(Minima_longitud + " esta es la minima longitud");
            System.out.println("");

            //Orden_de_hospitales.add((ComplejoHospitalario) Complejos_cumplen.get(Complejo_elegido));
        } else {
            JOptionPane.showMessageDialog(this, "No hay complejos que cumplan con las necesidades",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }

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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
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
