package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import connect.ConnectDB;
import entity.NhanVien;

public class NhanVien_DAO {
	public ArrayList<NhanVien> getAllNhanVien(){
		ArrayList<NhanVien> dsNhanViens = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
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
			//rs.close();
			statement.close();
			//con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dsNhanViens;
	}
	
	public String getTenNhanVienByMaNV(String ma){
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

}
