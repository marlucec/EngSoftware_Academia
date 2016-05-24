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
import persistence.AlunoDAO;

/**
 *
 * @author Katyelen
 */
public class ManterAlunoAction implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ArrayList<Aluno> listaaluno = new ArrayList<Aluno>();

//        Aluno a = new Aluno();
//        a.setCodigo(1);
//        a.setMatricula("201276021");
//        a.setNome("Katyelen");
//        a.setEmail("Katyelen@gmail");
//        a.setTelefone("32 98829-3197");
//        a.setEstadoAluno(new AlunoEstadoMatriculado());
//
//        listaaluno.add(a);
        
        try {
            listaaluno = AlunoDAO.getInstance().BuscarTodos(); 
            
            //request.setAttribute("aluno", a);
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
            Logger.getLogger(ManterAlunoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterAlunoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
