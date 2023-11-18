package org.conrel.models.dal;

import java.sql.*;

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
            } else {
                return;
            }

            PreparedStatement sst = con.prepareStatement("INSERT INTO FOLHA_PONTO (TOTAL_HORAS_TRABALHADAS, DATA,HORA_EXTRA,FALTAS,FK_FUNCIONARIO_CPF) " +
                    "VALUES (?,?,?,?,?)");

            sst.setInt(1, horasTotal);
            sst.setInt(2, horasExtras);
            sst.setInt(3, faltas);
            sst.setDate(4, dataCadastro);
            sst.setString(5, cpf);
            System.out.println("cadastrado com sucesso");

        } catch (SQLException e) {
            throw new SQLException("Erro ao cadastrar!");
        }


    }


}
