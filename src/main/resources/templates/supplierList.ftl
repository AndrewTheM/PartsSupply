<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Поставщики</title>
        <link rel="stylesheet" type="text/css" href="\css\listStyle.css"/>
    </head>
    <body>
        <div align="center">
            <a class="button" href="/api/supplier/create">Добавить поставщика</a>
            <a class="button" href="/index">На главную</a>
            <br><br>
            <table border="1" cellspacing="0" cellpadding="5">
                <tr>
                    <th>ID</th>
                    <th>Код поставщика</th>
                    <th>Название/имя</th>
                    <th>Юридический адрес</th>
                    <th>Телефон</th>
                    <th colspan="2">Редактирование</th>
                </tr>
                <#list suppliers as supplier>
                    <tr align="center">
                        <td>${supplier.id}</td>
                        <td>${supplier.code}</td>
                        <td>${supplier.name}</td>
                        <td>${supplier.address}</td>
                        <td>${supplier.phone}</td>
                        <td><a class="cross" href="/api/supplier/delete/${supplier.id}">Удалить</a></td>
                        <td><a class="cross" href="/api/supplier/edit/${supplier.id}">Изменить</a></td>
                    </tr>
                </#list>
            </table>
        </div>
    </body>
</html>