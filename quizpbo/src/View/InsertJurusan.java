/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Model.Jurusan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
/**
 *
 * @author HP
 */
public class InsertJurusan extends JFrame implements ActionListener{
    JFrame frameInsertJurusan;
    JLabel lKode,lNama,lAtas;
    JTextField TFKode,TFNama;
    JButton buttonSubmit,buttonBack,buttonReset;
    public InsertJurusan(){
        frameInsertJurusan = new JFrame("Insert Jurusan");
        frameInsertJurusan.setSize(300, 300);
        frameInsertJurusan.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameInsertJurusan.setLocationRelativeTo(null);
        
        lAtas = new JLabel("Silahkan Insert Data Dibawah ");
        lAtas.setBounds(100, 10, 200, 30);
        
        lKode = new JLabel("Kode: ");
        lKode.setBounds(45, 50, 100, 30);
        
        TFKode = new JTextField();
        TFKode.setBounds(150, 50, 200, 30);
        
        lNama = new JLabel("Nama ");
        lNama.setBounds(45, 100, 100, 30);
        
        TFNama = new JTextField();
        TFNama.setBounds(150, 100, 200, 30);
        
        buttonSubmit = new JButton("Submit");
        buttonSubmit.setBounds(45,150,300,30);
        buttonSubmit.addActionListener(this);
        
        buttonBack = new JButton("Back");
        buttonBack.setBounds(50,200,100,30);
        buttonBack.addActionListener(this);
        
        buttonReset = new JButton("Reset");
        buttonReset.setBounds(250,200,100,30);
        buttonReset.addActionListener(this);
           
        frameInsertJurusan.add(lAtas);
        frameInsertJurusan.add(buttonReset);
        frameInsertJurusan.add(buttonBack);
        frameInsertJurusan.add(buttonSubmit);
        frameInsertJurusan.add(TFKode);
        frameInsertJurusan.add(lNama);
        frameInsertJurusan.add(lKode);
        frameInsertJurusan.add(TFNama);
        frameInsertJurusan.setLayout(null);
        frameInsertJurusan.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command){
            case"Submit":
                String kodeJur = TFKode.getText();
                String namaJur = TFNama.getText();
                ArrayList<Jurusan> listJur = Controller.getAllJurusan();
                int cek_kode = Controller.cekKodeDuplikat(kodeJur);
                if(kodeJur.equals("") && namaJur.equals("")){
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                } else if(cek_kode > 0){
                    JOptionPane.showMessageDialog(null, "Kode Sudah Terpakai!!", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                } else {
                    if(Controller.insertJurusan(kodeJur, namaJur)){
                        JOptionPane.showMessageDialog(null, "Insert Berhasil!!");
                        frameInsertJurusan.setVisible(false);
                        new MainMenu();
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Insert gagal!!");
                        break;
                    }
                }
            case"Back":
                frameInsertJurusan.setVisible(false);
                new MainMenu();
                break;
            case"Reset":
                frameInsertJurusan.setVisible(false);
                new InsertJurusan();
                break;
            default:
                break;
        }
    }
}
