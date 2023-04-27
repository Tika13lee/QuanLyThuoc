package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.components.JTitlePanel;

import connect.ConnectDB;

import java.util.*;

import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import entity.HoaDon;
import entity.KhachHang;

public class FrmQLThongKe extends JFrame implements ActionListener  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane;
	private JPanel pnlToanPhan, panel_1;
	private JLabel lblThongTinKhachHang, lblDiaChi, lblThngKTheo, lblTongSLThuocBan, lblMaNV, lblTenNV, lblSDT, lblNN,
			lblMakh, lblNgay, lblDonthuoc, lblTongHD;
	private JTextField txtDiaChi, txtTenKH, txtMaKH, txtNN, txtSDT, txtMakn, txtNam, txtTenNV, txtTongSoHD,
			txtTongDoanhThu, txtTongSoHD1, txtTongDoanhThu1;
	private JButton btnMaKH, btnMaHD, btnXoa, btnXoa2, btnReload, btnThoat, btnXemKQ1, btnXemKQ2;
	private JScrollPane scrDSTK;
	public static DefaultTableModel tablemodel = new DefaultTableModel();
	public static DefaultTableModel tablemodel1 = new DefaultTableModel();
	DefaultTableModel tablemodel2 = new DefaultTableModel();
	private JTable table_1;
	String s;
	private JComboBox<Object> cmbThang, cmbMaNV, cmbMaKH, cmbNgay, cmbMaHD;
	private HoaDon_DAO hd_DAO;
	private KhachHang_DAO kh_DAO;

	public FrmQLThongKe() {
		
		
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		hd_DAO = new HoaDon_DAO();
		setTitle("Quản Lí Hiệu Thuốc");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setResizable(false);

		// tạo tab
		tabbedPane = new JTabbedPane();
		tabbedPane.setForeground(new Color(0, 128, 128));
		tabbedPane.setBounds(0, 0, 1535, 840);
		tabbedPane.setBorder(null);

		// NORTH

		// panel tổng
		pnlToanPhan = new JPanel();
		pnlToanPhan.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlToanPhan.setBackground(SystemColor.controlHighlight);

		JPanel pnlTieuDeTKHDTHV = new JPanel();
		pnlTieuDeTKHDTHV.setBackground(SystemColor.controlHighlight);
		pnlTieuDeTKHDTHV.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnlTieuDeTKHDTHV.setBounds(10, 11, 1510, 71);
		pnlToanPhan.add(pnlTieuDeTKHDTHV);
		pnlTieuDeTKHDTHV.setLayout(null);

		JLabel lblTieuDeTKHDTKH = new JLabel("QUẢN LÍ BÁN HÀNG");
		lblTieuDeTKHDTKH.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDeTKHDTKH.setForeground(Color.BLUE);
		lblTieuDeTKHDTKH.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTieuDeTKHDTKH.setBounds(480, 20, 538, 37);
		pnlTieuDeTKHDTHV.add(lblTieuDeTKHDTKH);

		tabbedPane.addTab("Thống kê", pnlToanPhan);
		pnlToanPhan.setLayout(null);

		// CENTER
		
		//LEFT

		// Các ô thao thác chức năng
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 93, 650, 157);
		panel_1.setBackground(SystemColor.controlHighlight);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlToanPhan.add(panel_1);
		panel_1.setLayout(null);
		// Ô tìm kiếm
		JPanel pnlTimKiem = new JPanel();
		pnlTimKiem.setBackground(SystemColor.controlHighlight);
		pnlTimKiem.setBorder(new TitledBorder(null, "Tìm kiếm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlTimKiem.setBounds(12, 10, 300, 140);
		panel_1.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		// Chi tiết ô tìm kiếm
		cmbMaKH = new JComboBox<>();
		pnlTimKiem.add(cmbMaKH);
		List<HoaDon> listHD = hd_DAO.getAllHoaDon();
		for (HoaDon hd: listHD)
		{
			cmbMaKH.addItem(hd.getKhachHang().getMaKH());
		}
		cmbMaKH.setBounds(20, 30, 120, 30);

		btnMaKH = new JButton("Tìm mã KH");
		pnlTimKiem.add(btnMaKH);
		btnMaKH.setBounds(160, 30, 120, 30);

		cmbMaHD = new JComboBox<>();
		pnlTimKiem.add(cmbMaHD);
		List<HoaDon> listHD1 = hd_DAO.getAllHoaDon();
		for (HoaDon hd: listHD1)
		{
			cmbMaHD.addItem(hd.getMaHD());
		}
		cmbMaHD.setBounds(20, 90, 120, 30);

		btnMaHD = new JButton("Tìm mã HD");
		pnlTimKiem.add(btnMaHD);
		btnMaHD.setBounds(160, 90, 120, 30);

		// Ô chức năng
		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBackground(SystemColor.controlHighlight);
		pnlChucNang.setBorder(new TitledBorder(null, "Chức năng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlChucNang.setBounds(330, 10, 300, 140);
		panel_1.add(pnlChucNang);
		pnlChucNang.setLayout(null);

		btnXoa = new JButton("Xóa");
		pnlChucNang.add(btnXoa);
		btnXoa.setBounds(20, 30, 120, 30);

		btnXoa2 = new JButton("???");
		pnlChucNang.add(btnXoa2);
		btnXoa2.setBounds(160, 30, 120, 30);

		btnReload = new JButton("Tải lại");
		pnlChucNang.add(btnReload);
		btnReload.setBounds(20, 90, 120, 30);

		btnThoat = new JButton("Thoát");
		pnlChucNang.add(btnThoat);
		btnThoat.setBounds(160, 90, 120, 30);

		// Các ô thống kê
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 260, 650, 355);
		panel_2.setBackground(SystemColor.controlHighlight);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlToanPhan.add(panel_2);
		panel_2.setLayout(null);

		// Ô thống kê theo tháng
		JPanel pnlThongKeThang = new JPanel();
		pnlThongKeThang.setBackground(SystemColor.controlHighlight);
		pnlThongKeThang.setBorder(
				new TitledBorder(null, "Thống kê theo tháng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThongKeThang.setBounds(12, 10, 300, 180);
		panel_2.add(pnlThongKeThang);
		pnlThongKeThang.setLayout(null);

		// Chi tiết ô thống kê theo tháng
		JLabel lblThang = new JLabel("Tháng:");
		lblThang.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblThang.setBounds(20, 40, 59, 28);
		pnlThongKeThang.add(lblThang);

		cmbThang = new JComboBox();
		cmbThang.setBounds(130, 40, 130, 28);
		cmbThang.addItem("1");
		cmbThang.addItem("2");
		cmbThang.addItem("3");
		cmbThang.addItem("4");
		cmbThang.addItem("5");
		cmbThang.addItem("6");
		cmbThang.addItem("7");
		cmbThang.addItem("8");
		cmbThang.addItem("9");
		cmbThang.addItem("10");
		cmbThang.addItem("11");
		cmbThang.addItem("12");
		pnlThongKeThang.add(cmbThang);

		JLabel lblNam = new JLabel("Năm:");
		lblNam.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNam.setBounds(20, 90, 59, 28);
		pnlThongKeThang.add(lblNam);

		txtNam = new JTextField();
		txtNam.setForeground(new Color(0, 0, 255));
		txtNam.setBounds(130, 90, 130, 28);
		pnlThongKeThang.add(txtNam);
		txtNam.setColumns(10);

		btnXemKQ1 = new JButton("Xem Kết Quả");
		pnlThongKeThang.add(btnXemKQ1);
		btnXemKQ1.setBounds(80, 135, 120, 30);

		// Ô thống kê theo nhân viên
		JPanel pnlThongKeNV = new JPanel();
		pnlThongKeNV.setBackground(SystemColor.controlHighlight);
		pnlThongKeNV.setBorder(
				new TitledBorder(null, "Thống kê theo nhân viên", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThongKeNV.setBounds(330, 10, 300, 180);
		panel_2.add(pnlThongKeNV);
		pnlThongKeNV.setLayout(null);

		// Chi tiết ô thống kê theo nhân viên
		JLabel lblMaNV = new JLabel("Mã Nhân Viên:");
		lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMaNV.setBounds(20, 40, 100, 28);
		pnlThongKeNV.add(lblMaNV);

		cmbMaNV = new JComboBox();
		cmbMaNV.setBounds(160, 40, 130, 28);
		cmbMaNV.addItem("Tất cả");
		pnlThongKeNV.add(cmbMaNV);

		JLabel lbltenNV = new JLabel("Tên Nhân Viên:");
		lbltenNV.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbltenNV.setBounds(20, 90, 100, 28);
		pnlThongKeNV.add(lbltenNV);

		txtTenNV = new JTextField();
		txtTenNV.setForeground(new Color(0, 0, 255));
		txtTenNV.setBounds(160, 90, 130, 28);
		pnlThongKeNV.add(txtTenNV);
		txtTenNV.setColumns(50);

		btnXemKQ2 = new JButton("Xem Kết Quả");
		pnlThongKeNV.add(btnXemKQ2);
		btnXemKQ2.setBounds(80, 135, 120, 30);

		// Ô kết quả
		JPanel pnlKetQua = new JPanel();
		pnlKetQua.setBackground(SystemColor.controlHighlight);
		pnlKetQua.setBorder(new TitledBorder(null, "Kết quả", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlKetQua.setBounds(10, 190, 620, 155);
		panel_2.add(pnlKetQua);
		pnlKetQua.setLayout(null);

		// chi tiết ô kết quả

		JLabel lblTongHD = new JLabel("Tổng số hóa đơn:");
		lblTongHD.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTongHD.setBounds(60, 40, 150, 28);
		pnlKetQua.add(lblTongHD);

		txtTongSoHD = new JTextField();
		txtTongSoHD.setForeground(new Color(0, 0, 255));
		txtTongSoHD.setEditable(false);
		txtTongSoHD.setBounds(200, 40, 150, 28);
		pnlKetQua.add(txtTongSoHD);
		txtTongSoHD.setColumns(10);

		JLabel lblTongDT = new JLabel("Tổng doanh thu:");
		lblTongDT.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTongDT.setBounds(60, 100, 150, 28);
		pnlKetQua.add(lblTongDT);

		txtTongDoanhThu = new JTextField();
		txtTongDoanhThu.setForeground(new Color(0, 0, 255));
		txtTongDoanhThu.setEditable(false);
		txtTongDoanhThu.setBounds(200, 100, 150, 28);
		pnlKetQua.add(txtTongDoanhThu);
		txtTongDoanhThu.setColumns(10);

		// Ô thống kê tổng quát (khung)
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 626, 650, 175);
		panel_3.setBackground(SystemColor.controlHighlight);
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlToanPhan.add(panel_3);
		panel_3.setLayout(null);

		// Ô thống kê tống quát
		JPanel pnlThongKeTongQuat = new JPanel();
		pnlThongKeTongQuat.setBackground(SystemColor.controlHighlight);
		pnlThongKeTongQuat.setBorder(
				new TitledBorder(null, "Thống kê tổng quát", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThongKeTongQuat.setBounds(12, 10, 620, 150);
		panel_3.add(pnlThongKeTongQuat);
		pnlThongKeTongQuat.setLayout(null);

		// Chi tiết ô thống kê tổng quát

		JLabel lblTongHD1 = new JLabel("Tổng số hóa đơn:");
		lblTongHD1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTongHD1.setBounds(60, 40, 150, 28);
		pnlThongKeTongQuat.add(lblTongHD1);

		txtTongSoHD1 = new JTextField();
		txtTongSoHD1.setForeground(new Color(0, 0, 255));
		txtTongSoHD1.setEditable(false);
		txtTongSoHD1.setBounds(200, 40, 150, 28);
		pnlThongKeTongQuat.add(txtTongSoHD1);
		txtTongSoHD1.setColumns(10);

		JLabel lblTongDT1 = new JLabel("Tổng doanh thu:");
		lblTongDT1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTongDT1.setBounds(60, 100, 150, 28);
		pnlThongKeTongQuat.add(lblTongDT1);

		txtTongDoanhThu1 = new JTextField();
		txtTongDoanhThu1.setForeground(new Color(0, 0, 255));
		txtTongDoanhThu1.setEditable(false);
		txtTongDoanhThu1.setBounds(200, 100, 150, 28);
		pnlThongKeTongQuat.add(txtTongDoanhThu1);
		txtTongDoanhThu1.setColumns(10);

		
		//RIGHT
		
		// danh sách thống kê và nút báo cáo
		JScrollPane scrDSTK;
		String[] tb1 = new String[] { "STT", "Mã Hóa đơn", "Ngày lập Hóa Đơn", "Mã Khách Hàng" ,"Mã Nhân Viên", "Thành Tiền"};
		tablemodel = new DefaultTableModel(tb1, 0);
		table_1 = new JTable(tablemodel);
		table_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
//		table_1.setBackground(new Color(255, 250, 205));
//		table_1.setForeground(new Color(0, 0, 205));
		getContentPane().add(scrDSTK = new JScrollPane(table_1, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS), BorderLayout.CENTER);
		table_1.setRowHeight(20);

		javax.swing.border.Border southbordert = BorderFactory.createLineBorder(Color.blue);
		TitledBorder southTitleBordert = new TitledBorder(southbordert, "Thông tin chung về hoá đơn");
		southTitleBordert.setTitleColor(Color.blue);
		scrDSTK.setBorder(
				new TitledBorder(null, "Danh sách thống kê", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		
		pnlToanPhan.add(scrDSTK);
		scrDSTK.setPreferredSize(new Dimension(0, 250));
		pnlToanPhan.setLayout(null);
		scrDSTK.setBounds(670, 90, 850, 720);
		JPanel panel_8 = new JPanel();
		scrDSTK.setColumnHeaderView(panel_8);
		panel_8.setBackground(new Color(175, 238, 238));
		panel_8.setLayout(null);
		getContentPane().add(tabbedPane);
		
		
		
		addData();
		
		
		
		//thêm sự kiện
		btnMaKH.addActionListener(this);
		btnMaHD.addActionListener(this);
		btnReload.addActionListener(this);
		btnThoat.addActionListener(this);
	}
	
	
	
	public void addData() {
		HoaDon h = new HoaDon();
		int stt = 0;
		hd_DAO = new HoaDon_DAO();
		List<HoaDon> listHd = hd_DAO.getAllHoaDon();
		for(HoaDon hd : listHd)
		{
			tablemodel.addRow(new Object[] {++stt, hd.getMaHD(), hd.getNgayLapHD(), hd.getNhanVien().getMaNV(), 
					hd.getKhachHang().getMaKH()});
		}
		
	}
	public void reloadData() {
	    tablemodel.setRowCount(0); // Xóa hết các dòng trong bảng
	    int stt = 0;
	    hd_DAO = new HoaDon_DAO();
	    List<HoaDon> listHd = hd_DAO.getAllHoaDon();
	    for (HoaDon hd : listHd) {
	    	tablemodel.addRow(new Object[] {++stt, hd.getMaHD(), hd.getNgayLapHD(), hd.getNhanVien().getMaNV(), 
					hd.getKhachHang().getMaKH()});// Thêm dòng vào bảng
	    }
	}

	public static void main(String[] args) {
		new FrmQLThongKe().setVisible(true);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
	    Object o = e.getSource();
	    if (o.equals(btnMaKH)) {
	    	String maKH = cmbMaKH.getSelectedItem().toString();
	    	List<HoaDon> listHd = hd_DAO.getHDtheoKH(maKH);
	    	tablemodel.setRowCount(0);
	    	int stt = 0;
	    	for (HoaDon hd : listHd) {
	    	    tablemodel.addRow(new Object[] { ++stt, hd.getMaHD(), hd.getNgayLapHD(), hd.getNhanVien().getMaNV(),
	    	            hd.getKhachHang().getMaKH() });
	    	}

	    }
	    if (o.equals(btnMaHD)) {
	    	String maHD = cmbMaHD.getSelectedItem().toString();
	    	List<HoaDon> listHd = hd_DAO.getHDTheoHD(maHD);
	    	tablemodel.setRowCount(0);
	    	int stt = 0;
	    	for (HoaDon hd : listHd) {
	    	    tablemodel.addRow(new Object[] { ++stt, hd.getMaHD(), hd.getNgayLapHD(), hd.getNhanVien().getMaNV(),
	    	            hd.getKhachHang().getMaKH() });
	    	}

	    }
	    if (o.equals(btnReload)) {
	    	 reloadData();
	    }
	    if(o.equals(btnThoat)) {
	    	setVisible(false);
	    	new FrmManHinhChinh().setVisible(true);
	    }
	}
	

}
