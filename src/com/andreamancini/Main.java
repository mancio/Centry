package com.andreamancini;



public class Main {

    private static String appname = "Centry";
    private static int height = 400;
    private static int width = 400;


    public static void main(String[] args) {

        Gui g = new Gui(appname, height, width);


        Pad p = new Pad();

        String[][] st = p.listAll();

        String[] sj = p.listJoy(st);

        p.lprint(st);

        p.lprint(sj);




    }
}