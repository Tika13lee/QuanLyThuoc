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
import javax.swing.border.BevelBorder;

public class FrmManHinhChinh extends JFrame implements ActionListener {
	private JLabel lblTitle;
	private JLabel lblImg;
	private JLabel lblUser;
	private JButton btnQuanLyThuoc;
	private JButton btnQuanLyThongKe;
	private JButton btnQuanLyHoaDon;
	private JButton btnLogOut;
	private String user;

	private FrmDangNhap dn;

	public FrmManHinhChinh(FrmDangNhap dn, String user) {
		this.dn = dn;
		this.user = user;

		setTitle("ManHinhChinh");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setLayout(null);

		showGUI();
	}

	public void showGUI() {
		lblTitle = new JLabel("QUẢN LÝ HIỆU THUỐC KNKP PHARMACY");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Time new roman", Font.BOLD, 35));
		lblTitle.setBounds(590, 23, 450, 35);

		btnQuanLyThuoc = new JButton("QUẢN LÝ THUỐC");
		btnQuanLyThuoc.setFont(new Font("Arial", Font.PLAIN, 16));
		btnQuanLyThuoc.setBounds(200, 120, 250, 60);
		btnQuanLyThuoc.setIcon(new ImageIcon("src/img/medicine-box-icon.png"));
		btnQuanLyThuoc.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

		btnQuanLyHoaDon = new JButton("QUẢN LÝ HÓA ĐƠN");
		btnQuanLyHoaDon.setFont(new Font("Arial", Font.PLAIN, 16));
		btnQuanLyHoaDon.setBounds(650, 120, 250, 60);
		btnQuanLyHoaDon.setIcon(new ImageIcon("src/img/Order-history-icon.png"));
		btnQuanLyHoaDon.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

		btnQuanLyThongKe = new JButton("QUẢN LÝ THỐNG KÊ");
		btnQuanLyThongKe.setFont(new Font("Arial", Font.PLAIN, 16));
		btnQuanLyThongKe.setBounds(1100, 120, 250, 60);
		btnQuanLyThongKe.setIcon(new ImageIcon("src/img/chart-icon.png"));
		btnQuanLyThongKe.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

		btnLogOut = new JButton("ĐĂNG XUẤT");
		btnLogOut.setBounds(1380, 30, 125, 30);
		btnLogOut.setIcon(new ImageIcon("src/img/logout-icon.png"));

		lblUser = new JLabel(user);
		lblUser.setBounds(1250, 30, 110, 30);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lblImg = new JLabel();
		ImageIcon img = new ImageIcon("src/img/bg-main.png");
		lblImg.setIcon(img);
		lblImg.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

		this.add(lblTitle);
		this.add(btnQuanLyThuoc);
		this.add(btnQuanLyHoaDon);
		this.add(btnQuanLyThongKe);
		this.add(lblUser);
		this.add(btnLogOut);
		this.add(lblImg);

		// event
		btnQuanLyThuoc.addActionListener(this);
		btnQuanLyHoaDon.addActionListener(this);
		btnQuanLyThongKe.addActionListener(this);
		btnLogOut.addActionListener(this);
	}

	public void display() {
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnQuanLyThuoc)) {
			new FrmQLThuoc(this).setVisible(true);
			setVisible(false);
		}
		if (o.equals(btnQuanLyHoaDon)) {
			new FrmQLHoaDon(this, user).setVisible(true);
			setVisible(false);
		}
		if (o.equals(btnQuanLyThongKe)) {
			new FrmQLThongKe(this).setVisible(true);
			setVisible(false);
		}
		if (o.equals(btnLogOut)) {
			if (JOptionPane.showConfirmDialog(this, "Bạn chắc muốn đăng xuất?", "Cảnh báo",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				dn.display();
				setVisible(false);
			}
		}

	}

}
