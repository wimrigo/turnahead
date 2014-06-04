package com.programmeren4.turnahead.server.database;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TestJDBCDriverInstallation_MySQL extends JFrame {
	private static final long serialVersionUID = -8255365930046001911L;
	private static TestJDBCDriverInstallation_MySQL _instance = null;
	private boolean flagFailed = false;

	public static synchronized TestJDBCDriverInstallation_MySQL getInstance() {
		if (_instance == null) {
			_instance = new TestJDBCDriverInstallation_MySQL();
		}
		return _instance;
	}

	private TestJDBCDriverInstallation_MySQL() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Tiny test frame");
		setVisible(true);
		setSize(new Dimension(20, 20));
		setLocationRelativeTo(null);

		try {
			@SuppressWarnings("rawtypes")
			Class driverObject = Class.forName("org.gjt.mm.mysql.Driver");
			JOptionPane.showMessageDialog(this, "driverObject=" + driverObject
					+ ". JDBC Driver detected. Your installation is OK.");
		} catch (Exception e) {
			this.flagFailed = true;
			JOptionPane
					.showMessageDialog(
							this,
							"JDBC Driver not detected: "
									+ e.getMessage()
									+ ". Please download MySQL Server and host a local instance. Program will exit now.");
		}
		this.dispose();
	}

	public boolean isFlag() {
		return flagFailed;
	}

}
