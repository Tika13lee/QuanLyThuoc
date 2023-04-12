package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DangNhap extends JFrame implements ActionListener {
	private JLabel lblTitle;
	private JLabel lblUser;
	private JLabel lblPass;
	private JLabel lblImg;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JButton btnLogIn;

	public DangNhap() {
		setTitle("DangNhap");
		setSize(800, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
//		setExtendedState(MAXIMIZED_BOTH);

		showGUI();

	}

	public void showGUI() {

		// title
		JPanel jpTitle = new JPanel();
		this.add(jpTitle, BorderLayout.NORTH);
		jpTitle.add(lblTitle = new JLabel("PHẦN MỀM QUẢN LÝ HIỆU THUỐC"));
		lblTitle.setFont(new Font("Arial", Font.PLAIN, 30));
		lblTitle.setForeground(Color.BLUE);

		// login
		JPanel jpLogIn = new JPanel();
		jpLogIn.setLayout(null);
		jpLogIn.setBackground(Color.WHITE);
		this.add(jpLogIn);

		lblUser = new JLabel("User: ");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUser.setBounds(410, 110, 45, 13);

		txtUser = new JTextField();
		txtUser.setBounds(515, 100, 245, 30);
		txtUser.setColumns(10);

		lblPass = new JLabel("Password:");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPass.setBounds(410, 170, 86, 13);

		txtPass = new JPasswordField();
		txtPass.setBounds(515, 160, 245, 30);
		txtPass.setColumns(10);

		btnLogIn = new JButton("Đăng nhập");
		btnLogIn.setBounds(510, 240, 100, 30);

		lblImg = new JLabel("New label");
		lblImg.setIcon(new ImageIcon("src/img/bg-login.png"));
		lblImg.setBounds(0, 0, 800, 500);

		jpLogIn.add(lblUser);
		jpLogIn.add(txtUser);
		jpLogIn.add(lblPass);
		jpLogIn.add(txtPass);
		jpLogIn.add(btnLogIn);
		jpLogIn.add(lblImg);

		// set data
		txtUser.setText("nhom3");
		txtPass.setText("147852369");

		// event
		btnLogIn.addActionListener(this);
	}

	public static void main(String[] args) {
		new DangNhap();
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
					ManHinhChinh main = new ManHinhChinh();
					main.setVisible(true);
					setVisible(false);
				}
			}
		}
	}

}
