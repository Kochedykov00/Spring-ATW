<#include "base.ftlh"/>

<#macro content>

    <#import "spring.ftl" as spring />

    <head>
        <title><@spring.message 'profile.page.edit.head'/></title>
    </head>


    <script>
        function sendFile() {
            // данные для отправки
            let formData = new FormData();
            // забрал файл из input
            let files = ($('#file'))[0]['files'];
            // добавляю файл в formData
            [].forEach.call(files, function (file, i, files) {
                formData.append("file", file);
            });

            $.ajax({
                type: "POST",
                url: "/files",
                data: formData,
                processData: false,
                contentType: false
            })
                .done(function (response) {
                    let fileUrl = 'http://localhost/files/' + response;
                    $('#photo').attr('value', '' + fileUrl);
                })
                .fail(function () {
                    alert('Error')
                });
        }
    </script>


    <form method="post" enctype="multipart/form-data">
        <div class="container-fluid profile-page-container">
            <div class="col-11">
                <div class="row profile">
                    <div class="col-6">

                        <div class="form-group">
                            <#if user.getPhoto()??>
                                <img src="${user.getPhoto()!}" width="400"/>
                            </#if>


                            <div class="form-group row">
                                <input type="file" id="file" name="file" placeholder="Name..."/>
                                <input type="button" onclick="sendFile()" class="btn btn-primary mb-2" value="Ok"/>
                            </div>
                            <input type="hidden" id="photo" name="photo" value=" ">

                        </div>
                    </div>
                    <div class="col-5 profileInfo">
                        <div class="row" id="infoAbout">
                            <div class="col-5">
                                <label for="login"><@spring.message 'profile.page.edit.login'/></label>
                                <br /><br />
                                <label for="surname"><@spring.message 'profile.page.edit.lastname'/></label>
                                <br /><br />
                                <label for="name"><@spring.message 'profile.page.edit.firstname'/></label>
                                <br /><br />
                                <label for="info"><@spring.message 'profile.page.edit.info'/></label>
                            </div>
                            <div class="col-6">
                                <input type="text" name="username" value="${user.getUsername()}" class="form-control" placeholder="" id="login">
                                <br />
                                <input type="text" value = "${user.getLastname()}" name="lastname" class="form-control" placeholder="" id="surname">
                                <br />
                                <input type="text"  value = "${user.getFirstname()}"  name="firstname" class="form-control" placeholder="" id="name">
                                <br />
                                <#if user.getInfo()??>
                                    <input type="text" value="${user.getInfo()}" name="info" class="form-control" placeholder="" id="info">
                                <#else >
                                    <input type="text"  name="info" class="form-control" placeholder="" id="info">
                                </#if >

                            </div>
                        </div>
                        <br />

                    </div>
                </div>
            </div>
            <div class="container" >
                <div class="col-5" style="margin-left: 37%">
                    <button  style="background-color: rgba(58,49,148,0.91)" value="save" type="submit" name="submit" id="submit"  class="btn btn btn-primary border-black mx-4 btn-lg px-15 mt-4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<@spring.message 'profile.page.edit.change'/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
                </div>
            </div>
        </div>
    </form>
</#macro>

<@display_page />