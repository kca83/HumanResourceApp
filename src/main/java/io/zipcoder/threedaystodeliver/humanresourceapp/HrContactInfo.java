package io.zipcoder.threedaystodeliver.humanresourceapp;

public class HrContactInfo {

    String name = "";
    StreetAddress streetAddress = new StreetAddress();
    String phone = "";
    String email = "";

    public HrContactInfo() {

    }

    public HrContactInfo(String name,
                         StreetAddress streetAddress,
                         String phone,
                         String email) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return ("Name: "+name + "\n" +"Phone: "+ phone + "\n" +"Email: "+ email + "\n" + streetAddress.toString());
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStreetAddress(StreetAddress streetAddress) {
        this.streetAddress = streetAddress;
    }

    public StreetAddress getStreetAddress() {
        return streetAddress;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

}
