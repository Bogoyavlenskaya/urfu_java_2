package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
    public static Connection connectDb() throws SQLException {
        String url="jdbc:postgresql://localhost:5432/exercise_db";
        String user="postgres";
        String password="postgres";
        return DriverManager.getConnection(url,user,password);
    }

}
