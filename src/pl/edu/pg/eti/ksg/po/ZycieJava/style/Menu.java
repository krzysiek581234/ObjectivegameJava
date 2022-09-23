package pl.edu.pg.eti.ksg.po.ZycieJava.style;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Menu extends JFrame implements ActionListener
{
    final int numberofMenus = 4;
    final int numberofSliders = 2;
    private int height;
    private int width;
    private JButton exit;
    private JTextArea [] text = new JTextArea [2];
    private JSlider[] slider = new JSlider[2];
    private JButton[] buttonTab = new JButton[numberofMenus];
    private boolean[]  isactive = new boolean[numberofMenus];
    private boolean notrun = true;
    public boolean grid = true;
    public Menu(int width, int height)
    {
        this.height = height;
        this.width = width;
        buttonTab[0] = new JButton("Start Game");
        buttonTab[1] = new JButton("Load Game");
        buttonTab[2] = new JButton("Hex");
        buttonTab[3] = new JButton("Exit");

        slider[0] = new JSlider(1,31,this.width);
        slider[1] = new JSlider(1,31,this.height);
        text[0] = new JTextArea("Width:");
        text[1] = new JTextArea("Height:");

        for (int i = 0; i < numberofMenus; i++)
        {
            isactive[i] = false;
            buttonTab[i].setBounds(515, 50+i*125, 250, 100);
            buttonTab[i].setFont(new Font("Comic Sans",Font.BOLD,25));
            buttonTab[i].setIconTextGap(-15);
            buttonTab[i].setForeground(Color.red);
            buttonTab[i].setBackground(Color.lightGray);
            buttonTab[i].setBorder(BorderFactory.createEtchedBorder());
            buttonTab[i].addActionListener(this);
            buttonTab[i].setFocusable(false);
            buttonTab[i].setHorizontalTextPosition(JButton.CENTER);
            buttonTab[i].setVerticalTextPosition(JButton.BOTTOM);
            if(i>=numberofSliders)
            {
                buttonTab[i].setBounds(515, 50+(i+1)*125, 250, 100);
            }
        }
        for (int j = 0; j < numberofSliders; j++) {
            text[j].setBounds(515, 280+j*70, 250, 20);
            text[j].setOpaque(false);
            text[j].setBackground(new Color(255, 255, 255, 100));
            slider[j].setBounds(515, 300+j*70, 250, 50);
            slider[j].setBackground(Color.lightGray);
            slider[j].setForeground(Color.red);
            slider[j].setPaintTrack(true);
            slider[j].setPaintTicks(true);
            slider[j].setPaintLabels(true);
            slider[j].setMajorTickSpacing(10);
            slider[j].setMinorTickSpacing(5);
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1280,720);
        this.setVisible(true);
        for (int i = 0; i < numberofMenus; i++)
        {
            this.add(buttonTab[i]);
        }
        for (int i = 0; i < numberofSliders; i++) {
            this.add(slider[i]);
            this.add(text[i]);
        }
        this.setTitle("Life Game Krzysztof Madajczak 188674");
        this.getContentPane().setBackground(new Color(0, 255, 255));
        this.setResizable(false);
        ImageIcon logo = new ImageIcon("pictures/krzyz.png");
        this.setIconImage(logo.getImage());

    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==buttonTab[0])
        {
            Menu.this.isactive[0] = true;
            Menu.this.notrun = false;
            Menu.this.height = Menu.this.slider[1].getValue();
            Menu.this.width = Menu.this.slider[0].getValue();
            Menu.this.dispose();
        }
        else if(e.getSource()==buttonTab[1])
        {
            Menu.this.isactive[1] = true;
            Menu.this.notrun = false;
            Menu.this.dispose();
        }
        else if(e.getSource()==buttonTab[3])
        {
            Menu.this.notrun = false;
            isactive[3] = true;
            Menu.this.dispose();
        }
        else if(e.getSource()==buttonTab[2])
        {
            Menu.this.notrun = false;
            if (isactive[2] == false)
            {
                buttonTab[2].setText("Kwadrat");
                isactive[2] = true;
                grid = true;
            }
            else
            {
                buttonTab[2].setText("Hex");
                isactive[2] = false;
                grid = false;
            }
        }
    }
    public boolean getActive(int i)
    {
        return isactive[i];
    }

    public boolean getnotrun()
    {
        return this.notrun;
    }

    public int MenugetHeight()
    {
        return Menu.this.height;
    }
    public int MenugetWidth()
    {
        return Menu.this.width;
    }


}
