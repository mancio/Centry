package com.andreamancini;

import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

import java.util.Arrays;
import java.util.Objects;

class Pad {

    //private Controller[] ca = ControllerEnvironment.getDefaultEnvironment().getControllers();


    Pad() {

    }

    
    
    /* array of 2 el arrays 
        |0| -> | name device | type |
        |1| -> | name device | type |
        |2| -> | name device | type |
        ...
     */
    String[][] listAll() {

        Controller[] ca = ControllerEnvironment.getDefaultEnvironment().getControllers();

        String[][] st = new String[ca.length][2];

        for (int i = 0; i < ca.length; i++) {

            /* Get the name of the controller */

            st[i][0] = ca[i].getName();
            st[i][1] = ca[i].getType().toString();


        }

        return st;
    }

    String[] listJoy(String[][] st){
        


        String[] list = new String[st.length];

        for (int i = 0; i < st.length; i++){

            if(st[i][1].equals(Controller.Type.STICK.toString())) {

                list[i] = st[i][1];

            }

        }

        return Arrays.stream(list).filter(Objects::nonNull).toArray(String[]::new);

    }

    void lprint(String[][] st){

        for (String[] strings : st) {

            System.out.println(strings[0] + " | " + strings[1]);

        }

    }

    void lprint(String[] st){

        for (String s : st) {

            System.out.println(s);

        }

    }



}







