/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ICT;

import Main.Deshbord;
import Science.ElectronicConfiguration;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

/**
 *
 * @author mmamm
 */
public class base2intoBase16 extends javax.swing.JFrame {

    /**
     * Creates new form base2intoBase16
     */
    JTextField selectedTxt;

    public base2intoBase16() {
        initComponents();
        qustions();

        jTextField3.setVisible(false);
        jTextField4.setVisible(false);
        jSeparator9.setVisible(false);
        lblerror.setVisible(false);
    }

    String idPas = "";
    String enter;
    int score = 0;
    int health = 4;
    int complete = 0;

    public void insertToSql() {

        try {
            // create connection to database
            Connection con = database.db.getConnection();
            // Create prepared statement with the sql query
            PreparedStatement st1 = con.prepareStatement("UPDATE `smart_learning`.`ict` SET `base2intoBase16Score` = ?, `base2intoBase16Complete` = ? WHERE (`stRegId` = '" + idPas + "');");
            // execute query
            st1.setString(1, score + "");
            st1.setString(2, complete + "");

            st1.executeUpdate();

            // show success message
        } catch (SQLException ex) {
            Logger.getLogger(ElectronicConfiguration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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

    public void chack() {
        int a1 = 1 * Integer.valueOf(sq1.getText());
        int a2 = 2 * Integer.valueOf(sq2.getText());
        int a3 = 4 * Integer.valueOf(sq3.getText());
        int a4 = 8 * Integer.valueOf(sq4.getText());
        int a5 = 16 * Integer.valueOf(sq5.getText());
        int a6 = 32 * Integer.valueOf(sq6.getText());

        String answer1 = String.valueOf(a1);
        String answer2 = String.valueOf(a2);
        String answer3 = String.valueOf(a3);
        String answer4 = String.valueOf(a4);
        String answer5 = String.valueOf(a5);
        String answer6 = String.valueOf(a6);

        // chech power
        if (power1.getText().equals("1") && power2.getText().equals("2") && power3.getText().equals("4")
                && power4.getText().equals("8") && power5.getText().equals("16") && power6.getText().equals("32")) {

        } else {

        }

        if (ans1.getText().equals(answer1) && ans2.getText().equals(answer2) && ans3.getText().equals(answer3) && ans4.getText().equals(answer4)
                && ans5.getText().equals(answer5) && ans6.getText().equals(answer6)) {
        } else {

        }

        //chack final answer
        int fanswer = a1 + a2 + a3 + a4 + a5 + a6;
        int uAnswer = Integer.valueOf(fAnswer.getText());
        System.out.println(fanswer);

        if (uAnswer == fanswer) {
            score = score + 2;
            BtnCheck1.setEnabled(true);
            fAnswer.setBorder(BorderFactory.createLineBorder(Color.GREEN));

        } else {
            fAnswer.setBorder(BorderFactory.createLineBorder(Color.RED));

        }

    }

    public void selectLabal() {
        selectedTxt.setBorder(BorderFactory.createLineBorder(Color.blue));
    }

    public void fullReset() {
        health1.setVisible(true);
        health2.setVisible(true);
        health3.setVisible(true);
        health4.setVisible(true);

        complete = 0;
        lblComplete.setText("Completed - " + complete + " %");

        score = 0;
        lblScore.setText(score + "");
        lblScoreSide.setText("Score - " + score);

        power1.setText("");
        power2.setText("");
        power3.setText("");
        power4.setText("");
        power5.setText("");
        power6.setText("");

        ans1.setText("");
        ans2.setText("");
        ans3.setText("");
        ans4.setText("");
        ans5.setText("");
        ans6.setText("");
        fAnswer.setText("");
        fAnswer.setEnabled(true);

        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");

        lblerror.setVisible(false);

        ffAnswer.setText("");

//        jLabel4.setForeground(new Color(102, 102, 102));
        // jLabel3.setForeground(new Color(102, 102, 102));
        // jLabel5.setForeground(new Color(102, 102, 102));
        dfault();
        qustions();
    }

    public void reset() {
        power1.setText("");
        power2.setText("");
        power3.setText("");
        power4.setText("");
        power5.setText("");
        power6.setText("");

        ans1.setText("");
        ans2.setText("");
        ans3.setText("");
        ans4.setText("");
        ans5.setText("");
        ans6.setText("");

        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jLabel18.setText("XX");

        lblerror.setVisible(false);

        ffAnswer.setText("");
        fAnswer.setText("");

//        jLabel4.setForeground(new Color(102, 102, 102));
        //   jLabel3.setForeground(new Color(102, 102, 102));
        //  jLabel5.setForeground(new Color(102, 102, 102));
        dfault();
    }

    public void dfault() {
        power1.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        power2.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        power3.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        power4.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        power5.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        power6.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));

        ans1.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 0)));
        ans2.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 0)));
        ans3.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 0)));
        ans4.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 0)));
        ans5.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 0)));
        ans6.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 0)));
        fAnswer.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 0)));

        jTextField1.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 0)));
        jTextField2.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 0)));
        jTextField3.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 0)));
        jTextField4.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 0)));
        ffAnswer.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 0)));

    }

    public void qustions() {
        Random rand = new Random();

        int qustion1 = rand.nextInt(2);
        int qustion2 = rand.nextInt(2);
        int qustion3 = rand.nextInt(2);
        int qustion4 = rand.nextInt(2);
        int qustion5 = rand.nextInt(2);
        int qustion6 = rand.nextInt(2);

        q1.setText(qustion1 + "");
        q2.setText(qustion2 + "");
        q3.setText(qustion3 + "");
        q4.setText(qustion4 + "");
        q5.setText(qustion5 + "");
        q6.setText(qustion6 + "");

        sq1.setText(qustion1 + "");
        sq2.setText(qustion2 + "");
        sq3.setText(qustion3 + "");
        sq4.setText(qustion4 + "");
        sq5.setText(qustion5 + "");
        sq6.setText(qustion6 + "");
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
        jLabel11 = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        health1 = new javax.swing.JButton();
        health4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        health2 = new javax.swing.JButton();
        lblMainObject = new javax.swing.JLabel();
        health3 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        lblUname = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        lblUserName9 = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        lblComplete = new javax.swing.JLabel();
        lblScoreSide = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        lblUserName10 = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JSeparator();
        lblComplete1 = new javax.swing.JLabel();
        lblScoreSide1 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        lblUserName11 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        lblComplete2 = new javax.swing.JLabel();
        lblScoreSide2 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        power1 = new javax.swing.JTextField();
        sq1 = new javax.swing.JLabel();
        sq2 = new javax.swing.JLabel();
        sq3 = new javax.swing.JLabel();
        sq4 = new javax.swing.JLabel();
        sq5 = new javax.swing.JLabel();
        sq6 = new javax.swing.JLabel();
        power2 = new javax.swing.JTextField();
        power3 = new javax.swing.JTextField();
        power4 = new javax.swing.JTextField();
        power5 = new javax.swing.JTextField();
        power6 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        ans1 = new javax.swing.JTextField();
        ans2 = new javax.swing.JTextField();
        ans3 = new javax.swing.JTextField();
        ans4 = new javax.swing.JTextField();
        ans5 = new javax.swing.JTextField();
        ans6 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        btn_reattempt = new javax.swing.JButton();
        BtnCheck = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        fAnswer = new javax.swing.JTextField();
        btnNext = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BtnCheck1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jTextField4 = new javax.swing.JTextField();
        BtnCheck2 = new javax.swing.JButton();
        lblerror = new javax.swing.JLabel();
        ffAnswer = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        q6 = new javax.swing.JLabel();
        q5 = new javax.swing.JLabel();
        q2 = new javax.swing.JLabel();
        q4 = new javax.swing.JLabel();
        q1 = new javax.swing.JLabel();
        q3 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Set the answer to given text box");

        lblScore.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblScore.setForeground(new java.awt.Color(102, 102, 102));
        lblScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScore.setText("000");

        health1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hart.png"))); // NOI18N
        health1.setBorder(null);
        health1.setContentAreaFilled(false);

        health4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hart.png"))); // NOI18N
        health4.setBorder(null);
        health4.setContentAreaFilled(false);

        jLabel13.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Score");

        health2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hart.png"))); // NOI18N
        health2.setBorder(null);
        health2.setContentAreaFilled(false);

        lblMainObject.setFont(new java.awt.Font("Segoe UI", 2, 28)); // NOI18N
        lblMainObject.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMainObject.setText("Base 2 into Base 16");

        health3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hart.png"))); // NOI18N
        health3.setBorder(null);
        health3.setContentAreaFilled(false);

        jLabel12.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Health");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 20, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(health1)
                            .addGap(9, 9, 9)
                            .addComponent(health2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(49, 49, 49)
                                    .addComponent(health4))
                                .addComponent(health3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(36, 36, 36)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblMainObject, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(59, 59, 59)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel13)
                        .addComponent(lblScore, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 49, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(health1)
                                .addComponent(health2)
                                .addComponent(health4)
                                .addComponent(health3)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblMainObject)
                            .addGap(12, 12, 12)
                            .addComponent(jLabel11))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addGap(8, 8, 8)
                            .addComponent(lblScore)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

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
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        jPanel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel14.setEnabled(false);

        lblUserName9.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        lblUserName9.setForeground(new java.awt.Color(51, 51, 51));
        lblUserName9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserName9.setText("Base 2 into Base 10");

        lblComplete.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        lblComplete.setForeground(new java.awt.Color(51, 51, 51));
        lblComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblComplete.setText("Completed - 0%");

        lblScoreSide.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        lblScoreSide.setForeground(new java.awt.Color(51, 51, 51));
        lblScoreSide.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScoreSide.setText("Score - 000");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserName9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblScoreSide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblComplete, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
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

        jButton2.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jButton2.setText("Base 2 into Base 10");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255), 2));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel15.setBackground(new java.awt.Color(247, 247, 247));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        jPanel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel15.setEnabled(false);

        lblUserName10.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        lblUserName10.setForeground(new java.awt.Color(51, 51, 51));
        lblUserName10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserName10.setText("Base 2 into Base 8");

        lblComplete1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        lblComplete1.setForeground(new java.awt.Color(51, 51, 51));
        lblComplete1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblComplete1.setText("Completed - 0%");

        lblScoreSide1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        lblScoreSide1.setForeground(new java.awt.Color(51, 51, 51));
        lblScoreSide1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScoreSide1.setText("Score - 000");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserName10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblScoreSide1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblComplete1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(jSeparator15))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblUserName10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblComplete1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblScoreSide1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jButton13.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jButton13.setText("Base 2 into Base 8");
        jButton13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255), 2));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jPanel16.setBackground(new java.awt.Color(247, 247, 247));
        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        jPanel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel16.setEnabled(false);

        lblUserName11.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        lblUserName11.setForeground(new java.awt.Color(51, 51, 51));
        lblUserName11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserName11.setText("Base 2 into Base 16");

        lblComplete2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        lblComplete2.setForeground(new java.awt.Color(51, 51, 51));
        lblComplete2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblComplete2.setText("Completed - 0%");

        lblScoreSide2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        lblScoreSide2.setForeground(new java.awt.Color(51, 51, 51));
        lblScoreSide2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScoreSide2.setText("Score - 000");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserName11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblScoreSide2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblComplete2, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(jSeparator16))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblUserName11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblComplete2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblScoreSide2)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jButton14.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jButton14.setText("Base 2 into Base 16");
        jButton14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255), 2));
        jButton14.setEnabled(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("<html>2<sup>0</sup></html>");

        jLabel8.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("<html>2<sup>1</sup></html>");

        jLabel9.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("<html>2<sup>2</sup></html>");

        jLabel10.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("<html>2<sup>3</sup></html>");

        jLabel16.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("<html>2<sup>4</sup></html>");

        jLabel17.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("<html>2<sup>5</sup></html>");

        power1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        power1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        power1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        power1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                power1MouseClicked(evt);
            }
        });

        sq1.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        sq1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sq1.setText("0");

        sq2.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        sq2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sq2.setText("0");

        sq3.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        sq3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sq3.setText("0");

        sq4.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        sq4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sq4.setText("0");

        sq5.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        sq5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sq5.setText("0");

        sq6.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        sq6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sq6.setText("0");

        power2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        power2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        power2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        power2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                power2MouseClicked(evt);
            }
        });

        power3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        power3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        power3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        power3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                power3MouseClicked(evt);
            }
        });

        power4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        power4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        power4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        power4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                power4MouseClicked(evt);
            }
        });

        power5.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        power5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        power5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        power5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                power5MouseClicked(evt);
            }
        });

        power6.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        power6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        power6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        power6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                power6MouseClicked(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));

        ans1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        ans1.setForeground(new java.awt.Color(51, 51, 51));
        ans1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ans1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 0)));
        ans1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ans1MouseClicked(evt);
            }
        });

        ans2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        ans2.setForeground(new java.awt.Color(51, 51, 51));
        ans2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ans2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 0)));
        ans2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ans2MouseClicked(evt);
            }
        });

        ans3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        ans3.setForeground(new java.awt.Color(51, 51, 51));
        ans3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ans3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 0)));
        ans3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ans3MouseClicked(evt);
            }
        });

        ans4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        ans4.setForeground(new java.awt.Color(51, 51, 51));
        ans4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ans4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 0)));
        ans4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ans4MouseClicked(evt);
            }
        });

        ans5.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        ans5.setForeground(new java.awt.Color(51, 51, 51));
        ans5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ans5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 0)));
        ans5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ans5MouseClicked(evt);
            }
        });
        ans5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ans5ActionPerformed(evt);
            }
        });

        ans6.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        ans6.setForeground(new java.awt.Color(51, 51, 51));
        ans6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ans6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 0)));
        ans6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ans6MouseClicked(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));

        jSeparator3.setForeground(new java.awt.Color(102, 102, 102));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("+");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("+");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("+");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("+");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("+");

        jButton1.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("0");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText("1");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton3MouseReleased(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 51, 51));
        jButton4.setText("2");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton4MouseReleased(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(51, 51, 51));
        jButton5.setText("3");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton5MouseReleased(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(51, 51, 51));
        jButton7.setText("4");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton7MouseReleased(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(51, 51, 51));
        jButton8.setText("5");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton8MouseReleased(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(51, 51, 51));
        jButton9.setText("6");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton9MouseReleased(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(51, 51, 51));
        jButton10.setText("7");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton10MouseReleased(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jButton11.setForeground(new java.awt.Color(51, 51, 51));
        jButton11.setText("8");
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton11MouseReleased(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jButton12.setForeground(new java.awt.Color(51, 51, 51));
        jButton12.setText("9");
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton12MouseReleased(evt);
            }
        });
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btn_reattempt.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btn_reattempt.setText("Reattempt");
        btn_reattempt.setEnabled(false);
        btn_reattempt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reattemptActionPerformed(evt);
            }
        });

        BtnCheck.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        BtnCheck.setText("Check");
        BtnCheck.setEnabled(false);
        BtnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCheckActionPerformed(evt);
            }
        });

        btn_back.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btn_back.setForeground(new java.awt.Color(0, 51, 51));
        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        fAnswer.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        fAnswer.setForeground(new java.awt.Color(51, 51, 51));
        fAnswer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fAnswer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 0)));
        fAnswer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fAnswerMouseClicked(evt);
            }
        });
        fAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fAnswerActionPerformed(evt);
            }
        });
        fAnswer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fAnswerKeyReleased(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnNext.setText("Next");
        btnNext.setEnabled(false);
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Power of 2");

        jLabel2.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Final Answer");

        BtnCheck1.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        BtnCheck1.setText("Next Step");
        BtnCheck1.setEnabled(false);
        BtnCheck1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCheck1ActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Base 10 into Base 8");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 16, 225, -1));

        jLabel18.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("XX");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 66, 62, -1));

        jLabel19.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel19.setText("16");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 66, -1, -1));

        jSeparator4.setForeground(new java.awt.Color(51, 51, 51));
        jPanel6.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 93, 70, 10));

        jSeparator5.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel6.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 57, -1, 40));

        jLabel20.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 103, 13, 31));

        jTextField1.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 0)));
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 103, 42, 31));

        jSeparator8.setForeground(new java.awt.Color(51, 51, 51));
        jPanel6.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 117, 14, -1));

        jTextField2.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 0)));
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jPanel6.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 103, 40, 31));

        jTextField3.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 0)));
        jTextField3.setEnabled(false);
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
        });
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 152, 40, 31));

        jSeparator9.setForeground(new java.awt.Color(51, 51, 51));
        jPanel6.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 163, 14, -1));

        jTextField4.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 0)));
        jTextField4.setEnabled(false);
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField4MouseClicked(evt);
            }
        });
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 152, 42, 31));

        BtnCheck2.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        BtnCheck2.setText("Check");
        BtnCheck2.setEnabled(false);
        BtnCheck2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCheck2ActionPerformed(evt);
            }
        });
        jPanel6.add(BtnCheck2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 172, -1));

        lblerror.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblerror.setForeground(new java.awt.Color(153, 0, 0));
        lblerror.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblerror.setText("Some Filds are empty !");
        jPanel6.add(lblerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 220, -1));

        ffAnswer.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        ffAnswer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ffAnswer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 0)));
        ffAnswer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ffAnswerMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ffAnswerMouseReleased(evt);
            }
        });
        ffAnswer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ffAnswerKeyReleased(evt);
            }
        });
        jPanel6.add(ffAnswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 172, 42));

        jSeparator6.setForeground(new java.awt.Color(51, 51, 51));
        jPanel6.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 70, -1));

        jSeparator7.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel6.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 101, -1, 40));

        jLabel21.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Base 8 Answer");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 212, 225, -1));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_reattempt)
                        .addGap(18, 18, 18)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(ans6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(2, 2, 2)
                                    .addComponent(jLabel28)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ans5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)
                                    .addComponent(jLabel27)
                                    .addGap(3, 3, 3)
                                    .addComponent(ans4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(1, 1, 1)
                                    .addComponent(jLabel26)
                                    .addGap(7, 7, 7)
                                    .addComponent(ans3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(4, 4, 4)
                                    .addComponent(jLabel25)
                                    .addGap(4, 4, 4)
                                    .addComponent(ans2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(3, 3, 3)
                                    .addComponent(jLabel15)
                                    .addGap(5, 5, 5)
                                    .addComponent(ans1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(sq6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(sq5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(sq4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(sq3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(sq2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(sq1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                    .addGap(6, 6, 6)
                                                    .addComponent(power6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                    .addGap(6, 6, 6)
                                                    .addComponent(power5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                    .addGap(6, 6, 6)
                                                    .addComponent(power4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                    .addGap(6, 6, 6)
                                                    .addComponent(power3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                    .addGap(6, 6, 6)
                                                    .addComponent(power2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                    .addGap(6, 6, 6)
                                                    .addComponent(power1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(fAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(BtnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(BtnCheck1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(power1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(power2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(power3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(power4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(power5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(power6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sq6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sq1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sq2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sq3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sq4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sq5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ans4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ans5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ans6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ans1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ans2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ans3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fAnswer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnCheck)
                            .addComponent(BtnCheck1)))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_back)
                    .addComponent(btn_reattempt)
                    .addComponent(btnNext))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        q6.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        q6.setForeground(new java.awt.Color(102, 102, 102));
        q6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        q6.setText("0");

        q5.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        q5.setForeground(new java.awt.Color(102, 102, 102));
        q5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        q5.setText("0");

        q2.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        q2.setForeground(new java.awt.Color(102, 102, 102));
        q2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        q2.setText("0");

        q4.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        q4.setForeground(new java.awt.Color(102, 102, 102));
        q4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        q4.setText("0");

        q1.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        q1.setForeground(new java.awt.Color(102, 102, 102));
        q1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        q1.setText("0");

        q3.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        q3.setForeground(new java.awt.Color(102, 102, 102));
        q3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        q3.setText("0");

        jLabel24.setFont(new java.awt.Font("Poppins Medium", 0, 10)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(q6)
                .addGap(18, 18, 18)
                .addComponent(q5)
                .addGap(18, 18, 18)
                .addComponent(q4)
                .addGap(18, 18, 18)
                .addComponent(q3)
                .addGap(18, 18, 18)
                .addComponent(q2)
                .addGap(18, 18, 18)
                .addComponent(q1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(q1)
                            .addComponent(q2)
                            .addComponent(q3)
                            .addComponent(q4)
                            .addComponent(q5)
                            .addComponent(q6))
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 502, Short.MAX_VALUE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void power1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_power1MouseClicked
        selectedTxt = power1;
        if (selectedTxt.getText().equals("")) {

            dfault();
            selectLabal();
        } else {
            dfault();
            selectLabal();
            selectedTxt.setText("");
        }
    }//GEN-LAST:event_power1MouseClicked

    private void power2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_power2MouseClicked
        selectedTxt = power2;
        if (selectedTxt.getText().equals("")) {

            dfault();
            selectLabal();
        } else {
            dfault();
            selectLabal();
            selectedTxt.setText("");
        }
    }//GEN-LAST:event_power2MouseClicked

    private void power3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_power3MouseClicked
        selectedTxt = power3;
        if (selectedTxt.getText().equals("")) {

            dfault();
            selectLabal();
        } else {
            dfault();
            selectLabal();
            selectedTxt.setText("");
        }
    }//GEN-LAST:event_power3MouseClicked

    private void power4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_power4MouseClicked
        selectedTxt = power4;
        if (selectedTxt.getText().equals("")) {

            dfault();
            selectLabal();
        } else {
            dfault();
            selectLabal();
            selectedTxt.setText("");
        }
    }//GEN-LAST:event_power4MouseClicked

    private void power5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_power5MouseClicked
        selectedTxt = power5;
        if (selectedTxt.getText().equals("")) {

            dfault();
            selectLabal();
        } else {
            dfault();
            selectLabal();
            selectedTxt.setText("");
        }
    }//GEN-LAST:event_power5MouseClicked

    private void power6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_power6MouseClicked
        selectedTxt = power6;
        if (selectedTxt.getText().equals("")) {

            dfault();
            selectLabal();
        } else {
            dfault();
            selectLabal();
            selectedTxt.setText("");
        }
    }//GEN-LAST:event_power6MouseClicked

    private void ans1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ans1MouseClicked
        selectedTxt = ans1;
        if (selectedTxt.getText().equals("")) {

            dfault();
            selectLabal();
        } else {
            dfault();
            selectLabal();
            selectedTxt.setText("");
        }
    }//GEN-LAST:event_ans1MouseClicked

    private void ans2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ans2MouseClicked
        selectedTxt = ans2;
        if (selectedTxt.getText().equals("")) {

            dfault();
            selectLabal();
        } else {
            dfault();
            selectLabal();
            selectedTxt.setText("");
        }
    }//GEN-LAST:event_ans2MouseClicked

    private void ans3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ans3MouseClicked
        selectedTxt = ans3;
        if (selectedTxt.getText().equals("")) {

            dfault();
            selectLabal();
        } else {
            dfault();
            selectLabal();
            selectedTxt.setText("");
        }
    }//GEN-LAST:event_ans3MouseClicked

    private void ans4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ans4MouseClicked
        selectedTxt = ans4;
        if (selectedTxt.getText().equals("")) {

            dfault();
            selectLabal();
        } else {
            dfault();
            selectLabal();
            selectedTxt.setText("");
        }
    }//GEN-LAST:event_ans4MouseClicked

    private void ans5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ans5MouseClicked
        selectedTxt = ans5;
        if (selectedTxt.getText().equals("")) {

            dfault();
            selectLabal();
        } else {
            dfault();
            selectLabal();
            selectedTxt.setText("");
        }
    }//GEN-LAST:event_ans5MouseClicked

    private void ans5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ans5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ans5ActionPerformed

    private void ans6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ans6MouseClicked
        selectedTxt = ans6;
        if (selectedTxt.getText().equals("")) {

            dfault();
            selectLabal();
        } else {
            dfault();
            selectLabal();
            selectedTxt.setText("");
        }
    }//GEN-LAST:event_ans6MouseClicked

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        if (!fAnswer.getText().equals("")) {
            BtnCheck.setEnabled(true);
        } else {
            BtnCheck.setEnabled(false);
        }

    }//GEN-LAST:event_jButton1MouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (selectedTxt == null) {

        } else {
            enter = selectedTxt.getText();
            selectedTxt.setText(enter + "0");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseReleased
        if (!fAnswer.getText().equals("")) {
            BtnCheck.setEnabled(true);
        } else {
            BtnCheck.setEnabled(false);
        }

    }//GEN-LAST:event_jButton3MouseReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (selectedTxt == null) {

        } else {
            enter = selectedTxt.getText();
            selectedTxt.setText(enter + "1");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseReleased
        if (!fAnswer.getText().equals("")) {
            BtnCheck.setEnabled(true);
        } else {
            BtnCheck.setEnabled(false);
        }

    }//GEN-LAST:event_jButton4MouseReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        if (selectedTxt == null) {

        } else {
            enter = selectedTxt.getText();
            selectedTxt.setText(enter + "2");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseReleased
        if (!fAnswer.getText().equals("")) {
            BtnCheck.setEnabled(true);
        } else {
            BtnCheck.setEnabled(false);
        }

    }//GEN-LAST:event_jButton5MouseReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (selectedTxt == null) {

        } else {
            enter = selectedTxt.getText();
            selectedTxt.setText(enter + "3");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseReleased
        if (!fAnswer.getText().equals("")) {
            BtnCheck.setEnabled(true);
        } else {
            BtnCheck.setEnabled(false);
        }

    }//GEN-LAST:event_jButton7MouseReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (selectedTxt == null) {

        } else {
            enter = selectedTxt.getText();
            selectedTxt.setText(enter + "4");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseReleased
        if (!fAnswer.getText().equals("")) {
            BtnCheck.setEnabled(true);
        } else {
            BtnCheck.setEnabled(false);
        }

    }//GEN-LAST:event_jButton8MouseReleased

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (selectedTxt == null) {

        } else {
            enter = selectedTxt.getText();
            selectedTxt.setText(enter + "5");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseReleased
        if (!fAnswer.getText().equals("")) {
            BtnCheck.setEnabled(true);
        } else {
            BtnCheck.setEnabled(false);
        }

    }//GEN-LAST:event_jButton9MouseReleased

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (selectedTxt == null) {

        } else {
            enter = selectedTxt.getText();
            selectedTxt.setText(enter + "6");
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseReleased
        if (!fAnswer.getText().equals("")) {
            BtnCheck.setEnabled(true);
        } else {
            BtnCheck.setEnabled(false);
        }

    }//GEN-LAST:event_jButton10MouseReleased

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (selectedTxt == null) {

        } else {
            enter = selectedTxt.getText();
            selectedTxt.setText(enter + "7");
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseReleased
        if (!fAnswer.getText().equals("")) {
            BtnCheck.setEnabled(true);
        } else {
            BtnCheck.setEnabled(false);
        }

    }//GEN-LAST:event_jButton11MouseReleased

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if (selectedTxt == null) {

        } else {
            enter = selectedTxt.getText();
            selectedTxt.setText(enter + "8");
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseReleased
        if (!fAnswer.getText().equals("")) {
            BtnCheck.setEnabled(true);
        } else {
            BtnCheck.setEnabled(false);
        }

    }//GEN-LAST:event_jButton12MouseReleased

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if (selectedTxt == null) {

        } else {
            enter = selectedTxt.getText();
            selectedTxt.setText(enter + "9");
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void btn_reattemptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reattemptActionPerformed
        fullReset();
        btn_reattempt.setEnabled(false);
    }//GEN-LAST:event_btn_reattemptActionPerformed

    private void BtnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCheckActionPerformed

        complete = complete + 6;
        lblComplete2.setText("Completed - " + complete + " %");
        chack();

    }//GEN-LAST:event_BtnCheckActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        Main.ictHub ih = new Main.ictHub();
        ih.setId(idPas);
        ih.show();
        this.dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    private void fAnswerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fAnswerMouseClicked
        selectedTxt = fAnswer;

        if (selectedTxt.getText().equals("")) {

            dfault();
            selectLabal();
        } else {
            dfault();
            selectLabal();
            selectedTxt.setText("");
        }
    }//GEN-LAST:event_fAnswerMouseClicked

    private void fAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fAnswerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fAnswerActionPerformed

    private void fAnswerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fAnswerKeyReleased
        if (!fAnswer.getText().equals("")) {
            BtnCheck.setEnabled(true);
        } else {
            BtnCheck.setEnabled(false);
        }
    }//GEN-LAST:event_fAnswerKeyReleased

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        reset();
        qustions();
        dfault();
        btnNext.setEnabled(false);
        BtnCheck2.setEnabled(false);
    }//GEN-LAST:event_btnNextActionPerformed

    private void BtnCheck1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCheck1ActionPerformed
        BtnCheck2.setEnabled(true);
        BtnCheck1.setEnabled(false);
        BtnCheck.setEnabled(false);

        int a1 = 1 * Integer.valueOf(sq1.getText());
        int a2 = 2 * Integer.valueOf(sq2.getText());
        int a3 = 4 * Integer.valueOf(sq3.getText());
        int a4 = 8 * Integer.valueOf(sq4.getText());
        int a5 = 16 * Integer.valueOf(sq5.getText());
        int a6 = 32 * Integer.valueOf(sq6.getText());

        int fanswer = a1 + a2 + a3 + a4 + a5 + a6;
        jLabel18.setText(fanswer + "");

        if (fanswer >= 64) {
            jTextField4.setEnabled(true);
            jTextField3.setEnabled(true);
            jLabel20.setText("16");

            jTextField3.setVisible(true);
            jTextField4.setVisible(true);
            jSeparator9.setVisible(true);
        } else {
            jTextField4.setEnabled(false);
            jTextField3.setEnabled(false);
        }

    }//GEN-LAST:event_BtnCheck1ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        selectedTxt = jTextField1;
        if (selectedTxt.getText().equals("")) {

            dfault();
            selectLabal();
        } else {
            dfault();
            selectLabal();
            selectedTxt.setText("");
        }
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        selectedTxt = jTextField2;
        if (selectedTxt.getText().equals("")) {

            dfault();
            selectLabal();
        } else {
            dfault();
            selectLabal();
            selectedTxt.setText("");
        }
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked

    }//GEN-LAST:event_jTextField3MouseClicked

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        selectedTxt = jTextField3;
        if (selectedTxt.getText().equals("")) {

            dfault();
            selectLabal();
        } else {
            dfault();
            selectLabal();
            selectedTxt.setText("");
        }
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        selectedTxt = jTextField4;
        if (selectedTxt.getText().equals("")) {

            dfault();
            selectLabal();
        } else {
            dfault();
            selectLabal();
            selectedTxt.setText("");
        }
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void BtnCheck2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCheck2ActionPerformed

        if (jTextField1.getText().equals("") || jTextField2.getText().equals("") || ffAnswer.getText().equals("")) {

            lblerror.setVisible(true);
        } else {
            lblerror.setVisible(false);

            int fanswer = Integer.valueOf(jLabel18.getText());

            //first chack
            String devid = String.valueOf(fanswer / 16);
            String bln = String.valueOf(fanswer % 16);
            String finalAnswer = devid + bln;

            System.out.println(finalAnswer);
            if (jTextField1.getText().equals(devid)) {
                jTextField1.setBorder(BorderFactory.createLineBorder(Color.green));
            } else {
                jTextField1.setBorder(BorderFactory.createLineBorder(Color.red));
            }

            if (jTextField2.getText().equals(bln)) {
                jTextField2.setBorder(BorderFactory.createLineBorder(Color.green));
            } else {
                jTextField2.setBorder(BorderFactory.createLineBorder(Color.red));
            }

            if (ffAnswer.getText().equals(finalAnswer)) {
                ffAnswer.setBorder(BorderFactory.createLineBorder(Color.green));
                score = score + 4;
            } else {
                ffAnswer.setBorder(BorderFactory.createLineBorder(Color.red));

                health--;
                if (health == 3) {
                    health4.setVisible(false);
                } else if (health == 2) {
                    health3.setVisible(false);
                } else if (health == 1) {
                    health2.setVisible(false);
                } else if (health == 0) {
                    health1.setVisible(false);

                    btn_reattempt.setEnabled(true);
                    btnNext.setEnabled(false);
                    BtnCheck.setEnabled(false);
                    BtnCheck2.setEnabled(false);
                }
            }

        }

        //Second chack
        int fanswer = Integer.valueOf(jLabel18.getText());
        if (fanswer >= 64) {
            if (jTextField3.getText().equals("") || jTextField4.getText().equals("") || ffAnswer.getText().equals("")) {

                lblerror.setVisible(true);
            } else {

                lblerror.setVisible(false);

                int get2nd = Integer.valueOf(jTextField1.getText());
                int get1blnce = Integer.valueOf(jTextField2.getText());

                String secondDiv = String.valueOf(get2nd / 16);
                String secondBlnce = String.valueOf(get2nd % 16);
                String secondFinal = String.valueOf(secondDiv + secondBlnce + get1blnce);
                System.out.println(secondFinal);

                if (jTextField4.getText().equals(secondDiv)) {
                    jTextField4.setBorder(BorderFactory.createLineBorder(Color.green));
                } else {
                    jTextField4.setBorder(BorderFactory.createLineBorder(Color.red));
                }

                if (jTextField3.getText().equals(secondBlnce)) {
                    jTextField3.setBorder(BorderFactory.createLineBorder(Color.green));
                } else {
                    jTextField3.setBorder(BorderFactory.createLineBorder(Color.red));
                }

                if (ffAnswer.getText().equals(secondFinal)) {
                    ffAnswer.setBorder(BorderFactory.createLineBorder(Color.green));
                    score = score + 4;
                } else {
                    ffAnswer.setBorder(BorderFactory.createLineBorder(Color.red));

                    health--;
                    if (health == 3) {
                        health4.setVisible(false);
                    } else if (health == 2) {
                        health3.setVisible(false);
                    } else if (health == 1) {
                        health2.setVisible(false);
                    } else if (health == 0) {
                        health1.setVisible(false);

                        btn_reattempt.setEnabled(true);
                        btnNext.setEnabled(false);
                        BtnCheck.setEnabled(false);
                        BtnCheck2.setEnabled(false);
                    }
                }

            }

        }

        lblScore.setText(score + "");
        lblScoreSide2.setText("Score - " + score);

        insertToSql();
        btnNext.setEnabled(true);
        BtnCheck.setEnabled(false);

    }//GEN-LAST:event_BtnCheck2ActionPerformed

    private void ffAnswerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ffAnswerMouseClicked
        selectedTxt = ffAnswer;
        if (selectedTxt.getText().equals("")) {

            dfault();
            selectLabal();
        } else {
            dfault();
            selectLabal();
            selectedTxt.setText("");
        }
    }//GEN-LAST:event_ffAnswerMouseClicked

    private void ffAnswerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ffAnswerMouseReleased

    }//GEN-LAST:event_ffAnswerMouseReleased

    private void ffAnswerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ffAnswerKeyReleased

    }//GEN-LAST:event_ffAnswerKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ICT.NumberConvertions nc = new ICT.NumberConvertions();
        nc.setId(idPas);
        nc.show();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        ICT.base2intoBase8 nc = new ICT.base2intoBase8();
        nc.setId(idPas);
        nc.show();
        this.dispose();
    }//GEN-LAST:event_jButton13ActionPerformed

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
            java.util.logging.Logger.getLogger(base2intoBase16.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(base2intoBase16.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(base2intoBase16.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(base2intoBase16.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new base2intoBase16().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCheck;
    private javax.swing.JButton BtnCheck1;
    private javax.swing.JButton BtnCheck2;
    private javax.swing.JTextField ans1;
    private javax.swing.JTextField ans2;
    private javax.swing.JTextField ans3;
    private javax.swing.JTextField ans4;
    private javax.swing.JTextField ans5;
    private javax.swing.JTextField ans6;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_reattempt;
    private javax.swing.JTextField fAnswer;
    private javax.swing.JTextField ffAnswer;
    private javax.swing.JButton health1;
    private javax.swing.JButton health2;
    private javax.swing.JButton health3;
    private javax.swing.JButton health4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel lblComplete;
    private javax.swing.JLabel lblComplete1;
    private javax.swing.JLabel lblComplete2;
    private javax.swing.JLabel lblMainObject;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblScoreSide;
    private javax.swing.JLabel lblScoreSide1;
    private javax.swing.JLabel lblScoreSide2;
    private javax.swing.JLabel lblUname;
    private javax.swing.JLabel lblUserName10;
    private javax.swing.JLabel lblUserName11;
    private javax.swing.JLabel lblUserName9;
    private javax.swing.JLabel lblerror;
    private javax.swing.JTextField power1;
    private javax.swing.JTextField power2;
    private javax.swing.JTextField power3;
    private javax.swing.JTextField power4;
    private javax.swing.JTextField power5;
    private javax.swing.JTextField power6;
    private javax.swing.JLabel q1;
    private javax.swing.JLabel q2;
    private javax.swing.JLabel q3;
    private javax.swing.JLabel q4;
    private javax.swing.JLabel q5;
    private javax.swing.JLabel q6;
    private javax.swing.JLabel sq1;
    private javax.swing.JLabel sq2;
    private javax.swing.JLabel sq3;
    private javax.swing.JLabel sq4;
    private javax.swing.JLabel sq5;
    private javax.swing.JLabel sq6;
    // End of variables declaration//GEN-END:variables
}
