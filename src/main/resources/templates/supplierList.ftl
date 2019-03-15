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
            <table border="1" cellspacing="0" cellpadding="5" bgcolor="#fff8dc">
                <tr>
                    <th>ID</th>
                    <th>Код поставщика</th>
                    <th>Название/имя</th>
                    <th>Юридический адрес</th>
                    <th>Телефон</th>
                    <th>Удаление</th>
                    <th>Изменение</th>
                </tr>
                <#list suppliers as supplier>
                    <tr align="center">
                        <td>${supplier.id}</td>
                        <td>${supplier.code}</td>
                        <td>${supplier.name}</td>
                        <td>${supplier.address}</td>
                        <td>${supplier.phone}</td>
                        <td><a class="cross" href="/api/supplier/delete/${supplier.id}">Х</a></td>
                        <td><a class="cross" href="/api/supplier/edit/${supplier.id}">Х</a></td>
                    </tr>
                </#list>
            </table>
            <br><br>
            <a href="/api/supplier/create">Добавить поставщика</a>
            <br>
            <a href="/index">На главную</a>
        </div>
    </body>
</html>