package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import connect.ConnectDB;
import dao.ChiTietHoaDon_DAO;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.NhaCungCap_DAO;
import dao.NhanVien_DAO;
import dao.TaiKhoan_DAO;
import dao.Thuoc_DAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.TaiKhoan;
import entity.Thuoc;

public class FrmQLHoaDon extends JFrame implements ActionListener, DocumentListener {
	private static final long serialVersionUID = 1L;
	private static final double VAT = 0.01;
	private int stt = 0;
	private double tongThanhTien = 0;
	private JLabel lblMaHD, lblNgayLap, lblSDT, lblHoKH, lblTenKH, lblGioiTinh, lblDiaChi, lblNgaySinh, lblMaKH;
	private JLabel lblMaNV, lblHoTenNV, lblSDTNV, lblDiaChiNV; // nhan vien
	private JTextField txtMaNV, txtHoTenNV, txtSDTNV, txtDiaChiNV;// nhan vien
	private JTextField txtMaHD, txtSDT, txtHoKH, txtTenKH, txtDiaChi, txtMaKH;// KH
	private JDateChooser dcrNgayLap;
	private JDateChooser dcrNgaySinh;
	private JRadioButton radNam;
	private DefaultTableModel model;
	private JTable table;
	private JButton btnThemMoi, btnThanhToan, btnThemThuoc, btnThoat;
	private JComboBox<String> cboAddThuoc;
	// thanh toan
	private JLabel lblTongThanhToan, lblPhuongThucThanhToan, lblTienKhachDua, lblTienTraLai;
	private JTextField txtTongThanhToan, txtTienKhachDua, txtTienTraLai;
	private JComboBox<String> cboPhuongThucThanhToan;
	// Goi DAO
	private Thuoc_DAO thuoc_dao = new Thuoc_DAO();
	private HoaDon_DAO hd_dao = new HoaDon_DAO();
	private KhachHang_DAO kh_dao = new KhachHang_DAO();
	private ChiTietHoaDon_DAO cthd_dao = new ChiTietHoaDon_DAO();
	private TaiKhoan_DAO tk_dao;
	private NhanVien_DAO nv_dao;
	private NhaCungCap_DAO ncc_dao;

	private JLabel lblLocTheoTen, lblPhanLoai, lblNCC;
	private JTextField txtLocTheoTen;
	private JComboBox<String> cboPhanLoai, cboNCC;
	private DefaultTableModel modelThuoc;
	private JTable tableThuoc;

	private FrmManHinhChinh mhc;
	private JButton btnTaiLai;

	public FrmQLHoaDon(FrmManHinhChinh mhc, String user) {
		this.mhc = mhc;

		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		nv_dao = new NhanVien_DAO();
		ncc_dao = new NhaCungCap_DAO();

		// Giao dien
		JPanel pBorder = new JPanel();
		pBorder.setLayout(new BorderLayout());
		setTitle("LapHoaDon");
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		// north
		JPanel pNorth = new JPanel();
		JLabel lblTitle = new JLabel("HÓA ĐƠN");
		lblTitle.setForeground(Color.BLUE);
		Font font = new Font("Tahoma", Font.BOLD, 24);
		lblTitle.setFont(font);
		pNorth.add(lblTitle);
		pNorth.setBorder(new EmptyBorder(0, 0, 0, 0));
		pNorth.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

		pBorder.add(pNorth, BorderLayout.NORTH);

		JPanel pCenter = new JPanel();
		pCenter.setLayout(new BoxLayout(pCenter, BoxLayout.Y_AXIS));
		JPanel pText = new JPanel();
		pText.setLayout(new BoxLayout(pText, BoxLayout.Y_AXIS));

		Box b1 = Box.createHorizontalBox();
		b1.add(Box.createHorizontalStrut(20));
		b1.add(lblMaHD = new JLabel("Mã hóa đơn:"));
		b1.add(txtMaHD = new JTextField());
		txtMaHD.setEditable(false); // set chỉ được đọc
		b1.add(Box.createHorizontalStrut(50));

		b1.add(lblNgayLap = new JLabel("Ngày lập hóa đơn:"));
		b1.add(dcrNgayLap = new JDateChooser());
		dcrNgayLap.setLocale(new Locale("vi", "VN"));
		dcrNgayLap.setDateFormatString("dd/MM/yyyy");
		dcrNgayLap.setDate(new Date(System.currentTimeMillis()));
		dcrNgayLap.setEnabled(false); // chi duoc doc
		b1.add(Box.createHorizontalStrut(50));
		pText.add(Box.createVerticalStrut(20));
		b1.add(lblMaKH = new JLabel("Mã khách hàng:"));
		b1.add(txtMaKH = new JTextField());
		txtMaKH.setEditable(false); // set chỉ được đọc
		b1.add(Box.createHorizontalStrut(20));
		pText.add(b1);

		Box b2 = Box.createHorizontalBox();
		b2.add(Box.createHorizontalStrut(20));
		b2.add(lblHoKH = new JLabel("Họ KH:"));
		b2.add(txtHoKH = new JTextField());
		b2.add(Box.createHorizontalStrut(50));
		b2.add(lblTenKH = new JLabel("Tên KH:"));
		b2.add(txtTenKH = new JTextField());
		b2.add(Box.createHorizontalStrut(150));
		b2.add(lblGioiTinh = new JLabel("Giới tính:"));
		radNam = new JRadioButton("Nam");
		b2.add(radNam);
		b2.add(Box.createHorizontalStrut(20));
		pText.add(Box.createVerticalStrut(20));
		pText.add(b2);

		txtHoKH.setPreferredSize(txtMaHD.getPreferredSize());
		txtTenKH.setPreferredSize(dcrNgayLap.getPreferredSize());

		Box b3 = Box.createHorizontalBox();
		b3.add(Box.createHorizontalStrut(20));
		b3.add(lblSDT = new JLabel("Số điện thoại KH:"));
		b3.add(txtSDT = new JTextField());
		b3.add(Box.createHorizontalStrut(50));
		b3.add(lblNgaySinh = new JLabel("Ngày sinh KH:"));
		b3.add(dcrNgaySinh = new JDateChooser());
		dcrNgaySinh.setLocale(new Locale("vi", "VN"));
		dcrNgaySinh.setDateFormatString("dd/MM/yyyy");
		b3.add(Box.createHorizontalStrut(180));
//		b3.add(cboAddThuoc = new JComboBox<String>());
//		cboAddThuoc.setPreferredSize(new Dimension(200, 15));
		b3.add(Box.createHorizontalStrut(20));
		b3.add(btnThemThuoc = new JButton("Chọn thuốc"));
		b3.add(Box.createHorizontalStrut(20));

		pText.add(Box.createVerticalStrut(20));
		pText.add(b3);

		Box b4 = Box.createHorizontalBox();
		b4.add(Box.createHorizontalStrut(20));
		b4.add(lblDiaChi = new JLabel("Địa chỉ:"));
		b4.add(txtDiaChi = new JTextField(30));
		b4.add(Box.createHorizontalStrut(10));
		pText.add(Box.createVerticalStrut(20));
		pText.add(b4);
		pText.add(Box.createVerticalStrut(20));

		lblMaHD.setPreferredSize(new Dimension(110, 20));
		lblNgayLap.setPreferredSize(new Dimension(110, 20));
		lblMaKH.setPreferredSize(new Dimension(110, 20));

		lblHoKH.setPreferredSize(lblMaHD.getPreferredSize());
		lblTenKH.setPreferredSize(lblNgayLap.getPreferredSize());
		lblGioiTinh.setPreferredSize(lblMaKH.getPreferredSize());

		lblSDT.setPreferredSize(lblMaHD.getPreferredSize());
		lblNgaySinh.setPreferredSize(lblNgayLap.getPreferredSize());
		btnThemThuoc.setPreferredSize(lblMaKH.getPreferredSize());

		lblDiaChi.setPreferredSize(lblMaHD.getPreferredSize());

		pText.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pCenter.add(pText);

		String[] tb = new String[] { "STT", "Mã thuốc", "Tên thuốc", "Đơn vị tính", "Đơn giá bán", "Số lượng", "%VAT",
				"Thành tiền" };
		model = new DefaultTableModel(tb, 0);
		table = new JTable(model);
		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setPreferredSize(new Dimension(0, 350));
		pCenter.add(Box.createVerticalStrut(20));
		pCenter.add(sp);
		pCenter.setBorder(new EmptyBorder(10, 0, 15, 0));

		pBorder.add(pCenter, BorderLayout.CENTER);

		// eath
		JPanel jpEath = new JPanel();
		jpEath.setBorder(new EmptyBorder(10, 20, 15, 10));
		jpEath.setLayout(new BoxLayout(jpEath, BoxLayout.Y_AXIS));
		pBorder.add(jpEath, BorderLayout.EAST);

		Box be1, be2, be3;

		be1 = Box.createHorizontalBox();
		be1.add(Box.createHorizontalStrut(10));
		be1.add(lblLocTheoTen = new JLabel("Lọc theo tên thuốc"));
		be1.add(Box.createHorizontalStrut(10));
		be1.add(txtLocTheoTen = new JTextField());
		be1.add(Box.createHorizontalStrut(10));

		be2 = Box.createHorizontalBox();
		be2.add(Box.createHorizontalStrut(10));
		be2.add(lblPhanLoai = new JLabel("Phân loại"));
		be2.add(Box.createHorizontalStrut(10));
		be2.add(cboPhanLoai = new JComboBox<String>());
		cboPhanLoai.addItem("Kê đơn");
		cboPhanLoai.addItem("Không kê đơn");
		be2.add(Box.createHorizontalStrut(20));
		be2.add(lblNCC = new JLabel("Mã nhà cung cấp"));
		be2.add(Box.createHorizontalStrut(10));
		be2.add(cboNCC = new JComboBox<String>());
		be2.add(Box.createHorizontalStrut(10));

		be3 = Box.createHorizontalBox();
		be3.add(btnTaiLai = new JButton("TẢI LẠI"));
		btnTaiLai.setIcon(new ImageIcon("src/img/taiLai.png"));

		// load data vào cboNCC
		ArrayList<NhaCungCap> dsNCC = ncc_dao.getAllNhaCungCap();
		for (NhaCungCap ncc : dsNCC) {
			cboNCC.addItem(ncc.getMaNCC());
		}

		String[] col = { "STT", "Mã thuốc", "Tên thuốc", "Số lượng", "Phân loại", "Nhà cung cấp" };
		modelThuoc = new DefaultTableModel(col, 0);
		tableThuoc = new JTable(modelThuoc);
		JScrollPane spThuoc = new JScrollPane(tableThuoc, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		jpEath.add(Box.createVerticalStrut(10));
		jpEath.add(be2);
		jpEath.add(Box.createVerticalStrut(20));
		jpEath.add(be1);
		jpEath.add(Box.createVerticalStrut(40));
		jpEath.add(spThuoc);
		jpEath.add(Box.createVerticalStrut(20));
		jpEath.add(be3);

		ArrayList<Thuoc> dsT = thuoc_dao.getAllThuoc();
		loadThuoc(dsT);

		// south
		JPanel pSouth = new JPanel();
		// pSouth.setLayout(BorderLayout);
		// pSouth.setSize(1000,500);
		JPanel pWest = new JPanel();
		pWest.setLayout(new BoxLayout(pWest, BoxLayout.Y_AXIS));
		Box b = Box.createVerticalBox();
		Box b5 = Box.createHorizontalBox();
		b5.add(Box.createHorizontalStrut(15));
		b5.add(lblMaNV = new JLabel("Mã nhân viên:"));
		b5.add(txtMaNV = new JTextField(15));

		b5.add(Box.createHorizontalStrut(15));
		// pWest.add(b5);

		Box b6 = Box.createHorizontalBox();
		b6.add(Box.createHorizontalStrut(15));
		b6.add(lblHoTenNV = new JLabel("Họ tên nhân viên:"));
		b6.add(txtHoTenNV = new JTextField(15));
		b6.add(Box.createHorizontalStrut(15));
		// pWest.add(b6);

		Box b7 = Box.createHorizontalBox();
		b7.add(Box.createHorizontalStrut(15));
		b7.add(lblSDTNV = new JLabel("Số Điện thoại:"));
		b7.add(txtSDTNV = new JTextField(15));
		b7.add(Box.createHorizontalStrut(15));
		// pWest.add(b7);

		Box b8 = Box.createHorizontalBox();
		b8.add(Box.createHorizontalStrut(15));
		b8.add(lblDiaChiNV = new JLabel("Địa chỉ:"));
		b8.add(txtDiaChiNV = new JTextField(30));
		b8.add(Box.createHorizontalStrut(15));

		txtMaNV.setEditable(false);
		txtHoTenNV.setEditable(false);
		txtSDTNV.setEditable(false);
		txtDiaChiNV.setEditable(false);

		// lấy thông tin nhân viên đã đăng nhập đưa vào JTextField
		tk_dao = new TaiKhoan_DAO();
		nv_dao = new NhanVien_DAO();
		ArrayList<TaiKhoan> dsTK = tk_dao.getAllTaiKhoan();
		for (TaiKhoan tk : dsTK) {
			if (tk.getTenTK().equals(user)) {
				String ma = tk.getMaTK();
				ArrayList<NhanVien> dsNV = nv_dao.getAllNVTheoMaTK(ma);
				for (NhanVien nv : dsNV) {
					txtMaNV.setText(nv.getMaNV());
					txtHoTenNV.setText(nv.getHoNV() + " " + nv.getTenNV());
					txtSDTNV.setText(nv.getSoDT());
					txtDiaChiNV.setText(nv.getDiaChi());
				}
			}
		}

		// pWest.add(b8);
		lblMaNV.setPreferredSize(new Dimension(150, 20));
		lblHoTenNV.setPreferredSize(lblMaNV.getPreferredSize());
		lblSDTNV.setPreferredSize(lblMaNV.getPreferredSize());
		lblDiaChiNV.setPreferredSize(lblMaNV.getPreferredSize());

		b.add(Box.createVerticalStrut(15));
		b.add(Box.createHorizontalStrut(15));
		b.add(b5);
		b.add(Box.createVerticalStrut(15));
		b.add(b6);
		b.add(Box.createVerticalStrut(15));
		b.add(b7);
		b.add(Box.createVerticalStrut(15));
		b.add(b8);
		b.add(Box.createVerticalStrut(15));
		pWest.add(b);
		pWest.setBorder(new EmptyBorder(20, 20, 20, 20));
		pSouth.add(pWest, BorderLayout.WEST);
		// pSouth.add(Box.createHorizontalStrut(200));
		Border borderSouth = BorderFactory.createLineBorder(Color.BLUE, font.BOLD);
		TitledBorder titledBorder = new TitledBorder(borderSouth, "Thông tin nhân viên");
		titledBorder.setTitleColor(Color.BLUE);
		pWest.setBorder(titledBorder);

		// thanh toan
		JPanel pThanhToan = new JPanel();
		pThanhToan.setLayout(new BoxLayout(pThanhToan, BoxLayout.Y_AXIS));
		Box bv = Box.createVerticalBox();
		Box bh1 = Box.createHorizontalBox();
		bh1.add(Box.createHorizontalStrut(20));
		bh1.add(lblTongThanhToan = new JLabel("Tổng tiền:"));
		bh1.add(txtTongThanhToan = new JTextField(15));
		txtTongThanhToan.setEditable(false); // chi duoc doc
		bh1.add(Box.createHorizontalStrut(20));
		Box bh2 = Box.createHorizontalBox();
		bh2.add(Box.createHorizontalStrut(20));
		bh2.add(lblPhuongThucThanhToan = new JLabel("Phương thức thanh toán:"));
		cboPhuongThucThanhToan = new JComboBox<String>(new String[] { "Tiền mặt", "Thẻ tín dụng" });
		bh2.add(cboPhuongThucThanhToan);
		bh2.add(Box.createHorizontalStrut(20));
		Box bh3 = Box.createHorizontalBox();
		bh3.add(Box.createHorizontalStrut(20));
		bh3.add(lblTienKhachDua = new JLabel("Tiền khách đưa:"));
		bh3.add(txtTienKhachDua = new JTextField(15));
		bh3.add(Box.createHorizontalStrut(20));
		Box bh4 = Box.createHorizontalBox();
		bh4.add(Box.createHorizontalStrut(20));
		bh4.add(lblTienTraLai = new JLabel("Tiền trả lại:"));
		bh4.add(txtTienTraLai = new JTextField(15));
		txtTienTraLai.setEditable(false);
		bh4.add(Box.createHorizontalStrut(20));
		bv.add(Box.createVerticalStrut(15));
		bv.add(bh1);
		bv.add(Box.createVerticalStrut(15));
		bv.add(bh2);
		bv.add(Box.createVerticalStrut(15));
		bv.add(bh3);
		bv.add(Box.createVerticalStrut(15));
		bv.add(bh4);
		bv.add(Box.createVerticalStrut(15));
		lblTongThanhToan.setPreferredSize(new Dimension(200, 20));
		lblPhuongThucThanhToan.setPreferredSize(lblTongThanhToan.getPreferredSize());
		lblTienKhachDua.setPreferredSize(lblTongThanhToan.getPreferredSize());
		lblTienTraLai.setPreferredSize(lblTongThanhToan.getPreferredSize());
		pThanhToan.add(bv);

		Border borderTT = BorderFactory.createLineBorder(Color.BLUE, font.BOLD);
		TitledBorder titledBorderTT = new TitledBorder(borderTT, "Thanh toán");
		titledBorderTT.setTitleColor(Color.BLUE);
		pThanhToan.setBorder(titledBorderTT);
		pSouth.add(Box.createHorizontalStrut(75));
		pSouth.add(pThanhToan, BorderLayout.CENTER);
		pSouth.add(Box.createHorizontalStrut(75));
		pSouth.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JPanel pChucNang = new JPanel();
		pChucNang.setLayout(new BoxLayout(pChucNang, BoxLayout.Y_AXIS));
		Box bp = Box.createVerticalBox();
		Box bp1 = Box.createHorizontalBox();
		bp1.add(Box.createHorizontalStrut(40));
		bp1.add(btnThemMoi = new JButton("THÊM HÓA ĐƠN"));
		bp1.add(Box.createHorizontalStrut(40));
		// bp1.add(Box.createHorizontalStrut(50));
		// bp.add(Box.createHorizontalStrut(50));
		Box bp2 = Box.createHorizontalBox();
		bp2.add(btnThanhToan = new JButton("THANH TOÁN"));
		// bp2.add(Box.createHorizontalStrut(50));
		bp2.add(Box.createHorizontalStrut(20));
		Box bp3 = Box.createHorizontalBox();
		bp3.add(btnThoat = new JButton("QUAY LẠI"));
		bp3.add(Box.createHorizontalStrut(50));

		bp.add(Box.createVerticalStrut(15));
		bp.add(bp1);
		bp.add(Box.createVerticalStrut(20));
		bp.add(bp2);
		bp.add(Box.createVerticalStrut(20));
		bp.add(bp3);
		bp.add(Box.createVerticalStrut(15));

		btnThemMoi.setPreferredSize(new Dimension(200, 30));
		btnThanhToan.setPreferredSize(btnThemMoi.getPreferredSize());
		btnThoat.setPreferredSize(btnThemMoi.getPreferredSize());

		pChucNang.add(bp);
		pSouth.add(pChucNang, BorderLayout.EAST);
		Border borderCN = BorderFactory.createLineBorder(Color.BLUE, font.BOLD);
		TitledBorder titledBorderCN = new TitledBorder(borderCN, "Chức năng");
		titledBorderCN.setTitleColor(Color.BLUE);
		pChucNang.setBorder(titledBorderCN);

		pBorder.add(pSouth, BorderLayout.SOUTH);
		pBorder.setBorder(new EmptyBorder(10, 20, 10, 20));

		this.add(pBorder);

		// set icon
		btnThemMoi.setIcon(new ImageIcon("src/img/them.png"));
		btnThoat.setIcon(new ImageIcon("src/img/quayLai.png"));
		btnThanhToan.setIcon(new ImageIcon("src/img/thanhToan.png"));

		// Đưa database và table
		// DocDuLieuDBVaoTable();

//		ArrayList<Thuoc> listThuoc;
//		listThuoc = thuoc_dao.getAllThuoc();
//		for (Thuoc t : listThuoc) {
//			cboAddThuoc.addItem(t.getMaThuoc());
//		}

		// event
		txtHoKH.addActionListener(this);
		txtTenKH.addActionListener(this);
		txtSDT.addActionListener(this);
		btnThemThuoc.addActionListener(this);
		btnThemMoi.addActionListener(this);
		btnThoat.addActionListener(this);
		btnThanhToan.addActionListener(this);
		btnTaiLai.addActionListener(this);
		cboPhanLoai.addActionListener(this);
		cboNCC.addActionListener(this);
		txtLocTheoTen.getDocument().addDocumentListener(this);
	}

	// load dữ liệu vào bảng thuốc
	public void loadThuoc(ArrayList<Thuoc> ds) {
		modelThuoc.setRowCount(0);
		int stt = 0;
		for (Thuoc t : ds) {
			modelThuoc.addRow(new Object[] { ++stt, t.getMaThuoc(), t.getTenThuoc(), t.getSoLuong(), t.getPhanLoai(),
					t.getNhaCC().getMaNCC() });
		}

	}

	private HoaDon createHD() {
		HoaDon temp = new HoaDon();
		// phat sinh ma hd
		int soHD = hd_dao.getSoluong();
		if (soHD == -1) {
			JOptionPane.showMessageDialog(null, "Phát sinh mã thất bại - Vui lòng kiểm tra kết nối database!!");
			return null;
		}
		String maHD = String.format("HD%01d", soHD + 1);
		txtMaHD.setText(maHD);
		// phat sinh ma kh
		int soKH = kh_dao.getSoluong();
		if (soKH == -1) {
			JOptionPane.showMessageDialog(null, "Phát sinh mã thất bại - Vui lòng kiểm tra kết nối database!!");
			return null;
		}
		String maKH = String.format("KH%01d", soKH + 1);
		txtMaKH.setText(maKH);

		Date dateNgayLapHD = dcrNgayLap.getDate();
		java.sql.Date sqlNgayLapHD = new java.sql.Date(dateNgayLapHD.getTime());

		Date dateNgaySinhKH = dcrNgaySinh.getDate();
		java.sql.Date sqlNgaySinh = new java.sql.Date(dateNgaySinhKH.getTime());

		String hoKH = txtHoKH.getText();
		String tenKH = txtTenKH.getText();
		Boolean gioiTinh = radNam.isSelected();
		String sdt = txtSDT.getText();
		String diaChi = txtDiaChi.getText();
		String maNhanVien = txtMaNV.getText();

		Double thanhTien = Double.parseDouble(txtTongThanhToan.getText());

		NhanVien nv = new NhanVien(maNhanVien);
		KhachHang kh = new KhachHang(maKH);

		// HoaDon hd = new HoaDon(maHD, sqlNgayLapHD, kh, nv,thanhTien );

		temp = new HoaDon(maHD, sqlNgayLapHD, kh, nv, thanhTien);
		KhachHang khdao = new KhachHang(maKH, hoKH, tenKH, diaChi, sdt, sqlNgaySinh, soKH, gioiTinh);
		kh_dao.insertKhachHang(khdao);

		// HoaDon hd = new HoaDon(maHD);

//		for(int i=0;i<model.getRowCount();i++) {
//			String maThuoc = (String) model.getValueAt(i, 1);
//			Thuoc t = new Thuoc(maThuoc);
//			String donViTinh = (String) model.getValueAt(i, 3);
//			Double donGia = (Double) model.getValueAt(i, 4);
//			int soLuong = (Integer) model.getValueAt(i, 5);
//			
//			
//			ChiTietHoaDon ct = new ChiTietHoaDon(t, donGia, soLuong, donViTinh, VAT, hd);
//			cthd_dao.createChiTietHoaDon(ct);
//		}

		return temp;
	}

	// kiem tra du lieu dua vao
	public boolean validData() {
		String hoKH = txtHoKH.getText().trim();
		String tenKH = txtTenKH.getText().trim();
		String sdt = txtSDT.getText().trim();
		String diaChi = txtDiaChi.getText().trim();
		String tienKhachDua = txtTienKhachDua.getText().trim();

		if (!(hoKH.matches("([A-Za-z ])+") && hoKH.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Họ khách hàng không được rỗng và là kí tự chữ");
			txtHoKH.requestFocus();
			return false;
		}
		if (!(tenKH.matches("([A-Za-z ])+") && tenKH.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Tên khách hàng không được rỗng và là kí tự chữ");
			txtTenKH.requestFocus();
			return false;
		}
		if (!(diaChi.matches("[A-Za-z ]+") && diaChi.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Địa chỉ khách hàng không được rỗng và là kí tự chữ");
			txtDiaChi.requestFocus();
			return false;
		}
		if (!(sdt.matches("[0-9]{9,}") && sdt.length() > 0)) {
			JOptionPane.showMessageDialog(this,
					"Số điện thoại khách hàng không được rỗng và là kí tự số (gồm 9 kí tự trở lên)");
			txtSDT.requestFocus();
			return false;
		}

		if (tienKhachDua.length() > 0) {
			try {
				double x = Double.parseDouble(tienKhachDua);
				double y = Double.parseDouble(txtTongThanhToan.getText().trim());
				if (x < y) {
					JOptionPane.showMessageDialog(this, "Tiền khách đưa phải lớn hơn hoặc bằng tổng tiền");
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Tiền khách đưa phải nhập kiểu số");
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập số tiền khách đưa");
		}
		return true;
	}

	public void xoaTrang() {
		txtMaHD.setText("");
		txtMaKH.setText("");
		txtHoKH.setText("");
		txtTenKH.setText("");
		txtSDT.setText("");
		txtDiaChi.setText("");
		txtHoKH.requestFocus();
		model.setRowCount(0);
		txtTienKhachDua.setText("");
		txtTienTraLai.setText("");
		txtTongThanhToan.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(txtHoKH)) {
			txtTenKH.requestFocus();
		}
		if (o.equals(txtTenKH)) {
			txtSDT.requestFocus();
		}
		if (o.equals(txtSDT)) {
			txtDiaChi.requestFocus();
		}
		if (o.equals(btnThoat)) {
			mhc.display();
			setVisible(false);
		}
		if (o.equals(btnThemMoi)) {
			xoaTrang();
		}
		if (o.equals(btnThemThuoc)) {
			int r = tableThuoc.getSelectedRow();
			if (r != -1) {
				String soLuong = JOptionPane.showInputDialog("Nhập số lương thuốc:");
				double soL = Double.parseDouble(soLuong);
				double thanhTien = 0;
				double dongia;
				String maThuoc = modelThuoc.getValueAt(r, 1).toString();
				ArrayList<Thuoc> ds = thuoc_dao.getAllThuocTheoMaThuoc(maThuoc);
				for (Thuoc t : ds) {
					dongia = t.getDonGia();
					thanhTien = dongia * soL + dongia * soL * VAT;
					tongThanhTien += thanhTien;
					model.addRow(new Object[] { ++stt, maThuoc, t.getTenThuoc(), t.getDonViTinh(), t.getDonGia(),
							soLuong, VAT, thanhTien + "" });
					txtTongThanhToan.setText(tongThanhTien + "");
				}
				// createHD();
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn thuốc");
			}
		}
		if (o.equals(cboNCC)) {
			String maNCC = cboNCC.getSelectedItem().toString();
			ArrayList<Thuoc> dsT = thuoc_dao.getAllThuocTheoNCC(maNCC);
			loadThuoc(dsT);
		}
		if (o.equals(cboPhanLoai)) {
			String pl = cboPhanLoai.getSelectedItem().toString();
			ArrayList<Thuoc> dsT = thuoc_dao.getAllThuocTheoPL(pl);
			loadThuoc(dsT);
		}
		if (o.equals(btnThanhToan)) {
			if (validData()) {
				double tienKD = Double.parseDouble(txtTienKhachDua.getText());
				double tienTL = tienKD - tongThanhTien;
				txtTienTraLai.setText(tienTL + "");
				HoaDon hd = createHD();
				if (!hd_dao.createHoaDon(hd)) {
					JOptionPane.showMessageDialog(null, "Trùng mã - Kiểm tra lại !!!");
					return;
				} else {
					JOptionPane.showMessageDialog(this, "Đã lưu hóa đơn");
					xoaTrang();
				}
			}
		}
		if (o.equals(btnTaiLai)) {
			ArrayList<Thuoc> ds = thuoc_dao.getAllThuoc();
			loadThuoc(ds);
			cboNCC.setSelectedIndex(0);
			cboPhanLoai.setSelectedIndex(0);
			txtLocTheoTen.setText("");
			txtLocTheoTen.requestFocus();
		}
	}

	// tìm kiếm và hiển thị lại danh sách
	public void UpdateTableThuoc() {
		String ten = txtLocTheoTen.getText();
		ArrayList<Thuoc> ds = thuoc_dao.getAllThuoc();
		ArrayList<Thuoc> dsMoi = new ArrayList<Thuoc>();
		modelThuoc = (DefaultTableModel) tableThuoc.getModel();
		modelThuoc.getDataVector().removeAllElements();
		if (ten.isEmpty()) {
			loadThuoc(ds);
		} else {
			for (Thuoc t : ds) {
				if (t.getTenThuoc().toLowerCase().startsWith(ten.toLowerCase()))
					dsMoi.add(t);
			}
			loadThuoc(dsMoi);
		}
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		UpdateTableThuoc();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		UpdateTableThuoc();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		UpdateTableThuoc();
	}
}
