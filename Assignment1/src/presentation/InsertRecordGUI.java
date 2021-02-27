package presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import data.TextFileIO;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class InsertRecordGUI extends JFrame {
	private JTextField txtDate;
	private JTextField txtCity;
	private JTextField txtCases;
	private JTextField txtDeaths;
	private JTextField txtRecover;
	
	public InsertRecordGUI() {
		this.setBounds(500, 200, 500, 300);
		getContentPane().setLayout(null);
		
		JLabel lbDate = new JLabel("Date");
		lbDate.setBounds(32, 62, 90, 14);
		getContentPane().add(lbDate);
		
		txtDate = new JTextField();
		txtDate.setBounds(219, 62, 86, 20);
		getContentPane().add(txtDate);
		txtDate.setColumns(10);
		
		JLabel lbCity = new JLabel("City name");
		lbCity.setBounds(32, 87, 90, 14);
		getContentPane().add(lbCity);
		
		txtCity = new JTextField();
		txtCity.setColumns(10);
		txtCity.setBounds(219, 87, 86, 20);
		getContentPane().add(txtCity);
		
		JLabel lbCases = new JLabel("Number of cases");
		lbCases.setBounds(32, 112, 136, 14);
		getContentPane().add(lbCases);
		
		txtCases = new JTextField();
		txtCases.setColumns(10);
		txtCases.setBounds(219, 112, 86, 20);
		getContentPane().add(txtCases);
		
		JLabel lbHeadingReporing = new JLabel("COVID-19 Reporting Canada");
		lbHeadingReporing.setForeground(new Color(255, 0, 0));
		lbHeadingReporing.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbHeadingReporing.setHorizontalAlignment(SwingConstants.CENTER);
		lbHeadingReporing.setBounds(32, 24, 377, 27);
		getContentPane().add(lbHeadingReporing);
		
		JLabel lbDeath = new JLabel("Number of deaths");
		lbDeath.setBounds(32, 137, 136, 14);
		getContentPane().add(lbDeath);
		
		txtDeaths = new JTextField();
		txtDeaths.setColumns(10);
		txtDeaths.setBounds(219, 137, 86, 20);
		getContentPane().add(txtDeaths);
		
		JLabel lbCaseRecover = new JLabel("Number of cases recovered");
		lbCaseRecover.setBounds(32, 163, 177, 14);
		getContentPane().add(lbCaseRecover);
		
		txtRecover = new JTextField();
		txtRecover.setColumns(10);
		txtRecover.setBounds(219, 160, 86, 20);
		getContentPane().add(txtRecover);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnReset.setBounds(32, 196, 90, 23);
		getContentPane().add(btnReset);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(203, 196, 102, 23);
		getContentPane().add(btnSubmit);
		
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String cityName = txtCity.getText();;
				String regex = "[a-zA-Z]+";
				String caseCount = txtCases.getText();
				String deathCount = txtDeaths.getText();
				String recoverCount = txtRecover.getText();
				String recordDate = txtDate.getText();
				
				SimpleDateFormat sdfrmt = new SimpleDateFormat("mm/dd/yyyy");
			    sdfrmt.setLenient(false);
			    if(recordDate.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter the date first.");
				}
			    else {
				    	if (recordDate.matches("^([0-9]{1,2}/){2}[0-9]{2,4}$")) {
				    		if(!(Pattern.matches("[a-zA-Z]+",cityName)) || (cityName.isEmpty())) {
								 JOptionPane.showMessageDialog(null, "Enter valid city name first."); 
							 }
							 else if (!(caseCount.matches("[0-9]+") && caseCount.length() >= 1)) {
								 JOptionPane.showMessageDialog(null, "Number of cases is required field and postive numeric only!");
							 }
							 else if (!(deathCount.matches("[0-9]+") && deathCount.length() >= 1)) {
								 JOptionPane.showMessageDialog(null, "Death count is required field and postive numeric only!"); 
							 }
							 else if (!(recoverCount.matches("[0-9]+") && recoverCount.length() >= 1)) {
								 JOptionPane.showMessageDialog(null, "Recover count is required field and postive numeric only!"); 
							 }
							 else {
								 String recordEntry = "Date: " + recordDate + ", City: " + cityName + ", Cases: " 
										 + caseCount + ", Deaths: " + deathCount + ", Recovered: " + recoverCount;
								
									try {
										TextFileIO.writeRecord(recordEntry);
										JOptionPane.showMessageDialog(null, "Data is saved to the file successfully!");
									} catch (IOException e1) {
										JOptionPane.showMessageDialog(null, "Error!!!" + e1.getMessage());
									}
									
									JOptionPane.showMessageDialog(null, "Date: " + recordDate + "\n" + "City: " + cityName + "\n" +
									"Number of cases: " + caseCount + "\n" + "Number of deaths: " + deathCount + "\n" 
											+ "Number of cases recovered: " + recoverCount);
							 }
				    		
				    	}
				    	else {
				    		JOptionPane.showMessageDialog(null, "Please enter date in dd/mm/yyyy format!");
				    	}
				    }
			    }
		});
	}
}