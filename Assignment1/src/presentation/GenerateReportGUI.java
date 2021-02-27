package presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import data.TextFileIO;

import java.awt.Font;
import java.io.IOException;
import java.awt.Color;
import javax.swing.JTextArea;

public class GenerateReportGUI extends JFrame {
	public GenerateReportGUI() {
		this.setBounds(500, 200, 558, 400);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("All records of COVID-19 Canada");
		lblNewLabel.setForeground(new Color(0, 51, 204));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(20, 21, 501, 20);
		getContentPane().add(lblNewLabel);
		
		JTextArea txtAreaGenerateReport = new JTextArea();
		txtAreaGenerateReport.setBounds(20, 52, 501, 298);
		getContentPane().add(txtAreaGenerateReport);
		
		// User can only see data, can not edit the text area
		txtAreaGenerateReport.setEditable(false);
		
		Object[] Userdata = null;

		try {
			Userdata = TextFileIO.readRecords();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		for(Object s: Userdata) {
			txtAreaGenerateReport.append(s.toString() + "\n");
		}
	}
}
