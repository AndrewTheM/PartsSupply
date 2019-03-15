<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Поставки</title>
        <link rel="stylesheet" type="text/css" href="\css\listStyle.css"/>
    </head>
    <body>
        <div align="center">
            <table border="1" cellspacing="0" cellpadding="5" bgcolor="#fff8dc">
                <tr>
                    <th>ID</th>
                    <th>Поставщик</th>
                    <th>Запчасть</th>
                    <th>Количество запчастей</th>
                    <th>Дата</th>
                    <th>Удаление</th>
                    <th>Изменение</th>
                </tr>
                <#list supplies as supply>
                    <tr align="center">
                        <td>${supply.id}</td>
                        <td>${supply.supplier.name}</td>
                        <td>${supply.part.name}</td>
                        <td>${supply.amount}</td>
                        <td>${supply.date}</td>
                        <td><a class="cross" href="/api/supply/delete/${supply.id}">Х</a></td>
                        <td><a class="cross" href="/api/supply/edit/${supply.id}">Х</a></td>
                    </tr>
                </#list>
            </table>
            <br><br>
            <a href="/api/supply/create">Добавить запись поставки</a>
            <br>
            <a href="/index">На главную</a>
        </div>
    </body>
</html>