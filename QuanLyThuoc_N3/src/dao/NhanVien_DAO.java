package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import connect.ConnectDB;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.TaiKhoan;
import entity.NhanVien;

public class NhanVien_DAO {

	public NhanVien_DAO() {

	}

	// lấy toàn bộ nhân viên
	public ArrayList<NhanVien> getAllNhanVien() {
		ArrayList<NhanVien> dsNhanViens = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				NhanVien nv = new NhanVien();
				nv.setMaNV(rs.getString("maNV"));
				nv.setHoNV(rs.getString("hoNV"));
				nv.setTenNV(rs.getString("tenNV"));
				nv.setTuoi(rs.getInt("tuoiNV"));
				nv.setSoDT(rs.getString("soDT"));
				nv.setGioiTinh(rs.getBoolean("gioiTinh"));
				nv.setDiaChi(rs.getString("diaChi"));
				dsNhanViens.add(nv);
			}
			// rs.close();
			statement.close();
			// con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dsNhanViens;
	}

	// lấy tên nhân viên theo mã
	public String getTenNhanVienByMaNV(String ma) {
		String tenNhanVien = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		try {
			String sql = "select tenNV from NhanVien where maNV = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ma);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				tenNhanVien = rs.getString("tenNV");
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
		return tenNhanVien;
	}

	// lấy nhân viên theo mã tài khoản
	public ArrayList<NhanVien> getAllNVTheoMaTK(String maTK) {
		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;
		String sql = "select * from NhanVien where maTK = ?";

		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, maTK);
			rs = statement.executeQuery();
			while (rs.next()) {
				String ma = rs.getString(1);
				String ho = rs.getString(2);
				String ten = rs.getString(3);
				int tuoi = rs.getInt(4);
				String sdt = rs.getString(5);
				boolean gt = rs.getBoolean(6);
				String maTaiKhoan = rs.getString(7);
				TaiKhoan tk = new TaiKhoan(maTaiKhoan);
				String dc = rs.getString(8);
				NhanVien nv = new NhanVien(ma, ho, ten, tuoi, sdt, gt, tk, dc);
				ds.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ds;
	}
}
