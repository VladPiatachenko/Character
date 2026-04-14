package sumdu.edu.ua.db;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseManager {
    private String url;
    private String user;
    private String password;

    public DatabaseManager(String propertiesPath) throws IOException {
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream(propertiesPath);
        properties.load(inputStream);
        inputStream.close();

        url = properties.getProperty("db.url");
        user = properties.getProperty("db.user");
        password = properties.getProperty("db.password");
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    public void initDatabase(String schemaPath) throws SQLException, IOException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();

        BufferedReader reader = new BufferedReader(new FileReader(schemaPath));
        StringBuilder sql = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            sql.append(line);
        }

        reader.close();

        statement.execute(sql.toString());

        statement.close();
        connection.close();
    }
}