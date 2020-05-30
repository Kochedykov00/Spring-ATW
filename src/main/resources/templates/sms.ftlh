<#include "base.ftlh"/>
<#macro content>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script type="application/javascript" src="webjars/jquery/3.4.1/jquery.min.js"></script>
    <title>Sms</title>
</head>
<body>
<h2 id="result"></h2>
<input type="text" id="query">
<input type="button" value="send" onclick="f()">
<script type="application/javascript">
    function f() {
        $.ajax({
            url: "/sms",
            data: {"text": $("#query").val()},

            success: function (data) {
                if (data.length > 0) {
                    $("#result").html("");
                    $("#result").append("отправлено");
                } else {
                    $("#result").html("не отправлено");
                }
            }
        })
    }
</script>
</body>
</html>
</#macro>
<@display_page/>