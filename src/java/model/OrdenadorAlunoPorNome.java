/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Katyelen
 * PADRÃO TEMPLATE METHOD
 */
public class OrdenadorAlunoPorNome extends OrdenadorTemplate{

    @Override
    public boolean isPrimeiro(Aluno aluno1, Aluno aluno2) {
        if (aluno1.getNome().compareToIgnoreCase(aluno2.getNome()) <= 0) {
            return true;
        }
        return false;
    }
    
}
