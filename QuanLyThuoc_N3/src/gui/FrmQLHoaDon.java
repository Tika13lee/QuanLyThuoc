package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class FrmQLHoaDon extends JFrame implements ActionListener{
	private static final long serialVersionUID =1L;
	private JLabel lblMaHD,lblNgayLap,lblSDT,lblHoKH,lblTenKH,lblGioiTinh,lblDiaChi,lblCMND,lblNgaySinh,lblTenThuoc,lblTuoi,lblTimThuoc;
	private JLabel lblMaNV,lblHoTenNV,lblCMNDNV,lblDiaChiNV; //nhan vien
	private JTextField txtMaNV,txtHoTenNV,txtCMNDNV,txtDiaChiNV;//nhan vien
	private JTextField txtMaHD,txtNgayLap,txtSDT,txtHoKH,txtTenKH,txtDiaChi,txtNgaySinh,txtCMND;//KH
	private JDateChooser dcrNgayLap ;
	private JDateChooser dcrNgaySinh;
	private JComboBox cboGioiTinh;
	private JComboBox cboTimThuoc;
	private DefaultTableModel model;
	private JTable table;
	private JButton btnThem,btnXoa,btnLamMoi,btnThanhToan,btnTimThuoc;
	
	public FrmQLHoaDon() {
		// TODO Auto-generated constructor stub
		JPanel pBorder = new JPanel();
		pBorder.setLayout(new BorderLayout());
		setTitle("Quản lý hóa đơn");
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		JPanel pNorth = new JPanel();
		JLabel lblTitle = new JLabel("LẬP HÓA ĐƠN");
		lblTitle.setForeground(Color.BLUE);
		Font font = new Font("Arial",Font.BOLD,25);
		lblTitle.setFont(font);
		pNorth.add(lblTitle);
		pNorth.setBorder(new EmptyBorder(20, 0, 0, 0));
		pBorder.add(pNorth,BorderLayout.NORTH);
		
		JPanel pCenter = new JPanel();
		pCenter.setLayout(new BoxLayout(pCenter, BoxLayout.Y_AXIS));
		
		Box b1 = Box.createHorizontalBox();
		//b1.add(Box.createVerticalStrut(15));
		b1.add(lblMaHD = new JLabel("Mã hóa đơn:"));
		b1.add(txtMaHD= new JTextField(15));
		txtMaHD.setColumns(1);
		lblMaHD.setPreferredSize(new Dimension(150, 20));
		b1.add(Box.createHorizontalStrut(50));
		b1.add(lblNgayLap = new JLabel("Ngày lập hóa đơn:"));
		//b1.add(txtNgayLap = new JTextField(15));
		b1.add(dcrNgayLap = new JDateChooser());
		b1.add(Box.createHorizontalStrut(210));
		
		lblNgayLap.setPreferredSize(new Dimension(150,20));
		pCenter.add(Box.createVerticalStrut(20));
		pCenter.add(b1);
		
		
		Box b2 = Box.createHorizontalBox();
		b2.add(lblHoKH = new JLabel("Họ KH:"));
		b2.add(txtHoKH = new JTextField(15));
		lblHoKH.setPreferredSize(lblMaHD.getPreferredSize());
		b2.add(Box.createHorizontalStrut(50));
		b2.add(lblTenKH = new JLabel("Tên KH:"));
		b2.add(txtTenKH = new JTextField(15));
		lblTenKH.setPreferredSize(lblNgayLap.getPreferredSize());
		b2.add(Box.createHorizontalStrut(20));
		b2.add(lblGioiTinh =new JLabel("Giới tính:"));
		lblGioiTinh.setPreferredSize(new Dimension(100,20));
		cboGioiTinh = new JComboBox<String>(new String[] {"Nam","Nữ"});
		cboGioiTinh.setPreferredSize(new Dimension(150,20));
		b2.add(cboGioiTinh);
		pCenter.add(Box.createVerticalStrut(20));
		pCenter.add(b2);
		
		Box b3 = Box.createHorizontalBox();
		b3.add(lblSDT = new JLabel("Số điện thoại KH:"));
		lblSDT.setPreferredSize(lblTenKH.getPreferredSize());
		b3.add(txtSDT = new JTextField(15));
		b3.add(Box.createHorizontalStrut(190));
		b3.add(lblCMND = new JLabel("Số CMND:"));
		lblCMND.setPreferredSize(lblTenKH.getPreferredSize());
		b3.add(txtCMND =new JTextField(15));
		b3.add(Box.createHorizontalStrut(50));
		b3.add(lblNgaySinh = new JLabel("Ngày sinh KH:"));
		lblNgaySinh.setPreferredSize(lblGioiTinh.getPreferredSize());
		//b3.add(txtNgaySinh = new JTextField(15));
		b3.add(dcrNgaySinh = new JDateChooser());
		b3.add(Box.createHorizontalStrut(50));
		pCenter.add(Box.createVerticalStrut(20));
		pCenter.add(b3);
		
		Box b4 = Box.createHorizontalBox();
		b4.add(lblDiaChi = new JLabel("Địa chỉ:"));
		lblDiaChi.setPreferredSize(lblHoKH.getPreferredSize());
		b4.add(txtDiaChi = new JTextField(30));
		b4.add(Box.createHorizontalStrut(20));
		b4.add(lblTimThuoc = new JLabel("Tìm thuốc:"));
		lblTimThuoc.setPreferredSize(lblNgayLap.getPreferredSize());
		cboTimThuoc = new JComboBox();
		cboTimThuoc.setPreferredSize(new Dimension(300,20));
		b4.add(cboTimThuoc);
		b4.add(Box.createHorizontalStrut(20));
		b4.add(btnTimThuoc = new JButton("Tìm thuốc"));
		b4.add(Box.createHorizontalStrut(300));
		pCenter.add(Box.createVerticalStrut(20));
		pCenter.add(b4);
		
		
//		Dimension dms_lbl = new Dimension(100, 20);
//		Arrays.stream(new JLabel[] { lblMaHD,lblNgayLap,lblSDT,lblHoTenKH,lblGioiTinh,lblDiaChi,lblCMND,lblNgaySinh,lblTenThuoc,lblTuoi,lblTimThuoc })
//		.forEach(item -> item.setPreferredSize(dms_lbl));
		
		String[] tb = new String[] {"STT","MaHoaDon","MaThuoc","LoaiThuoc","TenThuoc","DonGia","SoLuong","ThanhTien","NgayLapHD","HoTenKH","SDTKH","GioiTinh","Tuoi"};
		model = new DefaultTableModel(tb,0);
		table = new JTable(model);
		JScrollPane sp = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setPreferredSize(new Dimension(0,350));
		pCenter.add(Box.createVerticalStrut(20));
		pCenter.add(sp);
		pCenter.setBorder(new EmptyBorder(10, 0, 0, 0));
		
		
		pBorder.add(pCenter,BorderLayout.CENTER);
		
		JPanel pSouth = new JPanel();
		//pSouth.setLayout(BorderLayout);
		//pSouth.setSize(1000,500);
		JPanel pWest = new JPanel();
		pWest.setLayout(new BoxLayout(pWest, BoxLayout.Y_AXIS));
		Box b = Box.createVerticalBox();
		Box b5 = Box.createHorizontalBox();
		b5.add(Box.createHorizontalStrut(15));
		b5.add(lblMaNV= new JLabel("Mã nhân viên:"));
		b5.add(txtMaNV=new JTextField(15));
		b5.add(Box.createHorizontalStrut(15));
		//pWest.add(b5);
		
		Box b6 = Box.createHorizontalBox();
		b6.add(Box.createHorizontalStrut(15));
		b6.add(lblHoTenNV = new JLabel("Họ tên nhân viên:"));
		b6.add(txtHoTenNV = new JTextField(15));
		b6.add(Box.createHorizontalStrut(15));
		//pWest.add(b6);
		
		Box b7 = Box.createHorizontalBox();
		b7.add(Box.createHorizontalStrut(15));
		b7.add(lblCMNDNV = new JLabel("Số CMND:"));
		b7.add(txtCMNDNV = new JTextField(15));
		b7.add(Box.createHorizontalStrut(15));
		//pWest.add(b7);
		
		Box b8 = Box.createHorizontalBox();
		b8.add(Box.createHorizontalStrut(15));
		b8.add(lblDiaChiNV = new JLabel("Địa chỉ:"));
		b8.add(txtDiaChiNV = new JTextField(30));
		b8.add(Box.createHorizontalStrut(15));
		//pWest.add(b8);
		lblMaNV.setPreferredSize(new Dimension(150, 20));
		lblHoTenNV.setPreferredSize(lblMaNV.getPreferredSize());
		lblCMNDNV.setPreferredSize(lblMaNV.getPreferredSize());
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
		pSouth.add(pWest,BorderLayout.WEST);
		pSouth.add(Box.createHorizontalStrut(200));
		Border borderSouth = BorderFactory.createLineBorder(Color.BLUE,font.BOLD);
		TitledBorder titledBorder = new TitledBorder(borderSouth,"Thông tin nhân viên");
		titledBorder.setTitleColor(Color.BLUE);
		pWest.setBorder(titledBorder);
		
		JPanel pChucNang = new JPanel();
		pChucNang.setLayout(new BoxLayout(pChucNang, BoxLayout.Y_AXIS));
		Box bp = Box.createVerticalBox();
		Box bp1 = Box.createHorizontalBox();
		//bp1.add(Box.createHorizontalStrut(50));
		bp1.add(btnThem = new JButton("Thêm hóa đơn"));
		bp1.add(Box.createHorizontalStrut(50));
		bp1.add(btnXoa = new JButton("Xóa hóa đơn"));
		//bp1.add(Box.createHorizontalStrut(50));
		//bp.add(Box.createHorizontalStrut(50));
		Box bp2 = Box.createHorizontalBox();
		bp2.add(btnLamMoi = new JButton("Làm mới"));
		bp2.add(Box.createHorizontalStrut(50));
		bp2.add(btnThanhToan = new JButton("Thanh toán"));
		//bp2.add(Box.createHorizontalStrut(50));
		
		bp.add(Box.createVerticalStrut(40));
		bp.add(bp1);
		bp.add(Box.createVerticalStrut(20));
		bp.add(bp2);
		bp.add(Box.createVerticalStrut(40));
		
		btnThem.setPreferredSize(new Dimension(200,30));
		btnXoa.setPreferredSize(new Dimension(200,30));
		btnLamMoi.setPreferredSize(btnThem.getPreferredSize());
		btnThanhToan.setPreferredSize(btnXoa.getPreferredSize());

		btnThem.setFont(new Font("Arial", font.PLAIN, 15));
		btnXoa.setFont(new Font("Arial", font.PLAIN, 15));
		btnLamMoi.setFont(new Font("Arial", font.PLAIN, 15));
		btnThanhToan.setFont(new Font("Arial", font.PLAIN, 15));
		pChucNang.add(bp);
		pSouth.add(pChucNang,BorderLayout.EAST);
		Border borderCN = BorderFactory.createLineBorder(Color.BLUE,font.BOLD);
		TitledBorder titledBorderCN = new TitledBorder(borderCN,"Chức năng");
		titledBorderCN.setTitleColor(Color.BLUE);
		pChucNang.setBorder(titledBorderCN);
		
		
		pBorder.add(pSouth,BorderLayout.SOUTH);
		pBorder.setBorder(new EmptyBorder(10,20,10,20));
		
		
		this.add(pBorder);
		cboTimThuoc.addActionListener(this);
		btnTimThuoc.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnThanhToan.addActionListener(this);
		
		
	}
	public static void main(String[] args) {
		new FrmQLHoaDon().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
