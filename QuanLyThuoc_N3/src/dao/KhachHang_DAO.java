package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.KhachHang;

public class KhachHang_DAO {
	public ArrayList<KhachHang> getAllNhanVien() {
		ArrayList<KhachHang> dsKhachHangs = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				KhachHang kh = new KhachHang();
				kh.setMaKH(rs.getString("maKH"));
				kh.setHoKH(rs.getString("hoKH"));
				kh.setTenKH(rs.getString("tenKH"));
				kh.setSoDT(rs.getString("soDT"));
				kh.setNgaySinh(rs.getDate("ngaySinh"));
				kh.setGioiTinh(rs.getBoolean("gioiTinh"));
				kh.setDiaChi(rs.getString("diaChi"));
				dsKhachHangs.add(kh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsKhachHangs;
	}

	// thêm khách hàng
	public void insertKhachHang(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n;
		try {
			String sql = "insert into KhachHang values (?, ?, ?, ?, ?, ?, ?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, kh.getMaKH());
			stmt.setString(2, kh.getHoKH());
			stmt.setString(3, kh.getTenKH());
			stmt.setString(4, kh.getSoDT());
			stmt.setDate(5, kh.getNgaySinh());
			stmt.setBoolean(6, kh.isGioiTinh());
			stmt.setString(7, kh.getDiaChi());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//		return n > 0;
	}

	// lấy số lượng khách hàng có trong data
	public int getSoluong() {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT TOP 1 maKH FROM KhachHang ORDER BY maKH desc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				String temp = rs.getString("maKH");
				temp = temp.replace("KH", "");
				return Integer.parseInt(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
