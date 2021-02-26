package presentation;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;
import java.awt.Color;

public class HomePageGUI extends JFrame {
	
	public HomePageGUI() {
		this.initialize();
	}

	private void initialize() {
		this.setTitle("COVID-19 Report"); // Set the title
		this.setBounds(100,100, 400, 200);	//Set the size 400 x 200 at position 100,100
		//this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.getContentPane().setLayout(new BorderLayout()); //set the layout to border layout
		
		JLabel lblCaption = new JLabel("COVID-19 CANADA", SwingConstants.CENTER );
		lblCaption.setForeground(Color.BLUE);
		Font lblFont = lblCaption.getFont();
		lblCaption.setFont(new Font(lblFont.getFamily(), Font.BOLD, 30));
		getContentPane().add(lblCaption,BorderLayout.CENTER);
		
		JButton btnOK = new JButton("OK");
		getContentPane().add(btnOK, BorderLayout.SOUTH);
		btnOK.setMnemonic(KeyEvent.VK_O);

		// Click event handling for OK button
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Write your logic
				JOptionPane.showMessageDialog(null, "This is COVID-19 reporting application");
			}
		});

		JMenuBar mb = new JMenuBar();

		JMenu mnuFile = new JMenu("File");
		mnuFile.setMnemonic(KeyEvent.VK_F);
		mb.add(mnuFile);

		JMenuItem mnuAddRecord = new JMenuItem("Insert Record");
		mnuAddRecord.setMnemonic(KeyEvent.VK_X);
		mnuFile.add(mnuAddRecord);

		mnuAddRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertRecordGUI smg = new InsertRecordGUI();
				smg.setVisible(true);
			}
		});

		this.setJMenuBar(mb);

		// Student menu
		JMenu mnuManage = new JMenu("Manage");
		mb.add(mnuManage);

		JMenuItem mnuSearchRecord = new JMenuItem("Search Record");
		mnuManage.add(mnuSearchRecord);

		mnuSearchRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		JMenuItem mnuGenerateReport = new JMenuItem("Generate Report");
		mnuManage.add(mnuGenerateReport);

		mnuGenerateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//StudentSearchGUI smg = new StudentSearchGUI();
				//smg.setVisible(true);
			}
		});

		// Help Menu
		JMenu mnuHelp = new JMenu("Help");
		mnuHelp.setMnemonic(KeyEvent.VK_F);
		mb.add(mnuHelp);
		
		JMenuItem mnuExit = new JMenuItem("Exit");
		mnuHelp.add(mnuExit);

		mnuExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Thank you!");
				System.exit(0);
			}
		});
	}
}
