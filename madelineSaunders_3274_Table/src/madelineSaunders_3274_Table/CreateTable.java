package madelineSaunders_3274_Table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	private final String url = "jdbc:postgresql://localhost:5432/test";
    private final String user = "postgres";
    private final String password = "apple";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);

            if (conn != null) {
                System.out.println("Connected to the PostgreSQL server successfully.");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }

        return conn;
    }
    
	public static void main(String[] args) {
		JDBCPostgreSQLConnection app = new JDBCPostgreSQLConnection();
		Connection conn = app.connect();
		int count = 0;

		try {
			Statement stat = conn.createStatement();
			stat.execute("DROP TABLE testtable");
			stat.execute("CREATE TABLE testtable ( Name VARCHAR(20))");
			for (int i = 0; i < 10; i++) {
				stat.execute("INSERT INTO testtable VALUES('Madeline')");
			}
			ResultSet result = stat.executeQuery("SELECT * FROM testtable");
			
			while (result.next()) {
				System.out.println(result.getString("Name"));
				count++;
			}
			System.out.println(count + "(rows)");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}