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
import model.Estado;

/**
 * Singleton: Garantir que uma classe tenha somente uma inst�ncia e fornece um
 * ponto global de acesso para a mesma.
 *
 * @author Katyelen
 */
public class EstadoDAO {

    //PADRÃO SINGLETON
    private static EstadoDAO instance = new EstadoDAO();

    private static final String NOME_TABELA = "Estado";
    private static final String CAMPO_CODIGO = "codigo";
    private static final String CAMPO_DESCRICAO = "descricao";

    public static EstadoDAO getInstance() {
        return instance;
    }

    private EstadoDAO() {
    }

    public Estado BuscarCodigo(String codigo) throws ClassNotFoundException, SQLException {
        return Buscar(CAMPO_DESCRICAO, codigo);
    }

    public Estado Buscar(String campo, String valor) throws ClassNotFoundException, SQLException {

        try {

            String sql = "select * from " + NOME_TABELA + " where " + campo + " = '" + valor + "' ";
            ResultSet rs = DatabaseLocator.getInstance().getResultado(sql);

            return MontarObjeto(rs);

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Estado> BuscarTodos() throws ClassNotFoundException, SQLException {

        String sql = "select * from " + NOME_TABELA;
        ResultSet rs = DatabaseLocator.getInstance().getResultado(sql);
        return MontarArrayObjeto(rs);
    }

    public Estado MontarObjeto(ResultSet rs) throws SQLException, ClassNotFoundException {

        Estado e = null;

        e = new Estado();
        e.setCodigo(rs.getInt(CAMPO_CODIGO));
        e.setDescricao(rs.getString(CAMPO_DESCRICAO));

        return e;
    }

    public ArrayList<Estado> MontarArrayObjeto(ResultSet rs) throws SQLException, ClassNotFoundException {

        ArrayList<Estado> lista = null;
        Estado e = null;

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
