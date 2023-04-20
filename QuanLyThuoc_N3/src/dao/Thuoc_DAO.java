package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.NhaCungCap;
import entity.Thuoc;

public class Thuoc_DAO {
	public ArrayList<Thuoc> getAllThuoc() {
		ArrayList<Thuoc> dsThuoc = new ArrayList<Thuoc>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "select * from Thuoc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String phanLoai = rs.getString(3);
				Date ngaySX = rs.getDate(4);
				Date ngayHH = rs.getDate(4);
				String donViTinh = rs.getString(6);
				int soLuong = rs.getInt(7);
				double dongia = rs.getDouble(8);
				NhaCungCap ncc = new NhaCungCap(rs.getString(9));
				Thuoc thuoc = new Thuoc(ma, ten, phanLoai, ngayHH, donViTinh, soLuong, dongia, ngaySX, ncc);
				dsThuoc.add(thuoc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThuoc;
	}

	public ArrayList<Thuoc> getAllThuocTheoMa(String maThuoc) {
		ArrayList<Thuoc> ds = new ArrayList<Thuoc>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Seclect * from Thuoc where maThuoc = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maThuoc);
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String phanLoai = rs.getString(3);
				Date ngaySX = rs.getDate(4);
				Date ngayHH = rs.getDate(4);
				String donViTinh = rs.getString(6);
				int soLuong = rs.getInt(7);
				double dongia = rs.getDouble(8);
				NhaCungCap ncc = new NhaCungCap(rs.getString(9));
				Thuoc thuoc = new Thuoc(ma, ten, phanLoai, ngayHH, donViTinh, soLuong, dongia, ngaySX, ncc);
				ds.add(thuoc);
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
