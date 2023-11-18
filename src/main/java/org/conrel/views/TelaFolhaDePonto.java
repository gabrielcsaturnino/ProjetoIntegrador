package org.conrel.views;

import org.conrel.controller.FolhaPontoController;
import org.conrel.models.dal.ExceptionCustom;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.conrel.controller.FolhaPontoController.addFolhaPonto;

public class TelaFolhaDePonto extends JFrame {
    private JPanel folhaPontoPanel;
    private JTextField horasTotal;
    private JTextField totalFaltas;
    private JTextField horasExtras;
    private JButton addFolhaPonto;
    private JTextField dataCadastro;


    public TelaFolhaDePonto(int index) {
        setContentPane(folhaPontoPanel);
        setTitle("CONREL");

        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        setVisible(true);

        addFolhaPonto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String horasTotalText = horasTotal.getText();
                String horasExtrasText = horasExtras.getText();
                String totalFaltasText = totalFaltas.getText();
                String dataCadastroText = dataCadastro.getText();


                try {


                    int horasTotal = Integer.parseInt(horasTotalText);
                    int horasExtras = Integer.parseInt(horasExtrasText);
                    int totalFaltas = Integer.parseInt(totalFaltasText);


                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    java.util.Date dataCadastroUtil = null;

                    try {
                        dataCadastroUtil = dateFormat.parse(dataCadastroText);
                    } catch (ParseException ex) {
                        throw new RuntimeException(ex);
                    }

                    java.sql.Date dataCadastroSql = new java.sql.Date(dataCadastroUtil.getTime());


                    try {
                        addFolhaPonto(horasTotal, horasExtras, totalFaltas, dataCadastroSql, index);
                    } catch (ExceptionCustom ex) {
                        JOptionPane.showMessageDialog(TelaFolhaDePonto.this, ex.getMessage());
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(TelaFolhaDePonto.this, "Digite um valor valido");
                }
            }
        });
    }
}
