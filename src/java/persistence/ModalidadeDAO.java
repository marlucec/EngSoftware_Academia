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
import model.Modalidade;

/**
 * Singleton: Garantir que uma classe tenha somente uma inst�ncia e fornece um
 * ponto global de acesso para a mesma.
 *
 * @author Katyelen
 */
public class ModalidadeDAO {

    //PADRÃO SINGLETON
    private static ModalidadeDAO instance = new ModalidadeDAO();

    private static final String NOME_TABELA = "modalidade";
    private static final String CAMPO_CODIGO = "codigo";
    private static final String CAMPO_NOME = "nome";

    public static ModalidadeDAO getInstance() {
        return instance;
    }

    private ModalidadeDAO() {
    }

    public void Gravar(Modalidade m) throws ClassNotFoundException, SQLException {

        try {

            String sql = "insert into " + NOME_TABELA
                    + " (" + CAMPO_CODIGO + ", " + CAMPO_NOME + ")"
                    + " values ('" + m.getCodigo() + "','" + m.getNome() + "')";

            DatabaseLocator.getInstance().executaSql(sql);

        } catch (SQLException e) {
            throw e;
        }
    }

    public void Alterar(Modalidade m) throws ClassNotFoundException, SQLException {

        try {

            String sql = " update " + NOME_TABELA
                    + " set "
                    + CAMPO_NOME + " = '" + m.getNome()
                    + "' where "
                    + CAMPO_CODIGO + " = '" + m.getCodigo() + "'";

            DatabaseLocator.getInstance().executaSql(sql);

        } catch (SQLException e) {
            throw e;
        }
    }

    public Modalidade BuscarCodigo(String codigo) throws ClassNotFoundException, SQLException {
        return Buscar(CAMPO_CODIGO, codigo);
    }

    public Modalidade BuscarNome(String nome) throws ClassNotFoundException, SQLException {
        return Buscar(CAMPO_NOME, nome);
    }

    public Modalidade Buscar(String campo, String valor) throws ClassNotFoundException, SQLException {

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

    public ArrayList<Modalidade> BuscarTodos() throws ClassNotFoundException, SQLException {

        String sql = "select * from " + NOME_TABELA;
        ResultSet rs = DatabaseLocator.getInstance().getResultado(sql);
        return MontarArrayObjeto(rs);
    }

    public Modalidade MontarObjeto(ResultSet rs) throws SQLException, ClassNotFoundException {

        Modalidade m = null;

        m = new Modalidade();
        m.setCodigo(rs.getInt(CAMPO_CODIGO));
        m.setNome(rs.getString(CAMPO_NOME));
        return m;
    }

    public ArrayList<Modalidade> MontarArrayObjeto(ResultSet rs) throws SQLException, ClassNotFoundException {

        ArrayList<Modalidade> lista = null;
        Modalidade a = null;

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
