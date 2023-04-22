package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import connect.ConnectDB;
import dao.ChiTietHoaDon_DAO;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.NhaCungCap_DAO;
import dao.NhanVien_DAO;
import dao.Thuoc_DAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Thuoc;

public class FrmQLHoaDon extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JLabel lblMaHD, lblNgayLap, lblSDT, lblHoKH, lblTenKH, lblGioiTinh, lblDiaChi, lblNgaySinh,lblMaKH;
	private JLabel lblMaNV, lblHoTenNV, lblSDTNV, lblDiaChiNV; // nhan vien
	private JTextField txtMaNV, txtHoTenNV, txtSDTNV, txtDiaChiNV;// nhan vien
	private JTextField txtMaHD, txtSDT, txtHoKH, txtTenKH, txtDiaChi,txtMaKH;// KH
	private JDateChooser dcrNgayLap;
	private JDateChooser dcrNgaySinh;
	private JRadioButton radNam;
	private DefaultTableModel model;
	private JTable table;
	private JButton btnThem, btnXoa, btnLamMoi, btnThanhToan, btnTimThuoc;
	private JTabbedPane tabbedPane;
	//quan ly hoa don
	private JLabel lblTimHDTheoMa,lblTimHDTheoNV;
	private JComboBox<String> cboTimHDTheoMa;
	private JComboBox<String> cboTimHDTheoNV;
	private JButton btnXoaHD,btnThoat;
	private DefaultTableModel model1;
	private JTable table1;
	//thanh toan
	private JLabel lblTongThanhToan,lblPhuongThucThanhToan,lblTienKhachDua,lblTienTraLai;
	private JTextField txtTongThanhToan,txtTienKhachDua,txtTienTraLai;
	private JComboBox cboPhuongThucThanhToan;
	//Goi DAO
	private HoaDon_DAO hd_DAO;
	private Thuoc_DAO t_DAO;
	private NhanVien_DAO nv_DAO;
	private KhachHang_DAO kh_DAO;
	private ChiTietHoaDon_DAO cthd_DAO;


	public FrmQLHoaDon() {
		// TODO Auto-generated constructor stub
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		t_DAO = new Thuoc_DAO();
		hd_DAO = new HoaDon_DAO();
		cthd_DAO = new ChiTietHoaDon_DAO();

		//Giao dien
		JPanel pBorder = new JPanel();
		pBorder.setLayout(new BorderLayout());
		setTitle("Hóa đơn");
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		JPanel pNorth = new JPanel();
		JLabel lblTitle = new JLabel("LẬP HÓA ĐƠN");
		lblTitle.setForeground(Color.BLUE);
		Font font = new Font("Arial", Font.BOLD, 25);
		lblTitle.setFont(font);
		pNorth.add(lblTitle);
		pNorth.setBorder(new EmptyBorder(30, 0, 0, 0));
		pBorder.add(pNorth, BorderLayout.NORTH);

		JPanel pCenter = new JPanel();
		pCenter.setLayout(new BoxLayout(pCenter, BoxLayout.Y_AXIS));

		Box b1 = Box.createHorizontalBox();
		b1.add(Box.createVerticalStrut(15));
		b1.add(lblMaHD = new JLabel("Mã hóa đơn:"));
		b1.add(txtMaHD = new JTextField(15));
		b1.add(Box.createHorizontalStrut(50));

		b1.add(lblNgayLap = new JLabel("Ngày lập hóa đơn:"));
		b1.add(dcrNgayLap = new JDateChooser());
		dcrNgayLap.setLocale(new Locale("vi", "VN"));
		dcrNgayLap.setDateFormatString("dd/MM/yyyy");
		dcrNgayLap.setDate(new Date(System.currentTimeMillis()));
		b1.add(Box.createHorizontalStrut(50));
		pCenter.add(Box.createVerticalStrut(20));
		b1.add(lblMaKH = new JLabel("Mã khách hàng:"));
		b1.add(txtMaKH = new JTextField(15));
		pCenter.add(b1);

		Box b2 = Box.createHorizontalBox();
		b2.add(lblHoKH = new JLabel("Họ KH:"));
		b2.add(txtHoKH = new JTextField(15));
		b2.add(Box.createHorizontalStrut(125));
		b2.add(lblTenKH = new JLabel("Tên KH:"));
		b2.add(txtTenKH = new JTextField(15));
		b2.add(Box.createHorizontalStrut(50));
		b2.add(lblGioiTinh = new JLabel("Giới tính:"));
		radNam = new JRadioButton("Nam",true);
		b2.add(radNam);
		//b2.add(Box.createHorizontalStrut(200));
		b2.add(Box.createHorizontalStrut(290));
		pCenter.add(Box.createVerticalStrut(20));
		pCenter.add(b2);

		Box b3 = Box.createHorizontalBox();
		b3.add(lblSDT = new JLabel("Số điện thoại KH:"));
		b3.add(txtSDT = new JTextField(15));
		b3.add(Box.createHorizontalStrut(50));
		b3.add(lblNgaySinh = new JLabel("Ngày sinh KH:"));
		// b3.add(txtNgaySinh = new JTextField(15));
		b3.add(dcrNgaySinh = new JDateChooser());
		dcrNgaySinh.setLocale(new Locale("vi", "VN"));
		dcrNgaySinh.setDateFormatString("dd/MM/yyyy");
		b3.add(Box.createHorizontalStrut(50));
		b3.add(btnTimThuoc = new JButton("Tìm thuốc"));
		b3.add(Box.createHorizontalStrut(340));
		pCenter.add(Box.createVerticalStrut(20));
		pCenter.add(b3);

		Box b4 = Box.createHorizontalBox();
		b4.add(lblDiaChi = new JLabel("Địa chỉ:"));
		b4.add(txtDiaChi = new JTextField(30));
		pCenter.add(Box.createVerticalStrut(20));
		pCenter.add(b4);

		lblMaHD.setPreferredSize(new Dimension(150, 20));
		lblNgayLap.setPreferredSize(new Dimension(150, 20));
		lblMaKH.setPreferredSize(new Dimension(150, 20));

		lblHoKH.setPreferredSize(lblMaHD.getPreferredSize());
		lblTenKH.setPreferredSize(lblNgayLap.getPreferredSize());
		lblGioiTinh.setPreferredSize(lblMaKH.getPreferredSize());

		lblSDT.setPreferredSize(lblMaHD.getPreferredSize());
		lblNgaySinh.setPreferredSize(lblMaKH.getPreferredSize());
		btnTimThuoc.setPreferredSize(lblMaKH.getPreferredSize());

		lblDiaChi.setPreferredSize(lblMaHD.getPreferredSize());

		//		Dimension dms_lbl = new Dimension(100, 20);
		//		Arrays.stream(new JLabel[] { lblMaHD,lblNgayLap,lblSDT,lblHoTenKH,lblGioiTinh,lblDiaChi,lblCMND,lblNgaySinh,lblTenThuoc,lblTuoi,lblTimThuoc })
		//		.forEach(item -> item.setPreferredSize(dms_lbl));

		String[] tb = new String[] { "STT", "Mã thuốc","Tên thuốc","Mô tả","Đơn vị tính","Đơn giá bán","Số lượng","%VAT","Thành tiền" };
		model = new DefaultTableModel(tb, 0);
		table = new JTable(model);
		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setPreferredSize(new Dimension(0, 350));
		pCenter.add(Box.createVerticalStrut(20));
		pCenter.add(sp);
		pCenter.setBorder(new EmptyBorder(10, 0, 0, 0));

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
		//pSouth.add(Box.createHorizontalStrut(200));
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
		bh2.add(lblPhuongThucThanhToan = new JLabel("Phương thức thanh toán"));
		cboPhuongThucThanhToan = new JComboBox<String>(new String[] {"Tiền mặt","Thẻ tín dụng"});
		bh2.add(cboPhuongThucThanhToan);
		bh2.add(Box.createHorizontalStrut(20));
		Box bh3 = Box.createHorizontalBox();
		bh3.add(Box.createHorizontalStrut(20));
		bh3.add(lblTienKhachDua = new JLabel("Tiền khách đưa:"));
		bh3.add(txtTienKhachDua =  new JTextField(15));
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
		lblTongThanhToan.setPreferredSize(new Dimension(150,20));
		lblPhuongThucThanhToan.setPreferredSize(lblTongThanhToan.getPreferredSize());
		lblTienKhachDua.setPreferredSize(lblTongThanhToan.getPreferredSize());
		lblTienTraLai.setPreferredSize(lblTongThanhToan.getPreferredSize());
		pThanhToan.add(bv);

		Border borderTT = BorderFactory.createLineBorder(Color.BLUE, font.BOLD);
		TitledBorder titledBorderTT = new TitledBorder(borderTT, "Thanh toán");
		titledBorderTT.setTitleColor(Color.BLUE);
		pThanhToan.setBorder(titledBorderTT);
		pSouth.add(Box.createHorizontalStrut(75));
		pSouth.add(pThanhToan,BorderLayout.CENTER);
		pSouth.add(Box.createHorizontalStrut(75));




		JPanel pChucNang = new JPanel();
		pChucNang.setLayout(new BoxLayout(pChucNang, BoxLayout.Y_AXIS));
		Box bp = Box.createVerticalBox();
		Box bp1 = Box.createHorizontalBox();
		// bp1.add(Box.createHorizontalStrut(50));
		bp1.add(btnThem = new JButton("Thêm hóa đơn"));
		bp1.add(Box.createHorizontalStrut(50));
		bp1.add(btnXoa = new JButton("Xóa hóa đơn"));
		// bp1.add(Box.createHorizontalStrut(50));
		// bp.add(Box.createHorizontalStrut(50));
		Box bp2 = Box.createHorizontalBox();
		bp2.add(btnLamMoi = new JButton("Làm mới"));
		bp2.add(Box.createHorizontalStrut(50));
		bp2.add(btnThanhToan = new JButton("Thanh toán"));
		// bp2.add(Box.createHorizontalStrut(50));

		bp.add(Box.createVerticalStrut(40));
		bp.add(bp1);
		bp.add(Box.createVerticalStrut(20));
		bp.add(bp2);
		bp.add(Box.createVerticalStrut(40));

		btnThem.setPreferredSize(new Dimension(200, 30));
		btnXoa.setPreferredSize(new Dimension(200, 30));
		btnLamMoi.setPreferredSize(btnThem.getPreferredSize());
		btnThanhToan.setPreferredSize(btnXoa.getPreferredSize());

		btnThem.setFont(new Font("Arial", font.PLAIN, 15));
		btnXoa.setFont(new Font("Arial", font.PLAIN, 15));
		btnLamMoi.setFont(new Font("Arial", font.PLAIN, 15));
		btnThanhToan.setFont(new Font("Arial", font.PLAIN, 15));
		pChucNang.add(bp);
		pSouth.add(pChucNang, BorderLayout.EAST);
		Border borderCN = BorderFactory.createLineBorder(Color.BLUE, font.BOLD);
		TitledBorder titledBorderCN = new TitledBorder(borderCN, "Chức năng");
		titledBorderCN.setTitleColor(Color.BLUE);
		pChucNang.setBorder(titledBorderCN);

		pBorder.add(pSouth, BorderLayout.SOUTH);
		pBorder.setBorder(new EmptyBorder(10, 20, 10, 20));

		this.add(pBorder);
		btnTimThuoc.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnThanhToan.addActionListener(this);


		//frm quan ly hoa don
		JPanel pBorder1 = new JPanel();
		pBorder1.setLayout(new BorderLayout());

		JPanel pNorth1 = new JPanel();
		JLabel lblTitle1 = new JLabel("QUẢN LÝ HÓA ĐƠN");
		lblTitle1.setForeground(Color.BLUE);
		Font font1 = new Font("Arial", Font.BOLD, 30);
		lblTitle1.setFont(font1);
		pNorth1.add(lblTitle1);
		pNorth1.setBorder(new EmptyBorder(20, 0, 0, 0));
		pBorder1.add(pNorth1, BorderLayout.NORTH);

		JPanel pCenter1 = new JPanel();
		pCenter1.setLayout(new BoxLayout(pCenter1, BoxLayout.Y_AXIS));

		Box b11 = Box.createHorizontalBox();
		b11.add(lblTimHDTheoMa= new JLabel("Tìm theo mã hóa đơn:"));
		b11.add(cboTimHDTheoMa = new JComboBox<String>());
		cboTimHDTheoMa.setPreferredSize(new Dimension(200, 20));
		b11.add(Box.createHorizontalStrut(500));
		b11.add(btnXoaHD = new JButton("Xóa hóa đơn"));
		pCenter1.add(Box.createVerticalStrut(50));
		pCenter1.add(b11);

		Box b21 = Box.createHorizontalBox();
		b21.add(lblTimHDTheoNV= new JLabel("Tìm theo mã nhân viên:"));
		b21.add(cboTimHDTheoNV = new JComboBox<String>());
		cboTimHDTheoNV.setPreferredSize(new Dimension(200, 20));
		b21.add(Box.createHorizontalStrut(500));
		b21.add(btnThoat = new JButton("Thoát"));
		pCenter1.add(Box.createVerticalStrut(20));
		pCenter1.add(b21);
		pCenter1.add(Box.createVerticalStrut(20));

		lblTimHDTheoMa.setPreferredSize(new Dimension(200,20));
		lblTimHDTheoNV.setPreferredSize(lblTimHDTheoMa.getPreferredSize());

		//table
		String[] tb1 = new String[] { "STT", "Mã hóa đơn","Ngày lập hóa đơn","Mã nhân viên","Mã khách hàng"};
		model1 = new DefaultTableModel(tb1, 0);
		table1 = new JTable(model1);
		JScrollPane sp1 = new JScrollPane(table1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp1.setPreferredSize(new Dimension(0, 600));
		pCenter1.add(Box.createVerticalStrut(20));
		pCenter1.add(sp1);

		pBorder1.add(pCenter1,BorderLayout.CENTER);
		pBorder1.setBorder(new EmptyBorder(20, 50, 20, 50));


		this.add(pBorder1);
		cboTimHDTheoMa.addActionListener(this);
		cboTimHDTheoNV.addActionListener(this);
		btnThoat.addActionListener(this);
		btnXoaHD.addActionListener(this);

		//tao tab
		tabbedPane = new JTabbedPane();
		tabbedPane.setForeground(new Color(0, 128, 128));
		tabbedPane.setBounds(0, 0, 1535, 840);
		tabbedPane.setBorder(null);

		tabbedPane.addTab("Lập hóa đơn", pBorder);
		//tabbedPane.setBackground(Color.GRAY);
		getContentPane().add(tabbedPane);
		tabbedPane.add("Quản lý hóa đơn",pBorder1);
		getContentPane().add(tabbedPane);


		//Đưa database và table 
		DocDuLieuDBVaoTable();



	}
	// Doc dux lieu len table
	public void DocDuLieuDBVaoTable() {
		ChiTietHoaDon t = new ChiTietHoaDon();
		int stt = 0;
		cthd_DAO = new ChiTietHoaDon_DAO();
		List<ChiTietHoaDon> listCTHD = cthd_DAO.getAllChiTietHoaDon();
		for (ChiTietHoaDon ct : listCTHD) {
			model.addRow(new Object[] {++stt,ct.getThuoc().getMaThuoc(),ct.getThuoc().getTenThuoc(),ct.getMoTa(),ct.getDonViTinh(),ct.getDonGia(),ct.getSoLuong(),ct.getPhiVAT(),t.soTienPhaiTra()});
		}
	}
	//Tinh tong thanh tien

	public static void main(String[] args) {
		new FrmQLHoaDon().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
