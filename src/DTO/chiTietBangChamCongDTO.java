package DTO;

import java.time.LocalDateTime;

public class chiTietBangChamCongDTO {
	private String maChiTietBangChamCong;
	private LocalDateTime ngayLap;
	private int soNgayNghi = 0;
//	private String maKhenThuong;
//	private String maKiLuat;
	
	public chiTietBangChamCongDTO() {
		super();
	}
	public chiTietBangChamCongDTO(String maChiTietBangChamCong, LocalDateTime ngayLap, int soNgayNghi) {
		super();
		this.maChiTietBangChamCong = maChiTietBangChamCong;
		this.ngayLap = ngayLap;
		this.soNgayNghi = soNgayNghi;
	}


	public String getmaChiTietBangChamCong() {
		return maChiTietBangChamCong;
	}
	public void setmaChiTietBangChamCong(String maChiTietBangChamCong) {
		this.maChiTietBangChamCong = maChiTietBangChamCong;
	}
	
	public LocalDateTime getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(LocalDateTime ngayLap) {
		this.ngayLap = ngayLap;
	}
	
	public int getsoNgayNghi() {
		return soNgayNghi;
	}
	public void setsoNgayNghi(int soNgayNghi) {
		this.soNgayNghi = soNgayNghi;
	}

//	public String getmaKhenThuong() {
//		return maKhenThuong;
//	}
//	public void setmaKhenThuong(String maKhenThuong) {
//		this.maKhenThuong = maKhenThuong;
//	}
//	
//	public String getmaKiLuat() {
//		return maKiLuat;
//	}
//	public void setmaKiLuat(String maKiLuat) {
//		this.maKiLuat= maKiLuat;
//	}
}
