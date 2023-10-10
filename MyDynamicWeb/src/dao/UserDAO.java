package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.UserVO;

public class UserDAO {
	private Connection connection;
	
	public UserDAO(String driverClass, String url, String username, String password) {
		// Driver Class Loading
		try {
			Class.forName(driverClass);
			
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void connectionClose() {
		if(connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public UserVO getUser(String userId) {
		PreparedStatement pStmt = null;
		UserVO userVO = null;
		
		String sql = "select * from users where userid = ?";
		
		try {
			pStmt = connection.prepareStatement(sql);
			pStmt.setString(1, userId);
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				userVO = new UserVO(rs.getInt("id"), 
						rs.getString("userid"), 
						rs.getString("name"), 
						rs.getString("gender"), 
						rs.getString("city"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {
					if(pStmt != null)					
					pStmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return userVO;
	}
	
	public List<UserVO> getUserList() {
		PreparedStatement pStmt = null;
		List<UserVO> userList = new ArrayList<>();
		
		String sql = "select * from users order by id";
		
		try {
			pStmt = connection.prepareStatement(sql);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				UserVO userVO = new UserVO(rs.getInt("id"), 
						rs.getString("userid"), 
						rs.getString("name"), 
						rs.getString("gender"), 
						rs.getString("city"));
				userList.add(userVO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {
					if(pStmt != null)					
					pStmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return userList;
	}
}
