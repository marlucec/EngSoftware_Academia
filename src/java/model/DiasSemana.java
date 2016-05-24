/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Katyelen
 */
public class DiasSemana extends Semana{
    
    private ArrayList semanas = new ArrayList();

    public DiasSemana(String nome) {
        super(nome);
    }
    
    public void addSemana(Semana semana)
    {
        semanas.add(semana);
    }

    @Override
    public String getNome() {
        
        String textoSaida = this.nome + "\n";
        for (Iterator iterator = semanas.iterator(); iterator.hasNext();) {
            Semana semana = (Semana) iterator.next();
            textoSaida = textoSaida + semana.getNome();
        }
        return textoSaida;
    }
}
