package org.conrel.models.dal;

import java.sql.*;

import static org.conrel.models.dal.ConnectDB.con;
import static org.conrel.models.dal.ConnectDB.getConnection;

public class FolhaPontoDAO {
    public static void addPonto(int horasTotal, int horasExtras, int faltas, Date dataCadastro, int index) throws SQLException {
        Connection con = null;
        if (getConnection() == null) {
            new ConnectDB();
        }
        try {
            con = getConnection();
            if (con == null) {
                System.out.println("Erro ao obter a conexão.");
            }

            PreparedStatement pst = con.prepareStatement("SELECT CPF FROM FUNCIONARIO LIMIT 1 OFFSET ?");
            pst.setInt(1, index);
            ResultSet rs = pst.executeQuery();

            String cpf = null;
            if (rs.next()) {
                cpf = rs.getString("CPF");
                System.out.println(cpf);
            } else {
                return;
            }

            PreparedStatement sst = con.prepareStatement("INSERT INTO FOLHA_PONTO (TOTAL_HORAS_TRABALHADAS,HORA_EXTRA,FALTAS,DATA,FK_FUNCIONARIO_CPF) " +
                    "VALUES (?,?,?,?,?)");

            sst.setInt(1, horasTotal);
            sst.setInt(2, horasExtras);
            sst.setInt(3, faltas);

            sst.setDate(4, dataCadastro);
            sst.setString(5, cpf);
            sst.executeUpdate();
            System.out.println("cadastrado com sucesso");

        } catch (SQLException e) {
            throw new SQLException("Erro ao cadastrar!");
        }


    }


    public static boolean checaData(Date dataCadastro, int index) throws SQLException {
        Connection con = getConnection();
        if (con == null) {
            System.out.println("Erro ao obter a conexão.");
            return false;
        }

        PreparedStatement sst = con.prepareStatement("SELECT CPF FROM FUNCIONARIO LIMIT 1 OFFSET ?");
        sst.setInt(1, index);
        ResultSet st = sst.executeQuery();

        String cpf = null;
        if (st.next()) {
            cpf = st.getString("CPF");
        } else {
            return false;
        }

        PreparedStatement pps = con.prepareStatement("SELECT DATA FROM FOLHA_PONTO WHERE FK_FUNCIONARIO_CPF = ?");
        pps.setString(1, cpf);
        ResultSet ss = pps.executeQuery();

        while (ss.next()) {

            Date dataBanco = ss.getDate("DATA");
            long diffInMillis = Math.abs(dataCadastro.getTime() - dataBanco.getTime());
            long diffInDays = diffInMillis / (1000 * 60 * 60 * 24);
            System.out.println(diffInDays);


            if (diffInDays < 30) {

                return false;
            }
        }

        return true;
    }

}
