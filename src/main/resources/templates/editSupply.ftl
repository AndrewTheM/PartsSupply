<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Поставки</title>
        <link rel="stylesheet" type="text/css" href="css/indexStyle.css">
    </head>
    <body>
        <fieldset>
            <legend>Редактирование информации о запчасти</legend>
            <form name="supply" action="" method="POST">
                Поставщик:
                <br><@spring.formInput "supplyForm.supplier.id" "" "text"/> <br><br>
                Деталь:
                <br><@spring.formInput "supplyForm.part.id" "" "text"/> <br><br>
                Количество:
                <br><@spring.formInput "supplyForm.amount" "" "number"/> <br><br>
                Дата:
                <br><@spring.formInput "supplyForm.date" "" "date"/> <br><br>
                <input type="submit" value="Подтвердить"/>
            </form>
        </fieldset>
        <br>
        <a href="/api/supply/list">К списку</a>
    </body>
</html>