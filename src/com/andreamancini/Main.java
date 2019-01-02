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

        Gui g = new Gui(appname, height, width);

        g.build(sj);

        while (true) {

            float[] devals = p.readAx(13);

            int[] i = p.mapper(devals,0,100);

            p.lprint(i);

            g.setbar(i);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }






    }
}