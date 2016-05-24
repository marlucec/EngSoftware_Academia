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
import java.util.List;
import model.Mensalidade;
import model.Mensalidade;
import model.Mensalidade;

/**
 * Singleton: Garantir que uma classe tenha somente uma inst�ncia e fornece um
 * ponto global de acesso para a mesma.
 *
 * @author Katyelen
 */
public class MensalidadeDAO {

    //PADRÃO SINGLETON
    private static MensalidadeDAO instance = new MensalidadeDAO();

    private static final String NOME_TABELA = "mensalidade";
    private static final String CAMPO_CODIGO = "codigo";
    private static final String CAMPO_VALOR = "valor";
    private static final String CAMPO_MULTA = "multa";
    private static final String CAMPO_VENCIMENTO = "vencimento";
    private static final String CAMPO_PAGAMENTO = "pagamento";

    public static MensalidadeDAO getInstance() {
        return instance;
    }

    private MensalidadeDAO() {
    }

    public void Gravar(Mensalidade a) throws ClassNotFoundException, SQLException {

        try {

            String sql = "insert into " + NOME_TABELA
                    + " (" + CAMPO_CODIGO + ", " + CAMPO_VALOR
                    + ", " + CAMPO_MULTA + ", " + CAMPO_VENCIMENTO
                    + ", " + CAMPO_PAGAMENTO + ")"
                    + " values ('"
                    + a.getCodigo() + "','"
                    + a.getValor() + "','"
                    + a.getMulta() + "','"
                    + a.getVencimento() + "','"
                    + a.getPagamento() + "')";

            DatabaseLocator.getInstance().executaSql(sql);

        } catch (SQLException e) {
            throw e;
        }
    }

    public void Alterar(Mensalidade a) throws ClassNotFoundException, SQLException {

        try {

            String sql = " update " + NOME_TABELA
                    + " set "
                    + CAMPO_VALOR + " = '" + a.getValor() + "', "
                    + CAMPO_MULTA + " = '" + a.getMulta() + "', "
                    + CAMPO_VENCIMENTO + " = '" + a.getVencimento() + "', "
                    + CAMPO_PAGAMENTO + "= '" + a.getPagamento()
                    + "' where "
                    + CAMPO_CODIGO + " = '" + a.getCodigo() + "'";

            DatabaseLocator.getInstance().executaSql(sql);

        } catch (SQLException e) {
            throw e;
        }

    }

    public Mensalidade BuscarCodigo(String codigo) throws ClassNotFoundException, SQLException {
        return Buscar(CAMPO_CODIGO, codigo);
    }

    public Mensalidade Buscar(String campo, String valor) throws ClassNotFoundException, SQLException {

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

    public ArrayList<Mensalidade> BuscarTodos() throws ClassNotFoundException, SQLException {

        String sql = "select * from " + NOME_TABELA;
        ResultSet rs = DatabaseLocator.getInstance().getResultado(sql);
        return MontarArrayObjeto(rs);
    }

    public Mensalidade MontarObjeto(ResultSet rs) throws SQLException, ClassNotFoundException {

        Mensalidade c = null;

        c = new Mensalidade();
        c.setCodigo(rs.getInt(CAMPO_CODIGO));
        c.setValor(rs.getDouble(CAMPO_VALOR));
        c.setMulta(rs.getDouble(CAMPO_MULTA));
        c.setVencimento(rs.getDate(CAMPO_VENCIMENTO));
        c.setPagamento(rs.getDate(CAMPO_PAGAMENTO));
        return c;
    }

    public ArrayList<Mensalidade> MontarArrayObjeto(ResultSet rs) throws SQLException, ClassNotFoundException {

        ArrayList<Mensalidade> lista = new ArrayList<Mensalidade>();
        Mensalidade a = null;

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
