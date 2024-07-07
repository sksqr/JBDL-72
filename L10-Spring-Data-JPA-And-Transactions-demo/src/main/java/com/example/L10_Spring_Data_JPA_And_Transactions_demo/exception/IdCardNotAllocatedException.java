package com.example.L10_Spring_Data_JPA_And_Transactions_demo.exception;

public class IdCardNotAllocatedException extends Exception{

    public IdCardNotAllocatedException(String message) {
        super(message);
    }
}
