package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.KhachHang;
import entity.NhaCungCap;

public class KhachHang_DAO {
	public ArrayList<KhachHang> getAllNhanVien(){
		ArrayList<KhachHang> dsKhachHangs = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
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
			//rs.close();
			statement.close();
			//con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dsKhachHangs;
	}
	public void insertKhachHang(KhachHang kh) {
		try {
			Connection con = ConnectDB.getConnection();
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO KhachHang (maKH, hoKH, tenKH, soDT, ngaySinh, gioiTinh, diaChi) VALUES ('" + kh.getMaKH() +"','"+
			kh.getHoKH() + "','" + kh.getTenKH() + "','" +kh.getSoDT() + "','"+ kh.getNgaySinh() + "','"+ kh.isGioiTinh() + "','"+
					kh.getDiaChi()+ "')";
			stmt.executeUpdate(sql);
			stmt.close();
			//con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	// Phat sinh ma
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
