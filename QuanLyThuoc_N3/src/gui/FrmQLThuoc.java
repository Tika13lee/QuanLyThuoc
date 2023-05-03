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
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import connect.ConnectDB;
import dao.NhaCungCap_DAO;
import dao.Thuoc_DAO;
import entity.NhaCungCap;
import entity.Thuoc;

public class FrmQLThuoc extends JFrame implements ActionListener, MouseListener, DocumentListener {
	private JLabel lblTitle, lblMaThuoc, lblTenThuoc, lblPhanLoai, lblhanSD, lbldonViTinh, lblSoLuong, lblDonGia,
			lblngaySX, lblnhaCC, lblDonViTinh, lblTimTheoMa, lblTimTheoTen;
	private JTextField txtMaThuoc, txtTenThuoc, txtSoLuong, txtDonGia, txtTimKiem, txtngaySX, txtNgayHH, txtTimTheoTen;
	private JButton btnLamMoi, btnThoat, btnThem, btnSua, btnXoa, btnTaiLai, btnCheck, btnLocMaNCC, btnLocPhanLoai;
	private JDateChooser jdcNgaySX, jdcNgayHH;
	private JComboBox<String> cboPhanLoai, cboNhaCC, cboDonViTinh, cboMaThuoc;
	private DefaultTableModel model;
	private JTable table;

	private Thuoc_DAO thuoc_dao;
	private NhaCungCap_DAO ncc_dao;

	private FrmManHinhChinh mhc;
	private JButton btnLocTacDung;
	private JComboBox<String> cboTacDung;

	public FrmQLThuoc(FrmManHinhChinh mhc) {
		this.mhc = mhc;

		setTitle("QuanLyThuoc");
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
		Box bLeftCha = new Box(BoxLayout.X_AXIS);
		bLeftCha.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		Box bLeft = new Box(BoxLayout.Y_AXIS);
		bLeftCha.add(bLeft);

		// box ba bên phải (chức năng tìm kiếm)
		Box bRightCha = new Box(BoxLayout.X_AXIS);
		bRightCha.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		Box bRight = new Box(BoxLayout.Y_AXIS);
		bRight.setBorder(BorderFactory.createTitledBorder("Tìm kiếm thông tin thuốc:"));
		bRightCha.add(bRight);
		bLeft.setBorder(BorderFactory.createTitledBorder("Thông tin thuốc"));

		// tạo 4 box con bb
		Box b1 = new Box(BoxLayout.X_AXIS);
		Box b2 = new Box(BoxLayout.X_AXIS);
		Box b3 = new Box(BoxLayout.X_AXIS);
		Box b4 = new Box(BoxLayout.X_AXIS);

		// tiêu đề
		JPanel pnTieuDe = new JPanel();
		lblTitle = new JLabel("QUẢN LÝ THUỐC");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitle.setForeground(Color.blue);
		pnTieuDe.add(lblTitle);
		pnTieuDe.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));//

		b1.add(lblMaThuoc = new JLabel("Mã thuốc:"));
		b1.add(txtMaThuoc = new JTextField());
		txtMaThuoc.setEditable(false); // set chỉ được đọc
		b1.add(Box.createHorizontalStrut(20));
		b1.add(lblTenThuoc = new JLabel("Tên thuốc:"));
		b1.add(txtTenThuoc = new JTextField());

		b2.add(lblSoLuong = new JLabel("Số lượng:"));
		b2.add(txtSoLuong = new JTextField());
		b2.add(Box.createHorizontalStrut(20));
		b2.add(lblDonGia = new JLabel("Đơn giá:"));
		b2.add(txtDonGia = new JTextField());

		b3.add(lblngaySX = new JLabel("Ngày sản xuất:"));
		b3.add(jdcNgaySX = new JDateChooser());
		jdcNgaySX.setLocale(new Locale("vi", "VN"));
		jdcNgaySX.setDateFormatString("yyyy-MM-dd");
		b3.add(Box.createHorizontalStrut(20));
		b3.add(lblhanSD = new JLabel("Ngày hết hạn:"));
		b3.add(jdcNgayHH = new JDateChooser());
		jdcNgayHH.setLocale(new Locale("vi", "VN"));
		jdcNgayHH.setDateFormatString("yyyy-MM-dd");

		b4.add(lblnhaCC = new JLabel("Nhà cung cấp:"));
		b4.add(cboNhaCC = new JComboBox<String>());
		b4.add(Box.createHorizontalStrut(10));

		b4.add(lblPhanLoai = new JLabel("Qui định:"));
		cboPhanLoai = new JComboBox<String>();
		b4.add(cboPhanLoai);
		cboPhanLoai.addItem("Kê đơn");
		cboPhanLoai.addItem("Không kê đơn");
		b4.add(Box.createHorizontalStrut(10));

		b4.add(lblPhanLoai = new JLabel("Tác dụng:"));
		String[] str = { "Kháng sinh", "Giảm đau", "Tim mạch", "Chống dị ứng", "Thần kinh", "Hỗ trợ tiêu hóa" };
		b4.add(cboTacDung = new JComboBox<String>(str));
		b4.add(Box.createHorizontalStrut(10));

		b4.add(lblDonViTinh = new JLabel("Đơn vị tính:"));
		b4.add(cboDonViTinh = new JComboBox<String>());
		cboDonViTinh.addItem("milligram");

		// thêm và design kích thước các component
		b.add(Box.createVerticalStrut(15));
		bLeft.add(b1);
		bLeft.add(Box.createVerticalStrut(15));
		bLeft.add(b2);
		bLeft.add(Box.createVerticalStrut(15));
		bLeft.add(b3);
		bLeft.add(Box.createVerticalStrut(15));
		bLeft.add(b4);
		bLeft.add(Box.createVerticalStrut(15));

		bLeft.add(Box.createVerticalStrut(15));

		b.add(bLeftCha);

		// chức năng tìm kiếm
		Box ba1 = new Box(BoxLayout.X_AXIS);
		ba1.add(lblTimTheoTen = new JLabel("Tìm theo tên:"));
		ba1.add(Box.createHorizontalStrut(10));
		ba1.add(txtTimTheoTen = new JTextField(10));
		ba1.add(Box.createHorizontalStrut(20));

		Box ba2 = new Box(BoxLayout.X_AXIS);
		ba2.add(lblTimTheoMa = new JLabel("Tìm theo mã:"));
		ba2.add(Box.createHorizontalStrut(10));
		ba2.add(cboMaThuoc = new JComboBox<String>());
		ba2.add(Box.createHorizontalStrut(20));

		Box ba3 = new Box(BoxLayout.X_AXIS);
		ba3.add(Box.createHorizontalStrut(20));
		ba3.add(btnCheck = new JButton("Kiểm tra tình trạng thuốc"));
		ba3.add(Box.createHorizontalStrut(20));

		Box ba4 = new Box(BoxLayout.X_AXIS);
		ba4.add(btnLocMaNCC = new JButton("Lọc theo mã nhà cung cấp"));
		ba4.add(Box.createHorizontalStrut(20));
		ba4.add(btnLocPhanLoai = new JButton("Lọc theo qui định"));
		ba4.add(Box.createHorizontalStrut(20));
		ba4.add(btnLocTacDung = new JButton("Lọc theo tác dụng"));

		bRight.add(Box.createVerticalStrut(10));
		bRight.add(ba4);
		bRight.add(Box.createVerticalStrut(20));
		bRight.add(ba1);
		bRight.add(Box.createVerticalStrut(10));
		bRight.add(ba2);
		bRight.add(Box.createVerticalStrut(20));
		bRight.add(ba3);
		bRight.add(Box.createVerticalStrut(20));

		//
		b.add(Box.createHorizontalStrut(50));
		b.add(bRightCha);
		b.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		bAll.add(pnTieuDe);
		bAll.add(Box.createVerticalStrut(10));
		bAll.add(b);
		bAll.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

		// design kích thước
		lblMaThuoc.setPreferredSize(new Dimension(100, 20));

		lblSoLuong.setPreferredSize(new Dimension(100, 20));
		lblngaySX.setPreferredSize(new Dimension(100, 20));
		lblnhaCC.setPreferredSize(new Dimension(100, 20));

		lblTenThuoc.setPreferredSize(new Dimension(100, 20));
		lblDonGia.setPreferredSize(new Dimension(100, 20));
		lblhanSD.setPreferredSize(new Dimension(100, 20));

		bRight.setPreferredSize(new Dimension(400, 200));

		// bảng dữ liệu thuốc (center)
		String[] cols = { "STT", "Mã thuốc", "Tên thuốc", "Số lượng", "Đơn giá", "Ngày sản xuất", "Ngày hết hạn",
				"Nhà cung cấp", "Qui định", "Tác dụng", "Đơn vị tính" };
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		JScrollPane scr = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scr.setBorder(BorderFactory.createTitledBorder("Danh sách thuốc"));

		// gọi hàm đổ dl vào bảng
		DocDuLieuDBVaoTable();

		// gọi hàm đổ dl vào cbo
		ArrayList<Thuoc> listThuoc = thuoc_dao.getAllThuoc();
		for (Thuoc t : listThuoc) {
			cboMaThuoc.addItem(t.getMaThuoc());
		}
		ArrayList<NhaCungCap> listNCC = ncc_dao.getAllNhaCungCap();
		for (NhaCungCap ncc : listNCC) {
			cboNhaCC.addItem(ncc.getMaNCC());
		}

		// south
		JPanel pnSouth = new JPanel();
		pnSouth.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JPanel pnChucnang = new JPanel();
		pnChucnang.setBorder(BorderFactory.createTitledBorder("Chức năng"));
		pnChucnang.add(btnThem = new JButton("THÊM THUỐC"));
		pnChucnang.add(btnXoa = new JButton("XÓA THUỐC"));
		pnChucnang.add(btnSua = new JButton("CẬP NHẬT"));
		pnChucnang.add(btnLamMoi = new JButton("LÀM MỚI"));
		pnChucnang.add(btnTaiLai = new JButton("TẢI LẠI"));
		pnChucnang.add(btnThoat = new JButton("QUAY LẠI"));
		pnSouth.add(pnChucnang);

		// set Icon
		btnThem.setIcon(new ImageIcon("src/img/them.png"));
		btnXoa.setIcon(new ImageIcon("src/img/xoa.png"));
		btnSua.setIcon(new ImageIcon("src/img/capNhat.png"));
		btnThoat.setIcon(new ImageIcon("src/img/quayLai.png"));
		btnTaiLai.setIcon(new ImageIcon("src/img/taiLai.png"));
		btnLamMoi.setIcon(new ImageIcon("src/img/xoaTrang.png"));
		btnCheck.setIcon(new ImageIcon("src/img/canhBao.png"));

		pn.add(bAll, BorderLayout.NORTH);
		pn.add(pnSouth, BorderLayout.CENTER);
		pn.add(scr, BorderLayout.SOUTH);
		this.add(pn);

		// đăng kí sự kiện
		txtTenThuoc.addActionListener(this);
		txtSoLuong.addActionListener(this);
		table.addMouseListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnThoat.addActionListener(this);
		btnTaiLai.addActionListener(this);
		btnCheck.addActionListener(this);
		btnLocMaNCC.addActionListener(this);
		btnLocPhanLoai.addActionListener(this);
		btnLocTacDung.addActionListener(this);
		txtTimTheoTen.getDocument().addDocumentListener(this);
		cboMaThuoc.addActionListener(this);
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
		cboNhaCC.setSelectedItem(model.getValueAt(row, 7).toString());

		cboPhanLoai.setSelectedItem(model.getValueAt(row, 8).toString());
		cboDonViTinh.setSelectedItem(model.getValueAt(row, 9).toString());

		// Lấy giá trị ngày sản xuất từ model
		String dateSx = model.getValueAt(row, 5).toString();
		try {
			// Tạo đối tượng SimpleDateFormat để định dạng ngày
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// Chuyển đổi chuỗi thành đối tượng Date
			Date ngaySx = sdf.parse(dateSx);
			// Thiết lập giá trị cho JDateChooser
			jdcNgaySX.setDate(ngaySx);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}

		// Lấy giá trị ngày hết hạn từ model
		String dateHh = model.getValueAt(row, 6).toString();
		try {
			// Tạo đối tượng SimpleDateFormat để định dạng ngày
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// Chuyển đổi chuỗi thành đối tượng Date
			Date ngayHh = sdf.parse(dateHh);
			// Thiết lập giá trị cho JDateChooser
			jdcNgayHH.setDate(ngayHh);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}

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
		if (o.equals(txtTenThuoc)) {
			txtSoLuong.requestFocus();
		}
		if (o.equals(txtSoLuong)) {
			txtDonGia.requestFocus();
		}

		if (o.equals(btnThem)) {
			if (!txtMaThuoc.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Đang trong chế độ chỉnh sửa - Vui lòng làm mới.");
				return;
			}

			if (validData()) {
				Thuoc t = genarateOBJThuoc();
				try {
					if (!thuoc_dao.createThuoc(t)) {
						JOptionPane.showMessageDialog(null, "Trùng mã - Kiểm tra lại");
						return;
					} else {
						clearTextField();
						clearDataOnTable();
						DocDuLieuDBVaoTable();
						JOptionPane.showMessageDialog(this, "Thêm thành công !!");

					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
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
				JOptionPane.showMessageDialog(this, "Bạn chưa chọn thuốc để xóa");
				return;
			}
			String ma = model.getValueAt(row, 1).toString();
			Thuoc t = new Thuoc(ma);
			if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa thuốc có mã:" + ma, "Cảnh báo",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				if (thuoc_dao.delete(t)) {
					clearDataOnTable();
					DocDuLieuDBVaoTable();
					JOptionPane.showMessageDialog(this, "Xóa thành công thuốc có mã:" + ma);
				}
			}
		}

		if (o.equals(btnThoat)) {
			mhc.display();
			setVisible(false);
		}

		if (o.equals(btnTaiLai)) {
			clearDataOnTable();
			DocDuLieuDBVaoTable();
			cboNhaCC.setSelectedIndex(0);
			cboPhanLoai.setSelectedIndex(0);
//			cboMaThuoc.setSelectedIndex(0);
			txtTimTheoTen.setText("");
		}

		if (o.equals(btnLocPhanLoai)) {
			String pl = cboPhanLoai.getSelectedItem().toString();
			ArrayList<Thuoc> ds = thuoc_dao.getAllThuocTheoPL(pl);
			int stt = 0;
			model.setRowCount(0);
			for (Thuoc t : ds) {
				model.addRow(new Object[] { ++stt, t.getMaThuoc(), t.getTenThuoc(), t.getSoLuong(), t.getDonGia(),
						t.getNgaySX(), t.getNgayHetHan(), t.getNhaCC().getMaNCC(), t.getPhanLoai(), t.getDonViTinh() });
			}
		}

		if (o.equals(btnLocMaNCC)) {
			String maNCC = cboNhaCC.getSelectedItem().toString();
			ArrayList<Thuoc> ds = thuoc_dao.getAllThuocTheoNCC(maNCC);
			int stt = 0;
			model.setRowCount(0);
			for (Thuoc t : ds) {
				model.addRow(new Object[] { ++stt, t.getMaThuoc(), t.getTenThuoc(), t.getSoLuong(), t.getDonGia(),
						t.getNgaySX(), t.getNgayHetHan(), t.getNhaCC().getMaNCC(), t.getPhanLoai(), t.getDonViTinh() });
			}
		}

		if (o.equals(cboMaThuoc)) {
			String ma = cboMaThuoc.getSelectedItem().toString();
			ArrayList<Thuoc> ds = thuoc_dao.getAllThuoc();
			int stt = 0;
			for (Thuoc t : ds) {
				if (t.getMaThuoc().equals(ma)) {
					model = (DefaultTableModel) table.getModel();
					model.getDataVector().removeAllElements();
					model.addRow(new Object[] { ++stt, t.getMaThuoc(), t.getTenThuoc(), t.getSoLuong(), t.getDonGia(),
							t.getNgaySX(), t.getNgayHetHan(), t.getNhaCC().getMaNCC(), t.getPhanLoai(),
							t.getDonViTinh() });
				}
			}
		}

		if (o.equals(btnCheck)) {
			int stt = 0;
			List<Thuoc> list = thuoc_dao.getThuocHetHan();
			clearDataOnTable();
			JOptionPane.showMessageDialog(this, "Danh sách thuốc hết hạn sử dụng.");
			for (Thuoc t : list) {
				model.addRow(new Object[] { ++stt, t.getMaThuoc(), t.getTenThuoc(), t.getSoLuong(), t.getDonGia(),
						t.getNgaySX(), t.getNgayHetHan(), t.getNhaCC().getMaNCC(), t.getPhanLoai(), t.getDonViTinh() });
			}
		}

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
					t.getNgaySX(), t.getNgayHetHan(), t.getNhaCC().getMaNCC(), t.getPhanLoai(), t.getTacDung(),
					t.getDonViTinh() });
		}
	}

	/*
	 * kiểm tra dữ liệu
	 */
	private boolean validData() {
		String tenThuoc = txtTenThuoc.getText().trim();

		String sl = txtSoLuong.getText().trim();
		String dg = txtDonGia.getText().trim();
		Date now = new Date();
		Date nsx = jdcNgaySX.getDate();
		Date nhh = jdcNgayHH.getDate();

		if (!(tenThuoc.matches("[\\p{L}\\p{M} ]+") && tenThuoc.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Tên thuốc không được rỗng, là kí tự");
			txtTenThuoc.requestFocus();
			return false;
		}

		if (sl.length() > 0) {
			try {
				int soLuong = Integer.parseInt(sl);
				if (soLuong < 0) {
					JOptionPane.showMessageDialog(this, "Số lượng phải là số nguyên dương");
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Số lượng phải là số nguyên");
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng thuốc");
			return false;
		}

		if (dg.length() > 0) {
			try {
				double donGia = Double.parseDouble(dg);
				if (donGia < 0) {
					JOptionPane.showMessageDialog(this, "Đơn giá phải lớn hơn 0");
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Đơn giá phải là kiểu số");
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đơn giá thuốc");
			return false;
		}

		if (nsx != null) {
			if (nsx.after(now)) {
				JOptionPane.showMessageDialog(this, "Ngày sản xuất phải trước hoặc bằng ngày hiện tại");
				jdcNgaySX.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày sản xuất");
			return false;
		}

		if (nhh != null) {
			if (nhh.before(nsx)) {
				JOptionPane.showMessageDialog(this, "Ngày hết hạn phải sau hoặc bằng ngày sản xuất");
				jdcNgayHH.requestFocus();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày hết hạn");
			return false;
		}

		return true;

	}

	/*
	 * hàm genarateOBJThuoc() có chức năng lấy dữ liệu từ field chuyển thành obj
	 * Thuốc
	 */
	private Thuoc genarateOBJThuoc() {
		Thuoc temp;

		int soLuong = thuoc_dao.getSoluong();
		if (soLuong == -1) {
			JOptionPane.showMessageDialog(null, "Phát sinh mã thất bại - Vui lòng kiểm tra kết nối database!!");
			return null;
		}

		String ma = String.format("T%03d", soLuong + 1);

		if (txtTenThuoc.getText().isEmpty()) {
			return null;
		}
		String tenthuoc = txtTenThuoc.getText();

		if (txtSoLuong.getText().isEmpty()) {
			return null;
		}
		int soluong = Integer.parseInt(txtSoLuong.getText());

		if (txtDonGia.getText().isEmpty()) {
			return null;
		}
		double donGia = Double.parseDouble(txtDonGia.getText());

		Date dateNsx = jdcNgaySX.getDate();
		java.sql.Date sqlNsx = new java.sql.Date(dateNsx.getTime());
		Date dateNhh = jdcNgayHH.getDate();
		java.sql.Date sqlNhh = new java.sql.Date(dateNhh.getTime());

		String nhacc = cboNhaCC.getSelectedItem().toString();
		String phanloai = cboPhanLoai.getSelectedItem().toString();
		String donViTinh = cboDonViTinh.getSelectedItem().toString();
		String tacDung = cboTacDung.getSelectedItem().toString();
		NhaCungCap ncc = new NhaCungCap(nhacc);
		try {
			temp = new Thuoc(ma, tenthuoc, phanloai, tacDung, sqlNhh, donViTinh, soluong, donGia, sqlNsx, ncc);
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
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa");
			return;
		}
		// lấy dữ liệu từ textField chuyển đổi sang objThuoc
		String maThuoc = txtMaThuoc.getText();
		String tenthuoc = txtTenThuoc.getText();
		int soluong = Integer.parseInt(txtSoLuong.getText());
		double dongianhap = Double.parseDouble(txtDonGia.getText());

		// xử lí dữ liệu Date
		Date dateNsx = jdcNgaySX.getDate();
		java.sql.Date sqlNsx = new java.sql.Date(dateNsx.getTime());
		Date dateNhh = jdcNgayHH.getDate();
		java.sql.Date sqlNhh = new java.sql.Date(dateNhh.getTime());

		String nhacc = cboNhaCC.getSelectedItem().toString();
		String phanLoai = cboPhanLoai.getSelectedItem().toString();
		String donViTinh = cboDonViTinh.getSelectedItem().toString();
		String tacDung = cboTacDung.getSelectedItem().toString();
		NhaCungCap ncc = new NhaCungCap(nhacc);

		Thuoc t = new Thuoc(maThuoc, tenthuoc, phanLoai, tacDung, sqlNhh, donViTinh, soluong, dongianhap, sqlNsx, ncc);

		try {
			thuoc_dao.update(t);
			clearDataOnTable();
			DocDuLieuDBVaoTable();
			JOptionPane.showMessageDialog(this, "Sửa thành công thuốc: " + tenthuoc + ", có mã: " + maThuoc);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return;
		}
	}

	/*
	 * xóa hết data trên table
	 */
	private void clearDataOnTable() {
		while (model.getRowCount() != 0) {
			model.removeRow(0);
		}
	}

	/*
	 * xóa rỗng textField
	 */
	private void clearTextField() {
		Date now = new Date();
		txtMaThuoc.setText("");
		txtTenThuoc.setText("");
		txtSoLuong.setText("");
		txtDonGia.setText("");
		jdcNgaySX.setDate(null);
		jdcNgayHH.setDate(null);
		cboNhaCC.setSelectedIndex(0);
		cboPhanLoai.setSelectedIndex(0);
		cboDonViTinh.setSelectedIndex(0);
		txtMaThuoc.requestFocus();
	}

	/*
	 * xử lí sự kiện DocumentEvent
	 */
	@Override
	public void insertUpdate(DocumentEvent e) {
		UpdateTable();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		UpdateTable();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		UpdateTable();
	}

	// tìm kiếm và hiển thị lại danh sách
	public void UpdateTable() {
		String ten = txtTimTheoTen.getText();
		ArrayList<Thuoc> ds = thuoc_dao.getAllThuoc();
		ArrayList<Thuoc> dsMoi = new ArrayList<Thuoc>();
		model = (DefaultTableModel) table.getModel();
		model.getDataVector().removeAllElements();
		if (ten.isEmpty()) {
			DocDuLieuDBVaoTable();
		} else {
			for (Thuoc t : ds) {
				if (t.getTenThuoc().toLowerCase().startsWith(ten.toLowerCase()))
					dsMoi.add(t);
			}
			int stt = 0;
			for (Thuoc t : dsMoi) {
				model.addRow(new Object[] { ++stt, t.getMaThuoc(), t.getTenThuoc(), t.getSoLuong(), t.getDonGia(),
						t.getNgaySX(), t.getNgayHetHan(), t.getNhaCC().getMaNCC(), t.getPhanLoai(), t.getDonViTinh() });
			}
		}
	}

}
