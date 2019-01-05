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


import java.io.File;

public class Main {


    // application name (on the top bar)
    private static String appname = "Centry";

    // icon dimensions
    private static int height = 250;
    private static int width = 300;

    // slide bar dimension
    private static int min_bar = 0;
    private static int max_bar = 1000;

    // run inside intellij or "build" = execute final compiled jar.
    private static String state = "build";


    public static void main(String[] args) {

        // try and catch only if you want build the final executable .jar
        if(!state.equals("build")) {
            try {

                // get the path where the jar is executed
                String f = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();

                // remove the .jar filename from the path to have Disk\my\folder\dllfiles\
                String path = f.replace("\\Centry.jar", "");

                System.out.println(path);

                // set the .jar folder where is executed as input library
                System.setProperty("net.java.games.input.librarypath", path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // input device class
        Pad p = new Pad();

        // retrieve all the device dev name, dev type
        String[][] st = p.listAll();

        // ex: 1: Arduino (Joystick)
        String[] sj = p.listJoy(st);

        /* print device list
        ex:
        HID Keyboard Device | Keyboard
        HID-compliant mouse | Mouse
        HID-compliant mouse | Mouse
        Dell KB216 Wired Keyboard | Unknown
        Dell KB216 Wired Keyboard | Unknown
        */
        p.lprint(st);

        // ex. playing device is: Device not found
        p.lprint(sj, "playing device");

        // graphic builder class
        Gui g = new Gui(appname, width, height);

        // generate icon, texts and slides
        g.build(sj);

        while (true) {

            /* find the array position in Controller ca of the device selected
               in the list
               if the device is not a Stick, Gamepad, Wheel or Rudder return -1
             */
            int devnum = p.dev_finder(g.name_finder());

            if(devnum != -1) {

                // store axis analog value
                float[] devals = p.readAx(devnum);

                // map the value from scale -1.0f -> 1.0f to min_bar -> max_bar
                int[] i = p.mapper(devals, min_bar, max_bar);

                // print all the axis in loop (for testing)
                //p.lprint(i);

                // update slide bars
                g.setbar(i, min_bar, max_bar);

            }else{

                // hide slides and show error message
                g.nojoy();

                try {
                    Thread.sleep(5000);
                    System.exit(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.exit(1);
                }

            }



            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }






    }
}