<%@page import="model.Mensalidade"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Aluno"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat, java.util.Calendar,java.util.Date, java.util.GregorianCalendar " %>
<jsp:useBean id="aluno" class="model.Aluno"/>
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
        <h1>Cadastro de Mensalidade</h1>
        <form action="FrontController?name=Mensalidade&action=Gravar" method="post">
            <table>
                <tr>
                    <td>Aluno: </td>
                    <td><input type="text" size="15" name="txtAluno" value="${mensalidade.aluno.codigo}"/></td>
<!--                    <td><select name="id_tipo" class="go" size="1">
                            <c:forEach var="a" items="${listaaluno}">
                                <option value="${a.codigo}">${a.nome}</option>	
                            </c:forEach>
                        </select></td>-->
                </tr>
                <tr>
                    <td>Valor: </td>
                    <td><input type="text" size="15" name="txtValor" value="${mensalidade.valor}"/></td>
                </tr>
                <tr>
                    <td>Multa: </td>
                    <td><input type="text" size="15" name="txtMulta" value="${mensalidade.multa}"/></td>
                </tr>
                <tr>
                    <td>Vencimento: </td>
                    <td><input type="date" size="15" name="txtVencimento" value="${mensalidade.vencimento}"/></td>
                </tr>
                <tr>
                    <td>Pagamento: </td>
                    <td><input type="date" size="15" name="txtPagamento" value="${mensalidade.pagamento}"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Salvar"/></td>
                </tr> 
            </table>
        </form>      
        <br><br>        
        <br><br><a href="index.jsp">Voltar</a>
    </body>
</html>
