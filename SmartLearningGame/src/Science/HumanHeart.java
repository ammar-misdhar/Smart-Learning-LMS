/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Science;

import Main.Deshbord;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 *
 * @author mmamm
 */
public class HumanHeart extends javax.swing.JFrame {

    /**
     * Creates new form HumanHeart
     */
    JLabel selectedLabal;

    public HumanHeart() {
        initComponents();
        disable();
    }

    int complete;
    int score;
    int health = 4;

    String idPas = "";

    public void setId(String id) {
        idPas = id;
        try {
            Connection con = database.db.getConnection();
            String sql = "SELECT userName FROM smart_learning.register WHERE id=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String uName = rs.getString("userName");
                lblUname.setText("welcome " + uName);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Deshbord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertToSql() {
        try {
            // create connection to database
            Connection con = database.db.getConnection();
            // Create prepared statement with the sql query
            PreparedStatement st1 = con.prepareStatement("UPDATE `smart_learning`.`science` SET `HumanHeartScore` = ?, `HumanHeartCoplete` = ? WHERE (`stRegId` = '" + idPas + "');");
            // execute query
            st1.setString(1, score + "");
            st1.setString(2, complete + "");

            st1.executeUpdate();
            lblScore.setText(score + "");

            // show success message
        } catch (SQLException ex) {
            Logger.getLogger(ElectronicConfiguration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void reattampt() {
        disable();
        dfault();

        btnAorta.setVisible(true);
        btnRightAtrlum.setVisible(true);
        btnLeftAtrium.setVisible(true);
        btnRightVentricle.setVisible(true);
        btnLeftVentricle.setVisible(true);
        btnTricuspiValvc.setVisible(true);
        btnInferiorVenaCava.setVisible(true);
        btnLeftPulmonaryArtery.setVisible(true);
        btnRightPulmonaryArtery.setVisible(true);
        btnLeftPulmonaryVeins.setVisible(true);
        btnBicuspidValve.setVisible(true);
        btnRightPulmonaryVeins.setVisible(true);
        btnSuperiorVenaCava.setVisible(true);
        btnSemiLunarValves.setVisible(true);

        lblAorta.setText("");
        lblRightAtrlum.setText("");
        lblLeftAtrium.setText("");
        lblRightVentricle.setText("");
        lblLeftVentricle.setText("");
        lblTricuspiValvc.setText("");
        lblInferiorVenaCava.setText("");
        lblLeftPulmonaryArtery.setText("");
        lblRightPulmonaryArtery.setText("");
        lblLeftPulmonaryVeins.setText("");
        lblBicuspidValve.setText("");
        lblRightPulmonaryVeins.setText("");
        lblSuperiorVenaCava.setText("");
        lblSemiLunarValves.setText("");

        score = 0;
        lblScoreSide.setText("Score - " + score);
        lblScore.setText(score + "");

        complete = 0;
        lblComplete.setText("Completed - " + complete + "%");

        btnReattampt.setEnabled(false);

    }

    public void enable() {
        btnAorta.setEnabled(true);
        btnRightAtrlum.setEnabled(true);
        btnLeftAtrium.setEnabled(true);
        btnRightVentricle.setEnabled(true);
        btnLeftVentricle.setEnabled(true);
        btnTricuspiValvc.setEnabled(true);
        btnInferiorVenaCava.setEnabled(true);
        btnLeftPulmonaryArtery.setEnabled(true);
        btnRightPulmonaryArtery.setEnabled(true);
        btnLeftPulmonaryVeins.setEnabled(true);
        btnBicuspidValve.setEnabled(true);
        btnRightPulmonaryVeins.setEnabled(true);
        btnSuperiorVenaCava.setEnabled(true);
        btnSemiLunarValves.setEnabled(true);
    }

    public void disable() {
        btnAorta.setEnabled(false);
        btnRightAtrlum.setEnabled(false);
        btnLeftAtrium.setEnabled(false);
        btnRightVentricle.setEnabled(false);
        btnLeftVentricle.setEnabled(false);
        btnTricuspiValvc.setEnabled(false);
        btnInferiorVenaCava.setEnabled(false);
        btnLeftPulmonaryArtery.setEnabled(false);
        btnRightPulmonaryArtery.setEnabled(false);
        btnLeftPulmonaryVeins.setEnabled(false);
        btnBicuspidValve.setEnabled(false);
        btnRightPulmonaryVeins.setEnabled(false);
        btnSuperiorVenaCava.setEnabled(false);
        btnSemiLunarValves.setEnabled(false);
    }

    public void dfault() {
        lblAorta.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        lblRightAtrlum.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        lblLeftAtrium.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        lblRightVentricle.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        lblLeftVentricle.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        lblTricuspiValvc.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        lblInferiorVenaCava.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        lblLeftPulmonaryArtery.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        lblRightPulmonaryArtery.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        lblLeftPulmonaryVeins.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        lblBicuspidValve.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        lblRightPulmonaryVeins.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        lblSuperiorVenaCava.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        lblSemiLunarValves.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        disable();
    }

    public void selectLabal() {
        selectedLabal.setBorder(BorderFactory.createLineBorder(Color.blue));
        enable();
    }

    public void retunButon() {

        complete = complete - 7;

        if (selectedLabal.getText().equals("Aorta")) {
            btnAorta.setVisible(true);
        } else if (selectedLabal.getText().equals("Right atrlum")) {
            btnRightAtrlum.setVisible(true);
        } else if (selectedLabal.getText().equals("Left atrium")) {
            btnLeftAtrium.setVisible(true);
        } else if (selectedLabal.getText().equals("Right ventricle")) {
            btnRightVentricle.setVisible(true);
        } else if (selectedLabal.getText().equals("Left ventricle")) {
            btnLeftVentricle.setVisible(true);
        } else if (selectedLabal.getText().equals("Tricuspi valvc")) {
            btnTricuspiValvc.setVisible(true);
        } else if (selectedLabal.getText().equals("Inferior vena cava")) {
            btnInferiorVenaCava.setVisible(true);
        } else if (selectedLabal.getText().equals("Left pulmonary artery")) {
            btnLeftPulmonaryArtery.setVisible(true);
        } else if (selectedLabal.getText().equals("Right Pulmonary artery")) {
            btnRightPulmonaryArtery.setVisible(true);
        } else if (selectedLabal.getText().equals("Left Pulmonary veins")) {
            btnLeftPulmonaryVeins.setVisible(true);
        } else if (selectedLabal.getText().equals("Bicuspid valve")) {
            btnBicuspidValve.setVisible(true);
        } else if (selectedLabal.getText().equals("Right Pulmonary veins")) {
            btnRightPulmonaryVeins.setVisible(true);
        } else if (selectedLabal.getText().equals("Superior vena cava")) {
            btnSuperiorVenaCava.setVisible(true);
        } else if (selectedLabal.getText().equals("Semi lunar valves")) {
            btnSemiLunarValves.setVisible(true);
        }

        selectedLabal.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnl_Header = new javax.swing.JPanel();
        lblScore = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        health2 = new javax.swing.JButton();
        health4 = new javax.swing.JButton();
        lblMainObject = new javax.swing.JLabel();
        health1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        health3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblRightVentricle = new javax.swing.JLabel();
        lblLeftPulmonaryArtery = new javax.swing.JLabel();
        lblLeftPulmonaryVeins = new javax.swing.JLabel();
        lblBicuspidValve = new javax.swing.JLabel();
        lblLeftAtrium = new javax.swing.JLabel();
        lblSemiLunarValves = new javax.swing.JLabel();
        lblLeftVentricle = new javax.swing.JLabel();
        lblAorta = new javax.swing.JLabel();
        lblInferiorVenaCava = new javax.swing.JLabel();
        lblTricuspiValvc = new javax.swing.JLabel();
        lblRightAtrlum = new javax.swing.JLabel();
        lblRightPulmonaryVeins = new javax.swing.JLabel();
        lblRightPulmonaryArtery = new javax.swing.JLabel();
        lblSuperiorVenaCava = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnAorta1 = new javax.swing.JLabel();
        pnlAnswer = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnAorta = new javax.swing.JButton();
        btnRightAtrlum = new javax.swing.JButton();
        btnLeftAtrium = new javax.swing.JButton();
        btnRightVentricle = new javax.swing.JButton();
        btnLeftVentricle = new javax.swing.JButton();
        btnTricuspiValvc = new javax.swing.JButton();
        btnInferiorVenaCava = new javax.swing.JButton();
        btnLeftPulmonaryArtery = new javax.swing.JButton();
        btnRightPulmonaryArtery = new javax.swing.JButton();
        btnLeftPulmonaryVeins = new javax.swing.JButton();
        btnBicuspidValve = new javax.swing.JButton();
        btnRightPulmonaryVeins = new javax.swing.JButton();
        btnSuperiorVenaCava = new javax.swing.JButton();
        btnSemiLunarValves = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnReattampt = new javax.swing.JButton();
        btnChack = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        pnlDoubleBloodCirculation1 = new javax.swing.JPanel();
        lblDbc1 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        dbcCoplete1 = new javax.swing.JLabel();
        dbcScore1 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        lblUserName6 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        lblTitle17 = new javax.swing.JLabel();
        lblTitle18 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        lblUname = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        lblUserName9 = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        lblComplete = new javax.swing.JLabel();
        lblScoreSide = new javax.swing.JLabel();
        btnBloodCircleHuman = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnHeat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnl_Header.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblScore.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblScore.setForeground(new java.awt.Color(102, 102, 102));
        lblScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScore.setText("000");
        pnl_Header.add(lblScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, 39, -1));

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Set the correct body parts name in correct place.");
        pnl_Header.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, -1));

        health2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hart.png"))); // NOI18N
        health2.setBorder(null);
        health2.setContentAreaFilled(false);
        pnl_Header.add(health2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        health4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hart.png"))); // NOI18N
        health4.setBorder(null);
        health4.setContentAreaFilled(false);
        pnl_Header.add(health4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        lblMainObject.setFont(new java.awt.Font("Poppins SemiBold", 0, 24)); // NOI18N
        lblMainObject.setForeground(new java.awt.Color(51, 51, 51));
        lblMainObject.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMainObject.setText("Human Body Heart");
        pnl_Header.add(lblMainObject, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 344, -1));

        health1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hart.png"))); // NOI18N
        health1.setBorder(null);
        health1.setContentAreaFilled(false);
        pnl_Header.add(health1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel8.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Score");
        pnl_Header.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Health");
        pnl_Header.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 194, 20));

        health3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hart.png"))); // NOI18N
        health3.setBorder(null);
        health3.setContentAreaFilled(false);
        pnl_Header.add(health3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/scienceTitle.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        pnl_Header.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 88));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnBack.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(51, 51, 51));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRightVentricle.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblRightVentricle.setForeground(new java.awt.Color(102, 102, 102));
        lblRightVentricle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRightVentricle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblRightVentricle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRightVentricle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRightVentricleMouseClicked(evt);
            }
        });
        jPanel3.add(lblRightVentricle, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 160, 30));

        lblLeftPulmonaryArtery.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblLeftPulmonaryArtery.setForeground(new java.awt.Color(102, 102, 102));
        lblLeftPulmonaryArtery.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLeftPulmonaryArtery.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblLeftPulmonaryArtery.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLeftPulmonaryArtery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLeftPulmonaryArteryMouseClicked(evt);
            }
        });
        jPanel3.add(lblLeftPulmonaryArtery, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 160, 30));

        lblLeftPulmonaryVeins.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblLeftPulmonaryVeins.setForeground(new java.awt.Color(102, 102, 102));
        lblLeftPulmonaryVeins.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLeftPulmonaryVeins.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblLeftPulmonaryVeins.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLeftPulmonaryVeins.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLeftPulmonaryVeinsMouseClicked(evt);
            }
        });
        jPanel3.add(lblLeftPulmonaryVeins, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 160, 30));

        lblBicuspidValve.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblBicuspidValve.setForeground(new java.awt.Color(102, 102, 102));
        lblBicuspidValve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBicuspidValve.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblBicuspidValve.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBicuspidValve.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBicuspidValveMouseClicked(evt);
            }
        });
        jPanel3.add(lblBicuspidValve, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 160, 30));

        lblLeftAtrium.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblLeftAtrium.setForeground(new java.awt.Color(102, 102, 102));
        lblLeftAtrium.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLeftAtrium.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblLeftAtrium.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLeftAtrium.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLeftAtriumMouseClicked(evt);
            }
        });
        jPanel3.add(lblLeftAtrium, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 160, 30));

        lblSemiLunarValves.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblSemiLunarValves.setForeground(new java.awt.Color(102, 102, 102));
        lblSemiLunarValves.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSemiLunarValves.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblSemiLunarValves.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSemiLunarValves.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSemiLunarValvesMouseClicked(evt);
            }
        });
        jPanel3.add(lblSemiLunarValves, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 160, 30));

        lblLeftVentricle.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblLeftVentricle.setForeground(new java.awt.Color(102, 102, 102));
        lblLeftVentricle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLeftVentricle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblLeftVentricle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLeftVentricle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLeftVentricleMouseClicked(evt);
            }
        });
        jPanel3.add(lblLeftVentricle, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, 160, 30));

        lblAorta.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblAorta.setForeground(new java.awt.Color(102, 102, 102));
        lblAorta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAorta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblAorta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAorta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAortaMouseClicked(evt);
            }
        });
        jPanel3.add(lblAorta, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 160, 30));

        lblInferiorVenaCava.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblInferiorVenaCava.setForeground(new java.awt.Color(102, 102, 102));
        lblInferiorVenaCava.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInferiorVenaCava.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblInferiorVenaCava.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblInferiorVenaCava.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInferiorVenaCavaMouseClicked(evt);
            }
        });
        jPanel3.add(lblInferiorVenaCava, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 150, 30));

        lblTricuspiValvc.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblTricuspiValvc.setForeground(new java.awt.Color(102, 102, 102));
        lblTricuspiValvc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTricuspiValvc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblTricuspiValvc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblTricuspiValvc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTricuspiValvcMouseClicked(evt);
            }
        });
        jPanel3.add(lblTricuspiValvc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 150, 30));

        lblRightAtrlum.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblRightAtrlum.setForeground(new java.awt.Color(102, 102, 102));
        lblRightAtrlum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRightAtrlum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblRightAtrlum.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRightAtrlum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRightAtrlumMouseClicked(evt);
            }
        });
        jPanel3.add(lblRightAtrlum, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 150, 30));

        lblRightPulmonaryVeins.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblRightPulmonaryVeins.setForeground(new java.awt.Color(102, 102, 102));
        lblRightPulmonaryVeins.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRightPulmonaryVeins.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblRightPulmonaryVeins.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRightPulmonaryVeins.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRightPulmonaryVeinsMouseClicked(evt);
            }
        });
        jPanel3.add(lblRightPulmonaryVeins, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 150, 30));

        lblRightPulmonaryArtery.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblRightPulmonaryArtery.setForeground(new java.awt.Color(102, 102, 102));
        lblRightPulmonaryArtery.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRightPulmonaryArtery.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblRightPulmonaryArtery.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRightPulmonaryArtery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRightPulmonaryArteryMouseClicked(evt);
            }
        });
        jPanel3.add(lblRightPulmonaryArtery, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 150, 30));

        lblSuperiorVenaCava.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblSuperiorVenaCava.setForeground(new java.awt.Color(102, 102, 102));
        lblSuperiorVenaCava.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSuperiorVenaCava.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblSuperiorVenaCava.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSuperiorVenaCava.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSuperiorVenaCavaMouseClicked(evt);
            }
        });
        jPanel3.add(lblSuperiorVenaCava, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 150, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Human heart photo.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 520, 411));

        btnAorta1.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnAorta1.setForeground(new java.awt.Color(102, 102, 102));
        btnAorta1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAorta1.setText("Click empty box and select answer");
        btnAorta1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAorta1.setEnabled(false);
        btnAorta1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAorta1MouseClicked(evt);
            }
        });
        jPanel3.add(btnAorta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, -1));

        pnlAnswer.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Answers");

        btnAorta.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnAorta.setForeground(new java.awt.Color(102, 102, 102));
        btnAorta.setText("Aorta");
        btnAorta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnAorta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAorta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAortaActionPerformed(evt);
            }
        });

        btnRightAtrlum.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnRightAtrlum.setForeground(new java.awt.Color(102, 102, 102));
        btnRightAtrlum.setText("Right atrlum");
        btnRightAtrlum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnRightAtrlum.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRightAtrlum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRightAtrlumActionPerformed(evt);
            }
        });

        btnLeftAtrium.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnLeftAtrium.setForeground(new java.awt.Color(102, 102, 102));
        btnLeftAtrium.setText("Left atrium");
        btnLeftAtrium.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnLeftAtrium.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLeftAtrium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeftAtriumActionPerformed(evt);
            }
        });

        btnRightVentricle.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnRightVentricle.setForeground(new java.awt.Color(102, 102, 102));
        btnRightVentricle.setText("Right ventricle");
        btnRightVentricle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnRightVentricle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRightVentricle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRightVentricleActionPerformed(evt);
            }
        });

        btnLeftVentricle.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnLeftVentricle.setForeground(new java.awt.Color(102, 102, 102));
        btnLeftVentricle.setText("Left ventricle");
        btnLeftVentricle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnLeftVentricle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLeftVentricle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeftVentricleActionPerformed(evt);
            }
        });

        btnTricuspiValvc.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnTricuspiValvc.setForeground(new java.awt.Color(102, 102, 102));
        btnTricuspiValvc.setText("Tricuspi valvc");
        btnTricuspiValvc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnTricuspiValvc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTricuspiValvc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTricuspiValvcActionPerformed(evt);
            }
        });

        btnInferiorVenaCava.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnInferiorVenaCava.setForeground(new java.awt.Color(102, 102, 102));
        btnInferiorVenaCava.setText("Inferior vena cava");
        btnInferiorVenaCava.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnInferiorVenaCava.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInferiorVenaCava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInferiorVenaCavaActionPerformed(evt);
            }
        });

        btnLeftPulmonaryArtery.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnLeftPulmonaryArtery.setForeground(new java.awt.Color(102, 102, 102));
        btnLeftPulmonaryArtery.setText("Left pulmonary artery");
        btnLeftPulmonaryArtery.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnLeftPulmonaryArtery.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLeftPulmonaryArtery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeftPulmonaryArteryActionPerformed(evt);
            }
        });

        btnRightPulmonaryArtery.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnRightPulmonaryArtery.setForeground(new java.awt.Color(102, 102, 102));
        btnRightPulmonaryArtery.setText("Right Pulmonary artery");
        btnRightPulmonaryArtery.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnRightPulmonaryArtery.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRightPulmonaryArtery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRightPulmonaryArteryActionPerformed(evt);
            }
        });

        btnLeftPulmonaryVeins.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnLeftPulmonaryVeins.setForeground(new java.awt.Color(102, 102, 102));
        btnLeftPulmonaryVeins.setText("Left Pulmonary veins");
        btnLeftPulmonaryVeins.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnLeftPulmonaryVeins.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLeftPulmonaryVeins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeftPulmonaryVeinsActionPerformed(evt);
            }
        });

        btnBicuspidValve.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnBicuspidValve.setForeground(new java.awt.Color(102, 102, 102));
        btnBicuspidValve.setText("Bicuspid valve");
        btnBicuspidValve.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnBicuspidValve.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBicuspidValve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBicuspidValveActionPerformed(evt);
            }
        });

        btnRightPulmonaryVeins.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnRightPulmonaryVeins.setForeground(new java.awt.Color(102, 102, 102));
        btnRightPulmonaryVeins.setText("Right Pulmonary veins");
        btnRightPulmonaryVeins.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnRightPulmonaryVeins.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRightPulmonaryVeins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRightPulmonaryVeinsActionPerformed(evt);
            }
        });

        btnSuperiorVenaCava.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnSuperiorVenaCava.setForeground(new java.awt.Color(102, 102, 102));
        btnSuperiorVenaCava.setText("Superior vena cava");
        btnSuperiorVenaCava.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnSuperiorVenaCava.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSuperiorVenaCava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuperiorVenaCavaActionPerformed(evt);
            }
        });

        btnSemiLunarValves.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnSemiLunarValves.setForeground(new java.awt.Color(102, 102, 102));
        btnSemiLunarValves.setText("Semi lunar valves");
        btnSemiLunarValves.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnSemiLunarValves.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSemiLunarValves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSemiLunarValvesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAnswerLayout = new javax.swing.GroupLayout(pnlAnswer);
        pnlAnswer.setLayout(pnlAnswerLayout);
        pnlAnswerLayout.setHorizontalGroup(
            pnlAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAnswerLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
            .addGroup(pnlAnswerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAnswerLayout.createSequentialGroup()
                        .addGroup(pnlAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnLeftVentricle, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLeftAtrium, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnAorta, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRightVentricle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRightAtrlum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTricuspiValvc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnInferiorVenaCava, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLeftPulmonaryArtery, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRightPulmonaryArtery, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLeftPulmonaryVeins, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBicuspidValve, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRightPulmonaryVeins, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSemiLunarValves, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuperiorVenaCava, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlAnswerLayout.setVerticalGroup(
            pnlAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAnswerLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addGroup(pnlAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAorta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRightAtrlum, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLeftAtrium, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRightVentricle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLeftVentricle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTricuspiValvc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInferiorVenaCava, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btnLeftPulmonaryArtery, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRightPulmonaryArtery, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLeftPulmonaryVeins, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBicuspidValve, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRightPulmonaryVeins, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSuperiorVenaCava, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSemiLunarValves, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        btnReattampt.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnReattampt.setForeground(new java.awt.Color(51, 51, 51));
        btnReattampt.setText("Reattempt ");
        btnReattampt.setEnabled(false);
        btnReattampt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReattamptActionPerformed(evt);
            }
        });

        btnChack.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnChack.setForeground(new java.awt.Color(51, 51, 51));
        btnChack.setText("Chack");
        btnChack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnChack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(btnReattampt)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReattampt)
                    .addComponent(btnChack))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(pnlAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(24, 24, 24)
                        .addComponent(btnBack)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnl_Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        pnlDoubleBloodCirculation1.setBackground(new java.awt.Color(247, 247, 247));
        pnlDoubleBloodCirculation1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlDoubleBloodCirculation1.setEnabled(false);

        lblDbc1.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        lblDbc1.setForeground(new java.awt.Color(102, 102, 102));
        lblDbc1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDbc1.setText("Double blood circulation");

        dbcCoplete1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        dbcCoplete1.setForeground(new java.awt.Color(102, 102, 102));
        dbcCoplete1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dbcCoplete1.setText("Completed - 0%");

        dbcScore1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        dbcScore1.setForeground(new java.awt.Color(102, 102, 102));
        dbcScore1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dbcScore1.setText("Score - 0");

        javax.swing.GroupLayout pnlDoubleBloodCirculation1Layout = new javax.swing.GroupLayout(pnlDoubleBloodCirculation1);
        pnlDoubleBloodCirculation1.setLayout(pnlDoubleBloodCirculation1Layout);
        pnlDoubleBloodCirculation1Layout.setHorizontalGroup(
            pnlDoubleBloodCirculation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoubleBloodCirculation1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDoubleBloodCirculation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDbc1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dbcScore1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dbcCoplete1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator13))
                .addContainerGap())
        );
        pnlDoubleBloodCirculation1Layout.setVerticalGroup(
            pnlDoubleBloodCirculation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoubleBloodCirculation1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblDbc1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dbcCoplete1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dbcScore1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(247, 247, 247));
        jPanel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
        });

        lblUserName6.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        lblUserName6.setForeground(new java.awt.Color(102, 102, 102));
        lblUserName6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserName6.setText("Blood circulation of human");

        lblTitle17.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        lblTitle17.setForeground(new java.awt.Color(102, 102, 102));
        lblTitle17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle17.setText("Completed - 0%");

        lblTitle18.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        lblTitle18.setForeground(new java.awt.Color(102, 102, 102));
        lblTitle18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle18.setText("Score - 0");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserName6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitle18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitle17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator11))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblUserName6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTitle17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitle18)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jButton6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(102, 102, 102));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profile.png"))); // NOI18N
        jButton6.setContentAreaFilled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        lblUname.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        lblUname.setForeground(new java.awt.Color(102, 102, 102));
        lblUname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUname.setText("Wlcome Admin");

        jPanel14.setBackground(new java.awt.Color(247, 247, 247));
        jPanel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
        });

        lblUserName9.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        lblUserName9.setForeground(new java.awt.Color(51, 51, 51));
        lblUserName9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserName9.setText("Heart");

        lblComplete.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        lblComplete.setForeground(new java.awt.Color(51, 51, 51));
        lblComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblComplete.setText("Completed - 0%");

        lblScoreSide.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        lblScoreSide.setForeground(new java.awt.Color(51, 51, 51));
        lblScoreSide.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScoreSide.setText("Score - 0");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserName9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblScoreSide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator14))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblUserName9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblComplete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblScoreSide)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btnBloodCircleHuman.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        btnBloodCircleHuman.setText("Blood Circulation of Human");
        btnBloodCircleHuman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBloodCircleHumanActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jButton2.setText("Double blood circulation");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnHeat.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        btnHeat.setText("Heart");
        btnHeat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 2));
        btnHeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHeatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDoubleBloodCirculation1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBloodCircleHuman, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHeat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUname)
                .addGap(18, 18, 18)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHeat, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlDoubleBloodCirculation1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBloodCircleHuman, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Main.ScienceHub sh = new Main.ScienceHub();
        sh.setId(idPas);
        sh.show();
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void lblRightVentricleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRightVentricleMouseClicked
        selectedLabal = lblRightVentricle;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {

            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblRightVentricleMouseClicked

    private void lblLeftPulmonaryArteryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLeftPulmonaryArteryMouseClicked
        selectedLabal = lblLeftPulmonaryArtery;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {

            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblLeftPulmonaryArteryMouseClicked

    private void lblLeftPulmonaryVeinsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLeftPulmonaryVeinsMouseClicked
        selectedLabal = lblLeftPulmonaryVeins;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {

            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblLeftPulmonaryVeinsMouseClicked

    private void lblBicuspidValveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBicuspidValveMouseClicked
        selectedLabal = lblBicuspidValve;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {

            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblBicuspidValveMouseClicked

    private void lblLeftAtriumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLeftAtriumMouseClicked
        selectedLabal = lblLeftAtrium;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {

            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblLeftAtriumMouseClicked

    private void lblSemiLunarValvesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSemiLunarValvesMouseClicked
        selectedLabal = lblSemiLunarValves;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {

            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblSemiLunarValvesMouseClicked

    private void lblLeftVentricleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLeftVentricleMouseClicked
        selectedLabal = lblLeftVentricle;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {

            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblLeftVentricleMouseClicked

    private void lblAortaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAortaMouseClicked

        selectedLabal = lblAorta;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {

            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblAortaMouseClicked

    private void lblInferiorVenaCavaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInferiorVenaCavaMouseClicked
        selectedLabal = lblInferiorVenaCava;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {

            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblInferiorVenaCavaMouseClicked

    private void lblTricuspiValvcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTricuspiValvcMouseClicked
        selectedLabal = lblTricuspiValvc;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {

            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblTricuspiValvcMouseClicked

    private void lblRightAtrlumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRightAtrlumMouseClicked
        selectedLabal = lblRightAtrlum;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {

            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblRightAtrlumMouseClicked

    private void lblRightPulmonaryVeinsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRightPulmonaryVeinsMouseClicked
        selectedLabal = lblRightPulmonaryVeins;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {

            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblRightPulmonaryVeinsMouseClicked

    private void lblRightPulmonaryArteryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRightPulmonaryArteryMouseClicked
        selectedLabal = lblRightPulmonaryArtery;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {

            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblRightPulmonaryArteryMouseClicked

    private void lblSuperiorVenaCavaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSuperiorVenaCavaMouseClicked
        selectedLabal = lblSuperiorVenaCava;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {

            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblSuperiorVenaCavaMouseClicked

    private void btnAorta1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAorta1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAorta1MouseClicked

    private void btnAortaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAortaActionPerformed
        complete = complete + 7;
        String txt = btnAorta.getText();
        selectedLabal.setText(txt);
        btnAorta.setVisible(false);
        disable();
    }//GEN-LAST:event_btnAortaActionPerformed

    private void btnRightAtrlumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRightAtrlumActionPerformed
        complete = complete + 7;
        String txt = btnRightAtrlum.getText();
        selectedLabal.setText(txt);
        btnRightAtrlum.setVisible(false);
        disable();
    }//GEN-LAST:event_btnRightAtrlumActionPerformed

    private void btnLeftAtriumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeftAtriumActionPerformed
        complete = complete + 7;
        String txt = btnLeftAtrium.getText();
        selectedLabal.setText(txt);
        btnLeftAtrium.setVisible(false);
        disable();
    }//GEN-LAST:event_btnLeftAtriumActionPerformed

    private void btnRightVentricleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRightVentricleActionPerformed
        complete = complete + 7;
        String txt = btnRightVentricle.getText();
        selectedLabal.setText(txt);
        btnRightVentricle.setVisible(false);
        disable();
    }//GEN-LAST:event_btnRightVentricleActionPerformed

    private void btnLeftVentricleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeftVentricleActionPerformed
        complete = complete + 7;
        String txt = btnLeftVentricle.getText();
        selectedLabal.setText(txt);
        btnLeftVentricle.setVisible(false);
        disable();
    }//GEN-LAST:event_btnLeftVentricleActionPerformed

    private void btnTricuspiValvcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTricuspiValvcActionPerformed
        complete = complete + 7;
        String txt = btnTricuspiValvc.getText();
        selectedLabal.setText(txt);
        btnTricuspiValvc.setVisible(false);
        disable();
    }//GEN-LAST:event_btnTricuspiValvcActionPerformed

    private void btnInferiorVenaCavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInferiorVenaCavaActionPerformed
        complete = complete + 7;
        String txt = btnInferiorVenaCava.getText();
        selectedLabal.setText(txt);
        btnInferiorVenaCava.setVisible(false);
        disable();
    }//GEN-LAST:event_btnInferiorVenaCavaActionPerformed

    private void btnLeftPulmonaryArteryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeftPulmonaryArteryActionPerformed
        complete = complete + 7;
        String txt = btnLeftPulmonaryArtery.getText();
        selectedLabal.setText(txt);
        btnLeftPulmonaryArtery.setVisible(false);
        disable();
    }//GEN-LAST:event_btnLeftPulmonaryArteryActionPerformed

    private void btnRightPulmonaryArteryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRightPulmonaryArteryActionPerformed
        complete = complete + 7;
        String txt = btnRightPulmonaryArtery.getText();
        selectedLabal.setText(txt);
        btnRightPulmonaryArtery.setVisible(false);
        disable();
    }//GEN-LAST:event_btnRightPulmonaryArteryActionPerformed

    private void btnLeftPulmonaryVeinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeftPulmonaryVeinsActionPerformed
        complete = complete + 7;
        String txt = btnLeftPulmonaryVeins.getText();
        selectedLabal.setText(txt);
        btnLeftPulmonaryVeins.setVisible(false);
        disable();
    }//GEN-LAST:event_btnLeftPulmonaryVeinsActionPerformed

    private void btnBicuspidValveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBicuspidValveActionPerformed
        complete = complete + 7;
        String txt = btnBicuspidValve.getText();
        selectedLabal.setText(txt);
        btnBicuspidValve.setVisible(false);
        disable();
    }//GEN-LAST:event_btnBicuspidValveActionPerformed

    private void btnRightPulmonaryVeinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRightPulmonaryVeinsActionPerformed
        complete = complete + 7;
        String txt = btnRightPulmonaryVeins.getText();
        selectedLabal.setText(txt);
        btnRightPulmonaryVeins.setVisible(false);
        disable();
    }//GEN-LAST:event_btnRightPulmonaryVeinsActionPerformed

    private void btnSuperiorVenaCavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuperiorVenaCavaActionPerformed
        complete = complete + 7;
        String txt = btnSuperiorVenaCava.getText();
        selectedLabal.setText(txt);
        btnSuperiorVenaCava.setVisible(false);
        disable();
    }//GEN-LAST:event_btnSuperiorVenaCavaActionPerformed

    private void btnSemiLunarValvesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSemiLunarValvesActionPerformed
        complete = complete + 7;
        String txt = btnSemiLunarValves.getText();
        selectedLabal.setText(txt);
        btnSemiLunarValves.setVisible(false);
        disable();
    }//GEN-LAST:event_btnSemiLunarValvesActionPerformed

    private void btnReattamptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReattamptActionPerformed
        btnChack.setEnabled(true);
        if (health == 0) {
            health = 4;
            health1.setVisible(true);
            health2.setVisible(true);
            health3.setVisible(true);
            health4.setVisible(true);
        }
        reattampt();
    }//GEN-LAST:event_btnReattamptActionPerformed

    private void btnChackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChackActionPerformed

        score = 0;
        ///////////
        if (lblAorta.getText().equals("Aorta")) {
            lblAorta.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 7;

        } else {
            lblAorta.setBorder(BorderFactory.createLineBorder(Color.red));

        }
        ///////////
        if (lblLeftPulmonaryArtery.getText().equals("Left pulmonary artery")) {
            lblLeftPulmonaryArtery.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 7;

        } else {
            lblLeftPulmonaryArtery.setBorder(BorderFactory.createLineBorder(Color.red));

        }
        ///////////
        if (lblLeftPulmonaryVeins.getText().equals("Left Pulmonary veins")) {
            lblLeftPulmonaryVeins.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 7;

        } else {
            lblLeftPulmonaryVeins.setBorder(BorderFactory.createLineBorder(Color.red));

        }
        ///////////
        if (lblLeftAtrium.getText().equals("Left atrium")) {
            lblLeftAtrium.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 7;

        } else {
            lblLeftAtrium.setBorder(BorderFactory.createLineBorder(Color.red));

        }///////////
        if (lblBicuspidValve.getText().equals("Bicuspid valve")) {
            lblBicuspidValve.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 7;

        } else {
            lblBicuspidValve.setBorder(BorderFactory.createLineBorder(Color.red));

        }///////////
        if (lblSemiLunarValves.getText().equals("Semi lunar valves")) {
            lblSemiLunarValves.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 7;

        } else {
            lblSemiLunarValves.setBorder(BorderFactory.createLineBorder(Color.red));

        }///////////
        if (lblLeftVentricle.getText().equals("Left ventricle")) {
            lblLeftVentricle.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 7;

        } else {
            lblLeftVentricle.setBorder(BorderFactory.createLineBorder(Color.red));

        }///////////
        if (lblRightVentricle.getText().equals("Right ventricle")) {
            lblRightVentricle.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 7;

        } else {
            lblRightVentricle.setBorder(BorderFactory.createLineBorder(Color.red));

        }///////////
        if (lblInferiorVenaCava.getText().equals("Inferior vena cava")) {
            lblInferiorVenaCava.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 7;

        } else {
            lblInferiorVenaCava.setBorder(BorderFactory.createLineBorder(Color.red));

        }///////////
        if (lblTricuspiValvc.getText().equals("Tricuspi valvc")) {
            lblTricuspiValvc.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 7;

        } else {
            lblTricuspiValvc.setBorder(BorderFactory.createLineBorder(Color.red));

        }///////////
        if (lblRightAtrlum.getText().equals("Right atrlum")) {
            lblRightAtrlum.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 7;

        } else {
            lblRightAtrlum.setBorder(BorderFactory.createLineBorder(Color.red));

        }///////////
        if (lblRightPulmonaryVeins.getText().equals("Right Pulmonary veins")) {
            lblRightPulmonaryVeins.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 7;

        } else {
            lblRightPulmonaryVeins.setBorder(BorderFactory.createLineBorder(Color.red));

        }///////////
        if (lblRightPulmonaryArtery.getText().equals("Right Pulmonary artery")) {
            lblRightPulmonaryArtery.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 7;

        } else {
            lblRightPulmonaryArtery.setBorder(BorderFactory.createLineBorder(Color.red));

        }///////////
        if (lblSuperiorVenaCava.getText().equals("Superior vena cava")) {
            lblSuperiorVenaCava.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 7;

        } else {
            lblSuperiorVenaCava.setBorder(BorderFactory.createLineBorder(Color.red));

        }
        if (complete == 98) {
            complete = complete + 2;
        }

        lblComplete.setText("Completed - " + complete + "%");

        if (score == 98) {
            score = score + 2;
            btnReattampt.setEnabled(false);
            btnChack.setEnabled(false);
        } else {
            health--;
            if (health == 3) {
                health4.setVisible(false);
            } else if (health == 2) {
                health3.setVisible(false);
            } else if (health == 1) {
                health2.setVisible(false);
            } else if (health == 0) {
                health1.setVisible(false);
                btnChack.setEnabled(false);
                btnReattampt.setEnabled(true);

            }
        }
        lblScore.setText(score + "");
        lblScoreSide.setText("Score - " + score);
        insertToSql();

    }//GEN-LAST:event_btnChackActionPerformed

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked

    }//GEN-LAST:event_jPanel12MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked

    }//GEN-LAST:event_jPanel14MouseClicked

    private void btnBloodCircleHumanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBloodCircleHumanActionPerformed
        Science.HumanHeart hh = new HumanHeart();
        hh.setId(idPas);
        hh.show();
        this.dispose();
    }//GEN-LAST:event_btnBloodCircleHumanActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Science.DoubleBloodCirculer bch = new Science.DoubleBloodCirculer();
        bch.setId(idPas);
        bch.show();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnHeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHeatActionPerformed

    }//GEN-LAST:event_btnHeatActionPerformed

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
            java.util.logging.Logger.getLogger(HumanHeart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HumanHeart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HumanHeart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HumanHeart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HumanHeart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAorta;
    private javax.swing.JLabel btnAorta1;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBicuspidValve;
    private javax.swing.JButton btnBloodCircleHuman;
    private javax.swing.JButton btnChack;
    private javax.swing.JButton btnHeat;
    private javax.swing.JButton btnInferiorVenaCava;
    private javax.swing.JButton btnLeftAtrium;
    private javax.swing.JButton btnLeftPulmonaryArtery;
    private javax.swing.JButton btnLeftPulmonaryVeins;
    private javax.swing.JButton btnLeftVentricle;
    private javax.swing.JButton btnReattampt;
    private javax.swing.JButton btnRightAtrlum;
    private javax.swing.JButton btnRightPulmonaryArtery;
    private javax.swing.JButton btnRightPulmonaryVeins;
    private javax.swing.JButton btnRightVentricle;
    private javax.swing.JButton btnSemiLunarValves;
    private javax.swing.JButton btnSuperiorVenaCava;
    private javax.swing.JButton btnTricuspiValvc;
    private javax.swing.JLabel dbcCoplete1;
    private javax.swing.JLabel dbcScore1;
    private javax.swing.JButton health1;
    private javax.swing.JButton health2;
    private javax.swing.JButton health3;
    private javax.swing.JButton health4;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JLabel lblAorta;
    private javax.swing.JLabel lblBicuspidValve;
    private javax.swing.JLabel lblComplete;
    private javax.swing.JLabel lblDbc1;
    private javax.swing.JLabel lblInferiorVenaCava;
    private javax.swing.JLabel lblLeftAtrium;
    private javax.swing.JLabel lblLeftPulmonaryArtery;
    private javax.swing.JLabel lblLeftPulmonaryVeins;
    private javax.swing.JLabel lblLeftVentricle;
    private javax.swing.JLabel lblMainObject;
    private javax.swing.JLabel lblRightAtrlum;
    private javax.swing.JLabel lblRightPulmonaryArtery;
    private javax.swing.JLabel lblRightPulmonaryVeins;
    private javax.swing.JLabel lblRightVentricle;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblScoreSide;
    private javax.swing.JLabel lblSemiLunarValves;
    private javax.swing.JLabel lblSuperiorVenaCava;
    private javax.swing.JLabel lblTitle17;
    private javax.swing.JLabel lblTitle18;
    private javax.swing.JLabel lblTricuspiValvc;
    private javax.swing.JLabel lblUname;
    private javax.swing.JLabel lblUserName6;
    private javax.swing.JLabel lblUserName9;
    private javax.swing.JPanel pnlAnswer;
    private javax.swing.JPanel pnlDoubleBloodCirculation1;
    private javax.swing.JPanel pnl_Header;
    // End of variables declaration//GEN-END:variables
}
