package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DangNhap extends JFrame {
	private JLabel lblTitle;
	private JLabel lblUser;
	private JLabel lblImg;
	private JLabel lblPass;
	private JTextField txtUser;
	private JTextField txtPass;

	public DangNhap() {
		setTitle("DangNhap");
		setSize(800, 620);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(null);
		showGUI();
	}

	public void showGUI() {
		lblTitle = new JLabel("ĐĂNG NHẬP");
		lblTitle.setFont(new Font("Arial", Font.PLAIN, 30));
		lblTitle.setBounds(500, 162, 180, 29);
		lblTitle.setForeground(Color.BLUE);
		this.add(lblTitle);
		
		lblUser = new JLabel("User: ");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUser.setBounds(431, 256, 45, 13);
		this.add(lblUser);
		
		lblPass = new JLabel("Password:");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPass.setBounds(431, 312, 86, 13);
		this.add(lblPass);
		
		txtUser = new JTextField();
		txtUser.setBounds(527, 250, 222, 29);
		txtUser.setColumns(10);
		this.add(txtUser);
		
		txtPass = new JTextField();
		txtPass.setBounds(527, 306, 222, 29);
		txtPass.setColumns(10);
		this.add(txtPass);
		
		lblImg = new JLabel("New label");
		lblImg.setIcon(new ImageIcon(
				"C:/Users/DELL/eclipse-workspace/BTLon_Java/QuanLyThuoc/QuanLyThuoc_N3/src/img/bg-login.png"));
		lblImg.setBounds(0, 0, 800, 580);
		this.add(lblImg);
	}

	public static void main(String[] args) {
		new DangNhap();
	}

}
