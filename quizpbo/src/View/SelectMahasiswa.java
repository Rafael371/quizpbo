/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Model.Mahasiswa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.WindowConstants;

/**
 *
 * @author HP
 */
public class SelectMahasiswa extends JFrame implements ActionListener{
    JFrame mahasiswa;
    String[][] data;
    String[] kolom = {"NIM","Nama","Angkatan", "Kode"};
    JTable tabelMahasiswa;
    public SelectMahasiswa(String kodeJurusan){
        mahasiswa = new JFrame("Mahasiswa");
        mahasiswa.setSize(300, 300);
        mahasiswa.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mahasiswa.setLocationRelativeTo(null);
        
        ArrayList<Mahasiswa> listJur = Controller.getAllMahasiswa(kodeJurusan);
        int size = listJur.size();
        data = new String[size][2];
        
        for(int i = 0; i < listJur.size(); i++){
            data[i][0] = listJur.get(i).getNim();
            data[i][1] = listJur.get(i).getNama();
            data[i][1] = listJur.get(i).getAngkatan();
            data[i][1] = listJur.get(i).getKode_jurusan();
        }
        tabelMahasiswa=new JTable(data,kolom);
        tabelMahasiswa.setBounds(20,20,200,100);
        mahasiswa.add(tabelMahasiswa);
        mahasiswa.setLayout(null);
        mahasiswa.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
