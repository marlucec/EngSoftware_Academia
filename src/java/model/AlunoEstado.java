/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Katyelen
 * PADRÃO STATE
 */
public interface AlunoEstado {

    public int getEstado();
    public String getNomeEstado();
    public String matricular(Aluno a);
    public String abandonar(Aluno a);
    public String trancar(Aluno a);
}
