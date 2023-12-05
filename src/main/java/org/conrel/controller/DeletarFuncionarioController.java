package org.conrel.controller;

import org.conrel.views.TelaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.conrel.models.dal.FuncionarioDAO.Deletar;

public class DeletarFuncionarioController implements ActionListener {

    TelaPrincipal mv;

    public DeletarFuncionarioController(){

    }
    public DeletarFuncionarioController(TelaPrincipal mv){
        this.mv = mv;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        System.out.println(command);
        if(command.equals("Remover")){
            Deletar(mv.getIndex());
        }
    }
}
