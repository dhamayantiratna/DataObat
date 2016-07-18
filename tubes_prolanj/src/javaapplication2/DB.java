/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EGIW
 */
public class DB {

    public Connection c = null;

    public DB() {
        try {
            this.c = DriverManager.getConnection("jdbc:sqlite:dataobat.db");
            System.out.println("Connection opened");
        } catch (SQLException ex) {
            System.out.println("Cannot connect to database...");
        }
    }

    public void initTables() {
        try {
            Statement stmt;
            Class.forName("org.sqlite.JDBC");

            if (!tableExists("master_obat")) {
                stmt = c.createStatement();
                String sql = "CREATE TABLE master_obat("
                        + "id           INT             PRIMARY KEY     NOT NULL,"
                        + "nama_obat    VARCHAR(100)                    NOT NULL,"
                        + "harga_beli   NUMERIC                         NOT NULL,"
                        + "harga_jual   NUMERIC                         NOT NULL,"
                        + "satuan       VARCHAR(15)                     NOT NULL,"
                        + "stok         INTEGER                         NOT NULL)";

                stmt.executeQuery(sql);
                stmt.close();

                System.out.println("Table master_obat created");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet getObat() throws SQLException {
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM master_obat");
        return rs;
    }

    public ResultSet getObat(int id) {
        String query = "SELECT * FROM master_obat WHERE id = ?";
        try {
            PreparedStatement psmt = c.prepareStatement(query);
            psmt.setInt(1, id);
            ResultSet result = psmt.executeQuery();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet getObat(String filter) throws SQLException {
        if (filter == null) {
            return this.getObat();
        }
        String query = "SELECT * FROM master_obat WHERE nama_obat LIKE ?";
        PreparedStatement pst = c.prepareStatement(query);
        pst.setString(1, "%" + filter + "%");

        return pst.executeQuery();
    }

    public boolean deleteObat(int[] ids) throws SQLException {

        String query = String.format("DELETE FROM master_obat WHERE id IN (%s)", String.join(",", Collections.nCopies(ids.length, "?")));
        PreparedStatement stmt = c.prepareStatement(query);
        for (int i = 0; i < ids.length; i++) {
            stmt.setInt(i + 1, ids[i]);
        }

        return stmt.execute();
    }

    public int getObatCount() throws SQLException {
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM master_obat");
        return rs.getInt(1);
    }

    public int getObatCount(String filter) throws SQLException {
        if (filter == null) {
            return this.getObatCount();
        }

        String query = "SELECT COUNT(*) FROM master_obat WHERE nama_obat LIKE ?";
        PreparedStatement pst = c.prepareStatement(query);
        pst.setString(1, "%" + filter + "%");

        return pst.executeQuery().getInt(1);
    }

    public boolean tableExists(String tblName) throws SQLException {
        String sql = "SELECT COUNT(*) FROM sqlite_master WHERE name = ? and type='table'";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setString(1, tblName);
        int result = stmt.executeQuery().getInt(1);
        stmt.close();

        return result > 0;
    }

    public int getLastId() throws SQLException {
        String sql = "SELECT MAX(id) FROM master_obat";
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    public boolean tambahObat(String nama_obat, int harga_beli, int harga_jual, String satuan, int stok) throws SQLException {
        String query = "INSERT INTO master_obat VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = c.prepareStatement(query);
        pst.setInt(1, getLastId() + 1);
        pst.setString(2, nama_obat);
        pst.setInt(3, harga_beli);
        pst.setInt(4, harga_jual);
        pst.setString(5, satuan);
        pst.setInt(6, stok);

        return pst.execute();
    }

    public boolean updateObat(int idObat, String namaObat, int hargaBeli, int hargaJual, String satuan, int stok) {
        try {
            String query = "UPDATE master_obat SET nama_obat = ?, harga_beli = ?, harga_jual = ?, satuan = ?, stok = ? WHERE id = ?";
            PreparedStatement pst = c.prepareStatement(query);
            pst.setString(1, namaObat);
            pst.setInt(2, hargaBeli);
            pst.setInt(3, hargaJual);
            pst.setString(4, satuan);
            pst.setInt(5, stok);
            pst.setInt(6, idObat);

            return pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
