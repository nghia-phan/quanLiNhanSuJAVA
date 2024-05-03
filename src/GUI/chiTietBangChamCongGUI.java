package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

import DTO.chiTietBangChamCongDTO;
import BUS.chiTietBangChamCongBUS;

public class chiTietBangChamCongGUI extends JFrame {
//	protected static final String Interger = null;
	JFrame f = new JFrame();
	JPanel top = new JPanel();
	JPanel bottom = new JPanel();
	DefaultTableModel model = new DefaultTableModel();
	JTable table1= new JTable();
	chiTietBangChamCongBUS chiTietBUS = new chiTietBangChamCongBUS();
	JButton add= new JButton("Thêm");
	JButton set= new JButton("Sửa");
	JButton delete = new JButton("Xóa");


	public chiTietBangChamCongGUI(){
		loadChiTietBang();
//		top();
		bottom();
		
		
		f.setSize(1000,600);
		f.add(top);
		f.add(bottom);
		f.setLayout(new FlowLayout(FlowLayout.CENTER));
//		f.setLayout(new GridLayout(2,1));
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	public void top() {
		top.setPreferredSize(new Dimension(980,350));
		top.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		top.setLayout(new GridLayout());
	}
	public void bottom() {

		
		add.setBackground(Color.green);
		delete.setBackground(Color.red);
		bottom.add(add);
		bottom.add(set);
		bottom.add(delete);
		
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				initDeleteAction();
			}
		});
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				initAddAction();
			}
		});
		
		set.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setAction();
			}
		});
		bottom.setPreferredSize(new Dimension(1000,250));
		bottom.setLayout(new FlowLayout(FlowLayout.CENTER));
	}
	
	public void loadChiTietBang() {
		top.setPreferredSize(new Dimension(980,350));
//		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã chi tiết bảng chấm công");
		model.addColumn("Ngày lập");
		model.addColumn("Số ngày nghỉ");
		table1.setModel(model);
		
		ArrayList<chiTietBangChamCongDTO> list = chiTietBUS.getallChiTietBangChamCong();
		for (int i=0;i<list.size();i++) {
			chiTietBangChamCongDTO chiTiet = list.get(i);
			String maChiTiet = chiTiet.getmaChiTietBangChamCong();
			LocalDateTime ngayLap = chiTiet.getNgayLap();
			int soNgayNghi = chiTiet.getsoNgayNghi();
			Object[] row= {maChiTiet,ngayLap,soNgayNghi};
			model.addRow(row);
		}
//		create scroll bar
		JScrollPane pane = new JScrollPane(table1);
		
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		top.add(pane);
		top.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		top.setLayout(new GridLayout());
	}
	
	public void initAddAction() {
		JTextField maChiTietBangChamCong = new JTextField(20);
		JTextField ngayLap = new JTextField(20);
		JTextField soNgayNghi = new JTextField(20);
		
		JButton confirm = new JButton("OK");
		JButton cancel = new JButton("Cancel");
		
//		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JFrame panel = new JFrame("Thêm");
		panel.setLayout(new GridLayout(4,2));
		panel.setSize(400,200);
		panel.add(new JLabel("Mã chi tiết bảng chấm công"));
		panel.add(maChiTietBangChamCong);
		panel.add(new JLabel("Ngày lập (dd-MM-YYYY HH:mm:ss) :"));
		panel.add(ngayLap);
		panel.add(new JLabel("Số ngày nghỉ"));
		panel.add(soNgayNghi);
		
		panel.add(confirm);
		panel.add(cancel);
		
		panel.setLocationRelativeTo(null);
		panel.setVisible(true);
		
		
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				chiTietBangChamCongDTO add = new chiTietBangChamCongDTO();
				add.setmaChiTietBangChamCong(maChiTietBangChamCong.getText());
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy' 'HH:mm:ss");
				LocalDateTime dateTime = LocalDateTime.parse(ngayLap.getText().trim(), formatter);
				add.setNgayLap(dateTime);
				add.setsoNgayNghi(Integer.parseInt(soNgayNghi.getText()));
				try {
				if (chiTietBUS.addChiTietBangChamCong(add)) {
					JOptionPane.showMessageDialog(null, "Thêm thành công","Hoàn thành",JOptionPane.INFORMATION_MESSAGE);
					panel.dispose();
					Object[] row = {maChiTietBangChamCong.getText(),dateTime,soNgayNghi.getText()};
					model.addRow(row);
				}
				else {
					JOptionPane.showMessageDialog(null, "Thêm thất bại","Thất bại",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
				catch (Exception ex) {
					// TODO: handle exception
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Thêm thất bại, vui lòng nhập đúng định dạng","Thất bại",JOptionPane.INFORMATION_MESSAGE);
				}
				}
		});
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.dispose();
			}
		});
	}
	
	public void setAction() {
		JTextField maCanSua = new JTextField(20);
		JTextField maChiTietBangChamCong = new JTextField(20);
		JTextField ngayLap = new JTextField(20);
		JTextField soNgayNghi = new JTextField(20);
		
		JButton confirm = new JButton("OK");
		JButton cancel = new JButton("Cancel");
		
		JFrame panel = new JFrame("Thêm");
		panel.setLayout(new GridLayout(5,2));
		panel.setSize(400,200);
		
		panel.add(new JLabel("Mã cần sửa"));
		panel.add(maCanSua);
		panel.add(new JLabel("Mã chi tiết bảng chấm công"));
		panel.add(maChiTietBangChamCong);
		panel.add(new JLabel("Ngày lập (dd-MM-YYYY HH:mm:ss) :"));
		panel.add(ngayLap);
		panel.add(new JLabel("Số ngày nghỉ"));
		panel.add(soNgayNghi);
		panel.add(confirm);
		panel.add(cancel);
		
		panel.setLocationRelativeTo(null);
		panel.setVisible(true);
		
		
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				chiTietBangChamCongDTO add = new chiTietBangChamCongDTO();
				add.setmaChiTietBangChamCong(maChiTietBangChamCong.getText());
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy' 'HH:mm:ss");
				LocalDateTime dateTime = LocalDateTime.parse(ngayLap.getText().trim(), formatter);
				add.setNgayLap(dateTime);
				add.setsoNgayNghi(Integer.parseInt(soNgayNghi.getText()));
				try {
				if (chiTietBUS.updateChiTietBangChamCong(maCanSua.getText(), add)) {
					JOptionPane.showMessageDialog(null, "Sửa thành công","Hoàn thành",JOptionPane.INFORMATION_MESSAGE);
					panel.dispose();
					Object [] newData = {maChiTietBangChamCong.getText(),dateTime,soNgayNghi.getText()};
					for (int i = 0; i < model.getRowCount(); i++) {
	                    if (model.getValueAt(i, 0).toString().equals(maCanSua.getText())) {
	                        for (int column = 0;column < newData.length;column++) {
	                        	model.setValueAt(newData[column], i, column);
	                        }
	                    }
	                }
				}
				else {
					JOptionPane.showMessageDialog(null, "Sửa thất bại","Thất bại",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
				catch (Exception ex) {
					// TODO: handle exception
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Sửa thất bại, vui lòng nhập đúng định dạng","Thất bại",JOptionPane.INFORMATION_MESSAGE);
				}
				}
		});
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.dispose();
			}
		});
	}
	
	public void initDeleteAction() {
		String idCanXoa = JOptionPane.showInputDialog(null,"Nhập id cần xóa","Nhập id",JOptionPane.QUESTION_MESSAGE);
		
		if (idCanXoa !=null && !idCanXoa.isEmpty()) {
			int ans = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa?","Xác nhận xóa", JOptionPane.YES_NO_OPTION);
			if (ans == JOptionPane.YES_OPTION) {
				if (chiTietBUS.deleteChiTietBangChamCong(idCanXoa)) {
					JOptionPane.showMessageDialog(null, "Xóa thành công","Hoàn thành",JOptionPane.INFORMATION_MESSAGE);
					 for (int i = 0; i < model.getRowCount(); i++) {
		                    if (model.getValueAt(i, 0).toString().equals(idCanXoa)) {
		                        model.removeRow(i);
		                        break;
		                    }
		                }
				}
				else {
					JOptionPane.showMessageDialog(null, "Xóa thất bại","Thất bại",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		else if(idCanXoa == null) {
			
		}
		else {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập id","Lỗi",JOptionPane.ERROR_MESSAGE);
		}
	}
}
