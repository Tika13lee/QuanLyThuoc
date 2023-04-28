package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.TaiKhoan;

public class TaiKhoan_DAO {
	public TaiKhoan_DAO() {

	}

	public ArrayList<TaiKhoan> getAllTaiKhoan() {
		ArrayList<TaiKhoan> dsTK = new ArrayList<TaiKhoan>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select * from TaiKhoan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String loai = rs.getString(3);
				String pass = rs.getString(4);
				TaiKhoan tk = new TaiKhoan(ma, ten, loai, pass);
				dsTK.add(tk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsTK;
	}
}
