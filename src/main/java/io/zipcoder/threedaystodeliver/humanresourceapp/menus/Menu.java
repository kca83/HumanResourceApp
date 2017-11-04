package io.zipcoder.threedaystodeliver.humanresourceapp.menus;

import io.zipcoder.threedaystodeliver.humanresourceapp.*;

import java.util.ArrayList;
import java.util.Scanner;

import static io.zipcoder.threedaystodeliver.humanresourceapp.menus.SanitizeTools.getEnforcedCompensationType;
import static io.zipcoder.threedaystodeliver.humanresourceapp.menus.SanitizeTools.getEnforcedPositiveDoubleInput;

/**
 * Created by leon on 10/24/17.
 * Yup, totally stole most of this from Leon, he makes good stuff.
 */

public abstract class Menu {

    private final Enum[] menuOptions;

    public Menu(Enum[] menuOptions) {
        this.menuOptions = menuOptions;
    }

    public PersonWarehouse personWarehouse = PersonWarehouse.getInstance();

    abstract public void selectOption(String userInput);

    public void display() {
        String userInput;
        do {
            userInput = this.getMenuInput().toUpperCase();
            try {
                selectOption(userInput);
            } catch (IllegalArgumentException iae) {
                handleIllegalArgumentException(userInput, iae);
            } catch (NullPointerException npe) {
                handleNullPointerException(npe);
            }
        } while (!"Home".equalsIgnoreCase(userInput));
    }

    protected void handleIllegalArgumentException(String illegalArgument, IllegalArgumentException iae) {
        handleException("[ %s ] is an invalid argument.", illegalArgument);
    }

    protected void handleNullPointerException(NullPointerException npe) {
        handleException("Unable to retrieve data with input value.");
    }

    private void handleException(String message, Object... args) {
        System.out.printf(message, args);
    }

    protected HrContactInfo inputAllContactInfo() {
        System.out.print("Enter name: ");
        String inputName = this.getUserInput();
        System.out.print("Enter address line 1: ");
        String inputAddressLine1 = this.getUserInput();
        System.out.print("Enter address line 2: ");
        String inputAddressLine2 = this.getUserInput();
        System.out.print("Enter city: ");
        String inputCity = this.getUserInput();
        System.out.print("Enter state: ");
        String inputState = this.getUserInput();
        System.out.print("Enter zip code: ");
        String inputZipCode = this.getUserInput();
        System.out.print("Enter phone number: ");
        String inputPhoneNumber = this.getUserInput();
        System.out.print("Enter email address: ");
        String inputEmailAddress = this.getUserInput();

        StreetAddress newStreetAddress = new StreetAddress(inputAddressLine1, inputAddressLine2, inputCity, inputState, inputZipCode);
        HrContactInfo newHrContactInfo = new HrContactInfo(inputName, newStreetAddress, inputPhoneNumber, inputEmailAddress);

        return newHrContactInfo;
    }

    public String getMenuInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("===== %s =====\n", getClass().getSimpleName());
        System.out.println("Type in your selection to proceed:");
        for (Enum e : menuOptions) {
            System.out.printf("[ %s ] ", e.name());
        }
        System.out.println();
        return scanner.nextLine();
    }

    public String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    protected Person getPersonByName(){
        Scanner in = new Scanner(System.in);
        Person match=null;
        do {
            System.out.println("Enter Name: ");
            String name = in.nextLine();
            ArrayList<Person> matchList = personWarehouse.getPersonByName(name);
            if (matchList.size()==0) {
                System.out.println("Invalid Name. Choices: \n");
                System.out.println(personWarehouse.getAllPeople());
            }
            else if (matchList.size()==1){
                match=matchList.get(0);
            }
            else
            {
                do {
                    System.out.println("Multiple matches for " + name + ". Choose ID from choices below:\n");
                    for (Person p : matchList) {
                        System.out.println(p.toString());
                    }
                    match = getPersonById();
                    if (!name.equalsIgnoreCase(match.getContactInfo().getName())) {
                        System.out.println("That ID doesn't match any person named " + name);
                    }
                }while (!name.equalsIgnoreCase(match.getContactInfo().getName()) );
            }

        }while (match==null);
        return match;

    }

    protected Person getPersonById(){
        Scanner in = new Scanner(System.in);
        Person match;
        do {
            System.out.println("Enter ID: ");
            String id = in.nextLine();
            match = personWarehouse.getPersonById(id);
            if (match == null) {
                System.out.println("Invalid ID. Choices: \n");
                System.out.println(personWarehouse.getAllPeople());
            }
        }while (match==null);
        return match;
    }

    protected Compensation changeCompensation() {
        System.out.println("Enter paid Monthly/Hourly/Project: ");
        Compensation.compensationType inputPayType = getEnforcedCompensationType();
        System.out.print("Enter salary: ");
        double inputSalary = getEnforcedPositiveDoubleInput();
        System.out.print("Enter bonus: ");
        double inputBonus = getEnforcedPositiveDoubleInput();
        System.out.print("Enter PTO for the year: ");
        double inputPTO = getEnforcedPositiveDoubleInput();
        System.out.print("Opt in to medical coverage? y/n: ");
        String inputMedical = getUserInput();
        System.out.print("Opt in to dental coverage? y/n: ");
        String inputDental = getUserInput();
        System.out.print("Opt in to vision coverage? y/n: ");
        String inputVision = getUserInput();
        System.out.print("Opt in to prescription coverage? y/n: ");
        String inputPrescription = getUserInput();
        System.out.print("Enter retirement match %: ");
        double inputRetirementMatch = getEnforcedPositiveDoubleInput();

        Compensation newCompensation = new Compensation();
        newCompensation.setTypeAndAmount(inputPayType, inputSalary);
        newCompensation.setBonus(inputBonus);
        newCompensation.setPtoMaxPerYear(inputPTO);
        if("y".equals(inputMedical)) {
            newCompensation.setMedical(true);
        }
        else {
            newCompensation.setMedical(false);
        }

        if("y".equals(inputDental)) {
            newCompensation.setDental(true);
        }
        else {
            newCompensation.setDental(false);
        }

        if("y".equals(inputVision)) {
            newCompensation.setVision(true);
        }
        else {
            newCompensation.setVision(false);
        }

        if("y".equals(inputPrescription)) {
            newCompensation.setPrescription(true);
        }
        else {
            newCompensation.setPrescription(false);
        }

        newCompensation.setRetirementMatching(inputRetirementMatch);
        return newCompensation;
    }
}


