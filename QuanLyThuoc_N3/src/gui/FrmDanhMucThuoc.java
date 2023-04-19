package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import dao.Thuoc_DAO;
import entity.NhanVien;
import entity.Thuoc;

public class FrmDanhMucThuoc extends JFrame implements ActionListener {
	private DefaultTableModel modelDM;
	private JTable tableDM;
	private JTextField txtSL;
	private JButton btnChon;
	private JButton btnThoat;
	private Thuoc_DAO thuoc_dao;

	public FrmDanhMucThuoc() {
		setTitle("DanhMucThuoc");
		setSize(800, 500);
		setResizable(false);
		setLocationRelativeTo(null);

		// khởi tạo kết nối đến database
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		thuoc_dao = new Thuoc_DAO();

		JPanel jpNorth, jpS;

		jpNorth = new JPanel();
		this.add(jpNorth, BorderLayout.NORTH);
		Label lblTitle;
		jpNorth.add(lblTitle = new Label("DANH MỤC THUỐC"));
		lblTitle.setFont(new Font("Time New Roman", Font.BOLD, 20));
		lblTitle.setForeground(Color.BLUE);

		String[] cols = { "STT", "Mã thuốc", "Tên thuốc", "Phân loại", "Số lượng trong kho", "Đơn giá bán" };
		modelDM = new DefaultTableModel(cols, 0);
		tableDM = new JTable(modelDM);
		JScrollPane pane = new JScrollPane(tableDM);
		this.add(pane);

		DocDuLieuDatabaseVaoTable();

		jpS = new JPanel();
		jpS.add(new Label("Nhập số lượng: "));
		jpS.add(txtSL = new JTextField(20));
		jpS.add(btnChon = new JButton("Chọn thuốc"));
		jpS.add(btnThoat = new JButton("Thoát"));
//		btnThoat.setIcon(new ImageIcon("src/img/Users-Exit-icon.png"));
		this.add(jpS, BorderLayout.SOUTH);

		// event
		btnChon.addActionListener(this);
		btnThoat.addActionListener(this);
	}

	// load data to table
	public void DocDuLieuDatabaseVaoTable() {
		modelDM.setRowCount(0);
		ArrayList<Thuoc> list = thuoc_dao.getDanhMucThuoc();
		int stt = 0;
		for (Thuoc t : list) {
			modelDM.addRow(new Object[] { ++stt, t.getMaThuoc(), t.getTenThuoc() });
		}
	}

	public static void main(String[] args) {
		new FrmDanhMucThuoc().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThoat)) {
			setVisible(false);
			new FrmQLHoaDon().setVisible(true);
		} else if (o.equals(btnChon)) {
			int r = tableDM.getSelectedRow();
			String sl = txtSL.getText().trim();
			if (r != -1) {
				if (sl.equals("")) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng");
				} else {
					String ma = modelDM.getValueAt(r, 1).toString();
					ArrayList<Thuoc> dsThuoc = new ArrayList<Thuoc>();
					Thuoc t = new Thuoc(ma);
					dsThuoc.add(t);
					JOptionPane.showMessageDialog(this, "Chọn thành công");
					txtSL.setText("");
					txtSL.requestFocus();
				}
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn thuốc");
			}

		}

	}
}
