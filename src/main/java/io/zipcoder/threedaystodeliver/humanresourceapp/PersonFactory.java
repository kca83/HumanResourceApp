package io.zipcoder.threedaystodeliver.humanresourceapp;

import io.zipcoder.threedaystodeliver.humanresourceapp.exceptions.NoMorePersonIDException;

public class PersonFactory {

    private static int iteratedPersonID = 0;
    private static final int PERSON_ID_LENGTH = 5;

    static String nextPersonID() throws NoMorePersonIDException {
        if((""+iteratedPersonID).length() <= PERSON_ID_LENGTH) {
            return String.format("%0"+PERSON_ID_LENGTH+"d", iteratedPersonID++);
        } else { throw new NoMorePersonIDException(); }
    }

    public static String getNextPersonID(){
        return String.format("%0"+PERSON_ID_LENGTH+"d", iteratedPersonID);
    }

    public static void setIteratedPersonID(int newID){
        iteratedPersonID = newID;
    }

    public int getPersonIdLength(){
        return PERSON_ID_LENGTH;
    }

    public static Person createPerson(HrContactInfo hrContactInfo){
        Person person = new Person();
        person.setContactInfo(hrContactInfo);
        try {
            person.setId(nextPersonID());
        } catch (NoMorePersonIDException e) {
        }
        PersonWarehouse.getInstance().addPerson(person);

        return person;
    }

}
