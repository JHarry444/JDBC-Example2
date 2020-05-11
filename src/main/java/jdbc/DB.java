package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

	private Connection conn;

	private Statement stmnt;

	public DB() throws SQLException {
		conn = DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PASSWORD);
	}

	public void create(String fname, String lname) throws SQLException {
		String sql = "INSERT INTO actor (`first_name`, `last_name`) VALUES (`" + fname + "`, `" + lname + "`)";
		this.stmnt = conn.createStatement();
		this.stmnt.execute(sql);
	}

	public void read() throws SQLException {
		this.stmnt = conn.createStatement();
		String sql = "SELECT * FROM actor";
		ResultSet results = this.stmnt.executeQuery(sql);
		while (results.next()) {
			System.out.println(results.getString("first_name") + " " + results.getString("last_name"));
		}

	}

	public void update(String fname, String lname, int id) throws SQLException {
		this.stmnt = conn.createStatement();
		String sql = "UPDATE actor SET first_name = `" + fname + "`, last_name = `" + lname + "` WHERE actor_id = "
				+ id;
		stmnt.executeUpdate(sql);
	}

	public void delete(int id) throws SQLException {
		this.stmnt = conn.createStatement();
		String sql = "DELETE FROM sakila WHERE actor_id = " + id;
		stmnt.executeQuery(sql);
	}

}
