<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Поставки</title>
        <link rel="stylesheet" type="text/css" href="\css\formStyle.css"/>
    </head>
    <body>
        <fieldset>
            <legend>Добавление новой записи о поставке</legend>
            <form name="supply" action="" method="POST">
                Поставщик:
                <br><@spring.formSingleSelect "supplyForm.supplier" supplierMavs ""/> <br><br>
                Деталь:
                <br><@spring.formSingleSelect "supplyForm.part" partMavs ""/> <br><br>
                Количество:
                <br><@spring.formInput "supplyForm.amount" "" "number"/> <br><br>
                Дата:
                <br><@spring.formInput "supplyForm.date" "" "date"/> <br><br>
                <input class="button" type="submit" value="Добавить"/>
            </form>
        </fieldset>
        <br>
        <a href="/api/supply/list">К списку</a>
    </body>
</html>