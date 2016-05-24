/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

/**
 *
 * @author Katyelen
 */
public class Turma{
    
    private int codigo;
    private Modalidade modalidade;
    private Time horarioInicio;
    private Time horarioFim;
    
    public Turma() {
    }  

    public Turma(Modalidade modalidade, Time horarioInicio, Time horarioFim) {
        this.modalidade = modalidade;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
    }   
    
    /**
     * @return the modalidade
     */
    public Modalidade getModalidade() {
        return modalidade;
    }

    /**
     * @param modalidade the modalidade to set
     */
    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    /**
     * @return the horarioInicio
     */
    public Time getHorarioInicio() {
        return horarioInicio;
    }

    /**
     * @param horarioInicio the horarioInicio to set
     */
    public void setHorarioInicio(Time horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    /**
     * @return the horarioFim
     */
    public Time getHorarioFim() {
        return horarioFim;
    }

    /**
     * @param horarioFim the horarioFim to set
     */
    public void setHorarioFim(Time horarioFim) {
        this.horarioFim = horarioFim;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
}
