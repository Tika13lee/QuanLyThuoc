package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.NhaCungCap;
import entity.Thuoc;

public class Thuoc_DAO {
	public Thuoc_DAO() {

	}

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
}
