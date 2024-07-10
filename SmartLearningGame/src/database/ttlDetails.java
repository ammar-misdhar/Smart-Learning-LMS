/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mmamm
 */
public class ttlDetails {

    int scienceTtlScore = 0;
    int scineceTtlComplete = 0;

    int ictTtlScore = 0;
    int ictTtlComplete = 0;

    int mathTtlScore = 0;
    int mathTtlComplete = 0;

    int fullTtlScore = 0;
    int fullTtlComplete = 0;

    public void setTtl(String id) {

        sciencettl(id);
        ictttl(id);
        mathsTtl(id);
        fullTtlScore = scienceTtlScore + ictTtlScore + mathTtlScore;
        fullTtlComplete = scineceTtlComplete + ictTtlComplete + mathTtlComplete;

        setRegisterFrm(id);
    }

    public void sciencettl(String id) {

        try {
            Connection con = database.db.getConnection();
            String sql = "SELECT stRegId,(ElectronicConScore+HumanHeartScore+DoublBloodCirculationScore+BaseOrAsidScore+electricHouseGridScore) FROM smart_learning.science where stRegId=? ;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, id);

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
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                scineceTtlComplete = rs.getInt("(HumanHeartCoplete+DoublBloodCirculationCoplete+ElectronicConCoplete+BaseOrAsidComplete+electricHouseGridComplete)");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ttlDetails.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void ictttl(String id) {
        try {
            Connection con = database.db.getConnection();
            String sql = "SELECT stRegId,(fillTheBlankScore+MCQscore+computerPartsScore+base2intoBase10Score+base2intoBase8Score+base2intoBase16Score) FROM smart_learning.ict where stRegId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, id);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ictTtlScore = rs.getInt("(fillTheBlankScore+MCQscore+computerPartsScore+base2intoBase10Score+base2intoBase8Score+base2intoBase16Score)");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ttlDetails.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Connection con = database.db.getConnection();
            String sql = "SELECT stRegId,(fillTheBlankComplete+MCQcomplete+computerPartsComplete+base2intoBase10Complete+base2intoBase8Complete+base2intoBase16Complete) FROM smart_learning.ict where stRegId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ictTtlComplete = rs.getInt("(fillTheBlankComplete+MCQcomplete+computerPartsComplete+base2intoBase10Complete+base2intoBase8Complete+base2intoBase16Complete)");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ttlDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mathsTtl(String id) {
        try {
            Connection con = database.db.getConnection();
            String sql = "SELECT mathsScore+roundScore+roundAreaScore+roundLeanthArcScore+trangleAngleScore+trangleSideScore FROM smart_learning.maths where stRegId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, id);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                mathTtlScore = rs.getInt("mathsScore+roundScore+roundAreaScore+roundLeanthArcScore+trangleAngleScore+trangleSideScore");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ttlDetails.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Connection con = database.db.getConnection();
            String sql = "SELECT mathsComplete+roundComplete+roundAreaComplete+roundLeanthArcComplete+trangleAngleComplete+trangleSideComplete FROM smart_learning.maths where stRegId=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                mathTtlComplete = rs.getInt("mathsComplete+roundComplete+roundAreaComplete+roundLeanthArcComplete+trangleAngleComplete+trangleSideComplete");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ttlDetails.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setRegisterFrm(String id) {

        try {
            // create connection to database
            Connection con = database.db.getConnection();
            // Create prepared statement with the sql query
            PreparedStatement st1 = con.prepareStatement("UPDATE `smart_learning`.`register` SET `ttlScore` = '" + fullTtlScore + "', `ttlComplete` = '" + fullTtlComplete + "' WHERE (`id` = '" + id + "');");
            // execute query

            st1.executeUpdate();

            // show success message
        } catch (SQLException ex) {
            Logger.getLogger(ttlDetails.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
