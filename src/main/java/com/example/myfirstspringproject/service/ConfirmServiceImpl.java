package com.example.myfirstspringproject.service;

import com.example.myfirstspringproject.models.State;
import com.example.myfirstspringproject.models.User;
import com.example.myfirstspringproject.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Optional;

    @Service
    public class ConfirmServiceImpl implements ConfirmService {

        @Autowired
        private UsersRepository usersRepository;

        @Autowired
        private HttpHeaders headers;

        @Autowired
        private RestTemplate restTemplate;



        @Override
        public boolean confirm(String confirmCode) {
            Optional<User> userOptional = usersRepository.findByConfirmCode(confirmCode);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                user.setState(State.CONFIRMED);
                usersRepository.save(user);


                RestTemplate restTemplate = new RestTemplate();
                HttpHeaders headers = new HttpHeaders();
                headers.setBasicAuth("sasha.kochedykov@mail.ru", "c9Axu85uxw3kb8g9qh9NKjtzpZPm");
                String uri = "https://@gate.smsaero.ru/v2/sms/send?number=79172610217&text=hello abr&sign=SMS Aero&channel=DIRECT";
                HttpEntity<String> entity = new HttpEntity<>(headers);
                ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
                return true;
            }
            return false;
        }
    }


