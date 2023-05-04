package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import connect.ConnectDB;
import entity.NhaCungCap;
import entity.Thuoc;

public class Thuoc_DAO {
	public Thuoc_DAO() {

	}

	/*
	 * lấy tất cả data từ sql lên table;
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
				String td = rs.getString("tacDung");
				Date ngaySX = rs.getDate("ngaySX");
				Date ngayHH = rs.getDate("ngayHetHan");
				String donViTinh = rs.getString("donViTinh");
				int soLuong = rs.getInt("soLuong");
				double dongia = rs.getDouble("donGia");
				NhaCungCap ncc = new NhaCungCap(rs.getString("maNCC"));

				Thuoc thuoc = new Thuoc(ma, ten, phanLoai, td, ngayHH, donViTinh, soLuong, dongia, ngaySX, ncc);
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
				String td = rs.getString(4);
				Date ngaySX = rs.getDate(5);
				Date ngayHH = rs.getDate(6);
				String donViTinh = rs.getString(7);
				int soLuong = rs.getInt(8);
				double dongia = rs.getDouble(9);
				NhaCungCap ncc = new NhaCungCap(rs.getString(10));
				Thuoc thuoc = new Thuoc(ma, ten, phanLoai, td, ngayHH, donViTinh, soLuong, dongia, ngaySX, ncc);
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
	 * lấy data thuốc theo tác dụng;
	 */
	public ArrayList<Thuoc> getAllThuocTheoTacDung(String td) {
		ArrayList<Thuoc> ds = new ArrayList<Thuoc>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;
		String sql = "select * from Thuoc where tacDung = ?";

		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, td);
			rs = statement.executeQuery();
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String phanLoai = rs.getString(3);
				String tdung = rs.getString(4);
				Date ngaySX = rs.getDate(5);
				Date ngayHH = rs.getDate(6);
				String donViTinh = rs.getString(7);
				int soLuong = rs.getInt(8);
				double dongia = rs.getDouble(9);
				NhaCungCap ncc = new NhaCungCap(rs.getString(10));
				Thuoc thuoc = new Thuoc(ma, ten, phanLoai, tdung, ngayHH, donViTinh, soLuong, dongia, ngaySX, ncc);
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
	 * lấy data thuốc theo mã nhà cung cấp;
	 */
	public ArrayList<Thuoc> getAllThuocTheoNCC(String maNcc) {
		ArrayList<Thuoc> ds = new ArrayList<Thuoc>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;
		String sql = "select * from Thuoc where maNCC = ?";

		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, maNcc);
			rs = statement.executeQuery();
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String phanLoai = rs.getString(3);
				String tdung = rs.getString(4);
				Date ngaySX = rs.getDate(5);
				Date ngayHH = rs.getDate(6);
				String donViTinh = rs.getString(7);
				int soLuong = rs.getInt(8);
				double dongia = rs.getDouble(9);
				NhaCungCap ncc = new NhaCungCap(rs.getString(10));
				Thuoc thuoc = new Thuoc(ma, ten, phanLoai, tdung, ngayHH, donViTinh, soLuong, dongia, ngaySX, ncc);
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
	 * thêm thuốc
	 */
	public boolean createThuoc(Thuoc t) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into" + " Thuoc values (?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, t.getMaThuoc());
			stmt.setString(2, t.getTenThuoc());
			stmt.setString(3, t.getPhanLoai());
			stmt.setString(4, t.getTacDung());
			stmt.setDate(5, (java.sql.Date) t.getNgaySX());
			stmt.setDate(6, (java.sql.Date) t.getNgayHetHan());
			stmt.setString(7, t.getDonViTinh());
			stmt.setDouble(8, t.getDonGia());
			stmt.setInt(9, t.getSoLuong());
			stmt.setString(10, t.getNhaCC().getMaNCC());
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
	 * update Thuoc
	 */
	public void update(Thuoc t) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(
					"update Thuoc set tenThuoc = ?, phanLoai = ?, ngaySX = ?, ngayHetHan = ?, donViTinh = ?, donGia = ?, soLuong = ?, maNCC = ? where maThuoc = ?");
			stmt.setString(1, t.getTenThuoc());
			stmt.setString(2, t.getPhanLoai());

			java.sql.Date sqlNgaysx = new java.sql.Date(t.getNgaySX().getTime());
			java.sql.Date sqlNgayHH = new java.sql.Date(t.getNgayHetHan().getTime());
			stmt.setDate(3, sqlNgaysx);
			stmt.setDate(4, sqlNgayHH);
			stmt.setString(5, t.getDonViTinh());
			stmt.setDouble(6, t.getDonGia());
			stmt.setInt(7, t.getSoLuong());
			stmt.setString(8, t.getNhaCC().getMaNCC());
			stmt.setString(9, t.getMaThuoc()); // sửa đổi giá trị của đối số này

			int n = stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/*
	 * xóa thuốc
	 */
	public boolean delete(Thuoc t) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete Thuoc where maThuoc = ?");
			stmt.setString(1, t.getMaThuoc());
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
	 * lấy số lượng thuốc
	 */
	public int getSoluong() {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT TOP 1 mathuoc FROM Thuoc ORDER BY mathuoc desc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				String temp = rs.getString("mathuoc");
				temp = temp.replace("T", "");
				return Integer.parseInt(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	/*
	 * get all Thuốc theo Tên
	 */

	public ArrayList<Thuoc> getAllThuocTheoTenThuoc(String tenThuoc) {
		ArrayList<Thuoc> ds = new ArrayList<Thuoc>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		String sql = "Select * from Thuoc where tenThuoc = ?";

		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, tenThuoc);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String ma = rs.getString("maThuoc");
				String ten = rs.getString("tenThuoc");
				String phanLoai = rs.getString("phanLoai");
				String td = rs.getString("tacDung");
				Date ngaySX = rs.getDate("ngaySX");
				Date ngayHH = rs.getDate("ngayHetHan");
				String donViTinh = rs.getString("donViTinh");
				int soLuong = rs.getInt("soLuong");
				double dongia = rs.getDouble("donGia");
				NhaCungCap ncc = new NhaCungCap(rs.getString("maNCC"));
				Thuoc thuoc = new Thuoc(ma, ten, phanLoai, td, ngayHH, donViTinh, soLuong, dongia, ngaySX, ncc);
				ds.add(thuoc);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ds;
	}

	/*
	 * get thuốc theo mã thuôc
	 */
	public ArrayList<Thuoc> getAllThuocTheoMaThuoc(String maThuoc) {
		ArrayList<Thuoc> ds = new ArrayList<Thuoc>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		String sql = "Select * from Thuoc where maThuoc = ?";

		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, maThuoc);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String ma = rs.getString("maThuoc");
				String ten = rs.getString("tenThuoc");
				String phanLoai = rs.getString("phanLoai");
				String td = rs.getString("tacDung");
				Date ngaySX = rs.getDate("ngaySX");
				Date ngayHH = rs.getDate("ngayHetHan");
				String donViTinh = rs.getString("donViTinh");
				int soLuong = rs.getInt("soLuong");
				double dongia = rs.getDouble("donGia");
				NhaCungCap ncc = new NhaCungCap(rs.getString("maNCC"));
				Thuoc thuoc = new Thuoc(ma, ten, phanLoai, td, ngayHH, donViTinh, soLuong, dongia, ngaySX, ncc);
				ds.add(thuoc);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ds;
	}

	/*
	 * get all thuốc hết hạn sử dụng
	 */
	public ArrayList<Thuoc> getThuocHetHan() {
		ArrayList<Thuoc> dsThuoc = new ArrayList<Thuoc>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "SELECT * FROM Thuoc WHERE ngayHetHan < GETDATE()";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString("maThuoc");
				String ten = rs.getString("tenThuoc");
				String phanLoai = rs.getString("phanLoai");
				String td = rs.getString("tacDung");
				Date ngaySX = rs.getDate("ngaySX");
				Date ngayHH = rs.getDate("ngayHetHan");
				String donViTinh = rs.getString("donViTinh");
				int soLuong = rs.getInt("soLuong");
				double dongia = rs.getDouble("donGia");
				NhaCungCap ncc = new NhaCungCap(rs.getString("maNCC"));

				Thuoc thuoc = new Thuoc(ma, ten, phanLoai, td, ngayHH, donViTinh, soLuong, dongia, ngaySX, ncc);
				dsThuoc.add(thuoc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThuoc;
	}

}
