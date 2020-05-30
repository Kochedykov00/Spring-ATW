package com.example.myfirstspringproject.controllers;

import com.example.myfirstspringproject.service.ConfirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class SmsController {

    @Autowired
    ConfirmService confirmService;

    @GetMapping("/sms")
    public String getUsersPage() {
        return "sms";
    }

    @RequestMapping(path = "/sms", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public void sendSms(@RequestParam("text") String text) {
        /* вынес в отдельный метод потому что закончились деньги и выдает ошибку*/
        confirmService.confirmBySms(text);
    }
}
