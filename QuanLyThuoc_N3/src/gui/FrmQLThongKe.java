package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import dao.NhanVien_DAO;
import entity.HoaDon;
import entity.NhanVien;

public class FrmQLThongKe extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane;
	private JPanel pnlToanPhan, panel_1;
	private JLabel lblThongTinKhachHang, lblDiaChi, lblThngKTheo, lblTongSLThuocBan, lblMaNV, lblTenNV, lblSDT, lblNN,
			lblMaKH, lblNgay, lblDonthuoc, lblTongHD;
	private JTextField txtNam, txtTenNV, txtTongSoHD, txtTongDoanhThu, txtTongSoHD1, txtTongDoanhThu1;
	private JButton btnMaKH, btnMaHD, btnXoa, btnReload, btnThoat, btnXemKQ1, btnXemKQ2;
	private JScrollPane scrDSTK;
	public static DefaultTableModel tablemodel = new DefaultTableModel();
	private JTable table_1;
	private JComboBox<Object> cboThang, cboMaNV, cboMaKH, cboMaHD;

	private HoaDon_DAO hd_DAO;
	private NhanVien_DAO nv_dao;

	private FrmManHinhChinh mhc;

	public FrmQLThongKe(FrmManHinhChinh mhc) {
		this.mhc = mhc;

		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		hd_DAO = new HoaDon_DAO();
		nv_dao = new NhanVien_DAO();

		setTitle("QuanLyThongKe");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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

		JLabel lblTieuDeTKHDTKH = new JLabel("QUẢN LÍ THỐNG KÊ");
		lblTieuDeTKHDTKH.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDeTKHDTKH.setForeground(Color.BLUE);
		lblTieuDeTKHDTKH.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTieuDeTKHDTKH.setBounds(480, 20, 538, 37);
		pnlTieuDeTKHDTHV.add(lblTieuDeTKHDTKH);

		tabbedPane.addTab("Thống kê", pnlToanPhan);
		pnlToanPhan.setLayout(null);

		// CENTER

		// LEFT

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
		cboMaKH = new JComboBox<>();
		pnlTimKiem.add(cboMaKH);
		List<HoaDon> listHD = hd_DAO.getAllHoaDon();
		for (HoaDon hd : listHD) {
			cboMaKH.addItem(hd.getKhachHang().getMaKH());
		}
		cboMaKH.setBounds(20, 30, 120, 30);

		btnMaKH = new JButton("Tìm mã KH");
		pnlTimKiem.add(btnMaKH);
		btnMaKH.setBounds(160, 30, 120, 30);

		cboMaHD = new JComboBox<>();
		pnlTimKiem.add(cboMaHD);
		List<HoaDon> listHD1 = hd_DAO.getAllHoaDon();
		for (HoaDon hd : listHD1) {
			cboMaHD.addItem(hd.getMaHD());
		}
		cboMaHD.setBounds(20, 90, 120, 30);

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

		btnXoa = new JButton("XÓA HÓA ĐƠN ");
		pnlChucNang.add(btnXoa);
		btnXoa.setBounds(75, 30, 150, 30);

		btnReload = new JButton("TẢI LẠI");
		pnlChucNang.add(btnReload);
		btnReload.setBounds(20, 90, 120, 30);

		btnThoat = new JButton("QUAY LẠI");
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

		cboThang = new JComboBox();
		cboThang.setBounds(130, 40, 130, 28);
		cboThang.addItem("1");
		cboThang.addItem("2");
		cboThang.addItem("3");
		cboThang.addItem("4");
		cboThang.addItem("5");
		cboThang.addItem("6");
		cboThang.addItem("7");
		cboThang.addItem("8");
		cboThang.addItem("9");
		cboThang.addItem("10");
		cboThang.addItem("11");
		cboThang.addItem("12");
		pnlThongKeThang.add(cboThang);

		JLabel lblNam = new JLabel("Năm:");
		lblNam.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNam.setBounds(20, 90, 59, 28);
		pnlThongKeThang.add(lblNam);

		txtNam = new JTextField();
		txtNam.setForeground(new Color(0, 0, 255));
		txtNam.setBounds(130, 90, 130, 28);
		pnlThongKeThang.add(txtNam);
		txtNam.setColumns(10);

		btnXemKQ1 = new JButton("XEM KẾT QUẢ");
		pnlThongKeThang.add(btnXemKQ1);
		btnXemKQ1.setBounds(80, 135, 150, 30);

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

		cboMaNV = new JComboBox<>();
		pnlThongKeNV.add(cboMaNV);
		List<NhanVien> listHD2 = nv_dao.getAllNhanVien();
		for (NhanVien nv : listHD2) {
			cboMaNV.addItem(nv.getMaNV());
		}
		cboMaNV.setBounds(160, 40, 130, 28);
		pnlThongKeNV.add(cboMaNV);

		JLabel lbltenNV = new JLabel("Tên Nhân Viên:");
		lbltenNV.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbltenNV.setBounds(20, 90, 100, 28);
		pnlThongKeNV.add(lbltenNV);

		txtTenNV = new JTextField();
		txtTenNV.setForeground(new Color(0, 0, 255));
		txtTenNV.setEditable(false);
		txtTenNV.setBounds(160, 90, 130, 28);
		pnlThongKeNV.add(txtTenNV);
		txtTenNV.setColumns(50);

		btnXemKQ2 = new JButton("XEM KẾT QUẢ");
		pnlThongKeNV.add(btnXemKQ2);
		btnXemKQ2.setBounds(80, 135, 150, 30);

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

		// set icon
		btnMaKH.setIcon(new ImageIcon("src/img/Search-icon.png"));
		btnMaHD.setIcon(new ImageIcon("src/img/Search-icon.png"));
		btnXoa.setIcon(new ImageIcon("src/img/xoa.png"));
		btnReload.setIcon(new ImageIcon("src/img/taiLai.png"));
		btnThoat.setIcon(new ImageIcon("src/img/quayLai.png"));
		btnXemKQ1.setIcon(new ImageIcon("src/img/xem.png"));
		btnXemKQ2.setIcon(new ImageIcon("src/img/xem.png"));

		// RIGHT

		// danh sách thống kê và nút báo cáo
		JScrollPane scrDSTK;
		String[] tb1 = new String[] { "STT", "Mã Hóa đơn", "Ngày lập Hóa Đơn", "Mã Khách Hàng", "Mã Nhân Viên",
				"Thành Tiền" };
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
		thongKeHoaDon();

		// thêm sự kiện
		btnMaKH.addActionListener(this);
		btnMaHD.addActionListener(this);
		btnReload.addActionListener(this);
		btnThoat.addActionListener(this);
		btnXemKQ1.addActionListener(this);
		btnXemKQ2.addActionListener(this);
		cboMaNV.addActionListener(this);
		btnXoa.addActionListener(this);
	}

	// Thêm data
	public void addData() {
		HoaDon h = new HoaDon();
		int stt = 0;
		hd_DAO = new HoaDon_DAO();
		List<HoaDon> listHd = hd_DAO.getAllHoaDon();
		for (HoaDon hd : listHd) {
			tablemodel.addRow(new Object[] { ++stt, hd.getMaHD(), hd.getNgayLapHD(), hd.getKhachHang().getMaKH(),
					hd.getNhanVien().getMaNV(), });
		}

	}

	// Load lại data
	public void reloadData() {
		tablemodel.setRowCount(0); // Xóa hết các dòng trong bảng
		int stt = 0;
		hd_DAO = new HoaDon_DAO();
		List<HoaDon> listHd = hd_DAO.getAllHoaDon();
		for (HoaDon hd : listHd) {
			tablemodel.addRow(new Object[] { ++stt, hd.getMaHD(), hd.getNgayLapHD(), hd.getKhachHang().getMaKH(),
					hd.getNhanVien().getMaNV() });// Thêm dòng vào bảng
		}
	}

	// xử lý thống kê hóa đơn
	public void thongKeHoaDon() {
		int rowCount = table_1.getRowCount(); // lấy số hàng của table_1
		txtTongSoHD1.setText(String.valueOf(rowCount)); // hiển thị tổng số hóa đơn
	}

	// xử lý thống kê hóa đơn vào kết quả
	public void thongKeHoaDonKQ() {
		int rowCount = table_1.getRowCount(); // lấy số hàng của table_1
		txtTongSoHD.setText(String.valueOf(rowCount)); // hiển thị tổng số hóa đơn
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnMaKH)) {
			String maKH = cboMaKH.getSelectedItem().toString();
			List<HoaDon> listHd = hd_DAO.getHDtheoKH(maKH);
			tablemodel.setRowCount(0);
			int stt = 0;
			for (HoaDon hd : listHd) {
				tablemodel.addRow(new Object[] { ++stt, hd.getMaHD(), hd.getNgayLapHD(), hd.getKhachHang().getMaKH(),
						hd.getNhanVien().getMaNV() });
			}
			thongKeHoaDon();
		}
		if (o.equals(btnMaHD)) {
			String maHD = cboMaHD.getSelectedItem().toString();
			List<HoaDon> listHd = hd_DAO.getHDTheoHD(maHD);
			tablemodel.setRowCount(0);
			int stt = 0;
			for (HoaDon hd : listHd) {
				tablemodel.addRow(new Object[] { ++stt, hd.getMaHD(), hd.getNgayLapHD(), hd.getKhachHang().getMaKH(),
						hd.getNhanVien().getMaNV() });
			}
			thongKeHoaDon();
		}
		if (o.equals(btnReload)) {
			reloadData();
			thongKeHoaDon();
			txtTongSoHD.setText(null);
			txtNam.setText("");
			txtTenNV.setText("");
		}
		if (o.equals(btnThoat)) {
			mhc.display();
			setVisible(false);
		}
		if (o.equals(btnXemKQ1)) {
			int month = Integer.parseInt((String) cboThang.getSelectedItem());
			if (txtNam.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập năm!", "Thông báo", JOptionPane.WARNING_MESSAGE);
			} else {
				int year = Integer.parseInt(txtNam.getText());
				List<HoaDon> listHd = hd_DAO.getHoaDonTheoThangNam(month, year);
				tablemodel.setRowCount(0);
				int stt = 0;
				if (listHd.size() == 0) {
					JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn nào trong tháng và năm đã chọn!",
							"Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else {
					for (HoaDon hd : listHd) {
						tablemodel.addRow(new Object[] { ++stt, hd.getMaHD(), hd.getNgayLapHD(),
								hd.getKhachHang().getMaKH(), hd.getNhanVien().getMaNV() });
					}
					thongKeHoaDon();
					thongKeHoaDonKQ();
				}

			}
		}

		if (o.equals(btnXemKQ2)) {
			String maNV = cboMaNV.getSelectedItem().toString();
			List<HoaDon> listHd = hd_DAO.getHDTheoNV(maNV);
			tablemodel.setRowCount(0);
			int stt = 0;
			for (HoaDon hd : listHd) {
				tablemodel.addRow(new Object[] { ++stt, hd.getMaHD(), hd.getNgayLapHD(), hd.getKhachHang().getMaKH(),
						hd.getNhanVien().getMaNV() });
			}
			thongKeHoaDon();
			thongKeHoaDonKQ();
		}
		if (o.equals(cboMaNV)) {
			String ma = cboMaNV.getSelectedItem().toString();
			ArrayList<NhanVien> dsNV = nv_dao.getAllNhanVien();
			for (NhanVien nv : dsNV) {
				if (nv.getMaNV().equals(ma)) {
					txtTenNV.setText(nv.getHoNV() + " " + nv.getTenNV());
				}
			}

		}
		if (o.equals(btnXoa)) {
			int row = table_1.getSelectedRow(); // Lấy dòng được chọn trong bảng
			if (row >= 0) {
				String maHD = String.valueOf(table_1.getValueAt(row, 0)); // Lấy mã hóa đơn của dòng được chọn dưới dạng
																			// String
				if (hd_DAO.xoaTheoMaHD(maHD)) { // Xóa hóa đơn khỏi cơ sở dữ liệu
					tablemodel.removeRow(row); // Xóa dòng được chọn khỏi bảng
					JOptionPane.showMessageDialog(null, "Xóa hóa đơn thành công!", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Xóa hóa đơn thất bại!", "Thông báo",
							JOptionPane.ERROR_MESSAGE);
				}
			} else { // Nếu không có dòng nào được chọn
				JOptionPane.showMessageDialog(null, "Vui lòng chọn hóa đơn cần xóa!", "Thông báo",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
