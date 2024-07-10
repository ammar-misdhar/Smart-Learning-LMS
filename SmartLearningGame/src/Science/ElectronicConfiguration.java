/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Science;

import Main.Deshbord;
import Main.ScienceHub;
import java.awt.Color;
import java.awt.Panel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author mmamm
 */
public class ElectronicConfiguration extends javax.swing.JFrame {

    /**
     * Creates new form ElectronicConfiguration
     */
    //Rounds
    int roundOne = 0;
    int roundTwo = 0;
    int roundThree = 0;
    //Score
    int score = 0;
    //Health
    int helthDrop = 4;
    //Qustion Count
    int count = 0;
    //Qustion Count Down
    int qustion = 17;
    //Completed
    int complete = 0;
    
    public ElectronicConfiguration() {
        initComponents();
        startup();
        
    }
    String idpas = "";
    
    public void qustionChange() {
        
        if (lblMainObject.getText().equals("Si")) {
            btnNext.setText("Finish");
            btnNext.setEnabled(false);
            btnChack.setEnabled(false);
            
            if (score < 85) {
                btnReattampt.setVisible(true);
            } else {
                btnReattampt.setVisible(false);
            }
            
        } else {
            
            String[] letters = {"He", "Li", "H", "Be", "B", "Ar", "C", "F", "O", "Ne", "Mg", "Na", "N", "Cl", "P", "S", "Al", "Si"};
            lblMainObject.setText(letters[count]);
            
            reset();
            btnNext.setEnabled(false);
            btnChack.setEnabled(true);
            //

        }
    }
    
    public void setId(String id) {
        idpas = id;
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
        
        setLoadeGame();
    }
    
    public void setLoadeGame() {
        
        String obj = lblMainObject.getText();
        try {
            Connection con = database.db.getConnection();
            String sql = "SELECT ElectronicConScore,ElectronicConCoplete,ElectronicConLastQustion,ElectronicConCoundDown FROM smart_learning.science where stRegId=? ;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, idpas);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String scoregame = rs.getString("ElectronicConScore");
                String completeGame = rs.getString("ElectronicConCoplete");
                String qustioncount = rs.getString("ElectronicConLastQustion");
                String countDown = rs.getString("ElectronicConCoundDown");
                
                lblScore.setText(scoregame);
                lblScoreSide.setText("Score - " + scoregame);
                
                lblComplete.setText("Completed - " + completeGame + " %");
                
                lblQustion.setText("Qustions Count Down - " + countDown);
                
                qustion = Integer.valueOf(countDown);
                score = Integer.valueOf(scoregame);
                complete = Integer.valueOf(completeGame);
                count = Integer.valueOf(qustioncount);

                ////
                qustionChange();
                ////

                if (lblMainObject.getText().equals("Si")) {
                    btnNext.setText("Finish");
                    btnNext.setEnabled(false);
                    btnChack.setEnabled(false);
                    
                    if (score < 90) {
                        btnReattampt.setVisible(true);
                    } else {
                        btnReattampt.setVisible(false);
                    }
                }
                
                if (complete == 90 && score == 0) {
                    fullResetGame();
                }
                
                if (score >= 50) {
                    lblElectronicCon1.setEnabled(true);
                }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ElectronicConfiguration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertToSql() {
        try {
            // create connection to database
            Connection con = database.db.getConnection();
            // Create prepared statement with the sql query
            PreparedStatement st1 = con.prepareStatement("UPDATE `smart_learning`.`science` SET `ElectronicConScore` = ?, `ElectronicConCoplete` = ?, `ElectronicConLastQustion` = ?, `ElectronicConCoundDown` = ? WHERE (`stRegId` = '" + idpas + "');");
            // execute query
            st1.setString(1, score + "");
            st1.setString(2, complete + "");
            st1.setString(3, count + "");
            st1.setString(4, qustion + "");
            
            st1.executeUpdate();
            lblScore.setText(score + "");

            // show success message
        } catch (SQLException ex) {
            Logger.getLogger(ElectronicConfiguration.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    public void fullResetGame() {
        btnNext.setText("Next");
        complete = 0;
        lblComplete.setText("Completed - " + complete + "%");
        helthDrop = 4;
        health1.setVisible(true);
        health2.setVisible(true);
        health3.setVisible(true);
        health4.setVisible(true);
        score = 0;
        lblScoreSide.setText("Score - " + score);
        lblScore.setText("0");
        count = 0;
        String[] letters = {"He", "Li", "H", "Be", "B", "Ar", "C", "F", "O", "Ne", "Mg", "Na", "N", "Cl", "P", "S", "Al", "Si",};
        lblMainObject.setText(letters[count]);
        btnChack.setEnabled(true);
        qustion = 17;
        lblQustion.setText("Qustions Count Down - " + qustion);
        reset();
    }
    
    public void startup() {
        btnReattampt.setVisible(false);
        
        ir1_b1.setVisible(false);
        ir1_b2.setVisible(false);
        ir1_b3.setVisible(false);
        ir1_b4.setVisible(false);
        //
        ir2_b1.setVisible(false);
        ir2_b2.setVisible(false);
        ir2_b3.setVisible(false);
        ir2_b4.setVisible(false);
        ir2_b5.setVisible(false);
        ir2_b6.setVisible(false);
        ir2_b7.setVisible(false);
        ir2_b8.setVisible(false);
        //
        ir3_b1.setVisible(false);
        ir3_b2.setVisible(false);
        ir3_b3.setVisible(false);
        ir3_b4.setVisible(false);
        ir3_b5.setVisible(false);
        ir3_b6.setVisible(false);
        ir3_b7.setVisible(false);
        ir3_b8.setVisible(false);
        //
        btnNext.setEnabled(false);
        
    }
    
    public void reset() {
        roundOne = 0;
        roundTwo = 0;
        roundThree = 0;
        //
        ir1_b1.setVisible(false);
        ir1_b2.setVisible(false);
        ir1_b3.setVisible(false);
        ir1_b4.setVisible(false);
        //
        ir2_b1.setVisible(false);
        ir2_b2.setVisible(false);
        ir2_b3.setVisible(false);
        ir2_b4.setVisible(false);
        ir2_b5.setVisible(false);
        ir2_b6.setVisible(false);
        ir2_b7.setVisible(false);
        ir2_b8.setVisible(false);
        //
        ir3_b1.setVisible(false);
        ir3_b2.setVisible(false);
        ir3_b3.setVisible(false);
        ir3_b4.setVisible(false);
        ir3_b5.setVisible(false);
        ir3_b6.setVisible(false);
        ir3_b7.setVisible(false);
        ir3_b8.setVisible(false);
        //------------------------------------
        r1_b1.setVisible(true);
        r1_b2.setVisible(true);
        r1_b3.setVisible(true);
        r1_b4.setVisible(true);
        //
        r2_b1.setVisible(true);
        r2_b2.setVisible(true);
        r2_b3.setVisible(true);
        r2_b4.setVisible(true);
        r2_b5.setVisible(true);
        r2_b6.setVisible(true);
        r2_b7.setVisible(true);
        r2_b8.setVisible(true);
        //
        r3_b1.setVisible(true);
        r3_b2.setVisible(true);
        r3_b3.setVisible(true);
        r3_b4.setVisible(true);
        r3_b5.setVisible(true);
        r3_b6.setVisible(true);
        r3_b7.setVisible(true);
        r3_b8.setVisible(true);
        //---------------------------------
        btnNext.setEnabled(false);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        pnl_Header = new javax.swing.JPanel();
        lblMainObject = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        health4 = new javax.swing.JButton();
        health3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        health1 = new javax.swing.JButton();
        health2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        r1_b4 = new javax.swing.JButton();
        r1_b2 = new javax.swing.JButton();
        r1_b3 = new javax.swing.JButton();
        r1_b1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        r2_b3 = new javax.swing.JButton();
        r2_b2 = new javax.swing.JButton();
        r2_b6 = new javax.swing.JButton();
        r2_b4 = new javax.swing.JButton();
        r2_b7 = new javax.swing.JButton();
        r2_b8 = new javax.swing.JButton();
        r2_b5 = new javax.swing.JButton();
        r2_b1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        r3_b1 = new javax.swing.JButton();
        r3_b2 = new javax.swing.JButton();
        r3_b3 = new javax.swing.JButton();
        r3_b4 = new javax.swing.JButton();
        r3_b5 = new javax.swing.JButton();
        r3_b6 = new javax.swing.JButton();
        r3_b7 = new javax.swing.JButton();
        r3_b8 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        btnNext = new javax.swing.JButton();
        btnChack = new javax.swing.JButton();
        lblQustion = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        ir1_b1 = new javax.swing.JButton();
        ir1_b2 = new javax.swing.JButton();
        ir1_b3 = new javax.swing.JButton();
        ir1_b4 = new javax.swing.JButton();
        ir2_b1 = new javax.swing.JButton();
        ir2_b2 = new javax.swing.JButton();
        ir2_b3 = new javax.swing.JButton();
        ir2_b4 = new javax.swing.JButton();
        ir2_b5 = new javax.swing.JButton();
        ir2_b6 = new javax.swing.JButton();
        ir2_b7 = new javax.swing.JButton();
        ir2_b8 = new javax.swing.JButton();
        ir3_b1 = new javax.swing.JButton();
        ir3_b2 = new javax.swing.JButton();
        ir3_b3 = new javax.swing.JButton();
        ir3_b4 = new javax.swing.JButton();
        ir3_b5 = new javax.swing.JButton();
        ir3_b6 = new javax.swing.JButton();
        ir3_b7 = new javax.swing.JButton();
        ir3_b8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnReattampt = new javax.swing.JButton();
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
        lblElectronicCon2 = new javax.swing.JButton();
        lblElectronicCon1 = new javax.swing.JButton();
        btnHeat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnl_Header.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMainObject.setFont(new java.awt.Font("Segoe UI", 2, 28)); // NOI18N
        lblMainObject.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMainObject.setText("He");
        pnl_Header.add(lblMainObject, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 333, -1));

        lblScore.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblScore.setForeground(new java.awt.Color(102, 102, 102));
        lblScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScore.setText("000");
        pnl_Header.add(lblScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 40, 39, -1));

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Set the number of electrons of a given element.");
        pnl_Header.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));

        jLabel7.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Health");
        pnl_Header.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 194, 20));

        health4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hart.png"))); // NOI18N
        health4.setBorder(null);
        health4.setContentAreaFilled(false);
        pnl_Header.add(health4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));

        health3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hart.png"))); // NOI18N
        health3.setBorder(null);
        health3.setContentAreaFilled(false);
        pnl_Header.add(health3, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 40, 50, -1));

        jLabel8.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Score");
        pnl_Header.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, -1, -1));

        health1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hart.png"))); // NOI18N
        health1.setBorder(null);
        health1.setContentAreaFilled(false);
        pnl_Header.add(health1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        health2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hart.png"))); // NOI18N
        health2.setBorder(null);
        health2.setContentAreaFilled(false);
        pnl_Header.add(health2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/scienceTitle.png"))); // NOI18N
        pnl_Header.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -6, 810, 100));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        r1_b4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/orangergb.png"))); // NOI18N
        r1_b4.setBorder(null);
        r1_b4.setContentAreaFilled(false);
        r1_b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1_b4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 6, 172, 0);
        jPanel3.add(r1_b4, gridBagConstraints);

        r1_b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/orangergb.png"))); // NOI18N
        r1_b2.setBorder(null);
        r1_b2.setContentAreaFilled(false);
        r1_b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1_b2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 6, 0, 0);
        jPanel3.add(r1_b2, gridBagConstraints);

        r1_b3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/orangergb.png"))); // NOI18N
        r1_b3.setBorder(null);
        r1_b3.setContentAreaFilled(false);
        r1_b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1_b3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 6, 0, 0);
        jPanel3.add(r1_b3, gridBagConstraints);

        r1_b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/orangergb.png"))); // NOI18N
        r1_b1.setBorder(null);
        r1_b1.setContentAreaFilled(false);
        r1_b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1_b1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        jPanel3.add(r1_b1, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        r2_b3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bluergb.png"))); // NOI18N
        r2_b3.setBorder(null);
        r2_b3.setContentAreaFilled(false);
        r2_b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2_b3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 6, 0, 6);
        jPanel4.add(r2_b3, gridBagConstraints);

        r2_b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bluergb.png"))); // NOI18N
        r2_b2.setBorder(null);
        r2_b2.setContentAreaFilled(false);
        r2_b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2_b2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 6, 0, 6);
        jPanel4.add(r2_b2, gridBagConstraints);

        r2_b6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bluergb.png"))); // NOI18N
        r2_b6.setBorder(null);
        r2_b6.setContentAreaFilled(false);
        r2_b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2_b6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 6, 0, 6);
        jPanel4.add(r2_b6, gridBagConstraints);

        r2_b4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bluergb.png"))); // NOI18N
        r2_b4.setBorder(null);
        r2_b4.setContentAreaFilled(false);
        r2_b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2_b4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 6, 0, 6);
        jPanel4.add(r2_b4, gridBagConstraints);

        r2_b7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bluergb.png"))); // NOI18N
        r2_b7.setBorder(null);
        r2_b7.setContentAreaFilled(false);
        r2_b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2_b7ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 6, 0, 6);
        jPanel4.add(r2_b7, gridBagConstraints);

        r2_b8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bluergb.png"))); // NOI18N
        r2_b8.setBorder(null);
        r2_b8.setContentAreaFilled(false);
        r2_b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2_b8ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 6, 0, 6);
        jPanel4.add(r2_b8, gridBagConstraints);

        r2_b5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bluergb.png"))); // NOI18N
        r2_b5.setBorder(null);
        r2_b5.setContentAreaFilled(false);
        r2_b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2_b5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 6, 0, 6);
        jPanel4.add(r2_b5, gridBagConstraints);

        r2_b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bluergb.png"))); // NOI18N
        r2_b1.setBorder(null);
        r2_b1.setContentAreaFilled(false);
        r2_b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2_b1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 6);
        jPanel4.add(r2_b1, gridBagConstraints);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        r3_b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/grayrgb.png"))); // NOI18N
        r3_b1.setBorder(null);
        r3_b1.setContentAreaFilled(false);
        r3_b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3_b1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 6);
        jPanel5.add(r3_b1, gridBagConstraints);

        r3_b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/grayrgb.png"))); // NOI18N
        r3_b2.setBorder(null);
        r3_b2.setContentAreaFilled(false);
        r3_b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3_b2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 6, 0, 6);
        jPanel5.add(r3_b2, gridBagConstraints);

        r3_b3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/grayrgb.png"))); // NOI18N
        r3_b3.setBorder(null);
        r3_b3.setContentAreaFilled(false);
        r3_b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3_b3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 6, 0, 6);
        jPanel5.add(r3_b3, gridBagConstraints);

        r3_b4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/grayrgb.png"))); // NOI18N
        r3_b4.setBorder(null);
        r3_b4.setContentAreaFilled(false);
        r3_b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3_b4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 6, 0, 6);
        jPanel5.add(r3_b4, gridBagConstraints);

        r3_b5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/grayrgb.png"))); // NOI18N
        r3_b5.setBorder(null);
        r3_b5.setContentAreaFilled(false);
        r3_b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3_b5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 6, 0, 6);
        jPanel5.add(r3_b5, gridBagConstraints);

        r3_b6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/grayrgb.png"))); // NOI18N
        r3_b6.setBorder(null);
        r3_b6.setContentAreaFilled(false);
        r3_b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3_b6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 6, 0, 6);
        jPanel5.add(r3_b6, gridBagConstraints);

        r3_b7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/grayrgb.png"))); // NOI18N
        r3_b7.setBorder(null);
        r3_b7.setContentAreaFilled(false);
        r3_b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3_b7ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 6, 0, 6);
        jPanel5.add(r3_b7, gridBagConstraints);

        r3_b8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/grayrgb.png"))); // NOI18N
        r3_b8.setBorder(null);
        r3_b8.setContentAreaFilled(false);
        r3_b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3_b8ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 6, 0, 6);
        jPanel5.add(r3_b8, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Click to add ");

        btnNext.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnNext.setForeground(new java.awt.Color(51, 51, 51));
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
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

        lblQustion.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        lblQustion.setForeground(new java.awt.Color(102, 102, 102));
        lblQustion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQustion.setText("Qustions Count Down - 17");

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Click to Remove");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(347, 323));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ir1_b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/orangergb.png"))); // NOI18N
        ir1_b1.setBorder(null);
        ir1_b1.setContentAreaFilled(false);
        ir1_b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ir1_b1ActionPerformed(evt);
            }
        });
        jPanel6.add(ir1_b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        ir1_b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/orangergb.png"))); // NOI18N
        ir1_b2.setBorder(null);
        ir1_b2.setContentAreaFilled(false);
        ir1_b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ir1_b2ActionPerformed(evt);
            }
        });
        jPanel6.add(ir1_b2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, -1, -1));

        ir1_b3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/orangergb.png"))); // NOI18N
        ir1_b3.setBorder(null);
        ir1_b3.setContentAreaFilled(false);
        ir1_b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ir1_b3ActionPerformed(evt);
            }
        });
        jPanel6.add(ir1_b3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, -1, -1));

        ir1_b4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/orangergb.png"))); // NOI18N
        ir1_b4.setBorder(null);
        ir1_b4.setContentAreaFilled(false);
        ir1_b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ir1_b4ActionPerformed(evt);
            }
        });
        jPanel6.add(ir1_b4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        ir2_b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bluergb.png"))); // NOI18N
        ir2_b1.setBorder(null);
        ir2_b1.setContentAreaFilled(false);
        ir2_b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ir2_b1ActionPerformed(evt);
            }
        });
        jPanel6.add(ir2_b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, -1, -1));

        ir2_b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bluergb.png"))); // NOI18N
        ir2_b2.setBorder(null);
        ir2_b2.setContentAreaFilled(false);
        ir2_b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ir2_b2ActionPerformed(evt);
            }
        });
        jPanel6.add(ir2_b2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        ir2_b3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bluergb.png"))); // NOI18N
        ir2_b3.setBorder(null);
        ir2_b3.setContentAreaFilled(false);
        ir2_b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ir2_b3ActionPerformed(evt);
            }
        });
        jPanel6.add(ir2_b3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, -1, -1));

        ir2_b4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bluergb.png"))); // NOI18N
        ir2_b4.setBorder(null);
        ir2_b4.setContentAreaFilled(false);
        ir2_b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ir2_b4ActionPerformed(evt);
            }
        });
        jPanel6.add(ir2_b4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, -1, -1));

        ir2_b5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bluergb.png"))); // NOI18N
        ir2_b5.setBorder(null);
        ir2_b5.setContentAreaFilled(false);
        ir2_b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ir2_b5ActionPerformed(evt);
            }
        });
        jPanel6.add(ir2_b5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, -1, -1));

        ir2_b6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bluergb.png"))); // NOI18N
        ir2_b6.setBorder(null);
        ir2_b6.setContentAreaFilled(false);
        ir2_b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ir2_b6ActionPerformed(evt);
            }
        });
        jPanel6.add(ir2_b6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        ir2_b7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bluergb.png"))); // NOI18N
        ir2_b7.setBorder(null);
        ir2_b7.setContentAreaFilled(false);
        ir2_b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ir2_b7ActionPerformed(evt);
            }
        });
        jPanel6.add(ir2_b7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        ir2_b8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bluergb.png"))); // NOI18N
        ir2_b8.setBorder(null);
        ir2_b8.setContentAreaFilled(false);
        ir2_b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ir2_b8ActionPerformed(evt);
            }
        });
        jPanel6.add(ir2_b8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));

        ir3_b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/grayrgb.png"))); // NOI18N
        ir3_b1.setBorder(null);
        ir3_b1.setContentAreaFilled(false);
        ir3_b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ir3_b1ActionPerformed(evt);
            }
        });
        jPanel6.add(ir3_b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        ir3_b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/grayrgb.png"))); // NOI18N
        ir3_b2.setBorder(null);
        ir3_b2.setContentAreaFilled(false);
        ir3_b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ir3_b2ActionPerformed(evt);
            }
        });
        jPanel6.add(ir3_b2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, -1, -1));

        ir3_b3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/grayrgb.png"))); // NOI18N
        ir3_b3.setBorder(null);
        ir3_b3.setContentAreaFilled(false);
        ir3_b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ir3_b3ActionPerformed(evt);
            }
        });
        jPanel6.add(ir3_b3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, -1, -1));

        ir3_b4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/grayrgb.png"))); // NOI18N
        ir3_b4.setBorder(null);
        ir3_b4.setContentAreaFilled(false);
        ir3_b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ir3_b4ActionPerformed(evt);
            }
        });
        jPanel6.add(ir3_b4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, -1, -1));

        ir3_b5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/grayrgb.png"))); // NOI18N
        ir3_b5.setBorder(null);
        ir3_b5.setContentAreaFilled(false);
        ir3_b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ir3_b5ActionPerformed(evt);
            }
        });
        jPanel6.add(ir3_b5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, -1, -1));

        ir3_b6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/grayrgb.png"))); // NOI18N
        ir3_b6.setBorder(null);
        ir3_b6.setContentAreaFilled(false);
        ir3_b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ir3_b6ActionPerformed(evt);
            }
        });
        jPanel6.add(ir3_b6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, -1, -1));

        ir3_b7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/grayrgb.png"))); // NOI18N
        ir3_b7.setBorder(null);
        ir3_b7.setContentAreaFilled(false);
        ir3_b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ir3_b7ActionPerformed(evt);
            }
        });
        jPanel6.add(ir3_b7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        ir3_b8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/grayrgb.png"))); // NOI18N
        ir3_b8.setBorder(null);
        ir3_b8.setContentAreaFilled(false);
        ir3_b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ir3_b8ActionPerformed(evt);
            }
        });
        jPanel6.add(ir3_b8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/round.png"))); // NOI18N
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnBack.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(51, 51, 51));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnReattampt.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnReattampt.setForeground(new java.awt.Color(51, 51, 51));
        btnReattampt.setText("Reattempt ");
        btnReattampt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReattamptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReattampt))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(jLabel3)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(lblQustion)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(btnChack, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(66, 66, 66)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator2)))
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(118, 118, 118))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblQustion)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnChack)
                    .addComponent(btnReattampt)
                    .addComponent(btnBack))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pnl_Header, javax.swing.GroupLayout.PREFERRED_SIZE, 804, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_Header, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        lblDbc1.setText("XXX");

        dbcCoplete1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        dbcCoplete1.setForeground(new java.awt.Color(102, 102, 102));
        dbcCoplete1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dbcCoplete1.setText("Completed - XX%");

        dbcScore1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        dbcScore1.setForeground(new java.awt.Color(102, 102, 102));
        dbcScore1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dbcScore1.setText("Score - XX");

        javax.swing.GroupLayout pnlDoubleBloodCirculation1Layout = new javax.swing.GroupLayout(pnlDoubleBloodCirculation1);
        pnlDoubleBloodCirculation1.setLayout(pnlDoubleBloodCirculation1Layout);
        pnlDoubleBloodCirculation1Layout.setHorizontalGroup(
            pnlDoubleBloodCirculation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoubleBloodCirculation1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDoubleBloodCirculation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDbc1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dbcScore1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dbcCoplete1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
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
        lblUserName6.setText("XXX");

        lblTitle17.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        lblTitle17.setForeground(new java.awt.Color(102, 102, 102));
        lblTitle17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle17.setText("Completed - XX%");

        lblTitle18.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        lblTitle18.setForeground(new java.awt.Color(102, 102, 102));
        lblTitle18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle18.setText("Score - XX");

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
        lblUserName9.setText("Electonic Configuration");

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

        lblElectronicCon2.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        lblElectronicCon2.setText("XXX");
        lblElectronicCon2.setEnabled(false);
        lblElectronicCon2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblElectronicCon2ActionPerformed(evt);
            }
        });

        lblElectronicCon1.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        lblElectronicCon1.setText("XXX");
        lblElectronicCon1.setEnabled(false);
        lblElectronicCon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblElectronicCon1ActionPerformed(evt);
            }
        });

        btnHeat.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        btnHeat.setText("Electonic Configuration");
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
                    .addComponent(btnHeat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblElectronicCon2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblElectronicCon1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(lblElectronicCon1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblElectronicCon2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void r1_b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1_b4ActionPerformed
        r1_b4.setVisible(false);
        ir1_b1.setVisible(true);
        roundOne++;

    }//GEN-LAST:event_r1_b4ActionPerformed

    private void r1_b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1_b2ActionPerformed
        r1_b2.setVisible(false);
        ir1_b2.setVisible(true);
        roundOne++;
    }//GEN-LAST:event_r1_b2ActionPerformed

    private void r1_b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1_b3ActionPerformed
        r1_b3.setVisible(false);
        ir1_b3.setVisible(true);
        roundOne++;
    }//GEN-LAST:event_r1_b3ActionPerformed

    private void r1_b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1_b1ActionPerformed
        r1_b1.setVisible(false);
        ir1_b4.setVisible(true);
        roundOne++;
    }//GEN-LAST:event_r1_b1ActionPerformed

    private void r2_b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2_b3ActionPerformed
        ir2_b4.setVisible(true);
        r2_b3.setVisible(false);
        roundTwo++;
    }//GEN-LAST:event_r2_b3ActionPerformed

    private void r2_b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2_b2ActionPerformed
        ir2_b3.setVisible(true);
        r2_b2.setVisible(false);
        roundTwo++;
    }//GEN-LAST:event_r2_b2ActionPerformed

    private void r2_b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2_b6ActionPerformed
        ir2_b6.setVisible(true);
        r2_b6.setVisible(false);
        roundTwo++;
    }//GEN-LAST:event_r2_b6ActionPerformed

    private void r2_b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2_b4ActionPerformed
        ir2_b1.setVisible(true);
        r2_b4.setVisible(false);
        roundTwo++;
    }//GEN-LAST:event_r2_b4ActionPerformed

    private void r2_b7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2_b7ActionPerformed
        ir2_b7.setVisible(true);
        r2_b7.setVisible(false);
        roundTwo++;
    }//GEN-LAST:event_r2_b7ActionPerformed

    private void r2_b8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2_b8ActionPerformed
        ir2_b8.setVisible(true);
        r2_b8.setVisible(false);
        roundTwo++;
    }//GEN-LAST:event_r2_b8ActionPerformed

    private void r2_b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2_b5ActionPerformed
        ir2_b5.setVisible(true);
        r2_b5.setVisible(false);
        roundTwo++;
    }//GEN-LAST:event_r2_b5ActionPerformed

    private void r2_b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2_b1ActionPerformed
        r2_b1.setVisible(false);
        ir2_b2.setVisible(true);
        roundTwo++;
    }//GEN-LAST:event_r2_b1ActionPerformed

    private void r3_b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3_b1ActionPerformed
        ir3_b3.setVisible(true);
        r3_b1.setVisible(false);
        roundThree++;
    }//GEN-LAST:event_r3_b1ActionPerformed

    private void r3_b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3_b2ActionPerformed
        ir3_b2.setVisible(true);
        r3_b2.setVisible(false);
        roundThree++;
    }//GEN-LAST:event_r3_b2ActionPerformed

    private void r3_b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3_b3ActionPerformed
        ir3_b4.setVisible(true);
        r3_b3.setVisible(false);
        roundThree++;
    }//GEN-LAST:event_r3_b3ActionPerformed

    private void r3_b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3_b4ActionPerformed
        ir3_b5.setVisible(true);
        r3_b4.setVisible(false);
        roundThree++;
    }//GEN-LAST:event_r3_b4ActionPerformed

    private void r3_b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3_b5ActionPerformed
        ir3_b6.setVisible(true);
        r3_b5.setVisible(false);
        roundThree++;
    }//GEN-LAST:event_r3_b5ActionPerformed

    private void r3_b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3_b6ActionPerformed
        ir3_b7.setVisible(true);
        r3_b6.setVisible(false);
        roundThree++;
    }//GEN-LAST:event_r3_b6ActionPerformed

    private void r3_b7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3_b7ActionPerformed
        ir3_b8.setVisible(true);
        r3_b7.setVisible(false);
        roundThree++;
    }//GEN-LAST:event_r3_b7ActionPerformed

    private void r3_b8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3_b8ActionPerformed
        ir3_b1.setVisible(true);
        r3_b8.setVisible(false);
        roundThree++;
    }//GEN-LAST:event_r3_b8ActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        qustionChange();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnChackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChackActionPerformed
        
        btnChack.setEnabled(false);
        btnNext.setEnabled(true);
        
        String object = lblMainObject.getText();
        if (complete != 100 && helthDrop != 0) {
            complete = complete + 5;
            lblComplete.setText("Completed - " + complete + "%");
        }
        
        if (complete == 85) {
            complete = complete + 15;
            lblComplete.setText("Completed - " + complete + "%");
        }

        //QUIZE 01
        if (object.equals("H")) {
            if (roundOne == 1 && roundTwo == 0 && roundThree == 0) {
                score = score + 5;
                lblScore.setText("" + score);
                lblScoreSide.setText("Score - " + score);
                
            } else {
                helthDrop--;
                if (helthDrop == 3) {
                    health4.setVisible(false);
                } else if (helthDrop == 2) {
                    health3.setVisible(false);
                } else if (helthDrop == 1) {
                    health2.setVisible(false);
                } else if (helthDrop == 0) {
                    
                }
            }

            //QUIZE 02
        } else if (object.equals("He")) {
            if (roundOne == 2 && roundTwo == 0 && roundThree == 0) {
                score = score + 5;
                lblScore.setText("" + score);
                lblScoreSide.setText("Score - " + score);
                
            } else {
                helthDrop--;
                if (helthDrop == 3) {
                    health4.setVisible(false);
                } else if (helthDrop == 2) {
                    health3.setVisible(false);
                } else if (helthDrop == 1) {
                    health2.setVisible(false);
                } else if (helthDrop == 0) {
                    health1.setVisible(false);
                }
            }

            //QUIZE 03
        } else if (object.equals("Li")) {
            if (roundOne == 2 && roundTwo == 1 && roundThree == 0) {
                score = score + 5;
                lblScore.setText("" + score);
                lblScoreSide.setText("Score - " + score);
                
            } else {
                helthDrop--;
                if (helthDrop == 3) {
                    health4.setVisible(false);
                } else if (helthDrop == 2) {
                    health3.setVisible(false);
                } else if (helthDrop == 1) {
                    health2.setVisible(false);
                } else if (helthDrop == 0) {
                    health1.setVisible(false);
                }
            }

            //QUIZE 04
        } else if (object.equals("Be")) {
            if (roundOne == 2 && roundTwo == 2 && roundThree == 0) {
                score = score + 5;
                lblScore.setText("" + score);
                lblScoreSide.setText("Score - " + score);
            } else {
                helthDrop--;
                if (helthDrop == 3) {
                    health4.setVisible(false);
                } else if (helthDrop == 2) {
                    health3.setVisible(false);
                } else if (helthDrop == 1) {
                    health2.setVisible(false);
                } else if (helthDrop == 0) {
                    health1.setVisible(false);
                    JOptionPane.showMessageDialog(rootPane, "Your Are Basted");
                    fullResetGame();
                }
            }

            //QUIZE 05
        } else if (object.equals("B")) {
            if (roundOne == 2 && roundTwo == 3 && roundThree == 0) {
                score = score + 5;
                lblScore.setText("" + score);
                lblScoreSide.setText("Score - " + score);
                
            } else {
                helthDrop--;
                if (helthDrop == 3) {
                    health4.setVisible(false);
                } else if (helthDrop == 2) {
                    health3.setVisible(false);
                } else if (helthDrop == 1) {
                    health2.setVisible(false);
                } else if (helthDrop == 0) {
                    health1.setVisible(false);
                    JOptionPane.showMessageDialog(rootPane, "Your Are Basted");
                    fullResetGame();
                }
            }

            //QUIZE 06
        } else if (object.equals("C")) {
            if (roundOne == 2 && roundTwo == 4 && roundThree == 0) {
                score = score + 5;
                lblScore.setText("" + score);
                lblScoreSide.setText("Score - " + score);
                
            } else {
                helthDrop--;
                if (helthDrop == 3) {
                    health4.setVisible(false);
                } else if (helthDrop == 2) {
                    health3.setVisible(false);
                } else if (helthDrop == 1) {
                    health2.setVisible(false);
                } else if (helthDrop == 0) {
                    health1.setVisible(false);
                    JOptionPane.showMessageDialog(rootPane, "Your Are Basted");
                    fullResetGame();
                }
            }

            //QUIZE 07
        } else if (object.equals("N")) {
            if (roundOne == 2 && roundTwo == 5 && roundThree == 0) {
                score = score + 5;
                lblScore.setText("" + score);
                lblScoreSide.setText("Score - " + score);
                
            } else {
                helthDrop--;
                if (helthDrop == 3) {
                    health4.setVisible(false);
                } else if (helthDrop == 2) {
                    health3.setVisible(false);
                } else if (helthDrop == 1) {
                    health2.setVisible(false);
                } else if (helthDrop == 0) {
                    health1.setVisible(false);
                    JOptionPane.showMessageDialog(rootPane, "Your Are Basted");
                    fullResetGame();
                }
            }

            //QUIZE 08
        } else if (object.equals("O")) {
            if (roundOne == 2 && roundTwo == 6 && roundThree == 0) {
                score = score + 5;
                lblScore.setText("" + score);
                lblScoreSide.setText("Score - " + score);
                
            } else {
                helthDrop--;
                if (helthDrop == 3) {
                    health4.setVisible(false);
                } else if (helthDrop == 2) {
                    health3.setVisible(false);
                } else if (helthDrop == 1) {
                    health2.setVisible(false);
                } else if (helthDrop == 0) {
                    health1.setVisible(false);
                    JOptionPane.showMessageDialog(rootPane, "Your Are Basted");
                    fullResetGame();
                }
            }

            //QUIZE 09
        } else if (object.equals("F")) {
            if (roundOne == 2 && roundTwo == 7 && roundThree == 0) {
                score = score + 5;
                lblScore.setText("" + score);
                lblScoreSide.setText("Score - " + score);
                
            } else {
                helthDrop--;
                if (helthDrop == 3) {
                    health4.setVisible(false);
                } else if (helthDrop == 2) {
                    health3.setVisible(false);
                } else if (helthDrop == 1) {
                    health2.setVisible(false);
                } else if (helthDrop == 0) {
                    health1.setVisible(false);
                    JOptionPane.showMessageDialog(rootPane, "Your Are Basted");
                    fullResetGame();
                }
            }

            //QUIZE 10
        } else if (object.equals("Ne")) {
            if (roundOne == 2 && roundTwo == 8 && roundThree == 0) {
                score = score + 5;
                lblScore.setText("" + score);
                lblScoreSide.setText("Score - " + score);
                
            } else {
                helthDrop--;
                if (helthDrop == 3) {
                    health4.setVisible(false);
                } else if (helthDrop == 2) {
                    health3.setVisible(false);
                } else if (helthDrop == 1) {
                    health2.setVisible(false);
                } else if (helthDrop == 0) {
                    health1.setVisible(false);
                    JOptionPane.showMessageDialog(rootPane, "Your Are Basted");
                    fullResetGame();
                }
            }

            //QUIZE 11
        } else if (object.equals("Na")) {
            if (roundOne == 2 && roundTwo == 8 && roundThree == 1) {
                score = score + 5;
                lblScore.setText("" + score);
                lblScoreSide.setText("Score - " + score);
                
            } else {
                helthDrop--;
                if (helthDrop == 3) {
                    health4.setVisible(false);
                } else if (helthDrop == 2) {
                    health3.setVisible(false);
                } else if (helthDrop == 1) {
                    health2.setVisible(false);
                } else if (helthDrop == 0) {
                    health1.setVisible(false);
                    JOptionPane.showMessageDialog(rootPane, "Your Are Basted");
                    fullResetGame();
                }
            }

            //QUIZE 12
        } else if (object.equals("Mg")) {
            if (roundOne == 2 && roundTwo == 8 && roundThree == 2) {
                score = score + 5;
                lblScore.setText("" + score);
                lblScoreSide.setText("Score - " + score);
                
            } else {
                helthDrop--;
                if (helthDrop == 3) {
                    health4.setVisible(false);
                } else if (helthDrop == 2) {
                    health3.setVisible(false);
                } else if (helthDrop == 1) {
                    health2.setVisible(false);
                } else if (helthDrop == 0) {
                    health1.setVisible(false);
                    JOptionPane.showMessageDialog(rootPane, "Your Are Basted");
                    fullResetGame();
                }
            }

            //QUIZE 13
        } else if (object.equals("Al")) {
            if (roundOne == 2 && roundTwo == 8 && roundThree == 3) {
                score = score + 5;
                lblScore.setText("" + score);
                lblScoreSide.setText("Score - " + score);
                
            } else {
                helthDrop--;
                if (helthDrop == 3) {
                    health4.setVisible(false);
                } else if (helthDrop == 2) {
                    health3.setVisible(false);
                } else if (helthDrop == 1) {
                    health2.setVisible(false);
                } else if (helthDrop == 0) {
                    health1.setVisible(false);
                    JOptionPane.showMessageDialog(rootPane, "Your Are Basted");
                    fullResetGame();
                }
            }

            //QUIZE 14
        } else if (object.equals("Si")) {
            if (roundOne == 2 && roundTwo == 8 && roundThree == 4) {
                score = score + 5;
                lblScore.setText("" + score);
                lblScoreSide.setText("Score - " + score);
                
            } else {
                helthDrop--;
                if (helthDrop == 3) {
                    health4.setVisible(false);
                } else if (helthDrop == 2) {
                    health3.setVisible(false);
                } else if (helthDrop == 1) {
                    health2.setVisible(false);
                } else if (helthDrop == 0) {
                    health1.setVisible(false);
                    JOptionPane.showMessageDialog(rootPane, "Your Are Basted");
                    fullResetGame();
                }
            }

            //QUIZE 15
        } else if (object.equals("P")) {
            if (roundOne == 2 && roundTwo == 8 && roundThree == 5) {
                score = score + 5;
                lblScore.setText("" + score);
                lblScoreSide.setText("Score - " + score);
                
            } else {
                helthDrop--;
                if (helthDrop == 3) {
                    health4.setVisible(false);
                } else if (helthDrop == 2) {
                    health3.setVisible(false);
                } else if (helthDrop == 1) {
                    health2.setVisible(false);
                } else if (helthDrop == 0) {
                    health1.setVisible(false);
                    JOptionPane.showMessageDialog(rootPane, "Your Are Basted");
                    fullResetGame();
                }
            }

            //QUIZE 16
        } else if (object.equals("S")) {
            if (roundOne == 2 && roundTwo == 8 && roundThree == 6) {
                score = score + 5;
                lblScore.setText("" + score);
                lblScoreSide.setText("Score - " + score);
                
            } else {
                helthDrop--;
                if (helthDrop == 3) {
                    health4.setVisible(false);
                } else if (helthDrop == 2) {
                    health3.setVisible(false);
                } else if (helthDrop == 1) {
                    health2.setVisible(false);
                } else if (helthDrop == 0) {
                    health1.setVisible(false);
                    JOptionPane.showMessageDialog(rootPane, "Your Are Basted");
                    fullResetGame();
                }
            }

            //QUIZE 17
        } else if (object.equals("Cl")) {
            if (roundOne == 2 && roundTwo == 8 && roundThree == 7) {
                score = score + 5;
                lblScore.setText("" + score);
                lblScoreSide.setText("Score - " + score);
                
            } else {
                helthDrop--;
                if (helthDrop == 3) {
                    health4.setVisible(false);
                } else if (helthDrop == 2) {
                    health3.setVisible(false);
                } else if (helthDrop == 1) {
                    health2.setVisible(false);
                } else if (helthDrop == 0) {
                    health1.setVisible(false);
                    JOptionPane.showMessageDialog(rootPane, "Your Are Basted");
                    fullResetGame();
                }
            }

            //QUIZE 18
        } else if (object.equals("Ar")) {
            if (roundOne == 2 && roundTwo == 8 && roundThree == 6) {
                score = score + 5;
                lblScore.setText("" + score);
                lblScoreSide.setText("Score - " + score);
                
            } else {
                helthDrop--;
                if (helthDrop == 3) {
                    health4.setVisible(false);
                } else if (helthDrop == 2) {
                    health3.setVisible(false);
                } else if (helthDrop == 1) {
                    health2.setVisible(false);
                } else if (helthDrop == 0) {
                    health1.setVisible(false);
                    JOptionPane.showMessageDialog(rootPane, "Your Are Basted");
                    fullResetGame();
                    
                }
            }
        }
        
        if (count != 17) {
            /////

            qustion--;
            lblQustion.setText("Qustions Count Down - " + qustion);

            /////
            count++;
            
        }
        
        if (score == 85) {
            score = score + 15;
            lblScoreSide.setText("Score - " + score);
        }
        
        insertToSql();
        
        if (score >= 50) {
            lblElectronicCon1.setEnabled(true);
        }
        

    }//GEN-LAST:event_btnChackActionPerformed

    private void ir1_b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ir1_b1ActionPerformed
        r1_b4.setVisible(true);
        ir1_b1.setVisible(false);
        roundOne--;
    }//GEN-LAST:event_ir1_b1ActionPerformed

    private void ir1_b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ir1_b2ActionPerformed
        r1_b2.setVisible(true);
        ir1_b2.setVisible(false);
        roundOne--;
    }//GEN-LAST:event_ir1_b2ActionPerformed

    private void ir1_b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ir1_b3ActionPerformed
        r1_b3.setVisible(true);
        ir1_b3.setVisible(false);
        roundOne--;
    }//GEN-LAST:event_ir1_b3ActionPerformed

    private void ir1_b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ir1_b4ActionPerformed
        r1_b1.setVisible(true);
        ir1_b4.setVisible(false);
        roundOne--;
    }//GEN-LAST:event_ir1_b4ActionPerformed

    private void ir2_b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ir2_b1ActionPerformed
        ir2_b1.setVisible(false);
        r2_b4.setVisible(true);
        roundTwo--;
    }//GEN-LAST:event_ir2_b1ActionPerformed

    private void ir2_b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ir2_b2ActionPerformed
        r2_b1.setVisible(true);
        ir2_b2.setVisible(false);
        roundTwo--;
    }//GEN-LAST:event_ir2_b2ActionPerformed

    private void ir2_b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ir2_b3ActionPerformed
        ir2_b3.setVisible(false);
        r2_b2.setVisible(true);
        roundTwo--;
    }//GEN-LAST:event_ir2_b3ActionPerformed

    private void ir2_b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ir2_b4ActionPerformed
        ir2_b4.setVisible(false);
        r2_b3.setVisible(true);
        roundTwo--;
    }//GEN-LAST:event_ir2_b4ActionPerformed

    private void ir2_b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ir2_b5ActionPerformed
        ir2_b5.setVisible(false);
        r2_b5.setVisible(true);
        roundTwo--;
    }//GEN-LAST:event_ir2_b5ActionPerformed

    private void ir2_b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ir2_b6ActionPerformed
        ir2_b6.setVisible(false);
        r2_b6.setVisible(true);
        roundTwo--;
    }//GEN-LAST:event_ir2_b6ActionPerformed

    private void ir2_b7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ir2_b7ActionPerformed
        ir2_b7.setVisible(false);
        r2_b7.setVisible(true);
        roundTwo--;
    }//GEN-LAST:event_ir2_b7ActionPerformed

    private void ir2_b8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ir2_b8ActionPerformed
        ir2_b8.setVisible(false);
        r2_b8.setVisible(true);
        roundTwo--;
    }//GEN-LAST:event_ir2_b8ActionPerformed

    private void ir3_b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ir3_b1ActionPerformed
        ir3_b1.setVisible(false);
        r3_b8.setVisible(true);
        roundThree--;
    }//GEN-LAST:event_ir3_b1ActionPerformed

    private void ir3_b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ir3_b2ActionPerformed
        ir3_b2.setVisible(false);
        r3_b2.setVisible(true);
        roundThree--;
    }//GEN-LAST:event_ir3_b2ActionPerformed

    private void ir3_b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ir3_b3ActionPerformed
        ir3_b3.setVisible(false);
        r3_b1.setVisible(true);
        roundThree--;
    }//GEN-LAST:event_ir3_b3ActionPerformed

    private void ir3_b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ir3_b4ActionPerformed
        ir3_b4.setVisible(false);
        r3_b3.setVisible(true);
        roundThree--;
    }//GEN-LAST:event_ir3_b4ActionPerformed

    private void ir3_b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ir3_b5ActionPerformed
        ir3_b5.setVisible(false);
        r3_b4.setVisible(true);
        roundThree--;
    }//GEN-LAST:event_ir3_b5ActionPerformed

    private void ir3_b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ir3_b6ActionPerformed
        ir3_b6.setVisible(false);
        r3_b5.setVisible(true);
        roundThree--;
    }//GEN-LAST:event_ir3_b6ActionPerformed

    private void ir3_b7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ir3_b7ActionPerformed
        ir3_b7.setVisible(false);
        r3_b6.setVisible(true);
        roundThree--;
    }//GEN-LAST:event_ir3_b7ActionPerformed

    private void ir3_b8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ir3_b8ActionPerformed
        ir3_b8.setVisible(false);
        r3_b7.setVisible(true);
        roundThree--;
    }//GEN-LAST:event_ir3_b8ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        ScienceHub sh = new ScienceHub();
        sh.setId(idpas);
        sh.show();
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnReattamptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReattamptActionPerformed
        lblElectronicCon1.setEnabled(false);
        
        fullResetGame();
        btnReattampt.setVisible(false);
        insertToSql();
    }//GEN-LAST:event_btnReattamptActionPerformed

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked

    }//GEN-LAST:event_jPanel12MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked

    }//GEN-LAST:event_jPanel14MouseClicked

    private void lblElectronicCon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblElectronicCon2ActionPerformed
        
    }//GEN-LAST:event_lblElectronicCon2ActionPerformed

    private void lblElectronicCon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblElectronicCon1ActionPerformed
       
    }//GEN-LAST:event_lblElectronicCon1ActionPerformed

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
            java.util.logging.Logger.getLogger(ElectronicConfiguration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ElectronicConfiguration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ElectronicConfiguration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ElectronicConfiguration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ElectronicConfiguration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnChack;
    private javax.swing.JButton btnHeat;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnReattampt;
    private javax.swing.JLabel dbcCoplete1;
    private javax.swing.JLabel dbcScore1;
    private javax.swing.JButton health1;
    private javax.swing.JButton health2;
    private javax.swing.JButton health3;
    private javax.swing.JButton health4;
    private javax.swing.JButton ir1_b1;
    private javax.swing.JButton ir1_b2;
    private javax.swing.JButton ir1_b3;
    private javax.swing.JButton ir1_b4;
    private javax.swing.JButton ir2_b1;
    private javax.swing.JButton ir2_b2;
    private javax.swing.JButton ir2_b3;
    private javax.swing.JButton ir2_b4;
    private javax.swing.JButton ir2_b5;
    private javax.swing.JButton ir2_b6;
    private javax.swing.JButton ir2_b7;
    private javax.swing.JButton ir2_b8;
    private javax.swing.JButton ir3_b1;
    private javax.swing.JButton ir3_b2;
    private javax.swing.JButton ir3_b3;
    private javax.swing.JButton ir3_b4;
    private javax.swing.JButton ir3_b5;
    private javax.swing.JButton ir3_b6;
    private javax.swing.JButton ir3_b7;
    private javax.swing.JButton ir3_b8;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblComplete;
    private javax.swing.JLabel lblDbc1;
    private javax.swing.JButton lblElectronicCon1;
    private javax.swing.JButton lblElectronicCon2;
    private javax.swing.JLabel lblMainObject;
    private javax.swing.JLabel lblQustion;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblScoreSide;
    private javax.swing.JLabel lblTitle17;
    private javax.swing.JLabel lblTitle18;
    private javax.swing.JLabel lblUname;
    private javax.swing.JLabel lblUserName6;
    private javax.swing.JLabel lblUserName9;
    private javax.swing.JPanel pnlDoubleBloodCirculation1;
    private javax.swing.JPanel pnl_Header;
    private javax.swing.JButton r1_b1;
    private javax.swing.JButton r1_b2;
    private javax.swing.JButton r1_b3;
    private javax.swing.JButton r1_b4;
    private javax.swing.JButton r2_b1;
    private javax.swing.JButton r2_b2;
    private javax.swing.JButton r2_b3;
    private javax.swing.JButton r2_b4;
    private javax.swing.JButton r2_b5;
    private javax.swing.JButton r2_b6;
    private javax.swing.JButton r2_b7;
    private javax.swing.JButton r2_b8;
    private javax.swing.JButton r3_b1;
    private javax.swing.JButton r3_b2;
    private javax.swing.JButton r3_b3;
    private javax.swing.JButton r3_b4;
    private javax.swing.JButton r3_b5;
    private javax.swing.JButton r3_b6;
    private javax.swing.JButton r3_b7;
    private javax.swing.JButton r3_b8;
    // End of variables declaration//GEN-END:variables
}
