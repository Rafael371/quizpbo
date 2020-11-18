/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import Controller.Controller;
import Model.Jurusan;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author HP
 */
public class InsertMhs extends JFrame implements ActionListener{
    JFrame mahasiswa;
    JLabel lNim,lNama,lAngkatan, lJurusan,label;
    JTextField TFNim,TFNama,TFAngkatan;
    JButton buttonSubmit,buttonBack,buttonReset;
    JComboBox CBJurusan;
    String[] jurusan;
    public InsertMhs() {
        mahasiswa = new JFrame("Insert Maba");
        mahasiswa.setSize(600, 600);
        mahasiswa.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mahasiswa.setLocationRelativeTo(null);
        
        label = new JLabel("Silahkan Insert Data Dibawah ");
        label.setBounds(100, 10, 200, 30);
        
        lNim = new JLabel("NIM ");
        lNim.setBounds(45, 50, 100, 30);
        
        TFNim = new JTextField();
        TFNim.setBounds(150, 50, 200, 30);
        
        lNama = new JLabel("Nama ");
        lNama.setBounds(45, 100, 100, 30);
        
        TFNama = new JTextField();
        TFNama.setBounds(150, 100, 200, 30);
        
        lAngkatan = new JLabel("Angkatan ");
        lAngkatan.setBounds(45, 150, 100, 30);
        
        TFAngkatan = new JTextField();
        TFAngkatan.setBounds(150, 150, 200, 30);
        
        ArrayList<Jurusan> listJur = Controller.getAllJurusan();
        int panjang = listJur.size();
        jurusan = new String[panjang];
        for(int i = 0; i < listJur.size() ; i++){
            jurusan[i] = listJur.get(i).getKode();
        }
        
        lJurusan = new JLabel("Jurusan ");
        lJurusan.setBounds(45, 200, 100, 30);
        
        CBJurusan = new JComboBox(jurusan);
        CBJurusan.setBounds(150, 200, 200, 30);
        
        buttonSubmit = new JButton("Submit");
        buttonSubmit.setBounds(45,250,300,30);
        buttonSubmit.addActionListener(this);
        
        buttonBack = new JButton("Back");
        buttonBack.setBounds(50,300,100,30);
        buttonBack.addActionListener(this);
        
        buttonReset = new JButton("Reset");
        buttonReset.setBounds(250,300,100,30);
        buttonReset.addActionListener(this);
          
        mahasiswa.add(CBJurusan);
        mahasiswa.add(label);
        mahasiswa.add(buttonReset);
        mahasiswa.add(buttonBack);
        mahasiswa.add(buttonSubmit);
        mahasiswa.add(TFNim);
        mahasiswa.add(lNama);
        mahasiswa.add(lNim);
        mahasiswa.add(TFNama);
        mahasiswa.add(lAngkatan);
        mahasiswa.add(TFAngkatan);
        mahasiswa.add(lJurusan);
        mahasiswa.setLayout(null);
        mahasiswa.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command){
            case"Submit":
                String nama = TFNama.getText();
                String nim = TFNim.getText();
                int angkatan = Integer.parseInt(TFAngkatan.getText());
                int cek_nim = Controller.cekNIMDuplikat(nim);
                if(nama.equals("") && nim.equals("")){
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                } else if(cek_nim > 0){
                    JOptionPane.showMessageDialog(null, "NIM sudah terdaftar!", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                } else {
                    String jurusan = CBJurusan.getItemAt(CBJurusan.getSelectedIndex()).toString();
                    if(Controller.insertMahasiswa(nim, nama, angkatan, jurusan)){
                        JOptionPane.showMessageDialog(null, "Insert Berhasil!!");
                        mahasiswa.setVisible(false);
                        new MainMenu();
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Insert gagal!!");
                        break;
                    }
                }
            case"Back":
                mahasiswa.setVisible(false);
                new MainMenu();
                break;
            case"Reset":
                mahasiswa.setVisible(false);
                new InsertMhs();
                break;
            default:
                break;
        }
    }
    
}
