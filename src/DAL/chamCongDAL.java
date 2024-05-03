package DAL;

import java.sql.*;
import DTO.bangChamCongDTO;
import java.util.ArrayList;

public class chamCongDAL extends connection{
	
	public ArrayList <bangChamCongDTO> getAllBangChamCong(){
		ArrayList <bangChamCongDTO> arr = new ArrayList<bangChamCongDTO>();
		if (openConnection()!=null) {
			try {
				String sql = "select * from bangchamcong";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					bangChamCongDTO bangChamCong = new bangChamCongDTO();
					bangChamCong.setMaBangChamCong(rs.getString("MaBangChamCong"));
					bangChamCong.setMaNV(rs.getString("manv"));
					bangChamCong.setChiTietBangChamCong_maBangChamCong(rs.getString("chiTietBangChanmCong_MaBangChamCong"));
				arr.add(bangChamCong);
				}
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			finally {
				closeConnection();
			}
		}
		return arr;
	}	
	
public boolean hasMaBangChamCong(String id) {
	if (openConnection() != null) {
		try {
			String sql = "select * from bangchamcong "
					+"where mabangchamcong ="+id;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return rs.next();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
	}
	return false;
}
	
public boolean addBangChamCong(bangChamCongDTO tmp) {
	if (openConnection()!= null) {
		try {
			String sql = "insert into bangchamcong "
					+ "values(?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, tmp.getMaBangChamCong());
			stmt.setString(2, tmp.getmaNV());
			stmt.setString(3, tmp.getChiTietBangChamCong_maBangChamCong());
			int row = stmt.executeUpdate();
			return row >0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}}
		return false;
	}
public boolean deleteBangChamCong(String maBangCanXoa) {
	if (openConnection()!=null) {
		try {
			String sql = "delete from bangchamcong "
					+ "where mabangchamcong= ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maBangCanXoa);
			int row = stmt.executeUpdate();
			return row >0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}}
		return false;
	}
	public boolean updateBangChamCong(String maCanSua,bangChamCongDTO tmp) {
		if(openConnection()!= null) {
			try {
				String sql = "update bangchamcong set "+
			"mabangchamcong = ?,"+
			"manv = ?,"+
			"chitietbangchamcong_mabangchamcong = ?"+
			"where mabangchamcong = "+maCanSua;
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, tmp.getMaBangChamCong());
			stmt.setString(2, tmp.getmaNV());
			stmt.setString(3, tmp.getChiTietBangChamCong_maBangChamCong());
			int row = stmt.executeUpdate();
			return row >0;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			finally {
				closeConnection();
			}
		}
			return false;
}}
