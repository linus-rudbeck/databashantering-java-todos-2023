import java.sql.Connection;
import java.sql.DriverManager;

public abstract class DatabaseManager {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/java_todos";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    protected Connection conn;

    public boolean isConnected = false;

    public DatabaseManager() {
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            isConnected = (conn != null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
