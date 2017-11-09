package io.zipcoder.threedaystodeliver.humanresourceapp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static io.zipcoder.threedaystodeliver.humanresourceapp.EmploymentStatus.EMPLOYEE;
import static io.zipcoder.threedaystodeliver.humanresourceapp.EmploymentStatus.PROSPECT;
import static io.zipcoder.threedaystodeliver.humanresourceapp.EmploymentStatus.TERMINATED;

public class PersonWarehouseTest {

    PersonWarehouse personWarehouse;
    
    @Before
    public void setUp(){
        personWarehouse = PersonWarehouse.getInstance();
    }
    
    @Test
    public void addPersonTest() {
        Person testPerson = new Person();
        
        testPerson.setEmploymentStatus(EmploymentStatus.EMPLOYEE);
        int initialSize = personWarehouse.getAllPeople().size();
        personWarehouse.addPerson(testPerson);
        Assert.assertEquals(initialSize + 1, personWarehouse.getAllPeople().size());

    }

    @Test
    public void getPersonByNameTest() {
        Person testPerson1 = new Person();
        Person testPerson2 = new Person();
        personWarehouse.addPerson(testPerson1);
        personWarehouse.addPerson(testPerson2);
        testPerson1.setEmploymentStatus(EMPLOYEE);
        testPerson2.setEmploymentStatus(PROSPECT);
        testPerson1.getContactInfo().setName("testName");
        testPerson2.getContactInfo().setName("testName");

        ArrayList<Person> testArrayList = new ArrayList<>(2);
        testArrayList.add(testPerson1);
        testArrayList.add(testPerson2);

        Assert.assertArrayEquals(testArrayList.toArray(), personWarehouse.getPersonByName("testName").toArray());
    }

    @Test
    public void getPersonByIdTest(){
        Person testPerson1 = new Person();
        testPerson1.setEmploymentStatus(TERMINATED);
        personWarehouse.addPerson(testPerson1);
        testPerson1.setId("4815162342");
        Assert.assertEquals(testPerson1, personWarehouse.getPersonById("4815162342"));


    }

    @Test
    public void getAllProspects(){
        int initialAllProspectsCount = personWarehouse.getAllProspects().size();

        for(int i =0; i < 5; i++){
            Person testPerson = new Person();
            testPerson.setEmploymentStatus(PROSPECT);
            personWarehouse.addPerson(testPerson);
        }

        Assert.assertEquals(initialAllProspectsCount+5, personWarehouse.getAllProspects().size());

    }

    @Test
    public void getAllEmployees(){
        int initialAllEmployeesCount = personWarehouse.getAllEmployees().size();

        for(int i =0; i < 50; i++){
            Person testPerson = new Person();
            testPerson.setEmploymentStatus(EMPLOYEE);
            personWarehouse.addPerson(testPerson);
        }

        Assert.assertEquals(initialAllEmployeesCount+50, personWarehouse.getAllEmployees().size());

    }

    @Test
    public void getAllFormerEmployees(){
        int initialAllFormerCount = personWarehouse.getAllFormerEmployees().size();

        for(int i =0; i < 255; i++){
            Person testPerson = new Person();
            testPerson.setEmploymentStatus(TERMINATED);
            personWarehouse.addPerson(testPerson);
        }

        Assert.assertEquals(initialAllFormerCount+255, personWarehouse.getAllFormerEmployees().size());

    }

}
