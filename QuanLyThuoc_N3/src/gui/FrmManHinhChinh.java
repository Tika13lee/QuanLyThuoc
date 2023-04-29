package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

public class FrmManHinhChinh extends JFrame implements ActionListener {
	private JLabel lblTitle;
	private JButton btnQuanLyThuoc;
	private JButton btnQuanLyThongKe;
	private JButton btnQuanLyHoaDon;
	private JLabel lblImg;
	private JButton btnLogOut;

	public FrmManHinhChinh() {
		setTitle("ManHinhChinh");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setLayout(null);

		showGUI();
	}

	public void showGUI() {
		lblTitle = new JLabel("QUẢN LÝ HIỆU THUỐC");
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
		btnLogOut.setBounds(1370, 30, 110, 30);

		lblImg = new JLabel();
		ImageIcon img = new ImageIcon("src/img/bg-main.png");
		lblImg.setIcon(img);
		lblImg.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

		this.add(lblTitle);
		this.add(btnQuanLyThuoc);
		this.add(btnQuanLyHoaDon);
		this.add(btnQuanLyThongKe);
		this.add(lblImg);
		this.add(btnLogOut);

		// event
		btnQuanLyThuoc.addActionListener(this);
		btnQuanLyHoaDon.addActionListener(this);
		btnQuanLyThongKe.addActionListener(this);
		btnLogOut.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnQuanLyThuoc)) {
			new FrmQLThuoc().setVisible(true);
			setVisible(false);
		}
		if (o.equals(btnQuanLyHoaDon)) {
			new FrmQLHoaDon().setVisible(true);
			setVisible(false);
		}
		if (o.equals(btnQuanLyThongKe)) {
			new FrmQLThongKe().setVisible(true);
			setVisible(false);
		}
		if (o.equals(btnLogOut)) {
			new FrmDangNhap().setVisible(true);
			setVisible(false);
		}
	}

}
