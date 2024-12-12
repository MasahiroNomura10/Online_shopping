package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.UserBean;

public class TopDAO{
	
	public static boolean userSearch(String userName,String password)throws SQLException,ClassNotFoundException{
		boolean i=false;
		String sql ="SELECT * FROM user_table WHERE user_name=? AND password=?";
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement psmt = con.prepareStatement(sql)){
			
				psmt.setString(1, userName);
				psmt.setString(2, password);
				
				try(ResultSet rs = psmt.executeQuery()){
					if(rs.next()) {
						i=true;
					}					
				}
		}
		return i;
	}
	
	public List<UserBean> getAllUser() throws SQLException,ClassNotFoundException{
		List<UserBean> userList = new ArrayList<>();
		String sql = "SELECT * FROM user_table";
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement psmt =con.prepareStatement(sql);
				ResultSet rs = psmt.executeQuery()){
					
					while(rs.next()) {
						UserBean user = new UserBean();
						user.setUserName(rs.getString("user_name"));
						user.setMailAddres(rs.getString("mail_addres"));
						user.setPassword(rs.getString("password"));
						user.setMoney(Integer.parseInt(rs.getString("money")));
					}
				}
		return userList;
	}
	
	public boolean acountSearch(String userName)throws SQLException,ClassNotFoundException{
		String sql ="SELECT COUNT(*) FROM user_table WHERE user_name=?";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement psmt = con.prepareStatement(sql)){
				psmt.setString(1, userName);
				try(ResultSet rs =psmt.executeQuery()){
//				rs.nextはレコード全部見るため。getIntは、レコードでヒットした件数。
//				一件でもあれば
				if(rs.next()) {
					return rs.getInt(1)>0;
					
				}
			}
		}
		return false;
	}
	
	public boolean acountCreate(UserBean user) throws SQLException,ClassNotFoundException{
		boolean result=false;
		int count =0;
		String sql ="INSERT INTO user_table (user_name,mail_addres,password,money)VALUES(?,?,?,?)";
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement psmt = con.prepareStatement(sql)){
				
				psmt.setString(1,user.getUserName());
				psmt.setString(2, user.getMailAddres());
				psmt.setString(3, user.getPassword());
				psmt.setString(4,String.valueOf(user.getMoney()));
				
				count=psmt.executeUpdate();
				if(count>0) {
					result=true;
				}
		}
		return result;
	}
}