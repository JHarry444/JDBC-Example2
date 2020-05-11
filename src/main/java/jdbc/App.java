package jdbc;

import java.sql.SQLException;

public class App {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		DB db = new DB();
		db.create("Brad", "Pitt");
		db.read();
	}

}
