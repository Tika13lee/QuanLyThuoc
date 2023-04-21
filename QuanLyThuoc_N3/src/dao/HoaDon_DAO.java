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

public class HoaDon_DAO {
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
				KhachHang kh = new KhachHang(maKH);
				NhanVien nv = new NhanVien(maNV);
				HoaDon hd = new HoaDon(maHD, ngay, kh, nv);
				dsHD.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
	}

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
				KhachHang kh = new KhachHang(maKH);
				NhanVien nv = new NhanVien(maNV);
				HoaDon hd = new HoaDon(maHD, ngay, kh, nv);
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

	public boolean xoaTheoMaHD(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		try {
			String sql = "delete from HoaDon where maHD = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ma);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}