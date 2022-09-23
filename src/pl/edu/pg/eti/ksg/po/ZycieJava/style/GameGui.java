package pl.edu.pg.eti.ksg.po.ZycieJava.style;

import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Type;
import pl.edu.pg.eti.ksg.po.ZycieJava.World;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Call;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Coordinates;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Event;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGui extends JPanel implements ActionListener
{
    private int mapwidth;
    private int mapheight;
    private int boxwidth;
    private int boxheight;
    private int blocksizeX;
    private int blocksizeY;
    private World myWorld;
    private JButton[][] buttonTab;
    private boolean grid;
    private int chosen =-1;
    public GameGui(int boxwidth,int boxheight,World myWorld, boolean grid,int chosen)
    {
        this.grid = grid;
        Border br = BorderFactory.createLineBorder(Color.black);
        this.mapwidth = myWorld.getWidth();
        this.mapheight = myWorld.getHeight();
        this.boxheight = boxheight;
        this.boxwidth = boxwidth;
        this.myWorld = myWorld;
        this.blocksizeX = (int) (0.75 * boxwidth / (mapwidth + 1));
        this.blocksizeY = (int) (boxheight / (mapheight + 1));
        this.chosen = chosen;
        buttonTab = new JButton[mapwidth][mapheight];
        this.setLayout(null);
        this.setBounds(120,50,50,20);
        this.setBackground(Color.cyan);
        this.setBounds( boxwidth/4,0,3 *boxwidth/4,boxheight);
        this.setBorder(br);
        paintbuttom();
    }
    public void paintbuttom()
    {
        for (int i = 0; i < mapwidth; i++)
        {
            for (int j = 0; j < mapheight; j++)
            {
                buttonTab[i][j] = new JButton("");
                buttonTab[i][j].addActionListener(this);

                String type = "";
                buttonTab[i][j].setBackground(Color.CYAN);
                if(myWorld.map[i][j] != -1)
                {
                    type = myWorld.getmapType(i,j).toString();
                    buttonTab[i][j].setBackground(myWorld.census.get(myWorld.map[i][j]).getColor());
                }
                buttonTab[i][j].setText(type);
                buttonTab[i][j].setBounds(i*blocksizeX, j*blocksizeY, blocksizeX, blocksizeY);
                this.add(buttonTab[i][j]);
            }
        }
    }
    public void repaintbuttom()
    {
        for (int i = 0; i < mapwidth; i++)
        {
            for (int j = 0; j < mapheight; j++)
            {
                String type = "";
                buttonTab[i][j].setBackground(Color.CYAN);
                System.out.println(i+ " " + j);
                if (myWorld.map[i][j] != -1) {
                    System.out.print(" Animal");
                    type = myWorld.getmapType(i, j).toString();
                    //Color x = myWorld.census.get(myWorld.map[i][j]).getColor();
                    buttonTab[i][j].setBackground(myWorld.census.get(myWorld.map[i][j]).getColor());
                }
                buttonTab[i][j].setText(type);
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton button = (JButton) e.getSource();
        for (int i = 0; i < mapwidth; i++)
        {
            for (int j = 0; j < mapheight; j++)
            {
                if(button == buttonTab[i][j])
                {
                    if (chosen != -1)
                    {
                        Coordinates newCords = new Coordinates(i, j);
                        myWorld.addOrg(chosen,newCords);
                        repaintbuttom();
                    }
                }
            }
        }
    }
    public void setChosen(int chosen)
    {
        this.chosen =chosen;
    }


}
