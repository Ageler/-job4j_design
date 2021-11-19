package Job4j.it.OOD.SRP;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Example3InitAndSave {
    private static Connection connection;

    public void initConnection(String filePath, Properties properties) {
        try (InputStream input = new FileInputStream(filePath)) {
            properties.load(input);
            Class.forName(properties.getProperty("jdbc.driver"));
            String url = properties.getProperty("jdbc.url");
            String login = properties.getProperty("jdbc.username");
            String password = properties.getProperty("jdbc.password");
            connection = DriverManager.getConnection(url, login, password);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean putData(Date date) {
        try (PreparedStatement st = connection.prepareStatement("SELECT *",
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            ResultSet rs = st.getGeneratedKeys();
            st.setTimestamp(1, new Timestamp(date.getTime()));
            st.executeUpdate();
            if (rs != null && rs.next()) {
                return false;
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return true;
    }
}
