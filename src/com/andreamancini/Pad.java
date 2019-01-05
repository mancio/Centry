/*
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.

    Written by Andrea Mancini
 */



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

        int counter = 1;

        ArrayList<String> list = new ArrayList<>();

        for(String[] stt : st){

            switch (stt[1]) {
                case "Stick":
                    list.add(counter + ": " + stt[0] + " (Joystick)");
                    counter++;
                    break;
                case "Gamepad":
                    list.add(counter + ": " + stt[0] + " (Gamepad)");
                    counter++;
                    break;
                case "Wheel":
                    list.add(counter + ": " + stt[0] + " (Steering Wheel)");
                    counter++;
                    break;
                case "Rudder":
                    list.add(counter + ": " +  stt[0] + " (Rudder)");
                    counter++;
                    break;
                /*
                case "Mouse":
                    list.add(counter + ": " +  stt[0] + " (Mouse)");
                    counter++;
                    break;
                */
            }




        }

        if(counter == 1){
            list.add("Device not found");
        }



        return list.toArray(new String[0]);

    }


    int dev_finder(String s){


        for (int i = 0; i < ca.length; i++) {

            /* Get the name of the controller */

            if(s.contains(ca[i].getName())){

                return i;

            }




        }

        return -1;

    }




    float[] readAx(int devnum){

        //poll the data from the Joystick selected (required before getPollData())
        ca[devnum].poll();

        float[] valAx = {0, 0, 0};

        if(ca[devnum].getComponent(Component.Identifier.Axis.X) != null) {

            valAx[0] = ca[devnum].getComponent(Component.Identifier.Axis.X).getPollData();
        }else {
            valAx[0] = -2;
        }

        if(ca[devnum].getComponent(Component.Identifier.Axis.Y) != null) {

            valAx[1] = ca[devnum].getComponent(Component.Identifier.Axis.Y).getPollData();

        }else{
            valAx[1] = -2;
        }

        if(ca[devnum].getComponent(Component.Identifier.Axis.Z) != null) {

            valAx[2] = ca[devnum].getComponent(Component.Identifier.Axis.Z).getPollData();
        }else {
            valAx[2] = -2;
        }



        return valAx;

    }

    int mapper(float x, int out_min, int out_max){

       return (int)((x - (-1.0f)) * (out_max - out_min) / (1.0f - (-1.0f)) + out_min);


    }

    int[] mapper(float[] x, int out_min, int out_max){

        int[] vals = new int[3];

        for (int i = 0; i<x.length; i++) {

            vals[i] = (int)((x[i] - (-1.0f)) * (out_max - out_min) / (1.0f - (-1.0f)) + out_min);

        }

        return vals;

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

                System.out.println("Joystick axis " + nameax[con] + ": " + ax);
            }

           con++;

        }


    }

    void lprint(int[] val){

        String[] nameax = {"X","Y","Z"};

        int con = 0;

        for (float ax: val) {

            if(ax == -2){

                System.out.println("Joystick axis " + nameax[con] + ": NOT FOUND");

            }else {

                System.out.println("Joystick axis " + nameax[con] + ": " + ax);
            }

            con++;

        }


    }





}







