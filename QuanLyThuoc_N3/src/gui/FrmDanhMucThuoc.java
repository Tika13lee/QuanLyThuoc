package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import connect.ConnectDB;
import dao.Thuoc_DAO;
import entity.Thuoc;

public class FrmDanhMucThuoc extends JFrame implements ActionListener {
	private DefaultTableModel modelDM;
	private JTable tableDM;
	private JTextField txtSL;
	private JButton btnChon;
	private JButton btnThoat;
	private JButton btnTim;
	private JTextField txtTim;
//	private ArrayList<Thuoc> dsThuoc;
	private TableRowSorter<TableModel> sorter;
	private JComboBox cboMa;

	private Thuoc_DAO thuoc_dao;
	private JButton btnXem;
	private ArrayList<Thuoc> dsThuoc;

	public FrmDanhMucThuoc() {
		setTitle("DanhMucThuoc");
		setSize(1000, 500);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// khởi tạo kết nối đến database
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		thuoc_dao = new Thuoc_DAO();

		JPanel jpNorth;
		jpNorth = new JPanel();
		this.add(jpNorth, BorderLayout.NORTH);
		Label lblTitle;
		jpNorth.add(lblTitle = new Label("DANH MỤC THUỐC"));
		lblTitle.setFont(new Font("Time New Roman", Font.BOLD, 20));
		lblTitle.setForeground(Color.BLUE);

		String[] cols = { "STT", "Mã thuốc", "Tên thuốc", "Số lượng", "Đơn giá nhập", "Ngày sản xuất", "Ngày hết hạn",
				"Nhà cung cấp", "Phân loại", "Đơn vị tính" };
		modelDM = new DefaultTableModel(cols, 0);
		tableDM = new JTable(modelDM);
		JScrollPane pane = new JScrollPane(tableDM);
		this.add(pane);

		dsThuoc = thuoc_dao.getAllThuoc();
		LoadDatabaseVaoTable(dsThuoc);

		sorter = new TableRowSorter<TableModel>(tableDM.getModel());
		tableDM.setRowSorter(sorter);

		// split
		JSplitPane split;
		split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		this.add(split, BorderLayout.SOUTH);
		split.setResizeWeight(0.5);

		JPanel jpSearch = new JPanel();
		jpSearch.add(new Label("Tìm thuốc theo mã:"));
//		jpSearch.add(txtTim = new JTextField(20));

		jpSearch.add(cboMa = new JComboBox<>());
//		ArrayList<Thuoc> dsThuoc = thuoc_dao.getAllThuoc();
		for (Thuoc p : dsThuoc) {
			cboMa.addItem(p.getMaThuoc());
		}

		jpSearch.add(btnTim = new JButton("Tìm"));
		jpSearch.add(btnXem = new JButton("Xem chi tiết"));
		split.add(jpSearch);

		JPanel jpChon = new JPanel();
		jpChon.add(new Label("Nhập số lượng: "));
		jpChon.add(txtSL = new JTextField(20));
		jpChon.add(btnChon = new JButton("Chọn thuốc"));
		jpChon.add(btnThoat = new JButton("Thoát"));
		split.add(jpChon);

		// event
		btnTim.addActionListener(this);
		btnXem.addActionListener(this);
		btnChon.addActionListener(this);
		btnThoat.addActionListener(this);
	}

	// load data to table
	public void LoadDatabaseVaoTable(ArrayList<Thuoc> ds) {
		modelDM.setRowCount(0);
//		ArrayList<Thuoc> list = thuoc_dao.getAllThuoc();
		int stt = 0;
		for (Thuoc t : ds) {
			modelDM.addRow(new Object[] { ++stt, t.getMaThuoc(), t.getTenThuoc(), t.getSoLuong(), t.getDonGia(),
					t.getNgaySX(), t.getNgayHetHan(), t.getNhaCC().getMaNCC(), t.getPhanLoai(), t.getDonViTinh() });
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
					dsThuoc = new ArrayList<Thuoc>();
					Thuoc t = new Thuoc(ma);
					dsThuoc.add(t);
					JOptionPane.showMessageDialog(this, "Chọn thành công");
					txtSL.setText("");
					txtSL.requestFocus();
				}
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn thuốc");
			}
		} else if (o.equals(btnTim)) {
			String ma = cboMa.getSelectedObjects().toString();
			ArrayList<Thuoc> ds = thuoc_dao.getAllThuocTheoMa(ma);
			modelDM = (DefaultTableModel) tableDM.getModel();
			modelDM.getDataVector().removeAllElements();
			LoadDatabaseVaoTable(ds);

		} else if (o.equals(btnXem)) {
			new FrmQLThuoc().setVisible(true);
		}

	}
}
