package com.andreamancini;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

class Gui {

    private String appn;
    private int width;
    private int height;



    Gui(String ap, int l, int h){
        this.appn = ap;
        this.width = l;
        this.height = h;




    }



    private void makeFrame(JMenuBar men){

        JFrame f= new JFrame(appn);//creating instance of JFrame
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

        //JLabel l2=new JLabel("Axis X", SwingConstants.CENTER);

        f.add(l1);
        //f.add(l2);



        f.setLayout (null);
        f.setVisible(true);//making the frame visible

    }

    private JMenuBar makeMenu(String[] dev){

        JMenuBar menuBar;
        JMenu menu;

        //Create the menu bar.
        menuBar = new JMenuBar();

        //Build the first menu.
        menu = new JMenu("Devices");
        menu.setMnemonic(KeyEvent.VK_D);
        menu.getAccessibleContext().setAccessibleDescription(
                "Select your Joystick");
        menuBar.add(menu);

        makeItMen(menu, dev);

        return menuBar;

    }


    private void makeItMen(JMenu menu, String[] dev) {

        JMenuItem menuItem;

        for(String string : dev) {

            menuItem = new JMenuItem(string, KeyEvent.VK_J);

            menuItem.getAccessibleContext().setAccessibleDescription(
                    "Is this your Joystick?");
            menu.add(menuItem);
        }



    }







    void build(String[] dev){
        makeFrame(makeMenu(dev));
    }


}
