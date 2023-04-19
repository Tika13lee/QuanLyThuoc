package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FrmDangNhap extends JFrame implements ActionListener {
	private JLabel lblTitle;
	private JLabel lblUser;
	private JLabel lblPass;
	private JLabel lblImg;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JButton btnLogIn;

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
		btnLogIn.setBounds(530, 270, 100, 30);

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
		add(lblImg);

		// set data
		txtUser.setText("nhom3");
		txtPass.setText("147852369");

		// event
		btnLogIn.addActionListener(this);

	}

	public static void main(String[] args) {
		new FrmDangNhap().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnLogIn)) {
			String user = txtUser.getText().trim();
			String pass = txtPass.getText().trim();
			if (user.equals("") || pass.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin");
			} else {
				if (user.equals("nhom3") && pass.equals("147852369")) {
					FrmManHinhChinh main = new FrmManHinhChinh();
					main.setVisible(true);
					setVisible(false);
				}
			}
		}
	}

}
