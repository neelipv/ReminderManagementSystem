package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReminderDB {

	private static final String URL = "jdbc:sqlite:C:\\Users\\Acer\\MySQLiteDB";

	private static Connection conn;

	public static Connection DBConnection() {
		try {
			conn = DriverManager.getConnection(URL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	public int addReminder(ReminderBean r) {
		String sql = "insert into ReminderDB (event,date1) values(?,?)";

		try {
			Connection conn = DBConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getEvent());
			pstmt.setString(2, r.getDate());
			pstmt.executeUpdate();
			System.out.println("Insert Successfull !");
			return 1;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	public int updateReminder(ReminderBean r) {
		String sql = "update ReminderDB set event=?,date1=? where id=?;";

		try {
			Connection conn = DBConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getEvent());
			pstmt.setString(2, r.getDate());
			pstmt.setInt(3, r.getId());
			pstmt.executeUpdate();
			System.out.println("Updated Successfull !");
			return 1;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	public void viewAll() {
		try {
			Connection conn = DBConnection();

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from ReminderDB");
			System.out.println("\nID\t" +"Events\t\t\t" + "Date");
			while (rs.next()) {
				System.out.println(rs.getInt("id") + "\t" + rs.getString("event") + "\t\t\t" + rs.getString("date1"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
