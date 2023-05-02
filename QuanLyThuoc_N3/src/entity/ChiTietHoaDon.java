package entity;

public class ChiTietHoaDon {
	private Thuoc thuoc;
	private double donGia;
	private int soLuong;
	private String donViTinh;
	private double phiVAT;
	private HoaDon hoaDon;
	private double thanhTien;

	public ChiTietHoaDon(Thuoc thuoc, double donGia, int soLuong, String donViTinh, double phiVAT, HoaDon hoaDon,
			double thanhTien) {
		super();
		this.thuoc = thuoc;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.donViTinh = donViTinh;
		this.phiVAT = phiVAT;
		this.hoaDon = hoaDon;
		this.thanhTien = thanhTien;
	}

	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Thuoc getThuoc() {
		return thuoc;
	}

	public void setThuoc(Thuoc thuoc) {
		this.thuoc = thuoc;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public double getPhiVAT() {
		return phiVAT;
	}

	public void setPhiVAT(double phiVAT) {
		this.phiVAT = phiVAT;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [thuoc=" + thuoc + ", donGia=" + donGia + ", soLuong=" + soLuong + ", donViTinh="
				+ donViTinh + ", phiVAT=" + phiVAT + ", hoaDon=" + hoaDon + ", thanhTien=" + thanhTien + "]";
	}

}
