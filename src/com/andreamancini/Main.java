package com.andreamancini;



public class Main {



    private static String appname = "Centry";
    private static int height = 300;
    private static int width = 300;

    private static int min_bar = 0;
    private static int max_bar = 1000;


    public static void main(String[] args) {



        Pad p = new Pad();

        String[][] st = p.listAll();

        String[] sj = p.listJoy(st);

        p.lprint(st);

        p.lprint(sj, "playing device");

        Gui g = new Gui(appname, height, width);

        g.build(sj);

        while (true) {

            int devnum = p.dev_finder(g.name_finder());

            if(devnum != -1) {

                float[] devals = p.readAx(devnum);

                int[] i = p.mapper(devals, min_bar, max_bar);

                //p.lprint(i);

                g.setbar(i, min_bar, max_bar);

            }else{

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
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }






    }
}