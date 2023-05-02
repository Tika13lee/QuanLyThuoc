package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
				Thuoc thuoc = new Thuoc(maThuoc);
				HoaDon hd = new HoaDon(maHD);
				ChiTietHoaDon cthd = new ChiTietHoaDon(thuoc, donGia, soLuong, donViTinh, phiVAT, hd);

				dsCTHD.add(cthd);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsCTHD;
	}
	
	public boolean createChiTietHoaDon(ChiTietHoaDon ct) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into" + " ChiTietHoaDon values (?,?,?,?,?,?) where maHD = ?" );
			stmt.setDouble(1, ct.getDonGia());
			stmt.setInt(2, ct.getSoLuong());
			stmt.setString(3, ct.getDonViTinh());
			stmt.setDouble(4, ct.getPhiVAT());
			stmt.setString(5, ct.getThuoc().getMaThuoc());
			stmt.setString(6, ct.getHoaDon().getMaHD());
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
