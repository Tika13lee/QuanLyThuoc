package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Thuoc;

public class HoaDon_DAO {
	// lấy all data hóa đơn
	public ArrayList<HoaDon> getAllHoaDon() {
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select * from HoaDon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString("maHD");
				Date ngay = rs.getDate("ngayLapHD");
				String maKH = rs.getString("maKH");
				String maNV = rs.getString("maNV");
				Double thanhTien = rs.getDouble("thanhTien");
				KhachHang kh = new KhachHang(maKH);
				NhanVien nv = new NhanVien(maNV);
				HoaDon hd = new HoaDon(maHD, ngay, kh, nv, thanhTien);
				dsHD.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
	}

	// lấy hóa đơn theo mã nhân viên
	public ArrayList<HoaDon> getHDTheoNV(String ma) {
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		try {
			String sql = "select * from HoaDon where maNV = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ma);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maHD = rs.getString("maHD");
				Date ngay = rs.getDate("ngayLapHD");
				String maKH = rs.getString("maKH");
				String maNV = rs.getString("maNV");
				Double thanhTien = rs.getDouble("thanhTien");
				KhachHang kh = new KhachHang(maKH);
				NhanVien nv = new NhanVien(maNV);
				HoaDon hd = new HoaDon(maHD, ngay, kh, nv, thanhTien);
				dsHD.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dsHD;
	}

	// xóa hóa đơn theo mã hóa đơn
	public boolean xoaTheoMaHD(HoaDon ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		try {
			String sql = "delete from HoaDon where maHD = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ma.getMaHD());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	// lấy số lượng hóa đơn
	public int getSoluong() {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT TOP 1 maHD FROM HoaDon ORDER BY maHD desc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				String temp = rs.getString("maHD");
				temp = temp.replace("HD", "");
				return Integer.parseInt(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	// lấy hóa đơn theo mã khách hàng
	public ArrayList<HoaDon> getHDtheoKH(String ma) {
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		try {
			String sql = "select * from HoaDon where maKH = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ma);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maHD = rs.getString("maHD");
				Date ngay = rs.getDate("ngayLapHD");
				String maKH = rs.getString("maKH");
				String maNV = rs.getString("maNV");
				Double thanhTien = rs.getDouble("thanhTien");
				KhachHang kh = new KhachHang(maKH);
				NhanVien nv = new NhanVien(maNV);
				HoaDon hd = new HoaDon(maHD, ngay, kh, nv, thanhTien);
				dsHD.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dsHD;
	}

	// lấy hóa đơn theo mã hóa đơn
	public ArrayList<HoaDon> getHDTheoHD(String ma) {
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		try {
			String sql = "select * from HoaDon where maHD = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ma);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maHD = rs.getString("maHD");
				Date ngay = rs.getDate("ngayLapHD");
				String maKH = rs.getString("maKH");
				String maNV = rs.getString("maNV");
				Double thanhTien = rs.getDouble("thanhTien");
				KhachHang kh = new KhachHang(maKH);
				NhanVien nv = new NhanVien(maNV);
				HoaDon hd = new HoaDon(maHD, ngay, kh, nv, thanhTien);
				dsHD.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dsHD;
	}

	// lấy hóa đơn theo tháng năm
	public ArrayList<HoaDon> getHoaDonTheoThangNam(int thang, int nam) {
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		try {
			String sql = "SELECT * FROM HoaDon WHERE MONTH(ngayLapHD) = ? AND YEAR(ngayLapHD) = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, thang);
			ps.setInt(2, nam);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maHD = rs.getString("maHD");
				Date ngay = rs.getDate("ngayLapHD");
				String maKH = rs.getString("maKH");
				String maNV = rs.getString("maNV");
				Double thanhTien = rs.getDouble("thanhTien");
				KhachHang kh = new KhachHang(maKH);
				NhanVien nv = new NhanVien(maNV);
				HoaDon hd = new HoaDon(maHD, ngay, kh, nv, thanhTien);
				dsHD.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dsHD;
	}

	// thêm hóa đơn
	public boolean createHoaDon(HoaDon hd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into HoaDon values (?,?,?,?,?)");
			stmt.setString(1, hd.getMaHD());
			stmt.setDate(2, (java.sql.Date) hd.getNgayLapHD());
			stmt.setString(3, hd.getKhachHang().getMaKH());
			stmt.setString(4, hd.getNhanVien().getMaNV());
			stmt.setDouble(5, hd.getThanhTien());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}

}
