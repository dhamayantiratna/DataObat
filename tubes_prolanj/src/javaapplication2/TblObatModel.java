/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author EGIW
 */
public class TblObatModel extends AbstractTableModel {

    private DB db;
    private String[] headers = {"Kode", "Nama Obat", "Harga Beli", "Harga Jual",
        "Satuan", "Stok"};
    private NumberFormat formatter = NumberFormat.getCurrencyInstance();

    private Object[][] data;

    public TblObatModel(DB db) {
        this.db = db;
        data = null;

        search("");
    }

    public void search(String query) {
        try {
            if (db.getObatCount(query) > 0) {
                ResultSet dataObat = db.getObat(query);
                ResultSetMetaData dataObatMeta = dataObat.getMetaData();
                data = new Object[db.getObatCount(query)][];
                int i = 0;
                while (dataObat.next()) {
                    data[i] = new Object[headers.length];
                    data[i][0] = dataObat.getString(1);
                    data[i][1] = dataObat.getString(2);
                    data[i][2] = this.formatter.format(dataObat.getInt(3));
                    data[i][3] = this.formatter.format(dataObat.getInt(4));
                    data[i][4] = dataObat.getString(5);
                    data[i][5] = dataObat.getInt(6);

                    i++;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TblObatModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        fireTableChanged(null);
    }

    @Override
    public int getRowCount() {
        if(this.data == null) 
            return 0;
        return this.data.length;
    }

    @Override
    public int getColumnCount() {
        return this.headers.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        return this.data[i][i1];
    }

    @Override
    public String getColumnName(int i) {
        return this.headers[i];
    }

}
