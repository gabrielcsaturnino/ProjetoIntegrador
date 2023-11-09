package org.conrel.models.dal;

import org.conrel.models.Funcionario;
import org.conrel.models.dal.ConnectDB;
import org.postgresql.util.PSQLException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.conrel.models.dal.ConnectDB.getConnection;

public class FuncionarioDAO {


    public static boolean ValidarCpf(String cpf) throws PSQLException {

        Connection con = null;
        if (getConnection() == null) {
            new ConnectDB();
        }
        try {
            con = getConnection();

            if (con == null) {
                throw new SQLException("Erro ao obter a conexão.");
            }

            PreparedStatement pps = con.prepareStatement("SELECT COUNT(*) FROM FUNCIONARIO WHERE CPF = ?");
            pps.setString(1, cpf);
            ResultSet st = pps.executeQuery();
            st.next();
            int count = st.getInt(1);
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static void insert(Funcionario funcionario) {

        Connection con = null;
        if (getConnection() == null) {
            new ConnectDB();
        }
        try {
            con = getConnection();

            if (con == null) {
                throw new SQLException("Erro ao obter a conexão.");
            }

            PreparedStatement pps = con.prepareStatement("INSERT INTO FUNCIONARIO (cargo, cpf, nome, contrato, data_admissao, rg, departamento, salario_hora) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            pps.setString(1, funcionario.getCargo());
            pps.setString(2, funcionario.getCpf());
            pps.setString(3, funcionario.getNome());
            pps.setString(4, funcionario.getContrato());
            pps.setDate(5, (Date) funcionario.getData_admissao());
            pps.setString(6, funcionario.getRg());
            pps.setString(7, funcionario.getDepartamento());
            pps.setInt(8, funcionario.getSalario_hora());
            pps.executeUpdate();
            System.out.println("Adicionado com sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }


    public static List<Funcionario> consulta() throws SQLException {
        List<Funcionario> funcionarios = new ArrayList<>();
        Connection con = null;
        if (getConnection() == null) {
            new ConnectDB();
        }

        try {
            con = getConnection();

            if (con == null) {
                throw new SQLException("Erro ao obter a conexão.");
            }


            PreparedStatement pps = con.prepareStatement("SELECT * FROM FUNCIONARIO");
            ResultSet st = pps.executeQuery();
            while (st.next()) {
                Funcionario funcionario = new Funcionario(
                        st.getString("nome"),
                        st.getString("cpf"),
                        st.getString("cargo"),
                        st.getString("rg"),
                        st.getString("departamento"),
                        st.getDate("data_admissao"),
                        st.getString("contrato"),
                        st.getInt("salario_hora")
                );
              funcionarios.add(funcionario);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

       return funcionarios;
    }


}







