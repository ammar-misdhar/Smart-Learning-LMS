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
import javax.swing.JOptionPane;

/**
 *
 * @author mmamm
 */
public class DoubleBloodCirculer extends javax.swing.JFrame {

    /**
     * Creates new form DoubleBloodCirculer
     */
    JLabel selectedLabal;

    public DoubleBloodCirculer() {
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
            PreparedStatement st1 = con.prepareStatement("UPDATE `smart_learning`.`science` SET `DoublBloodCirculationScore` = ?, `DoublBloodCirculationCoplete` = ? WHERE (`stRegId` = '" + idPas + "');");
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

        btnLungs.setVisible(true);
        btnPulmonaryVeins.setVisible(true);
        btnSystemicArtery.setVisible(true);
        btnOrgans.setVisible(true);
        btnPulmonaryArtery.setVisible(true);
        btnSuperiorVenaCava.setVisible(true);

        lblLungs.setText("");

        lblOrgans.setText("");

        lblPulmonaryVeins.setText("");
        lblSuperiorVenaCava.setText("");
        lblSystemicArtery.setText("");

        lblInferiorVenaCava.setText("");
        lblPulmonaryArtery.setText("");

        score = 0;
        dbcScore.setText("Score - " + score);
        lblScore.setText(score + "");

        complete = 0;
        dbcCoplete.setText("Completed - " + complete + "%");

        btnReattampt.setEnabled(false);

    }

    public void enable() {

        btnLungs.setEnabled(true);
        btnPulmonaryVeins.setEnabled(true);
        btnSystemicArtery.setEnabled(true);
        btnOrgans.setEnabled(true);
        btnPulmonaryArtery.setEnabled(true);
        btnSuperiorVenaCava.setEnabled(true);
    }

    public void disable() {

        btnLungs.setEnabled(false);
        btnPulmonaryVeins.setEnabled(false);
        btnSystemicArtery.setEnabled(false);
        btnOrgans.setEnabled(false);
        btnPulmonaryArtery.setEnabled(false);
        btnSuperiorVenaCava.setEnabled(false);
    }

    public void dfault() {
        lblLungs.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));

        lblOrgans.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));

        lblPulmonaryVeins.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        lblSuperiorVenaCava.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        lblSystemicArtery.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));

        lblInferiorVenaCava.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        lblPulmonaryArtery.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));

        disable();
    }

    public void selectLabal() {
        selectedLabal.setBorder(BorderFactory.createLineBorder(Color.blue));
        enable();
    }

    public void retunButon() {

        complete = complete - 14;

        if (selectedLabal.getText().equals("Lungs")) {
            btnLungs.setVisible(true);
        } else if (selectedLabal.getText().equals("Pulmonary Veins")) {
            btnPulmonaryVeins.setVisible(true);
        } else if (selectedLabal.getText().equals("Systemic Artery")) {
            btnSystemicArtery.setVisible(true);
        } else if (selectedLabal.getText().equals("Organs")) {
            btnOrgans.setVisible(true);
        } else if (selectedLabal.getText().equals("Pulmonary Artery")) {
            btnPulmonaryArtery.setVisible(true);
        } else if (selectedLabal.getText().equals("Superior Vena Cava")) {
            btnSuperiorVenaCava.setVisible(true);
        } else if (selectedLabal.getText().equals("Inferior Vena Cava")) {
            btnInferiorVenaCava.setVisible(true);
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
        jLabel8 = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        health4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        health1 = new javax.swing.JButton();
        lblMainObject = new javax.swing.JLabel();
        health2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        health3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblPulmonaryVeins = new javax.swing.JLabel();
        lblSystemicArtery = new javax.swing.JLabel();
        lblOrgans = new javax.swing.JLabel();
        lblLungs = new javax.swing.JLabel();
        lblInferiorVenaCava = new javax.swing.JLabel();
        lblSuperiorVenaCava = new javax.swing.JLabel();
        lblPulmonaryArtery = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnAorta1 = new javax.swing.JLabel();
        pnlAnswer = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnLungs = new javax.swing.JButton();
        btnPulmonaryVeins = new javax.swing.JButton();
        btnSystemicArtery = new javax.swing.JButton();
        btnOrgans = new javax.swing.JButton();
        btnPulmonaryArtery = new javax.swing.JButton();
        btnSuperiorVenaCava = new javax.swing.JButton();
        btnInferiorVenaCava = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnReattampt = new javax.swing.JButton();
        btnChack = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        pnlDoubleBloodCirculation = new javax.swing.JPanel();
        lblDbc = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        dbcCoplete = new javax.swing.JLabel();
        dbcScore = new javax.swing.JLabel();
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
        setResizable(false);

        pnl_Header.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Score");
        pnl_Header.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, -1, -1));

        lblScore.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblScore.setForeground(new java.awt.Color(51, 51, 51));
        lblScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScore.setText("000");
        pnl_Header.add(lblScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, 39, -1));

        health4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hart.png"))); // NOI18N
        health4.setBorder(null);
        health4.setContentAreaFilled(false);
        pnl_Header.add(health4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

        jLabel7.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Health");
        pnl_Header.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 194, 20));

        health1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hart.png"))); // NOI18N
        health1.setBorder(null);
        health1.setContentAreaFilled(false);
        pnl_Header.add(health1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        lblMainObject.setFont(new java.awt.Font("Poppins SemiBold", 0, 24)); // NOI18N
        lblMainObject.setForeground(new java.awt.Color(51, 51, 51));
        lblMainObject.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMainObject.setText("Double Blood Circulation");
        pnl_Header.add(lblMainObject, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 344, -1));

        health2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hart.png"))); // NOI18N
        health2.setBorder(null);
        health2.setContentAreaFilled(false);
        pnl_Header.add(health2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 50, -1));

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Set the correct body parts name in correct place.");
        pnl_Header.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, -1, -1));

        health3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hart.png"))); // NOI18N
        health3.setBorder(null);
        health3.setContentAreaFilled(false);
        pnl_Header.add(health3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/scienceTitle.png"))); // NOI18N
        pnl_Header.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 88));

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

        lblPulmonaryVeins.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblPulmonaryVeins.setForeground(new java.awt.Color(102, 102, 102));
        lblPulmonaryVeins.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPulmonaryVeins.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblPulmonaryVeins.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPulmonaryVeins.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPulmonaryVeinsMouseClicked(evt);
            }
        });
        jPanel3.add(lblPulmonaryVeins, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 160, 30));

        lblSystemicArtery.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblSystemicArtery.setForeground(new java.awt.Color(102, 102, 102));
        lblSystemicArtery.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSystemicArtery.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblSystemicArtery.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSystemicArtery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSystemicArteryMouseClicked(evt);
            }
        });
        jPanel3.add(lblSystemicArtery, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, 160, 30));

        lblOrgans.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblOrgans.setForeground(new java.awt.Color(102, 102, 102));
        lblOrgans.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOrgans.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblOrgans.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblOrgans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOrgansMouseClicked(evt);
            }
        });
        jPanel3.add(lblOrgans, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 160, 30));

        lblLungs.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblLungs.setForeground(new java.awt.Color(102, 102, 102));
        lblLungs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLungs.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblLungs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLungs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLungsMouseClicked(evt);
            }
        });
        jPanel3.add(lblLungs, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 160, 30));

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
        jPanel3.add(lblInferiorVenaCava, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 150, 30));

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
        jPanel3.add(lblSuperiorVenaCava, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 150, 30));

        lblPulmonaryArtery.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblPulmonaryArtery.setForeground(new java.awt.Color(102, 102, 102));
        lblPulmonaryArtery.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPulmonaryArtery.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblPulmonaryArtery.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPulmonaryArtery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPulmonaryArteryMouseClicked(evt);
            }
        });
        jPanel3.add(lblPulmonaryArtery, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 150, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/doubleBood.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 570, 411));

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
        jPanel3.add(btnAorta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 530, -1));

        pnlAnswer.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Answers");

        btnLungs.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnLungs.setForeground(new java.awt.Color(102, 102, 102));
        btnLungs.setText("Lungs");
        btnLungs.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnLungs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLungs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLungsActionPerformed(evt);
            }
        });

        btnPulmonaryVeins.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnPulmonaryVeins.setForeground(new java.awt.Color(102, 102, 102));
        btnPulmonaryVeins.setText("Pulmonary Veins");
        btnPulmonaryVeins.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnPulmonaryVeins.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPulmonaryVeins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPulmonaryVeinsActionPerformed(evt);
            }
        });

        btnSystemicArtery.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnSystemicArtery.setForeground(new java.awt.Color(102, 102, 102));
        btnSystemicArtery.setText("Systemic Artery");
        btnSystemicArtery.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnSystemicArtery.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSystemicArtery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSystemicArteryActionPerformed(evt);
            }
        });

        btnOrgans.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnOrgans.setForeground(new java.awt.Color(102, 102, 102));
        btnOrgans.setText("Organs");
        btnOrgans.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnOrgans.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOrgans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrgansActionPerformed(evt);
            }
        });

        btnPulmonaryArtery.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnPulmonaryArtery.setForeground(new java.awt.Color(102, 102, 102));
        btnPulmonaryArtery.setText("Pulmonary Artery");
        btnPulmonaryArtery.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnPulmonaryArtery.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPulmonaryArtery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPulmonaryArteryActionPerformed(evt);
            }
        });

        btnSuperiorVenaCava.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnSuperiorVenaCava.setForeground(new java.awt.Color(102, 102, 102));
        btnSuperiorVenaCava.setText("Superior Vena Cava");
        btnSuperiorVenaCava.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnSuperiorVenaCava.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSuperiorVenaCava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuperiorVenaCavaActionPerformed(evt);
            }
        });

        btnInferiorVenaCava.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnInferiorVenaCava.setForeground(new java.awt.Color(102, 102, 102));
        btnInferiorVenaCava.setText("Inferior Vena Cava");
        btnInferiorVenaCava.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnInferiorVenaCava.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInferiorVenaCava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInferiorVenaCavaActionPerformed(evt);
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
                    .addComponent(btnLungs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPulmonaryVeins, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSystemicArtery, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOrgans, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuperiorVenaCava, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPulmonaryArtery, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInferiorVenaCava, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlAnswerLayout.setVerticalGroup(
            pnlAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAnswerLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(45, 45, 45)
                .addComponent(btnInferiorVenaCava, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLungs, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPulmonaryVeins, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSystemicArtery, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOrgans, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPulmonaryArtery, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSuperiorVenaCava, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
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
                .addGap(7, 7, 7)
                .addComponent(btnChack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReattampt)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChack)
                    .addComponent(btnReattampt))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(pnlAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnl_Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnl_Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        pnlDoubleBloodCirculation.setBackground(new java.awt.Color(247, 247, 247));
        pnlDoubleBloodCirculation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlDoubleBloodCirculation.setEnabled(false);

        lblDbc.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        lblDbc.setForeground(new java.awt.Color(51, 51, 51));
        lblDbc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDbc.setText("Double blood circulation");

        dbcCoplete.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        dbcCoplete.setForeground(new java.awt.Color(51, 51, 51));
        dbcCoplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dbcCoplete.setText("Completed - 0%");

        dbcScore.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        dbcScore.setForeground(new java.awt.Color(51, 51, 51));
        dbcScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dbcScore.setText("Score - 0");

        javax.swing.GroupLayout pnlDoubleBloodCirculationLayout = new javax.swing.GroupLayout(pnlDoubleBloodCirculation);
        pnlDoubleBloodCirculation.setLayout(pnlDoubleBloodCirculationLayout);
        pnlDoubleBloodCirculationLayout.setHorizontalGroup(
            pnlDoubleBloodCirculationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoubleBloodCirculationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDoubleBloodCirculationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDbc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dbcScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dbcCoplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator10))
                .addContainerGap())
        );
        pnlDoubleBloodCirculationLayout.setVerticalGroup(
            pnlDoubleBloodCirculationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoubleBloodCirculationLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblDbc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dbcCoplete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dbcScore)
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
        lblUserName9.setForeground(new java.awt.Color(102, 102, 102));
        lblUserName9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserName9.setText("Heart");

        lblComplete.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        lblComplete.setForeground(new java.awt.Color(102, 102, 102));
        lblComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblComplete.setText("Completed - 0%");

        lblScoreSide.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        lblScoreSide.setForeground(new java.awt.Color(102, 102, 102));
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
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255), 2));

        btnHeat.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        btnHeat.setText("Heart");
        btnHeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHeatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDoubleBloodCirculation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBloodCircleHuman, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHeat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUname)
                .addGap(18, 18, 18)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHeat, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlDoubleBloodCirculation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBloodCircleHuman, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
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

    private void lblPulmonaryVeinsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPulmonaryVeinsMouseClicked
        selectedLabal = lblPulmonaryVeins;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {

            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblPulmonaryVeinsMouseClicked

    private void lblSystemicArteryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSystemicArteryMouseClicked
        selectedLabal = lblSystemicArtery;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {

            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblSystemicArteryMouseClicked

    private void lblOrgansMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOrgansMouseClicked
        selectedLabal = lblOrgans;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {

            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblOrgansMouseClicked

    private void lblLungsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLungsMouseClicked

        selectedLabal = lblLungs;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {
            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblLungsMouseClicked

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

    private void lblPulmonaryArteryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPulmonaryArteryMouseClicked
        selectedLabal = lblPulmonaryArtery;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {

            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblPulmonaryArteryMouseClicked

    private void btnAorta1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAorta1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAorta1MouseClicked

    private void btnPulmonaryVeinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPulmonaryVeinsActionPerformed
        complete = complete + 14;
        String txt = btnPulmonaryVeins.getText();
        selectedLabal.setText(txt);
        btnPulmonaryVeins.setVisible(false);
        disable();
    }//GEN-LAST:event_btnPulmonaryVeinsActionPerformed

    private void btnSystemicArteryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSystemicArteryActionPerformed
        complete = complete + 14;
        String txt = btnSystemicArtery.getText();
        selectedLabal.setText(txt);
        btnSystemicArtery.setVisible(false);
        disable();
    }//GEN-LAST:event_btnSystemicArteryActionPerformed

    private void btnOrgansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrgansActionPerformed
        complete = complete + 14;
        String txt = btnOrgans.getText();
        selectedLabal.setText(txt);
        btnOrgans.setVisible(false);
        disable();
    }//GEN-LAST:event_btnOrgansActionPerformed

    private void btnPulmonaryArteryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPulmonaryArteryActionPerformed
        complete = complete + 14;
        String txt = btnPulmonaryArtery.getText();
        selectedLabal.setText(txt);
        btnPulmonaryArtery.setVisible(false);
        disable();
    }//GEN-LAST:event_btnPulmonaryArteryActionPerformed

    private void btnSuperiorVenaCavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuperiorVenaCavaActionPerformed
        complete = complete + 14;
        String txt = btnSuperiorVenaCava.getText();
        selectedLabal.setText(txt);
        btnSuperiorVenaCava.setVisible(false);
        disable();
    }//GEN-LAST:event_btnSuperiorVenaCavaActionPerformed

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
        if (lblLungs.getText().equals("Lungs")) {
            lblLungs.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 14;

        } else {
            lblLungs.setBorder(BorderFactory.createLineBorder(Color.red));

        }
        ///////////
        if (lblPulmonaryVeins.getText().equals("Pulmonary Veins")) {
            lblPulmonaryVeins.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 14;

        } else {
            lblPulmonaryVeins.setBorder(BorderFactory.createLineBorder(Color.red));

        }
        ///////////
        if (lblSystemicArtery.getText().equals("Systemic Artery")) {
            lblSystemicArtery.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 14;

        } else {
            lblSystemicArtery.setBorder(BorderFactory.createLineBorder(Color.red));

        }
        ///////////
        if (lblOrgans.getText().equals("Organs")) {
            lblOrgans.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 14;

        } else {
            lblOrgans.setBorder(BorderFactory.createLineBorder(Color.red));

        }///////////

        if (lblInferiorVenaCava.getText().equals("Inferior Vena Cava")) {
            lblInferiorVenaCava.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 14;

        } else {
            lblInferiorVenaCava.setBorder(BorderFactory.createLineBorder(Color.red));

        }///////////
        if (lblSuperiorVenaCava.getText().equals("Superior Vena Cava")) {
            lblSuperiorVenaCava.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 14;

        } else {
            lblSuperiorVenaCava.setBorder(BorderFactory.createLineBorder(Color.red));

        }///////////
        if (lblPulmonaryArtery.getText().equals("Pulmonary Artery")) {
            lblPulmonaryArtery.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 14;

        } else {
            lblPulmonaryArtery.setBorder(BorderFactory.createLineBorder(Color.red));

        }

        if (complete == 98) {
            complete = complete + 2;
        }

        dbcCoplete.setText("Completed - " + complete + "%");

        if (score == 98) {
            score = score + 2;
            btnReattampt.setEnabled(false);
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
        dbcScore.setText("Score - " + score);
        insertToSql();
    }//GEN-LAST:event_btnChackActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnLungsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLungsActionPerformed
        complete = complete + 14;
        String txt = btnLungs.getText();
        selectedLabal.setText(txt);
        btnLungs.setVisible(false);
        disable();
    }//GEN-LAST:event_btnLungsActionPerformed

    private void btnInferiorVenaCavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInferiorVenaCavaActionPerformed
        // TODO add your handling code here:
        complete = complete + 14;
        String txt = btnInferiorVenaCava.getText();
        selectedLabal.setText(txt);
        btnInferiorVenaCava.setVisible(false);
        disable();
    }//GEN-LAST:event_btnInferiorVenaCavaActionPerformed

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked

    }//GEN-LAST:event_jPanel14MouseClicked

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
       
    }//GEN-LAST:event_jPanel12MouseClicked

    private void btnHeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHeatActionPerformed
        Science.HumanHeart hh = new HumanHeart();
        hh.setId(idPas);
        hh.show();
        this.dispose();
    }//GEN-LAST:event_btnHeatActionPerformed

    private void btnBloodCircleHumanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBloodCircleHumanActionPerformed
        Science.BloodCirculationOfHuman bch = new BloodCirculationOfHuman();
        bch.setId(idPas);
        bch.show();
        this.dispose();
    }//GEN-LAST:event_btnBloodCircleHumanActionPerformed

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
            java.util.logging.Logger.getLogger(DoubleBloodCirculer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoubleBloodCirculer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoubleBloodCirculer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoubleBloodCirculer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoubleBloodCirculer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAorta1;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBloodCircleHuman;
    private javax.swing.JButton btnChack;
    private javax.swing.JButton btnHeat;
    private javax.swing.JButton btnInferiorVenaCava;
    private javax.swing.JButton btnLungs;
    private javax.swing.JButton btnOrgans;
    private javax.swing.JButton btnPulmonaryArtery;
    private javax.swing.JButton btnPulmonaryVeins;
    private javax.swing.JButton btnReattampt;
    private javax.swing.JButton btnSuperiorVenaCava;
    private javax.swing.JButton btnSystemicArtery;
    private javax.swing.JLabel dbcCoplete;
    private javax.swing.JLabel dbcScore;
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
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JLabel lblComplete;
    private javax.swing.JLabel lblDbc;
    private javax.swing.JLabel lblInferiorVenaCava;
    private javax.swing.JLabel lblLungs;
    private javax.swing.JLabel lblMainObject;
    private javax.swing.JLabel lblOrgans;
    private javax.swing.JLabel lblPulmonaryArtery;
    private javax.swing.JLabel lblPulmonaryVeins;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblScoreSide;
    private javax.swing.JLabel lblSuperiorVenaCava;
    private javax.swing.JLabel lblSystemicArtery;
    private javax.swing.JLabel lblTitle17;
    private javax.swing.JLabel lblTitle18;
    private javax.swing.JLabel lblUname;
    private javax.swing.JLabel lblUserName6;
    private javax.swing.JLabel lblUserName9;
    private javax.swing.JPanel pnlAnswer;
    private javax.swing.JPanel pnlDoubleBloodCirculation;
    private javax.swing.JPanel pnl_Header;
    // End of variables declaration//GEN-END:variables
}
