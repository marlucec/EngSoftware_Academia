/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Aluno;
import model.AlunoEstadoAbandonado;
import model.AlunoEstadoMatriculado;
import model.AlunoEstadoTrancado;

/**
 * Singleton: Garantir que uma classe tenha somente uma inst�ncia e fornece um
 * ponto global de acesso para a mesma.
 *
 * @author Katyelen
 */
public class AlunoDAO {

    //PADRÃO SINGLETON
    private static AlunoDAO instance = new AlunoDAO();

    private static final String NOME_TABELA = "aluno";
    private static final String CAMPO_CODIGO = "codigo";
    private static final String CAMPO_NOME = "nome";
    private static final String CAMPO_EMAIL = "email";
    private static final String CAMPO_MATRICULA = "matricula";
    private static final String CAMPO_TELEFONE = "telefone";
    private static final String CAMPO_ESTADO_FK = "estadoAluno_fk";

    public static AlunoDAO getInstance() {
        return instance;
    }

    private AlunoDAO() {
    }

    public void Gravar(Aluno a) throws ClassNotFoundException, SQLException {

        try {

            String sql = "insert into " + NOME_TABELA
                    + " ("
                    + CAMPO_MATRICULA + ", "
                    + CAMPO_NOME + ", "
                    + CAMPO_EMAIL + ", "
                    + CAMPO_TELEFONE + ", "
                    + CAMPO_ESTADO_FK + ")"
                    + " values ('"
                    + a.getMatricula() + "','"
                    + a.getNome() + "','"
                    + a.getEmail() + "','"
                    + a.getTelefone() + "','"
                    + a.getEstadoAluno() + "')";

            DatabaseLocator.getInstance().executaSql(sql);

        } catch (SQLException e) {
            throw e;
        }
    }

    public void Alterar(Aluno a) throws ClassNotFoundException, SQLException {

        try {

            String sql = " update " + NOME_TABELA
                    + " set "
                    + CAMPO_NOME + " = '" + a.getNome() + "', "
                    + CAMPO_EMAIL + "= '" + a.getEmail()
                    + "' where "
                    + CAMPO_CODIGO + " = '" + a.getCodigo() + "'";

            DatabaseLocator.getInstance().executaSql(sql);

        } catch (SQLException e) {
            throw e;
        }
    }
    
    public void AlterarEstado(Aluno a) throws ClassNotFoundException, SQLException {

        try {

            String sql = " update " + NOME_TABELA
                    + " set "
                    + CAMPO_ESTADO_FK + " = '" + a.getEstadoAluno() 
                    + "' where "
                    + CAMPO_CODIGO + " = '" + a.getCodigo() + "'";

            DatabaseLocator.getInstance().executaSql(sql);

        } catch (SQLException e) {
            throw e;
        }
    }

    public Aluno BuscarCodigo(String codigo) throws ClassNotFoundException, SQLException {
        return Buscar(CAMPO_CODIGO, codigo);
    }

    public Aluno BuscarNome(String nome) throws ClassNotFoundException, SQLException {
        return Buscar(CAMPO_NOME, nome);
    }

    public Aluno BuscarEmail(String email) throws ClassNotFoundException, SQLException {
        return Buscar(CAMPO_EMAIL, email);
    }

    public Aluno Buscar(String campo, String valor) throws ClassNotFoundException, SQLException {

        try {

            String sql = "select * from " + NOME_TABELA + " where " + campo + " = '" + valor + "' ";
            ResultSet rs = DatabaseLocator.getInstance().getResultado(sql);
            Aluno c = null;

            if (rs.next()) {
                c = new Aluno();
                c.setCodigo(rs.getInt(CAMPO_CODIGO));
                c.setNome(rs.getString(CAMPO_NOME));
                c.setMatricula(rs.getString(CAMPO_MATRICULA));
                c.setEmail(rs.getString(CAMPO_EMAIL));
                c.setTelefone(rs.getString(CAMPO_TELEFONE));

                switch (rs.getString(CAMPO_ESTADO_FK)) {
                    case "1":
                        c.setEstadoAluno(new AlunoEstadoMatriculado());
                        break;
                    case "2":
                        c.setEstadoAluno(new AlunoEstadoTrancado());
                        break;
                    case "3":
                        c.setEstadoAluno(new AlunoEstadoAbandonado());
                        break;
                }
            }
            
            return c;
        

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        
    }

    public void Apagar(String codigo) throws ClassNotFoundException, SQLException {

        Connection con = DatabaseLocator.getInstance().getConnection();
        Statement st = con.createStatement();

        try {

            String sql = "delete from " + NOME_TABELA + " where " + CAMPO_CODIGO + " = '" + codigo + "'";
            DatabaseLocator.getInstance().executaSql(sql);

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(con, st);
        }
    }

    public ArrayList<Aluno> BuscarTodos() throws ClassNotFoundException, SQLException {

        String sql = "select * from " + NOME_TABELA;
        ResultSet rs = DatabaseLocator.getInstance().getResultado(sql);
        return MontarArrayObjeto(rs);
    }

    public Aluno MontarObjeto(ResultSet rs) throws SQLException, ClassNotFoundException {

        Aluno c = null;

        c = new Aluno();
        c.setCodigo(rs.getInt(CAMPO_CODIGO));
        c.setNome(rs.getString(CAMPO_NOME));
        c.setMatricula(rs.getString(CAMPO_MATRICULA));
        c.setEmail(rs.getString(CAMPO_EMAIL));
        c.setTelefone(rs.getString(CAMPO_TELEFONE));

        switch (rs.getString(CAMPO_ESTADO_FK)) {
            case "1":
                c.setEstadoAluno(new AlunoEstadoMatriculado());
                break;
            case "2":
                c.setEstadoAluno(new AlunoEstadoTrancado());
                break;
            case "3":
                c.setEstadoAluno(new AlunoEstadoAbandonado());
                break;
        }

        return c;
    }

    public ArrayList<Aluno> MontarArrayObjeto(ResultSet rs) throws SQLException, ClassNotFoundException {

        ArrayList<Aluno> lista = new ArrayList<Aluno>();
        Aluno a = null;

        while (rs.next()) {
            lista.add(MontarObjeto(rs));
        }
        return lista;
    }

    public void closeResources(Connection con, Statement st) throws SQLException {
        if (st != null) {
            st.close();
        }
        if (con != null) {
            con.close();
        }
    }
}
