/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package OtherGames;

import Main.Deshbord;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author mmaam
 */
public class frmTicTacToe extends javax.swing.JFrame {

    /**
     * Creates new form frmTicTacToe
     */
    public frmTicTacToe() {
        initComponents();
        pnlGameBox.requestFocus();
        player1timer();

        // player1timerprgs();
    }
    
    String idPas = "";
    
    public void setId(String id) {
        // set user name
        idPas = id;
        try {
            Connection con = database.db.getConnection();
            String sql = "SELECT userName FROM smart_learning.register WHERE id=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String uName = rs.getString("userName");
                lblUname2.setText("Hi " + uName);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Deshbord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void playerWinChack() {
        int player1marks = Integer.valueOf(lblPlayer1Marks.getText());
        int player2marks = Integer.valueOf(lblPlayer2Marks.getText());

        if (player1marks == 100) {
            lblDisplay.setText("Player 1 is won the match");
            lblDisplay.setForeground(Color.red);

            pnlPlayer1.setBackground(Color.green);
            pnlPlayer2.setBackground(Color.red);
            lblPlayer2Logo.setForeground(Color.black);

            gameEnd();
        } else if (player2marks == 100) {
            lblDisplay.setText("Player 2 is won the match");
            lblDisplay.setForeground(Color.red);

            pnlPlayer2.setBackground(Color.green);
            pnlPlayer1.setBackground(Color.red);
            lblPlayer1Logo.setForeground(Color.black);

            gameEnd();
        }
    }

    public void gameCrash() {
        if (!(btnL1B1.getText() == "?"
                || btnL1B2.getText() == "?"
                || btnL1B3.getText() == "?"
                || btnL2B1.getText() == "?"
                || btnL2B2.getText() == "?"
                || btnL2B3.getText() == "?"
                || btnL3B1.getText() == "?"
                || btnL3B2.getText() == "?"
                || btnL3B3.getText() == "?")) {
            JOptionPane.showMessageDialog(rootPane, "Game crashed");
            resetGame();
        }
    }

    public void resetGame() {
        btnL1B1.setText("?");
        btnL1B2.setText("?");
        btnL1B3.setText("?");

        btnL2B1.setText("?");
        btnL2B2.setText("?");
        btnL2B3.setText("?");

        btnL3B1.setText("?");
        btnL3B2.setText("?");
        btnL3B3.setText("?");

        //enble btns
        btnL1B1.setEnabled(true);
        btnL1B2.setEnabled(true);
        btnL1B3.setEnabled(true);

        btnL2B1.setEnabled(true);
        btnL2B2.setEnabled(true);
        btnL2B3.setEnabled(true);

        btnL3B1.setEnabled(true);
        btnL3B2.setEnabled(true);
        btnL3B3.setEnabled(true);
        
        //set defoult borfer
        btnL1B1.setBorder(BorderFactory.createEmptyBorder());
        btnL1B2.setBorder(BorderFactory.createEmptyBorder());
        btnL1B3.setBorder(BorderFactory.createEmptyBorder());

        btnL2B1.setBorder(BorderFactory.createEmptyBorder());
        btnL2B2.setBorder(BorderFactory.createEmptyBorder());
        btnL2B3.setBorder(BorderFactory.createEmptyBorder());

        btnL3B1.setBorder(BorderFactory.createEmptyBorder());
        btnL3B2.setBorder(BorderFactory.createEmptyBorder());
        btnL3B3.setBorder(BorderFactory.createEmptyBorder());
    }

    public void gameEnd() {
        btnL1B1.setEnabled(false);
        btnL1B2.setEnabled(false);
        btnL1B3.setEnabled(false);

        btnL2B1.setEnabled(false);
        btnL2B2.setEnabled(false);
        btnL2B3.setEnabled(false);

        btnL3B1.setEnabled(false);
        btnL3B2.setEnabled(false);
        btnL3B3.setEnabled(false);
    }

// ========================= // Player 01 // ========================= //
    public void player1win() {
        if ( //Horizontal
                (btnL1B1.getText() == "X" && btnL1B2.getText() == "X" && btnL1B3.getText() == "X")
                || (btnL2B1.getText() == "X" && btnL2B2.getText() == "X" && btnL2B3.getText() == "X")
                || (btnL3B1.getText() == "X" && btnL3B2.getText() == "X" && btnL3B3.getText() == "X")
                || //Vertical
                (btnL1B1.getText() == "X" && btnL2B1.getText() == "X" && btnL3B1.getText() == "X")
                || (btnL1B2.getText() == "X" && btnL2B2.getText() == "X" && btnL3B2.getText() == "X")
                || (btnL1B3.getText() == "X" && btnL2B3.getText() == "X" && btnL3B3.getText() == "X")
                || //Cross
                (btnL1B1.getText() == "X" && btnL2B2.getText() == "X" && btnL3B3.getText() == "X")
                || (btnL1B3.getText() == "X" && btnL2B2.getText() == "X" && btnL3B1.getText() == "X")) {

            JOptionPane.showMessageDialog(rootPane, "Player one is won the match", "Win Message", 1);
            player1marks();
        }
    }

    public void player1marks() {
        int marks = Integer.valueOf(lblPlayer1Marks.getText());
        marks = marks + 20;
        lblPlayer1Marks.setText("" + marks);
        
        resetGame();
    }

  

    private Timer timerp1;

    public void player1timer() {
        timerp1 = new Timer(1000, new ActionListener() {
            int i = 10;

            @Override

            public void actionPerformed(ActionEvent e) {
                i--;
                lblPlayer1Timer.setText("" + i);

                if (i == 0) {

                    pnlPlayer1.setEnabled(false);
                    pnlPlayer2.setEnabled(true);
                    lblDisplay.setText("PLAYER 02 (O)");
                    lblDisplay.setForeground(Color.blue);

                    timerp1.stop();
                    player2timer();
                    lblPlayer1Timer.setText("10");
                }
            }

        });

        timerp1.start();
    }

    /*private Timer timerp1Prgs;

    public void player1timerprgs() {
        timerp1Prgs = new Timer(1000, new ActionListener() {
            int width = lblPlayer1TimerPrgs.getWidth();
            int height = lblPlayer1TimerPrgs.getHeight();
            int i = 10;

            @Override
            public void actionPerformed(ActionEvent e) {
                i--;
                if (width > 0) {
                    lblPlayer1TimerPrgs.setSize(width, height - 10);
                    System.out.println(i);
                }

            }
        });
        timerp1Prgs.start();
    }*/

// ========================= // Player 02 // ========================= //
    public void player2win() {
        if ( //Horizontal
                (btnL1B1.getText() == "O" && btnL1B2.getText() == "O" && btnL1B3.getText() == "O")
                || (btnL2B1.getText() == "O" && btnL2B2.getText() == "O" && btnL2B3.getText() == "O")
                || (btnL3B1.getText() == "O" && btnL3B2.getText() == "O" && btnL3B3.getText() == "O")
                || //Vertical
                (btnL1B1.getText() == "O" && btnL2B1.getText() == "O" && btnL3B1.getText() == "O")
                || (btnL1B2.getText() == "O" && btnL2B2.getText() == "O" && btnL3B2.getText() == "O")
                || (btnL1B3.getText() == "O" && btnL2B3.getText() == "O" && btnL3B3.getText() == "O")
                || //Cross
                (btnL1B1.getText() == "O" && btnL2B2.getText() == "O" && btnL3B3.getText() == "O")
                || (btnL1B3.getText() == "O" && btnL2B2.getText() == "O" && btnL3B1.getText() == "O")) {

            JOptionPane.showMessageDialog(rootPane, "Player two is won the match", "Win Message", 1);
            player2marks();
        }
    }

    public void player2marks() {
        int marks = Integer.valueOf(lblPlayer2Marks.getText());
        marks = marks + 20;
        lblPlayer2Marks.setText("" + marks);

        resetGame();
    }

    private Timer timerp2;

    public void player2timer() {
        timerp2 = new Timer(1000, new ActionListener() {
            int i = 10;

            @Override

            public void actionPerformed(ActionEvent e) {
                i--;
                lblPlayer2Timer.setText("" + i);

                if (i == 0) {

                    pnlPlayer2.setEnabled(false);
                    pnlPlayer1.setEnabled(true);
                    lblDisplay.setText("PLAYER 01 (X)");
                    lblDisplay.setForeground(Color.red);

                    timerp2.stop();
                    player1timer();
                    lblPlayer2Timer.setText("10");

                }
            }

        });

        timerp2.start();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBody = new javax.swing.JPanel();
        pnlGameBox = new javax.swing.JPanel();
        btnL1B1 = new javax.swing.JButton();
        btnL1B2 = new javax.swing.JButton();
        btnL1B3 = new javax.swing.JButton();
        btnL2B2 = new javax.swing.JButton();
        btnL2B3 = new javax.swing.JButton();
        btnL2B1 = new javax.swing.JButton();
        btnL3B2 = new javax.swing.JButton();
        btnL3B3 = new javax.swing.JButton();
        btnL3B1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblPlayer2Timer = new javax.swing.JLabel();
        lblPlayer2TimerPrgs = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblPlayer1Timer = new javax.swing.JLabel();
        lblPlayer1TimerPrgs = new javax.swing.JLabel();
        pnlPlayer1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblPlayer1Logo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblPlayer1Marks = new javax.swing.JLabel();
        pnlPlayer2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblPlayer2Logo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblPlayer2Marks = new javax.swing.JLabel();
        lblDisplay = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        lblUname2 = new javax.swing.JLabel();
        btnChack2 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBody.setBackground(new java.awt.Color(255, 255, 255));

        pnlGameBox.setBackground(new java.awt.Color(255, 255, 255));

        btnL1B1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btnL1B1.setText("?");
        btnL1B1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnL1B1ActionPerformed(evt);
            }
        });

        btnL1B2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btnL1B2.setText("?");
        btnL1B2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnL1B2ActionPerformed(evt);
            }
        });

        btnL1B3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btnL1B3.setText("?");
        btnL1B3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnL1B3ActionPerformed(evt);
            }
        });

        btnL2B2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btnL2B2.setText("?");
        btnL2B2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnL2B2ActionPerformed(evt);
            }
        });

        btnL2B3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btnL2B3.setText("?");
        btnL2B3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnL2B3ActionPerformed(evt);
            }
        });

        btnL2B1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btnL2B1.setText("?");
        btnL2B1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnL2B1ActionPerformed(evt);
            }
        });

        btnL3B2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btnL3B2.setText("?");
        btnL3B2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnL3B2ActionPerformed(evt);
            }
        });

        btnL3B3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btnL3B3.setText("?");
        btnL3B3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnL3B3ActionPerformed(evt);
            }
        });

        btnL3B1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btnL3B1.setText("?");
        btnL3B1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnL3B1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("TIMER");

        lblPlayer2Timer.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblPlayer2Timer.setForeground(new java.awt.Color(255, 51, 51));
        lblPlayer2Timer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayer2Timer.setText("10");

        lblPlayer2TimerPrgs.setBackground(new java.awt.Color(255, 51, 102));
        lblPlayer2TimerPrgs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayer2TimerPrgs.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPlayer2Timer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(lblPlayer2TimerPrgs, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPlayer2TimerPrgs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPlayer2Timer)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TIMER");

        lblPlayer1Timer.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblPlayer1Timer.setForeground(new java.awt.Color(255, 51, 51));
        lblPlayer1Timer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayer1Timer.setText("10");

        lblPlayer1TimerPrgs.setBackground(new java.awt.Color(255, 51, 102));
        lblPlayer1TimerPrgs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayer1TimerPrgs.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPlayer1Timer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(lblPlayer1TimerPrgs, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPlayer1TimerPrgs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPlayer1Timer)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlGameBoxLayout = new javax.swing.GroupLayout(pnlGameBox);
        pnlGameBox.setLayout(pnlGameBoxLayout);
        pnlGameBoxLayout.setHorizontalGroup(
            pnlGameBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGameBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGameBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGameBoxLayout.createSequentialGroup()
                        .addComponent(btnL1B1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnL1B2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnL1B3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlGameBoxLayout.createSequentialGroup()
                        .addComponent(btnL2B1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnL2B2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnL2B3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlGameBoxLayout.createSequentialGroup()
                        .addComponent(btnL3B1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnL3B2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnL3B3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlGameBoxLayout.setVerticalGroup(
            pnlGameBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGameBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGameBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlGameBoxLayout.createSequentialGroup()
                        .addGroup(pnlGameBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnL1B1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnL1B2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnL1B3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlGameBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnL2B1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnL2B2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnL2B3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlGameBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnL3B1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnL3B2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnL3B3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPlayer1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PLAYER 01");

        lblPlayer1Logo.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        lblPlayer1Logo.setForeground(new java.awt.Color(255, 51, 51));
        lblPlayer1Logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayer1Logo.setText("X");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MARKS");

        lblPlayer1Marks.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblPlayer1Marks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayer1Marks.setText("00");

        javax.swing.GroupLayout pnlPlayer1Layout = new javax.swing.GroupLayout(pnlPlayer1);
        pnlPlayer1.setLayout(pnlPlayer1Layout);
        pnlPlayer1Layout.setHorizontalGroup(
            pnlPlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlayer1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPlayer1Logo, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPlayer1Marks, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlPlayer1Layout.setVerticalGroup(
            pnlPlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlayer1Layout.createSequentialGroup()
                .addGroup(pnlPlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPlayer1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPlayer1Marks, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlPlayer1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lblPlayer1Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnlPlayer2.setBackground(new java.awt.Color(255, 204, 204));
        pnlPlayer2.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("PLAYER 02");

        lblPlayer2Logo.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        lblPlayer2Logo.setForeground(new java.awt.Color(51, 51, 255));
        lblPlayer2Logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayer2Logo.setText("O");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("MARKS");

        lblPlayer2Marks.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblPlayer2Marks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayer2Marks.setText("00");

        javax.swing.GroupLayout pnlPlayer2Layout = new javax.swing.GroupLayout(pnlPlayer2);
        pnlPlayer2.setLayout(pnlPlayer2Layout);
        pnlPlayer2Layout.setHorizontalGroup(
            pnlPlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlayer2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPlayer2Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlPlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPlayer2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                    .addGroup(pnlPlayer2Layout.createSequentialGroup()
                        .addGroup(pnlPlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPlayer2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblPlayer2Marks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlPlayer2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        pnlPlayer2Layout.setVerticalGroup(
            pnlPlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlayer2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlPlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPlayer2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPlayer2Marks)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(35, 35, 35))
                    .addGroup(pnlPlayer2Layout.createSequentialGroup()
                        .addComponent(lblPlayer2Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        lblDisplay.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblDisplay.setForeground(new java.awt.Color(255, 51, 51));
        lblDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDisplay.setText("PLAYER 01 (X)");

        javax.swing.GroupLayout pnlBodyLayout = new javax.swing.GroupLayout(pnlBody);
        pnlBody.setLayout(pnlBodyLayout);
        pnlBodyLayout.setHorizontalGroup(
            pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBodyLayout.createSequentialGroup()
                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlGameBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lblDisplay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlBodyLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBodyLayout.setVerticalGroup(
            pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlGameBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(208, 500));

        jButton7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(102, 102, 102));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profile.png"))); // NOI18N
        jButton7.setContentAreaFilled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        lblUname2.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        lblUname2.setForeground(new java.awt.Color(102, 102, 102));
        lblUname2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUname2.setText("Wlcome Admin");

        btnChack2.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnChack2.setForeground(new java.awt.Color(51, 51, 51));
        btnChack2.setText("Back");
        btnChack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChack2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblUname2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                            .addComponent(jSeparator4)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnChack2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator5))))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUname2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChack2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                    .addComponent(pnlBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnL1B1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnL1B1ActionPerformed
            // TODO add your handling code here:
        pnlGameBox.requestFocus();
        btnL1B1.setEnabled(false);

        if (!pnlPlayer2.isEnabled()) {
            btnL1B1.setText("X");
            btnL1B1.setBorder(BorderFactory.createLineBorder(Color.red, 4,true));

            pnlPlayer1.setEnabled(false);
            pnlPlayer2.setEnabled(true);
            lblDisplay.setText("PLAYER 02 (O)");
            lblDisplay.setForeground(Color.blue);
            player1win();
            player2timer();
            timerp1.stop();
            lblPlayer1Timer.setText("10");

        } else {
            btnL1B1.setText("O");
            btnL1B1.setBorder(BorderFactory.createLineBorder(Color.blue, 4,true));

            pnlPlayer2.setEnabled(false);
            pnlPlayer1.setEnabled(true);
            lblDisplay.setText("PLAYER 01 (X)");
            lblDisplay.setForeground(Color.red);
            player2win();
            player1timer();
            timerp2.stop();
            lblPlayer2Timer.setText("10");
        }
        gameCrash();
        playerWinChack();

    }//GEN-LAST:event_btnL1B1ActionPerformed

    private void btnL1B2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnL1B2ActionPerformed
        // TODO add your handling code here:
        pnlGameBox.requestFocus();
        btnL1B2.setEnabled(false);

        if (!pnlPlayer2.isEnabled()) {
            btnL1B2.setText("X");
            btnL1B2.setBorder(BorderFactory.createLineBorder(Color.red, 4,true));

            pnlPlayer1.setEnabled(false);
            pnlPlayer2.setEnabled(true);
            lblDisplay.setText("PLAYER 02 (O)");
            lblDisplay.setForeground(Color.blue);
            player1win();
            player2timer();
            timerp1.stop();
            lblPlayer1Timer.setText("10");
        } else {
            btnL1B2.setText("O");
            btnL1B2.setBorder(BorderFactory.createLineBorder(Color.blue, 4,true));

            pnlPlayer2.setEnabled(false);
            pnlPlayer1.setEnabled(true);
            lblDisplay.setText("PLAYER 01 (X)");
            lblDisplay.setForeground(Color.red);
            player2win();
            player1timer();
            timerp2.stop();
            lblPlayer2Timer.setText("10");
        }
        gameCrash();
        playerWinChack();

    }//GEN-LAST:event_btnL1B2ActionPerformed

    private void btnL1B3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnL1B3ActionPerformed
        // TODO add your handling code here:
        pnlGameBox.requestFocus();
        btnL1B3.setEnabled(false);

        if (!pnlPlayer2.isEnabled()) {
            btnL1B3.setText("X");
            btnL1B3.setBorder(BorderFactory.createLineBorder(Color.red, 4,true));

            pnlPlayer1.setEnabled(false);
            pnlPlayer2.setEnabled(true);
            lblDisplay.setText("PLAYER 02 (O)");
            lblDisplay.setForeground(Color.blue);
            player1win();
            player2timer();
            timerp1.stop();
            lblPlayer1Timer.setText("10");
        } else {
            btnL1B3.setText("O");
            btnL1B3.setBorder(BorderFactory.createLineBorder(Color.blue, 4,true));

            pnlPlayer2.setEnabled(false);
            pnlPlayer1.setEnabled(true);
            lblDisplay.setText("PLAYER 01 (X)");
            lblDisplay.setForeground(Color.red);
            player2win();
            player1timer();
            timerp2.stop();
            lblPlayer2Timer.setText("10");
        }
        gameCrash();
        playerWinChack();

    }//GEN-LAST:event_btnL1B3ActionPerformed

    private void btnL2B1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnL2B1ActionPerformed
        // TODO add your handling code here:
        pnlGameBox.requestFocus();
        btnL2B1.setEnabled(false);

        if (!pnlPlayer2.isEnabled()) {
            btnL2B1.setText("X");
            btnL2B1.setBorder(BorderFactory.createLineBorder(Color.red, 4,true));

            pnlPlayer1.setEnabled(false);
            pnlPlayer2.setEnabled(true);
            lblDisplay.setText("PLAYER 02 (O)");
            lblDisplay.setForeground(Color.blue);
            player1win();
            player2timer();
            timerp1.stop();
            lblPlayer1Timer.setText("10");
        } else {
            btnL2B1.setText("O");
            btnL2B1.setBorder(BorderFactory.createLineBorder(Color.blue, 4,true));

            pnlPlayer2.setEnabled(false);
            pnlPlayer1.setEnabled(true);
            lblDisplay.setText("PLAYER 01 (X)");
            lblDisplay.setForeground(Color.red);
            player2win();
            player1timer();
            timerp2.stop();
            lblPlayer2Timer.setText("10");
        }
        gameCrash();
        playerWinChack();

    }//GEN-LAST:event_btnL2B1ActionPerformed

    private void btnL2B2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnL2B2ActionPerformed
        // TODO add your handling code here:
        pnlGameBox.requestFocus();
        btnL2B2.setEnabled(false);

        if (!pnlPlayer2.isEnabled()) {
            btnL2B2.setText("X");
            btnL2B2.setBorder(BorderFactory.createLineBorder(Color.red, 4,true));

            pnlPlayer1.setEnabled(false);
            pnlPlayer2.setEnabled(true);
            lblDisplay.setText("PLAYER 02 (O)");
            lblDisplay.setForeground(Color.blue);
            player1win();
            player2timer();
            timerp1.stop();
            lblPlayer1Timer.setText("10");
        } else {
            btnL2B2.setText("O");
            btnL2B2.setBorder(BorderFactory.createLineBorder(Color.blue, 4,true));

            pnlPlayer2.setEnabled(false);
            pnlPlayer1.setEnabled(true);
            lblDisplay.setText("PLAYER 01 (X)");
            lblDisplay.setForeground(Color.red);
            player2win();
            player1timer();
            timerp2.stop();
            lblPlayer2Timer.setText("10");
        }
        gameCrash();
        playerWinChack();

    }//GEN-LAST:event_btnL2B2ActionPerformed

    private void btnL2B3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnL2B3ActionPerformed
        // TODO add your handling code here:
        pnlGameBox.requestFocus();
        btnL2B3.setEnabled(false);

        if (!pnlPlayer2.isEnabled()) {
            btnL2B3.setText("X");
            btnL2B3.setBorder(BorderFactory.createLineBorder(Color.red, 4,true));

            pnlPlayer1.setEnabled(false);
            pnlPlayer2.setEnabled(true);
            lblDisplay.setText("PLAYER 02 (O)");
            lblDisplay.setForeground(Color.blue);
            player1win();
            player2timer();
            timerp1.stop();
            lblPlayer1Timer.setText("10");
        } else {
            btnL2B3.setText("O");
            btnL2B3.setBorder(BorderFactory.createLineBorder(Color.blue, 4,true));

            pnlPlayer2.setEnabled(false);
            pnlPlayer1.setEnabled(true);
            lblDisplay.setText("PLAYER 01 (X)");
            lblDisplay.setForeground(Color.red);
            player2win();
            player1timer();
            timerp2.stop();
            lblPlayer2Timer.setText("10");
        }
        gameCrash();
        playerWinChack();

    }//GEN-LAST:event_btnL2B3ActionPerformed

    private void btnL3B1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnL3B1ActionPerformed
        // TODO add your handling code here:
        pnlGameBox.requestFocus();
        btnL3B1.setEnabled(false);

        if (!pnlPlayer2.isEnabled()) {
            btnL3B1.setText("X");
            btnL3B1.setBorder(BorderFactory.createLineBorder(Color.red, 4,true));

            pnlPlayer1.setEnabled(false);
            pnlPlayer2.setEnabled(true);
            lblDisplay.setText("PLAYER 02 (O)");
            lblDisplay.setForeground(Color.blue);
            player1win();
            player2timer();
            timerp1.stop();
            lblPlayer1Timer.setText("10");
        } else {
            btnL3B1.setText("O");
            btnL3B1.setBorder(BorderFactory.createLineBorder(Color.blue, 4,true));

            pnlPlayer2.setEnabled(false);
            pnlPlayer1.setEnabled(true);
            lblDisplay.setText("PLAYER 01 (X)");
            lblDisplay.setForeground(Color.red);
            player2win();
            player1timer();
            timerp2.stop();
            lblPlayer2Timer.setText("10");
        }
        gameCrash();
        playerWinChack();

    }//GEN-LAST:event_btnL3B1ActionPerformed

    private void btnL3B2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnL3B2ActionPerformed
        // TODO add your handling code here:
        pnlGameBox.requestFocus();
        btnL3B2.setEnabled(false);

        if (!pnlPlayer2.isEnabled()) {
            btnL3B2.setText("X");
            btnL3B2.setBorder(BorderFactory.createLineBorder(Color.red, 4,true));

            pnlPlayer1.setEnabled(false);
            pnlPlayer2.setEnabled(true);
            lblDisplay.setText("PLAYER 02 (O)");
            lblDisplay.setForeground(Color.blue);
            player1win();
            player2timer();
            timerp1.stop();
            lblPlayer1Timer.setText("10");
        } else {
            btnL3B2.setText("O");
            btnL3B2.setBorder(BorderFactory.createLineBorder(Color.blue, 4,true));

            pnlPlayer2.setEnabled(false);
            pnlPlayer1.setEnabled(true);
            lblDisplay.setText("PLAYER 01 (X)");
            lblDisplay.setForeground(Color.red);
            player2win();
            player1timer();
            timerp2.stop();
            lblPlayer2Timer.setText("10");
        }
        gameCrash();
        playerWinChack();

    }//GEN-LAST:event_btnL3B2ActionPerformed

    private void btnL3B3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnL3B3ActionPerformed
        // TODO add your handling code here:
        pnlGameBox.requestFocus();
        btnL3B3.setEnabled(false);

        if (!pnlPlayer2.isEnabled()) {
            btnL3B3.setText("X");
            btnL3B3.setBorder(BorderFactory.createLineBorder(Color.red, 4,true));

            pnlPlayer1.setEnabled(false);
            pnlPlayer2.setEnabled(true);
            lblDisplay.setText("PLAYER 02 (O)");
            lblDisplay.setForeground(Color.blue);
            player1win();
            player2timer();
            timerp1.stop();
            lblPlayer1Timer.setText("10");
        } else {
            btnL3B3.setText("O");
            btnL3B3.setBorder(BorderFactory.createLineBorder(Color.blue, 4,true));

            pnlPlayer2.setEnabled(false);
            pnlPlayer1.setEnabled(true);
            lblDisplay.setText("PLAYER 01 (X)");
            lblDisplay.setForeground(Color.red);
            player2win();
            player1timer();
            timerp2.stop();
            lblPlayer2Timer.setText("10");
        }
        gameCrash();
        playerWinChack();

    }//GEN-LAST:event_btnL3B3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnChack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChack2ActionPerformed
        Deshbord db = new Deshbord();
        db.setId(idPas);
        db.show();
        this.dispose();
    }//GEN-LAST:event_btnChack2ActionPerformed

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
            java.util.logging.Logger.getLogger(frmTicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmTicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmTicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmTicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmTicTacToe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChack2;
    private javax.swing.JButton btnL1B1;
    private javax.swing.JButton btnL1B2;
    private javax.swing.JButton btnL1B3;
    private javax.swing.JButton btnL2B1;
    private javax.swing.JButton btnL2B2;
    private javax.swing.JButton btnL2B3;
    private javax.swing.JButton btnL3B1;
    private javax.swing.JButton btnL3B2;
    private javax.swing.JButton btnL3B3;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblDisplay;
    private javax.swing.JLabel lblPlayer1Logo;
    private javax.swing.JLabel lblPlayer1Marks;
    private javax.swing.JLabel lblPlayer1Timer;
    private javax.swing.JLabel lblPlayer1TimerPrgs;
    private javax.swing.JLabel lblPlayer2Logo;
    private javax.swing.JLabel lblPlayer2Marks;
    private javax.swing.JLabel lblPlayer2Timer;
    private javax.swing.JLabel lblPlayer2TimerPrgs;
    private javax.swing.JLabel lblUname2;
    private javax.swing.JPanel pnlBody;
    private javax.swing.JPanel pnlGameBox;
    private javax.swing.JPanel pnlPlayer1;
    private javax.swing.JPanel pnlPlayer2;
    // End of variables declaration//GEN-END:variables
}
