package assignment1;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainWindow extends JFrame {
	private JMenuBar mb;
	private JMenu mnuFile, mnuManage, mnuHelp;
	private JMenuItem mnuAddRecord, mnuSearchRecord, mnuGenerateReport, mnuExit;

	public MainWindow() {
		initialize();

	}

	private void initialize() {
		this.setTitle("Assignment 1 - MJTitans");
		this.setBounds(100, 100, 400, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);

		mb = new JMenuBar();
		this.setJMenuBar(mb);

		mnuFile = new JMenu("File");
		mb.add(mnuFile);
		mnuAddRecord = new JMenuItem("Insert Record");
		mnuFile.add(mnuAddRecord);
		mnuManage = new JMenu("Manage");
		mb.add(mnuManage);
		mnuSearchRecord = new JMenuItem("Search Record");
		mnuManage.add(mnuSearchRecord);
		mnuGenerateReport = new JMenuItem("Generate Report");
		mnuFile.add(mnuGenerateReport);
		mnuHelp = new JMenu("Help");
		mb.add(mnuHelp);
		mnuExit = new JMenuItem("Exit");
		mnuHelp.add(mnuExit);

		mnuAddRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// StudentMgmtGUI smg=new StudentMgmtGUI();
				// smg.setVisible(true);
			}
		});
		
		mnuSearchRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// StudentSearchGUI studentSearch=new StudentSearchGUI();
				// studentSearch.setVisible(true);
			}
		});
		
		mnuGenerateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// StudentMgmtGUI smg=new StudentMgmtGUI();
				// smg.setVisible(true);
			}
		});
		
		/*
		 * mnuExit.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { JOptionPane.showMessageDialog(null,
		 * "This is SMS Application System"); System.exit(0); } });
		 */

	}
}
