package entity;

import java.util.Objects;

public class KhachHang {
	private String maKH;
	private String tenKH;
	private String diaChi;
	private String soDT;
	private String soCCCD;
	private int tuoi;
	private boolean gioiTinh;
	private DiaChi diaChiKH;

	public KhachHang(String maKH, String tenKH, String diaChi, String soDT, String soCCCD, int tuoi, boolean gioiTinh,
			DiaChi diaChiKH) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.soDT = soDT;
		this.soCCCD = soCCCD;
		this.tuoi = tuoi;
		this.gioiTinh = gioiTinh;
		this.diaChiKH = diaChiKH;
	}

	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

	public String getsoCCCD() {
		return soCCCD;
	}

	public void setsoCCCD(String soCCCD) {
		soCCCD = soCCCD;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public DiaChi getDiaChiKH() {
		return diaChiKH;
	}

	public void setDiaChiKH(DiaChi diaChiKH) {
		this.diaChiKH = diaChiKH;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maKH);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(maKH, other.maKH);
	}

	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", diaChi=" + diaChi + ", soDT=" + soDT + ", soCCCD="
				+ soCCCD + ", tuoi=" + tuoi + ", gioiTinh=" + gioiTinh + ", diaChiKH=" + diaChiKH + "]";
	}

}
