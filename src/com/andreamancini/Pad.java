package com.andreamancini;

import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

import java.util.ArrayList;


class Pad {

    /*
        Controller.Type.STICK.toString() -> "Stick"
        Controller.Type.GAMEPAD.toString() -> "Gamepad"
        Controller.Type.WHEEL.toString() -> "Wheel"
        Controller.Type.RUDDER.toString() -> "Rudder"
        Controller.Type.MOUSE.toString() -> "Mouse"
    */

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

        int counter = 0;

        ArrayList<String> list = new ArrayList<>();

        for(String[] stt : st){

            switch (stt[1]) {
                case "Joystick":
                    list.add(stt[0] + " (Joystick)");
                    counter++;
                    break;
                case "Gamepad":
                    list.add(stt[0] + " (Gamepad)");
                    counter++;
                    break;
                case "Wheel":
                    list.add(stt[0] + " (Steering Wheel)");
                    counter++;
                    break;
                case "Rudder":
                    list.add(stt[0] + " (Rudder)");
                    counter++;
                    break;
                case "Mouse":
                    list.add(stt[0] + " (Mouse)");
                    counter++;
                    break;
            }
        }

        if(counter == 0){
            list.add("Device not found");
        }



        return list.toArray(new String[0]);

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







