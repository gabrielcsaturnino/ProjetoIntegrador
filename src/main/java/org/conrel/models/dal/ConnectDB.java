package org.conrel.models.dal;

import org.conrel.models.Funcionario;

import java.sql.*;

public class ConnectDB {
    static Connection con;

    public ConnectDB() {

        try {
            if (con == null) {
                con = DriverManager.getConnection("jdbc:postgresql://projeto-integrador.cplzuphuait3.us-east-2.rds.amazonaws.com:5432/PJ-INTEGRADOR",
                        "postgres", "Kjumhlozfv23");
            }
            System.out.println("Conectado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }


    public static Connection getConnection() {
        return con;
    }

    public static void closeConnection() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
