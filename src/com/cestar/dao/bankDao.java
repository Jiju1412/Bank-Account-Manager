package com.cestar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cestar.model.bank;

public class bankDao {

	
	public Connection getConnection() {

		String url = "jdbc:mysql://localhost:3306/cestar";

		String user = "root";

		String pwd = "";

		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pwd);

			System.out.println("Connection Successful!!!");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}
	
	public int addRec(bank b) {

		Connection con = getConnection();

		String sql = "insert into bank values (?,?,?,?,?,?)";

		int status = 0;

		try {

			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, b.getAccountId());

			pstmt.setString(2, b.getAccountType());

			pstmt.setString(3, b.getAccountName());

			pstmt.setString(4, b.getAccountContact());

			pstmt.setString(5, b.getAccountBalance());
			
			pstmt.setString(6, b.getAccountDate());

			status = pstmt.executeUpdate();

			if (status > 0) {

				System.out.println("Record Inserted Successfuly!");
			} else {

				System.out.println("Try Again!!");
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return status;
	}
	
	public List<bank> displayAllRec() {
		
		Connection con = getConnection();

		String sql = "select * from bank";

		List<bank> bnk = new ArrayList<>();

		try {

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				bank b = new bank(rs.getInt("accountId"), rs.getString("accountType"), rs.getString("accountName"),
						rs.getString("accountContact"), rs.getString("accountBalance"),rs.getString("accountDate"));

				bnk.add(b);
			}

			System.out.println(bnk);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bnk;

	}
	
	public int updtaeRec(int old_id,bank Updated_bnk) {
		
		Connection con = getConnection();
		
		String sql = "update bank set accountId=?,accountType=?,accountName=?,accountContact=?,accountBalance=?, accountDate=? where accountId=?";
		
		int status = 0 ;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
		
		    pstmt.setInt(1,Updated_bnk.getAccountId());
		
		    pstmt.setString(2,Updated_bnk.getAccountType());
		    
		    pstmt.setString(3,Updated_bnk.getAccountName());
		    
		    pstmt.setString(4,Updated_bnk.getAccountContact());
		    
		    pstmt.setString(5, Updated_bnk.getAccountBalance());
		    
		    pstmt.setString(6, Updated_bnk.getAccountDate());
		    
		    pstmt.setInt(7, old_id);
		
		
		    status = pstmt.executeUpdate();
		    
		    if(status>0) {
		    	
		    	System.out.println("Record Updated:");
		    }
		    else {
		    	
		    	System.out.println("Try Again:");
		    }
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;		
	}
	
	public void deleteRec(int id) {
		
		Connection con = getConnection();
		
		String sql = "delete from bank where accountId=?";
		
		int status = 0 ;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			status = pstmt.executeUpdate();
			
			if(status>0) {
				
				System.out.println("Record deleted!");
			}
			
			else {
				
				System.out.println("Try again!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public bank getRecById(int id) {
		
		Connection con = getConnection();
		
		String sql = "select * from bank where accountId=?";
		
		int status = 0;
		
		bank bnk = null;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				bnk = new bank(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)); 
			}
			
			System.out.println(bnk);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bnk;
	}
		
}
