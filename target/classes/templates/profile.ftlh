<#include "base.ftlh" />

<#macro content>

    <#import "spring.ftl" as spring />

    <head>
        <title>Profile</title>

        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('.delete').click(function () {
                    var name = $(this).attr('name');
                    $.ajax({
                        type: "post",
                        url: "/delete",
                        data: {
                            "checklist_id": name
                        },
                        success: function () {
                            $('#' + name).fadeOut();
                        }
                    });
                });
            });
        </script>

    </head>


    <div class="container-fluid profile-page-container">
        <div class="col-11">
            <div class="row profile">
                <div class="col-6">

                    <img src="${user.getPhoto()!}" width="400"/>
                </div>
                <#if user.getId() == myPage.getId()>
                    <a href="/editProfile"><@spring.message 'profile.page.blog'/></a>
                </#if>



                        <div class="col-5 profileInfo">

                    <div class="row" id="infoAbout">
                        <div class="col-5">
                            <label for="login"><@spring.message 'profile.page.username'/> :</label>
                            <br /><br />
                            <label for="surname"><@spring.message 'profile.page.lastname'/> :</label>
                            <br /><br />
                            <label for="name"><@spring.message 'profile.page.firstname'/> :</label>
                            <br /><br />
                            <label for="info"><@spring.message 'profile.page.info'/> :</label>
                        </div>
                        <div class="col-6">


                            <h4 id="login">${user.getUsername()}</h4>
                            <br />
                            <h4 id="surname">${user.getLastname()}</h4>
                            <br />
                            <h4 id="name">${user.getFirstname()}</h4>
                            <br />

                            <#if user.getInfo()??>
                                <h4 id="info">${user.getInfo()}</h4>
                            </#if>
                        </div>
                    </div>
                    <br />
                            <div class="row" style="font-size: 19px;font-weight: 700;">
                                <div class="col-5">
                                    <label for="blog">Blog :</label>
                                </div>
                                     <#list blog as b>


                                    <div class="col-6">
                                        <div class="row">
                                            <h4 id="blog">${b.title}</h4>
                                            <form style="margin-left: 20%" action="/blog/${b.id}" >
                                                &nbsp;&nbsp;&nbsp;<button type="submit" class="btn btn-outline-primary"><@spring.message 'profile.page.blog'/></button>
                                            </form>
                                        </div>
                                    </div>


                                </#list>

                            </div>


                </div>
            </div>
        </div>
    </div>
</#macro>

<@display_page />