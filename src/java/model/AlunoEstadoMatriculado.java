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
public class AlunoEstadoMatriculado implements AlunoEstado{

    @Override
    public int getEstado() {
        return 1;
    }
    
    @Override
    public String getNomeEstado() {
        return "Matriculado";
    }

    @Override
    public String matricular(Aluno a) {
        return "Aluno já esta matriculado.";
    }

    @Override
    public String abandonar(Aluno a) { 
        a.setEstadoAluno(new AlunoEstadoAbandonado());
        return "ok";
    }

    @Override
    public String trancar(Aluno a) {
        a.setEstadoAluno(new AlunoEstadoTrancado());
        return "ok";
    }

    
}
