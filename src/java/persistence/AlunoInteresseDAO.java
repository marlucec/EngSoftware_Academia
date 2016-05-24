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
import model.Aluno;

/**
 * Singleton: Garantir que uma classe tenha somente uma inst�ncia e fornece um
 * ponto global de acesso para a mesma.
 *
 * @author Katyelen
 */
public class AlunoInteresseDAO {

    //PADRÃO SINGLETON
    private static AlunoInteresseDAO instance = new AlunoInteresseDAO();

    private static final String NOME_TABELA = "interesse";
    private static final String CAMPO_CODIGO = "codigo";
    private static final String CAMPO_NOME = "nome";
    private static final String CAMPO_ALUNO_FK = "aluno_fk";
    private static final String CAMPO_MODAL_FK = "modalidade_fk";

    public static AlunoInteresseDAO getInstance() {
        return instance;
    }

    private AlunoInteresseDAO() {
    }

    public void Gravar(Aluno a) throws ClassNotFoundException, SQLException {

        try {

            String sql = "insert into " + NOME_TABELA
                    + " (" + CAMPO_CODIGO + ", " + CAMPO_NOME + ")"
                    + " values ('" + a.getCodigo() + "','" + a.getNome() + "')";

            DatabaseLocator.getInstance().executaSql(sql);

        } catch (SQLException e) {
            throw e;
        }
    }

    public void Alterar(Aluno a) throws ClassNotFoundException, SQLException {

        try {

            String sql = " update " + NOME_TABELA
                    + " set "
                    + CAMPO_NOME + " = '" + a.getNome()
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

    public Aluno Buscar(String campo, String valor) throws ClassNotFoundException, SQLException {

        try {

            String sql = "select * from " + NOME_TABELA + " where " + campo + " = '" + valor + "' ";
            ResultSet rs = DatabaseLocator.getInstance().getResultado(sql);

            return MontarObjeto(rs);

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

    public ArrayList<Aluno> BuscarPorDanca() throws ClassNotFoundException, SQLException {

        String sql = "select * from " + NOME_TABELA + " where " + CAMPO_MODAL_FK + " = 1";
        ResultSet rs = DatabaseLocator.getInstance().getResultado(sql);

        ArrayList<Aluno> lista = new ArrayList<Aluno>();
        Aluno a = null;

        while (rs.next()) {
            a = AlunoDAO.getInstance().BuscarCodigo(rs.getString(CAMPO_ALUNO_FK));
            lista.add(a);
        }

        return lista;
    }

    public Aluno MontarObjeto(ResultSet rs) throws SQLException, ClassNotFoundException {

        Aluno c = null;

        c = new Aluno();
        c.setCodigo(rs.getInt(CAMPO_CODIGO));
        c.setNome(rs.getString(CAMPO_NOME));

        return c;
    }

    public ArrayList<Aluno> MontarArrayObjeto(ResultSet rs) throws SQLException, ClassNotFoundException {

        ArrayList<Aluno> lista = null;
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
