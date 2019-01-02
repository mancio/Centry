package com.andreamancini;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

class Gui {

    private String appn;
    private int width;
    private int height;

    private JFrame f= new JFrame(appn);//creating instance of JFrame
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;

    private JProgressBar jb1=new JProgressBar(0,100);
    private JProgressBar jb2=new JProgressBar(0,100);
    private JProgressBar jb3=new JProgressBar(0,100);

    Gui(String ap, int l, int h){
        this.appn = ap;
        this.width = l;
        this.height = h;




    }



    private void makeFrame(JMenuBar men){


        //JPanel pan = new JPanel();

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setAlwaysOnTop(true);

        f.setSize(width,height);


        f.setJMenuBar(men);

        Container pane = f.getContentPane();
        Insets insets = pane.getInsets();


        JLabel l1=new JLabel("Joystick Axes position");
        Dimension size = l1.getPreferredSize();
        l1.setBounds(width/4 + insets.left, 5 + insets.top,
                size.width, size.height);

        JLabel l2=new JLabel("Axis X");
        size = l2.getPreferredSize();
        l2.setBounds(10 + insets.left, 50 + insets.top,
                size.width, size.height);

        JLabel l3=new JLabel("Axis Y");
        size = l3.getPreferredSize();
        l3.setBounds(10 + insets.left, 55 + 50 + insets.top,
                size.width, size.height);

        JLabel l4=new JLabel("Axis Z");
        size = l4.getPreferredSize();
        l4.setBounds(10 + insets.left, 55 + 50*2 + insets.top,
                size.width, size.height);

        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);


        slide(insets,size);



        f.setLayout (null);
        f.setVisible(true);//making the frame visible

    }

    private void makeMenu(String[] dev){



        //Create the menu bar.
        menuBar = new JMenuBar();

        //Build the first menu.
        menu = new JMenu("Devices");
        menu.setMnemonic(KeyEvent.VK_D);
        menu.getAccessibleContext().setAccessibleDescription(
                "Select your Joystick");
        menuBar.add(menu);

        makeItMen(dev);



    }


    private void makeItMen(String[] dev) {



        for(String string : dev) {

            menuItem = new JMenuItem(string, KeyEvent.VK_J);

            menuItem.getAccessibleContext().setAccessibleDescription(
                    "Is this your Joystick?");
            menu.add(menuItem);
        }



    }

    private void slide(Insets ins, Dimension size){

        jb1.setBounds(width/4 + ins.left, 55 + ins.top,
                size.width *5, size.height);
        jb1.setValue(50);
        jb1.setStringPainted(true);


        jb2.setBounds(width/4 + ins.left, 55 + 50 + ins.top,
                size.width *5, size.height);
        jb2.setValue(50);
        jb2.setStringPainted(true);


        jb3.setBounds(width/4 + ins.left, 55 + 50*2 + ins.top,
                size.width *5, size.height);
        jb3.setValue(50);
        jb3.setStringPainted(true);



        f.add(jb1);
        f.add(jb2);
        f.add(jb3);
    }


    void setbar(int[] n){

        jb1.setValue(n[0]);
        jb2.setValue(n[1]);
        jb3.setValue(n[2]);

    }





    void build(String[] dev){
        makeMenu(dev);
        makeFrame(menuBar);
    }


}
