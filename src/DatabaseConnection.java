import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    private final String url = "jdbc:mysql://localhost:3306/banque";
    private final String user = "root";
    private final String password = "password";

    /**
     * Connect to the Mysql database
     *
     * @return a Connection object
     */
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the mysql server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
	public static void executeQuery(String query, Connection conn) {
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			
			if (rs.isBeforeFirst()) {  // Le curseur est-il avant la première ligne ? Sinon pas de données
				while (rs.next()) {
					ResultSetMetaData rsmd = rs.getMetaData();
					int columnsNumber = rsmd.getColumnCount();

					for (int i = 1; i <= columnsNumber; i++) {
						if (i > 1) System.out.print(",  ");
						String columnValue = rs.getString(i);
						System.out.print(columnValue + " " + rsmd.getColumnName(i));
					}
					System.out.println("");
				}
			}else {
				System.out.println("\nAucune donnée n'a été trouvé.");
			}
			
			rs.close();
		}
		catch (SQLException e) {
			System.out.println(e);
		}
	}
}
