package entity;

import java.sql.Date;
import java.util.Objects;

public class KhachHang {
	private String maKH;
	private String hoKH;
	private String tenKH;
	private String diaChi;
	private String soDT;
	private Date ngaySinh;
	private boolean gioiTinh;

	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KhachHang(String maKH) {
		this.maKH = maKH;
	}

	public KhachHang(String maKH, String hoKH, String tenKH, String diaChi, String soDT, Date ngaySinh,
			boolean gioiTinh) {
		super();
		this.maKH = maKH;
		this.hoKH = hoKH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.soDT = soDT;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getHoKH() {
		return hoKH;
	}

	public void setHoKH(String hoKH) {
		this.hoKH = hoKH;
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

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
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
		return "KhachHang [maKH=" + maKH + ", hoKH=" + hoKH + ", tenKH=" + tenKH + ", diaChi=" + diaChi + ", soDT="
				+ soDT + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + "]";
	}

}
