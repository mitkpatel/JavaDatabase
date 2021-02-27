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

import javax.swing.JOptionPane;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		btnReset.setBounds(103, 196, 90, 23);
		getContentPane().add(btnReset);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(203, 196, 102, 23);
		getContentPane().add(btnSubmit);
		
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String cityName;
				cityName = txtCity.getText();
				int caseCount = Integer.parseInt(txtCases.getText());
				int deathCount = Integer.parseInt(txtDeaths.getText());
				int recoverCount = Integer.parseInt(txtRecover.getText());
				String recordDate = txtDate.getText();
				
//				SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
//				
//				String formattedDate = null;
//				try {
//					formattedDate = sdf.format(sdf.parse(recordDate));
//				} catch (ParseException e2) {
//					// TODO Auto-generated catch block
//					e2.printStackTrace();
//				}
				
				
				SimpleDateFormat sdfrmt = new SimpleDateFormat("mm/dd/yyyy");
			    sdfrmt.setLenient(false);
			    if(recordDate != "") {
					JOptionPane.showMessageDialog(null, "Enter the date first.");
				}
			    else {
				    try
				    {
				        Date javaDate = sdfrmt.parse(recordDate); 
				        
				        if(cityName.length() == 0) {
							 JOptionPane.showMessageDialog(null, "Enter valid city name."); 
						 }
						 else if (caseCount <= 0) {
							 JOptionPane.showMessageDialog(null, "Cases should be greater than zero!"); 
						 }
						 else if (deathCount <= 0) {
							 JOptionPane.showMessageDialog(null, "Death count should be greater than zero!"); 
						 }
						 else if (recoverCount <= 0) {
							 JOptionPane.showMessageDialog(null, "Recover count should be greater than zero!"); 
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
				    /* Date format is invalid */
				    catch (ParseException eq)
				    {
				    	JOptionPane.showMessageDialog(null, "Invalid date! Enter valid Date.");
				        System.out.println(recordDate+" is Invalid Date format");
				        
				    }
			    }
			    
			    
//				if(recordDate.length() == 0) {
//					JOptionPane.showMessageDialog(null, "Enter the date first.");
//				}
//				else {
//					 if (formattedDate.equals(recordDate)) {
//						 JOptionPane.showMessageDialog(null, "Invalid date! Enter valid Date."); 
//					 }
//					 else {
//						 if(cityName.length() == 0) {
//							 JOptionPane.showMessageDialog(null, "Enter valid city name."); 
//						 }
//						 else if (caseCount <= 0) {
//							 JOptionPane.showMessageDialog(null, "Cases should be greater than zero!"); 
//						 }
//						 else if (deathCount <= 0) {
//							 JOptionPane.showMessageDialog(null, "Death count should be greater than zero!"); 
//						 }
//						 else if (recoverCount <= 0) {
//							 JOptionPane.showMessageDialog(null, "Recover count should be greater than zero!"); 
//						 }
//						 else {
//							 String recordEntry = "Date: " + recordDate + ", City: " + cityName + ", Cases: " 
//									 + caseCount + ", Deaths: " + deathCount + ", Recovered:" + recoverCount;
//								try {
//									TextFileIO.writeRecord(recordEntry);
//									JOptionPane.showMessageDialog(null, "Data is saved to the file successfully!");
//								} catch (IOException e1) {
//									JOptionPane.showMessageDialog(null, "Error!!!" + e1.getMessage());
//								}
//								
//								JOptionPane.showMessageDialog(null, "Date: " + recordDate + "\n" + "City: " + cityName + "\n" +
//								"Number of cases: " + caseCount + "\n" + "Number of deaths: " + deathCount + "\n" 
//										+ "Number of cases recovered: " + recoverCount);
//						 }
//					 }
//				}
			}
		});
	}
}