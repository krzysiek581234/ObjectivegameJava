package pl.edu.pg.eti.ksg.po.ZycieJava.style;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Animals.Human;
import pl.edu.pg.eti.ksg.po.ZycieJava.World;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Call;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Coordinates;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Event;

public class Aplication extends JFrame implements ActionListener
{
    private static int boxheight = 720;
    private static int boxwidth = 1280;
    private JButton start;
    private JButton save;
    private JComboBox box;
    protected World myWorld;
    public boolean notrun =false;
    private boolean nextTurn = false;
    private GameGui gameGui;
    private int chosen = -1;
    private boolean grid;
    private boolean loadstart =false;
    private JLabel label1 = new JLabel("Tura");
    JLabel getSuperpower = new JLabel("Super Power");
    JLabel getLoadingSuperPower = new JLabel("Get SuperPower");
    JLabel getTimeofSuperPower = new JLabel("Time to Superpower");

    public Aplication(World myWorld,boolean grid,boolean loadstart)
    {
        super("Life Game Krzysztof Madajczak 188674");
        this.myWorld = myWorld;
        this.setSize(boxwidth,boxheight);
        this.grid = grid;
        this.loadstart = loadstart;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        Border br = BorderFactory.createLineBorder(Color.black);
        //panele
        JPanel panel1 = new JPanel();
        gameGui = new GameGui(boxwidth,boxheight,myWorld,grid,chosen);
        panel1.setLayout(null);
        label1.setBounds(100,350,70,30);
        getSuperpower.setBounds(100,370,170,30);
        getLoadingSuperPower.setBounds(100,390,170,30);
        getTimeofSuperPower.setBounds(100,410,170,30);
        panel1.add(label1);
        panel1.add(getSuperpower);
        panel1.add(getLoadingSuperPower);
        panel1.add(getTimeofSuperPower);
        panel1.setBackground(Color.yellow);
        panel1.setBounds(0,0,boxwidth/4,boxheight);
        panel1.setBorder(br);

        start = new JButton("Turn");
        save = new JButton("Save");
        String[] str = {"no one", "human" , "sheep" , "fox" , "wolf" , "turtle" , "antylopa" , "grass" , "dandelion" , "guarana" , "blueberries" , "Borsch"};
        box = new JComboBox(str);

        start.setBounds(boxwidth/16,100,boxwidth/8,50);
        save.setBounds(boxwidth/16,200,boxwidth/8,50);
        box.setBounds(boxwidth/16,300,boxwidth/8,50);

        start.addActionListener(this);
        save.addActionListener(saveListen);
        box.addActionListener(chosenew);

        super.getContentPane().addKeyListener(czlowiekRuchListener);
        if(loadstart==false)
        {
            Aplication.this.save.setVisible(false);
            Aplication.this.box.setVisible(false);
            start.setText("Start!");
        }
        panel1.add(start);
        panel1.add(save);
        panel1.add(box);
        this.add(panel1);
        this.add(gameGui);
        super.getContentPane().setFocusable(true);
        super.getContentPane().requestFocusInWindow();
        setVisible(true);
    }
    public boolean getnorun()
    {
        return this.notrun;
    }


    public KeyListener  czlowiekRuchListener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }
        @Override
        public void keyPressed(KeyEvent e) {
            int next =-1;
            boolean superpower = false;
            if(e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                next = 1;
            }
            else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                next = 0;
            }
            else if(e.getKeyCode() == KeyEvent.VK_UP)
            {
                next = 3;
            }
            else if(e.getKeyCode() == KeyEvent.VK_DOWN)
            {
                next = 2;
            }
            else if(e.getKeyCode() == KeyEvent.VK_S)
            {
                superpower = true;
            }
            myWorld.humanmove(next,superpower);
        }
        @Override
        public void keyReleased(KeyEvent e) {

        }
    };


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==start)
        {
            if (loadstart == false) {
                this.loadstart = true;
                Aplication.this.start.setText("Next turn!");
                Aplication.this.myWorld.done = false;
                Aplication.this.myWorld.iniMapa();
                while (Aplication.this.myWorld.done == false) ;
                Aplication.this.save.setVisible(true);
                Aplication.this.box.setVisible(true);
                Aplication.super.getContentPane().setFocusable(true);
                Aplication.super.getContentPane().requestFocusInWindow();
            }
            else {
                Aplication.this.myWorld.done = false;
                Aplication.this.myWorld.fun();
                while (Aplication.this.myWorld.done == false) ;
            }
            label1.setText("Tura " + myWorld.getTurn());
            showsuperpower();
            gameGui.repaintbuttom();
            Aplication.super.getContentPane().setFocusable(true);
            Aplication.super.getContentPane().requestFocusInWindow();
        }
    }
    private ActionListener chosenew = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            chosen = box.getSelectedIndex();
            gameGui.setChosen(chosen);
            Aplication.super.getContentPane().setFocusable(true);
            Aplication.super.getContentPane().requestFocusInWindow();
        }
    };
    private ActionListener saveListen = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //TODO :
            //zapis swiata
            Aplication.this.myWorld.save();
            Aplication.super.getContentPane().setFocusable(true);
            Aplication.super.getContentPane().requestFocusInWindow();
        }
    };
    public void showsuperpower()
    {
        for(int i = 0 ; i < myWorld.getnumberofOrg();i++)
        {
            if(myWorld.census.get(i) instanceof Human)
            {
                getSuperpower.setText("Super Power" + ((Human) myWorld.census.get(i)).getSuperpower());
                getLoadingSuperPower.setText("Get SuperPower" + ((Human) myWorld.census.get(i)).getLoadingSuperPower());
                getTimeofSuperPower.setText("Time to Superpower" + ((Human) myWorld.census.get(i)).getTimeofSuperPower());
                break;
            }
        }
    }


}
