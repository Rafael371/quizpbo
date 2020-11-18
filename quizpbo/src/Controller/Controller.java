/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Jurusan;
import Model.Mahasiswa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Controller {
    static DatabaseHandler conn = new DatabaseHandler();
    public static ArrayList<Jurusan> getAllJurusan() {
        ArrayList<Jurusan> jurusan = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM jurusan ";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Jurusan jur = new Jurusan();
                jur.setKode(rs.getString("Kode"));
                jur.setNama(rs.getString("Nama"));
                jurusan.add(jur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (jurusan);
    }

    public static int cekKodeDuplikat(String kodeJur) {
        conn.connect();
        int a = 0;
        String query = "SELECT kode FROM jurusan WHERE kode = '" + kodeJur + "'";
        ArrayList<Jurusan> listJur = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Jurusan jur = new Jurusan();
                jur.setKode(rs.getString("Kode"));
                listJur.add(jur);
            }
            a = listJur.size();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public static boolean insertJurusan(String kodeJur, String namaJur) {
        conn.connect();
        String query = "INSERT INTO jurusan VALUES (?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, kodeJur);
            stmt.setString(2, namaJur);
            stmt.executeUpdate();
            return(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return(false);}

    public static ArrayList<Mahasiswa> getAllMahasiswa(String kodeJur) {
        ArrayList<Mahasiswa> mahasiswa = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM mahasiswa WHERE kode_Jurusan = '" + kodeJur + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Mahasiswa mhs = new Mahasiswa();
                mhs.setNim(rs.getString("nim"));
                mhs.setNama(rs.getString("Nama"));
                mhs.setAngkatan(rs.getString("angkatan"));
                mhs.setKode_jurusan(rs.getString("kode_jurusan"));
                mahasiswa.add(mhs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (mahasiswa);
    }

    public static int cekNIMDuplikat(String nim) {
        conn.connect();
        int a = 0;
        String query = "SELECT nim FROM mahasiswa WHERE nim = '" + nim + "'";
        ArrayList<Mahasiswa> listMa = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Mahasiswa maba = new Mahasiswa();
                maba.setNim(rs.getString("NIM"));
                listMa.add(maba);
            }
            a = listMa.size();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public static boolean insertMahasiswa(String nim, String nama, int angkatan, String jurusan) {
        conn.connect();
        String query = "INSERT INTO mahasiswa VALUES (?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, nim);
            stmt.setString(2, nama);
            stmt.setInt(3, angkatan);
            stmt.setString(4, jurusan);
            stmt.executeUpdate();
            return(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return(false);
    }
    
    
}
