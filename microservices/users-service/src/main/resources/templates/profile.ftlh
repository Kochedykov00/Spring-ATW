<#include "base.ftlh" />

<#macro content>

    <#import "spring.ftl" as spring />

    <head>
        <title>Profile</title>
    </head>


    <div class="container-fluid profile-page-container">
        <div class="col-11">
            <div class="row profile">
                <div class="col-6">

                    <img src="${user.getPhoto()!}" width="400"/>
                </div>
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

                </div>
            </div>
        </div>
    </div>
</#macro>

<@display_page />