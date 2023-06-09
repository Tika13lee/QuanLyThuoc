package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import connect.ConnectDB;
import dao.TaiKhoan_DAO;
import entity.TaiKhoan;

public class FrmDangNhap extends JFrame implements ActionListener {
	private JLabel lblTitle;
	private JLabel lblUser;
	private JLabel lblPass;
	private JLabel lblImg;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JButton btnLogIn;
	private JButton btnExit;

	private TaiKhoan_DAO tk_dao;

	public FrmDangNhap() {
		setTitle("DangNhap");
		setSize(800, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

		showGUI();

	}

	public void showGUI() {

		// ket noi database
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		tk_dao = new TaiKhoan_DAO();

		// title
		lblTitle = new JLabel("PHẦN MỀM QUẢN LÝ HIỆU THUỐC");
		lblTitle.setFont(new Font("Time new roman", Font.PLAIN, 30));
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setBounds(155, 23, 500, 30);

		// login
		lblUser = new JLabel("User: ");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUser.setBounds(410, 140, 45, 13);

		txtUser = new JTextField();
		txtUser.setBounds(515, 130, 245, 30);
		txtUser.setColumns(10);

		lblPass = new JLabel("Password:");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPass.setBounds(410, 200, 86, 13);

		txtPass = new JPasswordField();
		txtPass.setBounds(515, 190, 245, 30);
		txtPass.setColumns(10);

		btnLogIn = new JButton("Đăng nhập");
		btnLogIn.setBorder(BorderFactory.createRaisedBevelBorder());
		btnLogIn.setBounds(480, 270, 100, 30);
		// thiết lập nút mặc định khi nhấn enter
		getRootPane().setDefaultButton(btnLogIn);

		btnExit = new JButton("Thoát");

		btnExit.setBorder(BorderFactory.createRaisedBevelBorder());
		btnExit.setBounds(630, 270, 90, 30);

		lblImg = new JLabel();
		ImageIcon img = new ImageIcon("src/img/bg-login.png");
		lblImg.setIcon(img);
		lblImg.setBounds(0, 0, 800, 550);

		add(lblTitle);
		add(lblUser);
		add(txtUser);
		add(lblPass);
		add(txtPass);
		add(btnLogIn);
		add(btnExit);
		add(lblImg);

		// set data
		txtUser.setText("ThuyKieu");
		txtPass.setText("password1");

		// event
		txtUser.addActionListener(this);
		btnLogIn.addActionListener(this);
		btnExit.addActionListener(this);
	}

	public void display() {
		setVisible(true);
	}

	public static void main(String[] args) {
		new FrmDangNhap().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(txtUser)) {
			txtPass.requestFocus();
		}
		if (o.equals(btnLogIn)) {
			int flag = 0;
			String user = txtUser.getText().trim();
			String pass = String.valueOf(txtPass.getPassword());
			if (user.equals("") || pass.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin");
				flag = 1;
			} else {
				ArrayList<TaiKhoan> dsTK = tk_dao.getAllTaiKhoan();
				for (TaiKhoan tk : dsTK) {
					if (tk.getTenTK().equals(user) && tk.getMatKhau().equals(pass)) {
						flag = 1;
						JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
						String t = txtUser.getText();
						new FrmManHinhChinh(this, t).setVisible(true);
						setVisible(false);
					}
				}
			}
			if (flag == 0) {
				JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu không đúng");
				txtUser.requestFocus();
			}
		}
		if (o.equals(btnExit)) {
			System.exit(0);
		}
	}

}
