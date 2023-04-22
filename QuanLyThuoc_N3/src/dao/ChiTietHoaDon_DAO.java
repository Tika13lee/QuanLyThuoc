package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Thuoc;

public class ChiTietHoaDon_DAO {
	public ArrayList<ChiTietHoaDon> getAllChiTietHoaDon() {
		ArrayList<ChiTietHoaDon> dsCTHD = new ArrayList<ChiTietHoaDon>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select * from ChiTietHoaDon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString("maHD");
				String maThuoc = rs.getString("maThuoc");
				float donGia = rs.getFloat("donGia");
				int soLuong = rs.getInt("soLuong");
				String donViTinh = rs.getString("donViTinh");
				float phiVAT = rs.getFloat("phiVAT");
				String moTa = rs.getString("moTa");
				Thuoc thuoc = new Thuoc(maThuoc);
				HoaDon hd = new HoaDon(maHD);
				ChiTietHoaDon cthd = new ChiTietHoaDon(thuoc, donGia, soLuong, donViTinh, phiVAT, moTa, hd);

				dsCTHD.add(cthd);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsCTHD;
	}
//	public double soTienPhaiTra() {
//		ArrayList<ChiTietHoaDon> dsCTHD = new ArrayList<ChiTietHoaDon>();
//		double tienVAT = 0;
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		try {
//			String sql = "Select * from ChiTietHoaDon";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while (rs.next()) {
//				float donGia = rs.getFloat("donGia");
//				int soLuong = rs.getInt("soLuong");
//				float phiVAT = rs.getFloat("phiVAT");
//				double tienChuaVAT = soLuong * donGia;
//				tienVAT = tienChuaVAT * phiVAT / 100.0;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return tienVAT;
//	}
}
