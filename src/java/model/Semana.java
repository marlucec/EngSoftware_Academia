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
public abstract class Semana {
    protected String nome;

    public Semana(String nome) {
        this.nome = nome;
    }

    public abstract String getNome();

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
