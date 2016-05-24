/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author NeoRadcliffe
 */
public class Observable {

    private ArrayList<Aluno> allObservers = new ArrayList<Aluno>();

    public void notifyObservers() {
        
        for (Aluno a : this.allObservers) {
            a.update();
        }
    }

    public void addObserver(Aluno o) {
        allObservers.add(o);
    }

    public void removeObserver(Aluno o) {
        allObservers.remove(o);
    }

}
