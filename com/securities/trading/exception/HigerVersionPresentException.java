package com.securities.trading.exception;

public class HigerVersionPresentException extends Exception{

    public HigerVersionPresentException(String message){
        System.out.println(message);
        printStackTrace();
    }
}
