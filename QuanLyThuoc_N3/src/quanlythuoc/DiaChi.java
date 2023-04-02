package quanlythuoc;

import java.util.Objects;

public class DiaChi {
	private String maDiaChi;
	private String soNha, tenPhuong, phuong, quan, thanhPho, quocGia;

	public String getMaDiaChi() {
		return maDiaChi;
	}

	public void setMaDiaChi(String maDiaChi) {
		this.maDiaChi = maDiaChi;
	}

	public String getSoNha() {
		return soNha;
	}

	public void setSoNha(String soNha) {
		this.soNha = soNha;
	}

	public String getTenPhuong() {
		return tenPhuong;
	}

	public void setTenPhuong(String tenPhuong) {
		this.tenPhuong = tenPhuong;
	}

	public String getPhuong() {
		return phuong;
	}

	public void setPhuong(String phuong) {
		this.phuong = phuong;
	}

	public String getQuan() {
		return quan;
	}

	public void setQuan(String quan) {
		this.quan = quan;
	}

	public String getThanhPho() {
		return thanhPho;
	}

	public void setThanhPho(String thanhPho) {
		this.thanhPho = thanhPho;
	}

	public String getQuocGia() {
		return quocGia;
	}

	public void setQuocGia(String quocGia) {
		this.quocGia = quocGia;
	}

	public DiaChi(String maDiaChi, String soNha, String tenPhuong, String phuong, String quan, String thanhPho,
			String quocGia) {
		super();
		this.maDiaChi = maDiaChi;
		this.soNha = soNha;
		this.tenPhuong = tenPhuong;
		this.phuong = phuong;
		this.quan = quan;
		this.thanhPho = thanhPho;
		this.quocGia = quocGia;
	}

	public DiaChi() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(maDiaChi, phuong, quan, quocGia, soNha, tenPhuong, thanhPho);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiaChi other = (DiaChi) obj;
		return Objects.equals(maDiaChi, other.maDiaChi) && Objects.equals(phuong, other.phuong)
				&& Objects.equals(quan, other.quan) && Objects.equals(quocGia, other.quocGia)
				&& Objects.equals(soNha, other.soNha) && Objects.equals(tenPhuong, other.tenPhuong)
				&& Objects.equals(thanhPho, other.thanhPho);
	}

	@Override
	public String toString() {
		return "DiaChi [maDiaChi=" + maDiaChi + ", soNha=" + soNha + ", tenPhuong=" + tenPhuong + ", phuong=" + phuong
				+ ", quan=" + quan + ", thanhPho=" + thanhPho + ", quocGia=" + quocGia + "]";
	}

}
