package quanlythuoc;

import java.util.Objects;

public class Thuoc {
	private String maThuoc, tenThuoc, maDonVi, maNCC, loaiThuoc;
	private int namSX, soLuong;
	private double donGia;

	public String getMaThuoc() {
		return maThuoc;
	}

	public void setMaThuoc(String maThuoc) {
		this.maThuoc = maThuoc;
	}

	public String getTenThuoc() {
		return tenThuoc;
	}

	public void setTenThuoc(String tenThuoc) {
		this.tenThuoc = tenThuoc;
	}

	public String getMaDonVi() {
		return maDonVi;
	}

	public void setMaDonVi(String maDonVi) {
		this.maDonVi = maDonVi;
	}

	public String getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}

	public String getLoaiThuoc() {
		return loaiThuoc;
	}

	public void setLoaiThuoc(String loaiThuoc) {
		this.loaiThuoc = loaiThuoc;
	}

	public int getNamSX() {
		return namSX;
	}

	public void setNamSX(int namSX) {
		this.namSX = namSX;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public Thuoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Thuoc(String maThuoc, String tenThuoc, String maDonVi, String maNCC, String loaiThuoc, int namSX,
			int soLuong, double donGia) {
		super();
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
		this.maDonVi = maDonVi;
		this.maNCC = maNCC;
		this.loaiThuoc = loaiThuoc;
		this.namSX = namSX;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	@Override
	public String toString() {
		return "Thuoc [maThuoc=" + maThuoc + ", tenThuoc=" + tenThuoc + ", maDonVi=" + maDonVi + ", maNCC=" + maNCC
				+ ", loaiThuoc=" + loaiThuoc + ", namSX=" + namSX + ", soLuong=" + soLuong + ", donGia=" + donGia + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(donGia, loaiThuoc, maDonVi, maNCC, maThuoc, namSX, soLuong, tenThuoc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Thuoc other = (Thuoc) obj;
		return Double.doubleToLongBits(donGia) == Double.doubleToLongBits(other.donGia)
				&& Objects.equals(loaiThuoc, other.loaiThuoc) && Objects.equals(maDonVi, other.maDonVi)
				&& Objects.equals(maNCC, other.maNCC) && Objects.equals(maThuoc, other.maThuoc) && namSX == other.namSX
				&& soLuong == other.soLuong && Objects.equals(tenThuoc, other.tenThuoc);
	}

}
