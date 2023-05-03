package entity;

import java.util.Date;

public class Thuoc {
	private String maThuoc;
	private String tenThuoc;
	private String phanLoai;
	private String tacDung;
	private Date ngayHetHan;
	private String donViTinh;
	private int soLuong;
	private double donGia;
	private Date ngaySX;
	private NhaCungCap nhaCC;

	public Thuoc(String maThuoc, String tenThuoc, String phanLoai, String tacDung, Date ngayHetHan, String donViTinh,
			int soLuong, double donGia, Date ngaySX, NhaCungCap nhaCC) {
		super();
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
		this.phanLoai = phanLoai;
		this.tacDung = tacDung;
		this.ngayHetHan = ngayHetHan;
		this.donViTinh = donViTinh;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.ngaySX = ngaySX;
		this.nhaCC = nhaCC;
	}

	public Thuoc(String maThuoc) {
		this.maThuoc = maThuoc;
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

	public String getTacDung() {
		return tacDung;
	}

	public void setTacDung(String tacDung) {
		this.tacDung = tacDung;
	}

	public Date getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
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

	public Date getNgaySX() {
		return ngaySX;
	}

	public void setNgaySX(Date ngaySX) {
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maThuoc == null) ? 0 : maThuoc.hashCode());
		return result;
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
		if (maThuoc == null) {
			if (other.maThuoc != null)
				return false;
		} else if (!maThuoc.equals(other.maThuoc))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Thuoc [maThuoc=" + maThuoc + ", tenThuoc=" + tenThuoc + ", phanLoai=" + phanLoai + ", tacDung="
				+ tacDung + ", ngayHetHan=" + ngayHetHan + ", donViTinh=" + donViTinh + ", soLuong=" + soLuong
				+ ", donGia=" + donGia + ", ngaySX=" + ngaySX + ", nhaCC=" + nhaCC + "]";
	}

}
