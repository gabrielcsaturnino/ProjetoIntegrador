package org.conrel.models;

import org.conrel.models.Funcionario;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class FuncionarioTable  extends AbstractTableModel {
    private List<Funcionario> funcionarios;
    String[] colunas = {"Nome", "CPF", "Cargo", "Departamento", "Salário"};


    public FuncionarioTable(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public int getRowCount() {
        return funcionarios.size();
    }


    public int getColumnCount() {
        return colunas.length;
    }


    public Object getValueAt(int rowIndex, int columnIndex) {
        Funcionario funcionario = funcionarios.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return funcionario.getNome();
            case 1:
                return funcionario.getCpf();
            case 2:
                return funcionario.getCargo();
            case 3:
                return funcionario.getDepartamento();
            case 4:
                return funcionario.getSalario_hora();
            default:
                return null;
        }
    }

    public String getColumnName(int column) {
        return colunas[column];
    }
}


