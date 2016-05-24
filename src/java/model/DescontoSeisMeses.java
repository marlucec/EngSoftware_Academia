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
public class DescontoSeisMeses implements Desconto{

    @Override
    public double desconto(Mensalidade mensalidade) {
        return mensalidade.getValor() * 0.18;
    }
    
    
}
