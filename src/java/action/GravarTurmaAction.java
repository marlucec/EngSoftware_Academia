/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Modalidade;
import model.Turma;
import persistence.ModalidadeDAO;
import persistence.TurmaDAO;

/**
 *
 * @author Katyelen
 */
public class GravarTurmaAction implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String codModalidade = request.getParameter("txtModalidade");
        String horarioInicio = request.getParameter("txtHorarioInicio");
        String horarioFim = request.getParameter("txtHorarioFim");

        String mensagem = "";
        String destino = "turma.jsp";

        try {
            /*Recupera modalidade*/
            Modalidade modalidade = ModalidadeDAO.getInstance().BuscarCodigo(codModalidade);

            if (modalidade == null) {
                mensagem = "Modalidade inválida";
                destino = "erro.jsp";
            }            
            
            Turma turma = new Turma();
            TurmaDAO.getInstance().Gravar(turma);

            request.setAttribute("mensagem", mensagem);

            RequestDispatcher rd = request.getRequestDispatcher(destino);
            rd.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(GravarTurmaAction.class.getName()).log(Level.SEVERE, null, ex);           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GravarTurmaAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(GravarTurmaAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
