<#include "base.ftlh" />



<#macro content>

    <#if isConfirmed == true>
        <h1>Подтверждено!</h1>
    <#else>
        <h1>Ошибка</h1>
    </#if>




</#macro>

<@display_page />


