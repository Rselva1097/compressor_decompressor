package GUI;

import comp_decomp.compressor;
import comp_decomp.decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static comp_decomp.decompressor.*;

public class AppFrame extends JFrame implements ActionListener {

    JButton compress;
    JButton decompress;

    // constructor
    AppFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(null);

        this.setTitle("Compress And Decompress File");
        //buttons
        compress = new JButton("Select file to Compress");
        compress.setBounds(100,100,200,30);
        compress.setBackground(Color.pink);
        compress.addActionListener(this);

        decompress = new JButton("Select file to Decompress");
        decompress.setBounds(500,100,200,30);
        decompress.setBackground(Color.pink);
        decompress.addActionListener(this);



        // add buttons to the frame
        this.add(compress);
        this.add(decompress);

        // frame specifications
        this.setSize(1000,500);
        this.getContentPane().setBackground(Color.yellow);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==compress) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    compressor.method(file);
                }
                catch (Exception ee) {
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }

        if(e.getSource()==decompress) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    decompressor.method(file);
                }
                catch (Exception ee) {
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
    }
}
