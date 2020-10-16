package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBManager {
	public static final String JDBCDriverSQLite = "org.sqlite.JDBC";
	public static final String JDBCURLSQLite = "jdbc:sqlite:Viaggio.db";
	
	//public static final String JDBCDriverMySQL = "com.mysql.cj.jdbc.Driver";
	//public static final String JDBCURLMySQL = "jdbc:mysql://localhost:3306/viaggio?user=root&password=M10M14f31";

	protected Statement statement;
	protected Connection connection;

	public DBManager(String JDBCDriver, String JDBCURL) throws ClassNotFoundException, SQLException {
		Class.forName(JDBCDriver);
		connection = DriverManager.getConnection(JDBCURL);
		
		statement = connection.createStatement();
		statement.setQueryTimeout(30);
	}

	public DBManager(String JDBCDriver, String JDBCURL, int resultSetType, int resultSetConcurrency)
			throws ClassNotFoundException, SQLException {
		Class.forName(JDBCDriver);
		connection = DriverManager.getConnection(JDBCURL);
		statement = connection.createStatement(resultSetType, resultSetConcurrency);
		statement.setQueryTimeout(30);
	}
	
	public ResultSet executeQuery(String query) throws SQLException {
		return statement.executeQuery(query);
	}

	public int executeUpdate(String query) throws SQLException {
		return statement.executeUpdate(query);
	}

	public void close() throws SQLException {
		if (connection != null) {
			statement.close();
			connection.close();
		}
	}
}
