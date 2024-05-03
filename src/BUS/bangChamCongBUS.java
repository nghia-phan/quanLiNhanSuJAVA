package BUS;

import DTO.bangChamCongDTO;
import DAL.chamCongDAL;
import java.util.ArrayList;

public class bangChamCongBUS {
	private ArrayList<bangChamCongDTO> listChamCong;
	private chamCongDAL dal = new chamCongDAL();
	
	
	public bangChamCongBUS() {
		this.listChamCong = dal.getAllBangChamCong();
	}


	public ArrayList<bangChamCongDTO> getListChamCong() {
		return listChamCong;
	}
	public void setListChamCong(ArrayList<bangChamCongDTO> listChamCong) {
		this.listChamCong = listChamCong;
	}

//	them
	public boolean addBangChamCong(bangChamCongDTO tmp) {
		if (tmp == null) {
			return false;
		}
		if (dal.hasMaBangChamCong(tmp.getMaBangChamCong())) {
			return false;
		}
		return dal.addBangChamCong(tmp);
	}
	
	public boolean deleteBangChamCong(String maCanXoa) {
		for (bangChamCongDTO bangChamCong : listChamCong) {
			if (bangChamCong.getMaBangChamCong().equals(maCanXoa)) {
				listChamCong.remove(bangChamCong);
				dal.deleteBangChamCong(maCanXoa);
				return true;
			}
		}
		return false;
	}
	
	public boolean updateBangChamCong(String maBangCanSua,bangChamCongDTO bangChamCong) {
		for (bangChamCongDTO list : listChamCong) {
			if (list.getMaBangChamCong().equals(maBangCanSua)) {
				int index = listChamCong.indexOf(list);
				listChamCong.set(index, bangChamCong);
				dal.updateBangChamCong(maBangCanSua,bangChamCong);
				return true;
			}
		}
		return false;
	}
	
}
