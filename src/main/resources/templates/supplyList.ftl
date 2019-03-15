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
            <a class="button" href="/api/supply/create">Добавить запись поставки</a>
            <a class="button" href="/index">На главную</a>
            <br><br>
            <table border="1" cellspacing="0" cellpadding="5">
                <tr>
                    <th>ID</th>
                    <th>Поставщик</th>
                    <th>Запчасть</th>
                    <th>Количество запчастей</th>
                    <th>Дата</th>
                    <th colspan="2">Редактирование</th>
                </tr>
                <#list supplies as supply>
                    <tr align="center">
                        <td>${supply.id}</td>
                        <td>${supply.supplier.name}</td>
                        <td>${supply.part.name}</td>
                        <td>${supply.amount}</td>
                        <td>${supply.date}</td>
                        <td><a class="cross" href="/api/supply/delete/${supply.id}">Удалить</a></td>
                        <td><a class="cross" href="/api/supply/edit/${supply.id}">Изменить</a></td>
                    </tr>
                </#list>
            </table>
        </div>
    </body>
</html>