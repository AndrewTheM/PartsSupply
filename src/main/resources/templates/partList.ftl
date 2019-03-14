<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Запчасти</title>
        <link rel="stylesheet" type="text/css" href="listStyle.css">
    </head>
    <body>
        <table border="1" bgcolor="#fff8dc" align="center">
            <tr>
                <th>ID</th>
                <th>Код запчасти</th>
                <th>Название</th>
                <th>Тип/артикул</th>
                <th>Цена</th>
                <th>Заметка</th>
                <th>Удаление</th>
                <th>Изменение</th>
            </tr>
            <#list parts as part>
                <tr>
                    <td>${part.id}</td>
                    <td>${part.code}</td>
                    <td>${part.name}</td>
                    <td>${part.type}</td>
                    <td>${part.price}</td>
                    <td>${part.annotation}</td>
                    <td align="center"><a href="/api/part/delete/${part.id}">Х</a></td>
                    <td align="center"><a href="/api/part/edit/${part.id}">Х</a></td>
                </tr>
            </#list>
        </table>
        <br><br>
        <a href="/api/part/create">Добавить запчасть</a>
        <br>
        <a href="/index">На главную</a>
    </body>
</html>