package org.conrel.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FolhaPonto {
    private Date data;
    private Time horaEntrada;
    private Time horaSaida;
    private int totalHorasTrabalhadas;
    private int horaExtra;
    private int faltas;
    private Funcionario funcionario; // Chave estrangeira
}