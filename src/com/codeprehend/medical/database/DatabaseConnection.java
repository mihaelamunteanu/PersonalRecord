package com.codeprehend.medical.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton class to get the Database Connection Instance
 *
 * @since 4 Dec 2018
 */
public class DatabaseConnection {
    private static final String url = "jdbc:postgresql://localhost:5432/CabinetRugina";
    private static final String user = "postgres";
    private static final String password = "root";
    
	private static Connection conn = null;
	
    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    private static Connection connect() {
        
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
 
        return conn;
    }
    
    /**
     * The public method to get the instance of database connection.
     * 
     * @return Connection - the connection instance to database
     */
    public static Connection getDatabaseConnection() {
    	try {
			if (conn == null || conn.isClosed()) {
				conn = DatabaseConnection.connect();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return conn;
    }

}
