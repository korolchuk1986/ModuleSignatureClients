package fr.fiducial.signature.feature.clients.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnect {
    private static final String URL = "jdbc:mysql://localhost:3306/signature_clients?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    /**
     * MÃ©thode permettant de rÃ©cupÃ©rer la connexion Ã  la BDD
     * @return la connection
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }

    /**
     * Méthode permettant de fermer la connexion
     * @param connection à fermer
     * @throws SQLException
     */
    public static void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public static void main(String[] args) {
        try {
            Connection connection = DataConnect.getConnection();
            connection.close();
            System.out.println("ok connection database");
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

