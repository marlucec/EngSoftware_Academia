/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Katyelen
 */
public class Mensalidade {
    
    private int codigo;
    private double valor, multa;
    private Date vencimento, pagamento;
    private Desconto desconto;

    public Mensalidade() {
    }
    
    /**
     * @return the desconto
     */
    public double getDesconto() {
        return desconto.desconto(this);
    }
    
    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(Desconto desconto) {
        this.desconto = desconto;
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

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the multa
     */
    public double getMulta() {
        return multa;
    }

    /**
     * @param multa the multa to set
     */
    public void setMulta(double multa) {
        this.multa = multa;
    }

    /**
     * @return the vencimento
     */
    public Date getVencimento() {
        return vencimento;
    }

    /**
     * @param vencimento the vencimento to set
     */
    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    /**
     * @return the pagamento
     */
    public Date getPagamento() {
        return pagamento;
    }

    /**
     * @param pagamento the pagamento to set
     */
    public void setPagamento(Date pagamento) {
        this.pagamento = pagamento;
    }
}
