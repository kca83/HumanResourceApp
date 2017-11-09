package io.zipcoder.threedaystodeliver.humanresourceapp.menus;

public class MainMenu extends Menu{

    enum MainSelectionOptions {PROSPECT, EMPLOYEE, REPORTING, EXIT}

    public static final MainMenu INSTANCE = new MainMenu();

    private MainMenu(){
        super(MainSelectionOptions.values());
    }

    @Override
    public void selectOption(String userInput) {
        switch (MainSelectionOptions.valueOf(userInput)){
            case PROSPECT:
                prospectMenu();
                break;
            case EMPLOYEE:
                employeeMenu();
                break;
            case REPORTING:
                reportingMenu();
                break;
            case EXIT:
                System.exit(0);
                return;
        }
    }

    private void prospectMenu() {
        ProspectMenu prospectMenu = ProspectMenu.INSTANCE;
        prospectMenu.display();
    }

    private void employeeMenu() {
        EmployeeMenu employeeMenu = EmployeeMenu.INSTANCE;
        employeeMenu.display();
    }

    private void reportingMenu() {
        ReportingMenu reportingMenu = ReportingMenu.INSTANCE;
        reportingMenu.display();
    }
}
