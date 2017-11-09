package io.zipcoder.threedaystodeliver.humanresourceapp;
/*
import io.zipcoder.threedaystodeliver.humanresourceapp.exceptions.NotAnEmployeeException;
import org.junit.Assert;
import org.junit.Test;
import sun.util.calendar.CalendarDate;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class PersonHandlerTest {

    String name = "Uncle Bob";
    StreetAddress address = new StreetAddress();
    String phone = "123-456-7890";
    String email = "cleancode@forever.com";

    HrContactInfo info = new HrContactInfo(name, address, phone, email);

    @Test
    public void createProspectTypeShouldBeProspectTest(){
        Person prospect = PersonHandler.createProspect(info);
        Assert.assertEquals( EmploymentStatus.PROSPECT, prospect.getEmploymentStatus());
    }

    @Test
    public void createProspectAddToWarehouseTest(){
        PersonWarehouse personWarehouse = PersonWarehouse.getInstance();
        int beforeCount = personWarehouse.getAllPeople().size();
        int expected = 5;

        for (int i = 0; i < 5; i++) {
            Person person = PersonHandler.createProspect(info);
        }

        int afterCount = personWarehouse.getAllPeople().size();
        int actual = afterCount - beforeCount;

        Assert.assertEquals(expected, actual);
    }

//    Change prospects status during interview stage ->
//    enter information into console
//    infomation updates in person object
////
//    @Test
//    public void


//    Hire employee from prospect ->
//    enter information into console
//    populate employee fields (start date, salary, etc.)
//

    @Test
    public void hireProspectChangeTypeTest(){
        Person prospect = PersonHandler.createProspect(info);
        Person employee = PersonHandler.hire(prospect, LocalDate.now(), "", new Compensation());

        Assert.assertEquals(EmploymentStatus.EMPLOYEE, employee.getEmploymentStatus());
    }

    @Test
    public void hireProspectHasDateTest(){
        Person prospect = PersonHandler.createProspect(info);
       LocalDate date = LocalDate.now();
        Person employee = PersonHandler.hire(prospect, date, "", new Compensation());

        Assert.assertEquals(date, employee.getHiredDate());
    }

    @Test
    public void hireProspectHasCompensationTest(){
        Person prospect = PersonHandler.createProspect(info);
        Compensation compensation = new Compensation();
        compensation.setTypeAndAmount(Compensation.compensationType.Monthly, 2.50);
        Person employee = PersonHandler.hire(prospect, LocalDate.now(), "", compensation);

        Assert.assertEquals(Compensation.compensationType.Monthly, employee.getCompensation().getCompensationType());
        Assert.assertEquals(2.50, employee.getCompensation().getPayrate(), 0.001);
    }

    @Test
    public void hireProspectHasTitleTest(){
        String title = "Smooth Operator";
        Person prospect = PersonHandler.createProspect(info);
        Person employee = PersonHandler.hire(prospect, LocalDate.now(), title, new Compensation());

        Assert.assertEquals(title, employee.getTitle());
    }

    //
//    Hire employee from new ->
//    enter information into console
//    create person with entered contact info,
//    add person to warehouse,
//    verify person is in the warehouse
//    information is populated into person
//



//    Terminate employee ->
//    enter information into console
//    populate former employee fields,
//    remove from current employee lists
//


    @Test
    public void terminateEmployeeTypeTest(){
        Person employee = PersonHandler.hire(LocalDate.now(), "", new Compensation());
        Person formerEmployee = PersonHandler.terminate(employee, LocalDate.now(), "", "", new Compensation());

        Assert.assertEquals(EmploymentStatus.TERMINATED, formerEmployee.getEmploymentStatus());
    }

    @Test
    public void terminateEmployeePayRateIsNullTest(){
        Person employee = PersonHandler.hire(LocalDate.now(), "", new Compensation());
        Person formerEmployee = PersonHandler.terminate(employee, LocalDate.now(), "", "", new Compensation());

        Assert.assertNull(formerEmployee.getCompensation());
    }

    @Test
    public void terminatedEmployeeHasExitInterviewTest(){
        String exit = "TERMINATED";
        Person employee = PersonHandler.hire(LocalDate.now(), "", new Compensation());
        Person formerEmployee = PersonHandler.terminate(employee, LocalDate.now(), "", exit, new Compensation());

        Assert.assertTrue(exit.equals(formerEmployee.getExitInterview()));
    }


    @Test
    public void terminatedEmployeeHasTermDateTest(){
       LocalDate date = LocalDate.now();
        Person employee = PersonHandler.hire(LocalDate.of(1, 1,1 ), "", new Compensation());
        Person formerEmployee = PersonHandler.terminate(employee, date, "", "", new Compensation());

        Assert.assertEquals(date, employee.getTerminationDate());
    }

    @Test
    public void terminatedEmployeeHasReasonForTermination(){
        String reason = "code wasn't clean";

        Person employee = PersonHandler.hire(LocalDate.now(), "", new Compensation());
        Person formerEmployee = PersonHandler.terminate(employee, LocalDate.now(), reason, "", new Compensation());

        Assert.assertEquals(reason, employee.getReasonForTermination());
    }


//    change position employee ->
//    enter information into console
//    update job title, compensation

    @Test(expected = NotAnEmployeeException.class)
    public void changePositionNotEmployeeTest() throws NotAnEmployeeException {
        Person prospect = PersonHandler.createProspect(info);
        PersonHandler.changePosition(prospect, "The Boss", 2.50, 3.00, 1);
    }

    @Test
    public void changePositionTitleTest() throws NotAnEmployeeException {
        String title = "Clean Coder";

        Person employee = PersonHandler.hire(info, LocalDate.now(), "", new Compensation());
        PersonHandler.changePosition(employee, title, 5d, 3d, 2d);

        Assert.assertEquals(title, employee.getTitle());
    }

    @Test
    public void changePositionCompensationTest() throws NotAnEmployeeException {
        double newPayRate = 10d;
        double newBonus = 15d;
        double newPTO = 30d;
        
        Person employee = PersonHandler.hire(LocalDate.now(), "", new Compensation());
        PersonHandler.changePosition(employee, "Clean Coder", newPayRate, newBonus, newPTO);

        Assert.assertEquals(newPayRate, employee.getCompensation().getPayrate(), 0.001);
        Assert.assertEquals(newBonus, employee.getCompensation().getBonus(), 0.001);
        Assert.assertEquals(newPTO, employee.getCompensation().getPtoMaxPerYear(), 0.001);
    }
    


}
*/