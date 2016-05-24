/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import model.Aluno;
import model.AlunoEstadoAbandonado;
import model.AlunoEstadoMatriculado;
import model.AlunoEstadoTrancado;
import persistence.AlunoDAO;

/**
 *
 * @author Katyelen
 */
public class AbandonarAlunoAction implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String codigoAluno = request.getParameter("txtCodigo");

        String mensagem = "";
        String destino = "aluno.jsp";
        ArrayList<Aluno> listaaluno = new ArrayList<>();

        try {
            /*Recupera aluno*/
            Aluno aluno = AlunoDAO.getInstance().BuscarCodigo(codigoAluno);
            if (aluno == null) {
                mensagem = "Aluno não encontrado.";
            }

            mensagem = aluno.abandonar();

            if (mensagem.equals("ok")) {
                //Atualiza estado
                aluno.setEstadoAluno(new AlunoEstadoAbandonado());
                AlunoDAO.getInstance().AlterarEstado(aluno);
            }

            if (!mensagem.equals("ok")) {
                request.setAttribute("mensagem", mensagem);
            }

            listaaluno = AlunoDAO.getInstance().BuscarTodos();
            request.setAttribute("listaaluno", listaaluno);
            RequestDispatcher rd = request.getRequestDispatcher(destino);
            rd.forward(request, response);

        } catch (ServletException ex) {
            Logger.getLogger(GravarTurmaAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TrancarAlunoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TrancarAlunoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
