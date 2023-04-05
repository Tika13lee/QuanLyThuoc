package entity;

import java.util.Objects;

public class NhaCungCap {
	private String maNCC;
	private String tenNCC;
	private String soDT;
	private String email;
	private DiaChi diaChiNCC;

	public NhaCungCap(String maNCC, String tenNCC, String soDT, String email, DiaChi diaChiNCC) {
		super();
		this.maNCC = maNCC;
		this.tenNCC = tenNCC;
		this.soDT = soDT;
		this.email = email;
		this.diaChiNCC = diaChiNCC;
	}

	public NhaCungCap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}

	public String getTenNCC() {
		return tenNCC;
	}

	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}

	public String getSDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		soDT = soDT;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public DiaChi getDiaChiNCC() {
		return diaChiNCC;
	}

	public void setDiaChiNCC(DiaChi diaChiNCC) {
		this.diaChiNCC = diaChiNCC;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNCC);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhaCungCap other = (NhaCungCap) obj;
		return Objects.equals(maNCC, other.maNCC);
	}

	@Override
	public String toString() {
		return "NhaCungCap [maNCC=" + maNCC + ", tenNCC=" + tenNCC + ", soDT=" + soDT + ", email=" + email
				+ ", diaChiNCC=" + diaChiNCC + "]";
	}
	
}
