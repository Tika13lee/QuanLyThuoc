package entity;

import java.time.LocalDate;
import java.util.Objects;

public class Thuoc {
	private String maThuoc;
	private String tenThuoc;
	private String phanLoai;
	private String hanSD;
	private String donViTinh;
	private int soLuong;
	private double donGia;
	private LocalDate ngaySX;
	private NhaCungCap nhaCC;

	public Thuoc(String maThuoc, String tenThuoc, String phanLoai, String hanSD, String donViTinh, int soLuong,
			double donGia, LocalDate ngaySX, NhaCungCap nhaCC) {
		super();
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
		this.phanLoai = phanLoai;
		this.hanSD = hanSD;
		this.donViTinh = donViTinh;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.ngaySX = ngaySX;
		this.nhaCC = nhaCC;
	}

	public Thuoc() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public String getPhanLoai() {
		return phanLoai;
	}

	public void setPhanLoai(String phanLoai) {
		this.phanLoai = phanLoai;
	}

	public String getHanSD() {
		return hanSD;
	}

	public void setHanSD(String hanSD) {
		this.hanSD = hanSD;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
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

	public LocalDate getNgaySX() {
		return ngaySX;
	}

	public void setNgaySX(LocalDate ngaySX) {
		this.ngaySX = ngaySX;
	}

	public NhaCungCap getNhaCC() {
		return nhaCC;
	}

	public void setNhaCC(NhaCungCap nhaCC) {
		this.nhaCC = nhaCC;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maThuoc);
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
		return Objects.equals(maThuoc, other.maThuoc);
	}

	@Override
	public String toString() {
		return "Thuoc [maThuoc=" + maThuoc + ", tenThuoc=" + tenThuoc + ", phanLoai=" + phanLoai + ", hanSD=" + hanSD
				+ ", donViTinh=" + donViTinh + ", soLuong=" + soLuong + ", donGia=" + donGia + ", ngaySX=" + ngaySX
				+ ", nhaCC=" + nhaCC + "]";
	}

}
