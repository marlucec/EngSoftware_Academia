/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import model.Aluno;
import model.AlunoEstadoMatriculado;
import model.AlunoEstadoTrancado;
import model.OrdenadorAlunoPorMatricula;
import model.OrdenadorAlunoPorNome;
import persistence.AlunoDAO;

/**
 *
 * @author Katyelen
 */
public class OrdenarMatriculaAlunoAction implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ArrayList<Aluno> listaaluno = new ArrayList<Aluno>();       
        
        try {
            listaaluno = AlunoDAO.getInstance().BuscarTodos(); 
            
            //request.setAttribute("aluno", a);
            
            OrdenadorAlunoPorMatricula order = new OrdenadorAlunoPorMatricula();
            listaaluno = order.ordenarAlunos(listaaluno);
            request.setAttribute("listaaluno", listaaluno);
            RequestDispatcher rd = request.getRequestDispatcher("aluno.jsp");
            rd.forward(request, response);

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ServletException ex) {
            ex.printStackTrace();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ManterAlunoAction.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(ManterAlunoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrdenarMatriculaAlunoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrdenarMatriculaAlunoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
