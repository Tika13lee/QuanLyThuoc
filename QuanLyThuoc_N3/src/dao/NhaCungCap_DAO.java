package dao_;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.NhaCungCap;

public class NhaCungCap_DAO {

	public ArrayList<NhaCungCap> getAllNhaCungCap() {
		ArrayList<NhaCungCap> list = new ArrayList<NhaCungCap>();
		try {
			Connection con = ConnectDB.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM NhaCungCap");

			while (rs.next()) {
				NhaCungCap ncc = new NhaCungCap();
				ncc.setMaNCC(rs.getString("maNCC"));
				ncc.setTenNCC(rs.getString("tenNCC"));
				ncc.setSoDT(rs.getString("SDT"));
				ncc.setEmail(rs.getString("email"));
				ncc.setDiaChi(rs.getString("diaChi"));
				list.add(ncc);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return list;
	}

	// them nha cung cap vao DB
	public void insertNhaCungCap(NhaCungCap ncc) {
		try {
			Connection con = ConnectDB.getConnection();
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO NhaCungCap(maNCC, tenNCC, SDT, email, diaChi) VALUES ('" + ncc.getMaNCC() + "', '"
					+ ncc.getTenNCC() + "', '" + ncc.getSoDT() + "', '" + ncc.getEmail() + "', '" + ncc.getDiaChi()
					+ "')";
			stmt.executeUpdate(sql);
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}