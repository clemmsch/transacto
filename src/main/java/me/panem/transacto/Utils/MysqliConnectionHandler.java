package me.panem.transacto.Utils;

import me.panem.transacto.Transacto;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class MysqliConnectionHandler
{

    private static String host;
    private static String username;
    private static String password;
    // TODO Do we really need a dbname?
    // private static String dbname;
    private static int port;
    private static String socket;

    public boolean TestMysqliConnection() {
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

    public int getMysqliPort() {
        return port;
    }

    public String getMysqliSocket() {
        return socket;
    }

    // The getters have to be lonely, let's give them some setters
    public void setMysqliHost(String newHost) { host = newHost; }

    public void setMysqliUsername(String newUsername) {
        username = newUsername;
    }

    public void setMysqliPassword(String newPassword) {
        password = newPassword;
    }

    public void setMysqliPort(int newPort) {
        port = newPort;
    }

    public void setMysqliSocket(String newSocket) { socket = newSocket; }
}
