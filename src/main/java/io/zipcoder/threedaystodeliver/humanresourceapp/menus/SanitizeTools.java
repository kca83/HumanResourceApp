package io.zipcoder.threedaystodeliver.humanresourceapp.menus;

import io.zipcoder.threedaystodeliver.humanresourceapp.Compensation;

import java.time.LocalDate;
import java.util.Scanner;

import static io.zipcoder.threedaystodeliver.humanresourceapp.Compensation.compensationType.Hourly;
import static io.zipcoder.threedaystodeliver.humanresourceapp.Compensation.compensationType.Monthly;
import static io.zipcoder.threedaystodeliver.humanresourceapp.Compensation.compensationType.Project;

public class SanitizeTools {
    public static LocalDate getEnforcedLocalDateInput(){
        Scanner in = new Scanner(System.in);
        LocalDate localDateInput;
        String sInput;
        do {
            sInput = in.nextLine();
            if (!isInputLocalDate(sInput)) {
                System.out.println("Please enter a date in YYYY-MM-DD format.");
            }
        }while (!isInputLocalDate(sInput));
        localDateInput=LocalDate.parse(sInput);
        return localDateInput;
    }

    private static boolean isInputLocalDate(String passedString)
    {
        try {
            LocalDate output = LocalDate.parse(passedString);
        } catch (Exception e) {
            return false;
        }
        return (true);
    }

    public static double getEnforcedPositiveDoubleInput(){
        Scanner in = new Scanner(System.in);
        double dInput;
        String sInput;
        do {
            sInput = in.nextLine();
            if (!isInputDouble(sInput)||(Double.valueOf(sInput)<0)) {
                System.out.println("Please enter a decimal number greater than 0.");
            }
        }while (!isInputDouble(sInput)||(Double.valueOf(sInput)<0));
        dInput=Double.valueOf(sInput);
        return dInput;
    }

   /* public static double getEnforcedPositiveInput(double doubleIn){
        do {
            if(doubleIn < 0){
                System.out.println("Please enter a value greater than or equal to zero.");
            }while (doubleIn < 0);
        }
        return doubleIn;
    }*/

    private static boolean isInputDouble(String passedString)
    {
        try {
            Double output = Double.valueOf(passedString);
        } catch (NumberFormatException e) {
            return false;
        }
        return (true);
    }

    public static double getEnforcedIntegerInput(){
        Scanner in = new Scanner(System.in);
        int iInput;
        String sInput;
        do {
            sInput = in.nextLine();
            if (!isInputInt(sInput)) {
                System.out.println("Please enter an integer number.");
            }
        }while (!isInputInt(sInput));
        iInput=Integer.valueOf(sInput);
        return iInput;
    }

    private static boolean isInputInt(String passedString)
    {
        try {
            Integer output = Integer.valueOf(passedString);
        } catch (NumberFormatException e) {
            return false;
        }
        return (true);
    }

    public static Compensation.compensationType getEnforcedCompensationType() {
        Scanner in = new Scanner(System.in);
        Compensation.compensationType compType;
        String sInput;
        do {
            sInput = in.nextLine();
            if (!isInputCompensationType(sInput)) {
                System.out.println("Please enter " + Monthly + ", " + Hourly + ", or " + Project);
            }
        }while (!isInputCompensationType(sInput));

        String lowerCase = sInput.toLowerCase();
        if("monthly".equals(lowerCase)) {
            return Monthly;
        }
        else if("hourly".equals(lowerCase)) {
            return Hourly;
        }
        else {
            return Project;
        }
    }

    private static boolean isInputCompensationType(String passedString) {
        String lowerCase = passedString.toLowerCase();
        return ("monthly".equals(lowerCase) || "hourly".equals(lowerCase) || "project".equals(lowerCase));
    }


}
