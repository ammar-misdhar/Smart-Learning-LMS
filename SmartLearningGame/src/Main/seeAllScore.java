/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import Science.AcidOrBase;
import database.ttlDetails;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mmamm
 */
public class seeAllScore extends javax.swing.JFrame {

    /**
     * Creates new form seeAllScore
     */
    String idpas = "";

    int scienceTtlScore = 0;
    int scineceTtlComplete = 0;

    int ictTotal = 0;
    int ictTotalComplete = 0;

    public seeAllScore() {
        initComponents();
        loardData();
        tabaleDesign();
    }

    public void searchStudent(int searchType, String search) {

        try {
            int count = 0;
            String sql = "";
            Connection con = database.db.getConnection();

            if (searchType == 0) {
                sql = "SELECT id,userName,ttlComplete,ttlScore FROM smart_learning.register where id like '" + search + "%';";
            } else if (searchType == 1) {
                sql = "SELECT id,userName,ttlComplete,ttlScore FROM smart_learning.register where userName like '" + search + "%';";
            } 
            
            PreparedStatement st = con.prepareStatement(sql);
            //st.setString(1, search);
            ResultSet rs = st.executeQuery();
            DefaultTableModel tm = (DefaultTableModel) tblDetails.getModel();
            tm.setRowCount(0);
            while (rs.next()) {
                count++;
                String registerId = rs.getString("id");
                String username = rs.getString("userName");
                int ttlComplete = rs.getInt("ttlComplete");
                String ttlMarks = rs.getString("ttlScore");

                Vector rowData = new Vector<>();
                rowData.add(count);
                rowData.add(registerId);
                rowData.add(username);
                rowData.add("Completed : " + (ttlComplete / 8) + "%");
                rowData.add("Marks : " + ttlMarks);
                tm.addRow(rowData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(seeAllScore.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void tabaleDesign() {
        tblDetails.getTableHeader().setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
        tblDetails.getTableHeader().setForeground(new Color(255, 255, 255));
        tblDetails.getTableHeader().setBackground(new Color(102, 102, 102));
        tblDetails.getTableHeader().setOpaque(false);
        tblDetails.setFont(new Font("Poppins", Font.PLAIN, 13));
        tblDetails.setShowHorizontalLines(true);
        tblDetails.setShowVerticalLines(true);
        tblDetails.setRowHeight(25);

    }

    public void setData(String idti) {
        try {
            Connection con = database.db.getConnection();
            String sql = "SELECT id,firstName,lastName,userName,contact,Gender,ttlScore FROM smart_learning.register where id=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, idti);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String userName = rs.getString("userName");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String contact = rs.getString("contact");
                String Gender = rs.getString("Gender");
                String Score = rs.getString("ttlScore");

                if (Gender.equals("M")) {
                    lblGender.setText("Male");
                } else {
                    lblGender.setText("Female");
                }
                lblId.setText(id);
                lbluserName.setText(userName);
                lblUserName14.setText(userName + "'s Top Score");
                lblFirstName.setText(firstName);
                lblLastName.setText(lastName);
                lblContect.setText(contact);
                lblscore.setText(Score);
            }
        } catch (SQLException ex) {
            Logger.getLogger(seeAllScore.class.getName()).log(Level.SEVERE, null, ex);
        }

        //ICT
        try {
            Connection con = database.db.getConnection();
            String sql = "SELECT stRegId,(fillTheBlankScore+MCQscore+computerPartsScore) FROM smart_learning.ict where stRegId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, idti);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ictTotal = rs.getInt("(fillTheBlankScore+MCQscore+computerPartsScore)");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ttlDetails.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Connection con = database.db.getConnection();
            String sql = "SELECT stRegId,(fillTheBlankComplete+MCQcomplete+computerPartsComplete) FROM smart_learning.ict where stRegId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, idti);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ictTotalComplete = rs.getInt("(fillTheBlankComplete+MCQcomplete+computerPartsComplete)");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ttlDetails.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Science
        try {
            Connection con = database.db.getConnection();
            String sql = "SELECT stRegId,(ElectronicConScore+HumanHeartScore+DoublBloodCirculationScore+BaseOrAsidScore+electricHouseGridScore) FROM smart_learning.science where stRegId=? ;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, idti);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                scienceTtlScore = rs.getInt("(ElectronicConScore+HumanHeartScore+DoublBloodCirculationScore+BaseOrAsidScore+electricHouseGridScore)");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ttlDetails.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Connection con = database.db.getConnection();
            String sql = "SELECT stRegId,(HumanHeartCoplete+DoublBloodCirculationCoplete+ElectronicConCoplete+BaseOrAsidComplete+electricHouseGridComplete) FROM smart_learning.science where stRegId=? ;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, idti);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                scineceTtlComplete = rs.getInt("(HumanHeartCoplete+DoublBloodCirculationCoplete+ElectronicConCoplete+BaseOrAsidComplete+electricHouseGridComplete)");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ttlDetails.class.getName()).log(Level.SEVERE, null, ex);
        }

        int fScienceComplete = scineceTtlComplete / 6;
        lblScienceComplete.setText("Completed - " + fScienceComplete + "%");
        lblScienceScore.setText("Score - " + scienceTtlScore);

        int fIctCoplete = ictTotalComplete / 3;
        ictTtlComplete.setText("Completed - " + fIctCoplete + "%");
        ictTtlScor.setText("Score - " + ictTotal);

    }

    public void setID(String id) {

        idpas = id;
        try {
            Connection con = database.db.getConnection();
            String sql = "SELECT userName ,ttlScore FROM smart_learning.register WHERE id=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String uName = rs.getString("userName");
                String score = rs.getString("ttlScore");
                lbluName.setText("Hi " + uName);
                lblMyScore.setText(score);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Deshbord.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loardData() {
        int count = 1;
        try {

            Connection con = database.db.getConnection();
            String sql = "SELECT id,userName,ttlComplete,ttlScore FROM smart_learning.register;";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            DefaultTableModel tm = (DefaultTableModel) tblDetails.getModel();
            tm.setRowCount(0);
            while (rs.next()) {
                String id = rs.getString("id");
                String userName = rs.getString("userName");
                int ttlComplete = rs.getInt("ttlComplete");
                String ttlScore = rs.getString("ttlScore");

                Vector rowData = new Vector();
                rowData.add(count);
                rowData.add(id);
                rowData.add(userName);
                rowData.add("Completed : " + (ttlComplete / 8) + "%");
                rowData.add("Marks : " + ttlScore);

                tm.addRow(rowData);
                count++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(seeAllScore.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetails = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        lblContect = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        lblUserName10 = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JSeparator();
        lblScienceComplete = new javax.swing.JLabel();
        lblScienceScore = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        lblUserName11 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        lblScienceComplete1 = new javax.swing.JLabel();
        lblScienceScore1 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        lblUserName12 = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JSeparator();
        ictTtlComplete = new javax.swing.JLabel();
        ictTtlScor = new javax.swing.JLabel();
        lbluserName = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        lblUserName13 = new javax.swing.JLabel();
        jSeparator18 = new javax.swing.JSeparator();
        lblMyScore = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        lblUserName14 = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JSeparator();
        lblscore = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbluName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Number", "Admition Number", "User Name", "Complete", "Marks"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDetails);

        jComboBox1.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Register ID", "User Name" }));

        jTextField1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(51, 51, 51));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 892, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel1.setText("First Name");

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel3.setText("Last Name");

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel4.setText("Contect");

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel5.setText("Id");

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel6.setText("Gender");

        lblId.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblId.setText("XXXX");
        lblId.setOpaque(true);

        lblGender.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblGender.setText("XXXX");
        lblGender.setOpaque(true);

        lblLastName.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblLastName.setText("XXXX");
        lblLastName.setOpaque(true);

        lblFirstName.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblFirstName.setText("XXXX");
        lblFirstName.setOpaque(true);

        lblContect.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lblContect.setText("XXXX");
        lblContect.setOpaque(true);

        jPanel14.setBackground(new java.awt.Color(247, 247, 247));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        jPanel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel14.setEnabled(false);

        lblUserName10.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        lblUserName10.setForeground(new java.awt.Color(51, 51, 51));
        lblUserName10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserName10.setText("Science");

        lblScienceComplete.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        lblScienceComplete.setForeground(new java.awt.Color(51, 51, 51));
        lblScienceComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScienceComplete.setText("Completed - 0%");

        lblScienceScore.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        lblScienceScore.setForeground(new java.awt.Color(51, 51, 51));
        lblScienceScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScienceScore.setText("Score - 000");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserName10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblScienceScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblScienceComplete, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(jSeparator15))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblUserName10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblScienceComplete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblScienceScore)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(247, 247, 247));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        jPanel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel15.setEnabled(false);

        lblUserName11.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        lblUserName11.setForeground(new java.awt.Color(51, 51, 51));
        lblUserName11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserName11.setText("Maths");

        lblScienceComplete1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        lblScienceComplete1.setForeground(new java.awt.Color(51, 51, 51));
        lblScienceComplete1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScienceComplete1.setText("Completed - 0%");

        lblScienceScore1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        lblScienceScore1.setForeground(new java.awt.Color(51, 51, 51));
        lblScienceScore1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScienceScore1.setText("Score - 000");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserName11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblScienceScore1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblScienceComplete1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(jSeparator16))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblUserName11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblScienceComplete1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblScienceScore1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(247, 247, 247));
        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        jPanel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel16.setEnabled(false);

        lblUserName12.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        lblUserName12.setForeground(new java.awt.Color(51, 51, 51));
        lblUserName12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserName12.setText("ICT");

        ictTtlComplete.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        ictTtlComplete.setForeground(new java.awt.Color(51, 51, 51));
        ictTtlComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ictTtlComplete.setText("Completed - 0%");

        ictTtlScor.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        ictTtlScor.setForeground(new java.awt.Color(51, 51, 51));
        ictTtlScor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ictTtlScor.setText("Score - 000");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserName12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ictTtlScor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ictTtlComplete, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(jSeparator17))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblUserName12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ictTtlComplete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ictTtlScor)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        lbluserName.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        lbluserName.setText("XXXX");
        lbluserName.setOpaque(true);

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel7.setText("User Name");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblGender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(lblContect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbluserName, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(lblLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(lblLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lblContect, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbluserName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel17.setBackground(new java.awt.Color(247, 247, 247));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        jPanel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel17.setEnabled(false);

        lblUserName13.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        lblUserName13.setForeground(new java.awt.Color(51, 51, 51));
        lblUserName13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserName13.setText("Your Top Score");

        lblMyScore.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblMyScore.setForeground(new java.awt.Color(51, 51, 51));
        lblMyScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMyScore.setText("250");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserName13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMyScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator18))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblUserName13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMyScore, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel18.setBackground(new java.awt.Color(247, 247, 247));
        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        jPanel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel18.setEnabled(false);

        lblUserName14.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        lblUserName14.setForeground(new java.awt.Color(51, 51, 51));
        lblUserName14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserName14.setText("User");

        lblscore.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblscore.setForeground(new java.awt.Color(51, 51, 51));
        lblscore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblscore.setText("XXXX");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserName14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblscore, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(jSeparator19))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblUserName14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblscore, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Poppins Medium", 0, 15)); // NOI18N
        jLabel2.setText("Welcome Back !");

        lbluName.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lbluName.setForeground(new java.awt.Color(102, 102, 102));
        lbluName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbluName.setText("Welcome Admin ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbluName, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(lbluName)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTextField1.setText("");
        loardData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetailsMouseClicked
        int row = tblDetails.getSelectedRow();
        String id = tblDetails.getModel().getValueAt(row, 1).toString();

        setData(id);
    }//GEN-LAST:event_tblDetailsMouseClicked

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        int searchType =jComboBox1.getSelectedIndex();
        String search = jTextField1.getText();
        searchStudent(searchType, search);
    }//GEN-LAST:event_jTextField1KeyReleased

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
            java.util.logging.Logger.getLogger(seeAllScore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(seeAllScore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(seeAllScore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(seeAllScore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new seeAllScore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ictTtlComplete;
    private javax.swing.JLabel ictTtlScor;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblContect;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblMyScore;
    private javax.swing.JLabel lblScienceComplete;
    private javax.swing.JLabel lblScienceComplete1;
    private javax.swing.JLabel lblScienceScore;
    private javax.swing.JLabel lblScienceScore1;
    private javax.swing.JLabel lblUserName10;
    private javax.swing.JLabel lblUserName11;
    private javax.swing.JLabel lblUserName12;
    private javax.swing.JLabel lblUserName13;
    private javax.swing.JLabel lblUserName14;
    private javax.swing.JLabel lblscore;
    private javax.swing.JLabel lbluName;
    private javax.swing.JLabel lbluserName;
    private javax.swing.JTable tblDetails;
    // End of variables declaration//GEN-END:variables
}
