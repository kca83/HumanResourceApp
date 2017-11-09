package io.zipcoder.threedaystodeliver.humanresourceapp;

import org.junit.Assert;
import org.junit.Test;

public class HrContactInfoTest {

    @Test
    public void setNameTest() {
        HrContactInfo hrContactInfo = new HrContactInfo();
        hrContactInfo.setName("Katherine");
        Assert.assertEquals("Katherine", hrContactInfo.getName());
    }

    @Test
    public void setStreetAddressTest() {
        StreetAddress streetAddress = new StreetAddress("Line 1",
        "Line 2", "City", "STATE", "19801");
        HrContactInfo hrContactInfo = new HrContactInfo();
        hrContactInfo.setStreetAddress(streetAddress);
        Assert.assertEquals(streetAddress, hrContactInfo.getStreetAddress());
    }

    @Test
    public void setPhone(){
        HrContactInfo hrContactInfo = new HrContactInfo();
        hrContactInfo.setPhone("830973246");
        Assert.assertEquals("830973246", hrContactInfo.getPhone());

    }

    @Test
    public void setEmail(){
        HrContactInfo hrContactInfo = new HrContactInfo();
        hrContactInfo.setEmail("kajshlfaskj@kjbs.com");
        Assert.assertEquals("kajshlfaskj@kjbs.com", hrContactInfo.getEmail());
    }
}
