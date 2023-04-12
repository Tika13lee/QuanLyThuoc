package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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

		showGUI();
	}

	public void showGUI() {
		JPanel jpNorth, jpWest, jpCenter;

		jpNorth = new JPanel();
		this.add(jpNorth, BorderLayout.NORTH);
		jpNorth.add(lblTitle = new JLabel("QUẢN LÝ HIỆU THUỐC"));
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 40));

		jpWest = new JPanel();
		jpWest.setLayout(new GridLayout(15, 1));
		this.add(jpWest, BorderLayout.WEST);
		jpWest.add(btnQuanLyThuoc = new JButton("QUẢN LÝ THUỐC"));
		jpWest.add(btnQuanLyHoaDon = new JButton("QUẢN LÝ HÓA ĐƠN"));
		jpWest.add(btnQuanLyThongKe = new JButton("QUẢN LÝ THỐNG KÊ"));

		jpCenter = new JPanel();
		this.add(jpCenter);
		ImageIcon bg_ManHinhChinh = new ImageIcon("src/img/welcome.png");
		lblImg = new JLabel(bg_ManHinhChinh);
		jpCenter.add(lblImg);
	}

}
