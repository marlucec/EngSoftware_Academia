/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.AlunoDAO;

/**
 *
 * @author Katyelen
 */
public class ApagarAlunoAction implements Action{

    public void execute(HttpServletRequest request, HttpServletResponse response) {
        
        String codigo = request.getParameter("textCodigo");        

        try {
            if (codigo.equals("")) {
                response.sendRedirect("contato.jsp");
            } else {
                AlunoDAO.getInstance().Apagar(codigo);
                response.sendRedirect("Sucesso.jsp");
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
