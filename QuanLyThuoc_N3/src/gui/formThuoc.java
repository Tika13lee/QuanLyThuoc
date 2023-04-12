package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

//import com.toedter.calendar.JDateChooser;

public class formThuoc extends JFrame {
	private JLabel lblMaThuoc, lblTenThuoc, lblPhanLoai, lblhanSD, lbldonViTinh, lblSoLuong, lblDonGia, lblngaySX,
			lblnhaCC;
	private JTextField txtMaThuoc, txtTenThuoc, txtHanSD, txtDonViTinh, txtSoLuong, txtDonGia, txtnhaCC, txtngaySX,
			txtTimKiem;
//	private JDateChooser datehanSD;
	private JComboBox cboPhanLoai;
	private DefaultTableModel model;
	private JTable table;
	private JButton btnTimKiem, btnLamMoi, btnThoat ;
	private JLabel lblTimKiem;
	private JLabel lbltitle;

	public formThuoc() {
		setTitle("quản lý thuốc");
		setSize(900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);
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
		ba.setBorder(BorderFactory.createTitledBorder("tim kiem thong tin"));
		bb.setBorder(BorderFactory.createTitledBorder("thông tin thuốc"));
		
		Box b1 = new Box(BoxLayout.X_AXIS);
		Box b2 = new Box(BoxLayout.X_AXIS);
		Box b3 = new Box(BoxLayout.X_AXIS);
		Box b4 = new Box(BoxLayout.X_AXIS);

		lbltitle = new JLabel("Quan ly thuoc");
		lbltitle.setFont(new Font("arial", Font.BOLD, 24));
		lbltitle.setForeground(Color.pink);

		b1.add(lblMaThuoc = new JLabel("ma:"));
		b1.add(txtMaThuoc = new JTextField());
		b1.add(lblTenThuoc = new JLabel("ten thuoc"));
		b1.add(txtTenThuoc = new JTextField());

		b2.add(lblSoLuong = new JLabel("so luong:"));
		b2.add(txtSoLuong = new JTextField());
		b2.add(lblDonGia = new JLabel("don gia"));
		b2.add(txtDonGia = new JTextField());

		b3.add(lblngaySX = new JLabel("ngày sản xuất:"));
		b3.add(txtngaySX = new JTextField());
		b3.add(lblhanSD = new JLabel("han su dung:"));
		b3.add(txtHanSD = new JTextField());

		cboPhanLoai = new JComboBox<>();
		cboPhanLoai.addItem("thuoc kê đơn");
		cboPhanLoai.addItem("thuoc không kê đơn");

		b4.add(lblnhaCC = new JLabel("nhà cung cấp:"));
		b4.add(txtnhaCC = new JTextField());
		b4.add(lblPhanLoai = new JLabel("phan loai:"));
		b4.add(cboPhanLoai);

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
		JPanel pnTim = new JPanel();
//		pnTim.setBorder(BorderFactory.createTitledBorder("chức năng"));
		pnTim.add(lblTimKiem = new JLabel("nhập thông tin tìm kiếm:"));
		pnTim.add(txtTimKiem = new JTextField(20));
		pnTim.add(btnTimKiem = new JButton("Tim kiếm"));
		ba.add(pnTim);
		
		b.add(Box.createHorizontalStrut(50));
		b.add(ba);
		bAll.add(lbltitle);
		bAll.add(b);
		bAll.add(Box.createVerticalStrut(20));
//		this.add(b, BorderLayout.NORTH);
		
		//

		lblMaThuoc.setPreferredSize(new Dimension(100, 20));

		lblSoLuong.setPreferredSize(new Dimension(100, 20));
		lblngaySX.setPreferredSize(new Dimension(100, 20));
		lblnhaCC.setPreferredSize(new Dimension(100, 20));
		
		lblTenThuoc.setPreferredSize(new Dimension(100, 20));
		lblDonGia.setPreferredSize(new Dimension(100, 20));
		lblhanSD.setPreferredSize(new Dimension(100, 20));
		
		// center
		String[] cols = { "ma thuoc", "ten thuoc", "so luong", "don gia", "ngay san xuat", "han su dung", "phan loai",
				"nha cung cap" };
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		JScrollPane scr = new JScrollPane(table);
		
		// south

		JPanel pnSouth = new JPanel();
		pnSouth.add(btnLamMoi = new JButton("lam moi"));
		pnSouth.add(btnThoat = new JButton("thoat"));

		pn.add(bAll,BorderLayout.NORTH);
		pn.add(scr, BorderLayout.CENTER);
		pn.add(pnSouth,BorderLayout.SOUTH);
		this.add(pn);
	}

	public static void main(String[] args) {
		new formThuoc().setVisible(true);
	}
}
