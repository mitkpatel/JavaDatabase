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
import java.text.SimpleDateFormat;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JList;
import javax.swing.JComboBox;

public class InsertRecordGUI extends JFrame {
	private JTextField txtDate;
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
		txtDate.setBounds(219, 62, 112, 20);
		getContentPane().add(txtDate);
		txtDate.setColumns(10);
		
		JLabel lbCity = new JLabel("City name");
		lbCity.setBounds(32, 87, 90, 14);
		getContentPane().add(lbCity);
		
		JLabel lbCases = new JLabel("Number of cases");
		lbCases.setBounds(32, 112, 136, 14);
		getContentPane().add(lbCases);
		
		txtCases = new JTextField();
		txtCases.setColumns(10);
		txtCases.setBounds(219, 112, 112, 20);
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
		txtDeaths.setBounds(219, 137, 112, 20);
		getContentPane().add(txtDeaths);
		
		JLabel lbCaseRecover = new JLabel("Number of cases recovered");
		lbCaseRecover.setBounds(32, 163, 177, 14);
		getContentPane().add(lbCaseRecover);
		
		txtRecover = new JTextField();
		txtRecover.setColumns(10);
		txtRecover.setBounds(219, 160, 112, 20);
		getContentPane().add(txtRecover);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(32, 196, 112, 23);
		getContentPane().add(btnReset);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(203, 196, 128, 23);
		getContentPane().add(btnSubmit);
		
		String cityNames[] = {"Toronto","Brampton","Ottawa","Hamilton","Mississauga"};
		JComboBox txtCity = new JComboBox(cityNames);
		txtCity.setSelectedIndex(-1);
		txtCity.setBounds(219, 86, 112, 22);
		getContentPane().add(txtCity);
		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDate.setText("");
				txtCases.setText("");
				txtDeaths.setText("");
				txtRecover.setText("");
				txtCity.setSelectedIndex(-1);
				
			}
		});
		
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String cityName = txtCity.toString();;
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
				    	if (recordDate.matches("^([0-9]{1,2}/){2}[0-9]{4}$")) {
				    		if(txtCity.getSelectedIndex() == -1) {
				    			JOptionPane.showMessageDialog(null, "City name is required field, you have to select city from dropdown menu!");
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
								 String recordEntry = "Date: " + recordDate + ", City: " + txtCity.getSelectedItem() + ", Cases: " 
										 + caseCount + ", Deaths: " + deathCount + ", Recovered: " + recoverCount;
								
									try {
										TextFileIO.writeRecord(recordEntry);
										JOptionPane.showMessageDialog(null, "Data is saved to the file successfully!");
									} catch (IOException e1) {
										JOptionPane.showMessageDialog(null, "Error!!!" + e1.getMessage());
									}
									
									JOptionPane.showMessageDialog(null, "Date: " + recordDate + "\n" + "City: " + txtCity.getSelectedItem() + "\n" +
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