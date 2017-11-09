package io.zipcoder.threedaystodeliver.humanresourceapp.exceptions;

public class NotAnEmployeeException extends Exception {

    public NotAnEmployeeException(){
        System.out.println("Can't change a non-current-employee");
    }

}
