package org.conrel.dal;

import java.sql.*;

import static javax.swing.DropMode.INSERT;
import static org.postgresql.jdbc.SslMode.VALUES;

public class ConnectDB {
    static Connection con;
   public ConnectDB(){

       try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBPROJETO",
                   "postgres", "1234");
           if (con != null){
               System.out.println("Banco conectado");

           }else {
               System.out.println("Conexão falhou!");
           }
       }catch (Exception e){
           System.out.println(e.getMessage());
       }


   }

   public static void consulta() throws SQLException {
       try {
           new ConnectDB();
           PreparedStatement pps = con.prepareStatement("SELECT nome, cargo, salario_hora FROM FUNCIONARIO");
           ResultSet st = pps.executeQuery();
           while (st.next()){
           System.out.println("nome: " + st.getString("nome") + "\ncargo: " + st.getString("cargo") + "\nsalario:" + st.getInt("salario_hora")) ;}

       }catch (Exception e){
           System.out.println(e.getMessage());
       }
       finally {
           con.close();
       }




   }


public static void insert(String name) throws SQLException{
       new ConnectDB();
       try {

           PreparedStatement pps = con.prepareStatement("INSERT INTO FUNCIONARIO (cargo, cpf, nome, contrato, data_admissao, rg, departamento, salario_hora) " +
                   "VALUES ('Programador', '5555-5555', ?, '4512', '17-02-22', '444', '123', 15)");
           pps.setString(1, name);
           pps.executeUpdate();
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
       finally {
           con.close();
       }



}






}
