package com.andreamancini;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

class Gui {

    private String appn;
    private int width;
    private int height;

    private JFrame f= new JFrame(appn);//creating instance of JFrame
    private Insets insets = new Insets(0,0,0,0);
    private JMenuBar menuBar;
    private JMenu menu;
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButtonMenuItem menuItem;

    private JProgressBar jb1=new JProgressBar(0,100);
    private JProgressBar jb2=new JProgressBar(0,100);
    private JProgressBar jb3=new JProgressBar(0,100);

    private double per_min = 0.498;
    private double per_max = 0.502;

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
        insets = pane.getInsets();


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

            menuItem = new JRadioButtonMenuItem(string);

            menuItem.setActionCommand(string);

            buttonGroup.add(menuItem);
            menu.add(menuItem);

            if(string.equals(dev[0])){
                menuItem.setSelected(true);
            }



        }


    }


    String name_finder(){


        String name = buttonGroup.getSelection().getActionCommand();

        System.out.println(name);

        return name;
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


    void setbar(int[] n, int val_min, int val_max){

        jb1.setMinimum(val_min);
        jb2.setMinimum(val_min);
        jb3.setMinimum(val_min);

        jb1.setMaximum(val_max);
        jb2.setMaximum(val_max);
        jb3.setMaximum(val_max);

        jb1.setValue(n[0]);
        jb2.setValue(n[1]);
        jb3.setValue(n[2]);

        //jb1.setStringPainted(true);

        if(jb1.getPercentComplete() >= per_min && jb1.getPercentComplete() <= per_max){

            jb1.setForeground(Color.green);
            //jb1.setString("10%");
        }else {
            jb1.setForeground(Color.red);
        }

        if(jb2.getPercentComplete() >= per_min && jb2.getPercentComplete() <= per_max){

            jb2.setForeground(Color.green);
            //jb1.setString("10%");
        }else {
            jb2.setForeground(Color.red);
        }

        if(jb3.getPercentComplete() >= per_min && jb3.getPercentComplete() <= per_max){

            jb3.setForeground(Color.green);
            //jb1.setString("10%");
        }else {
            jb3.setForeground(Color.red);
        }


    }

    void nojoy(){

        jb1.setVisible(false);
        jb2.setVisible(false);
        jb3.setVisible(false);

        JLabel lno1 =new JLabel("JOYSTICK NOT FOUND");

        Dimension size1 = lno1.getPreferredSize();
        lno1.setBounds(width/4 + insets.left, 80 + insets.top,
                size1.width, size1.height);

        JLabel lno2 =new JLabel("PLEASE CONNECT A DEVICE");

        Dimension size2 = lno2.getPreferredSize();
        lno2.setBounds(width/5 + insets.left, 80 + 30 + insets.top,
                size2.width, size2.height);

        lno1.setForeground(Color.red);
        lno2.setForeground(Color.red);

        f.add(lno1);
        f.add(lno2);

    }





    void build(String[] dev){
        makeMenu(dev);
        makeFrame(menuBar);
    }


}
