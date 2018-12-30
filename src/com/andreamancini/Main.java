package com.andreamancini;



public class Main {

    private static String appname = "Centry";
    private static int height = 300;
    private static int width = 300;


    public static void main(String[] args) {

        Pad p = new Pad();

        String[][] st = p.listAll();

        String[] sj = p.listJoy(st);

        p.lprint(st);

        p.lprint(sj, "playing device");


        float[] devals = p.readAx(1);

        p.lprint(devals);


        Gui g = new Gui(appname, height, width);

        g.build(sj);



    }
}