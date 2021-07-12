package com.sample.utils;

import com.sample.views.AlertError;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Database{
    private static Database dataSource;
    private static Connection connection;

    public static Connection getConnection() {
        return connection;
    }

    private static final String DRIVER = "org.h2.Driver";
    private static final String DB = "javafx";
    private static final String JDBC_URL = "jdbc:h2:./"+DB+";IFEXISTS=TRUE";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private Database(){

    }

    public static Database getInstance(){
        if(dataSource==null){
            dataSource = new Database();
            try {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
            }catch (Exception e){
                e.printStackTrace();
                AlertError.getInstance().setTitle("Erreur lors de la connexion à la base de données.");
                AlertError.getInstance().setContentText(e.getMessage());
                AlertError.getInstance().showAndWait();
            }
        }
        return dataSource;
    }

    public ResultSet get(String queryStmt) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        try {
            resultSet = connection.createStatement().executeQuery(queryStmt);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);
            throw e;
        }
        return resultSet;
    }

    public void set(String sqlStmt) throws SQLException, ClassNotFoundException {
        try {
            Database.getInstance().connection.createStatement().executeUpdate(sqlStmt);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeUpdate operation : " + e);
            throw e;
        }
    }
}
