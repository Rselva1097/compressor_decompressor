package GUI;
import java.io.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.attribute.standard.Compression;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import comp_deco.compressor;
import comp_deco.decompressor;

public class AppFrame extends JFrame implements ActionListener {

	JButton compressButton;
	JButton decompressButton;
	
	AppFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		compressButton = new JButton("Please select file to compress");
		compressButton.setBounds(20, 100, 200, 30);
		compressButton.addActionListener(this);
		
		decompressButton = new JButton("Please select file to decompress");
		decompressButton.setBounds(20, 100, 200, 30);
		decompressButton.addActionListener(this);
		
		this.add(compressButton);
		this.add(decompressButton);
		this.setSize(1000, 500);
		this.getContentPane().setBackground(Color.BLACK);
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == compressButton) {
			JFileChooser fileChooser=new JFileChooser();
			int response=fileChooser.showSaveDialog(null);
			
			if(response == JFileChooser.APPROVE_OPTION) {
				File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
				System.out.println(file);
				try {
					compressor.method(file);
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e2.toString());
				}
			}
		}
		
		if(e.getSource() == decompressButton) {
			JFileChooser fileChooser=new JFileChooser();
			int response=fileChooser.showSaveDialog(null);
			
			if(response == JFileChooser.APPROVE_OPTION) {
				File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
				System.out.println(file);
				try {
					decompressor.method(file);
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e2.toString());
				}
			}
		}
	}

}
