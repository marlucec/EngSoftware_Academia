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
                    <td>Matricula: </td>
                    <td><input type="text" name="txtMatricula" value="${aluno.matricula}"/></td>
                </tr>
                <tr>
                    <td>Nome: </td>
                    <td><input type="text" name="txtNome" value="${aluno.nome}"/></td>
                </tr>
                <tr>
                    <td>Email: </td>
                    <td><input type="text" name="txtEmail" value="${aluno.email}"/></td>
                </tr>
                <tr>
                    <td>Telefone: </td>
                    <td><input type="text" name="txtTelefone" value="${aluno.telefone}"/></td>
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
                    <th class="myclass">Código</th>
                    <th class="myclass">Matricula <a href="FrontController?name=Aluno&action=OrdenarMatricula" class="linkdois"><img height=20 src="img/sort.png" width=10 border=0></a></th>
                    <th class="myclass">Nome <a href="FrontController?name=Aluno&action=OrdenarNome" class="linkdois"><img height=20 src="img/sort.png" width=10 border=0></a></th>
                    <th class="myclass">Email</th>
                    <th class="myclass">Telefone</th>
                    <th class="myclass">Estado</th>
                    <th class="myclass" colspan="4">Ação</th>
                </tr>
            </thead>
            <tbody>
                <% ArrayList<Aluno> aluno = (ArrayList<Aluno>) request.getAttribute("listaaluno");
                    for (int i = 0; i < aluno.size(); i++) {%>
            
                <tr class="myclass">
                    <td class="myclass"><input type="text" name="txtCodigo" value="<%=  aluno.get(i).getCodigo()%>"/></td>
                    <td class="myclass"><input type="text" name="txtMatricula" value="<%=  aluno.get(i).getMatricula()%>"/></td>
                    <td class="myclass"><input type="text" name="txtNome" value="<%=  aluno.get(i).getNome()%>"/></td>
                    <td class="myclass"><input type="text" name="txtEmail" value="<%=  aluno.get(i).getEmail()%>"/></td>
                    <td class="myclass"><input type="text" name="txtTelefone" value="<%=  aluno.get(i).getTelefone()%>"/></td>
                    <td class="myclass"><input type="text" name="txtEstado" value="<%=  aluno.get(i).getNomeEstadoAluno()%>"/></td>
                    <td class="myclass">
                        <form action="FrontController?name=Aluno&action=Apagar" method="post">
                        <input type="submit" value="Apagar"/>
                        </form>
                    </td>
                    <td class="myclass">
                        <form action="FrontController?name=Aluno&action=Matricular" method="post">
                            <input type="hidden" name="txtCodigo" value="<%=  aluno.get(i).getCodigo()%>"/>
                            <input type="submit" value="Matricular"/>
                        </form>
                    </td>
                    <td class="myclass">
                        <form action="FrontController?name=Aluno&action=Trancar" method="post">
                            <input type="hidden" name="txtCodigo" value="<%=  aluno.get(i).getCodigo()%>"/>
                            <input type="submit" value="Trancar"/>
                        </form>
                    </td>
                    <td class="myclass">
                        <form action="FrontController?name=Aluno&action=Abandonar" method="post">
                            <input type="hidden" name="txtCodigo" value="<%=  aluno.get(i).getCodigo()%>"/>
                            <input type="submit" value="Abandonar"/>
                        </form>
                    </td>
                </tr>
            
            <%  }%>
            
            <font color="#FF0000"><h3>${mensagem}</h3></font>
        </tbody>

    </table>
    <br><br><a href="index.jsp">Voltar</a>
</body>
</html>
