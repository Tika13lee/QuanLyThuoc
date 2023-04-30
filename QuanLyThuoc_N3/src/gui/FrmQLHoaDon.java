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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import connect.ConnectDB;
import dao.ChiTietHoaDon_DAO;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import dao.TaiKhoan_DAO;
import dao.Thuoc_DAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.TaiKhoan;
import entity.Thuoc;

public class FrmQLHoaDon extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final double VAT = 0.05;
	private JLabel lblMaHD, lblNgayLap, lblSDT, lblHoKH, lblTenKH, lblGioiTinh, lblDiaChi, lblNgaySinh, lblMaKH;
	private JLabel lblMaNV, lblHoTenNV, lblSDTNV, lblDiaChiNV; // nhan vien
	private JTextField txtMaNV, txtHoTenNV, txtSDTNV, txtDiaChiNV;// nhan vien
	private JTextField txtMaHD, txtSDT, txtHoKH, txtTenKH, txtDiaChi, txtMaKH;// KH
	private JDateChooser dcrNgayLap, dcrNgaySinh;
	private JRadioButton radNam;
	private DefaultTableModel model;
	private JTable table;
	private JButton btnThemMoi, btnThanhToan, btnThemThuoc, btnThoat;
	private JTabbedPane tabbedPane;
	private JComboBox<String> cboAddThuoc;
	// thanh toan
	private JLabel lblTongThanhToan, lblPhuongThucThanhToan, lblTienKhachDua, lblTienTraLai;
	private JTextField txtTongThanhToan, txtTienKhachDua, txtTienTraLai;
	private JComboBox<String> cboPhuongThucThanhToan;
	// Goi DAO
	private Thuoc_DAO thuoc_dao = new Thuoc_DAO();
	private HoaDon_DAO hd_dao = new HoaDon_DAO();
	private KhachHang_DAO kh_dao = new KhachHang_DAO();
	private TaiKhoan_DAO tk_dao;
	private NhanVien_DAO nv_dao;
	// private ChiTietHoaDon_DAO cthd_DAO;

	private FrmManHinhChinh mhc;

	public FrmQLHoaDon(FrmManHinhChinh mhc, String user) {
		this.mhc = mhc;

		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Giao dien
		JPanel pBorder = new JPanel();
		pBorder.setLayout(new BorderLayout());
		setTitle("LapHoaDon");
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

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
//		b1.add(Box.createVerticalStrut(15));
		b1.add(lblMaHD = new JLabel("Mã hóa đơn:"));
		b1.add(txtMaHD = new JTextField());
		txtMaHD.setEditable(false); // set chỉ được đọc
		b1.add(Box.createHorizontalStrut(50));

		b1.add(lblNgayLap = new JLabel("Ngày lập hóa đơn:"));
		b1.add(dcrNgayLap = new JDateChooser());
		dcrNgayLap.setLocale(new Locale("vi", "VN"));
		dcrNgayLap.setDateFormatString("dd/MM/yyyy");
		dcrNgayLap.setDate(new Date(System.currentTimeMillis()));
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
		b2.add(Box.createHorizontalStrut(316));
		b2.add(lblGioiTinh = new JLabel("Giới tính:"));
		radNam = new JRadioButton("Nam");
		b2.add(radNam);
		b2.add(Box.createHorizontalStrut(20));
		pText.add(Box.createVerticalStrut(20));
		pText.add(b2);

		txtHoKH.setPreferredSize(txtMaHD.getPreferredSize());
		txtTenKH.setPreferredSize(dcrNgayLap.getPreferredSize());
//		radNam.setPreferredSize(txtMaKH.getPreferredSize());

		Box b3 = Box.createHorizontalBox();
		b3.add(Box.createHorizontalStrut(20));
		b3.add(lblSDT = new JLabel("Số điện thoại KH:"));
		b3.add(txtSDT = new JTextField());
		b3.add(Box.createHorizontalStrut(50));
		b3.add(lblNgaySinh = new JLabel("Ngày sinh KH:"));
//		 b3.add(txtNgaySinh = new JTextField(15));
		b3.add(dcrNgaySinh = new JDateChooser());
		dcrNgaySinh.setLocale(new Locale("vi", "VN"));
		dcrNgaySinh.setDateFormatString("dd/MM/yyyy");
		b3.add(Box.createHorizontalStrut(140));
		b3.add(cboAddThuoc = new JComboBox<String>());
		cboAddThuoc.setPreferredSize(new Dimension(200, 15));
		b3.add(Box.createHorizontalStrut(20));
		b3.add(btnThemThuoc = new JButton("Thêm thuốc"));
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

		// Dimension dms_lbl = new Dimension(100, 20);
		// Arrays.stream(new JLabel[] {
		// lblMaHD,lblNgayLap,lblSDT,lblHoTenKH,lblGioiTinh,lblDiaChi,lblCMND,lblNgaySinh,lblTenThuoc,lblTuoi,lblTimThuoc
		// })
		// .forEach(item -> item.setPreferredSize(dms_lbl));

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

//		btnThem.setFont(new Font("Arial", font.PLAIN, 15));
//		btnXoa.setFont(new Font("Arial", font.PLAIN, 15));
//		btnLamMoi.setFont(new Font("Arial", font.PLAIN, 15));
//		btnThanhToan.setFont(new Font("Arial", font.PLAIN, 15));
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

		ArrayList<Thuoc> listThuoc;
		listThuoc = thuoc_dao.getAllThuoc();
		for (Thuoc t : listThuoc) {
			cboAddThuoc.addItem(t.getMaThuoc());
		}

		// dua du liue vao cbo nhan vien
//		DuaNVVaoCBO();

		// event
		txtHoKH.addActionListener(this);
		txtTenKH.addActionListener(this);
		txtSDT.addActionListener(this);
		btnThemThuoc.addActionListener(this);
		btnThemMoi.addActionListener(this);
		btnThoat.addActionListener(this);
		btnThanhToan.addActionListener(this);

	}
	// Doc dux lieu len table
//	public void DocDuLieuDBVaoTable() {
//		ChiTietHoaDon t = new ChiTietHoaDon();
//		int stt = 0;
//		cthd_DAO = new ChiTietHoaDon_DAO();
//		List<ChiTietHoaDon> listCTHD = cthd_DAO.getAllChiTietHoaDon();
//		for (ChiTietHoaDon ct : listCTHD) {
//			model.addRow(new Object[] {++stt,ct.getThuoc().getMaThuoc(),ct.getThuoc().getTenThuoc(),ct.getMoTa(),ct.getDonViTinh(),ct.getDonGia(),ct.getSoLuong(),ct.getPhiVAT(),t.soTienPhaiTra()});
//		}
//	}

	private HoaDon createHD() {
		HoaDon temp = new HoaDon();
		// phat sinh ma hd
		int soHD = hd_dao.getSoluong();
		if (soHD == -1) {
			JOptionPane.showMessageDialog(null, "Phát sinh mã thất bại - Vui lòng kiểm tra kết nối database!!");
			return null;
		}
		String maHD = String.format("HD%03d", soHD + 1);
		txtMaHD.setText(maHD);
		// phat sinh ma kh
		int soKH = kh_dao.getSoluong();
		if (soKH == -1) {
			JOptionPane.showMessageDialog(null, "Phát sinh mã thất bại - Vui lòng kiểm tra kết nối database!!");
			return null;
		}
		String maKH = String.format("KH%03d", soKH + 1);
		txtMaKH.setText(maKH);

		return temp;
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
			txtMaHD.setText("");
			txtMaKH.setText("");
			txtHoKH.setText("");
			txtTenKH.setText("");
			txtSDT.setText("");
			txtDiaChi.setText("");
			txtMaKH.requestFocus();
		}
		if (o.equals(btnThemThuoc)) {
			String soLuong = JOptionPane.showInputDialog("Nhập số lương thuốc:");
			double soL = Double.parseDouble(soLuong);
			int stt = 0;
			double thanhTien = 0;
			double dongia;
			String maThuoc = (String) cboAddThuoc.getSelectedItem();
			ArrayList<Thuoc> ds = thuoc_dao.getAllThuocTheoMaThuoc(maThuoc);
			for (Thuoc t : ds) {
				dongia = t.getDonGia();
				thanhTien = dongia * soL + dongia * soL * VAT;
				model.addRow(new Object[] { ++stt, maThuoc, t.getTenThuoc(), t.getDonViTinh(), t.getDonGia(), soLuong,
						VAT, thanhTien + "" });
			}
			createHD();
		}

	}
}
