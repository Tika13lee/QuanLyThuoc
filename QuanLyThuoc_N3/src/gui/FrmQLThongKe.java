package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;

public class FrmQLThongKe extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane;
	private JPanel pnlThongkeTTThuoc, pnlToanPhan, panel, pnlThongKeBaoCao, pnlThongTinChung, pnlThongTin,
			pnlThongKeChiTiet, pnlThongKe;

	JLabel lblThongTinKhachHang, lblDiaChi, lblThngKTheo, lblTongSLThuocBan, lblMaNV, lblTenNV, lblSDT, lblNN, lblMakh,
			lblNgay, lblDonthuoc, lblTongHD;
	JTextField txtDiaChi, txtTenKH, txtMaKH, txtNN, txtSDT, txtMakn;
	JButton btnTim, btnThem, btnXoa, btnBaoCao, btnXemThuocConLai, btnXemThuocDaBan, btnXemThuocHetHan,
			btnXemthuocConLaiTrongKho;
	JComboBox cmbMaKH, cmbNgay, cmbDonThuoc, cmbNgayTLTQ;
	ImageIcon background;
	JPanel panel_1;
	JScrollPane scrollPaneTKTTT, scrTKTQ1;
	JMonthChooser monthChooser;
	JMonthChooser txtThang;

	public static DefaultTableModel tablemodel = new DefaultTableModel();
	public static DefaultTableModel tablemodel1 = new DefaultTableModel();
	DefaultTableModel tablemodel2 = new DefaultTableModel();
	private JLabel lblNgayy;
	public static JTextField txtTongSoLuongThuoc;
	public static JTextField txtTongSoLoaiThuoc;
	public static JTextField txtTongSLThuocBan;
	public static JTextField txtTongSoHD;
	private JTable table_1;
	private JTextField txtLoiNhuan;
	String s;
	private JTable table2;
	private JTextField txtTongTienThuocDaNhap;
	private JTextField txtTongTienBanDuocTKTq;
	private JTextField txtLoiNhuanThuDkTQ;
	private JButton btnXemBCAoTKTQ;
	private JTable tblThongKeTongQuat;
	private JPanel panel_BaoCao;
	private JTextField txtNam;
	private JComboBox comboBox;
	private JDateChooser txtChonNgay;
	private JDateChooser txtChonNgayThongKeThuoc;
	private JRadioButton radioButton_2;
	private JRadioButton radioButton_3;
	private JRadioButton radioButton_4;
	private JRadioButton radSLThuocMua;
	private JRadioButton radTongHD;

	public FrmQLThongKe() {
//		setBackground(new Color(176, 224, 230));
		setTitle("Quản Lí Hiệu Thuốc");
//		setSize(1354, 733);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setResizable(false);

		/**
		 * Tab thống kê hóa đơn theo nhân viên -Panel thông tin chung: +Ngày mua +Mã
		 * khách hàng, tên khách hàng +Đơn thuốc -Panel Thống kê chi tiết: +Tổng lượng
		 * thuốc đã mua +Tổng hóa đơn
		 */
		panel = new JPanel();
		pnlThongTinChung = new JPanel();
		pnlThongTin = new JPanel();
		pnlThongTin.setBounds(20, 60, 610, 89);
		pnlThongKeChiTiet = new JPanel();
		pnlThongKe = new JPanel();
		txtTongSoHD = new JTextField();
		txtTongSoHD.setForeground(Color.BLUE);
		txtTongSLThuocBan = new JTextField();
		txtTongSLThuocBan.setForeground(Color.BLUE);
		txtTenKH = new JTextField();
		cmbMaKH = new JComboBox();
		cmbDonThuoc = new JComboBox();

		// set Ngày hiện tại
		String ngay;
		AbstractButton datePicker = null;
		Date today = new Date(System.currentTimeMillis()); // lấy theo gian thực
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd"); // định dạng kiểu ngày
		ngay = timeFormat.format(today.getTime());
		pnlThongTinChung.setLayout(null);

		// tạo tab
		tabbedPane = new JTabbedPane();
		tabbedPane.setForeground(new Color(0, 128, 128));
		tabbedPane.setBounds(0, 0, 1535, 840);
		tabbedPane.setBorder(null);

		// panel tổng
		pnlToanPhan = new JPanel();
		pnlToanPhan.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlToanPhan.setBackground(SystemColor.controlHighlight);

		JPanel pnlTieuDeTKHDTHV = new JPanel();
		pnlTieuDeTKHDTHV.setBackground(SystemColor.controlHighlight);
		pnlTieuDeTKHDTHV.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlTieuDeTKHDTHV.setBounds(10, 11, 1510, 71);
		pnlToanPhan.add(pnlTieuDeTKHDTHV);
		pnlTieuDeTKHDTHV.setLayout(null);

		JLabel lblTieuDeTKHDTKH = new JLabel("THỐNG KÊ HÓA ĐƠN THEO NHÂN VIÊN");
		lblTieuDeTKHDTKH.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDeTKHDTKH.setForeground(Color.RED);
		lblTieuDeTKHDTKH.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTieuDeTKHDTKH.setBounds(480, 11, 538, 37);
		pnlTieuDeTKHDTHV.add(lblTieuDeTKHDTKH);

		tabbedPane.addTab("Thống kê hóa đơn theo nhân viên", pnlToanPhan);
		tabbedPane.setBackground(Color.CYAN);
		pnlToanPhan.setLayout(null);

		pnlThongTinChung.setBackground(SystemColor.controlHighlight);
		pnlThongTinChung.setBounds(10, 93, 650, 157);
		pnlToanPhan.add(pnlThongTinChung);

		lblNgay = new JLabel("Ngày:");
		lblNgay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgay.setBounds(23, 29, 48, 20);
		lblMaNV = new JLabel("Mã Nhân Viên:");
		lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenNV = new JLabel("Tên Nhân Viên:");
		lblTenNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDonthuoc = new JLabel("Đơn thuốc");
		lblDonthuoc.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTongHD = new JLabel("Tổng số hóa đơn:");
		lblTongHD.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTongSLThuocBan = new JLabel("Tổng số lượng thuốc đã mua:");
		lblTongSLThuocBan.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTenNV.setBounds(20, 55, 107, 14);
		lblMaNV.setBounds(20, 20, 107, 14);
		lblDonthuoc.setBounds(350, 20, 79, 14);
		lblTongHD.setBounds(45, 58, 150, 22);
		lblTongSLThuocBan.setBounds(45, 18, 200, 20);
		txtTenKH.setBounds(140, 55, 130, 20);
		txtTongSLThuocBan.setBounds(253, 20, 124, 20);
		txtTongSoHD.setBounds(253, 60, 124, 20);
		txtTenKH.setEditable(false);
		txtTongSLThuocBan.setEditable(false);
		txtTongSoHD.setEditable(false);
		txtTongSLThuocBan.setColumns(10);
		txtTenKH.setColumns(10);
		txtTongSoHD.setColumns(10);
		cmbMaKH.setBounds(140, 18, 130, 20);
		cmbDonThuoc.setBounds(450, 18, 135, 20);

		txtChonNgay = new JDateChooser();
		txtChonNgay.setForeground(new Color(0, 0, 255));
		txtChonNgay.getCalendarButton().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtChonNgay.setLocale(new Locale("vi", "VN"));
		txtChonNgay.setDateFormatString("dd/MM/yyyy");
		txtChonNgay.setDate(new Date(System.currentTimeMillis()));
		txtChonNgay.setBounds(81, 29, 142, 20);
		pnlThongTinChung.add(txtChonNgay);

		pnlThongKe.add(lblTongSLThuocBan);
		pnlThongKe.add(lblTongHD);
		pnlThongKe.add(txtTongSoHD);
		pnlThongTin.add(lblMaNV);
		pnlThongTin.add(lblTenNV);
		pnlThongTin.add(lblDonthuoc);
		pnlThongTinChung.add(lblNgay);
		pnlThongTin.add(cmbMaKH);
		cmbMaKH.addItem("Tất cả");

		pnlThongTin.add(txtTenKH);
		cmbDonThuoc.addItem("Tất cả");
		cmbDonThuoc.addItem("Thuốc kê đơn");
		cmbDonThuoc.addItem("Không kê đơn");
		pnlThongTin.add(cmbDonThuoc);
		pnlThongKe.add(txtTongSLThuocBan);

		javax.swing.border.Border southborder4 = BorderFactory.createLineBorder(Color.blue, Font.BOLD);
		TitledBorder southTitleBorder4 = new TitledBorder(southborder4, "Thông tin chung");
		southTitleBorder4.setTitleColor(Color.blue);
		pnlThongTinChung.setBorder(
				new TitledBorder(null, "Thông tin chung", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlToanPhan.add(pnlThongTinChung);

		pnlThongTin.setBackground(SystemColor.controlHighlight);
		pnlThongTin.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnlThongTinChung.add(pnlThongTin);
		pnlThongTin.setLayout(null);

		pnlThongKeChiTiet.setBackground(SystemColor.controlHighlight);
		pnlThongKeChiTiet.setBounds(670, 93, 850, 157);
		pnlToanPhan.add(pnlThongKeChiTiet);
		pnlThongKeChiTiet.setLayout(null);

		javax.swing.border.Border southborder5 = BorderFactory.createLineBorder(Color.blue, Font.BOLD);
		TitledBorder southTitleBorder5 = new TitledBorder(southborder5, "Chi tiết thống kê");
		southTitleBorder5.setTitleColor(Color.blue);
		pnlThongKeChiTiet.setBorder(
				new TitledBorder(null, "Thông kê chi tiết", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlToanPhan.add(pnlThongKeChiTiet);

		pnlThongKe.setBackground(SystemColor.controlHighlight);
		pnlThongKe.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnlThongKe.setBounds(20, 24, 810, 126);
		pnlThongKeChiTiet.add(pnlThongKe);
		pnlThongKe.setLayout(null);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(406, 0, 312, 124);
		pnlThongKe.add(label_1);

		radSLThuocMua = new JRadioButton("");
		radSLThuocMua.setSelected(true);
		radSLThuocMua.setBackground(SystemColor.controlHighlight);
		radSLThuocMua.setBounds(15, 20, 28, 19);
		pnlThongKe.add(radSLThuocMua);

		radTongHD = new JRadioButton("");
		radTongHD.setSelected(true);
		radTongHD.setBackground(SystemColor.controlHighlight);
		radTongHD.setBounds(15, 60, 28, 19);
		pnlThongKe.add(radTongHD);

		// danh sách thống kê và nút báo cáo
		JScrollPane scrDSTK;
		String[] tb1 = new String[] { "Mã Hóa đơn", "Mã Nhân Viên", "Họ Nhân Viên", "Tên Nhân Viên", "Tuổi", "Số CCCD",
				"Giới tính", "Tài Khoản", "Địa Chỉ" };
		tablemodel = new DefaultTableModel(tb1, 0);
		table_1 = new JTable(tablemodel);
		table_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		table_1.setBackground(new Color(255, 250, 205));
		table_1.setForeground(new Color(0, 0, 205));
		getContentPane().add(scrDSTK = new JScrollPane(table_1, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS), BorderLayout.CENTER);
		table_1.setRowHeight(20);

		javax.swing.border.Border southbordert = BorderFactory.createLineBorder(Color.blue);
		TitledBorder southTitleBordert = new TitledBorder(southbordert, "Thông tin chung v�? thuốc");
		southTitleBordert.setTitleColor(Color.blue);
		scrDSTK.setBorder(
				new TitledBorder(null, "Danh sách thống kê", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		pnlToanPhan.add(scrDSTK);
		scrDSTK.setPreferredSize(new Dimension(0, 250));
		pnlToanPhan.setLayout(null);
		scrDSTK.setBounds(10, 248, 1510, 470);
		JPanel panel_8 = new JPanel();
		scrDSTK.setColumnHeaderView(panel_8);
		panel_8.setBackground(new Color(175, 238, 238));
		panel_8.setLayout(null);
		getContentPane().add(tabbedPane);
		getContentPane().add(tabbedPane);

		panel_BaoCao = new JPanel();
		panel_BaoCao.setBackground(SystemColor.controlHighlight);
		panel_BaoCao.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_BaoCao.setBounds(10, 715, 1510, 91);
		pnlToanPhan.add(panel_BaoCao);
		panel_BaoCao.setLayout(null);

		btnBaoCao = new JButton("Xem Báo Cáo");
		btnBaoCao.setBounds(610, 22, 255, 52);
		panel_BaoCao.add(btnBaoCao);

		btnBaoCao.setForeground(Color.BLACK);
		btnBaoCao.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBaoCao.setBackground(SystemColor.controlHighlight);

		/**
		 * Tab thuốc -Panel hình thức thống kê: +Xem thuốc hết hạn +Xem thuốc còn hạn
		 * +Xem thuốc đã bán +Xem thuốc còn trong kho -Panel báo cáo sau thống kê: +Tổng
		 * lượng thuốc +Tổng loại thuốc
		 */

		javax.swing.border.Border southborder = BorderFactory.createLineBorder(Color.blue, Font.BOLD);
		TitledBorder southTitleBorder = new TitledBorder(southborder, "Hình thức thống kê");
		southTitleBorder.setTitleColor(Color.blue);
		javax.swing.border.Border southborder1 = BorderFactory.createLineBorder(Color.blue, Font.BOLD);
		TitledBorder southTitleBorder1 = new TitledBorder(southborder1, "Báo cáo sau thống kê");
		southTitleBorder1.setTitleColor(Color.blue);
		getContentPane().setLayout(null);

		getContentPane().add(tabbedPane);

		javax.swing.border.Border southborder2 = BorderFactory.createLineBorder(Color.blue);
		TitledBorder southTitleBorder2 = new TitledBorder(southborder2, "Danh sách thuốc sau thống kê");
		southTitleBorder2.setTitleColor(Color.blue);

		pnlThongkeTTThuoc = new JPanel();
		pnlThongkeTTThuoc.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnlThongkeTTThuoc.setBackground(SystemColor.controlHighlight);

		tabbedPane.addTab("Thống kê tình trạng thuốc", pnlThongkeTTThuoc);
		pnlThongkeTTThuoc.setBounds(0, 50, 900, 240);
		pnlThongkeTTThuoc.setPreferredSize(new Dimension(0, 240));
		pnlThongkeTTThuoc.setLayout(null);
		pnlThongkeTTThuoc.setLayout(null);
		tabbedPane.setBackground(Color.CYAN);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 107, 780, 239);
		panel_2.setBackground(SystemColor.controlHighlight);
		pnlThongkeTTThuoc.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBorder(
				new TitledBorder(null, "Hình thức thống kê", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		lblNgayy = new JLabel("Ngày:");
		lblNgayy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgayy.setForeground(new Color(0, 0, 0));
		lblNgayy.setBounds(23, 29, 48, 20);
		panel_2.add(lblNgayy);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBackground(SystemColor.controlHighlight);
		panel_3.setBounds(23, 77, 740, 145);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		btnXemThuocHetHan = new JButton("Xem thuốc hết hạng");
		btnXemThuocHetHan.setHorizontalAlignment(SwingConstants.CENTER);
		btnXemThuocHetHan.setBounds(30, 14, 323, 54);
		panel_3.add(btnXemThuocHetHan);
		btnXemThuocHetHan.setBackground(SystemColor.controlHighlight);
		btnXemThuocHetHan.setForeground(new Color(0, 0, 0));
		btnXemThuocHetHan.setFont(new Font("Tahoma", Font.BOLD, 16));

		btnXemThuocDaBan = new JButton(" Xem thuốc đã bán");
		btnXemThuocDaBan.setHorizontalAlignment(SwingConstants.CENTER);
		btnXemThuocDaBan.setBounds(30, 76, 323, 54);
		panel_3.add(btnXemThuocDaBan);
		btnXemThuocDaBan.setBackground(SystemColor.controlHighlight);
		btnXemThuocDaBan.setForeground(new Color(0, 0, 0));
		btnXemThuocDaBan.setFont(new Font("Tahoma", Font.BOLD, 16));

		btnXemThuocConLai = new JButton("  Xem thuốc còn hạn sử dụng");
		btnXemThuocConLai.setHorizontalAlignment(SwingConstants.CENTER);
		btnXemThuocConLai.setBounds(380, 14, 323, 51);
		panel_3.add(btnXemThuocConLai);
		btnXemThuocConLai.setBackground(SystemColor.controlHighlight);
		btnXemThuocConLai.setForeground(new Color(0, 0, 0));
		btnXemThuocConLai.setFont(new Font("Tahoma", Font.BOLD, 16));

		btnXemthuocConLaiTrongKho = new JButton("Xem thuốc còn lại trong kho");
		btnXemthuocConLaiTrongKho.setHorizontalAlignment(SwingConstants.CENTER);
		btnXemthuocConLaiTrongKho.setBounds(380, 76, 323, 55);
		panel_3.add(btnXemthuocConLaiTrongKho);
		btnXemthuocConLaiTrongKho.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXemthuocConLaiTrongKho.setBackground(SystemColor.controlHighlight);

		txtChonNgayThongKeThuoc = new JDateChooser();
		txtChonNgayThongKeThuoc.getCalendarButton().setForeground(new Color(0, 0, 255));
		txtChonNgayThongKeThuoc.getCalendarButton().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtChonNgayThongKeThuoc.setLocale(new Locale("vi", "VN"));
		txtChonNgayThongKeThuoc.setDateFormatString("dd/MM/yyyy");
		txtChonNgayThongKeThuoc.setBounds(77, 33, 153, 20);
		txtChonNgayThongKeThuoc.setDate(new Date(System.currentTimeMillis()));

		panel_2.add(txtChonNgayThongKeThuoc);
		// Lấy thời gian thực của TKTTT
		String ngay2;
		AbstractButton datePicker1 = null;
		Date today1 = new Date(System.currentTimeMillis()); // lấy thời gian thực
		SimpleDateFormat timeFormat1 = new SimpleDateFormat("yyyy-MM-dd"); // định dạng kiểu ngày
		ngay2 = timeFormat1.format(today.getTime());

		JPanel jp = new JPanel();
		jp.setBounds(800, 107, 720, 239);
		jp.setBackground(SystemColor.controlHighlight);
		jp.setBorder(new TitledBorder(null, "Báo cáo thống kê", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThongkeTTThuoc.add(jp);
		jp.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.controlHighlight);
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBounds(23, 45, 680, 177);
		jp.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblTongSoLuongThuoc = new JLabel("Tổng số lượng thuốc");
		lblTongSoLuongThuoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTongSoLuongThuoc.setBounds(60, 38, 145, 28);
		panel_4.add(lblTongSoLuongThuoc);
		lblTongSoLuongThuoc.setForeground(new Color(0, 0, 0));

		txtTongSoLuongThuoc = new JTextField();
		txtTongSoLuongThuoc.setEditable(false);
		txtTongSoLuongThuoc.setForeground(Color.BLUE);
		txtTongSoLuongThuoc.setBounds(240, 40, 86, 20);
		panel_4.add(txtTongSoLuongThuoc);
		txtTongSoLuongThuoc.setColumns(10);

		JLabel lblTongSoLoaiThuoc = new JLabel("Tổng số loại thuốc");
		lblTongSoLoaiThuoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTongSoLoaiThuoc.setBounds(60, 88, 135, 17);
		panel_4.add(lblTongSoLoaiThuoc);
		lblTongSoLoaiThuoc.setForeground(new Color(0, 0, 0));

		txtTongSoLoaiThuoc = new JTextField();
		txtTongSoLoaiThuoc.setForeground(Color.BLUE);
		txtTongSoLoaiThuoc.setBounds(240, 90, 86, 20);
		panel_4.add(txtTongSoLoaiThuoc);
		txtTongSoLoaiThuoc.setEditable(false);
		txtTongSoLoaiThuoc.setColumns(10);

		JRadioButton radioButton = new JRadioButton("");
		radioButton.setSelected(true);
		radioButton.setBackground(SystemColor.controlHighlight);
		radioButton.setBounds(20, 40, 28, 20);
		panel_4.add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton("");
		radioButton_1.setSelected(true);
		radioButton_1.setBackground(SystemColor.controlHighlight);
		radioButton_1.setBounds(20, 90, 28, 17);
		panel_4.add(radioButton_1);

		JLabel lblNewLab = new JLabel("");
		lblNewLab.setBounds(281, 32, 296, 120);
		panel_4.add(lblNewLab);

		scrollPaneTKTTT = new JScrollPane();
		scrollPaneTKTTT.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneTKTTT.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneTKTTT.setBounds(10, 355, 1510, 450);
		pnlThongkeTTThuoc.add(scrollPaneTKTTT);

		String[] tb2 = new String[] { "Mã Thuốc", "Tên Thuốc", "Phân Loại", "Hạn Sử dụng", "Đơn vị tính", "Số lượng",
				"Đơn giá", "Ngày Sản Xuất", "Nhà cung cấp" };
		tablemodel1 = new DefaultTableModel(tb2, 0);
		table2 = new JTable(tablemodel1);
		table2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		table2.setBackground(new Color(245, 245, 220));
		table2.setForeground(Color.BLUE);
		table2.getColumnModel().getColumn(3).setPreferredWidth(95);
		table2.getColumnModel().getColumn(5).setPreferredWidth(110);
		table2.getColumnModel().getColumn(6).setPreferredWidth(121);
		scrollPaneTKTTT.setViewportView(table2);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(10, 11, 1510, 71);
		pnlThongkeTTThuoc.add(panel);

		JLabel lblT = new JLabel("THỐNG KÊ TÌNH TRẠNG THUỐC");
		lblT.setHorizontalAlignment(SwingConstants.CENTER);
		lblT.setForeground(Color.RED);
		lblT.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblT.setBounds(540, 11, 362, 49);
		panel.add(lblT);

		/**
		 * Tab Thống kê báo cáo doanh thu -Panel thông tin thống kê +Tổng tiền bán được
		 * +Tổng tiền thuốc đã nhập +Lợi nhuận thu đc
		 *
		 * -Panel xem báo cáo + nhập năm và chọn tháng + Xem báo cáo
		 */
		pnlThongKeBaoCao = new JPanel();
		pnlThongKeBaoCao.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnlThongKeBaoCao.setBackground(SystemColor.controlHighlight);
		tabbedPane.addTab("Thống kê báo cáo", pnlThongKeBaoCao);

		pnlThongKeBaoCao.setBounds(0, 50, 1510, 240);
		pnlThongKeBaoCao.setPreferredSize(new Dimension(0, 240));
		pnlThongKeBaoCao.setLayout(null);
		pnlThongKeBaoCao.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(30, 11, 1465, 265);
		panel_1.setBackground(SystemColor.controlHighlight);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlThongKeBaoCao.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 89, 367, 164);
		panel_5.setBackground(SystemColor.controlHighlight);
		panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNgayTKTQ = new JLabel("Tháng:");
		lblNgayTKTQ.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgayTKTQ.setBounds(10, 23, 59, 31);
		panel_5.add(lblNgayTKTQ);

		btnXemBCAoTKTQ = new JButton("Xem Báo Cáo");
		btnXemBCAoTKTQ.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXemBCAoTKTQ.setBackground(new Color(0, 206, 209));
		btnXemBCAoTKTQ.setBounds(74, 85, 205, 46);
		panel_5.add(btnXemBCAoTKTQ);

		// combo box 12 tháng
		comboBox = new JComboBox();
		comboBox.setForeground(new Color(0, 0, 255));
		comboBox.setBounds(79, 23, 85, 31);
		comboBox.addItem("1");
		comboBox.addItem("2");
		comboBox.addItem("3");
		comboBox.addItem("4");
		comboBox.addItem("5");
		comboBox.addItem("6");
		comboBox.addItem("7");
		comboBox.addItem("8");
		comboBox.addItem("9");
		comboBox.addItem("10");
		comboBox.addItem("11");
		comboBox.addItem("12");
		panel_5.add(comboBox);

		JLabel lblNm = new JLabel("Năm:");
		lblNm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNm.setBounds(177, 26, 59, 28);
		panel_5.add(lblNm);

		txtNam = new JTextField();
		txtNam.setForeground(new Color(0, 0, 255));
		txtNam.setBounds(245, 23, 85, 31);
		panel_5.add(txtNam);
		txtNam.setColumns(10);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(400, 89, 1055, 164);
		panel_7.setBackground(SystemColor.controlHighlight);
		panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.add(panel_7);
		panel_7.setLayout(null);

		JPanel pnlThongtinThongKeTQ = new JPanel();
		pnlThongtinThongKeTQ.setBackground(SystemColor.controlHighlight);
		pnlThongtinThongKeTQ.setBorder(
				new TitledBorder(null, "Thông tin thống kê ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThongtinThongKeTQ.setBounds(50, 29, 960, 124);
		panel_7.add(pnlThongtinThongKeTQ);
		pnlThongtinThongKeTQ.setLayout(null);

		JLabel lblTongSoLuongDaNhap = new JLabel("Tổng tiền thuốc đã nhập:");
		lblTongSoLuongDaNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTongSoLuongDaNhap.setBounds(70, 60, 300, 20);
		pnlThongtinThongKeTQ.add(lblTongSoLuongDaNhap);

		txtTongTienThuocDaNhap = new JTextField();
		txtTongTienThuocDaNhap.setForeground(new Color(0, 0, 255));
		txtTongTienThuocDaNhap.setEditable(false);
		txtTongTienThuocDaNhap.setBounds(400, 62, 241, 20);
		pnlThongtinThongKeTQ.add(txtTongTienThuocDaNhap);
		txtTongTienThuocDaNhap.setColumns(10);

		txtTongTienBanDuocTKTq = new JTextField();
		txtTongTienBanDuocTKTq.setForeground(new Color(0, 0, 255));
		txtTongTienBanDuocTKTq.setEditable(false);
		txtTongTienBanDuocTKTq.setColumns(10);
		txtTongTienBanDuocTKTq.setBounds(400, 32, 241, 20);
		pnlThongtinThongKeTQ.add(txtTongTienBanDuocTKTq);

		JLabel lblTongSoTienBanDuoc = new JLabel("Tổng tiền bán được:");
		lblTongSoTienBanDuoc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTongSoTienBanDuoc.setBounds(70, 30, 300, 20);
		pnlThongtinThongKeTQ.add(lblTongSoTienBanDuoc);

		JLabel lblLoiNhuanThuDuoc = new JLabel("Lợi nhuận thu được:");
		lblLoiNhuanThuDuoc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoiNhuanThuDuoc.setBounds(70, 90, 300, 19);
		pnlThongtinThongKeTQ.add(lblLoiNhuanThuDuoc);

		txtLoiNhuanThuDkTQ = new JTextField();
		txtLoiNhuanThuDkTQ.setForeground(new Color(0, 0, 255));
		txtLoiNhuanThuDkTQ.setEditable(false);
		txtLoiNhuanThuDkTQ.setColumns(10);
		txtLoiNhuanThuDkTQ.setBounds(400, 92, 241, 20);
		pnlThongtinThongKeTQ.add(txtLoiNhuanThuDkTQ);

		radioButton_2 = new JRadioButton("");
		radioButton_2.setSelected(true);
		radioButton_2.setBackground(SystemColor.controlHighlight);
		radioButton_2.setBounds(40, 32, 28, 11);
		pnlThongtinThongKeTQ.add(radioButton_2);

		radioButton_3 = new JRadioButton("");
		radioButton_3.setSelected(true);
		radioButton_3.setBackground(SystemColor.controlHighlight);
		radioButton_3.setBounds(40, 62, 28, 16);
		pnlThongtinThongKeTQ.add(radioButton_3);

		radioButton_4 = new JRadioButton("");
		radioButton_4.setSelected(true);
		radioButton_4.setBackground(SystemColor.controlHighlight);
		radioButton_4.setBounds(40, 92, 28, 20);
		pnlThongtinThongKeTQ.add(radioButton_4);

		JLabel label = new JLabel("");
		label.setBounds(515, 29, 320, 124);
		panel_7.add(label);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 11, 1445, 71);
		panel_6.setLayout(null);
		panel_6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_6.setBackground(SystemColor.controlHighlight);
		panel_1.add(panel_6);

		JLabel lblThngKTheo_1 = new JLabel("THỐNG KÊ THEO DOANH THU THEO THÁNG");
		lblThngKTheo_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngKTheo_1.setForeground(Color.RED);
		lblThngKTheo_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblThngKTheo_1.setBounds(438, 11, 500, 37);
		panel_6.add(lblThngKTheo_1);

		JScrollPane scrThongKeTongQuat = new JScrollPane();
		scrThongKeTongQuat.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrThongKeTongQuat.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrThongKeTongQuat.setBounds(30, 275, 1465, 530);
		pnlThongKeBaoCao.add(scrThongKeTongQuat);

		JScrollPane scrTKTQ;
		String[] tq = new String[] { "STT", "Mã Thuốc", "Tên Thuốc", "Đơn Giá Nhập", "Đơn Giá Bán", "Số Lượng Nhập",
				"Số Lượng Bán", "Tiền Nhập Thuốc", "Ngày Hết Hạn", "Tiền Bán Được" };
		tablemodel2 = new DefaultTableModel(tq, 0);
		tblThongKeTongQuat = new JTable(tablemodel2);
		tblThongKeTongQuat.setForeground(new Color(0, 0, 205));
		tblThongKeTongQuat.setBackground(new Color(255, 248, 220));
		tblThongKeTongQuat.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

		tblThongKeTongQuat.getColumnModel().getColumn(0).setPreferredWidth(37);
		tblThongKeTongQuat.getColumnModel().getColumn(1).setPreferredWidth(65);
		tblThongKeTongQuat.getColumnModel().getColumn(3).setPreferredWidth(92);
		tblThongKeTongQuat.getColumnModel().getColumn(4).setPreferredWidth(79);
		tblThongKeTongQuat.getColumnModel().getColumn(5).setPreferredWidth(133);
		tblThongKeTongQuat.getColumnModel().getColumn(6).setPreferredWidth(83);
		tblThongKeTongQuat.getColumnModel().getColumn(7).setPreferredWidth(77);
		tblThongKeTongQuat.getColumnModel().getColumn(8).setPreferredWidth(90);
		tblThongKeTongQuat.getColumnModel().getColumn(9).setPreferredWidth(105);
		scrThongKeTongQuat.setViewportView(tblThongKeTongQuat);

	}

	public static void main(String[] args) {
		new FrmQLThongKe().setVisible(true);
	}

}
