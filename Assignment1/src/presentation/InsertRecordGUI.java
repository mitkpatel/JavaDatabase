package presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

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
		
		JLabel lbHeading = new JLabel("COVID-19 Reporting Canada");
		lbHeading.setForeground(new Color(255, 0, 0));
		lbHeading.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lbHeading.setBounds(32, 24, 377, 27);
		getContentPane().add(lbHeading);
		
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
	}
}