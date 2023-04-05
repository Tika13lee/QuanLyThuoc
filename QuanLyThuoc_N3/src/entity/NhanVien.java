package entity;

import java.util.Objects;

public class NhanVien {
	private String maNV;
	private String tenNV;
	private int tuoi;
	private String soCCCD;
	private boolean gioiTinh;
	private TaiKhoan taiKhoan;
	private DiaChi diaChiNV;

	public NhanVien(String maNV, String tenNV, int tuoi, String soCCCD, boolean gioiTinh, TaiKhoan taiKhoan,
			DiaChi diaChiNV) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.tuoi = tuoi;
		this.soCCCD = soCCCD;
		this.gioiTinh = gioiTinh;
		this.taiKhoan = taiKhoan;
		this.diaChiNV = diaChiNV;
	}

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getSoCCCD() {
		return soCCCD;
	}

	public void setSoCCCD(String soCCCD) {
		this.soCCCD = soCCCD;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public DiaChi getDiaChiNV() {
		return diaChiNV;
	}

	public void setDiaChiNV(DiaChi diaChiNV) {
		this.diaChiNV = diaChiNV;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNV, other.maNV);
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", tuoi=" + tuoi + ", soCCCD=" + soCCCD + ", gioiTinh="
				+ gioiTinh + ", taiKhoan=" + taiKhoan + ", diaChiNV=" + diaChiNV + "]";
	}

}
