<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<div>
    <table>
        <tr>
            <th>Имя</th>
            <th>email</th>
        </tr>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td><a href="/users/${user.id}">Посмотреть</a></td>
            </tr>
        </#list>
    </table>




    <p><label for="name"></label><input id="name" oninput="f()"/></p>

    <div id="res"></div>

    



</div>
</body>
</html>
