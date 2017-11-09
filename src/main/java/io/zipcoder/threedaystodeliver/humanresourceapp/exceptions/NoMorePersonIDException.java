package io.zipcoder.threedaystodeliver.humanresourceapp.exceptions;

public class NoMorePersonIDException extends Exception {

    public NoMorePersonIDException(){
        String message = "System has run out of ID numbers, contact your system admin for assistance.";
        System.out.println(message);
    }

}
