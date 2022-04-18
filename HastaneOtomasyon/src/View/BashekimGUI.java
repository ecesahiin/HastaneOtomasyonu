package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Model.*;
import SQL.SQLOperations;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Helper.*;
import javax.swing.JComboBox;

public class BashekimGUI extends JFrame{

	SQLOperations sql=new SQLOperations();
	Clinic clinic = new Clinic();
	private JPanel w_pane;
	private JTextField fld_dName;
	private JTextField fld_dTcno;
	private JTextField fld_dPass;
	private JTextField fld_doctorID;
	private JTable table_doctor;
	private DefaultTableModel doctorModel = null;
	private Object[] doctorData = null;
	private JTable table_clinic,table_clinic2;
	private JTextField fld_clinicName;
	private DefaultTableModel clinicModel = null,clinicmodel2;
	private Object[] clinicData = null,clinicData2;
	private JPopupMenu clinicMenu;
	private Item item;
	private int selID;
	public BashekimGUI(Bashekim bashekim) throws SQLException {
		
		
		
		// Doctor Model
		doctorModel = new DefaultTableModel();
		Object[] colDoctorName = new Object[4];
		colDoctorName[0] = "ID";
		colDoctorName[1] = "Ad Soyad";
		colDoctorName[2] = "TC NO";
		colDoctorName[3] = "Þifre";
		doctorModel.setColumnIdentifiers(colDoctorName);
		doctorData = new Object[4];
		for (int i = 0; i < sql.getDoctorList().size(); i++) {
			doctorData[0] = sql.getDoctorList().get(i).getId();
			doctorData[1] = sql.getDoctorList().get(i).getName();
			doctorData[2] = sql.getDoctorList().get(i).getTcno();
			doctorData[3] = sql.getDoctorList().get(i).getPassword();
			doctorModel.addRow(doctorData);
		}
		

		// Clinic Model
		clinicModel = new DefaultTableModel();
		Object[] colClinic = new Object[2];
		colClinic[0] = "ID";
		colClinic[1] = "Poliklinik Adý";
		clinicModel.setColumnIdentifiers(colClinic);
		clinicData = new Object[2];
		for (int i = 0; i < clinic.getList().size(); i++) {
			clinicData[0] = clinic.getList().get(i).getId();
			clinicData[1] = clinic.getList().get(i).getName();
			clinicModel.addRow(clinicData);

		}
		
		clinicmodel2 = new DefaultTableModel();
		Object[] colClinic2 = new Object[2];
		colClinic2[0] = "Doktor";
		colClinic2[1] = "Poliklinik";
		clinicmodel2.setColumnIdentifiers(colClinic2);
		clinicData2 = new Object[2];
		for (int i = 0; i <sql.GetClinics().size() ; i++) {
			clinicData2[0] = sql.GetClinics().get(i).getClinic_name();
			clinicData2[1] = sql.GetClinics().get(i).getDoctor_name();
			clinicmodel2.addRow(clinicData2);

		}
		
		
		

		setResizable(false);
		setTitle("Hastane Y\u00F6netim Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		w_pane = new JPanel();
		w_pane.setBackground(Color.GRAY);
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_pane);
		w_pane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Hoþgeldiniz, Sayýn " + bashekim.getName());
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel.setBounds(9, 23, 257, 28);
		w_pane.add(lblNewLabel);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(105, 108, 5, 5);
		w_pane.add(tabbedPane);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 90, 726, 372);
		w_pane.add(tabbedPane_1);

		JPanel w_doctor = new JPanel();
		w_doctor.setBackground(Color.WHITE);
		tabbedPane_1.addTab("Doktor Yönetimi", null, w_doctor, null);
		w_doctor.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Ad Soyad");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		lblNewLabel_1.setBounds(556, 11, 155, 25);
		w_doctor.add(lblNewLabel_1);

		fld_dName = new JTextField();
		fld_dName.setBounds(556, 34, 143, 25);
		w_doctor.add(fld_dName);
		fld_dName.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("T.C No");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		lblNewLabel_2.setBounds(556, 70, 143, 25);
		w_doctor.add(lblNewLabel_2);

		fld_dTcno = new JTextField();
		fld_dTcno.setBounds(556, 93, 144, 25);
		w_doctor.add(fld_dTcno);
		fld_dTcno.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("\u015Eifre");
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(556, 129, 143, 25);
		w_doctor.add(lblNewLabel_2_1);

		fld_dPass = new JTextField();
		fld_dPass.setColumns(10);
		fld_dPass.setBounds(556, 158, 144, 25);
		w_doctor.add(fld_dPass);

		JLabel lblNewLabel_1_1 = new JLabel("Kullan\u0131c\u0131 ID");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(556, 236, 155, 25);
		w_doctor.add(lblNewLabel_1_1);

		fld_doctorID = new JTextField();
		fld_doctorID.setColumns(10);
		fld_doctorID.setBounds(556, 259, 144, 25);
		w_doctor.add(fld_doctorID);

		JButton btn_delDoctor = new JButton("Sil");
		btn_delDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SQLOperations s=new SQLOperations();
				s.Delete(Integer.parseInt(fld_doctorID.getText()));
				try {
					updateDoctorModel();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btn_delDoctor.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btn_delDoctor.setBounds(556, 295, 143, 31);
		w_doctor.add(btn_delDoctor);

		JScrollPane w_scrollDoctor = new JScrollPane();
		w_scrollDoctor.setBounds(10, 11, 540, 322);
		w_doctor.add(w_scrollDoctor);

		table_doctor = new JTable(doctorModel);
		w_scrollDoctor.setViewportView(table_doctor);

		JButton btnNewButton = new JButton("Ekle");
		btnNewButton.setBounds(556, 194, 110, 28);
		w_doctor.add(btnNewButton);
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fld_dName.getText().length() == 0 || fld_dPass.getText().length() == 0
						|| fld_dTcno.getText().length() == 0) {
					Helper.showMsg("fill");
				} else {
					try {
						Bashekim bashekim=new Bashekim(new DB());
						bashekim.setTcno(fld_dTcno.getText());
						bashekim.setPassword(fld_dPass.getText());
						bashekim.setName(fld_dName.getText());
						boolean control = bashekim.Insert();
						if (control) {
							Helper.showMsg("success");
							fld_dName.setText(null);
							fld_dTcno.setText(null);
							fld_dPass.setText(null);
							updateDoctorModel();

						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		JButton btn_addDoctor = new JButton("\u00C7\u0131k\u0131\u015F Yap");
		btn_addDoctor.setBounds(579, 22, 143, 31);
		w_pane.add(btn_addDoctor);
		btn_addDoctor.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btn_addDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginGUI frame = new LoginGUI();
				frame.setVisible(true);

			}

		});
		JPanel w_clinic = new JPanel();
		w_clinic.setBackground(Color.LIGHT_GRAY);
		tabbedPane_1.addTab("Poliklinikler", null, w_clinic, null);
		w_clinic.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 82, 2, 2);
		w_clinic.add(scrollPane);

		JScrollPane w_scrollClinic = new JScrollPane();
		w_scrollClinic.setBounds(10, 11, 266, 322);
		w_clinic.add(w_scrollClinic);

		clinicMenu = new JPopupMenu();
		JMenuItem updateMenu = new JMenuItem("Güncelle");
		JMenuItem deleteMenu = new JMenuItem("Sil");
		clinicMenu.add(updateMenu);
		clinicMenu.add(deleteMenu);

		updateMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selID = Integer.parseInt(table_clinic.getValueAt(table_clinic.getSelectedRow(), 0).toString());
				Clinic selectClinic = clinic.getFetch(selID);
				UpdateClinicGUI updateGUI = new UpdateClinicGUI(selectClinic);
				updateGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				updateGUI.setVisible(true);
				updateGUI.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						try {
							updateClinicModel();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

				});
			}
		});
		deleteMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Helper.confirm("sure")) {
					selID = Integer.parseInt(table_clinic.getValueAt(table_clinic.getSelectedRow(), 0).toString());
					try {
						if (clinic.deleteClinic(selID)) {
							Helper.showMsg("success");
							updateClinicModel();

						} else {
							Helper.showMsg("error");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}

		});

		table_clinic = new JTable(clinicModel);
		table_clinic.setComponentPopupMenu(clinicMenu);
		table_clinic.addMouseListener((MouseListener) new MouseAdapter() {
			private MouseEvent e;

			@Override
			public void mousePressed(MouseEvent e) {

				Point point = e.getPoint();
				int selectedRow = table_clinic.rowAtPoint(point);
				table_clinic.setRowSelectionInterval(selectedRow, selectedRow);

			}
		});
		
		w_scrollClinic.setViewportView(table_clinic);
		
		
		JLabel lblNewLabel_1_2 = new JLabel("Poliklinik Ad\u0131");
		lblNewLabel_1_2.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(286, 11, 155, 25);
		w_clinic.add(lblNewLabel_1_2);

		fld_clinicName = new JTextField();
		fld_clinicName.setColumns(10);
		fld_clinicName.setBounds(286, 34, 142, 25);
		w_clinic.add(fld_clinicName);

		JButton btn_addClinic = new JButton("Ekle");
		btn_addClinic.setBackground(Color.GRAY);
		btn_addClinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fld_clinicName.getText().length() == 0) {
					Helper.showMsg("fill");
				} else {
					try {
						
						if (clinic.addClinic(fld_clinicName.getText())) {
							Helper.showMsg("success");
							fld_clinicName.setText(null);
							updateClinicModel();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
					}
				}
			}
		});
		btn_addClinic.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btn_addClinic.setBounds(286, 70, 142, 28);
		w_clinic.add(btn_addClinic);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(438, 11, 271, 322);
		w_clinic.add(scrollPane_1);
		
		table_clinic2 = new JTable(clinicmodel2);
		scrollPane_1.setViewportView(table_clinic2);
		JComboBox select_doctor = new JComboBox();
		select_doctor.setBounds(286, 256, 142, 33);
		for(int i=0 ; i < sql.getDoctorList().size() ; i++) {
			select_doctor.addItem(new Item(sql.getDoctorList().get(i).getId() ,sql.getDoctorList().get(i).getName()));
		}
		select_doctor.addActionListener(e -> {
		    JComboBox c = (JComboBox) e.getSource();
		    item = (Item) c.getSelectedItem();
		    System.out.println(item.getKey() + ":" +item.getValue());
		});
		w_clinic.add(select_doctor);
		
		JButton btn_addCWorker = new JButton("Ekle");
		btn_addCWorker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selRow = table_clinic.getSelectedRow();
				int a;
				a=((Item) select_doctor.getSelectedItem()).getKey();
				
				if(selRow >= 0) {
					String selClinic = table_clinic.getModel().getValueAt(selRow, 0).toString();
					int selClinicID = Integer.parseInt(selClinic);
					Item doctorItem = (Item) select_doctor.getSelectedItem();
					try {
						int x=sql.getClinicList(table_clinic.getSelectedRow()).getId();
						sql.asd(a,x);
						updateClinicModel2();
					} catch (SQLException e2) {
					}
					try {
						boolean control = sql.addWorker(doctorItem.getKey(), selClinicID);
					} catch (SQLException e1) {
						
					}
					
				}else {
					Helper.showMsg("Lütfen bir poliklinik seçiniz !");
				}
			}

			
		});
		btn_addCWorker.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btn_addCWorker.setBounds(286, 300, 142, 33);
		w_clinic.add(btn_addCWorker);
		
		JButton btnNewButton_1 = new JButton("Yetki Ver");
		btnNewButton_1.setBounds(287, 26, 103, 28);

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				sql.Yetki(1,Integer.parseInt(fld_doctorID.getText()));
			}
		});
		
		
		w_pane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Yetki Al");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sql.Yetki(0,Integer.parseInt(fld_doctorID.getText()));
			}
		});
		btnNewButton_1_1.setBounds(415, 26, 103, 28);
		w_pane.add(btnNewButton_1_1);
	}

	public void updateDoctorModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_doctor.getModel();
		clearModel.setRowCount(0);
		for (int i = 0; i < sql.getDoctorList().size(); i++) {
			doctorData[0] = sql.getDoctorList().get(i).getId();
			doctorData[1] = sql.getDoctorList().get(i).getName();
			doctorData[2] = sql.getDoctorList().get(i).getTcno();
			doctorData[3] = sql.getDoctorList().get(i).getPassword();
			doctorModel.addRow(doctorData);
		}
	}
	

	public void updateClinicModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_clinic.getModel();
		clearModel.setRowCount(0);
		for (int i = 0; i < clinic.getList().size(); i++) {
			clinicData[0] = clinic.getList().get(i).getId();
			clinicData[1] = clinic.getList().get(i).getName();

			clinicModel.addRow(clinicData);

		}
	}
	public void updateClinicModel2() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_clinic2.getModel();
		clearModel.setRowCount(0);
		for (int i = 0; i <sql.GetClinics().size(); i++) {
			clinicData2[0] = sql.GetClinics().get(i).getClinic_name();
			clinicData2[1] = sql.GetClinics().get(i).getDoctor_name();

			clinicmodel2.addRow(clinicData2);

		}
	}
}
