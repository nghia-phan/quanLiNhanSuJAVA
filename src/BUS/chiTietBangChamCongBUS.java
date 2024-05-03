package BUS;

import DAL.chiTietChamCongDAL;
import DTO.chiTietBangChamCongDTO;

import java.sql.Connection;
import java.util.ArrayList;

public class chiTietBangChamCongBUS {
	private ArrayList<chiTietBangChamCongDTO> listChiTiet;
	private chiTietChamCongDAL dal = new chiTietChamCongDAL();
//	constructor
	public chiTietBangChamCongBUS() {
		this.listChiTiet = dal.getAllChiTietBangChamCong();
	}

	public void setListChiTiet(ArrayList<chiTietBangChamCongDTO> listChiTiet) {
		this.listChiTiet = listChiTiet;
	}
	public ArrayList<chiTietBangChamCongDTO> getallChiTietBangChamCong(){
		return listChiTiet;
	}
	
//	phuong thuc them
	public boolean addChiTietBangChamCong(chiTietBangChamCongDTO chiTiet) {
		if (chiTiet == null) {
			return false;
		}
		if(dal.hasMaChiTietBangChamCong(chiTiet.getmaChiTietBangChamCong())) {
			return false;
		}
		return dal.addChiTietBangChamCong(chiTiet);
	}
//	phuong thuc xoa
	public boolean deleteChiTietBangChamCong(String tmp) {
		for (chiTietBangChamCongDTO chiTiet : listChiTiet) {
			if (chiTiet.getmaChiTietBangChamCong().equals(tmp)) {
				listChiTiet.remove(chiTiet);
				dal.delete(tmp);
				return true;
			}
		}
		return false;
	}
//	phuong thuc sua
	public boolean updateChiTietBangChamCong(String maChiTietCanSua, chiTietBangChamCongDTO tmp) {
		for (chiTietBangChamCongDTO chiTiet : listChiTiet) {
			if (chiTiet.getmaChiTietBangChamCong().equals(maChiTietCanSua)) {
				int index = listChiTiet.indexOf(chiTiet);
				listChiTiet.set(index, tmp);
				dal.update(maChiTietCanSua,tmp);
				System.out.println("sua thanh cong");
				return true;
			}
		}
		return false;
	}
}
