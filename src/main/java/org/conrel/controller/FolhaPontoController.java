package org.conrel.controller;

import org.conrel.models.dal.ExceptionCustom;

import java.sql.Date;
import java.sql.SQLException;

import static org.conrel.models.dal.FolhaPontoDAO.addPonto;

public class FolhaPontoController {
    public static void addFolhaPonto(int horasTotal, int horasExtra, int faltas, Date dataCadastro, int index) throws ExceptionCustom, SQLException {

        addPonto(horasTotal, horasExtra, faltas, dataCadastro, index);

    }
}
