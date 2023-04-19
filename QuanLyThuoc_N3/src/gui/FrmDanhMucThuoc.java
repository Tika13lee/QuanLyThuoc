package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FrmDanhMucThuoc extends JFrame {
	private DefaultTableModel modelNV;
	private JTable tableNV;
	private JTextField txtSL;
	private JButton btnChon;
	private JButton btnThoat;

	public FrmDanhMucThuoc() {
		setTitle("DanhMucThuoc");
		setSize(800, 500);
		setLocationRelativeTo(null);

		JPanel jpNorth, jpS;

		jpNorth = new JPanel();
		this.add(jpNorth, BorderLayout.NORTH);
		Label lblTitle;
		jpNorth.add(lblTitle = new Label("DANH MỤC THUỐC"));
		lblTitle.setFont(new Font("Time New Roman", Font.BOLD, 20));
		lblTitle.setForeground(Color.BLUE);

		String[] cols = { "STT", "Mã thuốc", "Tên thuốc", "Phân loại", "Hạn sử dụng", "Đơn giá bán" };
		modelNV = new DefaultTableModel(cols, 0);
		tableNV = new JTable(modelNV);
		JScrollPane pane = new JScrollPane(tableNV);
		this.add(pane);

		jpS = new JPanel();
		jpS.add(new Label("Nhập số lượng: "));
		jpS.add(txtSL = new JTextField(20));
		jpS.add(btnChon = new JButton("Chọn thuốc"));
		jpS.add(btnThoat = new JButton("Thoát"));
//		btnThoat.setIcon(new ImageIcon("src/img/Users-Exit-icon.png"));
		this.add(jpS, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		new FrmDanhMucThuoc().setVisible(true);
	}
}
