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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.WindowConstants;

/**
 *
 * @author HP
 */
public class SelectJurusan extends JFrame implements ActionListener{
    JFrame Jurusan;
    String[][] data;
    String[] kolom = {"Kode","Nama"};
    JTable tabelJurusan;
    public SelectJurusan(){
        Jurusan = new JFrame("Jurusan");
        Jurusan.setSize(300, 300);
        Jurusan.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Jurusan.setLocationRelativeTo(null);
        
        ArrayList<Jurusan> listJur = Controller.getAllJurusan();
        int size = listJur.size();
        data = new String[size][2];
        
        for(int i = 0; i < listJur.size(); i++){
            data[i][0] = listJur.get(i).getKode();
            data[i][1] = listJur.get(i).getNama();
        }
        tabelJurusan=new JTable(data,kolom);
        tabelJurusan.setBounds(20,20,200,100);
        Jurusan.add(tabelJurusan);
        Jurusan.setLayout(null);
        Jurusan.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
