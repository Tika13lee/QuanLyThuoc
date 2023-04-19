package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
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
				String phanloai = rs.getString(3);
				Date ngaysx = rs.getDate(4);
				Date ngayHH = rs.getDate(4);
				String donviTinh = rs.getString(6);
				int soLuong = rs.getInt(7);
				double dongia = rs.getDouble(8);
				NhaCungCap ncc = (NhaCungCap) rs.getArray(9);
				Thuoc thuoc = new Thuoc(ma, ten, phanloai, ngayHH, donviTinh, soLuong, dongia, ngaysx, ncc);
				dsThuoc.add(thuoc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThuoc;
	}

	public ArrayList<Thuoc> getDanhMucThuoc() {
		ArrayList<Thuoc> dsDanhMuc = new ArrayList<Thuoc>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "select maThuoc, tenThuoc from Thuoc";
			Statement statement = con.createStatement();

			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Thuoc thuoc = new Thuoc();
				String ma = rs.getString(1);
				thuoc.setMaThuoc(ma);
				String ten = rs.getString(2);
				thuoc.setTenThuoc(ten);
//				String phanloai = rs.getString(3);
//				thuoc.setPhanLoai(phanloai);
//				
//				double donGia = rs.getDouble(7);
//				thuoc.setDonGia(donGia);
//				int soLuong = rs.getInt(8);
//				thuoc.setSoLuong(soLuong);
				dsDanhMuc.add(thuoc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsDanhMuc;
	}
}
