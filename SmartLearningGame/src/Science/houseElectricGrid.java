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
public class houseElectricGrid extends javax.swing.JFrame {

    /**
     * Creates new form houseElectricGrid
     */
    JLabel selectedLabal;

    public houseElectricGrid() {
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
                lblUname.setText("Welcome " + uName);

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
            PreparedStatement st1 = con.prepareStatement("UPDATE `smart_learning`.`science` SET `electricHouseGridScore` = ?, `electricHouseGridComplete` = ? WHERE (`stRegId` = '" + idPas + "');");
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

        btnDistributionWire.setVisible(true);
        btnSupplyCable.setVisible(true);
        btnOverloadCircuitBreaker.setVisible(true);
        btnElectricMeter.setVisible(true);
        btnIsolator.setVisible(true);
        btnCurrebtCircuteBraker.setVisible(true);
        btncircuteBrakeFuses.setVisible(true);
        btnSwitch.setVisible(true);
        btnPlugSocket.setVisible(true);
        btnEarthWire.setVisible(true);
        btnLightbulb.setVisible(true);

        lblDistributionWire.setText("");
        lblSupplyCable.setText("");
        lblOverloadCircuitBreaker.setText("");
        lblElectricMeter.setText("");
        lblIsolator.setText("");
        lblCurrebtCircuteBraker.setText("");
        lblcircuteBrakeFuses.setText("");
        lblSwitch.setText("");
        lblPlugSocket.setText("");
        lblEarthWire.setText("");
        lblLightbulb.setText("");

        score = 0;
        lblScoreSide.setText("Score - " + score);
        lblScore.setText(score + "");

        complete = 0;
        lblComplete.setText("Completed - " + complete + "%");

        btnReattampt.setEnabled(false);

    }

    public void enable() {

        btnDistributionWire.setEnabled(true);
        btnSupplyCable.setEnabled(true);
        btnOverloadCircuitBreaker.setEnabled(true);
        btnElectricMeter.setEnabled(true);
        btnIsolator.setEnabled(true);
        btnCurrebtCircuteBraker.setEnabled(true);
        btncircuteBrakeFuses.setEnabled(true);
        btnSwitch.setEnabled(true);
        btnPlugSocket.setEnabled(true);
        btnEarthWire.setEnabled(true);
        btnLightbulb.setEnabled(true);

    }

    public void disable() {

        btnDistributionWire.setEnabled(false);
        btnSupplyCable.setEnabled(false);
        btnOverloadCircuitBreaker.setEnabled(false);
        btnElectricMeter.setEnabled(false);
        btnIsolator.setEnabled(false);
        btnCurrebtCircuteBraker.setEnabled(false);
        btncircuteBrakeFuses.setEnabled(false);
        btnSwitch.setEnabled(false);
        btnPlugSocket.setEnabled(false);
        btnEarthWire.setEnabled(false);
        btnLightbulb.setEnabled(false);

    }

    public void dfault() {
        lblDistributionWire.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        lblSupplyCable.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        lblOverloadCircuitBreaker.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        lblElectricMeter.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        lblIsolator.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        lblCurrebtCircuteBraker.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        lblcircuteBrakeFuses.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        lblSwitch.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        lblPlugSocket.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        lblEarthWire.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        lblLightbulb.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));

        disable();
    }

    public void selectLabal() {
        selectedLabal.setBorder(BorderFactory.createLineBorder(Color.blue));
        enable();
    }

    public void retunButon() {

        complete = complete - 9;

        if (selectedLabal.getText().equals("Distribution wire")) {
            btnDistributionWire.setVisible(true);
        } else if (selectedLabal.getText().equals("Supply cable")) {
            btnSupplyCable.setVisible(true);
        } else if (selectedLabal.getText().equals("Overload circuit breaker")) {
            btnOverloadCircuitBreaker.setVisible(true);
        } else if (selectedLabal.getText().equals("Electric meter")) {
            btnElectricMeter.setVisible(true);
        } else if (selectedLabal.getText().equals("Isolator")) {
            btnIsolator.setVisible(true);
        } else if (selectedLabal.getText().equals("<html>Residual current circuit<br>breaker or trip switch</html>")) {
            btnCurrebtCircuteBraker.setVisible(true);
        } else if (selectedLabal.getText().equals("<html> miniature circuit <br>breakers or fuses </html>")) {
            btncircuteBrakeFuses.setVisible(true);
        } else if (selectedLabal.getText().equals("Switch")) {
            btnSwitch.setVisible(true);
        } else if (selectedLabal.getText().equals(" plug socket")) {
            btnPlugSocket.setVisible(true);
        } else if (selectedLabal.getText().equals("Earth wire")) {
            btnEarthWire.setVisible(true);
        } else if (selectedLabal.getText().equals(" Light bulb")) {
            btnLightbulb.setVisible(true);
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

        jPanel10 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        lblUname = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        lblUserName9 = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        lblComplete = new javax.swing.JLabel();
        lblScoreSide = new javax.swing.JLabel();
        btnHeat = new javax.swing.JButton();
        pnl_Header = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        health1 = new javax.swing.JButton();
        health2 = new javax.swing.JButton();
        health3 = new javax.swing.JButton();
        health4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblMainObject = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblDistributionWire = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblSupplyCable = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblOverloadCircuitBreaker = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblElectricMeter = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblIsolator = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblCurrebtCircuteBraker = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblSwitch = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblcircuteBrakeFuses = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblPlugSocket = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblEarthWire = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblLightbulb = new javax.swing.JLabel();
        btnChack1 = new javax.swing.JButton();
        pnlAnswer = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnSupplyCable = new javax.swing.JButton();
        btnOverloadCircuitBreaker = new javax.swing.JButton();
        btnElectricMeter = new javax.swing.JButton();
        btnIsolator = new javax.swing.JButton();
        btnCurrebtCircuteBraker = new javax.swing.JButton();
        btncircuteBrakeFuses = new javax.swing.JButton();
        btnDistributionWire = new javax.swing.JButton();
        btnSwitch = new javax.swing.JButton();
        btnPlugSocket = new javax.swing.JButton();
        btnEarthWire = new javax.swing.JButton();
        btnLightbulb = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnReattampt = new javax.swing.JButton();
        btnChack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

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

        lblUserName9.setBackground(new java.awt.Color(51, 51, 51));
        lblUserName9.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        lblUserName9.setForeground(new java.awt.Color(51, 51, 51));
        lblUserName9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserName9.setText("Electric Gride");

        lblComplete.setBackground(new java.awt.Color(51, 51, 51));
        lblComplete.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        lblComplete.setForeground(new java.awt.Color(51, 51, 51));
        lblComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblComplete.setText("Completed - 0%");

        lblScoreSide.setBackground(new java.awt.Color(51, 51, 51));
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
                    .addComponent(lblComplete, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
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

        btnHeat.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        btnHeat.setText("Electric Gride");
        btnHeat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255), 2));
        btnHeat.setEnabled(false);
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
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_Header.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Health");
        pnl_Header.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 194, 20));

        health1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hart.png"))); // NOI18N
        health1.setBorder(null);
        health1.setContentAreaFilled(false);
        pnl_Header.add(health1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        health2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hart.png"))); // NOI18N
        health2.setBorder(null);
        health2.setContentAreaFilled(false);
        pnl_Header.add(health2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 50, -1));

        health3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hart.png"))); // NOI18N
        health3.setBorder(null);
        health3.setContentAreaFilled(false);
        pnl_Header.add(health3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        health4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hart.png"))); // NOI18N
        health4.setBorder(null);
        health4.setContentAreaFilled(false);
        pnl_Header.add(health4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Set the correct body parts name in correct place.");
        pnl_Header.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        lblMainObject.setFont(new java.awt.Font("Poppins SemiBold", 0, 24)); // NOI18N
        lblMainObject.setForeground(new java.awt.Color(51, 51, 51));
        lblMainObject.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMainObject.setText("A house connected to the electric grid");
        pnl_Header.add(lblMainObject, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 10, 470, -1));

        jLabel8.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Score");
        pnl_Header.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, -1, -1));

        lblScore.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblScore.setForeground(new java.awt.Color(102, 102, 102));
        lblScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScore.setText("000");
        pnl_Header.add(lblScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, 39, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/electronicHouse.png"))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lblDistributionWire.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblDistributionWire.setForeground(new java.awt.Color(102, 102, 102));
        lblDistributionWire.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDistributionWire.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblDistributionWire.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDistributionWire.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDistributionWireMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel5.setText("A");

        jLabel6.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel6.setText("B");

        lblSupplyCable.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblSupplyCable.setForeground(new java.awt.Color(102, 102, 102));
        lblSupplyCable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSupplyCable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblSupplyCable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSupplyCable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSupplyCableMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel9.setText("C");

        lblOverloadCircuitBreaker.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblOverloadCircuitBreaker.setForeground(new java.awt.Color(102, 102, 102));
        lblOverloadCircuitBreaker.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOverloadCircuitBreaker.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblOverloadCircuitBreaker.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblOverloadCircuitBreaker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOverloadCircuitBreakerMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel10.setText("D");

        lblElectricMeter.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblElectricMeter.setForeground(new java.awt.Color(102, 102, 102));
        lblElectricMeter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblElectricMeter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblElectricMeter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblElectricMeter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblElectricMeterMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel11.setText("E");

        lblIsolator.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblIsolator.setForeground(new java.awt.Color(102, 102, 102));
        lblIsolator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIsolator.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblIsolator.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblIsolator.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIsolatorMouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel12.setText("F");

        lblCurrebtCircuteBraker.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblCurrebtCircuteBraker.setForeground(new java.awt.Color(102, 102, 102));
        lblCurrebtCircuteBraker.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCurrebtCircuteBraker.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblCurrebtCircuteBraker.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCurrebtCircuteBraker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCurrebtCircuteBrakerMouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel13.setText("G");

        lblSwitch.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblSwitch.setForeground(new java.awt.Color(102, 102, 102));
        lblSwitch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSwitch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblSwitch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSwitch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSwitchMouseClicked(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel14.setText("I");

        lblcircuteBrakeFuses.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblcircuteBrakeFuses.setForeground(new java.awt.Color(102, 102, 102));
        lblcircuteBrakeFuses.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblcircuteBrakeFuses.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblcircuteBrakeFuses.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblcircuteBrakeFuses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblcircuteBrakeFusesMouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel15.setText("H");

        lblPlugSocket.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblPlugSocket.setForeground(new java.awt.Color(102, 102, 102));
        lblPlugSocket.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlugSocket.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblPlugSocket.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPlugSocket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPlugSocketMouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel17.setText("J");

        lblEarthWire.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblEarthWire.setForeground(new java.awt.Color(102, 102, 102));
        lblEarthWire.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEarthWire.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblEarthWire.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEarthWire.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEarthWireMouseClicked(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel18.setText("K");

        lblLightbulb.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblLightbulb.setForeground(new java.awt.Color(102, 102, 102));
        lblLightbulb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLightbulb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        lblLightbulb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLightbulb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLightbulbMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(3, 3, 3)
                        .addComponent(lblDistributionWire, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSupplyCable, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblOverloadCircuitBreaker, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(3, 3, 3)
                                .addComponent(lblElectricMeter, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(3, 3, 3)
                                .addComponent(lblcircuteBrakeFuses, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel15))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEarthWire, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18)))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSwitch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIsolator, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(lblLightbulb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCurrebtCircuteBraker, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addGap(7, 7, 7)
                                .addComponent(lblPlugSocket, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDistributionWire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(lblSupplyCable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblOverloadCircuitBreaker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblElectricMeter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(lblIsolator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCurrebtCircuteBraker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblcircuteBrakeFuses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(lblSwitch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPlugSocket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEarthWire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(lblLightbulb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        btnChack1.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        btnChack1.setForeground(new java.awt.Color(51, 51, 51));
        btnChack1.setText("Back");
        btnChack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChack1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnChack1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChack1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlAnswer.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Answers");

        btnSupplyCable.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnSupplyCable.setForeground(new java.awt.Color(102, 102, 102));
        btnSupplyCable.setText("Supply cable");
        btnSupplyCable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnSupplyCable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSupplyCable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplyCableActionPerformed(evt);
            }
        });

        btnOverloadCircuitBreaker.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnOverloadCircuitBreaker.setForeground(new java.awt.Color(102, 102, 102));
        btnOverloadCircuitBreaker.setText("Overload circuit breaker");
        btnOverloadCircuitBreaker.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnOverloadCircuitBreaker.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOverloadCircuitBreaker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOverloadCircuitBreakerActionPerformed(evt);
            }
        });

        btnElectricMeter.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnElectricMeter.setForeground(new java.awt.Color(102, 102, 102));
        btnElectricMeter.setText("Electric meter");
        btnElectricMeter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnElectricMeter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnElectricMeter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElectricMeterActionPerformed(evt);
            }
        });

        btnIsolator.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnIsolator.setForeground(new java.awt.Color(102, 102, 102));
        btnIsolator.setText("Isolator");
        btnIsolator.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnIsolator.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIsolator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIsolatorActionPerformed(evt);
            }
        });

        btnCurrebtCircuteBraker.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnCurrebtCircuteBraker.setForeground(new java.awt.Color(102, 102, 102));
        btnCurrebtCircuteBraker.setText("<html>Residual current circuit<br>breaker or trip switch</html>");
        btnCurrebtCircuteBraker.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnCurrebtCircuteBraker.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCurrebtCircuteBraker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCurrebtCircuteBrakerActionPerformed(evt);
            }
        });

        btncircuteBrakeFuses.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btncircuteBrakeFuses.setForeground(new java.awt.Color(102, 102, 102));
        btncircuteBrakeFuses.setText("<html> miniature circuit <br>breakers or fuses </html>");
        btncircuteBrakeFuses.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btncircuteBrakeFuses.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncircuteBrakeFuses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncircuteBrakeFusesActionPerformed(evt);
            }
        });

        btnDistributionWire.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnDistributionWire.setForeground(new java.awt.Color(102, 102, 102));
        btnDistributionWire.setText("Distribution wire");
        btnDistributionWire.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnDistributionWire.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDistributionWire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDistributionWireActionPerformed(evt);
            }
        });

        btnSwitch.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnSwitch.setForeground(new java.awt.Color(102, 102, 102));
        btnSwitch.setText("Switch");
        btnSwitch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnSwitch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSwitch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSwitchActionPerformed(evt);
            }
        });

        btnPlugSocket.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnPlugSocket.setForeground(new java.awt.Color(102, 102, 102));
        btnPlugSocket.setText(" plug socket");
        btnPlugSocket.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnPlugSocket.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlugSocket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlugSocketActionPerformed(evt);
            }
        });

        btnEarthWire.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnEarthWire.setForeground(new java.awt.Color(102, 102, 102));
        btnEarthWire.setText("Earth wire");
        btnEarthWire.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnEarthWire.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEarthWire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEarthWireActionPerformed(evt);
            }
        });

        btnLightbulb.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        btnLightbulb.setForeground(new java.awt.Color(102, 102, 102));
        btnLightbulb.setText(" Light bulb");
        btnLightbulb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnLightbulb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLightbulb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLightbulbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAnswerLayout = new javax.swing.GroupLayout(pnlAnswer);
        pnlAnswer.setLayout(pnlAnswerLayout);
        pnlAnswerLayout.setHorizontalGroup(
            pnlAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAnswerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLightbulb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btncircuteBrakeFuses)
                    .addComponent(btnCurrebtCircuteBraker)
                    .addComponent(btnElectricMeter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOverloadCircuitBreaker, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addComponent(btnSwitch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEarthWire, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPlugSocket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIsolator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSupplyCable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDistributionWire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlAnswerLayout.setVerticalGroup(
            pnlAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAnswerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSupplyCable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDistributionWire, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOverloadCircuitBreaker, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnElectricMeter, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCurrebtCircuteBraker, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPlugSocket, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncircuteBrakeFuses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIsolator, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEarthWire, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLightbulb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        btnReattampt.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        btnReattampt.setForeground(new java.awt.Color(51, 51, 51));
        btnReattampt.setText("Reattempt ");
        btnReattampt.setEnabled(false);
        btnReattampt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReattamptActionPerformed(evt);
            }
        });

        btnChack.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        btnChack.setForeground(new java.awt.Color(51, 51, 51));
        btnChack.setText("Chack");
        btnChack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnChack, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReattampt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnChack, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(btnReattampt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pnlAnswer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnl_Header, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked

    }//GEN-LAST:event_jPanel14MouseClicked

    private void btnHeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHeatActionPerformed

    }//GEN-LAST:event_btnHeatActionPerformed

    private void btnSupplyCableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplyCableActionPerformed
        complete = complete + 9;
        String txt = btnSupplyCable.getText();
        selectedLabal.setText(txt);
        btnSupplyCable.setVisible(false);
        disable();
    }//GEN-LAST:event_btnSupplyCableActionPerformed

    private void btnOverloadCircuitBreakerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOverloadCircuitBreakerActionPerformed
        complete = complete + 9;
        String txt = btnOverloadCircuitBreaker.getText();
        selectedLabal.setText(txt);
        btnOverloadCircuitBreaker.setVisible(false);
        disable();
    }//GEN-LAST:event_btnOverloadCircuitBreakerActionPerformed

    private void btnElectricMeterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElectricMeterActionPerformed
        complete = complete + 9;
        String txt = btnElectricMeter.getText();
        selectedLabal.setText(txt);
        btnElectricMeter.setVisible(false);
        disable();
    }//GEN-LAST:event_btnElectricMeterActionPerformed

    private void btnIsolatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIsolatorActionPerformed
        complete = complete + 9;
        String txt = btnIsolator.getText();
        selectedLabal.setText(txt);
        btnIsolator.setVisible(false);
        disable();
    }//GEN-LAST:event_btnIsolatorActionPerformed

    private void btnCurrebtCircuteBrakerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCurrebtCircuteBrakerActionPerformed
        complete = complete + 9;
        String txt = btnCurrebtCircuteBraker.getText();
        selectedLabal.setText(txt);
        btnCurrebtCircuteBraker.setVisible(false);
        disable();
    }//GEN-LAST:event_btnCurrebtCircuteBrakerActionPerformed

    private void btncircuteBrakeFusesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncircuteBrakeFusesActionPerformed
        complete = complete + 9;
        String txt = btncircuteBrakeFuses.getText();
        selectedLabal.setText(txt);
        btncircuteBrakeFuses.setVisible(false);
        disable();
    }//GEN-LAST:event_btncircuteBrakeFusesActionPerformed

    private void btnDistributionWireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDistributionWireActionPerformed
        // TODO add your handling code here:
        complete = complete + 9;
        String txt = btnDistributionWire.getText();
        selectedLabal.setText(txt);
        btnDistributionWire.setVisible(false);
        disable();
    }//GEN-LAST:event_btnDistributionWireActionPerformed

    private void btnSwitchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwitchActionPerformed
        complete = complete + 9;
        String txt = btnSwitch.getText();
        selectedLabal.setText(txt);
        btnSwitch.setVisible(false);
        disable();
    }//GEN-LAST:event_btnSwitchActionPerformed

    private void btnPlugSocketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlugSocketActionPerformed
        complete = complete + 9;
        String txt = btnPlugSocket.getText();
        selectedLabal.setText(txt);
        btnPlugSocket.setVisible(false);
        disable();
    }//GEN-LAST:event_btnPlugSocketActionPerformed

    private void btnEarthWireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEarthWireActionPerformed
        complete = complete + 9;
        String txt = btnEarthWire.getText();
        selectedLabal.setText(txt);
        btnEarthWire.setVisible(false);
        disable();
    }//GEN-LAST:event_btnEarthWireActionPerformed

    private void btnLightbulbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLightbulbActionPerformed
        complete = complete + 9;
        String txt = btnLightbulb.getText();
        selectedLabal.setText(txt);
        btnLightbulb.setVisible(false);
        disable();
    }//GEN-LAST:event_btnLightbulbActionPerformed

    private void lblDistributionWireMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDistributionWireMouseClicked

        selectedLabal = lblDistributionWire;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {
            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblDistributionWireMouseClicked

    private void lblSupplyCableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSupplyCableMouseClicked
        selectedLabal = lblSupplyCable;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {

            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblSupplyCableMouseClicked

    private void lblOverloadCircuitBreakerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOverloadCircuitBreakerMouseClicked
        selectedLabal = lblOverloadCircuitBreaker;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {

            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblOverloadCircuitBreakerMouseClicked

    private void lblElectricMeterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblElectricMeterMouseClicked
        selectedLabal = lblElectricMeter;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {

            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblElectricMeterMouseClicked

    private void lblIsolatorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIsolatorMouseClicked
        selectedLabal = lblIsolator;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {

            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblIsolatorMouseClicked

    private void lblCurrebtCircuteBrakerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCurrebtCircuteBrakerMouseClicked
        selectedLabal = lblCurrebtCircuteBraker;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {

            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblCurrebtCircuteBrakerMouseClicked

    private void lblSwitchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSwitchMouseClicked
        selectedLabal = lblSwitch;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {

            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblSwitchMouseClicked

    private void lblcircuteBrakeFusesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcircuteBrakeFusesMouseClicked
        selectedLabal = lblcircuteBrakeFuses;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {

            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblcircuteBrakeFusesMouseClicked

    private void lblPlugSocketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPlugSocketMouseClicked
        selectedLabal = lblPlugSocket;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {

            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblPlugSocketMouseClicked

    private void lblEarthWireMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEarthWireMouseClicked
        selectedLabal = lblEarthWire;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {

            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblEarthWireMouseClicked

    private void lblLightbulbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLightbulbMouseClicked
        selectedLabal = lblLightbulb;
        if (selectedLabal.getText().equals("")) {
            dfault();
            selectLabal();
        } else {

            dfault();
            retunButon();

        }
    }//GEN-LAST:event_lblLightbulbMouseClicked

    private void btnChackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChackActionPerformed

        score = 0;
        ///////////
        if (lblDistributionWire.getText().equals("Distribution wire")) {
            lblDistributionWire.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 9;

        } else {
            lblDistributionWire.setBorder(BorderFactory.createLineBorder(Color.red));

        }
        ///////////
        if (lblSupplyCable.getText().equals("Supply cable")) {
            lblSupplyCable.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 9;

        } else {
            lblSupplyCable.setBorder(BorderFactory.createLineBorder(Color.red));

        }
        ///////////
        if (lblOverloadCircuitBreaker.getText().equals("Overload circuit breaker")) {
            lblOverloadCircuitBreaker.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 9;

        } else {
            lblOverloadCircuitBreaker.setBorder(BorderFactory.createLineBorder(Color.red));

        }
        ///////////
        if (lblElectricMeter.getText().equals("Electric meter")) {
            lblElectricMeter.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 9;

        } else {
            lblElectricMeter.setBorder(BorderFactory.createLineBorder(Color.red));

        }///////////

        if (lblIsolator.getText().equals("Isolator")) {
            lblIsolator.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 9;

        } else {
            lblIsolator.setBorder(BorderFactory.createLineBorder(Color.red));

        }///////////
        if (lblCurrebtCircuteBraker.getText().equals("<html>Residual current circuit<br>breaker or trip switch</html>")) {
            lblCurrebtCircuteBraker.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 9;

        } else {
            lblCurrebtCircuteBraker.setBorder(BorderFactory.createLineBorder(Color.red));

        }///////////
        if (lblcircuteBrakeFuses.getText().equals("<html> miniature circuit <br>breakers or fuses </html>")) {
            lblcircuteBrakeFuses.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 9;

        } else {
            lblcircuteBrakeFuses.setBorder(BorderFactory.createLineBorder(Color.red));

        }///////////
        if (lblSwitch.getText().equals("Switch")) {
            lblSwitch.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 9;

        } else {
            lblSwitch.setBorder(BorderFactory.createLineBorder(Color.red));

        }///////////
        if (lblPlugSocket.getText().equals(" plug socket")) {
            lblPlugSocket.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 9;

        } else {
            lblPlugSocket.setBorder(BorderFactory.createLineBorder(Color.red));

        }///////////
        if (lblEarthWire.getText().equals("Earth wire")) {
            lblEarthWire.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 9;

        } else {
            lblEarthWire.setBorder(BorderFactory.createLineBorder(Color.red));

        }///////////
        if (lblLightbulb.getText().equals(" Light bulb")) {
            lblLightbulb.setBorder(BorderFactory.createLineBorder(Color.green));
            score = score + 9;

        } else {
            lblLightbulb.setBorder(BorderFactory.createLineBorder(Color.red));

        }

        if (complete == 99) {
            complete = complete + 1;
        }

        lblComplete.setText("Completed - " + complete + "%");

        if (score == 99) {
            score = score + 1;
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
        lblScoreSide.setText("Score - " + score);
        insertToSql();
    }//GEN-LAST:event_btnChackActionPerformed

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

    private void btnChack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChack1ActionPerformed
        Main.ScienceHub sh = new Main.ScienceHub();
        sh.setId(idPas);
        sh.show();
        this.dispose();
    }//GEN-LAST:event_btnChack1ActionPerformed

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
            java.util.logging.Logger.getLogger(houseElectricGrid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(houseElectricGrid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(houseElectricGrid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(houseElectricGrid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new houseElectricGrid().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChack;
    private javax.swing.JButton btnChack1;
    private javax.swing.JButton btnCurrebtCircuteBraker;
    private javax.swing.JButton btnDistributionWire;
    private javax.swing.JButton btnEarthWire;
    private javax.swing.JButton btnElectricMeter;
    private javax.swing.JButton btnHeat;
    private javax.swing.JButton btnIsolator;
    private javax.swing.JButton btnLightbulb;
    private javax.swing.JButton btnOverloadCircuitBreaker;
    private javax.swing.JButton btnPlugSocket;
    private javax.swing.JButton btnReattampt;
    private javax.swing.JButton btnSupplyCable;
    private javax.swing.JButton btnSwitch;
    private javax.swing.JButton btncircuteBrakeFuses;
    private javax.swing.JButton health1;
    private javax.swing.JButton health2;
    private javax.swing.JButton health3;
    private javax.swing.JButton health4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JLabel lblComplete;
    private javax.swing.JLabel lblCurrebtCircuteBraker;
    private javax.swing.JLabel lblDistributionWire;
    private javax.swing.JLabel lblEarthWire;
    private javax.swing.JLabel lblElectricMeter;
    private javax.swing.JLabel lblIsolator;
    private javax.swing.JLabel lblLightbulb;
    private javax.swing.JLabel lblMainObject;
    private javax.swing.JLabel lblOverloadCircuitBreaker;
    private javax.swing.JLabel lblPlugSocket;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblScoreSide;
    private javax.swing.JLabel lblSupplyCable;
    private javax.swing.JLabel lblSwitch;
    private javax.swing.JLabel lblUname;
    private javax.swing.JLabel lblUserName9;
    private javax.swing.JLabel lblcircuteBrakeFuses;
    private javax.swing.JPanel pnlAnswer;
    private javax.swing.JPanel pnl_Header;
    // End of variables declaration//GEN-END:variables
}
