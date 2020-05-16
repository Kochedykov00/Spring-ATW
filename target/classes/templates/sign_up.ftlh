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
        <title>Sign up</title>
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
        <a class="navbar-brand text-black">Around The World</a>
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
        <h1 class="mb-lg-5"><img src="../photo/iconadd.png"><@spring.message 'signUp.logo'/></h1>
    </div>
    <@spring.bind "form"/>
    <form name="registration" action="/signUp" method="post">
        <div class="container">
            <div class="row" id="inputInformation">
                <div class="col-2">
                    <label for="surname"><@spring.message 'signUp.lastname'/></label>
                    <br /><br />
                    <label for="name"><@spring.message 'signUp.firstname'/></label>
                    <br /><br />
                    <label for="email"><@spring.message 'signUp.email'/></label>
                    <br /><br />
                    <label for="login"><@spring.message 'signUp.login'/></label>
                    <br /><br />
                    <label for="password"><@spring.message 'signUp.password'/></label>
                    <br /><br />
                    <label for="password2"><@spring.message 'signUp.repeatPassword'/></label>
                </div>
                <div class="col-6">

                    <@spring.formInput "form.lastname"/>
                    <br>
                    <@spring.showErrors "<br>", "error"/>
                    <br />

                    <@spring.formInput "form.firstname"/>
                    <br>
                    <@spring.showErrors "<br>", "error"/>
                    <br />

                    <@spring.formInput "form.email"/>
                    <br>
                    <@spring.showErrors "<br>", "error"/>
                    <br />

                    <@spring.formInput "form.username"/>
                    <br>
                    <@spring.showErrors "<br>", "error"/>
                    <br />
                    <input  class="form-control" type="password" name="password" id="password" size="50%" placeholder="<@spring.message 'signUp.PlaceholderPassword'/>"/>

                    <br />
                    <input  class="form-control" type="password" name="password2" id="password2" size="50%" placeholder="<@spring.message 'signUp.PlaceholderRepeatPassword'/>"/>

                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-6" align="right">
                    <button style="background-color: rgba(59,72,148,0.91)" value="save" type="submit" id="submit"  class="btn btn btn-primary border-black mx-4 btn-lg px-15 mt-4">&nbsp;&nbsp;&nbsp;<@spring.message 'signUp.SignUp'/>&nbsp;&nbsp;&nbsp;</button>
                </div>
                <div class="col-5" align="left">
                    <a class="btn btn-primary border-black mx-4 btn-lg px-15 mt-4"
                       style="background-color: rgba(58,49,148,0.91)"
                       href="/signIn" role="button">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<@spring.message 'signUp.SignIn'/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
                </div>
            </div>
        </div>
    </form>
    </div>
    </body>
    </html>

    </#macro>

    <@display_page />
