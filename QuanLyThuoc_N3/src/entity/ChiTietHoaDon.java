package entity;

public class ChiTietHoaDon {
	private Thuoc thuoc;
	private double donGia;
	private int soLuong;
	private String donViTinh;
	private double phiVAT;

	// constructor
	public ChiTietHoaDon() {
		super();
	}

	public ChiTietHoaDon(Thuoc thuoc, double donGia, int soLuong, String donViTinh, double phiVAT) {
		super();
		this.thuoc = thuoc;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.donViTinh = donViTinh;
		this.phiVAT = phiVAT;
	}

	// getter-setter
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

	// tinh tien phai tra
	public double soTienPhaiTra() {
		double tienChuaVAT = soLuong * donGia;
		double tienVAT = tienChuaVAT * phiVAT / 100.0;
		return tienVAT;
	}

	// toString
	public String toString() {
		return "ChiTietHoaDon [Thuoc="+ thuoc +"donGia=" + donGia + ", soLuong=" + soLuong + ", donViTinh=" + donViTinh + ", phiVAT="
				+ phiVAT + ", soTienPhaiTra=" + soTienPhaiTra() + "]";
	}

}
