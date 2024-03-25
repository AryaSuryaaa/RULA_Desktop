    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rulav3;

import Database.Database;
import GUI_Custom.ScrollBarCustom;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author surya
 */
public class MainBoard extends javax.swing.JFrame {

    // Set Database
    Connection con =null;
    Statement st = null;
    
    // variable sendToDatabase
    int finalSisiBadan = 0;
    int lenganAtasDb = 0;
    int lenganAtasSecDb = 0;
    int finalLenganAtas = 0;
    int lenganBawahDb = 0;
    int lenganBawahSecDb = 0;
    int finalLenganBawah = 0;
    int pergelanganTanganDb = 0;
    int pergelanganTanganSecDb = 0;
    int finalPergelanganTangan = 0;
    int finalPutarPergelanganTanganDb = 0;
    int tambahanDataDb = 0;
    int tambahanDataSecDb = 0;
    int finalTambahanData = 0;
    int leherDb = 0;
    int leherSecDb = 0;
    int finalLeher = 0;
    int badanDb = 0;
    int badanSecDb = 0;
    int finalBadan = 0;
    int finalKakiDb = 0;
    int tambahanData2Db = 0;
    int tambahanDataSec2Db = 0;
    int finalTambahanData2 = 0;
    
    // Result
    int scoreA = 0;
    int finalScoreA = 0;
    int scoreB = 0;
    int finalScoreB = 0;
    int scoreC = 0;
    int kerentanan = 0;
    String finalScoreC = "Hasil C";
    
    // add data pnael
    int LA1 = 0;
    int LA2 = 0;
    int LA3 = 0;
    int LB1 = 0;
    int PT1 = 0;
    int OP1 = 0;
    int LH1 = 0;
    int LH2 = 0;
    int BD1 = 0;
    int BD2 = 0;
    int OP2 = 0;
    
    // database yang dipilih
    String databaseClick = "0";
    
    
    
    
    
    /**
     * Creates new form MainBoard
     */
    public MainBoard() {
        
        initComponents();
        
        panelData.setVisible(false);
        panelNextBtn1.setVisible(false);
        updateButtonNext();
        
    }
    
    public void sendToDatabase(){
        
        // sisi Badan
        if(btnArahKiri.isSelected()) {
            finalSisiBadan += 1;
        } else {
            finalSisiBadan += 2;
        }
        
        System.out.println("Sisi Badan = " + finalSisiBadan);
        
        // Lengan Atas
        if (btnLA6.isSelected()) {
            lenganAtasDb += 1;
        } else if (btnLA7.isSelected() || btnLA8.isSelected()) {
            lenganAtasDb += 2;
        } else if (btnLA9.isSelected()) {
            lenganAtasDb += 3;
        } else {
            lenganAtasDb += 4;
        } 
        
        if (secDataLA1.isSelected()) {
            lenganAtasSecDb += 1;
            LA1 = 1;
        }
        if (secDataLA2.isSelected()) {
            lenganAtasSecDb += 1;
            LA2 = 1;
        }
        if (secDataLA3.isSelected()) {
            lenganAtasSecDb += -1;
            LA3 = 1;
        }    
                
        this.finalLenganAtas = lenganAtasDb + lenganAtasSecDb;
        System.out.println("Lengan atas = " + lenganAtasDb + " dan " + lenganAtasSecDb + " final " + finalLenganAtas);
                        
        // Lengan Bawah              
        if (btnLB1.isSelected()) {
            lenganBawahDb = 1;
        }  else  {
            lenganBawahDb = 2;
        }
                        
        if (secDataLB.isSelected()){
            lenganBawahSecDb = 1;
            LB1 = 1;
        }
                      
        this.finalLenganBawah = lenganBawahDb + lenganBawahSecDb;
        System.out.println("Lengan Bawah = " + lenganBawahDb + " dan " + lenganBawahSecDb + " final " + finalLenganBawah);
        
        // Pergelangan Tangan               
        if (btnPT1.isSelected()) {
            pergelanganTanganDb = 1;
        } else if (btnPT2.isSelected()) {
            pergelanganTanganDb = 2;
        } else {
            pergelanganTanganDb = 3;
        }
                       
        if (secDataPT.isSelected()){
            pergelanganTanganSecDb = 1;
            PT1 = 1;
        }
                
        this.finalPergelanganTangan = pergelanganTanganDb + pergelanganTanganSecDb;
        System.out.println("Pergelangan Tangan = " + pergelanganTanganDb + " dan " + pergelanganTanganSecDb + " final " + finalPergelanganTangan);
        
        // Putar Pergelangan Tangan       
        if (btnPPT1.isSelected()) {
            finalPutarPergelanganTanganDb = 1;
        } else {
            finalPutarPergelanganTanganDb = 2;
        } 
        
        System.out.println("Putar Pergelangan Tangan = " + finalPutarPergelanganTanganDb );
        
        // Tambahan data 1             
        if (tambahanData1.isSelected()) {
            tambahanDataDb = 0;
        } else if (tambahanData2.isSelected()) {
            tambahanDataDb = 1;
        } else if (tambahanData3.isSelected()) {
            tambahanDataDb = 2;
        } else {
            tambahanDataDb = 3;
        }
        if (tambahanData5.isSelected()){
            tambahanDataSecDb += 2;
            OP1 = 1;
        }
        
        this.finalTambahanData = tambahanDataDb + tambahanDataSecDb;
        System.out.println("Tambahan Data 1 = " + tambahanDataDb + " dan " + tambahanDataSecDb + " final " + finalTambahanData);
        
        // Leher        
        if (btnL1.isSelected()) {
            leherDb = 1;
        } else if (btnL2.isSelected()) {
            leherDb = 2;
        } else if (btnL3.isSelected()) {
            leherDb = 3;
        } else {
            leherDb = 4;
        }
        if (secDataL1.isSelected()){
            leherSecDb += 1;
            LH1 = 1;
        } 
        if (secDataL2.isSelected()){
            leherSecDb += 1;
            LH2 = 1;
        }
            
        this.finalLeher = leherDb + leherSecDb;
        System.out.println("Leher = " + leherDb + " dan " + leherSecDb + " final " + finalLeher);
        
        // Badan                
        if (btnB1.isSelected()) {
            badanDb = 1;
        } else if (btnB2.isSelected()) {
            badanDb = 2;
        } else if (btnB3.isSelected()) {
            badanDb = 3;
        } else  {
            badanDb = 4;
        }
        if (secDataB1.isSelected()){
            badanSecDb += 1;
            BD1 = 1;
        } 
        if (secDataB2.isSelected()){
            badanSecDb += 1;
            BD2 = 1;
        }
                
        this.finalBadan = badanDb + badanSecDb;
        System.out.println("Badan = " + badanDb + " dan " + badanSecDb + " final " + finalBadan);
        
        // Kaki               
        if (btnK1.isSelected()) {
            finalKakiDb = 1;
        } else {
            finalKakiDb = 2;
        }
        System.out.println("Kaki = " + finalKakiDb);
        
        // Tambahan data 2             
        if (tambahanData21.isSelected()) {
            tambahanData2Db = 0;
        } else if (tambahanData21.isSelected()) {
            tambahanData2Db = 1;
        } else if (tambahanData23.isSelected()) {
            tambahanData2Db = 2;
        } else {
            tambahanData2Db = 3;
        }
        if (tambahanData25.isSelected()){
            tambahanDataSec2Db += 2;
            OP2 = 1;
        }
        
        this.finalTambahanData2 = tambahanData2Db + tambahanDataSec2Db;
        System.out.println("Tambahan Data 2 = " + tambahanData2Db + " dan " + tambahanDataSec2Db + " final " + finalTambahanData2);
        
        result();
        
        try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/db_rula", "root" ,"");
                st=con.createStatement();
                
                // Untuk menyimpan ke database
                String simpanData = "INSERT INTO t_data VALUES ('" + nik.getText() + "','" + nama.getText() + "','" + umur.getText() + "','" 
                            + jenisKelamin.getSelectedItem() + "','" + alamat.getText() + "','" + nomorTelephone.getText() + "','" 
                            + pekerjaan.getText() + "','" + lamaBekerja.getText() + "','" + durasiBekerja.getText() + 
                    "','" + jenisKerja.getSelectedItem() + "','" + keluhan.getText()+ "'," + finalSisiBadan + "," + finalLenganAtas + "," + finalLenganBawah  + "," 
                    + finalPergelanganTangan + "," + finalPutarPergelanganTanganDb  + "," + finalTambahanData  + "," + finalLeher  + "," + finalBadan 
                    + "," + finalKakiDb + ",'" + finalTambahanData2 + "'," + finalScoreA + "," + finalScoreB + "," + scoreC + "," + kerentanan + ",'" + finalScoreC + "')";

                String simpanShow = "INSERT INTO t_show VALUES ('" + nik.getText() + "','" + nama.getText() + "','" + umur.getText() + "','" 
                    + jenisKelamin.getSelectedItem() + "','" + pekerjaan.getText() + "','" + finalScoreC + "')";

                String simpanAddDataPanel = "INSERT INTO t_add VALUES ('" + nik.getText() + "'," + LA1 + "," + LA2 
                    + "," + LA3 + "," + LB1 + "," + PT1 + "," + OP1 + "," + LH1 + "," + LH2 + "," + BD1 + "," 
                    + BD2 + "," + OP2  + ")";


                

                int SD = st.executeUpdate(simpanData);
                int SH = st.executeUpdate(simpanShow);
                int SAD = st.executeUpdate(simpanAddDataPanel);
                JOptionPane.showMessageDialog(null, "Data Berhasil Tersimpan");
                              
            
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            // Jika ada primary key yang sama
            JOptionPane.showMessageDialog(this, "Primary key sama", "Pesan",
            JOptionPane.WARNING_MESSAGE);
            System.out.println(e);
        }
    }
    
    
    
    public void result() {
        // SCORE A ===========================================
        // Upper Arm 1
        // twist 1
        if(this.finalLenganAtas == 1 && this.finalLenganBawah == 1 && this.finalPergelanganTangan == 1 && this.finalPutarPergelanganTanganDb == 1) {
            this.scoreA = 1;
        } else if(this.finalLenganAtas == 1 && !( this.finalLenganBawah == 1 ) && this.finalPergelanganTangan == 1 && this.finalPutarPergelanganTanganDb == 1) {
            this.scoreA = 2;
        } else if(this.finalLenganAtas == 1 && this.finalLenganBawah == 3 && this.finalPergelanganTangan == 1 && this.finalPutarPergelanganTanganDb == 2) {
            this.scoreA = 3;
        } else if(this.finalLenganAtas == 1 && !(this.finalLenganBawah == 3) && this.finalPergelanganTangan == 1 && this.finalPutarPergelanganTanganDb == 2) {
            this.scoreA = 2;
        } 
        // twist 2
        else if(this.finalLenganAtas == 1 && this.finalLenganBawah == 3 && this.finalPergelanganTangan == 2 && !(this.finalPutarPergelanganTanganDb == 0)) {
            this.scoreA = 3;
        } else if(this.finalLenganAtas == 1 && !(this.finalLenganBawah == 3) && this.finalPergelanganTangan == 2 && !(this.finalPutarPergelanganTanganDb == 0)) {
            this.scoreA = 2;
        } 
        // twist 3
        else if(this.finalLenganAtas == 1 && this.finalLenganBawah == 1 && this.finalPergelanganTangan == 3 && this.finalPutarPergelanganTanganDb == 1) {
            this.scoreA = 3;
        } else if(this.finalLenganAtas == 1 && !(this.finalLenganBawah == 1) && this.finalPergelanganTangan == 3 && this.finalPutarPergelanganTanganDb == 1) {
            this.scoreA = 3;
        } 
        // twist 4
        else if(this.finalLenganAtas == 1 && !(this.finalLenganBawah == 3) && this.finalPergelanganTangan == 4 && !(this.finalPutarPergelanganTanganDb == 0)) {
            this.scoreA = 3;
        } else if(this.finalLenganAtas == 1 && this.finalLenganBawah == 3 && this.finalPergelanganTangan == 4 && !(this.finalPutarPergelanganTanganDb == 0)) {
            this.scoreA = 4;
        } 
        
        // Upper Arm 2
        // twist 1
        else if(this.finalLenganAtas == 2 && this.finalLenganBawah == 1 && this.finalPergelanganTangan == 1 && this.finalPutarPergelanganTanganDb == 1) {
            this.scoreA = 2;
        } else if(this.finalLenganAtas == 2 && !( this.finalLenganBawah == 1 ) && this.finalPergelanganTangan == 1 && this.finalPutarPergelanganTanganDb == 1) {
            this.scoreA = 3;
        } else if(this.finalLenganAtas == 2 && this.finalLenganBawah == 3 && this.finalPergelanganTangan == 1 && this.finalPutarPergelanganTanganDb == 2) {
            this.scoreA = 4;
        } else if(this.finalLenganAtas == 2 && !(this.finalLenganBawah == 3) && this.finalPergelanganTangan == 1 && this.finalPutarPergelanganTanganDb == 2) {
            this.scoreA = 3;
        } 
        // twist 2
        else if(this.finalLenganAtas == 2 && this.finalLenganBawah == 3 && this.finalPergelanganTangan == 2 && !(this.finalPutarPergelanganTanganDb == 0)) {
            this.scoreA = 4;
        } else if(this.finalLenganAtas == 2 && !(this.finalLenganBawah == 3) && this.finalPergelanganTangan == 2 && !(this.finalPutarPergelanganTanganDb == 0)) {
            this.scoreA = 3;
        } 
        // twist 3
        else if(this.finalLenganAtas == 2 && this.finalLenganBawah == 3 && this.finalPergelanganTangan == 3 && this.finalPutarPergelanganTanganDb == 1) {
            this.scoreA = 4;
        } else if(this.finalLenganAtas == 2 && !(this.finalLenganBawah == 3) && this.finalPergelanganTangan == 3 && this.finalPutarPergelanganTanganDb == 1) {
            this.scoreA = 3;
        } else if(this.finalLenganAtas == 2 && !(this.finalLenganBawah == 0) && this.finalPergelanganTangan == 3 && this.finalPutarPergelanganTanganDb == 2) {
            this.scoreA = 4;
        } 
        // twist 4
        else if(this.finalLenganAtas == 2 && !(this.finalLenganBawah == 3) && this.finalPergelanganTangan == 4 && !(this.finalPutarPergelanganTanganDb == 0)) {
            this.scoreA = 4;
        } else if(this.finalLenganAtas == 2 && this.finalLenganBawah == 3 && this.finalPergelanganTangan == 4 && !(this.finalPutarPergelanganTanganDb == 0)) {
            this.scoreA = 5;
        } 
        
        // Upper Arm 3
        // twist 1
        else if(this.finalLenganAtas == 3 && this.finalLenganBawah == 3 && this.finalPergelanganTangan == 1 && this.finalPutarPergelanganTanganDb == 1) {
            this.scoreA = 4;
        } else if(this.finalLenganAtas == 3 && !( this.finalLenganBawah == 3 ) && this.finalPergelanganTangan == 1 && this.finalPutarPergelanganTanganDb == 1) {
            this.scoreA = 3;
        } else if(this.finalLenganAtas == 3 && this.finalLenganBawah == 1 && this.finalPergelanganTangan == 1 && this.finalPutarPergelanganTanganDb == 2) {
            this.scoreA = 3;
        } else if(this.finalLenganAtas == 3 && !(this.finalLenganBawah == 1) && this.finalPergelanganTangan == 1 && this.finalPutarPergelanganTanganDb == 2) {
            this.scoreA = 4;
        } 
        // twist 2
        else if(this.finalLenganAtas == 3 && !(this.finalLenganBawah == 0) && this.finalPergelanganTangan == 2 && !(this.finalPutarPergelanganTanganDb == 0)) {
            this.scoreA = 4;
        } 
        // twist 3
        else if(this.finalLenganAtas == 3 && !(this.finalLenganBawah == 0) && this.finalPergelanganTangan == 3 && this.finalPutarPergelanganTanganDb == 1) {
            this.scoreA = 4;
        } else if(this.finalLenganAtas == 3 && !(this.finalLenganBawah == 3) && this.finalPergelanganTangan == 3 && this.finalPutarPergelanganTanganDb == 2) {
            this.scoreA = 4;
        } else if(this.finalLenganAtas == 3 && this.finalLenganBawah == 3 && this.finalPergelanganTangan == 3 && this.finalPutarPergelanganTanganDb == 2) {
            this.scoreA = 5;
        } 
        // twist 4
        else if(this.finalLenganAtas == 3 && !(this.finalLenganBawah == 0) && this.finalPergelanganTangan == 4 && !(this.finalPutarPergelanganTanganDb == 0)) {
            this.scoreA = 5;
        } 
        
        // Upper Arm 4
        // twist 1
        else if(this.finalLenganAtas == 4 && !(this.finalLenganBawah == 0) && this.finalPergelanganTangan == 1 && !(this.finalPutarPergelanganTanganDb == 0)) {
            this.scoreA = 4;
        } 
        // twist 2
        else if(this.finalLenganAtas == 4 && !(this.finalLenganBawah == 0) && this.finalPergelanganTangan == 2 && this.finalPutarPergelanganTanganDb == 1) {
            this.scoreA = 4;
        } else if(this.finalLenganAtas == 4 && !(this.finalLenganBawah == 3) && this.finalPergelanganTangan == 2 && this.finalPutarPergelanganTanganDb == 2) {
            this.scoreA = 4;
        } else if(this.finalLenganAtas == 4 && this.finalLenganBawah == 3 && this.finalPergelanganTangan == 2 && this.finalPutarPergelanganTanganDb == 2) {
            this.scoreA = 5;
        } 
        // twist 3
        else if(this.finalLenganAtas == 4 && this.finalLenganBawah == 3 && this.finalPergelanganTangan == 3 && this.finalPutarPergelanganTanganDb == 1) {
            this.scoreA = 5;
        } else if(this.finalLenganAtas == 4 && !(this.finalLenganBawah == 3) && this.finalPergelanganTangan == 3 && this.finalPutarPergelanganTanganDb == 1) {
            this.scoreA = 4;
        } else if(this.finalLenganAtas == 4 && !(this.finalLenganBawah == 0) && this.finalPergelanganTangan == 3 && this.finalPutarPergelanganTanganDb == 2) {
            this.scoreA = 5;
        } 
        // 
        // twist 4
        else if(this.finalLenganAtas == 4 && this.finalLenganBawah == 3 && this.finalPergelanganTangan == 4 && !(this.finalPutarPergelanganTanganDb == 0)) {
            this.scoreA = 6;
        } else if(this.finalLenganAtas == 4 && !(this.finalLenganBawah == 3) && this.finalPergelanganTangan == 4 && !(this.finalPutarPergelanganTanganDb == 0)) {
            this.scoreA = 5;
        } 
        
        // Upper Arm 5
        // twist 1
        else if(this.finalLenganAtas == 5 && this.finalLenganBawah == 3 && this.finalPergelanganTangan == 1 && this.finalPutarPergelanganTanganDb == 1) {
            this.scoreA = 6;
        } else if(this.finalLenganAtas == 5 && !( this.finalLenganBawah == 3 ) && this.finalPergelanganTangan == 1 && this.finalPutarPergelanganTanganDb == 1) {
            this.scoreA = 5;
        } else if(this.finalLenganAtas == 5 && this.finalLenganBawah == 1 && this.finalPergelanganTangan == 1 && this.finalPutarPergelanganTanganDb == 2) {
            this.scoreA = 5;
        } else if(this.finalLenganAtas == 5 && !(this.finalLenganBawah == 1) && this.finalPergelanganTangan == 1 && this.finalPutarPergelanganTanganDb == 2) {
            this.scoreA = 6;
        } 
        // twist 2
        else if(this.finalLenganAtas == 5 && this.finalLenganBawah == 1 && this.finalPergelanganTangan == 2 && this.finalPutarPergelanganTanganDb == 1) {
            this.scoreA = 5;
        } else if(this.finalLenganAtas == 5 && !(this.finalLenganBawah == 1) && this.finalPergelanganTangan == 2 && this.finalPutarPergelanganTanganDb == 1) {
            this.scoreA = 6;
        } else if(this.finalLenganAtas == 5 && this.finalLenganBawah == 1 && this.finalPergelanganTangan == 2 && this.finalPutarPergelanganTanganDb == 2) {
            this.scoreA = 5;
        } else if(this.finalLenganAtas == 5 && this.finalLenganBawah == 2 && this.finalPergelanganTangan == 2 && this.finalPutarPergelanganTanganDb == 2) {
            this.scoreA = 6;
        } else if(this.finalLenganAtas == 5 && this.finalLenganBawah == 3 && this.finalPergelanganTangan == 2 && this.finalPutarPergelanganTanganDb == 2) {
            this.scoreA = 7;
        } 
        // twist 3
        else if(this.finalLenganAtas == 5 && this.finalLenganBawah == 1 && this.finalPergelanganTangan == 3 && this.finalPutarPergelanganTanganDb == 1) {
            this.scoreA = 5;
        } else if(this.finalLenganAtas == 5 && this.finalLenganBawah == 2 && this.finalPergelanganTangan == 3 && this.finalPutarPergelanganTanganDb == 1) {
            this.scoreA = 6;
        } else if(this.finalLenganAtas == 5 && this.finalLenganBawah == 3 && this.finalPergelanganTangan == 3 && this.finalPutarPergelanganTanganDb == 1) {
            this.scoreA = 7;
        } else if(this.finalLenganAtas == 5 && this.finalLenganBawah == 1 && this.finalPergelanganTangan == 3 && this.finalPutarPergelanganTanganDb == 2) {
            this.scoreA = 6;
        } else if(this.finalLenganAtas == 5 && !(this.finalLenganBawah == 1) && this.finalPergelanganTangan == 3 && this.finalPutarPergelanganTanganDb == 2) {
            this.scoreA = 7;
        }
        // 
        // twist 4
        else if(this.finalLenganAtas == 5 && this.finalLenganBawah == 1 && this.finalPergelanganTangan == 4 && this.finalPutarPergelanganTanganDb == 1) {
            this.scoreA = 6;
        } else if(this.finalLenganAtas == 5 && !(this.finalLenganBawah == 1) && this.finalPergelanganTangan == 4 && this.finalPutarPergelanganTanganDb == 1) {
            this.scoreA = 7;
        } else if(this.finalLenganAtas == 5 && this.finalLenganBawah == 3 && this.finalPergelanganTangan == 4 && this.finalPutarPergelanganTanganDb == 2) {
            this.scoreA = 8;
        } else if(this.finalLenganAtas == 5 && !( this.finalLenganBawah == 3 ) && this.finalPergelanganTangan == 4 && this.finalPutarPergelanganTanganDb == 2) {
            this.scoreA = 7;
        }
        
        // Upper Arm 6
        // twist 1 // twist 2
        else if(this.finalLenganAtas == 6 && this.finalLenganBawah == 1 && (this.finalPergelanganTangan == 1 || this.finalPergelanganTangan == 2) && !(this.finalPutarPergelanganTanganDb == 0)) {
            this.scoreA = 7;
        } else if(this.finalLenganAtas == 6 && this.finalLenganBawah == 2 && (this.finalPergelanganTangan == 1 || this.finalPergelanganTangan == 2) && !(this.finalPutarPergelanganTanganDb == 0)) {
            this.scoreA = 8;
        } else if(this.finalLenganAtas == 6 && this.finalLenganBawah == 3 && (this.finalPergelanganTangan == 1 || this.finalPergelanganTangan == 2) && !(this.finalPutarPergelanganTanganDb == 0)) {
            this.scoreA = 9;
        } 
        // twist 3
        else if(this.finalLenganAtas == 6 && this.finalLenganBawah == 1 && this.finalPergelanganTangan == 3 && this.finalPutarPergelanganTanganDb == 1) {
            this.scoreA = 7;
        } else if(this.finalLenganAtas == 6 && this.finalLenganBawah == 2 && this.finalPergelanganTangan == 3 && this.finalPutarPergelanganTanganDb == 1) {
            this.scoreA = 8;
        } else if(this.finalLenganAtas == 6 && this.finalLenganBawah == 3 && this.finalPergelanganTangan == 3 && this.finalPutarPergelanganTanganDb == 1) {
            this.scoreA = 9;
        } else if(this.finalLenganAtas == 6 && this.finalLenganBawah == 1 && this.finalPergelanganTangan == 3 && this.finalPutarPergelanganTanganDb == 2) {
            this.scoreA = 8;
        } else if(this.finalLenganAtas == 6 && !(this.finalLenganBawah == 1) && this.finalPergelanganTangan == 3 && this.finalPutarPergelanganTanganDb == 2) {
            this.scoreA = 9;
        } 
        // 
        // twist 4
        else if(this.finalLenganAtas == 6 && this.finalLenganBawah == 1 && this.finalPergelanganTangan == 4 && this.finalPutarPergelanganTanganDb == 1) {
            this.scoreA = 8;
        } else if(this.finalLenganAtas == 6 && !(this.finalLenganBawah == 1) && this.finalPergelanganTangan == 4 && this.finalPutarPergelanganTanganDb == 1) {
            this.scoreA = 9;
        } else if(this.finalLenganAtas == 6 && !(this.finalLenganBawah == 0) && this.finalPergelanganTangan == 4 && this.finalPutarPergelanganTanganDb == 2) {
            this.scoreA = 9;
        } 
        
        this.finalScoreA = this.scoreA + this.finalTambahanData;
        
        System.out.println("\n\nHasil Result");
        System.out.println("Score A = " + this.scoreA);
        System.out.println("Tambahan Data 1 = " + this.finalTambahanData);
        System.out.println("Final Score A = " + this.finalScoreA);
        
        
        // SCORE B =================================
        // Badan 1
        if (this.finalBadan == 1 && this.finalLeher == 1 && this.finalKakiDb == 1) {
            this.scoreB = 1;
        } else if (this.finalBadan == 1 && this.finalLeher == 1 && this.finalKakiDb == 2) {
            this.scoreB = 3;
        } else if (this.finalBadan == 1 && this.finalLeher == 2 && this.finalKakiDb == 1) {
            this.scoreB = 2;
        } else if (this.finalBadan == 1 && this.finalLeher == 2 && this.finalKakiDb == 2) {
            this.scoreB = 3;
        } else if (this.finalBadan == 1 && this.finalLeher == 3 && !(this.finalKakiDb == 0)) {
            this.scoreB = 3;
        } else if (this.finalBadan == 1 && this.finalLeher == 4 && !(this.finalKakiDb == 0)) {
            this.scoreB = 5;
        } 
        // Badan 1 dan 2 leher 5
        else if (this.finalBadan <= 2 && this.finalLeher == 5 && !(this.finalKakiDb == 0)) {
            this.scoreB = 7;
        } 
        // Badan 1,2 dan 3 leher 6
        else if (this.finalBadan <= 3 && this.finalLeher == 6 && !(this.finalKakiDb == 0)) {
            this.scoreB = 8;
        } 
        // badan 2
        else if (this.finalBadan == 2 && this.finalLeher <= 2 && this.finalKakiDb == 1) {
            this.scoreB = 2;
        } else if (this.finalBadan == 2 && this.finalLeher <= 2 && this.finalKakiDb == 2) {
            this.scoreB = 3;
        } else if (this.finalBadan == 2 && this.finalLeher == 3 && this.finalKakiDb == 1) {
            this.scoreB = 3;
        } else if (this.finalBadan == 2 && this.finalLeher == 3 && this.finalKakiDb == 2) {
            this.scoreB = 4;
        } else if (this.finalBadan == 2 && this.finalLeher == 4 && this.finalKakiDb == 1) {
            this.scoreB = 5;
        } else if (this.finalBadan == 2 && this.finalLeher == 4 && this.finalKakiDb == 2) {
            this.scoreB = 6;
        } 
        
        // badan 3
        else if (this.finalBadan == 3 && this.finalLeher == 1 && this.finalKakiDb == 1) {
            this.scoreB = 3;
        } else if (this.finalBadan == 3 && this.finalLeher == 1 && this.finalKakiDb == 2) {
            this.scoreB = 4;
        } else if (this.finalBadan == 3 && (this.finalLeher == 2 || this.finalLeher == 3) && this.finalKakiDb == 1) {
            this.scoreB = 4;
        } else if (this.finalBadan == 3 && (this.finalLeher == 2 || this.finalLeher == 3) && this.finalKakiDb == 2) {
            this.scoreB = 5;
        } else if (this.finalBadan == 3 && this.finalLeher == 4 && this.finalKakiDb == 1) {
            this.scoreB = 6;
        } else if (this.finalBadan == 3 && this.finalLeher == 4 && this.finalKakiDb == 2) {
            this.scoreB = 7;
        } else if (this.finalBadan == 3 && this.finalLeher == 5 && this.finalKakiDb == 1) {
            this.scoreB = 7;
        } else if (this.finalBadan == 3 && this.finalLeher == 5 && this.finalKakiDb == 2) {
            this.scoreB = 8;
        }
        
        // badan 4
        else if (this.finalBadan == 4 && this.finalLeher <= 2 && !(this.finalKakiDb == 0)) {
            this.scoreB = 5;
        } else if (this.finalBadan == 4 && this.finalLeher == 3 && this.finalKakiDb == 1) {
            this.scoreB = 5;
        } else if (this.finalBadan == 4 && this.finalLeher == 3 && this.finalKakiDb == 2) {
            this.scoreB = 6;
        } 
        // badan 4 dan 5  leher 4
        else if ((this.finalBadan == 4 || this.finalBadan == 5) && this.finalLeher == 4 && !(this.finalKakiDb == 0)) {
            this.scoreB = 7;
        } 
        // badan 4,5 dan 6 leher 5
        else if ((this.finalBadan >= 4) && this.finalLeher == 5 && !(this.finalKakiDb == 0)) {
            this.scoreB = 8;
        } else if (this.finalBadan == 4 && this.finalLeher == 6 && this.finalKakiDb == 1) {
            this.scoreB = 8;
        } else if (this.finalBadan == 4 && this.finalLeher == 6 && this.finalKakiDb == 2) {
            this.scoreB = 9;
        }
        // badan 5
        else if (this.finalBadan == 5 && this.finalLeher == 1 && !(this.finalKakiDb == 0)) {
            this.scoreB = 6;
        } else if (this.finalBadan == 5 && (this.finalLeher == 2 || this.finalLeher == 3) && this.finalKakiDb == 1) {
            this.scoreB = 6;
        } else if (this.finalBadan == 5 && (this.finalLeher == 2 || this.finalLeher == 3) && this.finalKakiDb == 2) {
            this.scoreB = 7;
        } 
        // badan 5 dan 6
        else if ((this.finalBadan >= 5) && this.finalLeher == 6 && !(this.finalKakiDb == 0)) {
            this.scoreB = 9;
        } else if (this.finalBadan == 6 && this.finalLeher <= 3 && !(this.finalKakiDb == 0)) {
            this.scoreB = 7;
        } else if (this.finalBadan == 6 && this.finalLeher == 4 && !(this.finalKakiDb == 0)) {
            this.scoreB = 8;
        } 
        
        this.finalScoreB = this.scoreB + this.finalTambahanData2;
        
        System.out.println("Score B = " + this.scoreB);
        System.out.println("Tambahan Data 2 = " + this.finalTambahanData2);
        System.out.println("Final Score B = " + this.finalScoreB);
        
        
        //SCORE C ==============================
        if (this.finalScoreA == 1 && this.scoreB == 1) {
            this.scoreC = 1;
        } else if (this.finalScoreA == 2 && this.scoreB <= 1 ) {
            this.scoreC = 2;
        } else if ((this.finalScoreA == 3 || this.finalScoreA == 4) && this.scoreB <= 3) {
            this.scoreC = 3;
        } else if ((this.finalScoreA == 5 || this.finalScoreA == 6) && this.scoreB <= 2) {
            this.scoreC = 4;
        } else if (this.finalScoreA >= 7 && this.scoreB <= 2) {
            this.scoreC = 5;
        } else if (this.finalScoreA == 1 && this.scoreB == 2) {
            this.scoreC = 2;
        } else if (this.finalScoreA == 1 && (this.scoreB == 3 || this.scoreB == 4)) {
            this.scoreC = 3;
        } else if (this.finalScoreA == 2 && this.scoreB == 3) {
            this.scoreC = 3;
        } else if ((this.finalScoreA == 2 || this.finalScoreA == 3) && (this.scoreB == 4 || this.scoreB == 5)) {
            this.scoreC = 4;
        } else if (this.finalScoreA == 4 && this.scoreB == 4) {
            this.scoreC = 4;
        } else if (this.finalScoreA == 5 && this.scoreB == 3) {
            this.scoreC = 4;
        } else if (this.finalScoreA == 5 && this.scoreB == 4) {
            this.scoreC = 5;
        } else if (this.finalScoreA == 6 && this.scoreB == 3) {
            this.scoreC = 5;
        } else if (this.finalScoreA == 6 && (this.scoreB == 4 || this.scoreB == 5)) {
            this.scoreC = 6;
        } else if (this.finalScoreA == 7 && (this.scoreB == 3 || this.scoreB == 4)) {
            this.scoreC = 6;
        } else if (this.finalScoreA >= 8 && this.scoreB == 3) {
            this.scoreC = 6;
        } else if (this.finalScoreA >= 8 && this.scoreB >= 4) {
            this.scoreC = 7;
        } else if (this.finalScoreA == 1 && this.scoreB == 5) {
            this.scoreC = 4;
        } else if (this.finalScoreA == 4 && this.scoreB == 5) {
            this.scoreC = 5;
        } else if (this.finalScoreA == 5 && this.scoreB == 5) {
            this.scoreC = 6;
        } else if (this.finalScoreA == 7 && this.scoreB >= 5) {
            this.scoreC = 7;
        } else if ((this.finalScoreA == 1 || this.finalScoreA == 2) && this.scoreB >= 6) {
            this.scoreC = 5;
        } else if (this.finalScoreA == 3 && this.scoreB == 6) {
            this.scoreC = 5;
        } else if (this.finalScoreA == 4 && this.scoreB >= 6) {
            this.scoreC = 6;
        } else if ((this.finalScoreA == 5 || this.finalScoreA == 6) && this.scoreB >= 6) {
            this.scoreC = 7;
        } else if (this.finalScoreA == 3 && this.scoreB >= 7) {
            this.scoreC = 6;
        } 
        
        
        System.out.println("Score C = " + this.scoreC);
        
        if(this.scoreC <= 2) {
            this.finalScoreC = "Postur dapat diterima";
            this.kerentanan = 1;
            displayHasil.setForeground(Color.green);
        } else if (this.scoreC == 3 || this.scoreC == 4) {
            this.finalScoreC = "Penyelidikan lebih lanjut, Perubahan mungkin diperlukan";
            this.kerentanan = 2;
            displayHasil.setForeground(Color.yellow);
        }  else if (this.scoreC == 5 || this.scoreC == 6) {
            this.finalScoreC = "Penyelidikan lebih lanjut, Segera berubah";
            this.kerentanan = 3;
            displayHasil.setForeground(Color.orange);
        } else {
            this.finalScoreC = "Menyelidiki dan menerapkan perubahan";
            this.kerentanan = 4;
            displayHasil.setForeground(Color.red);
        }
        
        
        System.out.println("Final Hasil = " + this.finalScoreC);
    }
    
    public void displayHasil() {
        displayHasil.setText(String.valueOf(scoreC));
        displayKerentanan.setText("<html>"+ String.valueOf(kerentanan)+ "</html>");
    }
    
    

    public void nextInputan() {
        CardLayout cardlayout = (CardLayout) cardInputData.getLayout();
        cardlayout.next(cardInputData);
        nextButton.setEnabled(false);
        
        int current = 0;
        for (Component comp : cardInputData.getComponents()) {
            if (comp.isVisible()) {
                break;
            }
            current++;
        }
          
        
        if (current == cardInputData.getComponentCount() - 11) {
            if(btnArahKanan.isSelected() || btnArahKiri.isSelected()) {
                nextButton.setEnabled(true);
            }  
        }
        if (current == cardInputData.getComponentCount() - 10) {
            showDataAddLA();
        }
        if (current == cardInputData.getComponentCount() - 9) {
            showDataAddLB();
        }
        if (current == cardInputData.getComponentCount() - 8) {
            showDataAddPT();
        }
        if (current == cardInputData.getComponentCount() - 7) {
            if(btnPPT1.isSelected() || btnPPT2.isSelected()) {
                nextButton.setEnabled(true);
            }  
        }
        if (current == cardInputData.getComponentCount() - 6) {
            showDataAddDT1();
        }
        if (current == cardInputData.getComponentCount() - 5) {
            showDataAddL();
        }
        if (current == cardInputData.getComponentCount() - 4) {
            showDataAddB();
        }
        if (current == cardInputData.getComponentCount() - 3) {
            if(btnK1.isSelected() || btnK2.isSelected()) {
                nextButton.setEnabled(true);
            }
        }
        
        if (current == cardInputData.getComponentCount() - 2) {
            if(btnK1.isSelected() || btnK2.isSelected()) {
                panelBtnNext.setVisible(false);
                panelNextBtn1.setVisible(true);
            }
        }
        
        backButton.setEnabled(true);
    }
    
    public void backInputan() {
        CardLayout cardlayout = (CardLayout) cardInputData.getLayout();
        cardlayout.previous(cardInputData);
        panelNextBtn1.setVisible(false);
        panelBtnNext.setVisible(true);
        
        int current = 0;
        for (Component comp : cardInputData.getComponents()) {
            if (comp.isVisible()) {
                break;
            }
            current++;
        }
        if (current == 0) {
            backButton.setEnabled(false);
        }
        nextButton.setEnabled(true);
    }
    
    private void updateButtonNext(){
        String n = nama.getText();
        String u = umur.getText();
//        String jk = jenisKelamin.getSelectedItem().toString();
        String almt = alamat.getText();
        String nt = nomorTelephone.getText();
        String pkjn = pekerjaan.getText();
        String lk = lamaBekerja.getText();
        String dk = durasiBekerja.getText();
//        String jk2 = jenisKerja.getSelectedItem().toString();
        String k = keluhan.getText();
        int jk = jenisKelamin.getSelectedIndex();
        int jk2 = jenisKerja.getSelectedIndex();
                
        boolean enabled = !n.isEmpty() && !u.isEmpty() && jk != -1 && !almt.isEmpty() && !nt.isEmpty() && !pkjn.isEmpty() && !lk.isEmpty() && !dk.isEmpty() && jk2 != -1 && !k.isEmpty();
        nextButton.setEnabled(enabled);
                    
//        System.out.println(jk);
//        System.out.println(jk2);
    }
    
    // Menampilkan database ke tabel
    public void TampilkanData(){
        DefaultTableModel model= new DefaultTableModel();
        model.addColumn("NIK");
        model.addColumn("Nama");
        model.addColumn("Umur");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Pekerjaan");
        model.addColumn("Final Score");
        try{
            String sql="SELECT * FROM t_show";
            java.sql.Connection conn = (Connection)Database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4)
                ,res.getString(5),res.getString(6)});
            }
            
            TabelHistory.setModel(model);
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public void showDataAddLA() {
        if(btnLA6.isSelected() || btnLA7.isSelected() || btnLA8.isSelected() || btnLA9.isSelected() || btnLA10.isSelected()) {
            lenganAtasTambahanPanel.setVisible(true);
            nextButton.setEnabled(true);
        }
    }
    
    public void showDataAddLB() {
        if(btnLB1.isSelected() || btnLB2.isSelected() || btnLB3.isSelected()) {
            lenganBawahTambahanPanel.setVisible(true);
            nextButton.setEnabled(true);
        }
    }
    
    public void showDataAddPT() {
        if(btnPT1.isSelected() || btnPT2.isSelected() || btnPT3.isSelected() || btnPT4.isSelected()) {
            pergelanganTanganTambahanPanel.setVisible(true);
            nextButton.setEnabled(true);
        }
    }
    
    public void showDataAddDT1() {
        if(tambahanData1.isSelected() || tambahanData2.isSelected() || tambahanData3.isSelected() || tambahanData4.isSelected()) {
            dataTambahan1Panel.setVisible(true);
            nextButton.setEnabled(true);
        }
    }
    
    public void showDataAddL() {
        if(btnL1.isSelected() || btnL2.isSelected() || btnL3.isSelected() || btnL4.isSelected()) {
            leherTambahanPanel.setVisible(true);
            nextButton.setEnabled(true);
        }
    }
    
    public void showDataAddB() {
        if(btnB1.isSelected() || btnB2.isSelected() || btnB3.isSelected() || btnB4.isSelected()) {
            badanTambahanPanel.setVisible(true);
            nextButton.setEnabled(true);
        }
    }
    
    public void showDataAddDT2() {
        if(tambahanData21.isSelected() || tambahanData22.isSelected() || tambahanData23.isSelected() || tambahanData24.isSelected()) {
            dataTambahan2Panel.setVisible(true);
            nextButton.setEnabled(true);
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

        sisiBadan = new javax.swing.ButtonGroup();
        lenganAtasGrup = new javax.swing.ButtonGroup();
        lenganBawahGrup = new javax.swing.ButtonGroup();
        pergelanganTanganGrup = new javax.swing.ButtonGroup();
        putarPergelanganTanganGrup = new javax.swing.ButtonGroup();
        dataTambahan1 = new javax.swing.ButtonGroup();
        leherGrup = new javax.swing.ButtonGroup();
        badanGrup = new javax.swing.ButtonGroup();
        kakiGrup = new javax.swing.ButtonGroup();
        dataTambahan2 = new javax.swing.ButtonGroup();
        MainPanel = new javax.swing.JPanel();
        left = new javax.swing.JPanel();
        appName = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        menuList = new javax.swing.JPanel();
        menu1 = new GUI_Custom.PanelRound();
        btnInputData = new javax.swing.JButton();
        menu2 = new GUI_Custom.PanelRound();
        btnInputData1 = new javax.swing.JButton();
        menuList1 = new javax.swing.JPanel();
        menu9 = new GUI_Custom.PanelRound();
        btnInputData8 = new javax.swing.JButton();
        right = new javax.swing.JPanel();
        panelDashboard = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        panelData = new javax.swing.JPanel();
        pInputData = new javax.swing.JPanel();
        cardInputData = new javax.swing.JPanel();
        dataDiri = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel58 = new javax.swing.JPanel();
        dataPersonalPanel = new javax.swing.JPanel();
        jPanel67 = new javax.swing.JPanel();
        nik = new GUI_Custom.TextField();
        jPanel70 = new javax.swing.JPanel();
        nama = new GUI_Custom.TextField();
        jPanel71 = new javax.swing.JPanel();
        jPanel77 = new javax.swing.JPanel();
        umur = new GUI_Custom.TextField();
        jPanel78 = new javax.swing.JPanel();
        jenisKelamin = new GUI_Custom.ComboBoxSuggestion();
        jPanel72 = new javax.swing.JPanel();
        alamat = new GUI_Custom.TextField();
        jPanel75 = new javax.swing.JPanel();
        nomorTelephone = new GUI_Custom.TextField();
        jPanel76 = new javax.swing.JPanel();
        pekerjaan = new GUI_Custom.TextField();
        dataPekerjaanPanel = new javax.swing.JPanel();
        jPanel82 = new javax.swing.JPanel();
        jPanel83 = new javax.swing.JPanel();
        lamaBekerja = new GUI_Custom.TextField();
        jPanel84 = new javax.swing.JPanel();
        durasiBekerja = new GUI_Custom.TextField();
        jPanel85 = new javax.swing.JPanel();
        jenisKerja = new GUI_Custom.ComboBoxSuggestion();
        jPanel81 = new javax.swing.JPanel();
        keluhan = new GUI_Custom.TextField();
        blank = new javax.swing.JPanel();
        pilihSisi = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel109 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel110 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        panelGrupSisiBadan = new javax.swing.JPanel();
        panelSisiKiri = new javax.swing.JPanel();
        btnArahKiri = new javax.swing.JRadioButton();
        panelSisiKanan = new javax.swing.JPanel();
        btnArahKanan = new javax.swing.JRadioButton();
        lenganAtas = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel111 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel112 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        panelGrupLenganAtas = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        coLA1 = new javax.swing.JPanel();
        btnLA6 = new javax.swing.JRadioButton();
        coLA2 = new javax.swing.JPanel();
        btnLA7 = new javax.swing.JRadioButton();
        coLA3 = new javax.swing.JPanel();
        btnLA8 = new javax.swing.JRadioButton();
        jPanel11 = new javax.swing.JPanel();
        coLA4 = new javax.swing.JPanel();
        btnLA9 = new javax.swing.JRadioButton();
        coLA5 = new javax.swing.JPanel();
        btnLA10 = new javax.swing.JRadioButton();
        lenganAtasTambahanPanel = new javax.swing.JPanel();
        coAddLA1 = new javax.swing.JPanel();
        secDataLA1 = new javax.swing.JCheckBox();
        coAddLA2 = new javax.swing.JPanel();
        secDataLA2 = new javax.swing.JCheckBox();
        coAddLA3 = new javax.swing.JPanel();
        secDataLA3 = new javax.swing.JCheckBox();
        lenganBawah = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel114 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel37 = new javax.swing.JPanel();
        coLB1 = new javax.swing.JPanel();
        btnLB1 = new javax.swing.JRadioButton();
        coLB2 = new javax.swing.JPanel();
        btnLB2 = new javax.swing.JRadioButton();
        coLB3 = new javax.swing.JPanel();
        btnLB3 = new javax.swing.JRadioButton();
        lenganBawahTambahanPanel = new javax.swing.JPanel();
        coAddLB1 = new javax.swing.JPanel();
        secDataLB = new javax.swing.JCheckBox();
        pergelanganTangan = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel116 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel23 = new javax.swing.JPanel();
        coPT1 = new javax.swing.JPanel();
        btnPT1 = new javax.swing.JRadioButton();
        coPT2 = new javax.swing.JPanel();
        btnPT2 = new javax.swing.JRadioButton();
        coPT3 = new javax.swing.JPanel();
        btnPT3 = new javax.swing.JRadioButton();
        coPT4 = new javax.swing.JPanel();
        btnPT4 = new javax.swing.JRadioButton();
        pergelanganTanganTambahanPanel = new javax.swing.JPanel();
        coAddPT1 = new javax.swing.JPanel();
        secDataPT = new javax.swing.JCheckBox();
        putarPergelanganTangan = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel117 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel118 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel28 = new javax.swing.JPanel();
        coPPT1 = new javax.swing.JPanel();
        btnPPT1 = new javax.swing.JRadioButton();
        coPPT2 = new javax.swing.JPanel();
        btnPPT2 = new javax.swing.JRadioButton();
        tambahan1 = new javax.swing.JPanel();
        jPanel282 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jLabel119 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel120 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jPanel36 = new javax.swing.JPanel();
        coDT11 = new javax.swing.JPanel();
        tambahanData1 = new javax.swing.JRadioButton();
        coDT12 = new javax.swing.JPanel();
        tambahanData2 = new javax.swing.JRadioButton();
        coDT13 = new javax.swing.JPanel();
        tambahanData3 = new javax.swing.JRadioButton();
        coDT14 = new javax.swing.JPanel();
        tambahanData4 = new javax.swing.JRadioButton();
        dataTambahan1Panel = new javax.swing.JPanel();
        coAddDT1 = new javax.swing.JPanel();
        tambahanData5 = new javax.swing.JRadioButton();
        leher = new javax.swing.JPanel();
        jPanel297 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jLabel121 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jLabel122 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jPanel41 = new javax.swing.JPanel();
        coL1 = new javax.swing.JPanel();
        btnL1 = new javax.swing.JRadioButton();
        coL2 = new javax.swing.JPanel();
        btnL2 = new javax.swing.JRadioButton();
        coL3 = new javax.swing.JPanel();
        btnL3 = new javax.swing.JRadioButton();
        coL4 = new javax.swing.JPanel();
        btnL4 = new javax.swing.JRadioButton();
        leherTambahanPanel = new javax.swing.JPanel();
        coAddL1 = new javax.swing.JPanel();
        secDataL1 = new javax.swing.JCheckBox();
        coAddL2 = new javax.swing.JPanel();
        secDataL2 = new javax.swing.JCheckBox();
        badan = new javax.swing.JPanel();
        jPanel308 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        jLabel123 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jLabel124 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jPanel45 = new javax.swing.JPanel();
        coB1 = new javax.swing.JPanel();
        btnB1 = new javax.swing.JRadioButton();
        coB2 = new javax.swing.JPanel();
        btnB2 = new javax.swing.JRadioButton();
        coB3 = new javax.swing.JPanel();
        btnB3 = new javax.swing.JRadioButton();
        coB4 = new javax.swing.JPanel();
        btnB4 = new javax.swing.JRadioButton();
        badanTambahanPanel = new javax.swing.JPanel();
        coAddB1 = new javax.swing.JPanel();
        secDataB1 = new javax.swing.JCheckBox();
        coAddB2 = new javax.swing.JPanel();
        secDataB2 = new javax.swing.JCheckBox();
        kaki = new javax.swing.JPanel();
        jPanel324 = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jLabel125 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        jLabel126 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jPanel49 = new javax.swing.JPanel();
        coK1 = new javax.swing.JPanel();
        btnK1 = new javax.swing.JRadioButton();
        coK2 = new javax.swing.JPanel();
        btnK2 = new javax.swing.JRadioButton();
        tambahan2 = new javax.swing.JPanel();
        jPanel283 = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        jPanel51 = new javax.swing.JPanel();
        jLabel127 = new javax.swing.JLabel();
        jPanel52 = new javax.swing.JPanel();
        jLabel128 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jPanel53 = new javax.swing.JPanel();
        coDT21 = new javax.swing.JPanel();
        tambahanData21 = new javax.swing.JRadioButton();
        coDT22 = new javax.swing.JPanel();
        tambahanData22 = new javax.swing.JRadioButton();
        coDT23 = new javax.swing.JPanel();
        tambahanData23 = new javax.swing.JRadioButton();
        coDT24 = new javax.swing.JPanel();
        tambahanData24 = new javax.swing.JRadioButton();
        dataTambahan2Panel = new javax.swing.JPanel();
        coAddDT2 = new javax.swing.JPanel();
        tambahanData25 = new javax.swing.JRadioButton();
        finalHasil = new javax.swing.JPanel();
        jPanel334 = new javax.swing.JPanel();
        jPanel60 = new javax.swing.JPanel();
        jPanel61 = new javax.swing.JPanel();
        jLabel131 = new javax.swing.JLabel();
        jPanel62 = new javax.swing.JPanel();
        jLabel132 = new javax.swing.JLabel();
        jPanel281 = new javax.swing.JPanel();
        jPanel59 = new javax.swing.JPanel();
        Hasil1 = new javax.swing.JPanel();
        displayHasil = new javax.swing.JLabel();
        Hasil2 = new javax.swing.JPanel();
        displayKerentanan = new javax.swing.JLabel();
        Hasil3 = new javax.swing.JPanel();
        displayKeterangan = new javax.swing.JLabel();
        jPanel437 = new javax.swing.JPanel();
        panelBtnNext1 = new javax.swing.JPanel();
        panelBtn22 = new GUI_Custom.PanelRound();
        nextButton2 = new javax.swing.JButton();
        panelBtnNext2 = new javax.swing.JPanel();
        panelBtn23 = new GUI_Custom.PanelRound();
        nextButton3 = new javax.swing.JButton();
        btnGrupDown = new javax.swing.JPanel();
        panelBtnBack = new GUI_Custom.PanelRound();
        backButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        panelBtnNext = new GUI_Custom.PanelRound();
        nextButton = new javax.swing.JButton();
        panelNextBtn1 = new GUI_Custom.PanelRound();
        nextButton1 = new javax.swing.JButton();
        blank6 = new javax.swing.JPanel();
        databasePanel = new javax.swing.JPanel();
        jPanel323 = new javax.swing.JPanel();
        jPanel54 = new javax.swing.JPanel();
        jPanel55 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        jPanel56 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        blank15 = new javax.swing.JPanel();
        jPanel342 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        TabelHistory = new GUI_Custom.TableDark();
        jPanel345 = new javax.swing.JPanel();
        panelDbDataLengkap = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        panelDbHapus = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        aboutMe = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel57 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel63 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel64 = new javax.swing.JPanel();
        jPanel65 = new javax.swing.JPanel();
        jPanel66 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel74 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel79 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel80 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1290, 777));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        MainPanel.setLayout(new javax.swing.BoxLayout(MainPanel, javax.swing.BoxLayout.X_AXIS));

        left.setBackground(new java.awt.Color(33, 42, 62));
        left.setMaximumSize(new java.awt.Dimension(140, 3053));
        left.setMinimumSize(new java.awt.Dimension(140, 253));
        left.setPreferredSize(new java.awt.Dimension(140, 753));
        left.setLayout(new javax.swing.BoxLayout(left, javax.swing.BoxLayout.Y_AXIS));

        appName.setBackground(new java.awt.Color(1, 100, 139));
        appName.setForeground(new java.awt.Color(255, 255, 255));
        appName.setPreferredSize(new java.awt.Dimension(117, 243));
        appName.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        jPanel5.setBackground(new java.awt.Color(1, 100, 139));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo_app (Custom).png"))); // NOI18N
        jPanel5.add(jLabel1);

        appName.add(jPanel5);

        jLabel2.setFont(new java.awt.Font("Google Sans", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("RULA");
        appName.add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Google Sans", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("APPLICATION");
        appName.add(jLabel3);

        left.add(appName);

        menuList.setBackground(new java.awt.Color(1, 100, 139));
        menuList.setLayout(new java.awt.GridLayout(6, 1));

        menu1.setBackground(new java.awt.Color(1, 100, 139));
        menu1.setRoundBottomLeft(20);
        menu1.setRoundBottomRight(20);
        menu1.setRoundTopLeft(20);
        menu1.setRoundTopRight(20);

        btnInputData.setBackground(new java.awt.Color(33, 42, 62));
        btnInputData.setFont(new java.awt.Font("Google Sans", 0, 12)); // NOI18N
        btnInputData.setForeground(new java.awt.Color(255, 255, 255));
        btnInputData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/input_icon.png"))); // NOI18N
        btnInputData.setText("Input Data");
        btnInputData.setBorderPainted(false);
        btnInputData.setContentAreaFilled(false);
        btnInputData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInputData.setFocusPainted(false);
        btnInputData.setIconTextGap(10);
        btnInputData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInputDataMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInputDataMouseEntered(evt);
            }
        });
        btnInputData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInputDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menu1Layout = new javax.swing.GroupLayout(menu1);
        menu1.setLayout(menu1Layout);
        menu1Layout.setHorizontalGroup(
            menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInputData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu1Layout.setVerticalGroup(
            menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInputData, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        );

        menuList.add(menu1);

        menu2.setBackground(new java.awt.Color(1, 100, 139));
        menu2.setRoundBottomLeft(20);
        menu2.setRoundBottomRight(20);
        menu2.setRoundTopLeft(20);
        menu2.setRoundTopRight(20);

        btnInputData1.setBackground(new java.awt.Color(33, 42, 62));
        btnInputData1.setFont(new java.awt.Font("Google Sans", 0, 12)); // NOI18N
        btnInputData1.setForeground(new java.awt.Color(255, 255, 255));
        btnInputData1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/database2_icon.png"))); // NOI18N
        btnInputData1.setText("Database");
        btnInputData1.setBorderPainted(false);
        btnInputData1.setContentAreaFilled(false);
        btnInputData1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInputData1.setFocusPainted(false);
        btnInputData1.setIconTextGap(10);
        btnInputData1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInputData1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInputData1MouseEntered(evt);
            }
        });
        btnInputData1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInputData1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menu2Layout = new javax.swing.GroupLayout(menu2);
        menu2.setLayout(menu2Layout);
        menu2Layout.setHorizontalGroup(
            menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInputData1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu2Layout.setVerticalGroup(
            menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInputData1, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        );

        menuList.add(menu2);

        left.add(menuList);

        menuList1.setBackground(new java.awt.Color(1, 100, 139));
        menuList1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 30, 0), null));
        menuList1.setLayout(new javax.swing.BoxLayout(menuList1, javax.swing.BoxLayout.LINE_AXIS));

        menu9.setBackground(new java.awt.Color(1, 100, 139));
        menu9.setMaximumSize(new java.awt.Dimension(32767, 50));
        menu9.setPreferredSize(new java.awt.Dimension(116, 50));
        menu9.setRoundBottomLeft(20);
        menu9.setRoundBottomRight(20);
        menu9.setRoundTopLeft(20);
        menu9.setRoundTopRight(20);

        btnInputData8.setBackground(new java.awt.Color(33, 42, 62));
        btnInputData8.setFont(new java.awt.Font("Google Sans", 0, 12)); // NOI18N
        btnInputData8.setForeground(new java.awt.Color(255, 255, 255));
        btnInputData8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/info.png"))); // NOI18N
        btnInputData8.setText("About Me");
        btnInputData8.setBorderPainted(false);
        btnInputData8.setContentAreaFilled(false);
        btnInputData8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInputData8.setFocusPainted(false);
        btnInputData8.setIconTextGap(10);
        btnInputData8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInputData5MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInputData5MouseEntered(evt);
            }
        });
        btnInputData8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInputData5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menu9Layout = new javax.swing.GroupLayout(menu9);
        menu9.setLayout(menu9Layout);
        menu9Layout.setHorizontalGroup(
            menu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInputData8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu9Layout.setVerticalGroup(
            menu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInputData8, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        menuList1.add(menu9);

        left.add(menuList1);

        MainPanel.add(left);

        right.setBackground(new java.awt.Color(255, 255, 255));
        right.setLayout(new java.awt.CardLayout());

        panelDashboard.setLayout(new java.awt.BorderLayout());

        jLabel19.setFont(new java.awt.Font("Google Sans", 1, 48)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dashboard_final.png"))); // NOI18N
        jLabel19.setText("RULA APPLICATION");
        jLabel19.setToolTipText("");
        jLabel19.setIconTextGap(0);
        panelDashboard.add(jLabel19, java.awt.BorderLayout.CENTER);

        right.add(panelDashboard, "card1");

        panelData.setLayout(new java.awt.BorderLayout());

        pInputData.setBackground(new java.awt.Color(155, 164, 181));
        pInputData.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(241, 246, 249)));
        pInputData.setLayout(new javax.swing.BoxLayout(pInputData, javax.swing.BoxLayout.Y_AXIS));

        cardInputData.setLayout(new java.awt.CardLayout());

        dataDiri.setLayout(new javax.swing.BoxLayout(dataDiri, javax.swing.BoxLayout.Y_AXIS));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 1, 1));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.Y_AXIS));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(32767, 230));
        jPanel3.setMinimumSize(new java.awt.Dimension(770, 230));
        jPanel3.setPreferredSize(new java.awt.Dimension(982, 80));
        jPanel3.setLayout(new java.awt.GridLayout(2, 0));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(1004, 69));

        jLabel89.setFont(new java.awt.Font("Poppins Black", 0, 30)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(3, 155, 216));
        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setText("DATA DIRI");
        jLabel89.setToolTipText("");
        jPanel6.add(jLabel89);

        jPanel3.add(jPanel6);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1004, 69));

        jLabel90.setFont(new java.awt.Font("Poppins", 0, 25)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(3, 155, 216));
        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel90.setText("Masukkan data diri sesuai dengan identitas masing-masing");
        jLabel90.setToolTipText("");
        jPanel2.add(jLabel90);

        jPanel3.add(jPanel2);

        jPanel4.add(jPanel3);

        jScrollPane2.setBorder(null);

        jPanel58.setBackground(new java.awt.Color(255, 255, 255));
        jPanel58.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 20, 1, 20));
        jPanel58.setPreferredSize(new java.awt.Dimension(1000, 300));
        jPanel58.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        dataPersonalPanel.setBackground(new java.awt.Color(255, 255, 255));
        dataPersonalPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Personal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins Medium", 0, 20)), javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 5))); // NOI18N
        dataPersonalPanel.setMinimumSize(new java.awt.Dimension(200, 400));
        dataPersonalPanel.setLayout(new java.awt.GridLayout(6, 0, 0, 8));

        jPanel67.setBackground(new java.awt.Color(255, 255, 255));
        jPanel67.setFont(new java.awt.Font("Poppins Medium", 0, 21)); // NOI18N
        jPanel67.setLayout(new javax.swing.BoxLayout(jPanel67, javax.swing.BoxLayout.LINE_AXIS));

        nik.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        nik.setLabelText("NIK");
        nik.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        nik.setPreferredSize(null);
        nik.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nikKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nikKeyReleased(evt);
            }
        });
        jPanel67.add(nik);

        dataPersonalPanel.add(jPanel67);

        jPanel70.setBackground(new java.awt.Color(255, 255, 255));
        jPanel70.setFont(new java.awt.Font("Poppins Medium", 0, 21)); // NOI18N
        jPanel70.setLayout(new javax.swing.BoxLayout(jPanel70, javax.swing.BoxLayout.LINE_AXIS));

        nama.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        nama.setLabelText("Nama");
        nama.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        nama.setPreferredSize(null);
        nama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                namaKeyReleased(evt);
            }
        });
        jPanel70.add(nama);

        dataPersonalPanel.add(jPanel70);

        jPanel71.setBackground(new java.awt.Color(255, 255, 255));
        jPanel71.setFont(new java.awt.Font("Poppins Medium", 0, 21)); // NOI18N
        jPanel71.setLayout(new java.awt.GridLayout(1, 2, 14, 0));

        jPanel77.setBackground(new java.awt.Color(255, 255, 255));
        jPanel77.setFont(new java.awt.Font("Poppins Medium", 0, 21)); // NOI18N
        jPanel77.setLayout(new javax.swing.BoxLayout(jPanel77, javax.swing.BoxLayout.LINE_AXIS));

        umur.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        umur.setLabelText("Umur");
        umur.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        umur.setPreferredSize(null);
        umur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                umurKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                umurKeyReleased(evt);
            }
        });
        jPanel77.add(umur);

        jPanel71.add(jPanel77);

        jPanel78.setBackground(new java.awt.Color(255, 255, 255));
        jPanel78.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Jenis Kelamin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins Thin", 0, 13)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 10, 10))); // NOI18N
        jPanel78.setFont(new java.awt.Font("Poppins Medium", 0, 21)); // NOI18N
        jPanel78.setMaximumSize(new java.awt.Dimension(2147483647, 100));
        jPanel78.setLayout(new java.awt.GridLayout(1, 0));

        jenisKelamin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Laki-Laki", "Perempuan" }));
        jenisKelamin.setSelectedIndex(-1);
        jenisKelamin.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jenisKelamin.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        jenisKelamin.setPreferredSize(null);
        jenisKelamin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jenisKelaminKeyReleased(evt);
            }
        });
        jPanel78.add(jenisKelamin);

        jPanel71.add(jPanel78);

        dataPersonalPanel.add(jPanel71);

        jPanel72.setBackground(new java.awt.Color(255, 255, 255));
        jPanel72.setFont(new java.awt.Font("Poppins Medium", 0, 21)); // NOI18N
        jPanel72.setLayout(new javax.swing.BoxLayout(jPanel72, javax.swing.BoxLayout.LINE_AXIS));

        alamat.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        alamat.setLabelText("Alamat");
        alamat.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        alamat.setPreferredSize(null);
        alamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                alamatKeyReleased(evt);
            }
        });
        jPanel72.add(alamat);

        dataPersonalPanel.add(jPanel72);

        jPanel75.setBackground(new java.awt.Color(255, 255, 255));
        jPanel75.setFont(new java.awt.Font("Poppins Medium", 0, 21)); // NOI18N
        jPanel75.setLayout(new javax.swing.BoxLayout(jPanel75, javax.swing.BoxLayout.LINE_AXIS));

        nomorTelephone.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        nomorTelephone.setLabelText("Nomor Telephone");
        nomorTelephone.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        nomorTelephone.setPreferredSize(null);
        nomorTelephone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomorTelephoneKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomorTelephoneKeyReleased(evt);
            }
        });
        jPanel75.add(nomorTelephone);

        dataPersonalPanel.add(jPanel75);

        jPanel76.setBackground(new java.awt.Color(255, 255, 255));
        jPanel76.setFont(new java.awt.Font("Poppins Medium", 0, 21)); // NOI18N
        jPanel76.setLayout(new javax.swing.BoxLayout(jPanel76, javax.swing.BoxLayout.LINE_AXIS));

        pekerjaan.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        pekerjaan.setLabelText("Pekerjaan");
        pekerjaan.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        pekerjaan.setPreferredSize(null);
        pekerjaan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pekerjaanKeyReleased(evt);
            }
        });
        jPanel76.add(pekerjaan);

        dataPersonalPanel.add(jPanel76);

        jPanel58.add(dataPersonalPanel);

        dataPekerjaanPanel.setBackground(new java.awt.Color(255, 255, 255));
        dataPekerjaanPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Pekerjaan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins Medium", 0, 20)), javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 5))); // NOI18N
        dataPekerjaanPanel.setMinimumSize(new java.awt.Dimension(200, 400));
        dataPekerjaanPanel.setLayout(new java.awt.GridLayout(6, 0, 0, 8));

        jPanel82.setBackground(new java.awt.Color(255, 255, 255));
        jPanel82.setFont(new java.awt.Font("Poppins Medium", 0, 21)); // NOI18N
        jPanel82.setLayout(new java.awt.GridLayout(1, 2, 14, 0));

        jPanel83.setBackground(new java.awt.Color(255, 255, 255));
        jPanel83.setFont(new java.awt.Font("Poppins Medium", 0, 21)); // NOI18N
        jPanel83.setLayout(new javax.swing.BoxLayout(jPanel83, javax.swing.BoxLayout.LINE_AXIS));

        lamaBekerja.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        lamaBekerja.setLabelText("Lama Bekerja (Tahun)");
        lamaBekerja.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        lamaBekerja.setPreferredSize(null);
        lamaBekerja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lamaBekerjaKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lamaBekerjaKeyReleased(evt);
            }
        });
        jPanel83.add(lamaBekerja);

        jPanel82.add(jPanel83);

        jPanel84.setBackground(new java.awt.Color(255, 255, 255));
        jPanel84.setFont(new java.awt.Font("Poppins Medium", 0, 21)); // NOI18N
        jPanel84.setLayout(new javax.swing.BoxLayout(jPanel84, javax.swing.BoxLayout.LINE_AXIS));

        durasiBekerja.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        durasiBekerja.setLabelText("Durasi Kerja / Hari (Jam)");
        durasiBekerja.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        durasiBekerja.setPreferredSize(null);
        durasiBekerja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                durasiBekerjaKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                durasiBekerjaKeyReleased(evt);
            }
        });
        jPanel84.add(durasiBekerja);

        jPanel82.add(jPanel84);

        dataPekerjaanPanel.add(jPanel82);

        jPanel85.setBackground(new java.awt.Color(255, 255, 255));
        jPanel85.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Jenis Kerja", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins Thin", 0, 13)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 10, 10))); // NOI18N
        jPanel85.setFont(new java.awt.Font("Poppins Medium", 0, 21)); // NOI18N
        jPanel85.setMaximumSize(new java.awt.Dimension(2147483647, 100));
        jPanel85.setLayout(new javax.swing.BoxLayout(jPanel85, javax.swing.BoxLayout.LINE_AXIS));

        jenisKerja.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Berdiri", "Duduk" }));
        jenisKerja.setSelectedIndex(-1);
        jenisKerja.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jenisKerja.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        jenisKerja.setPreferredSize(null);
        jenisKerja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jenisKerjaKeyReleased(evt);
            }
        });
        jPanel85.add(jenisKerja);

        dataPekerjaanPanel.add(jPanel85);

        jPanel81.setBackground(new java.awt.Color(255, 255, 255));
        jPanel81.setFont(new java.awt.Font("Poppins Medium", 0, 21)); // NOI18N
        jPanel81.setLayout(new javax.swing.BoxLayout(jPanel81, javax.swing.BoxLayout.LINE_AXIS));

        keluhan.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        keluhan.setLabelText("Keluhan");
        keluhan.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        keluhan.setPreferredSize(null);
        keluhan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                keluhanKeyReleased(evt);
            }
        });
        jPanel81.add(keluhan);

        dataPekerjaanPanel.add(jPanel81);

        jPanel58.add(dataPekerjaanPanel);

        jScrollPane2.setViewportView(jPanel58);

        jPanel4.add(jScrollPane2);

        blank.setBackground(new java.awt.Color(255, 255, 255));
        blank.setMaximumSize(new java.awt.Dimension(32767, 30));
        blank.setPreferredSize(new java.awt.Dimension(1281, 30));

        javax.swing.GroupLayout blankLayout = new javax.swing.GroupLayout(blank);
        blank.setLayout(blankLayout);
        blankLayout.setHorizontalGroup(
            blankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1396, Short.MAX_VALUE)
        );
        blankLayout.setVerticalGroup(
            blankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel4.add(blank);

        dataDiri.add(jPanel4);

        cardInputData.add(dataDiri, "card1");

        pilihSisi.setBackground(new java.awt.Color(255, 255, 255));
        pilihSisi.setLayout(new javax.swing.BoxLayout(pilihSisi, javax.swing.BoxLayout.Y_AXIS));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(20, 1, 1, 1)));
        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.Y_AXIS));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setMaximumSize(new java.awt.Dimension(32767, 230));
        jPanel7.setMinimumSize(new java.awt.Dimension(770, 230));
        jPanel7.setPreferredSize(new java.awt.Dimension(982, 80));
        jPanel7.setLayout(new java.awt.GridLayout(2, 0));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(1004, 69));

        jLabel109.setFont(new java.awt.Font("Poppins Black", 0, 30)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(3, 155, 216));
        jLabel109.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel109.setText("POSISI BADAN");
        jLabel109.setToolTipText("");
        jPanel8.add(jLabel109);

        jPanel7.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(1004, 69));

        jLabel110.setFont(new java.awt.Font("Poppins", 0, 25)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(3, 155, 216));
        jLabel110.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel110.setText("Lihat dengan teliti posisi badan pada data yang akan diinput");
        jLabel110.setToolTipText("");
        jPanel9.add(jLabel110);

        jPanel7.add(jPanel9);

        jPanel12.add(jPanel7);

        jScrollPane3.setBorder(null);

        panelGrupSisiBadan.setBackground(new java.awt.Color(255, 255, 255));
        panelGrupSisiBadan.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(30, 20, 30, 20)));
        panelGrupSisiBadan.setLayout(new java.awt.GridLayout(1, 2, 20, 0));

        panelSisiKiri.setBackground(new java.awt.Color(255, 255, 255));
        panelSisiKiri.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kiri", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 30)), null)); // NOI18N
        panelSisiKiri.setLayout(new java.awt.GridLayout(1, 0));

        btnArahKiri.setBackground(new java.awt.Color(255, 255, 255));
        sisiBadan.add(btnArahKiri);
        btnArahKiri.setFont(new java.awt.Font("Google Sans", 1, 24)); // NOI18N
        btnArahKiri.setContentAreaFilled(false);
        btnArahKiri.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnArahKiri.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnArahKiri.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnArahKiri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/left_side_final.png"))); // NOI18N
        btnArahKiri.setIconTextGap(30);
        btnArahKiri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnArahKiriMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnArahKiriMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnArahKiriMouseEntered(evt);
            }
        });
        btnArahKiri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArahKiriActionPerformed(evt);
            }
        });
        panelSisiKiri.add(btnArahKiri);

        panelGrupSisiBadan.add(panelSisiKiri);

        panelSisiKanan.setBackground(new java.awt.Color(255, 255, 255));
        panelSisiKanan.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kanan", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 30)), null)); // NOI18N
        panelSisiKanan.setLayout(new java.awt.GridLayout(1, 0));

        btnArahKanan.setBackground(new java.awt.Color(255, 255, 255));
        sisiBadan.add(btnArahKanan);
        btnArahKanan.setFont(new java.awt.Font("Google Sans", 1, 24)); // NOI18N
        btnArahKanan.setContentAreaFilled(false);
        btnArahKanan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnArahKanan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnArahKanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/right_side_final.png"))); // NOI18N
        btnArahKanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnArahKananMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnArahKananMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnArahKananMouseEntered(evt);
            }
        });
        btnArahKanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArahKananActionPerformed(evt);
            }
        });
        panelSisiKanan.add(btnArahKanan);

        panelGrupSisiBadan.add(panelSisiKanan);

        jScrollPane3.setViewportView(panelGrupSisiBadan);

        jPanel12.add(jScrollPane3);

        pilihSisi.add(jPanel12);

        cardInputData.add(pilihSisi, "card2");

        lenganAtas.setBackground(new java.awt.Color(255, 255, 255));
        lenganAtas.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(30, 20, 30, 20)));
        lenganAtas.setLayout(new javax.swing.BoxLayout(lenganAtas, javax.swing.BoxLayout.Y_AXIS));

        jPanel25.setLayout(new javax.swing.BoxLayout(jPanel25, javax.swing.BoxLayout.Y_AXIS));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setMaximumSize(new java.awt.Dimension(32767, 230));
        jPanel13.setMinimumSize(new java.awt.Dimension(770, 230));
        jPanel13.setPreferredSize(new java.awt.Dimension(982, 80));
        jPanel13.setLayout(new java.awt.GridLayout(2, 0));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setPreferredSize(new java.awt.Dimension(1004, 69));

        jLabel111.setFont(new java.awt.Font("Poppins Black", 0, 30)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(3, 155, 216));
        jLabel111.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel111.setText("LENGAN ATAS");
        jLabel111.setToolTipText("");
        jPanel14.add(jLabel111);

        jPanel13.add(jPanel14);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setPreferredSize(new java.awt.Dimension(1004, 69));

        jLabel112.setFont(new java.awt.Font("Poppins", 0, 25)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(3, 155, 216));
        jLabel112.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel112.setText("Lihat dengan teliti posisi lengan atas pada data yang akan diinput");
        jLabel112.setToolTipText("");
        jPanel15.add(jLabel112);

        jPanel13.add(jPanel15);

        jPanel25.add(jPanel13);

        jScrollPane5.setBorder(null);

        panelGrupLenganAtas.setBackground(new java.awt.Color(255, 255, 255));
        panelGrupLenganAtas.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 30, 1), javax.swing.BorderFactory.createEmptyBorder(30, 0, 1, 0)));
        panelGrupLenganAtas.setLayout(new java.awt.GridLayout(2, 1, 0, 10));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new java.awt.GridLayout(1, 3, 10, 0));

        coLA1.setBackground(new java.awt.Color(255, 255, 255));
        coLA1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), null)); // NOI18N
        coLA1.setLayout(new java.awt.GridLayout(1, 0));

        lenganAtasGrup.add(btnLA6);
        btnLA6.setContentAreaFilled(false);
        btnLA6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLA6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLA6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLA6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/upperarm1_final.png"))); // NOI18N
        btnLA6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLA6MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLA6MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLA6MouseEntered(evt);
            }
        });
        btnLA6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLA6ActionPerformed(evt);
            }
        });
        coLA1.add(btnLA6);

        jPanel10.add(coLA1);

        coLA2.setBackground(new java.awt.Color(255, 255, 255));
        coLA2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), null)); // NOI18N
        coLA2.setLayout(new java.awt.GridLayout(1, 0));

        lenganAtasGrup.add(btnLA7);
        btnLA7.setContentAreaFilled(false);
        btnLA7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLA7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLA7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLA7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/upperarm2_final.png"))); // NOI18N
        btnLA7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLA7MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLA7MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLA7MouseEntered(evt);
            }
        });
        btnLA7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLA7ActionPerformed(evt);
            }
        });
        coLA2.add(btnLA7);

        jPanel10.add(coLA2);

        coLA3.setBackground(new java.awt.Color(255, 255, 255));
        coLA3.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), null)); // NOI18N
        coLA3.setLayout(new java.awt.GridLayout(1, 0));

        lenganAtasGrup.add(btnLA8);
        btnLA8.setContentAreaFilled(false);
        btnLA8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLA8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLA8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLA8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/upperarm3_final.png"))); // NOI18N
        btnLA8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLA8MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLA8MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLA8MouseEntered(evt);
            }
        });
        btnLA8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLA8ActionPerformed(evt);
            }
        });
        coLA3.add(btnLA8);

        jPanel10.add(coLA3);

        panelGrupLenganAtas.add(jPanel10);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        coLA4.setBackground(new java.awt.Color(255, 255, 255));
        coLA4.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), null)); // NOI18N
        coLA4.setLayout(new java.awt.GridLayout(1, 0));

        lenganAtasGrup.add(btnLA9);
        btnLA9.setContentAreaFilled(false);
        btnLA9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLA9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLA9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLA9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/upperarm4_final.png"))); // NOI18N
        btnLA9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLA9MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLA9MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLA9MouseEntered(evt);
            }
        });
        btnLA9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLA9ActionPerformed(evt);
            }
        });
        coLA4.add(btnLA9);

        jPanel11.add(coLA4);

        coLA5.setBackground(new java.awt.Color(255, 255, 255));
        coLA5.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 4", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), null)); // NOI18N
        coLA5.setLayout(new java.awt.GridLayout(1, 0));

        lenganAtasGrup.add(btnLA10);
        btnLA10.setContentAreaFilled(false);
        btnLA10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLA10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLA10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLA10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/upperarm5_final.png"))); // NOI18N
        btnLA10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLA10MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLA10MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLA10MouseEntered(evt);
            }
        });
        btnLA10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLA10ActionPerformed(evt);
            }
        });
        coLA5.add(btnLA10);

        jPanel11.add(coLA5);

        panelGrupLenganAtas.add(jPanel11);

        jScrollPane5.setViewportView(panelGrupLenganAtas);

        jPanel25.add(jScrollPane5);

        lenganAtasTambahanPanel.setBackground(new java.awt.Color(255, 255, 255));
        lenganAtasTambahanPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Tambahan", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Poppins Medium", 0, 21)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10))); // NOI18N
        lenganAtasTambahanPanel.setMaximumSize(new java.awt.Dimension(32767, 98));
        lenganAtasTambahanPanel.setLayout(new java.awt.GridLayout(1, 3, 10, 0));

        coAddLA1.setBackground(new java.awt.Color(255, 255, 255));
        coAddLA1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bahu dinaikan ke atas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        coAddLA1.setLayout(new java.awt.GridLayout(1, 0));

        secDataLA1.setBackground(new java.awt.Color(255, 255, 255));
        secDataLA1.setContentAreaFilled(false);
        secDataLA1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secDataLA1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        secDataLA1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        secDataLA1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        secDataLA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secDataLA1ActionPerformed(evt);
            }
        });
        coAddLA1.add(secDataLA1);

        lenganAtasTambahanPanel.add(coAddLA1);

        coAddLA2.setBackground(new java.awt.Color(255, 255, 255));
        coAddLA2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lengan atas ditopang atau bersandar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        coAddLA2.setLayout(new java.awt.GridLayout(1, 0));

        secDataLA2.setBackground(new java.awt.Color(255, 255, 255));
        secDataLA2.setContentAreaFilled(false);
        secDataLA2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secDataLA2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        secDataLA2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        secDataLA2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        secDataLA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secDataLA2ActionPerformed(evt);
            }
        });
        coAddLA2.add(secDataLA2);

        lenganAtasTambahanPanel.add(coAddLA2);

        coAddLA3.setBackground(new java.awt.Color(255, 255, 255));
        coAddLA3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lengan atas di abduksi", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 14))); // NOI18N
        coAddLA3.setLayout(new java.awt.GridLayout(1, 0));

        secDataLA3.setBackground(new java.awt.Color(255, 255, 255));
        secDataLA3.setContentAreaFilled(false);
        secDataLA3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secDataLA3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        secDataLA3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        secDataLA3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        secDataLA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secDataLA3ActionPerformed(evt);
            }
        });
        coAddLA3.add(secDataLA3);

        lenganAtasTambahanPanel.add(coAddLA3);

        jPanel25.add(lenganAtasTambahanPanel);

        lenganAtas.add(jPanel25);

        cardInputData.add(lenganAtas, "card3");

        lenganBawah.setBackground(new java.awt.Color(255, 255, 255));
        lenganBawah.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(30, 20, 30, 20)));
        lenganBawah.setLayout(new javax.swing.BoxLayout(lenganBawah, javax.swing.BoxLayout.Y_AXIS));

        jPanel16.setLayout(new javax.swing.BoxLayout(jPanel16, javax.swing.BoxLayout.Y_AXIS));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setMaximumSize(new java.awt.Dimension(32767, 230));
        jPanel17.setMinimumSize(new java.awt.Dimension(770, 230));
        jPanel17.setPreferredSize(new java.awt.Dimension(982, 80));
        jPanel17.setLayout(new java.awt.GridLayout(2, 0));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setPreferredSize(new java.awt.Dimension(1004, 69));

        jLabel113.setFont(new java.awt.Font("Poppins Black", 0, 30)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(3, 155, 216));
        jLabel113.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel113.setText("LENGAN BAWAH");
        jLabel113.setToolTipText("");
        jPanel18.add(jLabel113);

        jPanel17.add(jPanel18);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setPreferredSize(new java.awt.Dimension(1004, 69));

        jLabel114.setFont(new java.awt.Font("Poppins", 0, 25)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(3, 155, 216));
        jLabel114.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel114.setText("Lihat dengan teliti posisi lengan bawah pada data yang akan diinput");
        jLabel114.setToolTipText("");
        jPanel20.add(jLabel114);

        jPanel17.add(jPanel20);

        jPanel16.add(jPanel17);

        jScrollPane4.setBorder(null);

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(30, 0, 30, 0)));
        jPanel37.setLayout(new java.awt.GridLayout(1, 3, 10, 0));

        coLB1.setBackground(new java.awt.Color(255, 255, 255));
        coLB1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), null)); // NOI18N
        coLB1.setLayout(new java.awt.GridLayout(1, 0));

        lenganBawahGrup.add(btnLB1);
        btnLB1.setContentAreaFilled(false);
        btnLB1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLB1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLB1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLB1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/lowerarm1_final.png"))); // NOI18N
        btnLB1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnLB1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLB1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLB1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLB1MouseEntered(evt);
            }
        });
        btnLB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLB1ActionPerformed(evt);
            }
        });
        coLB1.add(btnLB1);

        jPanel37.add(coLB1);

        coLB2.setBackground(new java.awt.Color(255, 255, 255));
        coLB2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), null)); // NOI18N
        coLB2.setLayout(new java.awt.GridLayout(1, 0));

        lenganBawahGrup.add(btnLB2);
        btnLB2.setContentAreaFilled(false);
        btnLB2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLB2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLB2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLB2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/lowerarm2_final.png"))); // NOI18N
        btnLB2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnLB2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLB2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLB2MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLB2MouseEntered(evt);
            }
        });
        btnLB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLB2ActionPerformed(evt);
            }
        });
        coLB2.add(btnLB2);

        jPanel37.add(coLB2);

        coLB3.setBackground(new java.awt.Color(255, 255, 255));
        coLB3.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), null)); // NOI18N
        coLB3.setLayout(new java.awt.GridLayout(1, 0));

        lenganBawahGrup.add(btnLB3);
        btnLB3.setContentAreaFilled(false);
        btnLB3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLB3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLB3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLB3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/lowerarm3_final.png"))); // NOI18N
        btnLB3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnLB3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLB3MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLB3MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLB3MouseEntered(evt);
            }
        });
        btnLB3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLB3ActionPerformed(evt);
            }
        });
        coLB3.add(btnLB3);

        jPanel37.add(coLB3);

        jScrollPane4.setViewportView(jPanel37);

        jPanel16.add(jScrollPane4);

        lenganBawahTambahanPanel.setBackground(new java.awt.Color(255, 255, 255));
        lenganBawahTambahanPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Tambahan", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Poppins Medium", 0, 21)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10))); // NOI18N
        lenganBawahTambahanPanel.setMaximumSize(new java.awt.Dimension(32767, 230));
        lenganBawahTambahanPanel.setLayout(new java.awt.GridLayout(1, 0));

        coAddLB1.setBackground(new java.awt.Color(255, 255, 255));
        coAddLB1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Salah satu tangan bekerja melintasi garis tengah atau kesamping tubuh", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 14)), null)); // NOI18N
        coAddLB1.setLayout(new java.awt.GridLayout(1, 0));

        secDataLB.setContentAreaFilled(false);
        secDataLB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secDataLB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/lowerarm4_final.png"))); // NOI18N
        secDataLB.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        secDataLB.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        secDataLB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secDataLBActionPerformed(evt);
            }
        });
        coAddLB1.add(secDataLB);

        lenganBawahTambahanPanel.add(coAddLB1);

        jPanel16.add(lenganBawahTambahanPanel);

        lenganBawah.add(jPanel16);

        cardInputData.add(lenganBawah, "card4");

        pergelanganTangan.setBackground(new java.awt.Color(255, 255, 255));
        pergelanganTangan.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(30, 20, 30, 20)));
        pergelanganTangan.setLayout(new javax.swing.BoxLayout(pergelanganTangan, javax.swing.BoxLayout.Y_AXIS));

        jPanel32.setLayout(new javax.swing.BoxLayout(jPanel32, javax.swing.BoxLayout.Y_AXIS));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setMaximumSize(new java.awt.Dimension(32767, 230));
        jPanel19.setMinimumSize(new java.awt.Dimension(770, 230));
        jPanel19.setPreferredSize(new java.awt.Dimension(982, 80));
        jPanel19.setLayout(new java.awt.GridLayout(2, 0));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setPreferredSize(new java.awt.Dimension(1004, 69));

        jLabel115.setFont(new java.awt.Font("Poppins Black", 0, 30)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(3, 155, 216));
        jLabel115.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel115.setText("PERGELANGAN TANGAN");
        jLabel115.setToolTipText("");
        jPanel21.add(jLabel115);

        jPanel19.add(jPanel21);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setPreferredSize(new java.awt.Dimension(1004, 69));

        jLabel116.setFont(new java.awt.Font("Poppins", 0, 25)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(3, 155, 216));
        jLabel116.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel116.setText("Lihat dengan teliti posisi pergelangan tangan pada data yang akan diinput");
        jLabel116.setToolTipText("");
        jPanel22.add(jLabel116);

        jPanel19.add(jPanel22);

        jPanel32.add(jPanel19);

        jScrollPane6.setBorder(null);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(30, 0, 30, 0)));
        jPanel23.setLayout(new java.awt.GridLayout(1, 4, 10, 0));

        coPT1.setBackground(new java.awt.Color(255, 255, 255));
        coPT1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), null)); // NOI18N
        coPT1.setLayout(new java.awt.GridLayout(1, 0));

        pergelanganTanganGrup.add(btnPT1);
        btnPT1.setContentAreaFilled(false);
        btnPT1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPT1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPT1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPT1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/wrist1_final.png"))); // NOI18N
        btnPT1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnPT1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPT1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPT1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPT1MouseEntered(evt);
            }
        });
        btnPT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPT1ActionPerformed(evt);
            }
        });
        coPT1.add(btnPT1);

        jPanel23.add(coPT1);

        coPT2.setBackground(new java.awt.Color(255, 255, 255));
        coPT2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), null)); // NOI18N
        coPT2.setLayout(new java.awt.GridLayout(1, 0));

        pergelanganTanganGrup.add(btnPT2);
        btnPT2.setContentAreaFilled(false);
        btnPT2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPT2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPT2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPT2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/wrist2_final.png"))); // NOI18N
        btnPT2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnPT2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPT2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPT2MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPT2MouseEntered(evt);
            }
        });
        btnPT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPT2ActionPerformed(evt);
            }
        });
        coPT2.add(btnPT2);

        jPanel23.add(coPT2);

        coPT3.setBackground(new java.awt.Color(255, 255, 255));
        coPT3.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), null)); // NOI18N
        coPT3.setLayout(new java.awt.GridLayout(1, 0));

        pergelanganTanganGrup.add(btnPT3);
        btnPT3.setContentAreaFilled(false);
        btnPT3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPT3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPT3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPT3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/wrist3_final.png"))); // NOI18N
        btnPT3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnPT3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPT3MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPT3MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPT3MouseEntered(evt);
            }
        });
        btnPT3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPT3ActionPerformed(evt);
            }
        });
        coPT3.add(btnPT3);

        jPanel23.add(coPT3);

        coPT4.setBackground(new java.awt.Color(255, 255, 255));
        coPT4.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), null)); // NOI18N
        coPT4.setLayout(new java.awt.GridLayout(1, 0));

        pergelanganTanganGrup.add(btnPT4);
        btnPT4.setContentAreaFilled(false);
        btnPT4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPT4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPT4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPT4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/wrist4_final.png"))); // NOI18N
        btnPT4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnPT4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPT4MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPT4MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPT4MouseEntered(evt);
            }
        });
        btnPT4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPT4ActionPerformed(evt);
            }
        });
        coPT4.add(btnPT4);

        jPanel23.add(coPT4);

        jScrollPane6.setViewportView(jPanel23);

        jPanel32.add(jScrollPane6);

        pergelanganTanganTambahanPanel.setBackground(new java.awt.Color(255, 255, 255));
        pergelanganTanganTambahanPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Tambahan", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Poppins Medium", 0, 21)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10))); // NOI18N
        pergelanganTanganTambahanPanel.setMaximumSize(new java.awt.Dimension(32767, 199));
        pergelanganTanganTambahanPanel.setLayout(new java.awt.GridLayout(1, 0));

        coAddPT1.setBackground(new java.awt.Color(255, 255, 255));
        coAddPT1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pergelangan tangan ditekuk menjauh dari garis tengah", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 14)), null)); // NOI18N
        coAddPT1.setLayout(new java.awt.GridLayout(1, 0));

        secDataPT.setContentAreaFilled(false);
        secDataPT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secDataPT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        secDataPT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/wrist5_final.png"))); // NOI18N
        secDataPT.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        secDataPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secDataPTActionPerformed(evt);
            }
        });
        coAddPT1.add(secDataPT);

        pergelanganTanganTambahanPanel.add(coAddPT1);

        jPanel32.add(pergelanganTanganTambahanPanel);

        pergelanganTangan.add(jPanel32);

        cardInputData.add(pergelanganTangan, "card5");

        putarPergelanganTangan.setBackground(new java.awt.Color(255, 255, 255));
        putarPergelanganTangan.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(30, 20, 30, 20)));
        putarPergelanganTangan.setLayout(new javax.swing.BoxLayout(putarPergelanganTangan, javax.swing.BoxLayout.Y_AXIS));

        jPanel35.setLayout(new javax.swing.BoxLayout(jPanel35, javax.swing.BoxLayout.Y_AXIS));

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setMaximumSize(new java.awt.Dimension(32767, 230));
        jPanel24.setMinimumSize(new java.awt.Dimension(770, 230));
        jPanel24.setPreferredSize(new java.awt.Dimension(982, 80));
        jPanel24.setLayout(new java.awt.GridLayout(2, 0));

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setPreferredSize(new java.awt.Dimension(1004, 69));

        jLabel117.setFont(new java.awt.Font("Poppins Black", 0, 30)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(3, 155, 216));
        jLabel117.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel117.setText("PUTAR PERGELANGAN TANGAN");
        jLabel117.setToolTipText("");
        jPanel26.add(jLabel117);

        jPanel24.add(jPanel26);

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setPreferredSize(new java.awt.Dimension(1004, 69));

        jLabel118.setFont(new java.awt.Font("Poppins", 0, 25)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(3, 155, 216));
        jLabel118.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel118.setText("Lihat dengan teliti putaran pergelangan tangan pada data yang akan diinput");
        jLabel118.setToolTipText("");
        jPanel27.add(jLabel118);

        jPanel24.add(jPanel27);

        jPanel35.add(jPanel24);

        jScrollPane7.setBorder(null);

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(30, 1, 30, 1)));
        jPanel28.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        coPPT1.setBackground(new java.awt.Color(255, 255, 255));
        coPPT1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tidak memutar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 30)), null)); // NOI18N
        coPPT1.setLayout(new java.awt.GridLayout(1, 0));

        putarPergelanganTanganGrup.add(btnPPT1);
        btnPPT1.setContentAreaFilled(false);
        btnPPT1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPPT1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPPT1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPPT1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/wrist_twist1_final.png"))); // NOI18N
        btnPPT1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPPT1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPPT1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPPT1MouseEntered(evt);
            }
        });
        btnPPT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPPT1ActionPerformed(evt);
            }
        });
        coPPT1.add(btnPPT1);

        jPanel28.add(coPPT1);

        coPPT2.setBackground(new java.awt.Color(255, 255, 255));
        coPPT2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Memutar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 30)), null)); // NOI18N
        coPPT2.setLayout(new java.awt.GridLayout(1, 0));

        putarPergelanganTanganGrup.add(btnPPT2);
        btnPPT2.setContentAreaFilled(false);
        btnPPT2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPPT2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPPT2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPPT2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/wrist_twist2_final.png"))); // NOI18N
        btnPPT2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPPT2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPPT2MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPPT2MouseEntered(evt);
            }
        });
        btnPPT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPPT2ActionPerformed(evt);
            }
        });
        coPPT2.add(btnPPT2);

        jPanel28.add(coPPT2);

        jScrollPane7.setViewportView(jPanel28);

        jPanel35.add(jScrollPane7);

        putarPergelanganTangan.add(jPanel35);

        cardInputData.add(putarPergelanganTangan, "card6");

        tambahan1.setBackground(new java.awt.Color(255, 255, 255));
        tambahan1.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(30, 20, 30, 20)));
        tambahan1.setLayout(new javax.swing.BoxLayout(tambahan1, javax.swing.BoxLayout.Y_AXIS));

        jPanel282.setLayout(new javax.swing.BoxLayout(jPanel282, javax.swing.BoxLayout.Y_AXIS));

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31.setMaximumSize(new java.awt.Dimension(32767, 230));
        jPanel31.setMinimumSize(new java.awt.Dimension(770, 230));
        jPanel31.setPreferredSize(new java.awt.Dimension(982, 80));
        jPanel31.setLayout(new java.awt.GridLayout(2, 0));

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));
        jPanel33.setPreferredSize(new java.awt.Dimension(1004, 69));

        jLabel119.setFont(new java.awt.Font("Poppins Black", 0, 30)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(3, 155, 216));
        jLabel119.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel119.setText("DATA TAMBAHAN 1");
        jLabel119.setToolTipText("");
        jPanel33.add(jLabel119);

        jPanel31.add(jPanel33);

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));
        jPanel34.setPreferredSize(new java.awt.Dimension(1004, 69));

        jLabel120.setFont(new java.awt.Font("Poppins", 0, 25)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(3, 155, 216));
        jLabel120.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel120.setText("Berikut ini merupakan data yang bersifat opsional");
        jLabel120.setToolTipText("");
        jPanel34.add(jLabel120);

        jPanel31.add(jPanel34);

        jPanel282.add(jPanel31);

        jScrollPane10.setBorder(null);

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));
        jPanel36.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(30, 0, 30, 0)));
        jPanel36.setLayout(new java.awt.GridLayout(2, 2, 10, 10));

        coDT11.setBackground(new java.awt.Color(255, 255, 255));
        coDT11.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 0", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1))); // NOI18N
        coDT11.setLayout(new java.awt.GridLayout(1, 0));

        dataTambahan1.add(tambahanData1);
        tambahanData1.setFont(new java.awt.Font("Poppins", 0, 21)); // NOI18N
        tambahanData1.setText("<html>- Tidak ada perlawanan<br>- Beban kurang dari 2Kg</html>");
        tambahanData1.setContentAreaFilled(false);
        tambahanData1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tambahanData1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tambahanData1.setIconTextGap(10);
        tambahanData1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        tambahanData1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tambahanData1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tambahanData1MouseEntered(evt);
            }
        });
        tambahanData1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahanData1ActionPerformed(evt);
            }
        });
        coDT11.add(tambahanData1);

        jPanel36.add(coDT11);

        coDT12.setBackground(new java.awt.Color(255, 255, 255));
        coDT12.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1))); // NOI18N
        coDT12.setLayout(new java.awt.GridLayout(1, 0));

        dataTambahan1.add(tambahanData2);
        tambahanData2.setFont(new java.awt.Font("Poppins", 0, 21)); // NOI18N
        tambahanData2.setText("<html>- Beban 2Kg sampai 10Kg</html>");
        tambahanData2.setContentAreaFilled(false);
        tambahanData2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tambahanData2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tambahanData2.setIconTextGap(10);
        tambahanData2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        tambahanData2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tambahanData2MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tambahanData2MouseEntered(evt);
            }
        });
        tambahanData2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahanData2ActionPerformed(evt);
            }
        });
        coDT12.add(tambahanData2);

        jPanel36.add(coDT12);

        coDT13.setBackground(new java.awt.Color(255, 255, 255));
        coDT13.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1))); // NOI18N
        coDT13.setLayout(new java.awt.GridLayout(1, 0));

        dataTambahan1.add(tambahanData3);
        tambahanData3.setFont(new java.awt.Font("Poppins", 0, 21)); // NOI18N
        tambahanData3.setText("<html>- Beban statis 2Kg sampai 10Kg<br>- Beban kurang dari 2kg</html>");
        tambahanData3.setContentAreaFilled(false);
        tambahanData3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tambahanData3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tambahanData3.setIconTextGap(10);
        tambahanData3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        tambahanData3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tambahanData3MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tambahanData3MouseEntered(evt);
            }
        });
        tambahanData3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahanData3ActionPerformed(evt);
            }
        });
        coDT13.add(tambahanData3);

        jPanel36.add(coDT13);

        coDT14.setBackground(new java.awt.Color(255, 255, 255));
        coDT14.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1))); // NOI18N
        coDT14.setLayout(new java.awt.GridLayout(1, 0));

        dataTambahan1.add(tambahanData4);
        tambahanData4.setFont(new java.awt.Font("Poppins", 0, 21)); // NOI18N
        tambahanData4.setText("<html>- Beban lebih dari 10 Kg<br>- Shock atau berulang</html>");
        tambahanData4.setContentAreaFilled(false);
        tambahanData4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tambahanData4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tambahanData4.setIconTextGap(10);
        tambahanData4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        tambahanData4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tambahanData4MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tambahanData4MouseEntered(evt);
            }
        });
        tambahanData4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahanData4ActionPerformed(evt);
            }
        });
        coDT14.add(tambahanData4);

        jPanel36.add(coDT14);

        jScrollPane10.setViewportView(jPanel36);

        jPanel282.add(jScrollPane10);

        dataTambahan1Panel.setBackground(new java.awt.Color(255, 255, 255));
        dataTambahan1Panel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Tambahan", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Poppins Medium", 0, 21)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10))); // NOI18N
        dataTambahan1Panel.setMaximumSize(new java.awt.Dimension(32767, 107));
        dataTambahan1Panel.setLayout(new java.awt.GridLayout(1, 0));

        coAddDT1.setBackground(new java.awt.Color(255, 255, 255));
        coAddDT1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), null)); // NOI18N
        coAddDT1.setMaximumSize(new java.awt.Dimension(32767, 107));
        coAddDT1.setLayout(new java.awt.GridLayout(1, 0));

        tambahanData5.setFont(new java.awt.Font("Poppins", 0, 21)); // NOI18N
        tambahanData5.setText("<html>Jika postur terutama statis (yaitu ditahan > I menit), Atau jika tindakan berulang terjadi 4x per menit</html>");
        tambahanData5.setContentAreaFilled(false);
        tambahanData5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tambahanData5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tambahanData5.setIconTextGap(10);
        tambahanData5.setVerifyInputWhenFocusTarget(false);
        tambahanData5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        tambahanData5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        tambahanData5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tambahanData5MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tambahanData5MouseEntered(evt);
            }
        });
        tambahanData5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahanData5ActionPerformed(evt);
            }
        });
        coAddDT1.add(tambahanData5);

        dataTambahan1Panel.add(coAddDT1);

        jPanel282.add(dataTambahan1Panel);

        tambahan1.add(jPanel282);

        cardInputData.add(tambahan1, "card8");

        leher.setBackground(new java.awt.Color(255, 255, 255));
        leher.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(30, 20, 30, 20)));
        leher.setLayout(new javax.swing.BoxLayout(leher, javax.swing.BoxLayout.Y_AXIS));

        jPanel297.setLayout(new javax.swing.BoxLayout(jPanel297, javax.swing.BoxLayout.Y_AXIS));

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38.setMaximumSize(new java.awt.Dimension(32767, 230));
        jPanel38.setMinimumSize(new java.awt.Dimension(770, 230));
        jPanel38.setPreferredSize(new java.awt.Dimension(982, 80));
        jPanel38.setLayout(new java.awt.GridLayout(2, 0));

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setPreferredSize(new java.awt.Dimension(1004, 69));

        jLabel121.setFont(new java.awt.Font("Poppins Black", 0, 30)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(3, 155, 216));
        jLabel121.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel121.setText("LEHER");
        jLabel121.setToolTipText("");
        jPanel39.add(jLabel121);

        jPanel38.add(jPanel39);

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setPreferredSize(new java.awt.Dimension(1004, 69));

        jLabel122.setFont(new java.awt.Font("Poppins", 0, 25)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(3, 155, 216));
        jLabel122.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel122.setText("Pilih posisi leher sesuai dengan data yang akan diinput");
        jLabel122.setToolTipText("");
        jPanel40.add(jLabel122);

        jPanel38.add(jPanel40);

        jPanel297.add(jPanel38);

        jScrollPane11.setBorder(null);

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));
        jPanel41.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(30, 0, 30, 0)));
        jPanel41.setLayout(new java.awt.GridLayout(1, 4, 10, 0));

        coL1.setBackground(new java.awt.Color(255, 255, 255));
        coL1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), null)); // NOI18N
        coL1.setLayout(new java.awt.GridLayout(1, 0));

        leherGrup.add(btnL1);
        btnL1.setContentAreaFilled(false);
        btnL1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnL1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnL1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnL1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/neck1.png"))); // NOI18N
        btnL1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnL1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnL1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnL1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnL1MouseEntered(evt);
            }
        });
        btnL1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnL1ActionPerformed(evt);
            }
        });
        coL1.add(btnL1);

        jPanel41.add(coL1);

        coL2.setBackground(new java.awt.Color(255, 255, 255));
        coL2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), null)); // NOI18N
        coL2.setLayout(new java.awt.GridLayout(1, 0));

        leherGrup.add(btnL2);
        btnL2.setContentAreaFilled(false);
        btnL2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnL2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnL2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnL2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/neck2.png"))); // NOI18N
        btnL2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnL2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnL2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnL2MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnL2MouseEntered(evt);
            }
        });
        btnL2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnL2ActionPerformed(evt);
            }
        });
        coL2.add(btnL2);

        jPanel41.add(coL2);

        coL3.setBackground(new java.awt.Color(255, 255, 255));
        coL3.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), null)); // NOI18N
        coL3.setLayout(new java.awt.GridLayout(1, 0));

        leherGrup.add(btnL3);
        btnL3.setContentAreaFilled(false);
        btnL3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnL3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnL3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnL3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/neck3.png"))); // NOI18N
        btnL3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnL3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnL3MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnL3MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnL3MouseEntered(evt);
            }
        });
        btnL3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnL3ActionPerformed(evt);
            }
        });
        coL3.add(btnL3);

        jPanel41.add(coL3);

        coL4.setBackground(new java.awt.Color(255, 255, 255));
        coL4.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 4", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), null)); // NOI18N
        coL4.setLayout(new java.awt.GridLayout(1, 0));

        leherGrup.add(btnL4);
        btnL4.setContentAreaFilled(false);
        btnL4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnL4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnL4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnL4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/neck4.png"))); // NOI18N
        btnL4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnL4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnL4MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnL4MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnL4MouseEntered(evt);
            }
        });
        btnL4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnL4ActionPerformed(evt);
            }
        });
        coL4.add(btnL4);

        jPanel41.add(coL4);

        jScrollPane11.setViewportView(jPanel41);

        jPanel297.add(jScrollPane11);

        leherTambahanPanel.setBackground(new java.awt.Color(255, 255, 255));
        leherTambahanPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Tambahan", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Poppins Medium", 0, 21)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10))); // NOI18N
        leherTambahanPanel.setMaximumSize(new java.awt.Dimension(32767, 239));
        leherTambahanPanel.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        coAddL1.setBackground(new java.awt.Color(255, 255, 255));
        coAddL1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Leher memutar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 14)), null)); // NOI18N
        coAddL1.setLayout(new java.awt.GridLayout(1, 0));

        secDataL1.setContentAreaFilled(false);
        secDataL1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secDataL1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        secDataL1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/neck5.png"))); // NOI18N
        secDataL1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        secDataL1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                secDataL1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                secDataL1MouseEntered(evt);
            }
        });
        secDataL1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secDataL1ActionPerformed(evt);
            }
        });
        coAddL1.add(secDataL1);

        leherTambahanPanel.add(coAddL1);

        coAddL2.setBackground(new java.awt.Color(255, 255, 255));
        coAddL2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Leher menekuk kesamping", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 14)), null)); // NOI18N
        coAddL2.setLayout(new java.awt.GridLayout(1, 0));

        secDataL2.setContentAreaFilled(false);
        secDataL2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secDataL2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        secDataL2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/neck6.png"))); // NOI18N
        secDataL2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        secDataL2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                secDataL2MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                secDataL2MouseEntered(evt);
            }
        });
        secDataL2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secDataL2ActionPerformed(evt);
            }
        });
        coAddL2.add(secDataL2);

        leherTambahanPanel.add(coAddL2);

        jPanel297.add(leherTambahanPanel);

        leher.add(jPanel297);

        cardInputData.add(leher, "card9");

        badan.setBackground(new java.awt.Color(255, 255, 255));
        badan.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(30, 20, 30, 20)));
        badan.setLayout(new javax.swing.BoxLayout(badan, javax.swing.BoxLayout.Y_AXIS));

        jPanel308.setLayout(new javax.swing.BoxLayout(jPanel308, javax.swing.BoxLayout.Y_AXIS));

        jPanel42.setBackground(new java.awt.Color(255, 255, 255));
        jPanel42.setMaximumSize(new java.awt.Dimension(32767, 230));
        jPanel42.setMinimumSize(new java.awt.Dimension(770, 230));
        jPanel42.setPreferredSize(new java.awt.Dimension(982, 80));
        jPanel42.setLayout(new java.awt.GridLayout(2, 0));

        jPanel43.setBackground(new java.awt.Color(255, 255, 255));
        jPanel43.setPreferredSize(new java.awt.Dimension(1004, 69));

        jLabel123.setFont(new java.awt.Font("Poppins Black", 0, 30)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(3, 155, 216));
        jLabel123.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel123.setText("BADAN");
        jLabel123.setToolTipText("");
        jPanel43.add(jLabel123);

        jPanel42.add(jPanel43);

        jPanel44.setBackground(new java.awt.Color(255, 255, 255));
        jPanel44.setPreferredSize(new java.awt.Dimension(1004, 69));

        jLabel124.setFont(new java.awt.Font("Poppins", 0, 25)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(3, 155, 216));
        jLabel124.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel124.setText("Pilih postur tubuh sesuai dengan data yang akan diinput");
        jLabel124.setToolTipText("");
        jPanel44.add(jLabel124);

        jPanel42.add(jPanel44);

        jPanel308.add(jPanel42);

        jScrollPane12.setBorder(null);

        jPanel45.setBackground(new java.awt.Color(255, 255, 255));
        jPanel45.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(30, 0, 30, 0)));
        jPanel45.setLayout(new java.awt.GridLayout(1, 4, 10, 0));

        coB1.setBackground(new java.awt.Color(255, 255, 255));
        coB1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), null)); // NOI18N
        coB1.setLayout(new java.awt.GridLayout(1, 0));

        badanGrup.add(btnB1);
        btnB1.setContentAreaFilled(false);
        btnB1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnB1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnB1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnB1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/trunk1.png"))); // NOI18N
        btnB1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnB1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnB1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnB1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnB1MouseEntered(evt);
            }
        });
        btnB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB1ActionPerformed(evt);
            }
        });
        coB1.add(btnB1);

        jPanel45.add(coB1);

        coB2.setBackground(new java.awt.Color(255, 255, 255));
        coB2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), null)); // NOI18N
        coB2.setLayout(new java.awt.GridLayout(1, 0));

        badanGrup.add(btnB2);
        btnB2.setContentAreaFilled(false);
        btnB2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnB2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnB2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnB2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/trunk2.png"))); // NOI18N
        btnB2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnB2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnB2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnB2MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnB2MouseEntered(evt);
            }
        });
        btnB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB2ActionPerformed(evt);
            }
        });
        coB2.add(btnB2);

        jPanel45.add(coB2);

        coB3.setBackground(new java.awt.Color(255, 255, 255));
        coB3.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), null)); // NOI18N
        coB3.setLayout(new java.awt.GridLayout(1, 0));

        badanGrup.add(btnB3);
        btnB3.setContentAreaFilled(false);
        btnB3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnB3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnB3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnB3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/trunk3.png"))); // NOI18N
        btnB3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnB3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnB3MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnB3MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnB3MouseEntered(evt);
            }
        });
        btnB3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB3ActionPerformed(evt);
            }
        });
        coB3.add(btnB3);

        jPanel45.add(coB3);

        coB4.setBackground(new java.awt.Color(255, 255, 255));
        coB4.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 4", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), null)); // NOI18N
        coB4.setLayout(new java.awt.GridLayout(1, 0));

        badanGrup.add(btnB4);
        btnB4.setContentAreaFilled(false);
        btnB4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnB4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnB4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnB4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/trunk4.png"))); // NOI18N
        btnB4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnB4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnB4MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnB4MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnB4MouseEntered(evt);
            }
        });
        btnB4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB4ActionPerformed(evt);
            }
        });
        coB4.add(btnB4);

        jPanel45.add(coB4);

        jScrollPane12.setViewportView(jPanel45);

        jPanel308.add(jScrollPane12);

        badanTambahanPanel.setBackground(new java.awt.Color(255, 255, 255));
        badanTambahanPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Tambahan", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Poppins Medium", 0, 21)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10))); // NOI18N
        badanTambahanPanel.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        coAddB1.setBackground(new java.awt.Color(255, 255, 255));
        coAddB1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Badan memutar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 14)), null)); // NOI18N
        coAddB1.setLayout(new java.awt.GridLayout(1, 0));

        secDataB1.setContentAreaFilled(false);
        secDataB1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secDataB1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        secDataB1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/trunk5.png"))); // NOI18N
        secDataB1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        secDataB1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                secDataB1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                secDataB1MouseEntered(evt);
            }
        });
        secDataB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secDataB1ActionPerformed(evt);
            }
        });
        coAddB1.add(secDataB1);

        badanTambahanPanel.add(coAddB1);

        coAddB2.setBackground(new java.awt.Color(255, 255, 255));
        coAddB2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Badan menekuk kesamping", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 14)), null)); // NOI18N
        coAddB2.setLayout(new java.awt.GridLayout(1, 0));

        secDataB2.setContentAreaFilled(false);
        secDataB2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secDataB2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        secDataB2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/trunk6.png"))); // NOI18N
        secDataB2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        secDataB2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                secDataB2MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                secDataB2MouseEntered(evt);
            }
        });
        secDataB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secDataB2ActionPerformed(evt);
            }
        });
        coAddB2.add(secDataB2);

        badanTambahanPanel.add(coAddB2);

        jPanel308.add(badanTambahanPanel);

        badan.add(jPanel308);

        cardInputData.add(badan, "card10");

        kaki.setBackground(new java.awt.Color(255, 255, 255));
        kaki.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(30, 20, 30, 20)));
        kaki.setLayout(new javax.swing.BoxLayout(kaki, javax.swing.BoxLayout.Y_AXIS));

        jPanel324.setLayout(new javax.swing.BoxLayout(jPanel324, javax.swing.BoxLayout.Y_AXIS));

        jPanel46.setBackground(new java.awt.Color(255, 255, 255));
        jPanel46.setMaximumSize(new java.awt.Dimension(32767, 230));
        jPanel46.setMinimumSize(new java.awt.Dimension(770, 230));
        jPanel46.setPreferredSize(new java.awt.Dimension(982, 80));
        jPanel46.setLayout(new java.awt.GridLayout(2, 0));

        jPanel47.setBackground(new java.awt.Color(255, 255, 255));
        jPanel47.setPreferredSize(new java.awt.Dimension(1004, 69));

        jLabel125.setFont(new java.awt.Font("Poppins Black", 0, 30)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(3, 155, 216));
        jLabel125.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel125.setText("KAKI");
        jLabel125.setToolTipText("");
        jPanel47.add(jLabel125);

        jPanel46.add(jPanel47);

        jPanel48.setBackground(new java.awt.Color(255, 255, 255));
        jPanel48.setPreferredSize(new java.awt.Dimension(1004, 69));

        jLabel126.setFont(new java.awt.Font("Poppins", 0, 25)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(3, 155, 216));
        jLabel126.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel126.setText("Harap lebih teliti dalam pemilihan postur - postur tubuh");
        jLabel126.setToolTipText("");
        jPanel48.add(jLabel126);

        jPanel46.add(jPanel48);

        jPanel324.add(jPanel46);

        jScrollPane13.setBorder(null);

        jPanel49.setBackground(new java.awt.Color(255, 255, 255));
        jPanel49.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(30, 0, 30, 0)));
        jPanel49.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        coK1.setBackground(new java.awt.Color(255, 255, 255));
        coK1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kaki tidak terangkat", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), null)); // NOI18N
        coK1.setLayout(new java.awt.GridLayout(1, 0));

        kakiGrup.add(btnK1);
        btnK1.setContentAreaFilled(false);
        btnK1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnK1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnK1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnK1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/legs1.png"))); // NOI18N
        btnK1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnK1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnK1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnK1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnK1MouseEntered(evt);
            }
        });
        btnK1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnK1ActionPerformed(evt);
            }
        });
        coK1.add(btnK1);

        jPanel49.add(coK1);

        coK2.setBackground(new java.awt.Color(255, 255, 255));
        coK2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kaki  terangkat", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), null)); // NOI18N
        coK2.setLayout(new java.awt.GridLayout(1, 0));

        kakiGrup.add(btnK2);
        btnK2.setContentAreaFilled(false);
        btnK2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnK2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnK2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnK2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/legs2.png"))); // NOI18N
        btnK2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnK2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnK2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnK2MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnK2MouseEntered(evt);
            }
        });
        btnK2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnK2ActionPerformed(evt);
            }
        });
        coK2.add(btnK2);

        jPanel49.add(coK2);

        jScrollPane13.setViewportView(jPanel49);

        jPanel324.add(jScrollPane13);

        kaki.add(jPanel324);

        cardInputData.add(kaki, "card11");

        tambahan2.setBackground(new java.awt.Color(255, 255, 255));
        tambahan2.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(30, 20, 30, 20)));
        tambahan2.setLayout(new javax.swing.BoxLayout(tambahan2, javax.swing.BoxLayout.Y_AXIS));

        jPanel283.setLayout(new javax.swing.BoxLayout(jPanel283, javax.swing.BoxLayout.Y_AXIS));

        jPanel50.setBackground(new java.awt.Color(255, 255, 255));
        jPanel50.setMaximumSize(new java.awt.Dimension(32767, 230));
        jPanel50.setMinimumSize(new java.awt.Dimension(770, 230));
        jPanel50.setPreferredSize(new java.awt.Dimension(982, 80));
        jPanel50.setLayout(new java.awt.GridLayout(2, 0));

        jPanel51.setBackground(new java.awt.Color(255, 255, 255));
        jPanel51.setPreferredSize(new java.awt.Dimension(1004, 69));

        jLabel127.setFont(new java.awt.Font("Poppins Black", 0, 30)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(3, 155, 216));
        jLabel127.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel127.setText("DATA TAMBAHAN 2");
        jLabel127.setToolTipText("");
        jPanel51.add(jLabel127);

        jPanel50.add(jPanel51);

        jPanel52.setBackground(new java.awt.Color(255, 255, 255));
        jPanel52.setPreferredSize(new java.awt.Dimension(1004, 69));

        jLabel128.setFont(new java.awt.Font("Poppins", 0, 25)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(3, 155, 216));
        jLabel128.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel128.setText("Berikut ini merupakan data yang bersifat opsional");
        jLabel128.setToolTipText("");
        jPanel52.add(jLabel128);

        jPanel50.add(jPanel52);

        jPanel283.add(jPanel50);

        jScrollPane16.setBorder(null);

        jPanel53.setBackground(new java.awt.Color(255, 255, 255));
        jPanel53.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(30, 0, 30, 0)));
        jPanel53.setLayout(new java.awt.GridLayout(2, 2, 10, 10));

        coDT21.setBackground(new java.awt.Color(255, 255, 255));
        coDT21.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 0", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1))); // NOI18N
        coDT21.setLayout(new java.awt.GridLayout(1, 0));

        dataTambahan2.add(tambahanData21);
        tambahanData21.setFont(new java.awt.Font("Poppins", 0, 21)); // NOI18N
        tambahanData21.setText("<html>- Tidak ada perlawanan<br>- Beban kurang dari 2Kg</html>");
        tambahanData21.setContentAreaFilled(false);
        tambahanData21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tambahanData21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tambahanData21.setIconTextGap(10);
        tambahanData21.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        tambahanData21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tambahanData21MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tambahanData21MouseEntered(evt);
            }
        });
        tambahanData21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahanData21ActionPerformed(evt);
            }
        });
        coDT21.add(tambahanData21);

        jPanel53.add(coDT21);

        coDT22.setBackground(new java.awt.Color(255, 255, 255));
        coDT22.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1))); // NOI18N
        coDT22.setLayout(new java.awt.GridLayout(1, 0));

        dataTambahan2.add(tambahanData22);
        tambahanData22.setFont(new java.awt.Font("Poppins", 0, 21)); // NOI18N
        tambahanData22.setText("<html>- Beban 2Kg sampai 10Kg</html>");
        tambahanData22.setContentAreaFilled(false);
        tambahanData22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tambahanData22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tambahanData22.setIconTextGap(10);
        tambahanData22.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        tambahanData22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tambahanData22MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tambahanData22MouseEntered(evt);
            }
        });
        tambahanData22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahanData22ActionPerformed(evt);
            }
        });
        coDT22.add(tambahanData22);

        jPanel53.add(coDT22);

        coDT23.setBackground(new java.awt.Color(255, 255, 255));
        coDT23.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1))); // NOI18N
        coDT23.setLayout(new java.awt.GridLayout(1, 0));

        dataTambahan2.add(tambahanData23);
        tambahanData23.setFont(new java.awt.Font("Poppins", 0, 21)); // NOI18N
        tambahanData23.setText("<html>- Beban statis 2Kg sampai 10Kg<br>- Beban kurang dari 2kg</html>");
        tambahanData23.setContentAreaFilled(false);
        tambahanData23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tambahanData23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tambahanData23.setIconTextGap(10);
        tambahanData23.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        tambahanData23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tambahanData23MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tambahanData23MouseEntered(evt);
            }
        });
        tambahanData23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahanData23ActionPerformed(evt);
            }
        });
        coDT23.add(tambahanData23);

        jPanel53.add(coDT23);

        coDT24.setBackground(new java.awt.Color(255, 255, 255));
        coDT24.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1))); // NOI18N
        coDT24.setLayout(new java.awt.GridLayout(1, 0));

        dataTambahan2.add(tambahanData24);
        tambahanData24.setFont(new java.awt.Font("Poppins", 0, 21)); // NOI18N
        tambahanData24.setText("<html>- Beban lebih dari 10 Kg<br>- Shock atau berulang</html>");
        tambahanData24.setContentAreaFilled(false);
        tambahanData24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tambahanData24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tambahanData24.setIconTextGap(10);
        tambahanData24.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        tambahanData24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tambahanData24MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tambahanData24MouseEntered(evt);
            }
        });
        tambahanData24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahanData24ActionPerformed(evt);
            }
        });
        coDT24.add(tambahanData24);

        jPanel53.add(coDT24);

        jScrollPane16.setViewportView(jPanel53);

        jPanel283.add(jScrollPane16);

        dataTambahan2Panel.setBackground(new java.awt.Color(255, 255, 255));
        dataTambahan2Panel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Tambahan", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Poppins Medium", 0, 21)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10))); // NOI18N
        dataTambahan2Panel.setMaximumSize(new java.awt.Dimension(32767, 107));
        dataTambahan2Panel.setLayout(new java.awt.GridLayout(1, 0));

        coAddDT2.setBackground(new java.awt.Color(255, 255, 255));
        coAddDT2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Poppins Medium", 0, 21)), null)); // NOI18N
        coAddDT2.setMaximumSize(new java.awt.Dimension(32767, 107));
        coAddDT2.setLayout(new java.awt.GridLayout(1, 0));

        tambahanData25.setFont(new java.awt.Font("Poppins", 0, 21)); // NOI18N
        tambahanData25.setText("<html>Jika postur terutama statis (yaitu ditahan > I menit), Atau jika tindakan berulang terjadi 4x per menit</html>");
        tambahanData25.setContentAreaFilled(false);
        tambahanData25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tambahanData25.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tambahanData25.setIconTextGap(10);
        tambahanData25.setVerifyInputWhenFocusTarget(false);
        tambahanData25.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        tambahanData25.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        tambahanData25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tambahanData25MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tambahanData25MouseEntered(evt);
            }
        });
        tambahanData25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahanData25ActionPerformed(evt);
            }
        });
        coAddDT2.add(tambahanData25);

        dataTambahan2Panel.add(coAddDT2);

        jPanel283.add(dataTambahan2Panel);

        tambahan2.add(jPanel283);

        cardInputData.add(tambahan2, "card8");

        finalHasil.setBackground(new java.awt.Color(255, 255, 255));
        finalHasil.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(30, 20, 10, 20)));
        finalHasil.setLayout(new javax.swing.BoxLayout(finalHasil, javax.swing.BoxLayout.Y_AXIS));

        jPanel334.setLayout(new javax.swing.BoxLayout(jPanel334, javax.swing.BoxLayout.Y_AXIS));

        jPanel60.setBackground(new java.awt.Color(255, 255, 255));
        jPanel60.setMaximumSize(new java.awt.Dimension(32767, 130));
        jPanel60.setMinimumSize(new java.awt.Dimension(770, 230));
        jPanel60.setPreferredSize(new java.awt.Dimension(982, 80));
        jPanel60.setLayout(new javax.swing.BoxLayout(jPanel60, javax.swing.BoxLayout.Y_AXIS));

        jPanel61.setBackground(new java.awt.Color(255, 255, 255));
        jPanel61.setMaximumSize(new java.awt.Dimension(32767, 56));
        jPanel61.setPreferredSize(new java.awt.Dimension(1004, 69));

        jLabel131.setFont(new java.awt.Font("Poppins Black", 0, 30)); // NOI18N
        jLabel131.setForeground(new java.awt.Color(3, 155, 216));
        jLabel131.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel131.setText("RAPID UPPER LIMB ASSESSMENT");
        jLabel131.setToolTipText("");
        jPanel61.add(jLabel131);

        jPanel60.add(jPanel61);

        jPanel62.setBackground(new java.awt.Color(255, 255, 255));
        jPanel62.setPreferredSize(new java.awt.Dimension(1004, 69));

        jLabel132.setFont(new java.awt.Font("Poppins", 0, 25)); // NOI18N
        jLabel132.setForeground(new java.awt.Color(3, 155, 216));
        jLabel132.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel132.setText("Skor perhitungan akhir RULA");
        jLabel132.setToolTipText("");
        jPanel62.add(jLabel132);

        jPanel60.add(jPanel62);

        jPanel334.add(jPanel60);

        jPanel281.setBackground(new java.awt.Color(255, 255, 255));
        jPanel281.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(30, 1, 30, 1)));
        jPanel281.setMinimumSize(new java.awt.Dimension(942, 300));
        jPanel281.setLayout(new javax.swing.BoxLayout(jPanel281, javax.swing.BoxLayout.Y_AXIS));

        jPanel59.setBackground(new java.awt.Color(255, 255, 255));
        jPanel59.setLayout(new javax.swing.BoxLayout(jPanel59, javax.swing.BoxLayout.Y_AXIS));

        Hasil1.setBackground(new java.awt.Color(255, 255, 255));
        Hasil1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hasil", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Poppins Medium", 0, 21)), null)); // NOI18N
        Hasil1.setMaximumSize(new java.awt.Dimension(2147483647, 200));
        Hasil1.setLayout(new java.awt.BorderLayout());

        displayHasil.setFont(new java.awt.Font("Poppins ExtraBold", 1, 100)); // NOI18N
        displayHasil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        displayHasil.setText("0");
        Hasil1.add(displayHasil, java.awt.BorderLayout.CENTER);

        jPanel59.add(Hasil1);

        Hasil2.setBackground(new java.awt.Color(255, 255, 255));
        Hasil2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kerentanan", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Poppins Medium", 0, 21)), null)); // NOI18N
        Hasil2.setFocusable(false);
        Hasil2.setMaximumSize(new java.awt.Dimension(2147483647, 200));
        Hasil2.setLayout(new java.awt.BorderLayout());

        displayKerentanan.setFont(new java.awt.Font("Poppins SemiBold", 1, 80)); // NOI18N
        displayKerentanan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        displayKerentanan.setText("0");
        Hasil2.add(displayKerentanan, java.awt.BorderLayout.CENTER);

        jPanel59.add(Hasil2);

        Hasil3.setBackground(new java.awt.Color(255, 255, 255));
        Hasil3.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Keterangan", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Poppins Medium", 0, 21)), null)); // NOI18N
        Hasil3.setMaximumSize(new java.awt.Dimension(2147483647, 200));
        Hasil3.setLayout(new java.awt.BorderLayout());

        displayKeterangan.setFont(new java.awt.Font("Poppins SemiBold", 1, 30)); // NOI18N
        displayKeterangan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        displayKeterangan.setText("Penyelidikan lebih lanjut, Perubahan mungkin diperlukan");
        Hasil3.add(displayKeterangan, java.awt.BorderLayout.CENTER);

        jPanel59.add(Hasil3);

        jPanel281.add(jPanel59);

        jPanel334.add(jPanel281);

        jPanel437.setBackground(new java.awt.Color(255, 255, 255));
        jPanel437.setMaximumSize(new java.awt.Dimension(32767, 200));
        jPanel437.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        panelBtnNext1.setBackground(new java.awt.Color(255, 255, 255));
        panelBtnNext1.setMaximumSize(new java.awt.Dimension(500, 32767));
        panelBtnNext1.setMinimumSize(new java.awt.Dimension(400, 0));
        panelBtnNext1.setPreferredSize(new java.awt.Dimension(200, 37));
        panelBtnNext1.setLayout(new javax.swing.BoxLayout(panelBtnNext1, javax.swing.BoxLayout.LINE_AXIS));

        panelBtn22.setBackground(new java.awt.Color(3, 155, 216));
        panelBtn22.setMaximumSize(new java.awt.Dimension(32767, 40));
        panelBtn22.setMinimumSize(new java.awt.Dimension(0, 40));
        panelBtn22.setPreferredSize(new java.awt.Dimension(556, 50));
        panelBtn22.setRoundBottomLeft(20);
        panelBtn22.setRoundBottomRight(20);
        panelBtn22.setRoundTopLeft(20);
        panelBtn22.setRoundTopRight(20);

        nextButton2.setBackground(new java.awt.Color(153, 153, 153));
        nextButton2.setFont(new java.awt.Font("Poppins SemiBold", 0, 18)); // NOI18N
        nextButton2.setForeground(new java.awt.Color(255, 255, 255));
        nextButton2.setText("LIHAT RINGKASAN DATA");
        nextButton2.setBorder(null);
        nextButton2.setBorderPainted(false);
        nextButton2.setContentAreaFilled(false);
        nextButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nextButton2MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextButton2MouseEntered(evt);
            }
        });
        nextButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBtn22Layout = new javax.swing.GroupLayout(panelBtn22);
        panelBtn22.setLayout(panelBtn22Layout);
        panelBtn22Layout.setHorizontalGroup(
            panelBtn22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nextButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
        );
        panelBtn22Layout.setVerticalGroup(
            panelBtn22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nextButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelBtnNext1.add(panelBtn22);

        jPanel437.add(panelBtnNext1);

        panelBtnNext2.setBackground(new java.awt.Color(255, 255, 255));
        panelBtnNext2.setMaximumSize(new java.awt.Dimension(500, 32767));
        panelBtnNext2.setLayout(new javax.swing.BoxLayout(panelBtnNext2, javax.swing.BoxLayout.LINE_AXIS));

        panelBtn23.setBackground(new java.awt.Color(3, 155, 216));
        panelBtn23.setMaximumSize(new java.awt.Dimension(32767, 40));
        panelBtn23.setMinimumSize(new java.awt.Dimension(0, 40));
        panelBtn23.setRoundBottomLeft(20);
        panelBtn23.setRoundBottomRight(20);
        panelBtn23.setRoundTopLeft(20);
        panelBtn23.setRoundTopRight(20);

        nextButton3.setBackground(new java.awt.Color(153, 153, 153));
        nextButton3.setFont(new java.awt.Font("Poppins SemiBold", 0, 18)); // NOI18N
        nextButton3.setForeground(new java.awt.Color(255, 255, 255));
        nextButton3.setText("INPUT DATA BARU");
        nextButton3.setBorder(null);
        nextButton3.setBorderPainted(false);
        nextButton3.setContentAreaFilled(false);
        nextButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nextButton3MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextButton3MouseEntered(evt);
            }
        });
        nextButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBtn23Layout = new javax.swing.GroupLayout(panelBtn23);
        panelBtn23.setLayout(panelBtn23Layout);
        panelBtn23Layout.setHorizontalGroup(
            panelBtn23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nextButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
        );
        panelBtn23Layout.setVerticalGroup(
            panelBtn23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nextButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelBtnNext2.add(panelBtn23);

        jPanel437.add(panelBtnNext2);

        jPanel334.add(jPanel437);

        finalHasil.add(jPanel334);

        cardInputData.add(finalHasil, "card13");

        pInputData.add(cardInputData);

        btnGrupDown.setBackground(new java.awt.Color(255, 255, 255));
        btnGrupDown.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 20));
        btnGrupDown.setLayout(new java.awt.GridLayout(1, 2, 400, 0));

        panelBtnBack.setBackground(new java.awt.Color(3, 155, 216));
        panelBtnBack.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(4, 8, 4, 4)));
        panelBtnBack.setRoundBottomLeft(20);
        panelBtnBack.setRoundBottomRight(20);
        panelBtnBack.setRoundTopLeft(20);
        panelBtnBack.setRoundTopRight(20);
        panelBtnBack.setLayout(new java.awt.GridLayout(1, 0));

        backButton.setBackground(new java.awt.Color(153, 153, 153));
        backButton.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("Kembali");
        backButton.setBorder(null);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backButton.setEnabled(false);
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButtonMouseEntered(evt);
            }
        });
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        panelBtnBack.add(backButton);

        btnGrupDown.add(panelBtnBack);

        jPanel1.setLayout(new javax.swing.OverlayLayout(jPanel1));

        panelBtnNext.setBackground(new java.awt.Color(3, 155, 216));
        panelBtnNext.setRoundBottomLeft(20);
        panelBtnNext.setRoundBottomRight(20);
        panelBtnNext.setRoundTopLeft(20);
        panelBtnNext.setRoundTopRight(20);
        panelBtnNext.setLayout(new java.awt.GridLayout(1, 0));

        nextButton.setBackground(new java.awt.Color(153, 153, 153));
        nextButton.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        nextButton.setForeground(new java.awt.Color(255, 255, 255));
        nextButton.setText("Next");
        nextButton.setBorder(null);
        nextButton.setBorderPainted(false);
        nextButton.setContentAreaFilled(false);
        nextButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nextButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextButtonMouseEntered(evt);
            }
        });
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        panelBtnNext.add(nextButton);

        jPanel1.add(panelBtnNext);

        panelNextBtn1.setBackground(new java.awt.Color(3, 155, 216));
        panelNextBtn1.setRoundBottomLeft(20);
        panelNextBtn1.setRoundBottomRight(20);
        panelNextBtn1.setRoundTopLeft(20);
        panelNextBtn1.setRoundTopRight(20);
        panelNextBtn1.setLayout(new java.awt.GridLayout(1, 0));

        nextButton1.setBackground(new java.awt.Color(153, 153, 153));
        nextButton1.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        nextButton1.setForeground(new java.awt.Color(255, 255, 255));
        nextButton1.setText("Simpan & Lihat Hasil");
        nextButton1.setBorder(null);
        nextButton1.setBorderPainted(false);
        nextButton1.setContentAreaFilled(false);
        nextButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nextButton1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextButton1MouseEntered(evt);
            }
        });
        nextButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButton1ActionPerformed(evt);
            }
        });
        panelNextBtn1.add(nextButton1);

        jPanel1.add(panelNextBtn1);

        btnGrupDown.add(jPanel1);

        pInputData.add(btnGrupDown);

        blank6.setBackground(new java.awt.Color(255, 255, 255));
        blank6.setMaximumSize(new java.awt.Dimension(32767, 10));
        blank6.setPreferredSize(new java.awt.Dimension(1281, 10));

        javax.swing.GroupLayout blank6Layout = new javax.swing.GroupLayout(blank6);
        blank6.setLayout(blank6Layout);
        blank6Layout.setHorizontalGroup(
            blank6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1398, Short.MAX_VALUE)
        );
        blank6Layout.setVerticalGroup(
            blank6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        pInputData.add(blank6);

        panelData.add(pInputData, java.awt.BorderLayout.CENTER);

        right.add(panelData, "card2");

        databasePanel.setLayout(new javax.swing.BoxLayout(databasePanel, javax.swing.BoxLayout.LINE_AXIS));

        jPanel323.setBackground(new java.awt.Color(255, 255, 255));
        jPanel323.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(30, 20, 1, 20)));
        jPanel323.setLayout(new javax.swing.BoxLayout(jPanel323, javax.swing.BoxLayout.Y_AXIS));

        jPanel54.setBackground(new java.awt.Color(255, 255, 255));
        jPanel54.setMaximumSize(new java.awt.Dimension(32767, 230));
        jPanel54.setMinimumSize(new java.awt.Dimension(770, 230));
        jPanel54.setPreferredSize(new java.awt.Dimension(982, 80));
        jPanel54.setLayout(new java.awt.GridLayout(2, 0));

        jPanel55.setBackground(new java.awt.Color(255, 255, 255));
        jPanel55.setPreferredSize(new java.awt.Dimension(1004, 69));

        jLabel91.setFont(new java.awt.Font("Poppins Black", 0, 30)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(3, 155, 216));
        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setText("RIWAYAT PERHITUNGAN RULA");
        jLabel91.setToolTipText("");
        jPanel55.add(jLabel91);

        jPanel54.add(jPanel55);

        jPanel56.setBackground(new java.awt.Color(255, 255, 255));
        jPanel56.setPreferredSize(new java.awt.Dimension(1004, 69));

        jLabel92.setFont(new java.awt.Font("Poppins", 0, 25)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(3, 155, 216));
        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setText("Tabel riwayat data digunakan untuk melihat detail dan menghapus data");
        jLabel92.setToolTipText("");
        jPanel56.add(jLabel92);

        jPanel54.add(jPanel56);

        jPanel323.add(jPanel54);

        blank15.setBackground(new java.awt.Color(255, 255, 255));
        blank15.setMaximumSize(new java.awt.Dimension(32767, 30));
        blank15.setPreferredSize(new java.awt.Dimension(1281, 30));

        javax.swing.GroupLayout blank15Layout = new javax.swing.GroupLayout(blank15);
        blank15.setLayout(blank15Layout);
        blank15Layout.setHorizontalGroup(
            blank15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1360, Short.MAX_VALUE)
        );
        blank15Layout.setVerticalGroup(
            blank15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel323.add(blank15);

        jPanel342.setBackground(new java.awt.Color(255, 255, 255));
        jPanel342.setLayout(new java.awt.BorderLayout());

        jScrollPane8.setBackground(new java.awt.Color(255, 255, 255));

        TabelHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", null, null, null},
                {"", "", "", null, null, null},
                {"", "", "", null, null, null},
                {"", "", "", null, null, null},
                {"", "", "", null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "NIK", "Nama", "Umur", "Jenis Kelamin", "Pekerjaan", "Final Score"
            }
        ));
        TabelHistory.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        TabelHistory.setMaximumSize(new java.awt.Dimension(525, 150));
        TabelHistory.setMinimumSize(new java.awt.Dimension(525, 150));
        TabelHistory.setPreferredScrollableViewportSize(new java.awt.Dimension(525, 150));
        TabelHistory.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                TabelHistoryMouseMoved(evt);
            }
        });
        TabelHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelHistoryMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(TabelHistory);

        jPanel342.add(jScrollPane8, java.awt.BorderLayout.CENTER);

        jPanel323.add(jPanel342);

        jPanel345.setBackground(new java.awt.Color(255, 255, 255));
        jPanel345.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu Fungsi", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins Medium", 0, 15)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10))); // NOI18N
        jPanel345.setMaximumSize(new java.awt.Dimension(32767, 230));
        jPanel345.setPreferredSize(new java.awt.Dimension(982, 90));
        jPanel345.setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        panelDbDataLengkap.setBackground(new java.awt.Color(3, 155, 216));
        panelDbDataLengkap.setForeground(new java.awt.Color(255, 255, 255));
        panelDbDataLengkap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelDbDataLengkap.setLayout(new java.awt.GridLayout(1, 0));

        jButton1.setFont(new java.awt.Font("Poppins SemiBold", 0, 21)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("LIHAT DATA LENGKAP");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelDbDataLengkap.add(jButton1);

        jPanel345.add(panelDbDataLengkap);

        panelDbHapus.setBackground(new java.awt.Color(3, 155, 216));
        panelDbHapus.setForeground(new java.awt.Color(255, 255, 255));
        panelDbHapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelDbHapus.setLayout(new java.awt.GridLayout(1, 0));

        jButton3.setFont(new java.awt.Font("Poppins SemiBold", 0, 21)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("HAPUS");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panelDbHapus.add(jButton3);

        jPanel345.add(panelDbHapus);

        jPanel323.add(jPanel345);

        databasePanel.add(jPanel323);

        right.add(databasePanel, "card4");

        aboutMe.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(30, 40, 40, 40)));
        aboutMe.setPreferredSize(new java.awt.Dimension(300, 500));
        aboutMe.setLayout(new java.awt.BorderLayout());

        jPanel29.setLayout(new javax.swing.BoxLayout(jPanel29, javax.swing.BoxLayout.Y_AXIS));

        jPanel30.setMaximumSize(new java.awt.Dimension(32767, 100));
        jPanel30.setPreferredSize(new java.awt.Dimension(100, 230));
        jPanel30.setRequestFocusEnabled(false);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/me-circle-hd.png"))); // NOI18N
        jPanel30.add(jLabel4);

        jPanel29.add(jPanel30);

        jPanel57.setMaximumSize(new java.awt.Dimension(32767, 70));
        jPanel57.setPreferredSize(new java.awt.Dimension(884, 70));

        jLabel5.setFont(new java.awt.Font("Poppins Black", 0, 40)); // NOI18N
        jLabel5.setText("I KADEK ");
        jPanel57.add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Poppins Black", 0, 40)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(3, 155, 216));
        jLabel6.setText("ARYA SURYA ");
        jPanel57.add(jLabel6);

        jLabel7.setFont(new java.awt.Font("Poppins Black", 0, 40)); // NOI18N
        jLabel7.setText("SAPUTRA");
        jPanel57.add(jLabel7);

        jPanel29.add(jPanel57);

        jPanel63.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 20, 1), null));

        jLabel8.setFont(new java.awt.Font("Poppins ExtraLight", 2, 25)); // NOI18N
        jLabel8.setText("as - Mobile Programmer Development");
        jPanel63.add(jLabel8);

        jPanel29.add(jPanel63);

        jPanel64.setLayout(new javax.swing.BoxLayout(jPanel64, javax.swing.BoxLayout.Y_AXIS));

        jPanel65.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Social Media", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Poppins SemiBold", 0, 25)), null)); // NOI18N
        jPanel65.setLayout(new java.awt.GridLayout(2, 2));

        jPanel66.setLayout(new java.awt.GridLayout(1, 2));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/github.png"))); // NOI18N
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jPanel66.add(jLabel9);

        jLabel10.setFont(new java.awt.Font("Poppins SemiBold", 0, 20)); // NOI18N
        jLabel10.setText("@AryaSuryaaa");
        jPanel66.add(jLabel10);

        jPanel65.add(jPanel66);

        jPanel74.setLayout(new java.awt.GridLayout(1, 2));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/instagram.png"))); // NOI18N
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jPanel74.add(jLabel11);

        jLabel12.setFont(new java.awt.Font("Poppins SemiBold", 0, 20)); // NOI18N
        jLabel12.setText("@aryasuryaa__");
        jPanel74.add(jLabel12);

        jPanel65.add(jPanel74);

        jPanel79.setLayout(new java.awt.GridLayout(1, 2));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/facebook.png"))); // NOI18N
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jPanel79.add(jLabel13);

        jLabel14.setFont(new java.awt.Font("Poppins SemiBold", 0, 20)); // NOI18N
        jLabel14.setText("@aryasuryaaa");
        jPanel79.add(jLabel14);

        jPanel65.add(jPanel79);

        jPanel80.setLayout(new java.awt.GridLayout(1, 2));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gmailIcon.png"))); // NOI18N
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jPanel80.add(jLabel15);

        jLabel16.setFont(new java.awt.Font("Poppins SemiBold", 0, 20)); // NOI18N
        jLabel16.setText("@suryasaputra914@gmail.com");
        jPanel80.add(jLabel16);

        jPanel65.add(jPanel80);

        jPanel64.add(jPanel65);

        jPanel29.add(jPanel64);

        aboutMe.add(jPanel29, java.awt.BorderLayout.CENTER);

        right.add(aboutMe, "card1");

        MainPanel.add(right);

        getContentPane().add(MainPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInputDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInputDataActionPerformed
        // TODO add your handling code here:
//        CardLayout cardLayout = (CardLayout) right.getLayout();
//        cardLayout.next(right);
        updateButtonNext();
        panelDashboard.setVisible(false);
        panelData.setVisible(true);
        databasePanel.setVisible(false);
        aboutMe.setVisible(false);
        
        // Data tambahan
        lenganAtasTambahanPanel.setVisible(false);
        lenganBawahTambahanPanel.setVisible(false);
        pergelanganTanganTambahanPanel.setVisible(false);
        dataTambahan1Panel.setVisible(false);
        leherTambahanPanel.setVisible(false);
        badanTambahanPanel.setVisible(false);
        dataTambahan2Panel.setVisible(false);
        
    }//GEN-LAST:event_btnInputDataActionPerformed

    private void btnInputDataMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInputDataMouseEntered
        // TODO add your handling code here:
        menu1.setBackground(new Color(155, 164, 181));
    }//GEN-LAST:event_btnInputDataMouseEntered

    private void btnInputDataMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInputDataMouseExited
        // TODO add your handling code here:
        menu1.setBackground(new Color(1, 100, 139));
    }//GEN-LAST:event_btnInputDataMouseExited

    private void btnInputData1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInputData1MouseEntered
        // TODO add your handling code here:
        menu2.setBackground(new Color(155, 164, 181));
    }//GEN-LAST:event_btnInputData1MouseEntered

    private void btnInputData1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInputData1MouseExited
        // TODO add your handling code here:
        menu2.setBackground(new Color(1, 100, 139));
    }//GEN-LAST:event_btnInputData1MouseExited

    private void btnInputData1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInputData1ActionPerformed
        // TODO add your handling code here:
        panelDashboard.setVisible(false);
        panelData.setVisible(false);
        aboutMe.setVisible(false);
        
        // Set Database
        try {
                Class.forName("com.mysql.jdbc.Driver");
                con =DriverManager.getConnection("jdbc:mysql://localhost/db_rula","root","");
                st = con.createStatement();
            }
            catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Gagal Terkoneksi ke Database", "Pesan", JOptionPane.ERROR_MESSAGE);
            }
        
        // Setting tabel
        jScrollPane8.setVerticalScrollBar(new ScrollBarCustom());
        
        // Menampilkan database ke tabel
        TampilkanData();
        
        databasePanel.setVisible(true);
    }//GEN-LAST:event_btnInputData1ActionPerformed

    private void btnArahKiriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnArahKiriMouseClicked
        
    }//GEN-LAST:event_btnArahKiriMouseClicked

    private void btnArahKiriMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnArahKiriMouseEntered
        // TODO add your handling code here:
        panelSisiKiri.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_btnArahKiriMouseEntered

    private void btnArahKiriMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnArahKiriMouseExited
        // TODO add your handling code here:
        panelSisiKiri.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnArahKiriMouseExited

    private void btnArahKiriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArahKiriActionPerformed
        panelSisiKiri.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Kiri", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 30), new java.awt.Color(3, 155, 216)),
            null));
        
        panelSisiKanan.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Kanan", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 30), new java.awt.Color(0,0,0)),
            null));
        
        nextButton.setEnabled(true);
    }//GEN-LAST:event_btnArahKiriActionPerformed

    private void btnArahKananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnArahKananMouseClicked
        
    }//GEN-LAST:event_btnArahKananMouseClicked

    private void btnArahKananMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnArahKananMouseEntered
        // TODO add your handling code here:
        panelSisiKanan.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_btnArahKananMouseEntered

    private void btnArahKananMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnArahKananMouseExited
        // TODO add your handling code here:
        panelSisiKanan.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnArahKananMouseExited

    private void backButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseEntered
        panelBtnBack.setBackground(new Color(1, 100, 139));
    }//GEN-LAST:event_backButtonMouseEntered

    private void backButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseExited
        panelBtnBack.setBackground(new Color(3,155,216));
    }//GEN-LAST:event_backButtonMouseExited

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        backInputan();
    }//GEN-LAST:event_backButtonActionPerformed

    private void nextButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButtonMouseEntered
        panelBtnNext.setBackground(new Color(1, 100, 139));
    }//GEN-LAST:event_nextButtonMouseEntered

    private void nextButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButtonMouseExited
        panelBtnNext.setBackground(new Color(3,155,216));
    }//GEN-LAST:event_nextButtonMouseExited

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
        nextInputan();
    }//GEN-LAST:event_nextButtonActionPerformed

    private void btnLB1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLB1MouseClicked

    }//GEN-LAST:event_btnLB1MouseClicked

    private void btnLB1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLB1MouseEntered
        coLB1.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_btnLB1MouseEntered

    private void btnLB1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLB1MouseExited
        coLB1.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnLB1MouseExited

    private void btnLB3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLB3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLB3MouseClicked

    private void btnLB3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLB3MouseEntered
        coLB3.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_btnLB3MouseEntered

    private void btnLB3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLB3MouseExited
        coLB3.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnLB3MouseExited

    private void btnLB2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLB2MouseExited
        coLB2.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnLB2MouseExited

    private void btnLB2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLB2MouseEntered
        coLB2.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_btnLB2MouseEntered

    private void btnLB2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLB2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLB2MouseClicked

    private void secDataLBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secDataLBActionPerformed
        if(secDataLB.isSelected()) {
            coAddLB1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Salah satu tangan bekerja melintasi garis tengah atau kesamping tubuh", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 14), new java.awt.Color(3, 155, 216)),
            null));
        } else {
            coAddLB1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Salah satu tangan bekerja melintasi garis tengah atau kesamping tubuh", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 14), new java.awt.Color(0,0,0)),
            null));
        }
    }//GEN-LAST:event_secDataLBActionPerformed

    private void btnLA6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLA6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLA6MouseClicked

    private void btnLA6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLA6MouseEntered
        coLA1.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_btnLA6MouseEntered

    private void btnLA6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLA6MouseExited
        coLA1.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnLA6MouseExited

    private void btnLA7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLA7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLA7MouseClicked

    private void btnLA7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLA7MouseEntered
        coLA2.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_btnLA7MouseEntered

    private void btnLA7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLA7MouseExited
        coLA2.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnLA7MouseExited

    private void btnLA8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLA8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLA8MouseClicked

    private void btnLA8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLA8MouseEntered
        coLA3.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_btnLA8MouseEntered

    private void btnLA8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLA8MouseExited
        coLA3.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnLA8MouseExited

    private void btnLA9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLA9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLA9MouseClicked

    private void btnLA9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLA9MouseEntered
        coLA4.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_btnLA9MouseEntered

    private void btnLA9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLA9MouseExited
        coLA4.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnLA9MouseExited

    private void btnLA10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLA10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLA10MouseClicked

    private void btnLA10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLA10MouseEntered
        coLA5.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_btnLA10MouseEntered

    private void btnLA10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLA10MouseExited
        coLA5.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnLA10MouseExited

    private void secDataLA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secDataLA1ActionPerformed
        if(secDataLA1.isSelected()) {
            coAddLA1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Bahu dinaikan ke atas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 14), new java.awt.Color(3, 155, 216)),
            null));
        } else {
            coAddLA1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Bahu dinaikan ke atas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 14), new java.awt.Color(0,0,0)),
            null));
        }
    }//GEN-LAST:event_secDataLA1ActionPerformed

    private void secDataLA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secDataLA2ActionPerformed
        if(secDataLA2.isSelected()) {
            coAddLA2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Lengan atas ditopang atau bersandar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 14), new java.awt.Color(3, 155, 216)),
            null));
        } else {
            coAddLA2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Lengan atas ditopang atau bersandar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 14), new java.awt.Color(0,0,0)),
            null));
        }
    }//GEN-LAST:event_secDataLA2ActionPerformed

    private void secDataLA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secDataLA3ActionPerformed
        if(secDataLA3.isSelected()) {
            coAddLA3.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Lengan atas diabduksi", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 14), new java.awt.Color(3, 155, 216)),
            null));
        } else {
            coAddLA3.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Lengan atas diabduksi", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 14), new java.awt.Color(0,0,0)),
            null));
        }
    }//GEN-LAST:event_secDataLA3ActionPerformed

    private void btnPT1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPT1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPT1MouseClicked

    private void btnPT1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPT1MouseEntered
        coPT1.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_btnPT1MouseEntered

    private void btnPT1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPT1MouseExited
       coPT1.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnPT1MouseExited

    private void secDataPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secDataPTActionPerformed
        if(secDataPT.isSelected()) {
            coAddPT1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Pergelangan tangan ditekuk menjauh dari garis tengah", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 14), new java.awt.Color(3, 155, 216)),
            null));
        } else {
            coAddPT1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Pergelangan tangan ditekuk menjauh dari garis tengah", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 14), new java.awt.Color(0,0,0)),
            null));
        }
        
    }//GEN-LAST:event_secDataPTActionPerformed

    private void btnPT2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPT2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPT2MouseClicked

    private void btnPT2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPT2MouseEntered
        coPT2.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_btnPT2MouseEntered

    private void btnPT2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPT2MouseExited
        coPT2.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnPT2MouseExited

    private void btnPT3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPT3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPT3MouseClicked

    private void btnPT3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPT3MouseEntered
        coPT3.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_btnPT3MouseEntered

    private void btnPT3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPT3MouseExited
        coPT3.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnPT3MouseExited

    private void btnPT4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPT4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPT4MouseClicked

    private void btnPT4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPT4MouseEntered
        coPT4.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_btnPT4MouseEntered

    private void btnPT4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPT4MouseExited
        coPT4.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnPT4MouseExited

    private void btnPPT1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPPT1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPPT1MouseClicked

    private void btnPPT1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPPT1MouseEntered
        coPPT1.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_btnPPT1MouseEntered

    private void btnPPT1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPPT1MouseExited
        coPPT1.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnPPT1MouseExited

    private void btnPPT2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPPT2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPPT2MouseClicked

    private void btnPPT2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPPT2MouseEntered
        coPPT2.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_btnPPT2MouseEntered

    private void btnPPT2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPPT2MouseExited
        coPPT2.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnPPT2MouseExited

    private void btnL1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnL1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnL1MouseClicked

    private void btnL1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnL1MouseEntered
        coL1.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_btnL1MouseEntered

    private void btnL1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnL1MouseExited
        coL1.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnL1MouseExited

    private void btnL2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnL2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnL2MouseClicked

    private void btnL2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnL2MouseEntered
        coL2.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_btnL2MouseEntered

    private void btnL2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnL2MouseExited
        coL2.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnL2MouseExited

    private void btnL3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnL3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnL3MouseClicked

    private void btnL3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnL3MouseEntered
        coL3.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_btnL3MouseEntered

    private void btnL3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnL3MouseExited
        coL3.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnL3MouseExited

    private void btnL4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnL4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnL4MouseClicked

    private void btnL4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnL4MouseEntered
        coL4.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_btnL4MouseEntered

    private void btnL4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnL4MouseExited
        coL4.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnL4MouseExited

    private void secDataL1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secDataL1ActionPerformed
        if(secDataL1.isSelected()) {
            coAddL1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Leher memutar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 14), new java.awt.Color(3, 155, 216)),
            null));
        } else {
            coAddL1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Leher memutar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 14), new java.awt.Color(0,0,0)),
            null));
        }
    }//GEN-LAST:event_secDataL1ActionPerformed

    private void secDataL2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secDataL2ActionPerformed
        if(secDataL2.isSelected()) {
            coAddL2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Leher menekuk kesamping", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 14), new java.awt.Color(3, 155, 216)),
            null));
        } else {
            coAddL2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Leher menekuk kesamping", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 14), new java.awt.Color(0,0,0)),
            null));
        }
    }//GEN-LAST:event_secDataL2ActionPerformed

    private void tambahanData1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahanData1ActionPerformed
        coDT11.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 0", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        coDT12.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coDT13.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coDT14.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        showDataAddDT1();
    }//GEN-LAST:event_tambahanData1ActionPerformed

    private void tambahanData2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahanData2ActionPerformed
        coDT11.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 0", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coDT12.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        coDT13.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coDT14.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        showDataAddDT1();
    }//GEN-LAST:event_tambahanData2ActionPerformed

    private void tambahanData4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahanData4ActionPerformed
        coDT11.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 0", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coDT12.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coDT13.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coDT14.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        showDataAddDT1();
    }//GEN-LAST:event_tambahanData4ActionPerformed

    private void tambahanData3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahanData3ActionPerformed
        coDT11.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 0", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coDT12.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coDT13.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        coDT14.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        showDataAddDT1();
    }//GEN-LAST:event_tambahanData3ActionPerformed

    private void tambahanData5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahanData5ActionPerformed
        if(tambahanData5.isSelected()) {
            coAddDT1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        } else {
            coAddDT1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        }
    }//GEN-LAST:event_tambahanData5ActionPerformed

    private void btnB1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnB1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnB1MouseClicked

    private void btnB1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnB1MouseEntered
        coB1.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_btnB1MouseEntered

    private void btnB1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnB1MouseExited
        coB1.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnB1MouseExited

    private void btnB2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnB2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnB2MouseClicked

    private void btnB2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnB2MouseEntered
        coB2.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_btnB2MouseEntered

    private void btnB2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnB2MouseExited
        coB2.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnB2MouseExited

    private void btnB3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnB3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnB3MouseClicked

    private void btnB3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnB3MouseEntered
        coB3.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_btnB3MouseEntered

    private void btnB3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnB3MouseExited
        coB3.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnB3MouseExited

    private void btnB4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnB4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnB4MouseClicked

    private void btnB4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnB4MouseEntered
        coB4.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_btnB4MouseEntered

    private void btnB4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnB4MouseExited
        coB4.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnB4MouseExited

    private void secDataB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secDataB1ActionPerformed
        if(secDataB1.isSelected()) {
            coAddB1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Badan memutar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 14), new java.awt.Color(3, 155, 216)),
            null));
        } else {
            coAddB1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Badan memutar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 14), new java.awt.Color(0,0,0)),
            null));
        }
    }//GEN-LAST:event_secDataB1ActionPerformed

    private void secDataB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secDataB2ActionPerformed
        if(secDataB2.isSelected()) {
            coAddB2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Badan menekuk kesamping", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 14), new java.awt.Color(3, 155, 216)),
            null));
        } else {
            coAddB2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Badan menekuk kesamping", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 14), new java.awt.Color(0,0,0)),
            null));
        }
    }//GEN-LAST:event_secDataB2ActionPerformed

    private void btnK1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnK1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnK1MouseClicked

    private void btnK1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnK1MouseEntered
        coK1.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_btnK1MouseEntered

    private void btnK1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnK1MouseExited
        coK1.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnK1MouseExited

    private void btnK2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnK2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnK2MouseClicked

    private void btnK2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnK2MouseEntered
        coK2.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_btnK2MouseEntered

    private void btnK2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnK2MouseExited
        coK2.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnK2MouseExited

    private void btnLB3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLB3ActionPerformed
        coLB1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coLB2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coLB3.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        showDataAddLB();
    }//GEN-LAST:event_btnLB3ActionPerformed

    private void TabelHistoryMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelHistoryMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_TabelHistoryMouseMoved

    private void TabelHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelHistoryMouseClicked
        // TODO add your handling code here:
        // Ketika tabel ke tekan
        int baris = TabelHistory.rowAtPoint(evt.getPoint());
        this.databaseClick = TabelHistory.getValueAt(baris,0).toString();
//
//        // Mengubah warna panel jika data dari tabel telah dipilih
//        PanelLihatDetail.setBackground(new java.awt.Color(40,167,69));
//        ButtonLihatDetail.setEnabled(true);
//        PanelHapusData.setBackground(new java.awt.Color(220,53,69));
//        ButtonHapusData.setEnabled(true);
    }//GEN-LAST:event_TabelHistoryMouseClicked

    private void nextButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButton1MouseExited
        panelNextBtn1.setBackground(new Color(3,155,216));
    }//GEN-LAST:event_nextButton1MouseExited

    private void nextButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButton1MouseEntered
        
        panelNextBtn1.setBackground(new Color(1, 100, 139));
    }//GEN-LAST:event_nextButton1MouseEntered

    private void nextButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButton1ActionPerformed
        // TODO add your handling code here:
        int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah data yang anda inputkan sudah benar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            // Tindakan yang diambil jika pengguna memilih Yes (Ya)
            sendToDatabase();
            displayHasil();
            nextInputan();
            btnGrupDown.setVisible(false);
            
//            System.out.println("Anda memilih Yes (Ya)");
        } else {
            // Tindakan yang diambil jika pengguna memilih No (Tidak) atau menutup dialog
//            System.out.println("Anda memilih No (Tidak) atau menutup dialog");
        }
        
        
    }//GEN-LAST:event_nextButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DetailDataFrame toDetail = new DetailDataFrame();
        
        toDetail.getDetailData(databaseClick);
        toDetail.getDetailTambahan(databaseClick);
        
        toDetail.setVisible(true);
        
        toDetail.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin menghapus data?", "Konfirmasi hapus data", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            // Tindakan yang diambil jika pengguna memilih Yes (Ya)
            try{
                String sql= "DELETE FROM t_data WHERE nik ='"+ databaseClick+"'";
                String sql2= "DELETE FROM t_add WHERE nik ='"+ databaseClick +"'";
                String sql3= "DELETE FROM t_show WHERE nik ='"+ databaseClick+"'";

                java.sql.Connection conn=(Connection)Database.configDB();

                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                java.sql.PreparedStatement pstm2 = conn.prepareStatement(sql2);
                java.sql.PreparedStatement pstm3 = conn.prepareStatement(sql3);

                pstm.execute();
                pstm2.execute();
                pstm3.execute();

                JOptionPane.showMessageDialog(null, "Hapus Data Berhasil.");
                TampilkanData();
            } catch(HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            
//            System.out.println("Anda memilih Yes (Ya)");
        } else {
            // Tindakan yang diambil jika pengguna memilih No (Tidak) atau menutup dialog
//            System.out.println("Anda memilih No (Tidak) atau menutup dialog");
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void nikKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nikKeyReleased
        // TODO add your handling code here:
        updateButtonNext();
    }//GEN-LAST:event_nikKeyReleased

    private void namaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namaKeyReleased
        updateButtonNext();
    }//GEN-LAST:event_namaKeyReleased

    private void umurKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_umurKeyReleased
        updateButtonNext();
    }//GEN-LAST:event_umurKeyReleased

    private void jenisKelaminKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jenisKelaminKeyReleased
        updateButtonNext();
    }//GEN-LAST:event_jenisKelaminKeyReleased

    private void alamatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alamatKeyReleased
        updateButtonNext();
    }//GEN-LAST:event_alamatKeyReleased

    private void nomorTelephoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomorTelephoneKeyReleased
        updateButtonNext();
    }//GEN-LAST:event_nomorTelephoneKeyReleased

    private void pekerjaanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pekerjaanKeyReleased
        updateButtonNext();
    }//GEN-LAST:event_pekerjaanKeyReleased

    private void lamaBekerjaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lamaBekerjaKeyReleased
        updateButtonNext();
    }//GEN-LAST:event_lamaBekerjaKeyReleased

    private void durasiBekerjaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_durasiBekerjaKeyReleased
        updateButtonNext();
    }//GEN-LAST:event_durasiBekerjaKeyReleased

    private void jenisKerjaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jenisKerjaKeyReleased
        updateButtonNext();
    }//GEN-LAST:event_jenisKerjaKeyReleased

    private void keluhanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keluhanKeyReleased
        updateButtonNext();
    }//GEN-LAST:event_keluhanKeyReleased

    private void nikKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nikKeyTyped
        char c = evt.getKeyChar();
        if(!((c >= '0') && (c <= '9')
            || (c == KeyEvent.VK_BACK_SPACE)
            || (c == KeyEvent.VK_DELETE))){
        getToolkit().beep();
        evt.consume();
        }
    }//GEN-LAST:event_nikKeyTyped

    private void umurKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_umurKeyTyped
        char c = evt.getKeyChar();
        if(!((c >= '0') && (c <= '9')
            || (c == KeyEvent.VK_BACK_SPACE)
            || (c == KeyEvent.VK_DELETE))){
        getToolkit().beep();
        evt.consume();
        }
    }//GEN-LAST:event_umurKeyTyped

    private void nomorTelephoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomorTelephoneKeyTyped
        char c = evt.getKeyChar();
        if(!((c >= '0') && (c <= '9')
            || (c == KeyEvent.VK_BACK_SPACE)
            || (c == KeyEvent.VK_DELETE))){
        getToolkit().beep();
        evt.consume();
        }
    }//GEN-LAST:event_nomorTelephoneKeyTyped

    private void lamaBekerjaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lamaBekerjaKeyTyped
        char c = evt.getKeyChar();
        if(!((c >= '0') && (c <= '9')
            || (c == KeyEvent.VK_BACK_SPACE)
            || (c == KeyEvent.VK_DELETE))){
        getToolkit().beep();
        evt.consume();
        }
    }//GEN-LAST:event_lamaBekerjaKeyTyped

    private void durasiBekerjaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_durasiBekerjaKeyTyped
        char c = evt.getKeyChar();
        if(!((c >= '0') && (c <= '9')
            || (c == KeyEvent.VK_BACK_SPACE)
            || (c == KeyEvent.VK_DELETE))){
        getToolkit().beep();
        evt.consume();
        }
    }//GEN-LAST:event_durasiBekerjaKeyTyped

    private void btnArahKananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArahKananActionPerformed
        panelSisiKiri.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Kiri", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 30), new java.awt.Color(0,0,0)),
            null));
        
        panelSisiKanan.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Kanan", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 30), new java.awt.Color(3, 155, 216)),
            null));
        
        nextButton.setEnabled(true);
    }//GEN-LAST:event_btnArahKananActionPerformed

    private void btnLA6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLA6ActionPerformed
        coLA1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        coLA2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coLA3.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coLA4.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coLA5.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 4", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        showDataAddLA();
        
    }//GEN-LAST:event_btnLA6ActionPerformed

    private void btnLA7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLA7ActionPerformed
        coLA1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coLA2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        coLA3.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coLA4.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coLA5.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 4", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        showDataAddLA();
    }//GEN-LAST:event_btnLA7ActionPerformed

    private void btnLA8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLA8ActionPerformed
        coLA1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coLA2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coLA3.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        coLA4.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coLA5.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 4", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        showDataAddLA();
    }//GEN-LAST:event_btnLA8ActionPerformed

    private void btnLA9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLA9ActionPerformed
        coLA1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coLA2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coLA3.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coLA4.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        coLA5.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 4", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        showDataAddLA();
    }//GEN-LAST:event_btnLA9ActionPerformed

    private void btnLA10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLA10ActionPerformed
        coLA1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coLA2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coLA3.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coLA4.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coLA5.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 4", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        showDataAddLA();
    }//GEN-LAST:event_btnLA10ActionPerformed

    private void btnLB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLB1ActionPerformed
        coLB1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        coLB2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coLB3.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        showDataAddLB();
    }//GEN-LAST:event_btnLB1ActionPerformed

    private void btnLB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLB2ActionPerformed
        coLB1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coLB2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        coLB3.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        showDataAddLB();
    }//GEN-LAST:event_btnLB2ActionPerformed

    private void btnPT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPT1ActionPerformed
        coPT1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        coPT2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coPT3.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coPT4.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        showDataAddPT();
    }//GEN-LAST:event_btnPT1ActionPerformed

    private void btnPT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPT2ActionPerformed
        coPT1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coPT2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        coPT3.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coPT4.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        showDataAddPT();
    }//GEN-LAST:event_btnPT2ActionPerformed

    private void btnPT3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPT3ActionPerformed
        coPT1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coPT2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coPT3.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        coPT4.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        showDataAddPT();
    }//GEN-LAST:event_btnPT3ActionPerformed

    private void btnPT4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPT4ActionPerformed
        coPT1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coPT2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coPT3.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coPT4.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        showDataAddPT();
    }//GEN-LAST:event_btnPT4ActionPerformed

    private void btnPPT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPPT1ActionPerformed
        coPPT1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Tidak memutar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 30), new java.awt.Color(3, 155, 216)),
            null));
        
        coPPT2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Memutar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 30), new java.awt.Color(0,0,0)),
            null));
        
        nextButton.setEnabled(true);
    }//GEN-LAST:event_btnPPT1ActionPerformed

    private void btnPPT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPPT2ActionPerformed
        coPPT1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Tidak memutar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 30), new java.awt.Color(0,0,0)),
            null));
        
        coPPT2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Memutar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 30), new java.awt.Color(3, 155, 216)),
            null));
        nextButton.setEnabled(true);
    }//GEN-LAST:event_btnPPT2ActionPerformed

    private void tambahanData1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahanData1MouseEntered
        coDT11.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_tambahanData1MouseEntered

    private void tambahanData1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahanData1MouseExited
        coDT11.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_tambahanData1MouseExited

    private void tambahanData2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahanData2MouseEntered
        coDT12.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_tambahanData2MouseEntered

    private void tambahanData2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahanData2MouseExited
        coDT12.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_tambahanData2MouseExited

    private void tambahanData3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahanData3MouseEntered
        coDT13.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_tambahanData3MouseEntered

    private void tambahanData3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahanData3MouseExited
        coDT13.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_tambahanData3MouseExited

    private void tambahanData4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahanData4MouseEntered
        coDT14.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_tambahanData4MouseEntered

    private void tambahanData4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahanData4MouseExited
        coDT14.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_tambahanData4MouseExited

    private void tambahanData5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahanData5MouseEntered
        coAddDT1.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_tambahanData5MouseEntered

    private void tambahanData5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahanData5MouseExited
        coAddDT1.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_tambahanData5MouseExited

    private void btnL1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnL1ActionPerformed
        coL1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        coL2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coL3.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coL4.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 4", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        showDataAddL();
    }//GEN-LAST:event_btnL1ActionPerformed

    private void btnL2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnL2ActionPerformed
        coL1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coL2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        coL3.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coL4.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 4", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        showDataAddL();
    }//GEN-LAST:event_btnL2ActionPerformed

    private void btnL3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnL3ActionPerformed
        coL1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coL2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coL3.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        coL4.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 4", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        showDataAddL();
    }//GEN-LAST:event_btnL3ActionPerformed

    private void btnL4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnL4ActionPerformed
        coL1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coL2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coL3.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coL4.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 4", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        showDataAddL();
    }//GEN-LAST:event_btnL4ActionPerformed

    private void secDataL1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_secDataL1MouseEntered
        coAddL1.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_secDataL1MouseEntered

    private void secDataL1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_secDataL1MouseExited
        coAddL1.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_secDataL1MouseExited

    private void secDataL2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_secDataL2MouseEntered
        coAddL2.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_secDataL2MouseEntered

    private void secDataL2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_secDataL2MouseExited
        coAddL2.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_secDataL2MouseExited

    private void btnB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB1ActionPerformed
        coB1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        coB2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coB3.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coB4.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 4", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        showDataAddB();
    }//GEN-LAST:event_btnB1ActionPerformed

    private void btnB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB2ActionPerformed
        coB1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coB2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        coB3.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coB4.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 4", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        showDataAddB();
    }//GEN-LAST:event_btnB2ActionPerformed

    private void btnB3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB3ActionPerformed
        coB1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coB2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coB3.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        coB4.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 4", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        showDataAddB();
    }//GEN-LAST:event_btnB3ActionPerformed

    private void btnB4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB4ActionPerformed
        coB1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coB2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coB3.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coB4.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 4", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        showDataAddB();
    }//GEN-LAST:event_btnB4ActionPerformed

    private void secDataB1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_secDataB1MouseEntered
        coAddB1.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_secDataB1MouseEntered

    private void secDataB1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_secDataB1MouseExited
        coAddB1.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_secDataB1MouseExited

    private void secDataB2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_secDataB2MouseEntered
        coAddB2.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_secDataB2MouseEntered

    private void secDataB2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_secDataB2MouseExited
        coAddB2.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_secDataB2MouseExited

    private void btnK1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnK1ActionPerformed
        coK1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Kaki tidak terangkat", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        coK2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Kaki terangkat", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        nextButton.setEnabled(true);
    }//GEN-LAST:event_btnK1ActionPerformed

    private void btnK2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnK2ActionPerformed
        coK1.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Kaki tidak terangkat", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coK2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "Kaki terangkat", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        nextButton.setEnabled(true);
    }//GEN-LAST:event_btnK2ActionPerformed

    private void tambahanData21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahanData21MouseExited
        coDT21.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_tambahanData21MouseExited

    private void tambahanData21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahanData21MouseEntered
        coDT21.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_tambahanData21MouseEntered

    private void tambahanData21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahanData21ActionPerformed
        coDT21.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 0", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        coDT22.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coDT23.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coDT24.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        showDataAddDT2();
    }//GEN-LAST:event_tambahanData21ActionPerformed

    private void tambahanData22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahanData22MouseExited
        coDT22.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_tambahanData22MouseExited

    private void tambahanData22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahanData22MouseEntered
        coDT22.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_tambahanData22MouseEntered

    private void tambahanData22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahanData22ActionPerformed
        coDT21.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 0", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coDT22.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        coDT23.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coDT24.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        showDataAddDT2();
    }//GEN-LAST:event_tambahanData22ActionPerformed

    private void tambahanData23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahanData23MouseExited
        coDT23.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_tambahanData23MouseExited

    private void tambahanData23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahanData23MouseEntered
        coDT23.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_tambahanData23MouseEntered

    private void tambahanData23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahanData23ActionPerformed
        coDT21.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 0", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coDT22.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coDT23.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        coDT24.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        showDataAddDT2();
    }//GEN-LAST:event_tambahanData23ActionPerformed

    private void tambahanData24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahanData24MouseExited
        coDT24.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_tambahanData24MouseExited

    private void tambahanData24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahanData24MouseEntered
        coDT24.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_tambahanData24MouseEntered

    private void tambahanData24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahanData24ActionPerformed
        coDT21.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 0", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coDT22.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coDT23.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        
        coDT24.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        
        showDataAddDT2();
    }//GEN-LAST:event_tambahanData24ActionPerformed

    private void tambahanData25MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahanData25MouseExited
        coAddDT2.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_tambahanData25MouseExited

    private void tambahanData25MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahanData25MouseEntered
        coAddDT2.setBackground(new Color(138, 226, 239));
    }//GEN-LAST:event_tambahanData25MouseEntered

    private void tambahanData25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahanData25ActionPerformed
        if(tambahanData25.isSelected()) {
            coAddDT2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(3, 155, 216)),
            null));
        } else {
            coAddDT2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createTitledBorder(null, "+ 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
            new java.awt.Font("Poppins Medium", 0, 21), new java.awt.Color(0,0,0)),
            null));
        }
    }//GEN-LAST:event_tambahanData25ActionPerformed

    private void nextButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButton2MouseExited
        panelBtn22.setBackground(new Color(3,155,216));
    }//GEN-LAST:event_nextButton2MouseExited

    private void nextButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButton2MouseEntered
        panelBtn22.setBackground(new Color(1, 100, 139));
    }//GEN-LAST:event_nextButton2MouseEntered

    private void nextButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButton2ActionPerformed
        // TODO add your handling code here:
        DetailDataFrame toDetail = new DetailDataFrame();

        toDetail.getDetailData(nik.getText());
        toDetail.getDetailTambahan(nik.getText());
        toDetail.setVisible(true);
        
        toDetail.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_nextButton2ActionPerformed

    private void nextButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButton3MouseExited
        panelBtn23.setBackground(new Color(3,155,216));
    }//GEN-LAST:event_nextButton3MouseExited

    private void nextButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButton3MouseEntered
        panelBtn23.setBackground(new Color(1, 100, 139));
    }//GEN-LAST:event_nextButton3MouseEntered

    private void nextButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButton3ActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            // Tindakan yang diambil jika pengguna memilih Yes (Ya)
            
            MainBoard mainBoard = new MainBoard();
            mainBoard.databasePanel.setVisible(false);
            mainBoard.panelDashboard.setVisible(false);
            mainBoard.panelData.setVisible(true);
            mainBoard.setVisible(true);
            this.dispose();
//            System.out.println("Anda memilih Yes (Ya)");
        } else {
            // Tindakan yang diambil jika pengguna memilih No (Tidak) atau menutup dialog
//            System.out.println("Anda memilih No (Tidak) atau menutup dialog");
        }
    }//GEN-LAST:event_nextButton3ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        panelDbDataLengkap.setBackground(new Color(1, 100, 139));
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        panelDbDataLengkap.setBackground(new Color(3,155,216));
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        panelDbHapus.setBackground(new Color(3,155,216));
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        panelDbHapus.setBackground(new Color(1, 100, 139));
    }//GEN-LAST:event_jButton3MouseEntered

    private void btnInputData5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInputData5ActionPerformed
        panelDashboard.setVisible(false);
        panelData.setVisible(false);
        databasePanel.setVisible(false);
        aboutMe.setVisible(true);
    }//GEN-LAST:event_btnInputData5ActionPerformed

    private void btnInputData5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInputData5MouseEntered
        // TODO add your handling code here:
        menu9.setBackground(new Color(155, 164, 181));
    }//GEN-LAST:event_btnInputData5MouseEntered

    private void btnInputData5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInputData5MouseExited
        // TODO add your handling code here:
        menu9.setBackground(new Color(1, 100, 139));
    }//GEN-LAST:event_btnInputData5MouseExited

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Hasil1;
    private javax.swing.JPanel Hasil2;
    private javax.swing.JPanel Hasil3;
    private javax.swing.JPanel MainPanel;
    private GUI_Custom.TableDark TabelHistory;
    private javax.swing.JPanel aboutMe;
    private GUI_Custom.TextField alamat;
    private javax.swing.JPanel appName;
    private javax.swing.JButton backButton;
    private javax.swing.JPanel badan;
    private javax.swing.ButtonGroup badanGrup;
    private javax.swing.JPanel badanTambahanPanel;
    private javax.swing.JPanel blank;
    private javax.swing.JPanel blank15;
    private javax.swing.JPanel blank6;
    private javax.swing.JRadioButton btnArahKanan;
    private javax.swing.JRadioButton btnArahKiri;
    private javax.swing.JRadioButton btnB1;
    private javax.swing.JRadioButton btnB2;
    private javax.swing.JRadioButton btnB3;
    private javax.swing.JRadioButton btnB4;
    private javax.swing.JPanel btnGrupDown;
    private javax.swing.JButton btnInputData;
    private javax.swing.JButton btnInputData1;
    private javax.swing.JButton btnInputData8;
    private javax.swing.JRadioButton btnK1;
    private javax.swing.JRadioButton btnK2;
    private javax.swing.JRadioButton btnL1;
    private javax.swing.JRadioButton btnL2;
    private javax.swing.JRadioButton btnL3;
    private javax.swing.JRadioButton btnL4;
    private javax.swing.JRadioButton btnLA10;
    private javax.swing.JRadioButton btnLA6;
    private javax.swing.JRadioButton btnLA7;
    private javax.swing.JRadioButton btnLA8;
    private javax.swing.JRadioButton btnLA9;
    private javax.swing.JRadioButton btnLB1;
    private javax.swing.JRadioButton btnLB2;
    private javax.swing.JRadioButton btnLB3;
    private javax.swing.JRadioButton btnPPT1;
    private javax.swing.JRadioButton btnPPT2;
    private javax.swing.JRadioButton btnPT1;
    private javax.swing.JRadioButton btnPT2;
    private javax.swing.JRadioButton btnPT3;
    private javax.swing.JRadioButton btnPT4;
    private javax.swing.JPanel cardInputData;
    private javax.swing.JPanel coAddB1;
    private javax.swing.JPanel coAddB2;
    private javax.swing.JPanel coAddDT1;
    private javax.swing.JPanel coAddDT2;
    private javax.swing.JPanel coAddL1;
    private javax.swing.JPanel coAddL2;
    private javax.swing.JPanel coAddLA1;
    private javax.swing.JPanel coAddLA2;
    private javax.swing.JPanel coAddLA3;
    private javax.swing.JPanel coAddLB1;
    private javax.swing.JPanel coAddPT1;
    private javax.swing.JPanel coB1;
    private javax.swing.JPanel coB2;
    private javax.swing.JPanel coB3;
    private javax.swing.JPanel coB4;
    private javax.swing.JPanel coDT11;
    private javax.swing.JPanel coDT12;
    private javax.swing.JPanel coDT13;
    private javax.swing.JPanel coDT14;
    private javax.swing.JPanel coDT21;
    private javax.swing.JPanel coDT22;
    private javax.swing.JPanel coDT23;
    private javax.swing.JPanel coDT24;
    private javax.swing.JPanel coK1;
    private javax.swing.JPanel coK2;
    private javax.swing.JPanel coL1;
    private javax.swing.JPanel coL2;
    private javax.swing.JPanel coL3;
    private javax.swing.JPanel coL4;
    private javax.swing.JPanel coLA1;
    private javax.swing.JPanel coLA2;
    private javax.swing.JPanel coLA3;
    private javax.swing.JPanel coLA4;
    private javax.swing.JPanel coLA5;
    private javax.swing.JPanel coLB1;
    private javax.swing.JPanel coLB2;
    private javax.swing.JPanel coLB3;
    private javax.swing.JPanel coPPT1;
    private javax.swing.JPanel coPPT2;
    private javax.swing.JPanel coPT1;
    private javax.swing.JPanel coPT2;
    private javax.swing.JPanel coPT3;
    private javax.swing.JPanel coPT4;
    private javax.swing.JPanel dataDiri;
    private javax.swing.JPanel dataPekerjaanPanel;
    private javax.swing.JPanel dataPersonalPanel;
    private javax.swing.ButtonGroup dataTambahan1;
    private javax.swing.JPanel dataTambahan1Panel;
    private javax.swing.ButtonGroup dataTambahan2;
    private javax.swing.JPanel dataTambahan2Panel;
    private javax.swing.JPanel databasePanel;
    private javax.swing.JLabel displayHasil;
    private javax.swing.JLabel displayKerentanan;
    private javax.swing.JLabel displayKeterangan;
    private GUI_Custom.TextField durasiBekerja;
    private javax.swing.JPanel finalHasil;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel281;
    private javax.swing.JPanel jPanel282;
    private javax.swing.JPanel jPanel283;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel297;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel308;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel323;
    private javax.swing.JPanel jPanel324;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel334;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel342;
    private javax.swing.JPanel jPanel345;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel437;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel79;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel jPanel82;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel85;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private GUI_Custom.ComboBoxSuggestion jenisKelamin;
    private GUI_Custom.ComboBoxSuggestion jenisKerja;
    private javax.swing.JPanel kaki;
    private javax.swing.ButtonGroup kakiGrup;
    private GUI_Custom.TextField keluhan;
    private GUI_Custom.TextField lamaBekerja;
    private javax.swing.JPanel left;
    private javax.swing.JPanel leher;
    private javax.swing.ButtonGroup leherGrup;
    private javax.swing.JPanel leherTambahanPanel;
    private javax.swing.JPanel lenganAtas;
    private javax.swing.ButtonGroup lenganAtasGrup;
    private javax.swing.JPanel lenganAtasTambahanPanel;
    private javax.swing.JPanel lenganBawah;
    private javax.swing.ButtonGroup lenganBawahGrup;
    private javax.swing.JPanel lenganBawahTambahanPanel;
    private GUI_Custom.PanelRound menu1;
    private GUI_Custom.PanelRound menu2;
    private GUI_Custom.PanelRound menu9;
    private javax.swing.JPanel menuList;
    private javax.swing.JPanel menuList1;
    private GUI_Custom.TextField nama;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton nextButton1;
    private javax.swing.JButton nextButton2;
    private javax.swing.JButton nextButton3;
    private GUI_Custom.TextField nik;
    private GUI_Custom.TextField nomorTelephone;
    private javax.swing.JPanel pInputData;
    private GUI_Custom.PanelRound panelBtn22;
    private GUI_Custom.PanelRound panelBtn23;
    private GUI_Custom.PanelRound panelBtnBack;
    private GUI_Custom.PanelRound panelBtnNext;
    private javax.swing.JPanel panelBtnNext1;
    private javax.swing.JPanel panelBtnNext2;
    private javax.swing.JPanel panelDashboard;
    private javax.swing.JPanel panelData;
    private javax.swing.JPanel panelDbDataLengkap;
    private javax.swing.JPanel panelDbHapus;
    private javax.swing.JPanel panelGrupLenganAtas;
    private javax.swing.JPanel panelGrupSisiBadan;
    private GUI_Custom.PanelRound panelNextBtn1;
    private javax.swing.JPanel panelSisiKanan;
    private javax.swing.JPanel panelSisiKiri;
    private GUI_Custom.TextField pekerjaan;
    private javax.swing.JPanel pergelanganTangan;
    private javax.swing.ButtonGroup pergelanganTanganGrup;
    private javax.swing.JPanel pergelanganTanganTambahanPanel;
    private javax.swing.JPanel pilihSisi;
    private javax.swing.JPanel putarPergelanganTangan;
    private javax.swing.ButtonGroup putarPergelanganTanganGrup;
    public javax.swing.JPanel right;
    private javax.swing.JCheckBox secDataB1;
    private javax.swing.JCheckBox secDataB2;
    private javax.swing.JCheckBox secDataL1;
    private javax.swing.JCheckBox secDataL2;
    private javax.swing.JCheckBox secDataLA1;
    private javax.swing.JCheckBox secDataLA2;
    private javax.swing.JCheckBox secDataLA3;
    private javax.swing.JCheckBox secDataLB;
    private javax.swing.JCheckBox secDataPT;
    private javax.swing.ButtonGroup sisiBadan;
    private javax.swing.JPanel tambahan1;
    private javax.swing.JPanel tambahan2;
    private javax.swing.JRadioButton tambahanData1;
    private javax.swing.JRadioButton tambahanData2;
    private javax.swing.JRadioButton tambahanData21;
    private javax.swing.JRadioButton tambahanData22;
    private javax.swing.JRadioButton tambahanData23;
    private javax.swing.JRadioButton tambahanData24;
    private javax.swing.JRadioButton tambahanData25;
    private javax.swing.JRadioButton tambahanData3;
    private javax.swing.JRadioButton tambahanData4;
    private javax.swing.JRadioButton tambahanData5;
    private GUI_Custom.TextField umur;
    // End of variables declaration//GEN-END:variables
}
