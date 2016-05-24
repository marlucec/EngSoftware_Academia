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
import model.Aluno;
import model.AlunoEstadoMatriculado;
import persistence.AlunoDAO;


/**
 *
 * @author Katyelen
 */
public class GravarAlunoAction implements Action{

    public void execute(HttpServletRequest request, HttpServletResponse response) {
        
        String matricula = request.getParameter("txtMatricula");
        String nome = request.getParameter("txtNome");
        String email = request.getParameter("txtEmail");
        String telefone = request.getParameter("txtTelefone");

        try {
            if ( matricula.equals("") || nome.equals("")) {
                response.sendRedirect("erro.jsp");
            } else {
                Aluno aluno =  new Aluno();
                aluno.setMatricula(matricula);
                aluno.setNome(nome);
                aluno.setEmail(email);
                aluno.setTelefone(telefone);
                aluno.setEstadoAluno(new AlunoEstadoMatriculado());
                AlunoDAO.getInstance().Gravar(aluno);
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
