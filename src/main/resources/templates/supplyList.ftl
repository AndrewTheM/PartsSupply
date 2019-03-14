<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Поставки</title>
        <link rel="stylesheet" type="text/css" href="listStyle.css">
    </head>
    <body>
        <table border="2" bgcolor="#fff8dc" align="center">
            <tr>
                <th>ID</th>
                <th>ID поставщика</th>
                <th>ID запчасти</th>
                <th>Количество запчастей</th>
                <th>Дата</th>
                <th>Удаление</th>
                <th>Изменение</th>
            </tr>
            <#list supplies as supply>
                <tr>
                    <td>${supply.id}</td>
                    <td>${supply.supplier.id}</td>
                    <td>${supply.part.id}</td>
                    <td>${supply.amount}</td>
                    <td>${supply.date}</td>
                    <td align="center"><a href="/api/supply/delete/${supply.id}">Х</a></td>
                    <td align="center"><a href="/api/supply/edit/${supply.id}">Х</a></td>
                </tr>
            </#list>
        </table>
        <br><br>
        <a href="<@spring.url '/api/supply/create'/>">Добавить запись поставки</a>
        <br>
        <a href="/index">На главную</a>
    </body>
</html>