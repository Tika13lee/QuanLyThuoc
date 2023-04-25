package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
//import java.sql.Date;

import connect.ConnectDB;
import entity.NhaCungCap;
import entity.Thuoc;

public class Thuoc_DAO {
	public Thuoc_DAO() {

	}

	/*
	 * lấy data từ sql lên table;
	 */
	public ArrayList<Thuoc> getAllThuoc() {
		ArrayList<Thuoc> dsThuoc = new ArrayList<Thuoc>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "select * from Thuoc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString("maThuoc");
				String ten = rs.getString("tenThuoc");
				String phanLoai = rs.getString("phanLoai");
				Date ngaySX = rs.getDate("ngaySX");
				Date ngayHH = rs.getDate("ngayHetHan");
				String donViTinh = rs.getString("donViTinh");
				int soLuong = rs.getInt("soLuong");
				double dongia = rs.getDouble("donGia");
				NhaCungCap ncc = new NhaCungCap(rs.getString("maNCC"));

				Thuoc thuoc = new Thuoc(ma, ten, phanLoai, ngayHH, donViTinh, soLuong, dongia, ngaySX, ncc);
				dsThuoc.add(thuoc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThuoc;
	}

	/*
	 * lấy data thuốc theo phân loại;
	 */
	public ArrayList<Thuoc> getAllThuocTheoPL(String pl) {
		ArrayList<Thuoc> ds = new ArrayList<Thuoc>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;
		String sql = "select * from Thuoc where phanLoai = ?";

		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, pl);
			rs = statement.executeQuery();
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String phanLoai = rs.getString(3);
				Date ngaySX = rs.getDate(4);
				Date ngayHH = rs.getDate(5);
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

	/*
	 * them nhan vien
	 */
	public boolean createThuoc(Thuoc t) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into" + " Thuoc values (?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, t.getMaThuoc());
			stmt.setString(2, t.getTenThuoc());
			stmt.setString(3, t.getPhanLoai());
			stmt.setDate(4, (java.sql.Date) t.getNgaySX());
			stmt.setDate(5, (java.sql.Date) t.getNgayHetHan());
			stmt.setString(6, t.getDonViTinh());
			stmt.setDouble(7, t.getDonGia());
			stmt.setInt(8, t.getSoLuong());
			stmt.setString(9, t.getNhaCC().getMaNCC());
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

	/*
	 * update thuốc
	 */
	public boolean update(Thuoc t) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(
					"update Thuoc set tenThuoc = ?, phanLoai = ?,ngaySX =?,ngayHetHan=?,donViTinh=?,donGia=?,soLuong=?, maNCC = ? where maThuoc = ?");
			stmt.setString(1, t.getMaThuoc());
			stmt.setString(2, t.getTenThuoc());
			stmt.setString(3, t.getPhanLoai());
			stmt.setDate(4, (java.sql.Date) t.getNgaySX());
			stmt.setDate(5, (java.sql.Date) t.getNgayHetHan());
			stmt.setString(6, t.getDonViTinh());
			stmt.setDouble(7, t.getDonGia());
			stmt.setInt(8, t.getSoLuong());
			stmt.setString(9, t.getNhaCC().getMaNCC());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}
	/*
	 * xóa thuốc
	 */
	public boolean delete(Thuoc t) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n= 0;
		try {
			stmt = con.prepareStatement("delete Thuoc where maThuoc = ?");
			stmt.setString(1, t.getMaThuoc());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return n>0;
	}

}
