/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Katyelen
 */
public class AlunoEstadoAbandonado implements AlunoEstado{

    @Override
    public int getEstado() {
        return 3;
    }
    
    @Override
    public String getNomeEstado() {
        return "Abandonado";
    }

    @Override
    public String matricular(Aluno a) {
        return "Aluno já esta matriculado.";
    }

    @Override
    public String abandonar(Aluno a) { 
        a.setEstadoAluno(new AlunoEstadoAbandonado());
        return "Aluno abandonou a academia.";
    }

    @Override
    public String trancar(Aluno a) {
        return "Aluno abandonou a academia.";
    }  

    
}
