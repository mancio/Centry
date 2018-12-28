package com.andreamancini;

import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

class Pad {

    //private Controller[] ca = ControllerEnvironment.getDefaultEnvironment().getControllers();


    Pad(){

    }

    void list() {

        Controller[] ca = ControllerEnvironment.getDefaultEnvironment().getControllers();

        for (int i = 0; i < ca.length; i++) {

            /* Get the name of the controller */
            System.out.println(ca[i].getName());

        }
    }




}
