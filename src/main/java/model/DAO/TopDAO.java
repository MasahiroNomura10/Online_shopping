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
				PreparedStatement psmt =con.prepareStatement(sql));
				ResultSet rs = psmt.executeQuery()){
					
					while(rs.next()) {
						UserBean user = new UserBean();
						user.setUserID(rs.getString("user_id"));
						user.setUserName(rs.getString("user_name"));
						user.setMailAddres(rs.getString("mail_addres"));
						user.setPassword(rs.getString("password"));
						
					}
				}
	}
}