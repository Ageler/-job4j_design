package Job4j.it.JDBC;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    public Connection getConnection() {
        return connection;
    }

    private Connection connection;
    private Statement statement;

    private Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }


    private void initConnection() {
        String url = properties.getProperty("jdbc.url");
        String login = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
        try {
            connection = DriverManager.getConnection(url, login, password);
            statement =  connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (id serial primary key," +
                "name varchar(50))";
        statement.executeUpdate(sql);
    }

    public void dropTable(String tableName) throws SQLException {
        String sql = "DROP TABLE IF EXISTS " + tableName;
        statement.executeUpdate(sql);
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        String sql
                = "ALTER TABLE " + tableName +  " ADD COLUMN " +  columnName + " " + type;
        statement.executeUpdate(sql);
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        String sql =
                "ALTER TABLE " + tableName + " DROP COLUMN " +  columnName;
        statement.executeUpdate(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        String sql = "RENAME COLUMN " + tableName + "." + columnName + " TO " + newColumnName;
        statement.executeUpdate(sql);
    }


    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties sqlProp = new Properties();
        sqlProp.load(new FileReader("app.properties"));
        TableEditor tableEditor = new TableEditor(sqlProp);
        tableEditor.createTable("DDD1");
        tableEditor.dropTable("DDD1");

    }
}