/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rulav3;

import Database.Database;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author surya
 */
public class DetailDataFrame extends javax.swing.JFrame {

    /**
     * Creates new form DetailDataFrame
     */
   
    
    public DetailDataFrame() {
        initComponents();
    }
    
    
   public void CetakPDF(JPanel panel) {
    PrinterJob printerJob = PrinterJob.getPrinterJob();
    printerJob.setJobName("Print Record");
    
    // Mengatur ukuran PageFormat sebagai A4
    PageFormat pageFormat = printerJob.defaultPage();
    Paper paper = pageFormat.getPaper();
    double width = 595.0;  // Lebar A4 dalam piksel (72 piksel per inci)
    double height = 842.0; // Tinggi A4 dalam piksel (72 piksel per inci)
    double margin = 10.0;  // Margin dalam piksel
    paper.setSize(width, height);
    paper.setImageableArea(margin, margin, width - 2 * margin, height - 2 * margin);
    pageFormat.setPaper(paper);
    
    printerJob.setPrintable(new Printable() {
        @Override
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
            if (pageIndex > 0) {
                return Printable.NO_SUCH_PAGE;
            }

            Graphics2D graphics2D = (Graphics2D) graphics;
            graphics2D.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

            // Menyesuaikan skala grafis agar tidak terlalu kecil
            double scaleX = pageFormat.getImageableWidth() / panel.getWidth();
            double scaleY = pageFormat.getImageableHeight() / panel.getHeight();
            graphics2D.scale(scaleX, scaleY);

            panel.paint(graphics2D);
            return Printable.PAGE_EXISTS;
        }
    });

    boolean returnResult = printerJob.printDialog();
    if (returnResult) {
        try {
            printerJob.print();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}


    
    void getDetailData(String nik) {
        try {
            String sql = "SELECT * FROM t_data WHERE nik ='" + nik + "'";
            java.sql.Connection conn = (Connection) Database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            

            // Memindahkan kursor ResultSet ke baris pertama (jika ada)
            if (res.next()) {
                // Set Data Detail Personal
                displayNama.setText(" " + res.getString("nama"));
                displayNik.setText(" " + res.getString("nik"));
                displayUmur.setText(" " + res.getString("umur"));
                displayJenisKelamin.setText(" " + res.getString("jenis_kelamin"));
                displayAlamat.setText("<html> " + res.getString("alamat") + "</html>");
                displayNomorTelephone.setText(" " + res.getString("nomor_telephone"));
                displayPekerjaan.setText("( " + res.getString("pekerjaan") + " )");
                displayLamaBekerja.setText(" " + res.getString("lama_bekerja") + " Tahun");
                displayDurasiBekerja.setText(" " + res.getString("durasi_bekerja") + " Jam");
                displayJenisKerja.setText(" " + res.getString("jenis_kerja"));
                displayKeluhan.setText("<html> "+ res.getString("keluhan") +" </html>");
                
                
                // Set Data Skor Rula
                String finalScore = res.getString("score_c");
                switch(finalScore) {
                    case "1" : case "2" : displayFinalScore.setForeground(Color.green);
                        break;
                    case "3" : case "4" : displayFinalScore.setForeground(Color.yellow);
                        break;
                    case "5" : case "6" : displayFinalScore.setForeground(Color.orange);
                        break;
                    default :
                        displayFinalScore.setForeground(Color.red);
                        break;
                }
                displayFinalScore.setText(finalScore);
                displayKerentanan.setText(res.getString("kerentanan"));
                displayPenjelasan.setText(res.getString("final_hasil"));
                
                // badan
                String gambarSisiBadan = res.getString("sisi_badan");
                switch(gambarSisiBadan) {
                    case "1" : 
                        gSisiBadan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/left_side_final.png")));
                        tBadan.setText("Kiri");
                        break;
                    default : 
                        gSisiBadan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/right_side_final.png")));
                        tBadan.setText("Kanan");
                        break;
                }
                
                // Lengan Atas
                String gambarLenganAtas = res.getString("lengan_atas");
               
                switch(gambarLenganAtas) {
                    case "1" :
                        gLenganAtas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/upperarm1_final.png")));
                        break;
                    case "2" :
                        gLenganAtas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/upperarm2_final.png")));
                        break;
                    case "3" :
                        gLenganAtas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/upperarm3_final.png")));
                        break;
                    default : 
                        gLenganAtas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/upperarm5_final.png")));
                        break;
                }
                
                // Lengan Bawah
                String gambarLenganBawah = res.getString("lengan_bawah");
               
                switch(gambarLenganBawah) {
                    case "1" :
                        gLenganBawah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/lowerarm1_final.png")));
                        break;
                    case "2" :
                        gLenganBawah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/lowerarm2_final.png")));
                        break;
                    default : 
                        gLenganBawah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/lowerarm3_final.png")));
                        break;
                }
                
                // Pergelangan Tangan
                String gambarPergelanganTangan = res.getString("pergelangan_tangan");
               
                switch(gambarPergelanganTangan) {
                    case "1" :
                        gPergelanganTangan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/wrist1_final.png")));
                        break;
                    case "2" :
                        gPergelanganTangan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/wrist2_final.png")));
                        break;
                    case "3" : 
                        gPergelanganTangan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/wrist3_final.png")));
                        break;
                    default:
                        gPergelanganTangan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/wrist4_final.png")));
                        break;
                }
                
                // Putar Pergelangan Tangan
                String gambarPutarPergelangan = res.getString("putar_pergelangan_tangan");
               
                switch(gambarPutarPergelangan) {
                    case "1" :
                        gPutarPergelangan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/wrist_twist1_final.png")));
                        tPutarPergelangan.setText("Tidak memutar");
                        break;
                    default:
                        gPutarPergelangan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/wrist_twist2_final.png")));
                        tPutarPergelangan.setText("Memutar");
                        break;
                }
                
                // Opsional Data 1
                String opsionalData1 = res.getString("tambahan_data");
               
                switch(opsionalData1) {
                    case "0" :
                        tOP1.setText("<html><b>Score 0</b> - Tidak ada perlawanan - Beban kurang dari 2kg</html>");
                        break;
                    case "1" :
                        tOP1.setText("<html><b>Score 1</b> - Beban 2kg sampai 10kg </html>");
                        break;
                    case "2" :
                        tOP1.setText("<html><b>Score 2</b> - Beban berulang 2kg sampai 10kg - Beban lebih dari 10kg </html>");
                        break;
                    default:
                        tOP1.setText("<html><b>Score 3</b> - Beban lebih dari 10kg - Shock atau berulang</html>");
                        break;
                }
                
                // Leher
                String gambarLeher = res.getString("leher");
               
                switch(gambarLeher) {
                    case "1" :
                        gLeher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/neck1.png")));
                        break;
                    case "2" :
                        gLeher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/neck2.png")));
                        break;
                    case "3" :
                        gLeher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/neck3.png")));
                        break;
                    default:
                        gLeher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/neck4.png")));
                        break;
                }
                
                // Badan
                String gambarBadan = res.getString("badan");
               
                switch(gambarBadan) {
                    case "1" :
                        gBadan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/trunk1.png")));
                        break;
                    case "2" :
                        gBadan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/trunk2.png")));
                        break;
                    case "3" :
                        gBadan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/trunk3.png")));
                        break;
                    default:
                        gBadan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/trunk4.png")));
                        break;
                }
                
                // Kaki
                String gambarKaki = res.getString("kaki");
               
                switch(gambarKaki) {
                    case "1" :
                        gKaki.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/legs1.png")));
                        tKaki.setText("Tidak Terangkat");
                        break;
                    default:
                        gKaki.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/legs2.png")));
                        tKaki.setText("Terangkat");
                        break;
                }
                
                // Opsional Data 2
                String opsionalData2 = res.getString("tambahan_data2");
               
                switch(opsionalData2) {
                    case "0" :
                        tOP2.setText("<html><b>Score 0</b> - Tidak ada perlawanan - Beban kurang dari 2kg</html>");
                        break;
                    case "1" :
                        tOP2.setText("<html><b>Score 1</b> - Beban 2kg sampai 10kg </html>");
                        break;
                    case "2" :
                        tOP2.setText("<html><b>Score 2</b> - Beban berulang 2kg sampai 10kg - Beban lebih dari 10kg </html>");
                        break;
                    default:
                        tOP2.setText("<html><b>Score 3</b> - Beban lebih dari 10kg - Shock atau berulang</html>");
                        break;
                }

            } else {
                // Jika hasil query kosong, tambahkan penanganan yang sesuai di sini
                // Misalnya, menampilkan pesan bahwa data tidak ditemukan
                System.out.println("Data tidak ditemukan");
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void getDetailTambahan(String nik) {
        
        clLA2.setVisible(false);
        clLB2.setVisible(false);
        clPT2.setVisible(false);
        clOP2.setVisible(false);
        clLeher2.setVisible(false);
        clB2.setVisible(false);
        clOP22.setVisible(false);
        
        // DATA TAMBAHAN
        try {
            String sql2 = "SELECT * FROM t_add WHERE nik ='" + nik + "'";
            java.sql.Connection conn2 = (Connection) Database.configDB();
            java.sql.Statement stm2 = conn2.createStatement();
            java.sql.ResultSet res2 = stm2.executeQuery(sql2);
                
            if (res2.next()) {
                // Set data dari ResultSet res2 ke variabel-variabel yang diperlukan
                
                // Lengan Atas
                String addLenganAtas1 = res2.getString("la_1");
                if(!"1".equals(addLenganAtas1)) {
                    addLA1.setVisible(false);
                    
                }
                String addLenganAtas2 = res2.getString("la_2");
                if(!"1".equals(addLenganAtas2)) {
                    addLA2.setVisible(false);
                }
                String addLenganAtas3 = res2.getString("la_3");
                if(!"1".equals(addLenganAtas3)) {
                    addLA3.setVisible(false);
                }
                if("0".equals(addLenganAtas1) && "0".equals(addLenganAtas2) && "0".equals(addLenganAtas3)) {
                    clLA1.setVisible(false);
                    clLA2.setVisible(true);
                }
                
                // Lengan Bawah
                String addLenganBawah = res2.getString("lb_1");
                if(!"1".equals(addLenganBawah)) {
                    clLB1.setVisible(false);
                    clLB2.setVisible(true);                    
                } 
                
                // Pergelangan Tangan
                String addPergelanganTangan = res2.getString("pt_1");
                if(!"1".equals(addPergelanganTangan)) {
                    clPT1.setVisible(false);
                    clPT2.setVisible(true);
                } 
                
                // Opsional Data 1
                String addOpsionalData1 = res2.getString("op_1");
                if(!"1".equals(addOpsionalData1)) {
                    clOP1.setVisible(false);
                    clOP2.setVisible(true);
                    
                } 
                
                // Leher
                String addLeher1 = res2.getString("lh_1");
                if(!"1".equals(addLeher1)) {
                    addL1.setVisible(false);
                    
                }
                String addLeher2 = res2.getString("lh_2");
                if(!"1".equals(addLeher2)) {
                    addL2.setVisible(false);
                    
                } 
                if("0".equals(addLeher1) && "0".equals(addLeher2)) {
                    clLeher1.setVisible(false);
                    clLeher2.setVisible(true);
                }
                
                // Badan
                String addBadan1 = res2.getString("bd_1");
                if(!"1".equals(addBadan1)) {
                    addB1.setVisible(false);
                    
                }
                String addbadan2 = res2.getString("bd_2");
                if(!"1".equals(addbadan2)) {
                    addB2.setVisible(false);
                    
                } 
                if("0".equals(addBadan1) && "0".equals(addbadan2)) {
                    clB1.setVisible(false);
                    clB2.setVisible(true);
                }
                
                // Opsional Data 2
                String addOpsionalData2 = res2.getString("op_2");
                if(!"1".equals(addOpsionalData2)) {
                    clOP21.setVisible(false);
                    clOP22.setVisible(true);
                    
                } 
                
            } else {
                // Jika hasil query kosong, tambahkan penanganan yang sesuai di sini
                // Misalnya, menampilkan pesan bahwa data tidak ditemukan
                System.out.println("Data tidak ditemukan");
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        containerDetail = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        headerDetail = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        informasiPersonal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        displayNama = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        displayNik = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        displayUmur = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        displayJenisKelamin = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        displayAlamat = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        displayNomorTelephone = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        displayPekerjaan = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        displayLamaBekerja = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        displayDurasiBekerja = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        displayJenisKerja = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        displayKeluhan = new javax.swing.JLabel();
        informasiPersonal1 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        jPanel53 = new javax.swing.JPanel();
        displayFinalScore = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        jPanel144 = new javax.swing.JPanel();
        displayKerentanan = new javax.swing.JLabel();
        jPanel146 = new javax.swing.JPanel();
        displayPenjelasan = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jPanel55 = new javax.swing.JPanel();
        gSisiBadan = new javax.swing.JLabel();
        jPanel56 = new javax.swing.JPanel();
        jPanel57 = new javax.swing.JPanel();
        jPanel59 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel62 = new javax.swing.JPanel();
        tBadan = new javax.swing.JLabel();
        jPanel58 = new javax.swing.JPanel();
        jPanel61 = new javax.swing.JPanel();
        jPanel65 = new javax.swing.JPanel();
        jPanel60 = new javax.swing.JPanel();
        jPanel63 = new javax.swing.JPanel();
        gLenganAtas = new javax.swing.JLabel();
        jPanel64 = new javax.swing.JPanel();
        jPanel66 = new javax.swing.JPanel();
        jPanel67 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jPanel69 = new javax.swing.JPanel();
        clLA1 = new javax.swing.JPanel();
        addLA1 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        addLA2 = new javax.swing.JPanel();
        jCheckBox2 = new javax.swing.JCheckBox();
        addLA3 = new javax.swing.JPanel();
        jCheckBox3 = new javax.swing.JCheckBox();
        clLA2 = new javax.swing.JPanel();
        addLA4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel72 = new javax.swing.JPanel();
        jPanel73 = new javax.swing.JPanel();
        gLenganBawah = new javax.swing.JLabel();
        jPanel74 = new javax.swing.JPanel();
        jPanel75 = new javax.swing.JPanel();
        jPanel76 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jPanel77 = new javax.swing.JPanel();
        jPanel78 = new javax.swing.JPanel();
        clLB1 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();
        clLB2 = new javax.swing.JPanel();
        addLA5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel80 = new javax.swing.JPanel();
        jPanel81 = new javax.swing.JPanel();
        gPergelanganTangan = new javax.swing.JLabel();
        jPanel82 = new javax.swing.JPanel();
        jPanel83 = new javax.swing.JPanel();
        jPanel84 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jPanel85 = new javax.swing.JPanel();
        jPanel86 = new javax.swing.JPanel();
        clPT1 = new javax.swing.JPanel();
        jPanel88 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jCheckBox5 = new javax.swing.JCheckBox();
        clPT2 = new javax.swing.JPanel();
        addLA6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel98 = new javax.swing.JPanel();
        jPanel99 = new javax.swing.JPanel();
        gPutarPergelangan = new javax.swing.JLabel();
        jPanel100 = new javax.swing.JPanel();
        jPanel101 = new javax.swing.JPanel();
        jPanel102 = new javax.swing.JPanel();
        jPanel105 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jPanel106 = new javax.swing.JPanel();
        tPutarPergelangan = new javax.swing.JLabel();
        jPanel103 = new javax.swing.JPanel();
        jPanel104 = new javax.swing.JPanel();
        jPanel107 = new javax.swing.JPanel();
        jPanel109 = new javax.swing.JPanel();
        jPanel110 = new javax.swing.JPanel();
        jPanel108 = new javax.swing.JPanel();
        jPanel111 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jPanel116 = new javax.swing.JPanel();
        tOP1 = new javax.swing.JCheckBox();
        jPanel112 = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        clOP1 = new javax.swing.JPanel();
        jPanel143 = new javax.swing.JPanel();
        jCheckBox14 = new javax.swing.JCheckBox();
        clOP2 = new javax.swing.JPanel();
        addLA7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel89 = new javax.swing.JPanel();
        jPanel90 = new javax.swing.JPanel();
        gLeher = new javax.swing.JLabel();
        jPanel91 = new javax.swing.JPanel();
        jPanel92 = new javax.swing.JPanel();
        jPanel93 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jPanel94 = new javax.swing.JPanel();
        clLeher1 = new javax.swing.JPanel();
        addL1 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jCheckBox7 = new javax.swing.JCheckBox();
        addL2 = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jCheckBox8 = new javax.swing.JCheckBox();
        clLeher2 = new javax.swing.JPanel();
        addLA8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel114 = new javax.swing.JPanel();
        jPanel115 = new javax.swing.JPanel();
        gBadan = new javax.swing.JLabel();
        jPanel117 = new javax.swing.JPanel();
        jPanel118 = new javax.swing.JPanel();
        jPanel119 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jPanel120 = new javax.swing.JPanel();
        clB1 = new javax.swing.JPanel();
        addB1 = new javax.swing.JPanel();
        jPanel51 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jCheckBox10 = new javax.swing.JCheckBox();
        addB2 = new javax.swing.JPanel();
        jPanel124 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jCheckBox11 = new javax.swing.JCheckBox();
        clB2 = new javax.swing.JPanel();
        addLA9 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel125 = new javax.swing.JPanel();
        jPanel126 = new javax.swing.JPanel();
        gKaki = new javax.swing.JLabel();
        jPanel127 = new javax.swing.JPanel();
        jPanel128 = new javax.swing.JPanel();
        jPanel129 = new javax.swing.JPanel();
        jPanel130 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jPanel131 = new javax.swing.JPanel();
        tKaki = new javax.swing.JLabel();
        jPanel132 = new javax.swing.JPanel();
        jPanel133 = new javax.swing.JPanel();
        jPanel134 = new javax.swing.JPanel();
        jPanel135 = new javax.swing.JPanel();
        jPanel136 = new javax.swing.JPanel();
        jPanel137 = new javax.swing.JPanel();
        jPanel138 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jPanel139 = new javax.swing.JPanel();
        tOP2 = new javax.swing.JCheckBox();
        jPanel140 = new javax.swing.JPanel();
        clOP21 = new javax.swing.JPanel();
        jPanel142 = new javax.swing.JPanel();
        jCheckBox13 = new javax.swing.JCheckBox();
        clOP22 = new javax.swing.JPanel();
        addLA10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        print = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1088, 638));
        setPreferredSize(new java.awt.Dimension(1700, 1825));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        containerDetail.setBackground(new java.awt.Color(255, 255, 255));
        containerDetail.setLayout(new javax.swing.BoxLayout(containerDetail, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 1, 1));
        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 100));
        jPanel2.setPreferredSize(new java.awt.Dimension(1057, 80));

        headerDetail.setFont(new java.awt.Font("Poppins Black", 1, 35)); // NOI18N
        headerDetail.setText("DETAIL DATA PERHITUNGAN RULA");
        jPanel2.add(headerDetail);

        containerDetail.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 16, 1, 16));
        jPanel3.setMaximumSize(new java.awt.Dimension(32767, 2000));
        jPanel3.setMinimumSize(new java.awt.Dimension(0, 660));
        jPanel3.setPreferredSize(new java.awt.Dimension(1300, 300));
        jPanel3.setLayout(new java.awt.GridLayout(1, 2));

        informasiPersonal.setBackground(new java.awt.Color(255, 255, 255));
        informasiPersonal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informasi Personal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins Medium", 0, 16))); // NOI18N
        informasiPersonal.setMaximumSize(new java.awt.Dimension(1300, 260));
        informasiPersonal.setMinimumSize(new java.awt.Dimension(1000, 260));
        informasiPersonal.setPreferredSize(new java.awt.Dimension(1000, 400));
        informasiPersonal.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 200));
        jPanel1.setMinimumSize(new java.awt.Dimension(650, 200));
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(new java.awt.GridLayout(6, 1, 10, 0));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMaximumSize(new java.awt.Dimension(32767, 25));
        jPanel5.setMinimumSize(new java.awt.Dimension(300, 20));
        jPanel5.setPreferredSize(new java.awt.Dimension(522, 20));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        displayNama.setFont(new java.awt.Font("Poppins Black", 0, 30)); // NOI18N
        displayNama.setText("I Kadek Arya Surya Saputra");
        jPanel5.add(displayNama);

        jPanel1.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setMaximumSize(new java.awt.Dimension(32767, 30));
        jPanel6.setMinimumSize(new java.awt.Dimension(300, 20));
        jPanel6.setPreferredSize(new java.awt.Dimension(522, 25));
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.X_AXIS));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setFont(new java.awt.Font("Poppins ExtraLight", 0, 20)); // NOI18N
        jLabel1.setText("NIK                           ");
        jPanel7.add(jLabel1);

        jPanel6.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setMaximumSize(new java.awt.Dimension(5, 20));
        jPanel8.setMinimumSize(new java.awt.Dimension(5, 20));
        jPanel8.setOpaque(false);
        jPanel8.setPreferredSize(new java.awt.Dimension(10, 20));
        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.LINE_AXIS));

        jLabel2.setFont(new java.awt.Font("Poppins ExtraLight", 0, 20)); // NOI18N
        jLabel2.setText(":    ");
        jLabel2.setMaximumSize(new java.awt.Dimension(20, 22));
        jLabel2.setMinimumSize(new java.awt.Dimension(20, 22));
        jLabel2.setPreferredSize(new java.awt.Dimension(30, 22));
        jPanel8.add(jLabel2);

        jPanel6.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

        displayNik.setFont(new java.awt.Font("Poppins ExtraLight", 0, 20)); // NOI18N
        displayNik.setText("9807892378647248");
        jPanel9.add(displayNik);

        jPanel6.add(jPanel9);

        jPanel1.add(jPanel6);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setMaximumSize(new java.awt.Dimension(32767, 30));
        jPanel10.setMinimumSize(new java.awt.Dimension(300, 20));
        jPanel10.setPreferredSize(new java.awt.Dimension(522, 25));
        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.X_AXIS));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.LINE_AXIS));

        jLabel4.setFont(new java.awt.Font("Poppins ExtraLight", 0, 20)); // NOI18N
        jLabel4.setText("Umur                       ");
        jPanel11.add(jLabel4);

        jPanel10.add(jPanel11);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setMaximumSize(new java.awt.Dimension(5, 20));
        jPanel12.setMinimumSize(new java.awt.Dimension(5, 20));
        jPanel12.setOpaque(false);
        jPanel12.setPreferredSize(new java.awt.Dimension(10, 20));
        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.LINE_AXIS));

        jLabel5.setFont(new java.awt.Font("Poppins ExtraLight", 0, 20)); // NOI18N
        jLabel5.setText(":     ");
        jLabel5.setMaximumSize(new java.awt.Dimension(20, 22));
        jLabel5.setMinimumSize(new java.awt.Dimension(20, 22));
        jLabel5.setPreferredSize(new java.awt.Dimension(30, 22));
        jPanel12.add(jLabel5);

        jPanel10.add(jPanel12);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.LINE_AXIS));

        displayUmur.setFont(new java.awt.Font("Poppins ExtraLight", 0, 20)); // NOI18N
        displayUmur.setText("12");
        jPanel13.add(displayUmur);

        jPanel10.add(jPanel13);

        jPanel1.add(jPanel10);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setMaximumSize(new java.awt.Dimension(32767, 30));
        jPanel14.setMinimumSize(new java.awt.Dimension(300, 20));
        jPanel14.setPreferredSize(new java.awt.Dimension(522, 25));
        jPanel14.setLayout(new javax.swing.BoxLayout(jPanel14, javax.swing.BoxLayout.X_AXIS));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(new javax.swing.BoxLayout(jPanel15, javax.swing.BoxLayout.LINE_AXIS));

        jLabel7.setFont(new java.awt.Font("Poppins ExtraLight", 0, 20)); // NOI18N
        jLabel7.setText("Jenis Kelamin          ");
        jPanel15.add(jLabel7);

        jPanel14.add(jPanel15);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setMaximumSize(new java.awt.Dimension(5, 20));
        jPanel16.setMinimumSize(new java.awt.Dimension(5, 20));
        jPanel16.setOpaque(false);
        jPanel16.setPreferredSize(new java.awt.Dimension(10, 20));
        jPanel16.setLayout(new javax.swing.BoxLayout(jPanel16, javax.swing.BoxLayout.LINE_AXIS));

        jLabel8.setFont(new java.awt.Font("Poppins ExtraLight", 0, 20)); // NOI18N
        jLabel8.setText(":     ");
        jLabel8.setMaximumSize(new java.awt.Dimension(20, 22));
        jLabel8.setMinimumSize(new java.awt.Dimension(20, 22));
        jLabel8.setPreferredSize(new java.awt.Dimension(30, 22));
        jPanel16.add(jLabel8);

        jPanel14.add(jPanel16);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setLayout(new javax.swing.BoxLayout(jPanel17, javax.swing.BoxLayout.LINE_AXIS));

        displayJenisKelamin.setFont(new java.awt.Font("Poppins ExtraLight", 0, 20)); // NOI18N
        displayJenisKelamin.setText("Laki- Laki");
        jPanel17.add(displayJenisKelamin);

        jPanel14.add(jPanel17);

        jPanel1.add(jPanel14);

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setMaximumSize(new java.awt.Dimension(32767, 30));
        jPanel18.setMinimumSize(new java.awt.Dimension(300, 20));
        jPanel18.setPreferredSize(new java.awt.Dimension(522, 30));
        jPanel18.setLayout(new javax.swing.BoxLayout(jPanel18, javax.swing.BoxLayout.X_AXIS));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setLayout(new javax.swing.BoxLayout(jPanel19, javax.swing.BoxLayout.LINE_AXIS));

        jLabel10.setFont(new java.awt.Font("Poppins ExtraLight", 0, 20)); // NOI18N
        jLabel10.setText("Alamat                    ");
        jPanel19.add(jLabel10);

        jPanel18.add(jPanel19);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setMaximumSize(new java.awt.Dimension(5, 20));
        jPanel20.setMinimumSize(new java.awt.Dimension(5, 20));
        jPanel20.setOpaque(false);
        jPanel20.setPreferredSize(new java.awt.Dimension(10, 20));
        jPanel20.setLayout(new javax.swing.BoxLayout(jPanel20, javax.swing.BoxLayout.LINE_AXIS));

        jLabel11.setFont(new java.awt.Font("Poppins ExtraLight", 0, 20)); // NOI18N
        jLabel11.setText(":     ");
        jLabel11.setMaximumSize(new java.awt.Dimension(20, 22));
        jLabel11.setMinimumSize(new java.awt.Dimension(20, 22));
        jLabel11.setPreferredSize(new java.awt.Dimension(30, 22));
        jPanel20.add(jLabel11);

        jPanel18.add(jPanel20);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setLayout(new javax.swing.BoxLayout(jPanel21, javax.swing.BoxLayout.LINE_AXIS));

        displayAlamat.setFont(new java.awt.Font("Poppins ExtraLight", 0, 14)); // NOI18N
        displayAlamat.setText("Jln SoeKarno Hatta asd");
        jPanel21.add(displayAlamat);

        jPanel18.add(jPanel21);

        jPanel1.add(jPanel18);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setMaximumSize(new java.awt.Dimension(32767, 30));
        jPanel22.setMinimumSize(new java.awt.Dimension(300, 20));
        jPanel22.setPreferredSize(new java.awt.Dimension(522, 25));
        jPanel22.setLayout(new javax.swing.BoxLayout(jPanel22, javax.swing.BoxLayout.X_AXIS));

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setLayout(new javax.swing.BoxLayout(jPanel23, javax.swing.BoxLayout.LINE_AXIS));

        jLabel13.setFont(new java.awt.Font("Poppins ExtraLight", 0, 20)); // NOI18N
        jLabel13.setText("Nomor Telephone  ");
        jPanel23.add(jLabel13);

        jPanel22.add(jPanel23);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setMaximumSize(new java.awt.Dimension(5, 20));
        jPanel24.setMinimumSize(new java.awt.Dimension(5, 20));
        jPanel24.setOpaque(false);
        jPanel24.setPreferredSize(new java.awt.Dimension(10, 20));
        jPanel24.setLayout(new javax.swing.BoxLayout(jPanel24, javax.swing.BoxLayout.LINE_AXIS));

        jLabel14.setFont(new java.awt.Font("Poppins ExtraLight", 0, 20)); // NOI18N
        jLabel14.setText(":     ");
        jLabel14.setMaximumSize(new java.awt.Dimension(20, 22));
        jLabel14.setMinimumSize(new java.awt.Dimension(20, 22));
        jLabel14.setPreferredSize(new java.awt.Dimension(30, 22));
        jPanel24.add(jLabel14);

        jPanel22.add(jPanel24);

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setLayout(new javax.swing.BoxLayout(jPanel25, javax.swing.BoxLayout.LINE_AXIS));

        displayNomorTelephone.setFont(new java.awt.Font("Poppins ExtraLight", 0, 20)); // NOI18N
        displayNomorTelephone.setText("087753231841");
        jPanel25.add(displayNomorTelephone);

        jPanel22.add(jPanel25);

        jPanel1.add(jPanel22);

        informasiPersonal.add(jPanel1);

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel26.setMaximumSize(new java.awt.Dimension(32767, 200));
        jPanel26.setMinimumSize(new java.awt.Dimension(650, 200));
        jPanel26.setName(""); // NOI18N
        jPanel26.setLayout(new java.awt.GridLayout(6, 1, 10, 0));

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setMaximumSize(new java.awt.Dimension(32767, 25));
        jPanel27.setMinimumSize(new java.awt.Dimension(300, 20));
        jPanel27.setPreferredSize(new java.awt.Dimension(522, 20));
        jPanel27.setLayout(new javax.swing.BoxLayout(jPanel27, javax.swing.BoxLayout.LINE_AXIS));

        displayPekerjaan.setFont(new java.awt.Font("Poppins Light", 0, 30)); // NOI18N
        displayPekerjaan.setText("( Programmer )");
        jPanel27.add(displayPekerjaan);

        jPanel26.add(jPanel27);

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setMaximumSize(new java.awt.Dimension(32767, 30));
        jPanel28.setMinimumSize(new java.awt.Dimension(300, 20));
        jPanel28.setPreferredSize(new java.awt.Dimension(522, 25));
        jPanel28.setLayout(new javax.swing.BoxLayout(jPanel28, javax.swing.BoxLayout.X_AXIS));

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setLayout(new javax.swing.BoxLayout(jPanel29, javax.swing.BoxLayout.LINE_AXIS));

        jLabel16.setFont(new java.awt.Font("Poppins ExtraLight", 0, 20)); // NOI18N
        jLabel16.setText("Lama Bekerja   ");
        jPanel29.add(jLabel16);

        jPanel28.add(jPanel29);

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setMaximumSize(new java.awt.Dimension(5, 20));
        jPanel30.setMinimumSize(new java.awt.Dimension(5, 20));
        jPanel30.setOpaque(false);
        jPanel30.setPreferredSize(new java.awt.Dimension(10, 20));
        jPanel30.setLayout(new javax.swing.BoxLayout(jPanel30, javax.swing.BoxLayout.LINE_AXIS));

        jLabel17.setFont(new java.awt.Font("Poppins ExtraLight", 0, 20)); // NOI18N
        jLabel17.setText(":     ");
        jLabel17.setMaximumSize(new java.awt.Dimension(20, 22));
        jLabel17.setMinimumSize(new java.awt.Dimension(20, 22));
        jLabel17.setPreferredSize(new java.awt.Dimension(30, 22));
        jPanel30.add(jLabel17);

        jPanel28.add(jPanel30);

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31.setLayout(new javax.swing.BoxLayout(jPanel31, javax.swing.BoxLayout.LINE_AXIS));

        displayLamaBekerja.setFont(new java.awt.Font("Poppins ExtraLight", 0, 20)); // NOI18N
        displayLamaBekerja.setText("9807892378647248");
        jPanel31.add(displayLamaBekerja);

        jPanel28.add(jPanel31);

        jPanel26.add(jPanel28);

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.setMaximumSize(new java.awt.Dimension(32767, 30));
        jPanel32.setMinimumSize(new java.awt.Dimension(300, 20));
        jPanel32.setPreferredSize(new java.awt.Dimension(522, 25));
        jPanel32.setLayout(new javax.swing.BoxLayout(jPanel32, javax.swing.BoxLayout.X_AXIS));

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));
        jPanel33.setLayout(new javax.swing.BoxLayout(jPanel33, javax.swing.BoxLayout.LINE_AXIS));

        jLabel19.setFont(new java.awt.Font("Poppins ExtraLight", 0, 20)); // NOI18N
        jLabel19.setText("Durasi Bekerja  ");
        jPanel33.add(jLabel19);

        jPanel32.add(jPanel33);

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));
        jPanel34.setMaximumSize(new java.awt.Dimension(5, 20));
        jPanel34.setMinimumSize(new java.awt.Dimension(5, 20));
        jPanel34.setOpaque(false);
        jPanel34.setPreferredSize(new java.awt.Dimension(10, 20));
        jPanel34.setLayout(new javax.swing.BoxLayout(jPanel34, javax.swing.BoxLayout.LINE_AXIS));

        jLabel20.setFont(new java.awt.Font("Poppins ExtraLight", 0, 20)); // NOI18N
        jLabel20.setText(":     ");
        jLabel20.setMaximumSize(new java.awt.Dimension(20, 22));
        jLabel20.setMinimumSize(new java.awt.Dimension(20, 22));
        jLabel20.setPreferredSize(new java.awt.Dimension(30, 22));
        jPanel34.add(jLabel20);

        jPanel32.add(jPanel34);

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.setLayout(new javax.swing.BoxLayout(jPanel35, javax.swing.BoxLayout.LINE_AXIS));

        displayDurasiBekerja.setFont(new java.awt.Font("Poppins ExtraLight", 0, 20)); // NOI18N
        displayDurasiBekerja.setText("12");
        jPanel35.add(displayDurasiBekerja);

        jPanel32.add(jPanel35);

        jPanel26.add(jPanel32);

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));
        jPanel36.setMaximumSize(new java.awt.Dimension(32767, 30));
        jPanel36.setMinimumSize(new java.awt.Dimension(300, 20));
        jPanel36.setPreferredSize(new java.awt.Dimension(522, 25));
        jPanel36.setLayout(new javax.swing.BoxLayout(jPanel36, javax.swing.BoxLayout.X_AXIS));

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setLayout(new javax.swing.BoxLayout(jPanel37, javax.swing.BoxLayout.LINE_AXIS));

        jLabel22.setFont(new java.awt.Font("Poppins ExtraLight", 0, 20)); // NOI18N
        jLabel22.setText("Jenis Kerja        ");
        jPanel37.add(jLabel22);

        jPanel36.add(jPanel37);

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38.setMaximumSize(new java.awt.Dimension(5, 20));
        jPanel38.setMinimumSize(new java.awt.Dimension(5, 20));
        jPanel38.setOpaque(false);
        jPanel38.setPreferredSize(new java.awt.Dimension(10, 20));
        jPanel38.setLayout(new javax.swing.BoxLayout(jPanel38, javax.swing.BoxLayout.LINE_AXIS));

        jLabel23.setFont(new java.awt.Font("Poppins ExtraLight", 0, 20)); // NOI18N
        jLabel23.setText(":     ");
        jLabel23.setMaximumSize(new java.awt.Dimension(20, 22));
        jLabel23.setMinimumSize(new java.awt.Dimension(20, 22));
        jLabel23.setPreferredSize(new java.awt.Dimension(30, 22));
        jPanel38.add(jLabel23);

        jPanel36.add(jPanel38);

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setLayout(new javax.swing.BoxLayout(jPanel39, javax.swing.BoxLayout.LINE_AXIS));

        displayJenisKerja.setFont(new java.awt.Font("Poppins ExtraLight", 0, 20)); // NOI18N
        displayJenisKerja.setText("Laki - Laki");
        jPanel39.add(displayJenisKerja);

        jPanel36.add(jPanel39);

        jPanel26.add(jPanel36);

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setMaximumSize(new java.awt.Dimension(32767, 30));
        jPanel40.setMinimumSize(new java.awt.Dimension(300, 20));
        jPanel40.setPreferredSize(new java.awt.Dimension(522, 25));
        jPanel40.setLayout(new javax.swing.BoxLayout(jPanel40, javax.swing.BoxLayout.X_AXIS));

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));
        jPanel41.setLayout(new javax.swing.BoxLayout(jPanel41, javax.swing.BoxLayout.LINE_AXIS));

        jLabel25.setFont(new java.awt.Font("Poppins ExtraLight", 0, 20)); // NOI18N
        jLabel25.setText("Keluhan            ");
        jPanel41.add(jLabel25);

        jPanel40.add(jPanel41);

        jPanel42.setBackground(new java.awt.Color(255, 255, 255));
        jPanel42.setMaximumSize(new java.awt.Dimension(5, 20));
        jPanel42.setMinimumSize(new java.awt.Dimension(5, 20));
        jPanel42.setOpaque(false);
        jPanel42.setPreferredSize(new java.awt.Dimension(10, 20));
        jPanel42.setLayout(new javax.swing.BoxLayout(jPanel42, javax.swing.BoxLayout.LINE_AXIS));

        jLabel26.setFont(new java.awt.Font("Poppins ExtraLight", 0, 20)); // NOI18N
        jLabel26.setText(":     ");
        jLabel26.setMaximumSize(new java.awt.Dimension(20, 22));
        jLabel26.setMinimumSize(new java.awt.Dimension(20, 22));
        jLabel26.setPreferredSize(new java.awt.Dimension(30, 22));
        jPanel42.add(jLabel26);

        jPanel40.add(jPanel42);

        jPanel43.setBackground(new java.awt.Color(255, 255, 255));
        jPanel43.setLayout(new javax.swing.BoxLayout(jPanel43, javax.swing.BoxLayout.LINE_AXIS));

        displayKeluhan.setFont(new java.awt.Font("Poppins ExtraLight", 0, 20)); // NOI18N
        displayKeluhan.setText("Jln SoeKarno Hatta asd");
        jPanel43.add(displayKeluhan);

        jPanel40.add(jPanel43);

        jPanel26.add(jPanel40);

        informasiPersonal.add(jPanel26);

        jPanel3.add(informasiPersonal);

        informasiPersonal1.setBackground(new java.awt.Color(255, 255, 255));
        informasiPersonal1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Skor Perhitungan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins Medium", 0, 16))); // NOI18N
        informasiPersonal1.setMaximumSize(new java.awt.Dimension(3000, 260));
        informasiPersonal1.setMinimumSize(new java.awt.Dimension(500, 260));
        informasiPersonal1.setPreferredSize(new java.awt.Dimension(500, 300));
        informasiPersonal1.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jPanel52.setBackground(new java.awt.Color(255, 255, 255));
        jPanel52.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel52.setMaximumSize(new java.awt.Dimension(32767, 200));
        jPanel52.setMinimumSize(new java.awt.Dimension(650, 200));
        jPanel52.setName(""); // NOI18N
        jPanel52.setPreferredSize(new java.awt.Dimension(683, 400));
        jPanel52.setLayout(new javax.swing.BoxLayout(jPanel52, javax.swing.BoxLayout.LINE_AXIS));

        jPanel53.setBackground(new java.awt.Color(255, 255, 255));
        jPanel53.setMaximumSize(new java.awt.Dimension(1000, 95));
        jPanel53.setMinimumSize(new java.awt.Dimension(100, 80));
        jPanel53.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel53.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        displayFinalScore.setFont(new java.awt.Font("Poppins Black", 0, 70)); // NOI18N
        displayFinalScore.setText("4");
        displayFinalScore.setPreferredSize(new java.awt.Dimension(50, 100));
        jPanel53.add(displayFinalScore);

        jPanel52.add(jPanel53);

        jPanel54.setMinimumSize(new java.awt.Dimension(600, 192));
        jPanel54.setLayout(new javax.swing.BoxLayout(jPanel54, javax.swing.BoxLayout.Y_AXIS));

        jPanel144.setBackground(new java.awt.Color(255, 255, 255));
        jPanel144.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kerentanan", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Poppins", 0, 20))); // NOI18N

        displayKerentanan.setFont(new java.awt.Font("Poppins SemiBold", 0, 40)); // NOI18N
        displayKerentanan.setText("4");
        jPanel144.add(displayKerentanan);

        jPanel54.add(jPanel144);

        jPanel146.setBackground(new java.awt.Color(255, 255, 255));
        jPanel146.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Penjelasan", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Poppins", 0, 20))); // NOI18N

        displayPenjelasan.setFont(new java.awt.Font("Poppins SemiBold", 0, 21)); // NOI18N
        displayPenjelasan.setText("ASDANSDAKSNDASD");
        jPanel146.add(displayPenjelasan);

        jPanel54.add(jPanel146);

        jPanel52.add(jPanel54);

        informasiPersonal1.add(jPanel52);

        jPanel3.add(informasiPersonal1);

        containerDetail.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 16, 1, 16));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jPanel44.setBackground(new java.awt.Color(255, 255, 255));
        jPanel44.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Postur Tubuh", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins Medium", 0, 16)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10))); // NOI18N
        jPanel44.setPreferredSize(new java.awt.Dimension(1000, 1400));
        jPanel44.setLayout(new java.awt.GridLayout(5, 2, 5, 5));

        jPanel45.setBackground(new java.awt.Color(255, 255, 255));
        jPanel45.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10)));
        jPanel45.setMaximumSize(new java.awt.Dimension(250, 270));
        jPanel45.setMinimumSize(new java.awt.Dimension(250, 270));
        jPanel45.setPreferredSize(new java.awt.Dimension(250, 270));
        jPanel45.setLayout(new java.awt.GridLayout(1, 0));

        jPanel55.setBackground(new java.awt.Color(255, 255, 255));
        jPanel55.setMaximumSize(new java.awt.Dimension(100, 32767));
        jPanel55.setPreferredSize(new java.awt.Dimension(100, 250));

        gSisiBadan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gSisiBadan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/right_side_final.png"))); // NOI18N
        jPanel55.add(gSisiBadan);

        jPanel45.add(jPanel55);

        jPanel56.setLayout(new javax.swing.BoxLayout(jPanel56, javax.swing.BoxLayout.Y_AXIS));

        jPanel57.setBackground(new java.awt.Color(255, 255, 255));
        jPanel57.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1));
        jPanel57.setMaximumSize(new java.awt.Dimension(32767, 200));
        jPanel57.setLayout(new javax.swing.BoxLayout(jPanel57, javax.swing.BoxLayout.Y_AXIS));

        jPanel59.setBackground(new java.awt.Color(255, 255, 255));
        jPanel59.setMaximumSize(new java.awt.Dimension(32767, 50));
        jPanel59.setLayout(new javax.swing.BoxLayout(jPanel59, javax.swing.BoxLayout.LINE_AXIS));

        jLabel29.setFont(new java.awt.Font("Poppins SemiBold", 0, 30)); // NOI18N
        jLabel29.setText("SISI BADAN");
        jPanel59.add(jLabel29);

        jPanel57.add(jPanel59);

        jPanel62.setBackground(new java.awt.Color(255, 255, 255));
        jPanel62.setMaximumSize(new java.awt.Dimension(32767, 50));
        jPanel62.setLayout(new javax.swing.BoxLayout(jPanel62, javax.swing.BoxLayout.LINE_AXIS));

        tBadan.setFont(new java.awt.Font("Poppins Light", 0, 25)); // NOI18N
        tBadan.setText("Kanan");
        jPanel62.add(tBadan);

        jPanel57.add(jPanel62);

        jPanel56.add(jPanel57);

        jPanel58.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 155, Short.MAX_VALUE)
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 147, Short.MAX_VALUE)
        );

        jPanel56.add(jPanel58);

        jPanel45.add(jPanel56);

        jPanel61.setLayout(new javax.swing.BoxLayout(jPanel61, javax.swing.BoxLayout.Y_AXIS));

        jPanel65.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 155, Short.MAX_VALUE)
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 264, Short.MAX_VALUE)
        );

        jPanel61.add(jPanel65);

        jPanel45.add(jPanel61);

        jPanel44.add(jPanel45);

        jPanel60.setBackground(new java.awt.Color(255, 255, 255));
        jPanel60.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10)));
        jPanel60.setMaximumSize(new java.awt.Dimension(250, 270));
        jPanel60.setMinimumSize(new java.awt.Dimension(250, 270));
        jPanel60.setPreferredSize(new java.awt.Dimension(250, 270));
        jPanel60.setLayout(new javax.swing.BoxLayout(jPanel60, javax.swing.BoxLayout.LINE_AXIS));

        jPanel63.setBackground(new java.awt.Color(255, 255, 255));
        jPanel63.setMaximumSize(new java.awt.Dimension(200, 32767));
        jPanel63.setPreferredSize(new java.awt.Dimension(300, 250));
        jPanel63.setLayout(new javax.swing.BoxLayout(jPanel63, javax.swing.BoxLayout.LINE_AXIS));

        gLenganAtas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gLenganAtas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/upperarm1_final.png"))); // NOI18N
        gLenganAtas.setMaximumSize(new java.awt.Dimension(107, 300));
        gLenganAtas.setMinimumSize(new java.awt.Dimension(107, 300));
        gLenganAtas.setPreferredSize(new java.awt.Dimension(306, 300));
        jPanel63.add(gLenganAtas);

        jPanel60.add(jPanel63);

        jPanel64.setLayout(new javax.swing.BoxLayout(jPanel64, javax.swing.BoxLayout.Y_AXIS));

        jPanel66.setBackground(new java.awt.Color(255, 255, 255));
        jPanel66.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1));
        jPanel66.setMaximumSize(new java.awt.Dimension(32767, 200));
        jPanel66.setLayout(new javax.swing.BoxLayout(jPanel66, javax.swing.BoxLayout.Y_AXIS));

        jPanel67.setBackground(new java.awt.Color(255, 255, 255));
        jPanel67.setMaximumSize(new java.awt.Dimension(32767, 50));
        jPanel67.setLayout(new javax.swing.BoxLayout(jPanel67, javax.swing.BoxLayout.LINE_AXIS));

        jLabel32.setFont(new java.awt.Font("Poppins SemiBold", 0, 30)); // NOI18N
        jLabel32.setText("LENGAN ATAS");
        jPanel67.add(jLabel32);

        jPanel66.add(jPanel67);

        jPanel64.add(jPanel66);

        jPanel69.setBackground(new java.awt.Color(255, 255, 255));
        jPanel69.setLayout(new java.awt.CardLayout());

        clLA1.setBackground(new java.awt.Color(255, 255, 255));
        clLA1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Tambahan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins Thin", 0, 16)), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 20))); // NOI18N
        clLA1.setLayout(new java.awt.GridLayout(3, 0));

        addLA1.setBackground(new java.awt.Color(255, 255, 255));
        addLA1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        addLA1.setLayout(new javax.swing.BoxLayout(addLA1, javax.swing.BoxLayout.LINE_AXIS));

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Bahu dinaikan");
        jCheckBox1.setEnabled(false);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        addLA1.add(jCheckBox1);

        clLA1.add(addLA1);

        addLA2.setBackground(new java.awt.Color(255, 255, 255));
        addLA2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        addLA2.setLayout(new javax.swing.BoxLayout(addLA2, javax.swing.BoxLayout.LINE_AXIS));

        jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jCheckBox2.setSelected(true);
        jCheckBox2.setText("Lengan atas ditopang atau Bersandar");
        jCheckBox2.setEnabled(false);
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        addLA2.add(jCheckBox2);

        clLA1.add(addLA2);

        addLA3.setBackground(new java.awt.Color(255, 255, 255));
        addLA3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        addLA3.setLayout(new javax.swing.BoxLayout(addLA3, javax.swing.BoxLayout.LINE_AXIS));

        jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jCheckBox3.setSelected(true);
        jCheckBox3.setText("Lengan atas di abduksi");
        jCheckBox3.setEnabled(false);
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        addLA3.add(jCheckBox3);

        clLA1.add(addLA3);

        jPanel69.add(clLA1, "card2");

        clLA2.setBackground(new java.awt.Color(255, 255, 255));
        clLA2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Tambahan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins Thin", 0, 16)), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5))); // NOI18N
        clLA2.setLayout(new javax.swing.BoxLayout(clLA2, javax.swing.BoxLayout.LINE_AXIS));

        addLA4.setBackground(new java.awt.Color(255, 255, 255));
        addLA4.setBorder(javax.swing.BorderFactory.createEmptyBorder(40, 1, 1, 1));

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel3.setText("Tidak terdapat data tambahan!");
        addLA4.add(jLabel3);

        clLA2.add(addLA4);

        jPanel69.add(clLA2, "card2");

        jPanel64.add(jPanel69);

        jPanel60.add(jPanel64);

        jPanel44.add(jPanel60);

        jPanel72.setBackground(new java.awt.Color(255, 255, 255));
        jPanel72.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10)));
        jPanel72.setMaximumSize(new java.awt.Dimension(250, 270));
        jPanel72.setMinimumSize(new java.awt.Dimension(250, 270));
        jPanel72.setPreferredSize(new java.awt.Dimension(250, 270));
        jPanel72.setLayout(new javax.swing.BoxLayout(jPanel72, javax.swing.BoxLayout.LINE_AXIS));

        jPanel73.setBackground(new java.awt.Color(255, 255, 255));
        jPanel73.setMaximumSize(new java.awt.Dimension(200, 32767));
        jPanel73.setPreferredSize(new java.awt.Dimension(300, 250));
        jPanel73.setLayout(new javax.swing.BoxLayout(jPanel73, javax.swing.BoxLayout.LINE_AXIS));

        gLenganBawah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gLenganBawah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/upperarm1_final.png"))); // NOI18N
        gLenganBawah.setMaximumSize(new java.awt.Dimension(107, 300));
        gLenganBawah.setMinimumSize(new java.awt.Dimension(107, 300));
        gLenganBawah.setPreferredSize(new java.awt.Dimension(306, 300));
        jPanel73.add(gLenganBawah);

        jPanel72.add(jPanel73);

        jPanel74.setLayout(new javax.swing.BoxLayout(jPanel74, javax.swing.BoxLayout.Y_AXIS));

        jPanel75.setBackground(new java.awt.Color(255, 255, 255));
        jPanel75.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1));
        jPanel75.setMaximumSize(new java.awt.Dimension(32767, 200));
        jPanel75.setLayout(new javax.swing.BoxLayout(jPanel75, javax.swing.BoxLayout.Y_AXIS));

        jPanel76.setBackground(new java.awt.Color(255, 255, 255));
        jPanel76.setMaximumSize(new java.awt.Dimension(32767, 50));
        jPanel76.setLayout(new javax.swing.BoxLayout(jPanel76, javax.swing.BoxLayout.LINE_AXIS));

        jLabel34.setFont(new java.awt.Font("Poppins SemiBold", 0, 30)); // NOI18N
        jLabel34.setText("LENGAN BAWAH");
        jPanel76.add(jLabel34);

        jPanel75.add(jPanel76);

        jPanel74.add(jPanel75);

        jPanel77.setBackground(new java.awt.Color(255, 255, 255));
        jPanel77.setLayout(new javax.swing.BoxLayout(jPanel77, javax.swing.BoxLayout.LINE_AXIS));

        jPanel78.setBackground(new java.awt.Color(255, 255, 255));
        jPanel78.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Tambahan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins Thin", 0, 16)), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5))); // NOI18N
        jPanel78.setLayout(new java.awt.CardLayout());

        clLB1.setBackground(new java.awt.Color(255, 255, 255));
        clLB1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        clLB1.setLayout(new javax.swing.BoxLayout(clLB1, javax.swing.BoxLayout.LINE_AXIS));

        jPanel47.setLayout(new javax.swing.BoxLayout(jPanel47, javax.swing.BoxLayout.LINE_AXIS));
        clLB1.add(jPanel47);

        jLabel35.setBackground(new java.awt.Color(0, 0, 0));
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/lowerarm4_final.png"))); // NOI18N
        clLB1.add(jLabel35);

        jCheckBox4.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jCheckBox4.setSelected(true);
        jCheckBox4.setText("<html>Salah satu tangan bekerja melintasi garis tengah atau kesamping tubuh</html>");
        jCheckBox4.setToolTipText("");
        jCheckBox4.setEnabled(false);
        clLB1.add(jCheckBox4);

        jPanel78.add(clLB1, "card2");

        clLB2.setBackground(new java.awt.Color(255, 255, 255));
        clLB2.setLayout(new javax.swing.BoxLayout(clLB2, javax.swing.BoxLayout.LINE_AXIS));

        addLA5.setBackground(new java.awt.Color(255, 255, 255));
        addLA5.setBorder(javax.swing.BorderFactory.createEmptyBorder(40, 1, 1, 1));

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel6.setText("Tidak terdapat data tambahan!");
        addLA5.add(jLabel6);

        clLB2.add(addLA5);

        jPanel78.add(clLB2, "card2");

        jPanel77.add(jPanel78);

        jPanel74.add(jPanel77);

        jPanel72.add(jPanel74);

        jPanel44.add(jPanel72);

        jPanel80.setBackground(new java.awt.Color(255, 255, 255));
        jPanel80.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10)));
        jPanel80.setMaximumSize(new java.awt.Dimension(250, 270));
        jPanel80.setMinimumSize(new java.awt.Dimension(250, 270));
        jPanel80.setPreferredSize(new java.awt.Dimension(250, 270));
        jPanel80.setLayout(new javax.swing.BoxLayout(jPanel80, javax.swing.BoxLayout.LINE_AXIS));

        jPanel81.setBackground(new java.awt.Color(255, 255, 255));
        jPanel81.setMaximumSize(new java.awt.Dimension(200, 32767));
        jPanel81.setPreferredSize(new java.awt.Dimension(300, 250));
        jPanel81.setLayout(new javax.swing.BoxLayout(jPanel81, javax.swing.BoxLayout.LINE_AXIS));

        gPergelanganTangan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gPergelanganTangan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/wrist3_final.png"))); // NOI18N
        gPergelanganTangan.setMaximumSize(new java.awt.Dimension(107, 300));
        gPergelanganTangan.setMinimumSize(new java.awt.Dimension(107, 300));
        gPergelanganTangan.setPreferredSize(new java.awt.Dimension(306, 300));
        jPanel81.add(gPergelanganTangan);

        jPanel80.add(jPanel81);

        jPanel82.setLayout(new javax.swing.BoxLayout(jPanel82, javax.swing.BoxLayout.Y_AXIS));

        jPanel83.setBackground(new java.awt.Color(255, 255, 255));
        jPanel83.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1));
        jPanel83.setMaximumSize(new java.awt.Dimension(32767, 200));
        jPanel83.setLayout(new javax.swing.BoxLayout(jPanel83, javax.swing.BoxLayout.Y_AXIS));

        jPanel84.setBackground(new java.awt.Color(255, 255, 255));
        jPanel84.setMaximumSize(new java.awt.Dimension(32767, 50));
        jPanel84.setLayout(new javax.swing.BoxLayout(jPanel84, javax.swing.BoxLayout.LINE_AXIS));

        jLabel37.setFont(new java.awt.Font("Poppins SemiBold", 0, 30)); // NOI18N
        jLabel37.setText("Pergelangan Tangan");
        jPanel84.add(jLabel37);

        jPanel83.add(jPanel84);

        jPanel82.add(jPanel83);

        jPanel85.setBackground(new java.awt.Color(255, 255, 255));
        jPanel85.setLayout(new javax.swing.BoxLayout(jPanel85, javax.swing.BoxLayout.LINE_AXIS));

        jPanel86.setBackground(new java.awt.Color(255, 255, 255));
        jPanel86.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Tambahan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins Thin", 0, 16)), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5))); // NOI18N
        jPanel86.setLayout(new java.awt.CardLayout());

        clPT1.setBackground(new java.awt.Color(255, 255, 255));
        clPT1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        clPT1.setLayout(new javax.swing.BoxLayout(clPT1, javax.swing.BoxLayout.LINE_AXIS));

        jPanel88.setLayout(new javax.swing.BoxLayout(jPanel88, javax.swing.BoxLayout.LINE_AXIS));
        clPT1.add(jPanel88);

        jLabel38.setBackground(new java.awt.Color(0, 0, 0));
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/wrist5_final.png"))); // NOI18N
        clPT1.add(jLabel38);

        jCheckBox5.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox5.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jCheckBox5.setSelected(true);
        jCheckBox5.setText("<html>Salah satu tangan bekerja melintasi garis tengah atau kesamping tubuh</html>");
        jCheckBox5.setToolTipText("");
        jCheckBox5.setEnabled(false);
        clPT1.add(jCheckBox5);

        jPanel86.add(clPT1, "card2");

        clPT2.setBackground(new java.awt.Color(255, 255, 255));
        clPT2.setLayout(new javax.swing.BoxLayout(clPT2, javax.swing.BoxLayout.LINE_AXIS));

        addLA6.setBackground(new java.awt.Color(255, 255, 255));
        addLA6.setBorder(javax.swing.BorderFactory.createEmptyBorder(40, 1, 1, 1));

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel9.setText("Tidak terdapat data tambahan!");
        addLA6.add(jLabel9);

        clPT2.add(addLA6);

        jPanel86.add(clPT2, "card2");

        jPanel85.add(jPanel86);

        jPanel82.add(jPanel85);

        jPanel80.add(jPanel82);

        jPanel44.add(jPanel80);

        jPanel98.setBackground(new java.awt.Color(255, 255, 255));
        jPanel98.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10)));
        jPanel98.setMaximumSize(new java.awt.Dimension(250, 270));
        jPanel98.setMinimumSize(new java.awt.Dimension(250, 270));
        jPanel98.setPreferredSize(new java.awt.Dimension(250, 270));
        jPanel98.setLayout(new javax.swing.BoxLayout(jPanel98, javax.swing.BoxLayout.LINE_AXIS));

        jPanel99.setBackground(new java.awt.Color(255, 255, 255));
        jPanel99.setMaximumSize(new java.awt.Dimension(200, 32767));
        jPanel99.setPreferredSize(new java.awt.Dimension(300, 250));
        jPanel99.setLayout(new javax.swing.BoxLayout(jPanel99, javax.swing.BoxLayout.LINE_AXIS));

        gPutarPergelangan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gPutarPergelangan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/wrist_twist1_final.png"))); // NOI18N
        gPutarPergelangan.setMaximumSize(new java.awt.Dimension(107, 300));
        gPutarPergelangan.setMinimumSize(new java.awt.Dimension(107, 300));
        gPutarPergelangan.setPreferredSize(new java.awt.Dimension(306, 300));
        jPanel99.add(gPutarPergelangan);

        jPanel98.add(jPanel99);

        jPanel100.setLayout(new javax.swing.BoxLayout(jPanel100, javax.swing.BoxLayout.Y_AXIS));

        jPanel101.setBackground(new java.awt.Color(255, 255, 255));
        jPanel101.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1));
        jPanel101.setMaximumSize(new java.awt.Dimension(32767, 200));
        jPanel101.setLayout(new javax.swing.BoxLayout(jPanel101, javax.swing.BoxLayout.Y_AXIS));

        jPanel102.setBackground(new java.awt.Color(255, 255, 255));
        jPanel102.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1));
        jPanel102.setMaximumSize(new java.awt.Dimension(32767, 200));
        jPanel102.setLayout(new javax.swing.BoxLayout(jPanel102, javax.swing.BoxLayout.Y_AXIS));

        jPanel105.setBackground(new java.awt.Color(255, 255, 255));
        jPanel105.setMaximumSize(new java.awt.Dimension(32767, 50));
        jPanel105.setLayout(new javax.swing.BoxLayout(jPanel105, javax.swing.BoxLayout.LINE_AXIS));

        jLabel43.setFont(new java.awt.Font("Poppins SemiBold", 0, 30)); // NOI18N
        jLabel43.setText("PUTAR PERGELANGAN TANGAN");
        jPanel105.add(jLabel43);

        jPanel102.add(jPanel105);

        jPanel106.setBackground(new java.awt.Color(255, 255, 255));
        jPanel106.setMaximumSize(new java.awt.Dimension(32767, 50));
        jPanel106.setLayout(new javax.swing.BoxLayout(jPanel106, javax.swing.BoxLayout.LINE_AXIS));

        tPutarPergelangan.setFont(new java.awt.Font("Poppins Light", 0, 25)); // NOI18N
        tPutarPergelangan.setText("Kanan");
        jPanel106.add(tPutarPergelangan);

        jPanel102.add(jPanel106);

        jPanel101.add(jPanel102);

        jPanel100.add(jPanel101);

        jPanel103.setBackground(new java.awt.Color(255, 255, 255));
        jPanel103.setLayout(new javax.swing.BoxLayout(jPanel103, javax.swing.BoxLayout.LINE_AXIS));

        jPanel104.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel104Layout = new javax.swing.GroupLayout(jPanel104);
        jPanel104.setLayout(jPanel104Layout);
        jPanel104Layout.setHorizontalGroup(
            jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );
        jPanel104Layout.setVerticalGroup(
            jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 116, Short.MAX_VALUE)
        );

        jPanel103.add(jPanel104);

        jPanel100.add(jPanel103);

        jPanel98.add(jPanel100);

        jPanel44.add(jPanel98);

        jPanel107.setBackground(new java.awt.Color(255, 255, 255));
        jPanel107.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10)));
        jPanel107.setMaximumSize(new java.awt.Dimension(250, 270));
        jPanel107.setMinimumSize(new java.awt.Dimension(250, 270));
        jPanel107.setPreferredSize(new java.awt.Dimension(250, 270));
        jPanel107.setLayout(new javax.swing.BoxLayout(jPanel107, javax.swing.BoxLayout.LINE_AXIS));

        jPanel109.setBackground(new java.awt.Color(255, 255, 255));
        jPanel109.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 1, 1));
        jPanel109.setLayout(new javax.swing.BoxLayout(jPanel109, javax.swing.BoxLayout.Y_AXIS));

        jPanel110.setBackground(new java.awt.Color(255, 255, 255));
        jPanel110.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1));
        jPanel110.setMaximumSize(new java.awt.Dimension(32767, 200));
        jPanel110.setLayout(new javax.swing.BoxLayout(jPanel110, javax.swing.BoxLayout.Y_AXIS));

        jPanel108.setBackground(new java.awt.Color(255, 255, 255));
        jPanel108.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel108.setMaximumSize(new java.awt.Dimension(32767, 200));
        jPanel108.setLayout(new javax.swing.BoxLayout(jPanel108, javax.swing.BoxLayout.Y_AXIS));

        jPanel111.setBackground(new java.awt.Color(255, 255, 255));
        jPanel111.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 30));
        jPanel111.setMaximumSize(new java.awt.Dimension(32767, 50));
        jPanel111.setLayout(new javax.swing.BoxLayout(jPanel111, javax.swing.BoxLayout.LINE_AXIS));

        jLabel45.setFont(new java.awt.Font("Poppins SemiBold", 0, 30)); // NOI18N
        jLabel45.setText("OPSIONAL DATA 1");
        jPanel111.add(jLabel45);

        jPanel108.add(jPanel111);

        jPanel116.setBackground(new java.awt.Color(255, 255, 255));
        jPanel116.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 30));
        jPanel116.setMaximumSize(new java.awt.Dimension(32767, 60));
        jPanel116.setLayout(new javax.swing.BoxLayout(jPanel116, javax.swing.BoxLayout.LINE_AXIS));

        tOP1.setBackground(new java.awt.Color(255, 255, 255));
        tOP1.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        tOP1.setSelected(true);
        tOP1.setText("<html><b>Score 0</b> - Tidak ada perlawanan - Beban kurang dari 2kg</html>");
        tOP1.setEnabled(false);
        tOP1.setMaximumSize(new java.awt.Dimension(700, 31));
        tOP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tOP1ActionPerformed(evt);
            }
        });
        jPanel116.add(tOP1);

        jPanel108.add(jPanel116);

        jPanel110.add(jPanel108);

        jPanel109.add(jPanel110);

        jPanel112.setBackground(new java.awt.Color(255, 255, 255));
        jPanel112.setLayout(new javax.swing.BoxLayout(jPanel112, javax.swing.BoxLayout.LINE_AXIS));

        jPanel48.setBackground(new java.awt.Color(255, 255, 255));
        jPanel48.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Tambahan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins Thin", 0, 16)), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 20))); // NOI18N
        jPanel48.setLayout(new java.awt.CardLayout());

        clOP1.setBackground(new java.awt.Color(255, 255, 255));
        clOP1.setLayout(new java.awt.GridLayout(3, 0));

        jPanel143.setBackground(new java.awt.Color(255, 255, 255));
        jPanel143.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        jPanel143.setLayout(new javax.swing.BoxLayout(jPanel143, javax.swing.BoxLayout.LINE_AXIS));

        jCheckBox14.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox14.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jCheckBox14.setSelected(true);
        jCheckBox14.setText("<html>Jika postur terutama statis (yaitu ditahan > I menit), Atau jika tindakan berulang terjadi 4x per menit</html>");
        jCheckBox14.setEnabled(false);
        jCheckBox14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox14ActionPerformed(evt);
            }
        });
        jPanel143.add(jCheckBox14);

        clOP1.add(jPanel143);

        jPanel48.add(clOP1, "card2");

        clOP2.setBackground(new java.awt.Color(255, 255, 255));
        clOP2.setLayout(new javax.swing.BoxLayout(clOP2, javax.swing.BoxLayout.LINE_AXIS));

        addLA7.setBackground(new java.awt.Color(255, 255, 255));
        addLA7.setBorder(javax.swing.BorderFactory.createEmptyBorder(40, 1, 1, 1));

        jLabel12.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel12.setText("Tidak terdapat data tambahan!");
        addLA7.add(jLabel12);

        clOP2.add(addLA7);

        jPanel48.add(clOP2, "card2");

        jPanel112.add(jPanel48);

        jPanel109.add(jPanel112);

        jPanel107.add(jPanel109);

        jPanel44.add(jPanel107);

        jPanel89.setBackground(new java.awt.Color(255, 255, 255));
        jPanel89.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10)));
        jPanel89.setMaximumSize(new java.awt.Dimension(250, 270));
        jPanel89.setMinimumSize(new java.awt.Dimension(250, 270));
        jPanel89.setPreferredSize(new java.awt.Dimension(250, 270));
        jPanel89.setLayout(new javax.swing.BoxLayout(jPanel89, javax.swing.BoxLayout.LINE_AXIS));

        jPanel90.setBackground(new java.awt.Color(255, 255, 255));
        jPanel90.setMaximumSize(new java.awt.Dimension(200, 32767));
        jPanel90.setPreferredSize(new java.awt.Dimension(300, 250));
        jPanel90.setLayout(new javax.swing.BoxLayout(jPanel90, javax.swing.BoxLayout.LINE_AXIS));

        gLeher.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gLeher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/neck1.png"))); // NOI18N
        gLeher.setMaximumSize(new java.awt.Dimension(107, 300));
        gLeher.setMinimumSize(new java.awt.Dimension(107, 300));
        gLeher.setPreferredSize(new java.awt.Dimension(306, 300));
        jPanel90.add(gLeher);

        jPanel89.add(jPanel90);

        jPanel91.setLayout(new javax.swing.BoxLayout(jPanel91, javax.swing.BoxLayout.Y_AXIS));

        jPanel92.setBackground(new java.awt.Color(255, 255, 255));
        jPanel92.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1));
        jPanel92.setMaximumSize(new java.awt.Dimension(32767, 200));
        jPanel92.setLayout(new javax.swing.BoxLayout(jPanel92, javax.swing.BoxLayout.Y_AXIS));

        jPanel93.setBackground(new java.awt.Color(255, 255, 255));
        jPanel93.setMaximumSize(new java.awt.Dimension(32767, 50));
        jPanel93.setLayout(new javax.swing.BoxLayout(jPanel93, javax.swing.BoxLayout.LINE_AXIS));

        jLabel40.setFont(new java.awt.Font("Poppins SemiBold", 0, 30)); // NOI18N
        jLabel40.setText("LEHER");
        jPanel93.add(jLabel40);

        jPanel92.add(jPanel93);

        jPanel91.add(jPanel92);

        jPanel94.setBackground(new java.awt.Color(255, 255, 255));
        jPanel94.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Tambahan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins Thin", 0, 15)), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 20))); // NOI18N
        jPanel94.setLayout(new java.awt.CardLayout());

        clLeher1.setBackground(new java.awt.Color(255, 255, 255));
        clLeher1.setLayout(new java.awt.GridLayout(1, 0));

        addL1.setBackground(new java.awt.Color(255, 255, 255));
        addL1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        addL1.setLayout(new javax.swing.BoxLayout(addL1, javax.swing.BoxLayout.LINE_AXIS));

        jPanel49.setLayout(new javax.swing.BoxLayout(jPanel49, javax.swing.BoxLayout.LINE_AXIS));
        addL1.add(jPanel49);

        jLabel41.setBackground(new java.awt.Color(0, 0, 0));
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/neck5.png"))); // NOI18N
        addL1.add(jLabel41);

        jCheckBox7.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox7.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jCheckBox7.setSelected(true);
        jCheckBox7.setText("<html>Display Text</html>");
        jCheckBox7.setToolTipText("");
        jCheckBox7.setEnabled(false);
        addL1.add(jCheckBox7);

        clLeher1.add(addL1);

        addL2.setBackground(new java.awt.Color(255, 255, 255));
        addL2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        addL2.setLayout(new javax.swing.BoxLayout(addL2, javax.swing.BoxLayout.LINE_AXIS));

        jPanel50.setLayout(new javax.swing.BoxLayout(jPanel50, javax.swing.BoxLayout.LINE_AXIS));
        addL2.add(jPanel50);

        jLabel46.setBackground(new java.awt.Color(0, 0, 0));
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/neck6.png"))); // NOI18N
        addL2.add(jLabel46);

        jCheckBox8.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox8.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jCheckBox8.setSelected(true);
        jCheckBox8.setText("<html>Display Text</html>");
        jCheckBox8.setToolTipText("");
        jCheckBox8.setEnabled(false);
        addL2.add(jCheckBox8);

        clLeher1.add(addL2);

        jPanel94.add(clLeher1, "card2");

        clLeher2.setBackground(new java.awt.Color(255, 255, 255));
        clLeher2.setLayout(new javax.swing.BoxLayout(clLeher2, javax.swing.BoxLayout.LINE_AXIS));

        addLA8.setBackground(new java.awt.Color(255, 255, 255));
        addLA8.setBorder(javax.swing.BorderFactory.createEmptyBorder(40, 1, 1, 1));

        jLabel15.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel15.setText("Tidak terdapat data tambahan!");
        addLA8.add(jLabel15);

        clLeher2.add(addLA8);

        jPanel94.add(clLeher2, "card2");

        jPanel91.add(jPanel94);

        jPanel89.add(jPanel91);

        jPanel44.add(jPanel89);

        jPanel114.setBackground(new java.awt.Color(255, 255, 255));
        jPanel114.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10)));
        jPanel114.setMaximumSize(new java.awt.Dimension(250, 270));
        jPanel114.setMinimumSize(new java.awt.Dimension(250, 270));
        jPanel114.setPreferredSize(new java.awt.Dimension(250, 270));
        jPanel114.setLayout(new javax.swing.BoxLayout(jPanel114, javax.swing.BoxLayout.LINE_AXIS));

        jPanel115.setBackground(new java.awt.Color(255, 255, 255));
        jPanel115.setMaximumSize(new java.awt.Dimension(200, 32767));
        jPanel115.setPreferredSize(new java.awt.Dimension(300, 250));
        jPanel115.setLayout(new javax.swing.BoxLayout(jPanel115, javax.swing.BoxLayout.LINE_AXIS));

        gBadan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gBadan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/trunk1.png"))); // NOI18N
        gBadan.setMaximumSize(new java.awt.Dimension(107, 300));
        gBadan.setMinimumSize(new java.awt.Dimension(107, 300));
        gBadan.setPreferredSize(new java.awt.Dimension(306, 300));
        jPanel115.add(gBadan);

        jPanel114.add(jPanel115);

        jPanel117.setLayout(new javax.swing.BoxLayout(jPanel117, javax.swing.BoxLayout.Y_AXIS));

        jPanel118.setBackground(new java.awt.Color(255, 255, 255));
        jPanel118.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1));
        jPanel118.setMaximumSize(new java.awt.Dimension(32767, 200));
        jPanel118.setLayout(new javax.swing.BoxLayout(jPanel118, javax.swing.BoxLayout.Y_AXIS));

        jPanel119.setBackground(new java.awt.Color(255, 255, 255));
        jPanel119.setMaximumSize(new java.awt.Dimension(32767, 50));
        jPanel119.setLayout(new javax.swing.BoxLayout(jPanel119, javax.swing.BoxLayout.LINE_AXIS));

        jLabel48.setFont(new java.awt.Font("Poppins SemiBold", 0, 30)); // NOI18N
        jLabel48.setText("BADAN");
        jPanel119.add(jLabel48);

        jPanel118.add(jPanel119);

        jPanel117.add(jPanel118);

        jPanel120.setBackground(new java.awt.Color(255, 255, 255));
        jPanel120.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Tambahan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins Thin", 0, 16)), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 20))); // NOI18N
        jPanel120.setLayout(new java.awt.CardLayout());

        clB1.setBackground(new java.awt.Color(255, 255, 255));
        clB1.setLayout(new java.awt.GridLayout(1, 0));

        addB1.setBackground(new java.awt.Color(255, 255, 255));
        addB1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        addB1.setLayout(new javax.swing.BoxLayout(addB1, javax.swing.BoxLayout.LINE_AXIS));

        jPanel51.setLayout(new javax.swing.BoxLayout(jPanel51, javax.swing.BoxLayout.LINE_AXIS));
        addB1.add(jPanel51);

        jLabel49.setBackground(new java.awt.Color(0, 0, 0));
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/trunk5.png"))); // NOI18N
        addB1.add(jLabel49);

        jCheckBox10.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox10.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jCheckBox10.setSelected(true);
        jCheckBox10.setText("<html>Display Text</html>");
        jCheckBox10.setToolTipText("");
        jCheckBox10.setEnabled(false);
        addB1.add(jCheckBox10);

        clB1.add(addB1);

        addB2.setBackground(new java.awt.Color(255, 255, 255));
        addB2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        addB2.setLayout(new javax.swing.BoxLayout(addB2, javax.swing.BoxLayout.LINE_AXIS));

        jPanel124.setLayout(new javax.swing.BoxLayout(jPanel124, javax.swing.BoxLayout.LINE_AXIS));
        addB2.add(jPanel124);

        jLabel50.setBackground(new java.awt.Color(0, 0, 0));
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/trunk6.png"))); // NOI18N
        addB2.add(jLabel50);

        jCheckBox11.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox11.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jCheckBox11.setSelected(true);
        jCheckBox11.setText("<html>Display Text</html>");
        jCheckBox11.setToolTipText("");
        jCheckBox11.setEnabled(false);
        addB2.add(jCheckBox11);

        clB1.add(addB2);

        jPanel120.add(clB1, "card2");

        clB2.setBackground(new java.awt.Color(255, 255, 255));
        clB2.setLayout(new javax.swing.BoxLayout(clB2, javax.swing.BoxLayout.LINE_AXIS));

        addLA9.setBackground(new java.awt.Color(255, 255, 255));
        addLA9.setBorder(javax.swing.BorderFactory.createEmptyBorder(40, 1, 1, 1));

        jLabel18.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel18.setText("Tidak terdapat data tambahan!");
        addLA9.add(jLabel18);

        clB2.add(addLA9);

        jPanel120.add(clB2, "card2");

        jPanel117.add(jPanel120);

        jPanel114.add(jPanel117);

        jPanel44.add(jPanel114);

        jPanel125.setBackground(new java.awt.Color(255, 255, 255));
        jPanel125.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10)));
        jPanel125.setMaximumSize(new java.awt.Dimension(250, 270));
        jPanel125.setMinimumSize(new java.awt.Dimension(250, 270));
        jPanel125.setPreferredSize(new java.awt.Dimension(250, 270));
        jPanel125.setLayout(new javax.swing.BoxLayout(jPanel125, javax.swing.BoxLayout.LINE_AXIS));

        jPanel126.setBackground(new java.awt.Color(255, 255, 255));
        jPanel126.setMaximumSize(new java.awt.Dimension(200, 32767));
        jPanel126.setPreferredSize(new java.awt.Dimension(300, 250));
        jPanel126.setLayout(new javax.swing.BoxLayout(jPanel126, javax.swing.BoxLayout.LINE_AXIS));

        gKaki.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gKaki.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kanan/legs1.png"))); // NOI18N
        gKaki.setMaximumSize(new java.awt.Dimension(107, 300));
        gKaki.setMinimumSize(new java.awt.Dimension(107, 300));
        gKaki.setPreferredSize(new java.awt.Dimension(306, 300));
        jPanel126.add(gKaki);

        jPanel125.add(jPanel126);

        jPanel127.setLayout(new javax.swing.BoxLayout(jPanel127, javax.swing.BoxLayout.Y_AXIS));

        jPanel128.setBackground(new java.awt.Color(255, 255, 255));
        jPanel128.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1));
        jPanel128.setMaximumSize(new java.awt.Dimension(32767, 200));
        jPanel128.setLayout(new javax.swing.BoxLayout(jPanel128, javax.swing.BoxLayout.Y_AXIS));

        jPanel129.setBackground(new java.awt.Color(255, 255, 255));
        jPanel129.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1));
        jPanel129.setMaximumSize(new java.awt.Dimension(32767, 200));
        jPanel129.setLayout(new javax.swing.BoxLayout(jPanel129, javax.swing.BoxLayout.Y_AXIS));

        jPanel130.setBackground(new java.awt.Color(255, 255, 255));
        jPanel130.setMaximumSize(new java.awt.Dimension(32767, 50));
        jPanel130.setLayout(new javax.swing.BoxLayout(jPanel130, javax.swing.BoxLayout.LINE_AXIS));

        jLabel52.setFont(new java.awt.Font("Poppins SemiBold", 0, 30)); // NOI18N
        jLabel52.setText("POSISI KAKI");
        jPanel130.add(jLabel52);

        jPanel129.add(jPanel130);

        jPanel131.setBackground(new java.awt.Color(255, 255, 255));
        jPanel131.setMaximumSize(new java.awt.Dimension(32767, 50));
        jPanel131.setLayout(new javax.swing.BoxLayout(jPanel131, javax.swing.BoxLayout.LINE_AXIS));

        tKaki.setFont(new java.awt.Font("Poppins Light", 0, 25)); // NOI18N
        tKaki.setText("Kanan");
        jPanel131.add(tKaki);

        jPanel129.add(jPanel131);

        jPanel128.add(jPanel129);

        jPanel127.add(jPanel128);

        jPanel132.setBackground(new java.awt.Color(255, 255, 255));
        jPanel132.setLayout(new javax.swing.BoxLayout(jPanel132, javax.swing.BoxLayout.LINE_AXIS));

        jPanel133.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel133Layout = new javax.swing.GroupLayout(jPanel133);
        jPanel133.setLayout(jPanel133Layout);
        jPanel133Layout.setHorizontalGroup(
            jPanel133Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 211, Short.MAX_VALUE)
        );
        jPanel133Layout.setVerticalGroup(
            jPanel133Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 116, Short.MAX_VALUE)
        );

        jPanel132.add(jPanel133);

        jPanel127.add(jPanel132);

        jPanel125.add(jPanel127);

        jPanel44.add(jPanel125);

        jPanel134.setBackground(new java.awt.Color(255, 255, 255));
        jPanel134.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10)));
        jPanel134.setMaximumSize(new java.awt.Dimension(250, 270));
        jPanel134.setMinimumSize(new java.awt.Dimension(250, 270));
        jPanel134.setPreferredSize(new java.awt.Dimension(250, 270));
        jPanel134.setLayout(new javax.swing.BoxLayout(jPanel134, javax.swing.BoxLayout.LINE_AXIS));

        jPanel135.setBackground(new java.awt.Color(255, 255, 255));
        jPanel135.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 1, 1));
        jPanel135.setLayout(new javax.swing.BoxLayout(jPanel135, javax.swing.BoxLayout.Y_AXIS));

        jPanel136.setBackground(new java.awt.Color(255, 255, 255));
        jPanel136.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1));
        jPanel136.setMaximumSize(new java.awt.Dimension(32767, 200));
        jPanel136.setLayout(new javax.swing.BoxLayout(jPanel136, javax.swing.BoxLayout.Y_AXIS));

        jPanel137.setBackground(new java.awt.Color(255, 255, 255));
        jPanel137.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel137.setMaximumSize(new java.awt.Dimension(32767, 200));
        jPanel137.setLayout(new javax.swing.BoxLayout(jPanel137, javax.swing.BoxLayout.Y_AXIS));

        jPanel138.setBackground(new java.awt.Color(255, 255, 255));
        jPanel138.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 30));
        jPanel138.setMaximumSize(new java.awt.Dimension(32767, 50));
        jPanel138.setLayout(new javax.swing.BoxLayout(jPanel138, javax.swing.BoxLayout.LINE_AXIS));

        jLabel54.setFont(new java.awt.Font("Poppins SemiBold", 0, 30)); // NOI18N
        jLabel54.setText("OPSIONAL DATA 2");
        jPanel138.add(jLabel54);

        jPanel137.add(jPanel138);

        jPanel139.setBackground(new java.awt.Color(255, 255, 255));
        jPanel139.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 30));
        jPanel139.setMaximumSize(new java.awt.Dimension(32767, 60));
        jPanel139.setLayout(new javax.swing.BoxLayout(jPanel139, javax.swing.BoxLayout.LINE_AXIS));

        tOP2.setBackground(new java.awt.Color(255, 255, 255));
        tOP2.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        tOP2.setSelected(true);
        tOP2.setText("<html><b>Score 0</b> - Tidak ada perlawanan - Beban kurang dari 2kg</html>");
        tOP2.setEnabled(false);
        tOP2.setMaximumSize(new java.awt.Dimension(700, 31));
        tOP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tOP2ActionPerformed(evt);
            }
        });
        jPanel139.add(tOP2);

        jPanel137.add(jPanel139);

        jPanel136.add(jPanel137);

        jPanel135.add(jPanel136);

        jPanel140.setBackground(new java.awt.Color(255, 255, 255));
        jPanel140.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Tambahan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins Thin", 0, 16)), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 20))); // NOI18N
        jPanel140.setLayout(new java.awt.CardLayout());

        clOP21.setBackground(new java.awt.Color(255, 255, 255));
        clOP21.setLayout(new java.awt.GridLayout(3, 0));

        jPanel142.setBackground(new java.awt.Color(255, 255, 255));
        jPanel142.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        jPanel142.setLayout(new javax.swing.BoxLayout(jPanel142, javax.swing.BoxLayout.LINE_AXIS));

        jCheckBox13.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox13.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jCheckBox13.setSelected(true);
        jCheckBox13.setText("<html>Jika postur terutama statis (yaitu ditahan > I menit), Atau jika tindakan berulang terjadi 4x per menit</html>");
        jCheckBox13.setEnabled(false);
        jCheckBox13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox13ActionPerformed(evt);
            }
        });
        jPanel142.add(jCheckBox13);

        clOP21.add(jPanel142);

        jPanel140.add(clOP21, "card2");

        clOP22.setBackground(new java.awt.Color(255, 255, 255));
        clOP22.setLayout(new javax.swing.BoxLayout(clOP22, javax.swing.BoxLayout.LINE_AXIS));

        addLA10.setBackground(new java.awt.Color(255, 255, 255));
        addLA10.setBorder(javax.swing.BorderFactory.createEmptyBorder(40, 1, 1, 1));

        jLabel21.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel21.setText("Tidak terdapat data tambahan!");
        addLA10.add(jLabel21);

        clOP22.add(addLA10);

        jPanel140.add(clOP22, "card2");

        jPanel135.add(jPanel140);

        jPanel134.add(jPanel135);

        jPanel44.add(jPanel134);

        jPanel4.add(jPanel44);

        containerDetail.add(jPanel4);

        jScrollPane1.setViewportView(containerDetail);

        getContentPane().add(jScrollPane1);

        jMenu1.setText("File");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        print.setText("Print ");
        print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printMouseClicked(evt);
            }
        });
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        jMenu1.add(print);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void tOP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tOP1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tOP1ActionPerformed

    private void tOP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tOP2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tOP2ActionPerformed

    private void jCheckBox13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox13ActionPerformed

    private void jCheckBox14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox14ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void printMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_printMouseClicked

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
        CetakPDF(containerDetail);
    }//GEN-LAST:event_printActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailDataFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new DetailDataFrame().setVisible(true);
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addB1;
    private javax.swing.JPanel addB2;
    private javax.swing.JPanel addL1;
    private javax.swing.JPanel addL2;
    private javax.swing.JPanel addLA1;
    private javax.swing.JPanel addLA10;
    private javax.swing.JPanel addLA2;
    private javax.swing.JPanel addLA3;
    private javax.swing.JPanel addLA4;
    private javax.swing.JPanel addLA5;
    private javax.swing.JPanel addLA6;
    private javax.swing.JPanel addLA7;
    private javax.swing.JPanel addLA8;
    private javax.swing.JPanel addLA9;
    private javax.swing.JPanel clB1;
    private javax.swing.JPanel clB2;
    private javax.swing.JPanel clLA1;
    private javax.swing.JPanel clLA2;
    private javax.swing.JPanel clLB1;
    private javax.swing.JPanel clLB2;
    private javax.swing.JPanel clLeher1;
    private javax.swing.JPanel clLeher2;
    private javax.swing.JPanel clOP1;
    private javax.swing.JPanel clOP2;
    private javax.swing.JPanel clOP21;
    private javax.swing.JPanel clOP22;
    private javax.swing.JPanel clPT1;
    private javax.swing.JPanel clPT2;
    private javax.swing.JPanel containerDetail;
    private javax.swing.JLabel displayAlamat;
    private javax.swing.JLabel displayDurasiBekerja;
    private javax.swing.JLabel displayFinalScore;
    private javax.swing.JLabel displayJenisKelamin;
    private javax.swing.JLabel displayJenisKerja;
    private javax.swing.JLabel displayKeluhan;
    private javax.swing.JLabel displayKerentanan;
    private javax.swing.JLabel displayLamaBekerja;
    private javax.swing.JLabel displayNama;
    private javax.swing.JLabel displayNik;
    private javax.swing.JLabel displayNomorTelephone;
    private javax.swing.JLabel displayPekerjaan;
    private javax.swing.JLabel displayPenjelasan;
    private javax.swing.JLabel displayUmur;
    private javax.swing.JLabel gBadan;
    private javax.swing.JLabel gKaki;
    private javax.swing.JLabel gLeher;
    private javax.swing.JLabel gLenganAtas;
    private javax.swing.JLabel gLenganBawah;
    private javax.swing.JLabel gPergelanganTangan;
    private javax.swing.JLabel gPutarPergelangan;
    private javax.swing.JLabel gSisiBadan;
    private javax.swing.JLabel headerDetail;
    private javax.swing.JPanel informasiPersonal;
    private javax.swing.JPanel informasiPersonal1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel100;
    private javax.swing.JPanel jPanel101;
    private javax.swing.JPanel jPanel102;
    private javax.swing.JPanel jPanel103;
    private javax.swing.JPanel jPanel104;
    private javax.swing.JPanel jPanel105;
    private javax.swing.JPanel jPanel106;
    private javax.swing.JPanel jPanel107;
    private javax.swing.JPanel jPanel108;
    private javax.swing.JPanel jPanel109;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel110;
    private javax.swing.JPanel jPanel111;
    private javax.swing.JPanel jPanel112;
    private javax.swing.JPanel jPanel114;
    private javax.swing.JPanel jPanel115;
    private javax.swing.JPanel jPanel116;
    private javax.swing.JPanel jPanel117;
    private javax.swing.JPanel jPanel118;
    private javax.swing.JPanel jPanel119;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel120;
    private javax.swing.JPanel jPanel124;
    private javax.swing.JPanel jPanel125;
    private javax.swing.JPanel jPanel126;
    private javax.swing.JPanel jPanel127;
    private javax.swing.JPanel jPanel128;
    private javax.swing.JPanel jPanel129;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel130;
    private javax.swing.JPanel jPanel131;
    private javax.swing.JPanel jPanel132;
    private javax.swing.JPanel jPanel133;
    private javax.swing.JPanel jPanel134;
    private javax.swing.JPanel jPanel135;
    private javax.swing.JPanel jPanel136;
    private javax.swing.JPanel jPanel137;
    private javax.swing.JPanel jPanel138;
    private javax.swing.JPanel jPanel139;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel140;
    private javax.swing.JPanel jPanel142;
    private javax.swing.JPanel jPanel143;
    private javax.swing.JPanel jPanel144;
    private javax.swing.JPanel jPanel146;
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
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
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
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
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
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel jPanel82;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel85;
    private javax.swing.JPanel jPanel86;
    private javax.swing.JPanel jPanel88;
    private javax.swing.JPanel jPanel89;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel90;
    private javax.swing.JPanel jPanel91;
    private javax.swing.JPanel jPanel92;
    private javax.swing.JPanel jPanel93;
    private javax.swing.JPanel jPanel94;
    private javax.swing.JPanel jPanel98;
    private javax.swing.JPanel jPanel99;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem print;
    private javax.swing.JLabel tBadan;
    private javax.swing.JLabel tKaki;
    private javax.swing.JCheckBox tOP1;
    private javax.swing.JCheckBox tOP2;
    private javax.swing.JLabel tPutarPergelangan;
    // End of variables declaration//GEN-END:variables
}
