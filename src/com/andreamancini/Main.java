package com.andreamancini;



public class Main {

    private static String appname = "Centry";
    private static int height = 300;
    private static int width = 300;

    private static int min_bar = 0;
    private static int max_bar = 500;


    public static void main(String[] args) {

        Pad p = new Pad();

        String[][] st = p.listAll();

        String[] sj = p.listJoy(st);

        p.lprint(st);

        p.lprint(sj, "playing device");

        Gui g = new Gui(appname, height, width);

        g.build(sj);

        while (true) {

            float[] devals = p.readAx(13);

            int[] i = p.mapper(devals,min_bar,max_bar);

            p.lprint(i);

            g.setbar(i,min_bar,max_bar);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }






    }
}