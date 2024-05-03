package DTO;

public class bangChamCongDTO {
	private String maBangChamCong;
	private String maNV;
	private String chiTietBangChamCong_maBangChamCong;
	
	public bangChamCongDTO() {
		super();
	}
	public bangChamCongDTO(String maBangChamCong, String maNV, String chiTietBangChamCong_maBangChamCong) {
		super();
		this.maBangChamCong = maBangChamCong;
		this.maNV = maNV;
		this.chiTietBangChamCong_maBangChamCong = chiTietBangChamCong_maBangChamCong;
	}
	
	public String getMaBangChamCong() {
		return maBangChamCong;
	}
	public void setMaBangChamCong(String maBangChamCong) {
		this.maBangChamCong = maBangChamCong;
	}
	
	public String getmaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	
	public String getChiTietBangChamCong_maBangChamCong() {
		return chiTietBangChamCong_maBangChamCong;
	}
	public void setChiTietBangChamCong_maBangChamCong(String chiTietBangChamCong_maBangChamCong) {
		this.chiTietBangChamCong_maBangChamCong = chiTietBangChamCong_maBangChamCong;
	}
}
