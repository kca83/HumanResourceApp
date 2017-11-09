package io.zipcoder.threedaystodeliver.humanresourceapp;

import java.util.ArrayList;

public class PersonWarehouse {

    private static PersonWarehouse INSTANCE = null;

    private static ArrayList<Person> people = new ArrayList<>();

   private PersonWarehouse(){}

    public static PersonWarehouse getInstance(){
        if(INSTANCE == null){
            INSTANCE = new PersonWarehouse();
            return INSTANCE;
        } else {
            return INSTANCE;
        }
    }

    public void addPerson(Person person){
        people.add(person);
    }

    public ArrayList<Person> getAllFormerEmployees() {
        ArrayList<Person> listOfFormerEmployees = new ArrayList<>(3);
        for (Person person : people) {
            if (EmploymentStatus.TERMINATED.equals(person.getEmploymentStatus())){
                listOfFormerEmployees.add(person);
            }
        }return listOfFormerEmployees;
    }

    public ArrayList<Person> getAllEmployees() {
        ArrayList<Person> listOfAllEmployees = new ArrayList<>(100);
        for (Person person : people) {
            if (EmploymentStatus.EMPLOYEE.equals(person.getEmploymentStatus())) {
                listOfAllEmployees.add(person);
            }
        }
        return listOfAllEmployees;
    }

    public ArrayList<Person> getAllProspects() {
        ArrayList<Person> listOfProspects = new ArrayList<>(100);
        for (Person person : people) {
            if (EmploymentStatus.PROSPECT.equals(person.getEmploymentStatus())) {
                listOfProspects.add(person);
            }
        }
        return listOfProspects;
    }

    public Person getPersonById(String id){
        for(Person person: people) {
            if(person.getId().equals(id))
                return person;
        }

        return null;
    }

    public ArrayList<Person> getAllPeople() {
        return people;
    }

    public ArrayList<Person> getPersonByName(String name){
        ArrayList<Person> listOfMatchedNames = new ArrayList<>(10);
        for(Person person: people) {
            if(person.getContactInfo().getName().equals(name)) {
                listOfMatchedNames.add(person);
            }
        }
        return listOfMatchedNames;
    }
}
