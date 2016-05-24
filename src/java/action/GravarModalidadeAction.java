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
import model.Modalidade;
import persistence.ModalidadeDAO;


/**
 *
 * @author Katyelen
 */
public class GravarModalidadeAction implements Action{

    public void execute(HttpServletRequest request, HttpServletResponse response) {
        
        String nome = request.getParameter("txtNome");

        try {
            if ( nome.equals("")) {
                response.sendRedirect("erro.jsp");
            } else {
                Modalidade modalidade =  new Modalidade();
                modalidade.setNome(nome);
                ModalidadeDAO.getInstance().Gravar(modalidade);
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
