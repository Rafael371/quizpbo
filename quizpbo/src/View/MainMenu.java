/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
/**
 *
 * @author HP
 */
public class MainMenu extends JFrame implements ActionListener {
    JFrame mainFrame;
    JButton buttonInsertJurusan,buttonLihatSemuaJurusan,buttonInsertMhs,buttonLihatDataMhsPerJurusan;
    JLabel label;
    public MainMenu(){
        mainFrame = new JFrame();
        mainFrame.setSize(500, 500);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        
        label = new JLabel("MyITHB");
        label.setBounds(170, 20, 100, 30);
        
        buttonInsertJurusan = new JButton("Insert Jurusan Baru");
        buttonInsertJurusan.setBounds(45, 60, 300, 30);
        buttonInsertJurusan.addActionListener(this);
        buttonLihatSemuaJurusan = new JButton("Lihat Semua Jurusan");
        buttonLihatSemuaJurusan.setBounds(45, 100, 300, 30);
        buttonLihatSemuaJurusan.addActionListener(this);
        buttonInsertMhs = new JButton("Insert Mahasiswa Baru");
        buttonInsertMhs.setBounds(45, 140, 300, 30);
        buttonInsertMhs.addActionListener(this);
        buttonLihatDataMhsPerJurusan = new JButton("Lihat Data Per Jurusan");
        buttonLihatDataMhsPerJurusan.setBounds(45, 180, 300, 30);
        buttonLihatDataMhsPerJurusan.addActionListener(this);
        
        mainFrame.add(label);
        mainFrame.add(buttonLihatSemuaJurusan);
        mainFrame.add(buttonInsertMhs);
        mainFrame.add(buttonLihatDataMhsPerJurusan);
        mainFrame.add(buttonInsertJurusan);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command){
            case "Insert Jurusan Baru":
                mainFrame.setVisible(false);
                new InsertJurusan();
                break;
            case "Lihat Semua Jurusan":
                mainFrame.setVisible(false);
                new SelectJurusan();
                break;
            case "Insert Mahasiswa Baru":
                mainFrame.setVisible(false);
                new InsertMhs();
                break;
            case "Lihat Data Per Jurusan":
                mainFrame.setVisible(false);
                String inputan = JOptionPane.showInputDialog("Kode Jurusan = ");
                new SelectMahasiswa(inputan);
                break;
            default:
                break;
        }
    }
}
