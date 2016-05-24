<%@page import="model.Modalidade"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Aluno"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Academia</title>
        <style type = "text/css">
            body 
            {
                font-family: tahoma, helvetica, arial, sans-serif; 
            }
            table, tr, td, th
            { 
                font-size: .9em;
            }
            table.myclass, tr.myclass, td.myclass, th.myclass
            { 
                text-align: center;
                font-size: .9em;
                border: 1px groove;
                padding: 3px;
                background-color: #dddddd;
            }
        </style>
    </head>
    <body>
        <h1>Cadastro de Aluno</h1>
        <form action="FrontController?name=Aluno&action=Gravar" method="post">
            <table>
                <tr>
                    <td>Nome: </td>
                    <td><input type="text" name="txtNome" value="${modalidade.nome}"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Salvar"/></td>
                </tr> 
            </table>
        </form>      
        <br><br>
        <table class="myclass">
            <thead>
                <tr class="myclass">
                    <th class="myclass" style = "width: 100px;">Codigo</th>
                    <th class="myclass" style = "width: 100px;">Nome</th>
                    <th class="myclass" style = "width: 200px;"></th>
                </tr>
            </thead>
            <tbody>
                <% ArrayList<Modalidade> modalidade = (ArrayList<Modalidade>) request.getAttribute("listaaluno");
                   for (int i = 0; i < modalidade.size(); i++) { %>
                <form action="FrontController?name=Aluno&action=Apagar" method="post">
                   <tr class="myclass">
                    <td class="myclass"><input type="text" name="txtCodigo" value="<%=  modalidade.get(i).getCodigo()%>"/></td>
                    <td class="myclass"><input type="text" name="txtNome" value="<%=  modalidade.get(i).getNome()%>"/></td>
                    <td class="myclass"><input type="submit" value="Apagar"/></td>
                </tr>
                </form>
                <%  }%>
            </tbody>

        </table>
        <br><br><a href="index.jsp">Voltar</a>
    </body>
</html>
