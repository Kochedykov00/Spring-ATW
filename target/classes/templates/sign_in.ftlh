<#include "base.ftlh"/>
<#macro content>
</#macro>
<#macro display_page>

<#import "spring.ftl" as spring />


<form method="post">

    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Sign in</title>
        <link rel="stylesheet" href="../css/bootstrap.css">
        <link rel="stylesheet" href="../css/styleForATW.css">
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/jquery-3.4.1.min.js"></script>
        <script src="../js/bootstrap.bundle.js"></script>

    </head>

    <style>
        .error {
            color: #ff0000;
        }
    </style>

    <body style="background-color: #d4e3fc">
    <nav class="navbar navbar-expand-sm navbar-dark justify-content-end" style="background-color: #8eb0fa">
        <a class="navbar-brand text-white">Around The World</a>
        <div class="col-2 offset-8 ">
            <div class="dropdown" hidden>
                <button type="button" class="btn btn-primary dropdown-toggle top-line-btn" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Меню</button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="">Мой профиль</a>
                    <a class="dropdown-item" href="">Мой блог</a>
                    <a class="dropdown-item" href="">Обсуждения</a>
                    <a class="dropdown-item" href="">Главная</a>
                    <a class="dropdown-item" href="">Выход</a>
                </div>
            </div>
        </div>
    </nav>

    <div class="mt-7">
        <h1 class="mb-lg-5"><img src="/photo/key_icon.png">&nbsp;&nbsp;<@spring.message 'signIn.logo'/></h1>
    </div>
    <br />
    <form  method="post">
        <div class="container">
            <div class="row" id="inputInformation">
                <div class="col-2">
                    <label for="email"><@spring.message 'signIn.email'/></label>
                    <br /><br /><br />
                    <label for="password"><@spring.message 'signIn.password'/></label>
                </div>
                <div class="col-6">
                    <input class="form-control" type="text" name="email" id="email" size="50%" placeholder="<@spring.message 'signIn.placeholderEmail'/>"/>

                    <br /><br />
                    <input class="form-control" type="password" name="password" id="password" size="50%" placeholder="<@spring.message 'signIn.placeholderPassword'/>"/>

                </div>
            </div>
        </div>
        <br /><br />
        <div class="container">
            <div class="row">
                <div class="col-6" align="right">
                    <input type="checkbox" id = "checkbox" name="checkbox"><@spring.message 'signIn.checkbox'/></input>
                    <a class="btn btn-primary border-black mx-4 btn-lg px-15 mt-4"
                       style="background-color: rgba(59,72,148,0.91)"
                       href="/signUp" role="button">&nbsp;&nbsp;&nbsp;<@spring.message 'signIn.signUp'/>&nbsp;&nbsp;&nbsp;</a>
                </div>
                <form action="/signIn" method="post">
                <div class="col-5" align="left">
                    <input type="submit" id="submit" name = "submit" value="<@spring.message 'signIn.signIn'/>" class="btn btn-primary border-black mx-4 btn-lg px-15 mt-4" style="background-color: rgba(58,49,148,0.91)"></input>
                </div>
            </div>
        </div>
    </form>

    <script src="C:\BitBucket\Abramsky\web\Frontend\js\bootstrap.min.js"></script>
    <script src="C:\BitBucket\Abramsky\web\Frontend\js\jquery-3.4.1.min.js"></script>
    <script src="C:\BitBucket\Abramsky\web\Frontend\js\bootstrap.bundle.js"></script>
    <script src="C:\BitBucket\Abramsky\web\Frontend\js\myJs.js"></script>

</body>

</html>

</#macro>

<@display_page />






