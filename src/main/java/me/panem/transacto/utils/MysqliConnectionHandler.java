package me.panem.transacto.utils;

public class MysqliConnectionHandler
{

    private static String host;
    private static String username;
    private static String password;
    private static String dbname;
    private static String port;
    private static String socket;

    public boolean testMysqliConnection() {
        // TODO Implement

        return true;
    }



    // A few getters for the variables
    public String getMysqliHost() {
        return host;
    }

    public String getMysqliUsername() {
        return username;
    }

    public String getMysqliPassword() {
        return password;
    }

    public String getMysqliPort() {
        return port;
    }

    public String getMysqliSocket() {
        return socket;
    }
    public String getMysqliDbname() {
        return dbname;
    }

    // The getters have to be lonely, let's give them some setters
    public void setMysqliHost(String newHost) { host = newHost; }

    public void setMysqliUsername(String newUsername) {
        username = newUsername;
    }

    public void setMysqliPassword(String newPassword) {
        password = newPassword;
    }

    public void setMysqliPort(String newPort) {
        port = newPort;
    }

    public void setMysqliSocket(String newSocket) { socket = newSocket; }
    public void setMysqliDbname(String newDb) { dbname = newDb; }
}
