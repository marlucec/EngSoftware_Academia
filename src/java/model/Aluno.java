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
public class Aluno extends Observer {

    private int codigo;
    private String matricula, nome, cpf, email, sexo, telefone;
    private Date dataNascimento,dataCadastro;
    private AlunoEstado estadoAluno;

    public Aluno() {
    } 

    public Aluno(int codigo, String matricula, String nome, String cpf, String email, String sexo, String telefone, Date dataNascimento, Date dataCadastro) {
        this.codigo = codigo;
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.sexo = sexo;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = dataCadastro;
    }
    
    public int getEstadoAluno() {
        return estadoAluno.getEstado();
    }
    
    public String getNomeEstadoAluno() {
        return estadoAluno.getNomeEstado();
    }
    
    public String matricular()
    {
        return this.estadoAluno.matricular(this);
    }
    
    public String trancar()
    {
        return this.estadoAluno.trancar(this);
    }
    
    public String abandonar()
    {
        return this.estadoAluno.abandonar(this);
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
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the dataNascimento
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the dataCadastro
     */
    public Date getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param dataCadastro the dataCadastro to set
     */
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }   

    /**
     * @param estadoAluno the estadoAluno to set
     */
    public void setEstadoAluno(AlunoEstado estadoAluno) {
        this.estadoAluno = estadoAluno;
    }

    @Override
    public void update() {
        System.out.println( "Mensalidade atrasada"); 
    }
    
    
}
