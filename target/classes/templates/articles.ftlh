<#include "base.ftlh" />


<#macro content>
    <#import 'spring.ftl' as spring >

    <head>
        <title><@spring.message 'main.page.head'/></title>
    </head>



    <body>

    <div class="col-12">
    <p><label for="name"></label><input id="name" oninput="f()"/></p>
    </div>


    <div id="res"></div>

    <script type="application/javascript">

        function f() {
            if ($("#name").val().length >= 1) {
                $.ajax({
                    url: "/users/search",
                    data: {"name": $("#name").val()},
                    dataType: "json",
                    success: function (name) {

                        if (name.length > 0) {

                            $("#res").html("");
                            $("#res").append("<h3>Найдено " + name.length + " пользователя(ей)</h3>");
                            for (var i = 0; i < name.length; i++) {


                                $("#res").append("<h4>" + name[i].username + "</h4>");
                            }
                        } else {
                            $("#res").html("Пользователи не найдены");
                        }
                    }
                })
            }
            else {
                $("#res").html(" ");
            }
        }
    </script>



    <br /><br />

    <div id="bests">
        <h3 class="mb-lg-5"><img src="../photo/star.png">&nbsp;<@spring.message 'main.page.better'/></h3>
    </div>

    <div class="col-12">
        <div class="row" id="bestRow">
            <#list articlesByRating as a>
                <div class="col-2 bestArt" >
                    <div class="bestArtRow row">



                        <img src="${a.photo}" class="small-photo">
                        <div class="bestArtBody">

                            <div style="overflow: auto; max-width: 100px;">
                                <div><a class="articleHref" href="/articles/${a.id}">${a.title}</a></div>
                                <div><a class="articleHref" href="/profile/${a.user_id}">Author</a></div>
                                <div><h6>${a.date}</h6></div>
                            </div>

                        </div>

                    </div>


                </div>
            </#list>
        </div>

        <div id="lasts">
            <h3 class="mb-lg-5"><img src="../photo/calendar.png">&nbsp;<@spring.message 'main.page.new'/></h3>
        </div>

        <div class="container-fluid page-container">
            <div class="row">
                <div class="col-9">
                    <#list articlesByDate as ad>
                        <div class="col-9 lastArt" >
                            <div class="lastArtRow row">

                                <img src="${ad.photo}" class="small-photo1" width="200px", height="auto">
                                <div class="lastArtBody">
                                    <div style="overflow: auto; max-width: 300px;">
                                        <div><a class="articleHref" href="/articles/${ad.id}">${ad.title}</a></div>
                                        <div><a class="articleHref" href="/profile/${ad.user_id}">Author</a></div>
                                        <div><h6>${ad.date}</h6></div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </#list>



                </div>
            </div>
        </div>

    </div>

    <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    <script src="../js/jquery-3.4.1.min.js" type="text/javascript"></script>
    <script src="../js/bootstrap.bundle.js" type="text/javascript"></script>
    <script src="../js/myJs.js" type="text/javascript"></script>




    </body>
    </html>
</#macro>

<@display_page />