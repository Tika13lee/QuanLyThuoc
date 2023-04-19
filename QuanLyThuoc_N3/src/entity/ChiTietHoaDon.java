package entity;

public class ChiTietHoaDon {
	private Thuoc thuoc;
	private double donGia;
	private int soLuong;
	private String donViTinh;
	private double phiVAT;
	private String moTa;
	private HoaDon hoaDon;

	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChiTietHoaDon(Thuoc thuoc, double donGia, int soLuong, String donViTinh, double phiVAT, String moTa, HoaDon hoaDon) {
		super();
		this.thuoc = thuoc;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.donViTinh = donViTinh;
		this.phiVAT = phiVAT;
		this.moTa = moTa;
		this.hoaDon = hoaDon;
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

	
	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	// tinh tien phai tra
	public double soTienPhaiTra() {
		double tienChuaVAT = soLuong * donGia;
		double tienVAT = tienChuaVAT * phiVAT / 100.0;
		return tienVAT;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [thuoc=" + thuoc + ", donGia=" + donGia + ", soLuong=" + soLuong + ", donViTinh="
				+ donViTinh + ", phiVAT=" + phiVAT + ", moTa=" + moTa + ", hoaDon=" + hoaDon + "]";
	}

	

}
