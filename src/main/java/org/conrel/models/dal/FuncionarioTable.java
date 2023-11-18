package org.conrel.models.dal;

import org.conrel.models.Funcionario;
import org.conrel.views.AdicionarFuncionario;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FuncionarioTable extends AbstractTableModel {
    private List<Funcionario> funcionarios;
    String[] colunas = {"Nome", "CPF", "Cargo", "Departamento", "Salário", "Remover", "Beneficio", "Ponto"};


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
            case 5:
                return "Remover";
            case 6:
                return "Beneficio";
            case 7:
                return "Ponto";

            default:
                return null;
        }


    }


    public boolean isCellEditable(int row, int column) {
        return column == 6 || column == 5 || column == 7;

    }


    public String getColumnName(int column) {
        return colunas[column];
    }


    public void deleteRow(int index) {
        funcionarios.remove(index);
        fireTableRowsDeleted(index, index);
    }
}


