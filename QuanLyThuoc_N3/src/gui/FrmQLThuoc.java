package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//import java.sql.Date;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import connect.ConnectDB;
import dao.NhaCungCap_DAO;
import dao.Thuoc_DAO;
import entity.NhaCungCap;
import entity.Thuoc;

public class FrmQLThuoc extends JFrame implements ActionListener, MouseListener {
	private JLabel lblMaThuoc, lblTenThuoc, lblPhanLoai, lblhanSD, lbldonViTinh, lblSoLuong, lblDonGia, lblngaySX,
			lblnhaCC, lblDonViTinh;
	private JTextField txtMaThuoc, txtTenThuoc, txtDonViTinh, txtSoLuong, txtDonGia, txtnhaCC, txtTimKiem, txtngaySX;
//	private JDateChooser jdcNgaySX;
	private JTextField txtNgayHH;
	private JComboBox cboPhanLoai, cboNhaCC, cboDonViTinh;

	private DefaultTableModel model;
	private JTable table;

	private JButton btnTimKiem, btnLamMoi, btnThoat, btnThem, btnSua, btnXoa;
	private JLabel lblTimKiem;
	private JLabel lbltitle;
	private JRadioButton radTheoMa, radHsd, radTen;
	private Thuoc_DAO thuoc_dao;
	private NhaCungCap_DAO ncc_dao;

	public FrmQLThuoc() {
		setTitle("quản lý thuốc");
		setSize(900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);

		showGui();
	}

	public void showGui() {

		// khởi tạo kết nối csdl
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		thuoc_dao = new Thuoc_DAO();
		ncc_dao = new NhaCungCap_DAO();

		// set kích thước của panel tổng
		JPanel pn = new JPanel();
		pn.setLayout(new BorderLayout());
		pn.setBorder(new EmptyBorder(20, 50, 20, 50));

		// north
		Box bAll = new Box(BoxLayout.Y_AXIS);
		Box b = new Box(BoxLayout.X_AXIS);

		// box bb bên trái
		Box bb = new Box(BoxLayout.Y_AXIS);
		// box ba bên phải (chức năng tìm kiếm)
		Box ba = new Box(BoxLayout.Y_AXIS);
		ba.setBorder(BorderFactory.createTitledBorder("tìm kiếm thông tin:"));
		bb.setBorder(BorderFactory.createTitledBorder("Thông tin thuốc"));

		// tạo 4 box con bb
		Box b1 = new Box(BoxLayout.X_AXIS);
		Box b2 = new Box(BoxLayout.X_AXIS);
		Box b3 = new Box(BoxLayout.X_AXIS);
		Box b4 = new Box(BoxLayout.X_AXIS);

		lbltitle = new JLabel("QUẢN LÝ THUỐC");
		lbltitle.setFont(new Font("arial", Font.BOLD, 24));
		lbltitle.setForeground(Color.blue);
		lbltitle.setHorizontalAlignment(SwingConstants.CENTER);

		b1.add(lblMaThuoc = new JLabel("Mã thuốc:"));
		b1.add(txtMaThuoc = new JTextField());
//		txtMaThuoc.setEditable(false); // set chỉ được đọc
		b1.add(lblTenThuoc = new JLabel("Tên thuốc:"));
		b1.add(txtTenThuoc = new JTextField());

		b2.add(lblSoLuong = new JLabel("Số lượng:"));
		b2.add(txtSoLuong = new JTextField());
		b2.add(lblDonGia = new JLabel("Đơn giá:"));
		b2.add(txtDonGia = new JTextField());

		b3.add(lblngaySX = new JLabel("Ngày sản xuất:"));
		b3.add(txtngaySX = new JTextField());
//		jdcNgaySX.setCalendar(Calendar.getInstance());
		b3.add(lblhanSD = new JLabel("Ngày hết hạn:"));
		b3.add(txtNgayHH = new JTextField());

		cboPhanLoai = new JComboBox<>();

		b4.add(lblnhaCC = new JLabel("Nhà cung cấp:"));
		b4.add(cboNhaCC = new JComboBox<>());
		b4.add(Box.createHorizontalStrut(30));
		b4.add(lblPhanLoai = new JLabel("Phân loại:"));
		b4.add(Box.createHorizontalStrut(30));
		b4.add(cboPhanLoai);
		b4.add(Box.createHorizontalStrut(30));

		b4.add(lblDonViTinh = new JLabel("Đơn vị tính:"));
		b4.add(cboDonViTinh = new JComboBox<>());

		// thêm và design kích thước các component
		b.add(Box.createVerticalStrut(15));
		bb.add(b1);
		bb.add(Box.createVerticalStrut(15));
		bb.add(b2);
		bb.add(Box.createVerticalStrut(15));
		bb.add(b3);
		bb.add(Box.createVerticalStrut(15));
		bb.add(b4);
		bb.add(Box.createVerticalStrut(15));

		bb.add(Box.createVerticalStrut(15));
		b.add(bb);
		JPanel pnTim = new JPanel(); // add Tim vao pn
		JPanel pnLuaChon = new JPanel(); // add rad vao pn;
		pnTim.add(lblTimKiem = new JLabel("nhập thông tin tìm kiếm:"));
		pnTim.add(txtTimKiem = new JTextField(20));
		pnTim.add(btnTimKiem = new JButton("Tim kiếm"));

		pnLuaChon.add(radTen = new JRadioButton("Tìm theo tên"));
		pnLuaChon.add(radTheoMa = new JRadioButton("Tìm theo mã"));
		pnLuaChon.add(radHsd = new JRadioButton("tìm theo hạn sử dụng"));
		ba.add(pnTim);
		ba.add(pnLuaChon);

		b.add(Box.createHorizontalStrut(50));
		b.add(ba);
		bAll.add(lbltitle);
		bAll.add(b);
		bAll.add(Box.createVerticalStrut(50));

		// design kích thước
		lblMaThuoc.setPreferredSize(new Dimension(100, 20));

		lblSoLuong.setPreferredSize(new Dimension(100, 20));
		lblngaySX.setPreferredSize(new Dimension(100, 20));
		lblnhaCC.setPreferredSize(new Dimension(100, 20));

		lblTenThuoc.setPreferredSize(new Dimension(100, 20));
		lblDonGia.setPreferredSize(new Dimension(100, 20));
		lblhanSD.setPreferredSize(new Dimension(100, 20));

		// center
		String[] cols = { "STT", "Mã thuốc", "Tên thuốc", "Số lượng", "Đơn giá nhập", "Ngày sản xuất", "Hạn sử dụng",
				"Nhà cung cấp", "Phân loại", "Đơn vị tính" };
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		JScrollPane scr = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scr.setBorder(BorderFactory.createTitledBorder("Danh sách thuốc"));
		// gọi hàm đổ dl vào bảng
		DocDuLieuDBVaoTable();

		//gọi hàm đổ dl vào cbo
		ArrayList<Thuoc> listThuoc = thuoc_dao.getAllThuoc();
		for (Thuoc t : listThuoc) {
			cboNhaCC.addItem(t.getNhaCC().getMaNCC());
			cboPhanLoai.addItem(t.getPhanLoai());
			cboDonViTinh.addItem(t.getDonViTinh());
		}

		// south
		JPanel pnSouth = new JPanel();
		pnSouth.add(btnThem = new JButton("Thêm thuốc"));
		pnSouth.add(btnXoa = new JButton("Xóa thuốc"));
		pnSouth.add(btnSua = new JButton("Cập nhật"));
		pnSouth.add(btnLamMoi = new JButton("lam moi"));
		pnSouth.add(btnThoat = new JButton("thoat"));

		pn.add(bAll, BorderLayout.NORTH);
		pn.add(scr, BorderLayout.CENTER);
		pn.add(pnSouth, BorderLayout.SOUTH);
		this.add(pn);

		// đăng kí sự kiện
		table.addMouseListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnThoat.addActionListener(this);
	}

	/*
	 * hàm DocDuLieuDBVaoTable() đổ dữ liều từ sql vào table
	 */
	public void DocDuLieuDBVaoTable() {
		int stt = 0;
		thuoc_dao = new Thuoc_DAO();
		List<Thuoc> list = thuoc_dao.getAllThuoc();
		for (Thuoc t : list) {
			model.addRow(new Object[] { ++stt, t.getMaThuoc(), t.getTenThuoc(), t.getSoLuong(), t.getDonGia(),
					t.getNgaySX(), t.getNgayHetHan(), t.getNhaCC().getMaNCC(), t.getPhanLoai(), t.getDonViTinh() });
		}
	}

	public static void main(String[] args) {
		new FrmQLThuoc().setVisible(true);
	}

	/*
	 * sử lý sự kiện chuột
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMaThuoc.setText(model.getValueAt(row, 1).toString());
		txtTenThuoc.setText(model.getValueAt(row, 2).toString());
		txtSoLuong.setText(model.getValueAt(row, 3).toString());
		txtDonGia.setText(model.getValueAt(row, 4).toString());
		txtNgayHH.setText(model.getValueAt(row, 6).toString());
		cboNhaCC.setSelectedItem(model.getValueAt(row, 7).toString());
		txtngaySX.setText(model.getValueAt(row, 5).toString());
		cboPhanLoai.setSelectedItem(model.getValueAt(row, 8).toString());
		cboDonViTinh.setSelectedItem(model.getValueAt(row, 9).toString());

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			String ma = txtMaThuoc.getText();
			String tenthuoc = txtTenThuoc.getText();
			int soluong = Integer.parseInt(txtSoLuong.getText());
			double dongianhap = Double.parseDouble(txtDonGia.getText());

			String nsxString = txtngaySX.getText();
			String nhhString = txtNgayHH.getText();
			java.sql.Date datensx = java.sql.Date.valueOf(nsxString);
			java.sql.Date datenhh = java.sql.Date.valueOf(nhhString);

			String nhacc = cboNhaCC.getSelectedItem().toString();
			String phanloai = cboPhanLoai.getSelectedItem().toString();
			String doviTinh = cboDonViTinh.getSelectedItem().toString();
			NhaCungCap ncc = new NhaCungCap(nhacc);
			Thuoc t = new Thuoc(ma, tenthuoc, phanloai, datenhh, doviTinh, soluong, dongianhap, datensx, ncc);
			try {
				if (thuoc_dao.createThuoc(t)) {
					clearTextField();
					clearDataOnTable();
					DocDuLieuDBVaoTable();
					JOptionPane.showMessageDialog(this, "thêm thành công !!");
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "trung id");
			}

		}

		if (o.equals(btnLamMoi)) {
			clearTextField();
		}

		if (o.equals(btnSua)) {
			replaceID();
		}

		if (o.equals(btnXoa)) {
			int row = table.getSelectedRow();

			if (row < 0) {
				JOptionPane.showMessageDialog(this, "bạn chưa chọn dòng để xóa");
				return;
			}
			Thuoc t = genarateOBJThuoc();
			if (thuoc_dao.delete(t)) {
				clearDataOnTable();
				DocDuLieuDBVaoTable();

				String ma = model.getValueAt(row, 1).toString();
				JOptionPane.showMessageDialog(this, "xóa thành công thuốc có mã:" + ma);
			}
		}

		if (o.equals(btnThoat)) {
			setVisible(false);
			new FrmManHinhChinh().setVisible(true);
		}

	}

	/*
	 * có chức năng lấy dữ liệu từ field chuyển thành obj Thuốc
	 */
	private Thuoc genarateOBJThuoc() {
		Thuoc temp;
		String ma = txtMaThuoc.getText();
		String tenthuoc = txtTenThuoc.getText();
		int soluong = Integer.parseInt(txtSoLuong.getText());
		double dongianhap = Double.parseDouble(txtDonGia.getText());

		String nsxString = txtngaySX.getText();
		String nhhString = txtNgayHH.getText();
		java.sql.Date datensx = java.sql.Date.valueOf(nsxString);
		java.sql.Date datenhh = java.sql.Date.valueOf(nhhString);

		String nhacc = cboNhaCC.getSelectedItem().toString();
		String phanloai = cboPhanLoai.getSelectedItem().toString();
		String doviTinh = cboDonViTinh.getSelectedItem().toString();
		NhaCungCap ncc = new NhaCungCap(nhacc);
		try {
			temp = new Thuoc(ma, tenthuoc, phanloai, datenhh, doviTinh, soluong, dongianhap, datensx, ncc);
			return temp;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}

	}

	/*
	 * dùng sự kiện sửa
	 */
	private void replaceID() {
		int pos = table.getSelectedRow();
		if (pos < 0) {
			JOptionPane.showMessageDialog(this, "vui lòng chọn dòng cần sửa");
			return;
		}

		Thuoc t = genarateOBJThuoc();

		try {
			if (thuoc_dao.update(t)) {
				clearDataOnTable();
				DocDuLieuDBVaoTable();
				JOptionPane.showMessageDialog(this, "sửa thành công");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return;
		}
	}

	/*
	 * xóa hết data trên table
	 */
	private void clearDataOnTable() {
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
	}

	/*
	 * xóa rỗng textField
	 */
	private void clearTextField() {
		txtMaThuoc.setText("");
		txtTenThuoc.setText("");
		txtSoLuong.setText("");
		txtDonGia.setText("");
		txtngaySX.setText("");
		txtNgayHH.setText("");
		cboNhaCC.setSelectedIndex(1);
		cboPhanLoai.setSelectedIndex(1);
		cboDonViTinh.setSelectedIndex(1);
		txtMaThuoc.requestFocus();
	}

}
