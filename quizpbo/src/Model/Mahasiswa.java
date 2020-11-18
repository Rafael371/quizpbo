/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author HP
 */
public class Mahasiswa {
    private String nim;
    private String nama;
    private String angkatan;
    private String kode_jurusan;

    public Mahasiswa(String nim, String nama, String angkatan, String kode_jurusan) {
        this.nim = nim;
        this.nama = nama;
        this.angkatan = angkatan;
        this.kode_jurusan = kode_jurusan;
    }
    public Mahasiswa(){
    
    }
    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(String angkatan) {
        this.angkatan = angkatan;
    }

    public String getKode_jurusan() {
        return kode_jurusan;
    }

    public void setKode_jurusan(String kode_jurusan) {
        this.kode_jurusan = kode_jurusan;
    }
}
