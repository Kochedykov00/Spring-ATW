package com.example.myfirstspringproject.service;


public interface ConfirmService {
    boolean confirm(String confirmCode);
    public  boolean confirmBySms(String confirmCode);
}

