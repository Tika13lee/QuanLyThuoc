package entity;

import java.util.Objects;

public class TaiKhoan {
	private String maTK;
	private String tenTK;
	private String loaiTK;
	private String matKhau;

	public TaiKhoan(String maTK, String tenTK, String loaiTK, String matKhau) {
		super();
		this.maTK = maTK;
		this.tenTK = tenTK;
		this.loaiTK = loaiTK;
		this.matKhau = matKhau;
	}

	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaTK() {
		return maTK;
	}

	public void setMaTK(String maTK) {
		this.maTK = maTK;
	}

	public String getTenTK() {
		return tenTK;
	}

	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}

	public String getLoaiTK() {
		return loaiTK;
	}

	public void setLoaiTK(String loaiTK) {
		this.loaiTK = loaiTK;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maTK);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(maTK, other.maTK);
	}

	@Override
	public String toString() {
		return "TaiKhoan [maTK=" + maTK + ", tenTK=" + tenTK + ", loaiTK=" + loaiTK + ", matKhau=" + matKhau + "]";
	}

}
