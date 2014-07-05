package sistem.tampilan;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


/**
 *
 * @author compaq
 */
public class SuratKeluar extends javax.swing.JFrame {

    Connection cn = null;
    ResultSet rssukel = null;
    DefaultTableModel tabModel;
    int a = 0;
    private JFileChooser fileChooser;
	private String filePath = null;
	private File file;
	private POIFSFileSystem fs = null;
	private FileInputStream fis;
	private HWPFDocument doc;
	private WordExtractor we;
	String[] paragraphs;

    public SuratKeluar() {
        initComponents();
        konek();
        tampilData();
        initAbstract();

    }
    
	
	private void initAbstract(){
		setLocationRelativeTo(null);
		txtHasil.setLineWrap(true);
		txtHasil.setWrapStyleWord(true);
		fileChooser = new JFileChooser();
		
        }

    void konek() {
        try {
            //aktif driver
            Class.forName("com.mysql.jdbc.Driver");
            //konek database
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/surat", "root", "");
            Object[] judul_kolom = {"Id Surat", "Nomor Surat", "Tanggal Surat", "Tujuan Surat", "Pengirim Surat", "Perihal Surat", "Tahun", "File Surat"};
            tabModel = new DefaultTableModel(null, judul_kolom);
            tab_sukel.setModel(tabModel);
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
            rssukel = stm.executeQuery("select * from surat_keluar");
            while (rssukel.next()) {
                Object[] data = {rssukel.getString("id_surat"),
                    rssukel.getString("no_surat"),
                    rssukel.getDate("tgl_surat"),
                    rssukel.getString("tujuan_surat"),
                    rssukel.getString("pengirim_surat"),
                    rssukel.getString("prihal_surat"),
                    rssukel.getString("tahun"),
                    rssukel.getString("file_surat")
                };
                tabModel.addRow(data);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    void kosongkanform() {
        id_surat.setText("");
        no_surat.setText("");
        tgl_surat.setText("");
        tjuan_surat.setText("");
        pengirim_surat.setText("");
        prihal_surat.setText("");
        thn.setText("");
        txtDir.setText("");
        txtHasil.setText("");
        tgl_surat1.setDate(null);
       

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_sukel = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        id_surat = new javax.swing.JTextField();
        no_surat = new javax.swing.JTextField();
        tgl_surat = new javax.swing.JTextField();
        tjuan_surat = new javax.swing.JTextField();
        pengirim_surat = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        prihal_surat = new javax.swing.JTextArea();
        txtDir = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cari = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        thn = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtHasil = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        tgl_surat1 = new com.toedter.calendar.JDateChooser();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        carno = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Pemberkasan Surat Kementerian Agama Purwokerto ");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 102, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("SISTEM PEMBERKASAN SURAT MASUK DAN SURAT KELUAR");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("KEMENTERIAN AGAMA KABUPATEN BANYUMAS PURWOKERTO");

        jLabel3.setText("Data - Data Surat Keluar");

        tab_sukel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Surat", "Nomor Surat", "Tanggal Surat", "Tujuan Surat", "Pengirim Surat", "Perihal Surat", "Tahun", "File Surat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tab_sukel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_sukelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tab_sukel);

        jLabel4.setText("Id Surat");

        jLabel5.setText("Nomor Surat");

        jLabel6.setText("Tanggal Surat");

        jLabel7.setText("Tujuan Surat");

        jLabel8.setText("Pengirim Surat");

        jLabel9.setText("Perihal Surat");

        jLabel10.setText("File Surat");

        prihal_surat.setColumns(20);
        prihal_surat.setRows(5);
        jScrollPane2.setViewportView(prihal_surat);

        jButton1.setText("Cari File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Kembali");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cariKeyPressed(evt);
            }
        });

        jLabel11.setText("Tahun");

        txtHasil.setColumns(20);
        txtHasil.setRows(5);
        jScrollPane3.setViewportView(txtHasil);

        jButton5.setText("Baca File Surat");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        tgl_surat1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tgl_surat1PropertyChange(evt);
            }
        });

        jRadioButton1.setText("Cari Berdasarkan Perihal");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });

        jRadioButton2.setText("Cari Berdasarkan Nomor");
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });

        carno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                carnoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(473, 473, 473))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(394, 394, 394)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(90, 90, 90)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2)
                                    .addComponent(pengirim_surat, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tjuan_surat)
                                    .addComponent(no_surat)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tgl_surat1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tgl_surat))
                                    .addComponent(id_surat, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(thn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(79, 79, 79)
                                        .addComponent(simpan)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(hapus)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButton5)
                                                .addGap(0, 0, Short.MAX_VALUE))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(84, 84, 84)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cari, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                                    .addComponent(carno))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3))
                            .addComponent(jScrollPane1))
                        .addGap(34, 34, 34))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(id_surat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(5, 5, 5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(no_surat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tgl_surat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addComponent(tgl_surat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tjuan_surat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(pengirim_surat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(thn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)))
                    .addComponent(jScrollPane3))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(simpan)
                            .addComponent(hapus)
                            .addComponent(jButton2))
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jRadioButton1))
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(carno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        try {

            Statement stm = cn.createStatement();
            a = stm.executeUpdate("insert into surat_keluar set id_surat='" + id_surat.getText() + "',"
                    + "no_surat='" + no_surat.getText() + "',"
                    + "tgl_surat='" + tgl_surat.getText() + "',"
                    + "tujuan_surat='" + tjuan_surat.getText() + "',"
                    + "pengirim_surat='" + pengirim_surat.getText() + "',"
                    + "prihal_surat='" + prihal_surat.getText() + "',"
                    + "tahun='" + thn.getText() + "',"
                    + "file_surat='" + txtDir.getText() + "'");
            tampilData();
            kosongkanform();
           

        } catch (Exception e) {
            e.printStackTrace();
        }
         if (a != 0) {
            JOptionPane.showMessageDialog(null, "DATA TERSIMPAN");
        } else {
            JOptionPane.showMessageDialog(null, "DATA GAGAL DISIMPAN \n Cek Id Jangan Sampai Terjadi Duplikat Id \n Silahkan Coba Lagi");
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
    
             try {
            
            Statement stm = cn.createStatement();
            a = stm.executeUpdate("delete from surat_keluar where id_surat='"
                    + tabModel.getValueAt(tab_sukel.getSelectedRow(), 0) + "'");
            tampilData();
            kosongkanform();
        } catch (Exception e) {
            e.printStackTrace();
        }
            JOptionPane.showMessageDialog(null, "DATA TERHAPUS");
       
    }//GEN-LAST:event_hapusActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            Statement stm = cn.createStatement();
            a = stm.executeUpdate("update surat_keluar set id_surat='" + id_surat.getText() + "',"
                    + "no_surat='" + no_surat.getText() + "',"
                    + "tgl_surat='" + tgl_surat.getText() + "',"
                    + "tujuan_surat='" + tjuan_surat.getText() + "',"
                    + "pengirim_surat='" + pengirim_surat.getText() + "',"
                    + "prihal_surat='" + prihal_surat.getText() + "',"
                    + "tahun='" + thn.getText() + "',"
                    + "file_surat='" + txtDir.getText() + "'where id_surat='"
                    + tabModel.getValueAt(tab_sukel.getSelectedRow(), 0) + "'");
            tampilData();
            
            kosongkanform();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (a == 0) {
            JOptionPane.showMessageDialog(null, "DATA GAGAL DIUPDATE \n Silahkan Coba Lagi");
        } else {
            JOptionPane.showMessageDialog(null, "DATA TER-UPDATE");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(this)){
			filePath = fileChooser.getSelectedFile().getAbsolutePath();
			file = new File(filePath);
			txtDir.setText(filePath);
			txtHasil.setText("");
		}
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tab_sukelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_sukelMouseClicked
        id_surat.setText(tabModel.getValueAt(tab_sukel.getSelectedRow(), 0) + "");
        no_surat.setText(tabModel.getValueAt(tab_sukel.getSelectedRow(), 1) + "");
        tgl_surat.setText(tabModel.getValueAt(tab_sukel.getSelectedRow(), 2) + "");
        tjuan_surat.setText(tabModel.getValueAt(tab_sukel.getSelectedRow(), 3) + "");
        pengirim_surat.setText(tabModel.getValueAt(tab_sukel.getSelectedRow(), 4) + "");
        prihal_surat.setText(tabModel.getValueAt(tab_sukel.getSelectedRow(), 5) + "");
        thn.setText(tabModel.getValueAt(tab_sukel.getSelectedRow(), 6) + "");
        txtDir.setText(tabModel.getValueAt(tab_sukel.getSelectedRow(), 7) + "");
    }//GEN-LAST:event_tab_sukelMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new MenuUtama().show();
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        JFrame form = new JFrame();
        form.setSize(500, 500);
        new tengah(this);
    }//GEN-LAST:event_formWindowActivated

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(filePath != null){
			
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					try{			
						fis = new FileInputStream(file);
						doc = new HWPFDocument(fis);
						we = new WordExtractor(doc);
						//get Paragraph text  as array
						paragraphs = we.getParagraphText();

						for(int i = 0; i < paragraphs.length; i++){
							//paragraphs[i] = paragraphs[i].replaceAll("\\cM?\r?\n","");
							txtHasil.append(paragraphs[i]);				
						}						
					}catch(Exception exc){
						System.out.println(exc.getMessage());
					}finally{
						
					}
				}
			});
			t.start();
		}
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tgl_surat1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tgl_surat1PropertyChange
        // TODO add your handling code here:
        if (tgl_surat1.getDate() != null) {
            SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
            String tanggalSurat = Format.format(tgl_surat1.getDate());
            tgl_surat.setText(tanggalSurat);

        }
    }//GEN-LAST:event_tgl_surat1PropertyChange

    private void cariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyPressed
        Object[] Baris = {"Id Surat", "Nomor Surat", "Tanggal Surat", "Tujuan", "Pengirim Surat", "Perihal Surat", "Tahun", " File Surat"};
        tabModel = new DefaultTableModel(null, Baris);
        tab_sukel.setModel(tabModel);

        try {
            String sql = "select * from surat_keluar where prihal_surat like '%" + cari.getText() + "%'";
            java.sql.Statement stmt = cn.createStatement();
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()) {
                String id = rslt.getString("id_surat");
                String no = rslt.getString("no_surat");
                String tgl_surat = rslt.getString("tgl_surat");
                String tgl_surat_terima = rslt.getString("tujuan_surat");
                String pengirim = rslt.getString("pengirim_surat");
                String prihal = rslt.getString("prihal_surat");
                String thn = rslt.getString("tahun");
                String file = rslt.getString("file_surat");

                String[] dataField = {id, no, tgl_surat, tgl_surat_terima, pengirim, prihal,  thn, file};
                tabModel.addRow(dataField);
            }
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_cariKeyPressed

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        cari.getKeyListeners();
        cari.setVisible(true);
        carno.setVisible(false);
    }//GEN-LAST:event_jRadioButton1MouseClicked

    private void carnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_carnoKeyPressed
        Object[] Baris = {"Id Surat", "Nomor Surat", "Tanggal Surat", "Tujuan", "Pengirim Surat", "Perihal Surat", "Tahun", " File Surat"};
        tabModel = new DefaultTableModel(null, Baris);
        tab_sukel.setModel(tabModel);

        try {
            String sql = "select * from surat_keluar where no_surat like '%" + carno.getText() + "%'";
            java.sql.Statement stmt = cn.createStatement();
            java.sql.ResultSet rslt = stmt.executeQuery(sql);
            while (rslt.next()) {
                String id = rslt.getString("id_surat");
                String no = rslt.getString("no_surat");
                String tgl_surat = rslt.getString("tgl_surat");
                String tgl_surat_terima = rslt.getString("tujuan_surat");
                String pengirim = rslt.getString("pengirim_surat");
                String prihal = rslt.getString("prihal_surat");
                String thn = rslt.getString("tahun");
                String file = rslt.getString("file_surat");

                String[] dataField = {id, no, tgl_surat, tgl_surat_terima, pengirim, prihal,  thn, file};
                tabModel.addRow(dataField);
            }
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_carnoKeyPressed

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked
        carno.getKeyListeners();
        cari.setVisible(false);
        carno.setVisible(true);
    }//GEN-LAST:event_jRadioButton2MouseClicked

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
            java.util.logging.Logger.getLogger(SuratKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuratKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuratKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuratKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SuratKeluar().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JTextField carno;
    private javax.swing.JButton hapus;
    private javax.swing.JTextField id_surat;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField no_surat;
    private javax.swing.JTextField pengirim_surat;
    private javax.swing.JTextArea prihal_surat;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tab_sukel;
    private javax.swing.JTextField tgl_surat;
    private com.toedter.calendar.JDateChooser tgl_surat1;
    private javax.swing.JTextField thn;
    private javax.swing.JTextField tjuan_surat;
    private javax.swing.JTextField txtDir;
    private javax.swing.JTextArea txtHasil;
    // End of variables declaration//GEN-END:variables
}
