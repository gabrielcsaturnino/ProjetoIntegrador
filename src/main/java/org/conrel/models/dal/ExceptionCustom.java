package org.conrel.models.dal;

import java.lang.reflect.Executable;
import java.sql.SQLException;

public class ExceptionCustom extends Exception {
    public ExceptionCustom(String msg){
        super(msg);
    }


}
