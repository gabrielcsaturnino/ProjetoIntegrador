package org.conrel.controller;

import static org.conrel.models.dal.FuncionarioDAO.Deletar;

public class DeletarFuncionarioController {
     public static void DelFuncionario(int index){
         Deletar(index);

     }
}
