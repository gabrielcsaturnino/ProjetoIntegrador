package org.conrel.controller;

import org.conrel.models.dal.ExceptionCustom;

import java.sql.Date;
import java.sql.SQLException;

import static org.conrel.models.dal.FolhaPontoDAO.addPonto;
import static org.conrel.models.dal.FolhaPontoDAO.checaData;

public class FolhaPontoController {
    public static void addFolhaPonto(int horasTotal, int horasExtra, int faltas, Date dataCadastro, int index) throws ExceptionCustom, SQLException {


           if(checaData(dataCadastro, index)){
               addPonto(horasTotal, horasExtra, faltas, dataCadastro, index);
           }else {
               throw new ExceptionCustom("Ponto ja cadastrado para data solicitada.");
           }




    }
}
