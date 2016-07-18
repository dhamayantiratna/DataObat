/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.awt.Frame;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author EGIW
 */
public class JDialogEditObat extends javax.swing.JDialog {

    private DB db;
    private TampilData parent;

    /**
     * Creates new form JDialogTambahObat
     */
    public JDialogEditObat(DB db, TampilData parent, boolean modal) {
        super(parent, modal);
        this.db = db;
        this.parent = parent;
        initComponents();
    }

    public void clearForm() {
        jTfKode.setText(null);
        jTfNamaObat.setText(null);
        jTfHargaBeli.setText(null);
        jTfHargaJual.setText(null);
        jCBoxSatuan.setSelectedIndex(0);
        jSpinStok.setValue(0);
        jTfNamaObat.requestFocus();
    }

    public JComboBox<String> getjCBoxSatuan() {
        return jCBoxSatuan;
    }

    public JSpinner getjSpinStok() {
        return jSpinStok;
    }

    public JTextField getjTfHargaBeli() {
        return jTfHargaBeli;
    }

    public JTextField getjTfHargaJual() {
        return jTfHargaJual;
    }

    public JTextField getjTfKode() {
        return jTfKode;
    }

    public JTextField getjTfNamaObat() {
        return jTfNamaObat;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jBtnSimpan = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jBtnBatal = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTfKode = new javax.swing.JTextField();
        jTfNamaObat = new javax.swing.JTextField();
        jTfHargaBeli = new javax.swing.JTextField();
        jTfHargaJual = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jCBoxSatuan = new javax.swing.JComboBox<String>();
        jLabel2 = new javax.swing.JLabel();
        jSpinStok = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setText("Nama Obat");

        jBtnSimpan.setText("Simpan");
        jBtnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSimpanClickSimpan(evt);
            }
        });

        jLabel4.setText("Harga Beli");

        jBtnBatal.setActionCommand("Keluar");
        jBtnBatal.setLabel("Keluar");
        jBtnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBatalClickBatal(evt);
            }
        });

        jLabel5.setText("Harga Jual");

        jLabel6.setText("Satuan");

        jLabel7.setText("Stok");

        jTfKode.setEditable(false);
        jTfKode.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Ubah Data Obat");

        jCBoxSatuan.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"pcs", "plex"}));

        jLabel2.setText("Kode");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(41, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jBtnSimpan)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jBtnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jSpinStok, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel6))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTfNamaObat)
                                                        .addComponent(jTfHargaBeli)
                                                        .addComponent(jTfHargaJual)
                                                        .addComponent(jCBoxSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTfKode, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel2)
                                                .addComponent(jTfKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3))
                                .addComponent(jTfNamaObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jTfHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jTfHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCBoxSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(jSpinStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jBtnSimpan)
                                .addComponent(jBtnBatal))
                        .addContainerGap(25, Short.MAX_VALUE))
        );

        jBtnBatal.getAccessibleContext().setAccessibleName("Keluar");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSimpanClickSimpan(java.awt.event.ActionEvent evt) {
        int idObat = Integer.parseInt(jTfKode.getText());
        String namaObat = jTfNamaObat.getText();
        int hargaBeli = Integer.parseInt(jTfHargaBeli.getText());
        int hargaJual = Integer.parseInt(jTfHargaJual.getText());
        String satuan = jCBoxSatuan.getSelectedItem().toString();
        int stok = (int) jSpinStok.getValue();

        db.updateObat(idObat, namaObat, hargaBeli, hargaJual, satuan, stok);
        String dialogsave = "Data berhasil disimpan.";
        JOptionPane.showMessageDialog(null, dialogsave, "Message", JOptionPane.INFORMATION_MESSAGE);
        parent.getTblObatModel().search("");

        clearForm();
        this.setVisible(false);
    }

    private void jBtnBatalClickBatal(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBatalClickBatal
        clearForm();
        this.setVisible(false);
    }//GEN-LAST:event_jBtnBatalClickBatal

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBatal;
    private javax.swing.JButton jBtnSimpan;
    private javax.swing.JComboBox<String> jCBoxSatuan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSpinner jSpinStok;
    private javax.swing.JTextField jTfHargaBeli;
    private javax.swing.JTextField jTfHargaJual;
    private javax.swing.JTextField jTfKode;
    private javax.swing.JTextField jTfNamaObat;
    // End of variables declaration//GEN-END:variables
}
