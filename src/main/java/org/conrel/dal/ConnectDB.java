package org.conrel.dal;

import java.sql.*;

public class ConnectDB {
    Connection con;
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

   public void consulta() throws SQLException {
       try {

           Statement result = con.createStatement();


           ResultSet st = result.executeQuery("SELECT nome, cargo, salario_hora FROM FUNCIONARIO");
           while (st.next()){
           System.out.println("nome: " + st.getString("nome") + "\ncargo: " + st.getString("cargo") + "\nsalario:" + st.getInt("salario_hora")) ;}

       }catch (Exception e){
           System.out.println(e.getMessage());
       }
       con.close();
   }






}
