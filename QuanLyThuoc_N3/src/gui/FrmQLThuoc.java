package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import connect.ConnectDB;
import dao.NhaCungCap_DAO;
import entity.NhaCungCap;

public class FrmQLThuoc extends JFrame {
	private JLabel lblMaThuoc, lblTenThuoc, lblPhanLoai, lblhanSD, lbldonViTinh, lblSoLuong, lblDonGia, lblngaySX,
			lblnhaCC, lblDonViTinh;
	private JTextField txtMaThuoc, txtTenThuoc, txtDonViTinh, txtSoLuong, txtDonGia, txtnhaCC, txtTimKiem;
	private JDateChooser jdcHanSD, jdcNgaySX;
	private JTextField txtHanSD;
	private JComboBox cboPhanLoai, cboNhaCC, cboDonViTinh;
	private DefaultTableModel model;
	private JTable table;
	private JButton btnTimKiem, btnLamMoi, btnThoat, btnThem, btnSua, btnXoa;
	private JLabel lblTimKiem;
	private JLabel lbltitle;
	private JRadioButton radTheoMa, radHsd, radTen;
	private NhaCungCap_DAO nhaCC_dao;

	public FrmQLThuoc() {
		setTitle("quản lý thuốc");
		setSize(900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);

		// khởi tạo kết nối đến CSDL
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		nhaCC_dao = new NhaCungCap_DAO();
		
		showGui();
	}

	public void showGui() {
		JPanel pn = new JPanel();
		pn.setLayout(new BorderLayout());
		pn.setBorder(new EmptyBorder(20, 50, 20, 50));

		// north
		Box bAll = new Box(BoxLayout.Y_AXIS);
		Box b = new Box(BoxLayout.X_AXIS);

		Box bb = new Box(BoxLayout.Y_AXIS);
		Box ba = new Box(BoxLayout.Y_AXIS);
		ba.setBorder(BorderFactory.createTitledBorder("tìm kiếm thông tin:"));
		bb.setBorder(BorderFactory.createTitledBorder("thông tin thuốc"));

		Box b1 = new Box(BoxLayout.X_AXIS);
		Box b2 = new Box(BoxLayout.X_AXIS);
		Box b3 = new Box(BoxLayout.X_AXIS);
		Box b4 = new Box(BoxLayout.X_AXIS);

		lbltitle = new JLabel("QUẢN LÝ THUỐC");
		lbltitle.setFont(new Font("arial", Font.BOLD, 24));
		lbltitle.setForeground(Color.blue);
		lbltitle.setHorizontalAlignment(SwingConstants.CENTER);

		b1.add(lblMaThuoc = new JLabel("mã:"));
		b1.add(txtMaThuoc = new JTextField());
		b1.add(lblTenThuoc = new JLabel("tên thuốc:"));
		b1.add(txtTenThuoc = new JTextField());

		b2.add(lblSoLuong = new JLabel("số lượng:"));
		b2.add(txtSoLuong = new JTextField());
		b2.add(lblDonGia = new JLabel("đơn giá:"));
		b2.add(txtDonGia = new JTextField());

		b3.add(lblngaySX = new JLabel("ngày sản xuất:"));
		b3.add(jdcNgaySX = new JDateChooser());
		jdcNgaySX.setCalendar(Calendar.getInstance());
		b3.add(lblhanSD = new JLabel("hạn sử dụng:"));
//		b3.add(jdcHanSD = new JDateChooser());
		b3.add(txtHanSD = new JTextField());

		cboPhanLoai = new JComboBox<>();

		b4.add(lblnhaCC = new JLabel("nhà cung cấp:"));
		b4.add(cboNhaCC = new JComboBox<>());
		b4.add(Box.createHorizontalStrut(30));
		b4.add(lblPhanLoai = new JLabel("phân loại:"));
		b4.add(Box.createHorizontalStrut(30));
		b4.add(cboPhanLoai);
		b4.add(Box.createHorizontalStrut(30));

		b4.add(lblDonViTinh = new JLabel("Đơn vị tính:"));
		b4.add(cboDonViTinh = new JComboBox<>());

		// load data nha cung cap vao cboNhaCC
		ArrayList<NhaCungCap> listNCC = nhaCC_dao.getAllNhaCungCap();
		for (NhaCungCap p : listNCC) {
			cboNhaCC.addItem(p.getMaNCC());
		}
		
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
//		pnTim.setBorder(BorderFactory.createTitledBorder("chức năng"));
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

		//

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
		JScrollPane scr = new JScrollPane(table);

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
	}

	public static void main(String[] args) {
		new FrmQLThuoc().setVisible(true);
	}
}
