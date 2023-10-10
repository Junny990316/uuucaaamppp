package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.CustomerVO;

public class CustomerDAO {
private Connection connection;
	
	public CustomerDAO(String driverClass, String url, String username, String password) {
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
	
	public CustomerVO getUser(String id) {
		PreparedStatement pStmt = null;
		CustomerVO customerVO = null;
		
		String sql = "select * from customer where id = ?";
		
		try {
			pStmt = connection.prepareStatement(sql);
			pStmt.setString(1, id);
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				customerVO = new CustomerVO(rs.getInt("id"), 
						rs.getString("name"), 
						rs.getString("email"), 
						rs.getInt("age"),
						rs.getString("addr"),
						rs.getDate("entryDate"));
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
		return customerVO;
	}
	
	public List<CustomerVO> getCustomerList() {
		PreparedStatement pStmt = null;
		List<CustomerVO> custoemerList = new ArrayList<>();
		
		String sql = "select * from customer order by id";
		
		try {
			pStmt = connection.prepareStatement(sql);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				CustomerVO customerVO = new CustomerVO(rs.getInt("id"), 
						rs.getString("name"), 
						rs.getString("email"), 
						rs.getInt("age"),
						rs.getString("addr"),
						rs.getDate("entryDate"));
				custoemerList.add(customerVO);
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
		return custoemerList;
	}
}
