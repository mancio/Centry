package com.andreamancini;

import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

import java.util.ArrayList;


class Pad {


    private Controller[] ca = ControllerEnvironment.getDefaultEnvironment().getControllers();

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
                case "Stick":
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
                /*
                case "Mouse":
                    list.add(stt[0] + " (Mouse)");
                    counter++;
                    break;
                 */
            }
        }

        if(counter == 0){
            list.add("Device not found");
        }



        return list.toArray(new String[0]);

    }




    float[] readAx(int devnum){

        float[] valAx = {0, 0, 0};

        if(ca[devnum-1].getComponent(Component.Identifier.Axis.X) != null) {

            valAx[0] = ca[devnum - 1].getComponent(Component.Identifier.Button._1).getPollData();
        }else {
            valAx[0] = -2;
        }

        if(ca[devnum-1].getComponent(Component.Identifier.Axis.Y) != null) {

            valAx[1] = ca[devnum - 1].getComponent(Component.Identifier.Button._1).getPollData();

        }else{
            valAx[1] = -2;
        }

        if(ca[devnum-1].getComponent(Component.Identifier.Axis.Z) != null) {

            valAx[2] = ca[devnum - 1].getComponent(Component.Identifier.Button._1).getPollData();
        }else {
            valAx[2] = -2;
        }



        return valAx;

    }



    void lprint(String[][] st){

        System.out.println("-----------------");
        System.out.println("Device list");
        System.out.println(" ");

        for (String[] strings : st) {

           System.out.println(strings[0] + " | " + strings[1]);

        }



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

    void lprint(float[] val){

        String[] nameax = {"X","Y","Z"};

        int con = 0;

        for (float ax: val) {

            if(ax == -2){

                System.out.println("Joystick axis " + nameax[con] + ": NOT FOUND");

            }else {

                System.out.print("Joystick axis " + nameax[con] + ": " + ax);
            }

           con++;

        }


    }



}







