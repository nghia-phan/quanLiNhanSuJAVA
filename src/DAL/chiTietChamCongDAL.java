package DAL;

import DTO.chiTietBangChamCongDTO;
import java.sql.*;
import java.util.ArrayList;


public class chiTietChamCongDAL extends connection{
	
	public ArrayList<chiTietBangChamCongDTO> getAllChiTietBangChamCong(){
//		openConnection();
		ArrayList<chiTietBangChamCongDTO> array = new ArrayList<chiTietBangChamCongDTO>();
		if (openConnection() != null) {
			try {
				String sql = "Select * from chitietbangchamcong";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					chiTietBangChamCongDTO chamCong = new chiTietBangChamCongDTO();
					chamCong.setmaChiTietBangChamCong(rs.getString("MaChiTietBangChamCong"));
					chamCong.setNgayLap(rs.getTimestamp("NgayLap").toLocalDateTime());
					chamCong.setsoNgayNghi(rs.getInt("SoNgayNghi"));
				array.add(chamCong);
				}
				
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("cannot set");
			}
			finally {
				closeConnection();
			}
		}
		return array;
	}
//	them
	public boolean addChiTietBangChamCong(chiTietBangChamCongDTO tmp) {
		Connection conn = openConnection();
			try {
				String sql="insert into chitietbangchamcong (machitietbangchamcong, ngaylap, songaynghi) values(?, ?, ?)";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, tmp.getmaChiTietBangChamCong());
				stmt.setTimestamp(2, Timestamp.valueOf(tmp.getNgayLap()));
				stmt.setInt(3, tmp.getsoNgayNghi());
				
				int row = stmt.executeUpdate();
				return row > 0;
				
			}catch (SQLException ex) {
				ex.printStackTrace();
			}
				closeConnection();
				return false;
	}
//	xoa
	public boolean delete(String tmp) {
		Connection conn = openConnection();
		try {
			String sql = "delete from ChiTietBangChamCong where MaChiTIetBangChamCong = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, tmp);
			int rows = pst.executeUpdate();
			return rows > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection();
		return false;
	}
//	sua
	public boolean update(String maCanSua,chiTietBangChamCongDTO tmp) {
		Connection conn = openConnection();
		
		try {
			String sql = "update chiTietBangChamCong set "+ 
						"maChiTietBangChamCong = ? ,"+
						"ngayLap = ? ,"+
						"soNgayNghi = ? "+ 
						"where maChiTietBangChamCong = "+maCanSua;
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, tmp.getmaChiTietBangChamCong());
			pst.setTimestamp(2, Timestamp.valueOf(tmp.getNgayLap()));
			pst.setInt(3, tmp.getsoNgayNghi());
			int rows = pst.executeUpdate();
			return rows > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		closeConnection();
		return false;
	}
	
	
	public boolean hasMaChiTietBangChamCong(String id) {
		Connection con = openConnection();
		if (con != null) {
			try {
				String sql = "select * from chitietbangchamcong "
						+ "where machitietbangchamcong="+id;
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
	
}
