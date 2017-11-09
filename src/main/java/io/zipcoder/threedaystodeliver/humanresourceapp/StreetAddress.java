package io.zipcoder.threedaystodeliver.humanresourceapp;

public class StreetAddress{

  String addressLine1 = "";
  String addressLine2 = "";
  String city = "";
  String state = "";
  String zip = "";//String to account for possible non-numerical postal codes
  
  public StreetAddress(){
  }
  
  public StreetAddress(String addressLine1,
                       String addressLine2,
                       String city,
                       String state,
                       String zip){
    this.addressLine1=addressLine1;
    this.addressLine2=addressLine2;
    this.city=city;
    this.state=state;
    this.zip=zip;
  }

  @Override
  public String toString(){
    String returnMe = "Address:\n" + addressLine1 + "\n" +
                           addressLine2 + "\n" +
                           city + ", " + state +", " + zip + "\n\n";
    return returnMe;
  }

  public void changeStreetAddress( String addressLine1,
                   String addressLine2,
                   String city,
                   String state,
                   String zip){
      this.addressLine1 = addressLine1;
      this.addressLine2 = addressLine2;
      this.city = city;
      this.state = state;
      this.zip = zip;
  }

  public String getAddressLine1(){
    return addressLine1;
  }

  public String getAddressLine2(){
    return addressLine2;
  }

  public String getCity(){
    return city;
  }

  public String getState(){
    return state;
  }

  public String getZip(){
    return zip;
  }

}
