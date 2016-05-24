/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Katyelen
 * PADRÃO TEMPLATE METHOD
 */
public abstract class OrdenadorTemplate {
    
    public abstract boolean isPrimeiro(Aluno aluno1, Aluno aluno2);
 
    public ArrayList<Aluno> ordenarAlunos(ArrayList<Aluno> lista) {
        ArrayList<Aluno> novaLista = new ArrayList<Aluno>();
        for (Aluno aluno : lista) {
            novaLista.add(aluno);
        }
 
        for (int i = 0; i < novaLista.size(); i++) {
            for (int j = i; j < novaLista.size(); j++) {
                if (!isPrimeiro(novaLista.get(i), novaLista.get(j))) {
                    Aluno temp = novaLista.get(j);
                    novaLista.set(j, novaLista.get(i));
                    novaLista.set(i, temp);
                }
            }
        }
 
        return novaLista;
    }
}
