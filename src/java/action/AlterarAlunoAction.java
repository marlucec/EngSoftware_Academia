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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import model.Aluno;
import persistence.AlunoDAO;

/**
 *
 * @author Katyelen
 */
public class AlterarAlunoAction implements Action{

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        String codigo = request.getParameter("textCodigo");
        String nome = request.getParameter("textNome");
        String email = request.getParameter("textEmail");
        String empresa = request.getParameter("textEmpresa");

        try {
            if (codigo.equals("") || nome.equals("") || email.equals("")) {
                response.sendRedirect("contato.jsp");
            } else {
                //Alterar
                Aluno contato = new Aluno();
                AlunoDAO.getInstance().Alterar(contato);
                
                //Recuperar, eviar pra tela
                contato = AlunoDAO.getInstance().BuscarCodigo(codigo);
                request.setAttribute("contato", contato);
                RequestDispatcher rd = request.getRequestDispatcher("contato.jsp");
                rd.forward(request, response);
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ServletException ex) {
            ex.printStackTrace();
        }
    }
    
}
