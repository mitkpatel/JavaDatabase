package presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import data.TextFileIO;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import java.util.regex.Pattern;

public class SearchRecordGUI extends JFrame {
	private JTextField txtFindCity;
	private JTextField txtFindDate;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public SearchRecordGUI() {
		getContentPane().setLayout(null);
		this.setBounds(100,100, 500, 382);
		
		JLabel lbSearchHeading = new JLabel("Search particular records");
		lbSearchHeading.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbSearchHeading.setForeground(new Color(0, 51, 255));
		lbSearchHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lbSearchHeading.setBounds(20, 25, 464, 20);
		getContentPane().add(lbSearchHeading);
		
		JRadioButton rdbtnCity = new JRadioButton("Search record by city name");
		rdbtnCity.setSelected(true);
		buttonGroup.add(rdbtnCity);
		rdbtnCity.setBounds(20, 52, 220, 23);
		getContentPane().add(rdbtnCity);
		
		txtFindCity = new JTextField();
		txtFindCity.setBounds(317, 53, 107, 20);
		getContentPane().add(txtFindCity);
		txtFindCity.setColumns(10);
		
		JRadioButton rdbtnDate = new JRadioButton("Search record for specific date (dd/mm/yyyy)");
		buttonGroup.add(rdbtnDate);
		rdbtnDate.setBounds(20, 78, 291, 23);
		getContentPane().add(rdbtnDate);
		
		txtFindDate = new JTextField();
		txtFindDate.setColumns(10);
		txtFindDate.setBounds(317, 79, 107, 20);
		getContentPane().add(txtFindDate);
		
		JButton btnFind = new JButton("Find");
		btnFind.setBounds(121, 111, 89, 23);
		getContentPane().add(btnFind);
		
		JTextArea txtAreaFindRecord = new JTextArea();
		txtAreaFindRecord.setBounds(20, 145, 442, 187);
		getContentPane().add(txtAreaFindRecord);
		
		// User can only see data, can not edit the text area
		txtAreaFindRecord.setEditable(false);
		
		JButton btnSearchAgain = new JButton("Search Again");
		btnSearchAgain.setBounds(236, 111, 112, 23);
		getContentPane().add(btnSearchAgain);
		
		btnSearchAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAreaFindRecord.setText("");
				txtFindDate.setText("");
				txtFindCity.setText("");
				txtFindDate.setEditable(true);
				txtFindCity.setEditable(true);
			}
		});
		
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchDate = txtFindDate.getText();
				String searchCity = txtFindCity.getText();
				
				Object[] Userdata = null;
				
				try {
					Userdata = TextFileIO.readRecords();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				if (rdbtnCity.isSelected()) {
					txtAreaFindRecord.setText("");
					txtFindDate.setText("");
					if(!(Pattern.matches("[a-zA-Z]+",searchCity)) || (searchCity.isEmpty())) {
						 JOptionPane.showMessageDialog(null, "Enter valid city name first."); 
					 }
					else {
						if (searchCity.matches("^[a-zA-Z]*$")) {
							txtFindCity.setEditable(false);
							for(Object s: Userdata) {
								String str = (String)s;
								String[] splitArray = str.split(",");
								if(splitArray[1].contains(searchCity)) {
									txtAreaFindRecord.append(str + "\n");
								}
							}
						}
					}
						
				} else if (rdbtnDate.isSelected()) {
					txtAreaFindRecord.setText("");
					txtFindCity.setText("");
					if (searchDate.isEmpty()) {
						 JOptionPane.showMessageDialog(null, "Enter date first!");
					} 
					else if (searchDate.matches("^([0-9]{1,2}/){2}[0-9]{2,4}$")) {
						txtFindDate.setEditable(false);;
						for(Object s: Userdata) {
							String str = (String)s;
							String[] splitArray = str.split(",");
							if(splitArray[0].contains(searchDate)) {
								txtAreaFindRecord.append(str + "\n");
							} 
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Enter date in dd/mm/yyyy format!");
					}
				}
				
			}
		});
	}
}
