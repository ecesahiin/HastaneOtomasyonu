package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

import Helper.*;
import Model.Bashekim;
import java.awt.Window.Type;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

public class LoginGUI extends JFrame {
	
	private JPanel w_pane;
	private JTextField fld_hastaPass;
	private JTextField textField_1;
	private JTextField fld_doctorTc;
	private JPasswordField fld_doctorPass;
	private DBConnection conn = new DBConnection();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setSize(1920, 1080);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		setSize(new Dimension(1920, 1080));
		setResizable(false);
		setTitle("Hastane Otomasyonu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 400);
		w_pane = new JPanel();
		w_pane.setSize(new Dimension(1000, 1000));
		w_pane.setMinimumSize(new Dimension(600, 600));
		w_pane.setBackground(Color.WHITE);
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_pane);
		w_pane.setLayout(null);

		JLabel lbl_logo = new JLabel("");
		lbl_logo.setBounds(48, 103, 49, 14);
		w_pane.add(lbl_logo);

		JLabel lblNewLabel = new JLabel("Hastane Y\u00F6netimine Ho\u015Fgeldiniz");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblNewLabel.setBounds(108, 103, 268, 30);
		w_pane.add(lblNewLabel);
		JTabbedPane w_tabpane = new JTabbedPane(JTabbedPane.TOP);
		w_tabpane.setBounds(21, 144, 452, 218);
		w_pane.add(w_tabpane);

		JPanel w_hastaLogin = new JPanel();
		w_hastaLogin.setBounds(new Rectangle(960, 540, 960, 540));
		w_hastaLogin.setLocation(new Point(960, 540));
		w_hastaLogin.setBackground(Color.WHITE);
		w_tabpane.addTab("Hasta Giriþi", null, w_hastaLogin, null);
		w_hastaLogin.setLayout(null);

		JLabel lblifre = new JLabel("\u015Eifre:");
		lblifre.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblifre.setBounds(10, 45, 268, 30);
		w_hastaLogin.add(lblifre);

		JLabel lblTcNumaranz = new JLabel("T.C Numaran\u0131z:");
		lblTcNumaranz.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblTcNumaranz.setBounds(10, 7, 127, 30);
		w_hastaLogin.add(lblTcNumaranz);

		fld_hastaPass = new JTextField();
		fld_hastaPass.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		fld_hastaPass.setText("12345750987");
		fld_hastaPass.setBounds(169, 12, 180, 20);
		w_hastaLogin.add(fld_hastaPass);
		fld_hastaPass.setColumns(10);

		fld_doctorPass = new JPasswordField();
		fld_doctorPass.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		fld_doctorPass.setText("");
		fld_doctorPass.setBounds(169, 12, 180, 20);
		w_hastaLogin.add(fld_doctorPass);
		fld_doctorPass.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		textField_1.setText("1234");
		textField_1.setBounds(169, 53, 180, 20);
		w_hastaLogin.add(textField_1);
		textField_1.setColumns(10);

		JButton btn_register = new JButton("Kay\u0131t Ol");
		btn_register.setBounds(32, 121, 159, 41);
		w_hastaLogin.add(btn_register);

		JButton btn_hastaLogin = new JButton("Giri\u015F Yap");
		btn_hastaLogin.setBounds(242, 121, 159, 41);
		w_hastaLogin.add(btn_hastaLogin);

		JPanel w_doctorLogin = new JPanel();
		w_doctorLogin.setBackground(Color.WHITE);
		w_tabpane.addTab("Doktor Giriþi", null, w_doctorLogin, null);
		w_doctorLogin.setLayout(null);

		JLabel lblTcNumaranz_1 = new JLabel("T.C Numaran\u0131z:");
		lblTcNumaranz_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblTcNumaranz_1.setBounds(10, 24, 127, 30);
		w_doctorLogin.add(lblTcNumaranz_1);

		fld_doctorTc = new JTextField();
		fld_doctorTc.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		fld_doctorTc.setColumns(10);
		fld_doctorTc.setBounds(147, 29, 180, 20);
		w_doctorLogin.add(fld_doctorTc);

		JLabel lblifre_1 = new JLabel("\u015Eifre:");
		lblifre_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblifre_1.setBounds(10, 69, 118, 30);
		w_doctorLogin.add(lblifre_1);

		JButton btn_doctorLogin = new JButton("Giri\u015F Yap");
		btn_doctorLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fld_doctorTc.getText().length() == 0 || fld_doctorPass.getText().length() == 0) {
					Helper.showMsg("fill");
				} else {
					try {
						Connection con = conn.connDb();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM user where tcno = "+fld_doctorTc.getText()+ " and password = " + fld_doctorPass.getText());

						while (rs.next()) {
							Bashekim bhekim = Bashekim.getInstance(rs.getInt("id"), rs.getString("tcno"),
									rs.getString("name"), fld_doctorPass.getText(), rs.getString("type"));
							BashekimGUI bGUI = new BashekimGUI(bhekim);
							bGUI.setVisible(true);
							dispose();

						}

					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}
			}
		});
		btn_doctorLogin.setBounds(70, 110, 272, 41);
		w_doctorLogin.add(btn_doctorLogin);

		fld_doctorPass = new JPasswordField();
		fld_doctorPass.setBounds(147, 77, 180, 20);
		w_doctorLogin.add(fld_doctorPass);
	}
}
