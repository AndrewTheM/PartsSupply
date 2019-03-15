<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Запчасти</title>
        <link rel="stylesheet" type="text/css" href="\css\listStyle.css"/>
    </head>
    <body>
        <div align="center">
            <a class="button" href="/api/part/create">Добавить запчасть</a>
            <a class="button" href="/index">На главную</a>
            <br><br>
            <table border="1" cellspacing="0" cellpadding="5">
                <tr>
                    <th>ID</th>
                    <th>Код запчасти</th>
                    <th>Название</th>
                    <th>Тип/артикул</th>
                    <th>Цена</th>
                    <th>Заметка</th>
                    <th colspan="2">Редактирование</th>
                </tr>
                <#list parts as part>
                    <tr align="center">
                        <td>${part.id}</td>
                        <td>${part.code}</td>
                        <td>${part.name}</td>
                        <td>${part.type}</td>
                        <td>${part.price}</td>
                        <td>${part.annotation}</td>
                        <td><a class="cross" href="/api/part/delete/${part.id}">Удалить</a></td>
                        <td><a class="cross" href="/api/part/edit/${part.id}">Изменить</a></td>
                    </tr>
                </#list>
            </table>
        </div>
    </body>
</html>