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

        return Arrays.stream(st).filter(Objects::nonNull).toArray(String[]::new);


    }

    String[] listJoy(String[][] st){
        


        String[][] list = st.clone();

        for (int i = 0; i < list.length; i++){

            if(!st[i][1].equals(Controller.Type.STICK.toString())) {

                list[i][0] = null;
                list[i][1] = null;

            }

        }

        return Arrays.stream(list).filter(Objects::nonNull).toArray(String[]::new);

    }

    void lprint(String[][] st){

        System.out.println("-----------------");
        System.out.println(" ");

        for (String[] strings : st) {

           System.out.println(strings[0] + " | " + strings[1]);

        }

        System.out.println("-----------------");
        System.out.println(" ");

    }

    void lprint(String[] st, String dev){

        System.out.println("-----------------");
        System.out.println(" ");

        for (String s : st) {

            System.out.println(dev + " is: " + s);

        }

        System.out.println("-----------------");
        System.out.println(" ");

    }



}







