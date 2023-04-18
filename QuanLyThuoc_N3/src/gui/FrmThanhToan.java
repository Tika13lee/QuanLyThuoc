package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrmThanhToan extends JFrame implements ActionListener{
	private static final long serialVersionUID =1L;
	private JLabel lblTongThanhToan,lblHinhThucThanhToan,lblLoaiTien,lblTienKhachDua,lblTienTraLai;
	private JTextField txtTongThanhToan,txtTienKhachDua,txtTienTraLai;
	private JComboBox cboHinhThucThanhToan;
	private JComboBox cboLoaiTien;
	private JButton btnTinhTien,btnDong;
	public FrmThanhToan() {
		// TODO Auto-generated constructor stub
		setTitle("Thông tin thanh toán");
		setSize(600,400);
		//setExtendedState(MAXIMIZED_BOTH);
		//setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		JPanel pBorder = new JPanel();
		pBorder.setLayout(new BorderLayout());
		//Phần tiêu đề
		JPanel pNorth = new JPanel();
		JLabel lblTitle = new JLabel("Thông tin thanh toán"); 
		lblTitle.setFont(new Font("Arail", Font.BOLD, 25));
		lblTitle.setForeground(Color.BLUE);
		pNorth.add(lblTitle);
		pBorder.add(pNorth,BorderLayout.NORTH);
		
		//Phần center
		JPanel pCenter = new JPanel();
		pCenter.setLayout(new BoxLayout(pCenter, BoxLayout.Y_AXIS));
		Box b1 = Box.createHorizontalBox();
		b1.add(lblTongThanhToan = new JLabel("Tổng tiền thanh toán:"));
		lblTongThanhToan.setPreferredSize(new Dimension(200,20));
		b1.add(txtTongThanhToan = new JTextField(15));
		
		Box b2 = Box.createHorizontalBox();
		b2.add(lblHinhThucThanhToan = new JLabel("Hình thức thanh toán:"));
		lblHinhThucThanhToan.setPreferredSize(lblTongThanhToan.getPreferredSize());
		cboHinhThucThanhToan = new JComboBox<String>(new String[] {"Tiền mặt","Thẻ tín dụng"});
		cboHinhThucThanhToan.setPreferredSize(new Dimension(100, 20));
		b2.add(cboHinhThucThanhToan);
		
		Box b3 = Box.createHorizontalBox();
		b3.add(lblLoaiTien = new JLabel("Loại tiền:"));
		lblLoaiTien.setPreferredSize(lblTongThanhToan.getPreferredSize());
		cboLoaiTien = new JComboBox<String>(new String[] {"VND","Euro"});
		cboLoaiTien.setPreferredSize(new Dimension(100, 20));
		b3.add(cboLoaiTien);
		
		Box b4 = Box.createHorizontalBox();
		b4.add(lblTienKhachDua = new JLabel("Tiền khách đưa:"));
		lblTienKhachDua.setPreferredSize(lblTongThanhToan.getPreferredSize());
		b4.add(txtTienKhachDua = new JTextField(15));
		
		pCenter.add(Box.createVerticalStrut(20));
		pCenter.add(b1);
		pCenter.add(Box.createVerticalStrut(20));
		pCenter.add(b2);
		pCenter.add(Box.createVerticalStrut(20));
		pCenter.add(b3);
		pCenter.add(Box.createVerticalStrut(20));
		pCenter.add(b4);
		pCenter.add(Box.createVerticalStrut(20));
		pBorder.add(pCenter,BorderLayout.CENTER);
		
		//phần chức năng
		JPanel pSouth = new JPanel();
		pSouth.add(btnTinhTien = new JButton("Tính tiền"));
		pSouth.add(btnDong = new JButton("Đóng"));
		pSouth.add(Box.createVerticalStrut(100));
		pSouth.setBackground(Color.CYAN);
		pBorder.add(pSouth,BorderLayout.SOUTH);
		pBorder.setBorder(new EmptyBorder(20, 0, 0, 0));
		
		this.add(pBorder);
		btnDong.addActionListener(this);
		btnTinhTien.addActionListener(this);
		
		
		
		
		
	}
	public static void main(String[] args) {
		new FrmThanhToan().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
