package com.motel.app.database;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Factory class for obtaining connections to the Access database.
 */
public final class AccessConnectionFactory {

    private static final String DB_RESOURCE = "db/controle.mdb";

    private AccessConnectionFactory() {
        // Prevent instantiation
    }

    /**
     * Returns a {@link Connection} to the Access database.
     *
     * @return a database connection
     * @throws SQLException if the database file cannot be found or a connection cannot be established
     */
    public static Connection getConnection() throws SQLException {
        URL resource = AccessConnectionFactory.class.getClassLoader().getResource(DB_RESOURCE);
        if (resource == null) {
            throw new SQLException("Database file not found.");
        }
        String dbPath = new File(resource.getFile()).getAbsolutePath();
        String url = "jdbc:ucanaccess://" + dbPath;
        return DriverManager.getConnection(url);
    }
}
