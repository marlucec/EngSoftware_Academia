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
import model.Turma;

/**
 * Singleton: Garantir que uma classe tenha somente uma inst�ncia e fornece um
 * ponto global de acesso para a mesma.
 *
 * @author Katyelen
 */
public class TurmaDAO {

    //PADRÃO SINGLETON
    private static TurmaDAO instance = new TurmaDAO();

    private static final String NOME_TABELA = "turma";
    private static final String CAMPO_CODIGO = "codigo";
    private static final String CAMPO_HOR_INI = "horarioInicio";
    private static final String CAMPO_HOR_FIM = "horariofim";
    private static final String CAMPO_MODALIDADE_FK = "modalidade_fk";

    public static TurmaDAO getInstance() {
        return instance;
    }

    private TurmaDAO() {
    }

    public void Gravar(Turma t) throws ClassNotFoundException, SQLException {

        try {

            String sql = "insert into " + NOME_TABELA
                    + " (" + CAMPO_CODIGO + ", " + CAMPO_HOR_INI + ")"
                    + " values ('" + t.getCodigo() + "','" + t.getHorarioInicio() + "','" + t.getHorarioFim() + "')";

            DatabaseLocator.getInstance().executaSql(sql);

        } catch (SQLException e) {
            throw e;
        }
    }

    public void Alterar(Turma t) throws ClassNotFoundException, SQLException {

        try {

            String sql = " update " + NOME_TABELA
                    + " set "
                    + CAMPO_HOR_INI + " = '" + t.getHorarioInicio() + "', "
                    + CAMPO_HOR_FIM + "= '" + t.getHorarioFim()
                    + "' where "
                    + CAMPO_CODIGO + " = '" + t.getCodigo() + "'";

            DatabaseLocator.getInstance().executaSql(sql);

        } catch (SQLException e) {
            throw e;
        }
    }

    public Turma BuscarCodigo(String codigo) throws ClassNotFoundException, SQLException {
        return Buscar(CAMPO_CODIGO, codigo);
    }

    public Turma Buscar(String campo, String valor) throws ClassNotFoundException, SQLException {

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

    public ArrayList<Turma> BuscarTodos() throws ClassNotFoundException, SQLException {

        String sql = "select * from " + NOME_TABELA;
        ResultSet rs = DatabaseLocator.getInstance().getResultado(sql);
        return MontarArrayObjeto(rs);
    }

    public Turma MontarObjeto(ResultSet rs) throws SQLException, ClassNotFoundException {

        Turma c = null;

        c = new Turma();
        c.setCodigo(rs.getInt(CAMPO_CODIGO));
        c.setHorarioInicio(rs.getTime(CAMPO_HOR_INI));
        c.setHorarioFim(rs.getTime(CAMPO_HOR_FIM));
        c.setModalidade(ModalidadeDAO.getInstance().BuscarCodigo(rs.getString(CAMPO_MODALIDADE_FK)));
        return c;
    }

    public ArrayList<Turma> MontarArrayObjeto(ResultSet rs) throws SQLException, ClassNotFoundException {

        ArrayList<Turma> lista = null;
        Turma a = null;

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
