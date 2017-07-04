<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RegBook</title>
    </head>
    <body>
        <h1 align="center">RegBook</h1>
        <br>
        <form name="registro" method="post" style="position: absolute; left: 44%" 
              action="/regBook/servletweb?acao=Registrar">
            <label style="display: inline-block; width: 245px;">
                Nome do livro: 
                <input type="text" name="nome" id="nome" size="30">
            </label><br>
            <label style="display: inline-block; width: 245px;">
                Nome do autor:
                <input type="text" name="autor" id="nome" size="30">
            </label><br>
            <label style="display: inline-block; width: 245px;">
                Código ISBN:
                <input type="text" name="isbn" id="nome" size="30">
            </label><br>
            <label style="display: inline-block; width: 245px;">
                Volume do livro:
                <input type="text" name="volume" id="nome" size="30">
            </label><br>
            <label style="display: inline-block; width: 245px;">
                Data do livro:
                <input type="text" name="data" id="nome" size="30">
            </label><br>
            <label style="display: inline-block; width: 245px;">
                Nome da editora:
                <input type="text" name="editora" id="nome" size="30">
            </label><br>
            <label style="display: inline-block; width: 245px;">
                Número de páginas:
                <input type="text" name="paginas" id="nome" size="30">
            </label><br><br>
            <div align="center">
                <input type="submit" value="Inserir">
            </div>
        </form>
    </body>
</html>
