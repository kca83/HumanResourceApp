package io.zipcoder.threedaystodeliver.humanresourceapp.menus;

import io.zipcoder.threedaystodeliver.humanresourceapp.Person;

import java.util.ArrayList;

public class ReportingMenu extends Menu{

    enum ReportingSelectionOptions {ALL, PROSPECT, EMPLOYEE, HOME, EXIT}

    public static final ReportingMenu INSTANCE = new ReportingMenu();

    private ReportingMenu(){
        super(ReportingSelectionOptions.values());
    }

    @Override
    public void selectOption(String userInput) {
        switch (ReportingSelectionOptions.valueOf(userInput)){
            case PROSPECT:
                printAllProspects();
                break;
            case EMPLOYEE:
                printAllEmployees();
                break;
            case ALL:
                printAllEmployees();
                System.out.println();
                printAllProspects();
                break;
            case HOME:
                return;
            case EXIT:
                System.exit(0);
                return;
        }
    }

    public void printAllProspects() {
        ArrayList<Person> allProspects = personWarehouse.getAllProspects();

        if(allProspects.size() > 0) {
            System.out.println("PROSPECTS:");
            String report = Person.printProspectReportHeader();
            for (Person prospect : allProspects) {
                report += "\n" + prospect.printProspectForReport();
            }

            System.out.println(report);
        }
        else {
            System.out.println("No prospects available to report");
        }
    }

    public void printAllEmployees() {
        ArrayList<Person> allEmployees = personWarehouse.getAllEmployees();

        if(allEmployees.size() > 0) {
            System.out.println("EMPLOYEES:");
            String report = Person.printEmployeeReportHeader();
            for (Person prospect : allEmployees) {
                report += "\n" + prospect.printEmployeeForReport();
            }

            System.out.println(report);
        }
        else {
            System.out.println("No employees available to report");
        }
    }
}
