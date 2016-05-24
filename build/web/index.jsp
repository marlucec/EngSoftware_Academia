<%-- 
    Document   : index
    Created on : 22/05/2016, 17:33:59
    Author     : Katyelen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Academia de Ginastica</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <style type = "text/css">
            body 
            {
                font-family: tahoma, helvetica, arial, sans-serif; 
            }
            table, tr, td, th
            { 
                text-align: left;
                font-size: large;
                padding: 0px;
            }
            
        </style>
        <h1>Academia</h1> 
        <table>
            <tr>
                <td><a href="FrontController?name=Aluno&action=Manter">Aluno</a></td>
            </tr>
            <tr>
                <td><a href="FrontController?name=Mensalidade&action=Manter">Mensalidade</a></td>
            </tr>
        </table>
    </body>
</html>
