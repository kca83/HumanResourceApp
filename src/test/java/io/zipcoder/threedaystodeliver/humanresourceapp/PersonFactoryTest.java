package io.zipcoder.threedaystodeliver.humanresourceapp;

import io.zipcoder.threedaystodeliver.humanresourceapp.exceptions.NoMorePersonIDException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonFactoryTest {

    public static Person createBob(){
        String name = "Uncle Bob";
        StreetAddress address = new StreetAddress();
        String phone = "123-456-7890";
        String email = "cleancode@forever.com";

        HrContactInfo info = new HrContactInfo(name, address, phone, email);

        return PersonFactory.createPerson(info);
    }

    Person person;

    @Before
    public void setUp(){
        PersonFactory.setIteratedPersonID(0);
        person = createBob();
    }

    @Test(expected = NoMorePersonIDException.class)
    public void noMorePersonIDsTest() throws NoMorePersonIDException {
        PersonFactory.setIteratedPersonID(100000);
        String nextID = PersonFactory.nextPersonID();
    }

    @Test
    public void setAndGetPersonIDTestShouldBe7(){
        person.setId("00007");
        String expectedID = "00007";
        String actualID = person.getId();
        Assert.assertEquals(expectedID, actualID);
    }

    @Test
    public void iteratingIDTest() throws NoMorePersonIDException {
        int iterations = 4;
        for (int i = 0; i < iterations; i++) {
            createBob();
        }
        String expected = "00005"; //+1 from @Before

        Assert.assertEquals(expected, PersonFactory.getNextPersonID());
    }

    @Test
    public void createPersonHRinfoTest(){
        Assert.assertEquals("Uncle Bob", person.getContactInfo().getName());
        Assert.assertEquals("123-456-7890", person.getContactInfo().getPhone());
        Assert.assertEquals("cleancode@forever.com", person.getContactInfo().getEmail());
    }


}
