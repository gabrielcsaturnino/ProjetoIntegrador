package org.conrel.controller;

import org.conrel.models.Funcionario;

import org.conrel.views.AdicionarFuncionario;
import org.conrel.views.TelaPrincipal;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainViewController implements ActionListener {

    TelaPrincipal mv;

    public MainViewController(TelaPrincipal mv){
        this.mv = mv;
    }
    Funcionario funcionario = new Funcionario();


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if(command.equals("Cadastro")){
            AdicionarFuncionario adicionarFuncionario = new AdicionarFuncionario();
            AdicionarFuncionarioController adicionarFuncionarioController = new AdicionarFuncionarioController(adicionarFuncionario, funcionario, mv);
            adicionarFuncionario.setListeners(adicionarFuncionarioController);
            mv.setVisibleFalse();


        }
    }
}

