package org.conrel.dal;

import java.sql.*;

import static javax.swing.DropMode.INSERT;
import static org.postgresql.jdbc.SslMode.VALUES;

public class ConnectDB {
    static Connection con;
   public ConnectDB(){

       try {
            con = DriverManager.getConnection("jdbc:postgresql://projeto-integrador.cplzuphuait3.us-east-2.rds.amazonaws.com:5432/PJ-INTEGRADOR",
                   "postgres", "Kjumhlozfv23");
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
           if(con!=null){
               con.close();}
       }




   }


public static void insert(String name) throws SQLException{
       new ConnectDB();
       try {

           PreparedStatement pps = con.prepareStatement("INSERT INTO FUNCIONARIO (cargo, cpf, nome, contrato, data_admissao, rg, departamento, salario_hora) " +
                   "VALUES ('Programador', '4444-5555', ?, '4512', TO_DATE('17/02/2022', 'DD/MM/YYYY'), '444', '123', 12)");
           pps.setString(1, name);
           pps.executeUpdate();
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
       finally {
           if(con!=null){
               con.close();}
       }



}






}
