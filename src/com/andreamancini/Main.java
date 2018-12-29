package com.andreamancini;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Gui g = new Gui();

        g.makeFrame();

        Pad p = new Pad();

        String[][] st = p.listAll();

        String[] sj = p.listJoy(st);

        p.lprint(st);

        p.lprint(sj);




    }
}