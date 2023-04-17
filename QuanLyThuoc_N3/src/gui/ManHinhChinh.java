//package gui;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.GridLayout;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
//public class ManHinhChinh extends JFrame {
//	private JLabel lblTitle;
//	private JButton btnQuanLyThuoc;
//	private JButton btnQuanLyThongKe;
//	private JButton btnQuanLyHoaDon;
//	private JLabel lblImg;
//
//	public ManHinhChinh() {
//		setTitle("ManHinhChinh");
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setLocationRelativeTo(null);
//		setExtendedState(MAXIMIZED_BOTH);
//		setVisible(true);
//
//		showGUI();
//	}
//
//	public void showGUI() {
//		JPanel jpNorth, jpWest, jpCenter;
//
//		jpNorth = new JPanel();
//		this.add(jpNorth, BorderLayout.NORTH);
//		jpNorth.add(lblTitle = new JLabel("QUẢN LÝ HIỆU THUỐC"));
//		lblTitle.setForeground(Color.BLUE);
//		lblTitle.setFont(new Font("Arial", Font.BOLD, 40));
//
//		jpWest = new JPanel();
//		jpWest.setLayout(new GridLayout(15, 1));
//		this.add(jpWest, BorderLayout.WEST);
//		jpWest.add(btnQuanLyThuoc = new JButton("QUẢN LÝ THUỐC"));
//		jpWest.add(btnQuanLyHoaDon = new JButton("QUẢN LÝ HÓA ĐƠN"));
//		jpWest.add(btnQuanLyThongKe = new JButton("QUẢN LÝ THỐNG KÊ"));
//
//		jpCenter = new JPanel();
//		this.add(jpCenter);
//		ImageIcon bg_ManHinhChinh = new ImageIcon("src/img/welcome.png");
//		lblImg = new JLabel(bg_ManHinhChinh);
//		jpCenter.add(lblImg);
//	}
//
//}
package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ManHinhChinh extends JFrame {
	private JLabel lblTitle;
	private JButton btnQuanLyThuoc;
	private JButton btnQuanLyThongKe;
	private JButton btnQuanLyHoaDon;
	private JLabel lblImg;

	public ManHinhChinh() {
		setTitle("ManHinhChinh");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
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

		btnQuanLyHoaDon = new JButton("QUẢN LÝ HÓA ĐƠN");
		btnQuanLyHoaDon.setFont(new Font("Arial", Font.PLAIN, 16));
		btnQuanLyHoaDon.setBounds(650, 120, 250, 60);
		btnQuanLyHoaDon.setIcon(new ImageIcon("src/img/Order-history-icon.png"));

		btnQuanLyThongKe = new JButton("QUẢN LÝ THỐNG KÊ");
		btnQuanLyThongKe.setFont(new Font("Arial", Font.PLAIN, 16));
		btnQuanLyThongKe.setBounds(1100, 120, 250, 60);
		btnQuanLyThongKe.setIcon(new ImageIcon("src/img/chart-icon.png"));

		lblImg = new JLabel();
		ImageIcon img = new ImageIcon("src/img/bg-main.png");
		lblImg.setIcon(img);
		lblImg.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

		this.add(lblTitle);
		this.add(btnQuanLyThuoc);
		this.add(btnQuanLyHoaDon);
		this.add(btnQuanLyThongKe);
		this.add(lblImg);
	}

}



