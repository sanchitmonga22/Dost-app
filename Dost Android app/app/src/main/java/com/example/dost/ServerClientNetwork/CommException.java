package com.example.dost.ServerClientNetwork;

/**
 * Class used to raise the custom exception
 * @author : Sanchit Monga
 */
public class CommException extends Exception {

    public CommException(String message){
        super(message);
    }
}