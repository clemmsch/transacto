package me.panem.transacto.SQL;

import me.panem.transacto.Utils.MysqliConnectionHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySql
{
    MysqliConnectionHandler handler = new MysqliConnectionHandler();
    private String host = "127.0.0.1";
    private String port = "3006"; // FIXME
    private String database = "transacto";
    private String username = "root";
    // TODO Add
    private String password = "";

    private Connection connection;

    public boolean isConnected() {
        return (connection == null ? false : true);
    }

    public void connect() throws ClassNotFoundException, SQLException {
        if (!isConnected()) { // Only if not connected, of course
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?useSSL=false", username, password);
        }
    }

    public void disconnect() {
        if (isConnected())
        {// Only if connected, you can disconnect
           try {
               connection.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
        }
    }

    public Connection getConnection() {
        return connection;
    }

}
