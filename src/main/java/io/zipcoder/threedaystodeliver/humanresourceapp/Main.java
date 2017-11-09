package io.zipcoder.threedaystodeliver.humanresourceapp;

import io.zipcoder.threedaystodeliver.humanresourceapp.Utils.RandomUtilsHR;
import io.zipcoder.threedaystodeliver.humanresourceapp.menus.MainMenu;

public class Main {


    public static void main(String[] args) {

        //create x random users
        for (int i = 0; i < 25; i++) {
            RandomUtilsHR.createPerson();
        }

        while (true) {
            MainMenu.INSTANCE.display();
        }
    }
}
