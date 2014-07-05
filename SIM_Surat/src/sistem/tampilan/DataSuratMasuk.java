/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TambahSuratKeluar.java
 *
 * Created on Feb 27, 2013, 8:22:36 PM
 */
package sistem.tampilan;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author compaq
 */
public class DataSuratMasuk extends javax.swing.JFrame {

    Connection cn = null;
    ResultSet rssumas = null;
    DefaultTableModel tabModel;

    public DataSuratMasuk() {
        initComponents();
        konek();
        tampilData();

    }

    void konek() {
        try {
            //aktif driver
            Class.forName("com.mysql.jdbc.Driver");
            //konek database
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/surat", "root", "");
            Object[] judul_kolom = {"Id Surat", "Nomor Surat", "Tanggal Surat", "Tanggal Terima", "Pengirim Surat", "Perihal Surat", "Disposisi", "Tahun", " File Surat"};
            tabModel = new DefaultTableModel(null, judul_kolom);
            tab_sumas.setModel(tabModel);
            //       tampilData();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void tampilData() {
        try {
            Statement stm; //buat stm
            stm = cn.createStatement();
            tabModel.getDataVector().removeAllElements();
            rssumas = stm.executeQuery("select * from surat_masuk");
            while (rssumas.next()) {
                Object[] data = {rssumas.getString("id_surat"),
                    rssumas.getString("no_surat"),
                    rssumas.getString("tgl_surat"),
                    rssumas.getString("tgl_surat_diterima"),
                    rssumas.getString("pengirim"),
                    rssumas.getString("prihal_surat"),
                    rssumas.getString("disposisi"),
                    rssumas.getString("tahun"),
                    rssumas.getString("file_surat")
                };
                tabModel.addRow(data);
            }

        } catch (Exception e) {
            e.printStackTrace();

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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        cari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_sumas = new javax.swing.JTable();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        crpengirim = new javax.swing.JTextField();
        crprihal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Pemberkasan Surat Kementerian Agama Purwokerto");

        jPanel1.setBackground(new java.awt.Color(51, 153, 0));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setText("SISTEM PEMBERKASAN SURAT MASUK DAN SURAT KELUAR");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("KEMENTERIAN AGAMA KABUPATEN BANYUMAS PURWOKERTO");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel3.setText("Data - Data Surat Masuk");

        jButton5.setText("Kembali");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cariKeyPressed(evt);
            }
        });

        tab_sumas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Surat", "Nomor Surat", "Tanggal Surat", "Tanggal Terima", "Pengirim ", "Perihal Surat", "Disposisi", "Tahun", "File Surat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tab_sumas);

        jRadioButton1.setText("Cari Berdasarkan Nomor");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseEntered(evt);
            }
        });

        jRadioButton2.setText("Cari Berdasarkan Pengirim");
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });

        jRadioButton3.setText("Cari Berdasarkan Perihal");
        jRadioButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton3MouseClicked(evt);
            }
        });

        crpengirim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                crpengirimKeyPressed(evt);
            }
        });

        crprihal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                crprihalKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 210, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(316, 316, 316))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addGap(30, 30, 30))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jRadioButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cari, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                                    .addComponent(crpengirim)
                                    .addComponent(crprihal))
                                .addGap(355, 355, 355)))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(371, 371, 371)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(21, 21, 21)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton2)
                    .addComponent(crpengirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton3)
                    .addComponent(crprihal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(jButton5)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new MenuUser().show();
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void cariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyPressed
        Object[] Baris = {"Id Surat", "Nomor Surat", "Tanggal Surat", "Tanggal Terima", "Pengirim Surat", "Perihal Surat", "Disposisi", "Tahun", " File Surat"};
        tabModel = new DefaultTableModel(null, Baris);
        tab_sumas.setModel(tabModel);

        try {
            String sql = "select * from surat_masuk where no_surat like '%" + cari.getText() + "%'";
            java.sql.Statement stmt = cn.createStatement();
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()) {
                String id = rslt.getString("id_surat");
                String no = rslt.getString("no_surat");
                String tgl_surat = rslt.getString("tgl_surat");
                String tgl_surat_terima = rslt.getString("tgl_surat_diterima");
                String pengirim = rslt.getString("pengirim");
                String prihal = rslt.getString("prihal_surat");
                String dis = rslt.getString("disposisi");
                String thn = rslt.getString("tahun");
                String file = rslt.getString("file_surat");

                String[] dataField = {id, no, tgl_surat, tgl_surat_terima, pengirim, prihal, dis, thn, file};
                tabModel.addRow(dataField);
            }
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_cariKeyPressed

    private void crpengirimKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_crpengirimKeyPressed
        Object[] Baris = {"Id Surat", "Nomor Surat", "Tanggal Surat", "Tanggal Terima", "Pengirim Surat", "Perihal Surat", "Disposisi", "Tahun", " File Surat"};
        tabModel = new DefaultTableModel(null, Baris);
        tab_sumas.setModel(tabModel);

        try {
            String sql = "select * from surat_masuk where pengirim like '%" + crpengirim.getText() + "%'";
            java.sql.Statement stmt = cn.createStatement();
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()) {
                String id = rslt.getString("id_surat");
                String no = rslt.getString("no_surat");
                String tgl_surat = rslt.getString("tgl_surat");
                String tgl_surat_terima = rslt.getString("tgl_surat_diterima");
                String pengirim = rslt.getString("pengirim");
                String prihal = rslt.getString("prihal_surat");
                String dis = rslt.getString("disposisi");
                String thn = rslt.getString("tahun");
                String file = rslt.getString("file_surat");

                String[] dataField = {id, no, tgl_surat, tgl_surat_terima, pengirim, prihal, dis, thn, file};
                tabModel.addRow(dataField);
            }
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_crpengirimKeyPressed

    private void crprihalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_crprihalKeyPressed
        Object[] Baris = {"Id Surat", "Nomor Surat", "Tanggal Surat", "Tanggal Terima", "Pengirim Surat", "Perihal Surat", "Disposisi", "Tahun", " File Surat"};
        tabModel = new DefaultTableModel(null, Baris);
        tab_sumas.setModel(tabModel);

        try {
            String sql = "select * from surat_masuk where prihal_surat like '%" + crprihal.getText() + "%'";
            java.sql.Statement stmt = cn.createStatement();
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()) {
                String id = rslt.getString("id_surat");
                String no = rslt.getString("no_surat");
                String tgl_surat = rslt.getString("tgl_surat");
                String tgl_surat_terima = rslt.getString("tgl_surat_diterima");
                String pengirim = rslt.getString("pengirim");
                String prihal = rslt.getString("prihal_surat");
                String dis = rslt.getString("disposisi");
                String thn = rslt.getString("tahun");
                String file = rslt.getString("file_surat");

                String[] dataField = {id, no, tgl_surat, tgl_surat_terima, pengirim, prihal, dis, thn, file};
                tabModel.addRow(dataField);
            }
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_crprihalKeyPressed

    private void jRadioButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseEntered
        cari.getKeyListeners();
        cari.setVisible(true);
        crpengirim.setVisible(false);
        crprihal.setVisible(false);
    }//GEN-LAST:event_jRadioButton1MouseEntered

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked
        crpengirim.getKeyListeners();
        cari.setVisible(false);
        crpengirim.setVisible(true);
        crprihal.setVisible(false);
    }//GEN-LAST:event_jRadioButton2MouseClicked

    private void jRadioButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton3MouseClicked
        crprihal.getKeyListeners();
        cari.setVisible(false);
        crpengirim.setVisible(false);
        crprihal.setVisible(true);
    }//GEN-LAST:event_jRadioButton3MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataSuratMasuk().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JTextField crpengirim;
    private javax.swing.JTextField crprihal;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tab_sumas;
    // End of variables declaration//GEN-END:variables
}