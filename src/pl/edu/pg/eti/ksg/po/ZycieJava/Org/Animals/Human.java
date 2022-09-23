package pl.edu.pg.eti.ksg.po.ZycieJava.Org.Animals;

import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Animal;
import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Organism;
import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Type;
import pl.edu.pg.eti.ksg.po.ZycieJava.World;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Call;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Coordinates;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Event;

import java.awt.*;

public class Human extends Animal
{
    static int StartStrength = 15;
    static int StartInitiative = 4;
    static int durationSuperPower = 5;
    static int superPowerRechargeTime = 5 + durationSuperPower;
    int superpower;
    int timeofSuperPower;
    int loadingSuperPower;
    boolean issuperPowerLoad = false;
    private int nextmove;

    public Human(int tura, World newWorld, Coordinates Pos)
    {
        super(tura, newWorld, Pos);
        this.kod = 'C';
        this.initiative = this.StartInitiative;
        this.strength = this.StartStrength;
        this.type = Type.human;
        this.superpower = 0;
        this.timeofSuperPower = 0;
        this.loadingSuperPower = 0;
        this.nextmove = -1;
        this.color = Color.ORANGE;
    }
    @Override
    public Event action()
    {
        if (superpower == 1)
        {

            //supermoc 5 s188674 kill all :)
            this.timeofSuperPower--;
            Event Returnevent = null;
            Returnevent = new Event(this.position, Call.killALL, this.position);
            this.myWorld.eventManager(Returnevent);
            issuperPowerLoad = true;
            if (timeofSuperPower == 0)
            {
                this.issuperPowerLoad =false;
                this.superpower = 0;
            }
        }
        if (loadingSuperPower != 0)
        {
            this.loadingSuperPower--;
        }

        if (nextmove != -1)
        {
            Coordinates newCords = new Coordinates(this.position);

            switch (nextmove)
                    //warunek
            {
                case 0: //Ri
                    newCords.x++;
                    break;
                case 1:
                    newCords.x--;
                    break;
                case 2:
                    newCords.y++;
                    break;
                case 3:
                    newCords.y--;
                    break;
            }
            this.nextmove = -1;
            return new Event(this.position, Call.move, newCords);
        }
        return null;
    }
    public Organism newChild(int turn, Coordinates Pos)
    {
        return null; //czlowiek sie nie rozmnarza
    }
    @Override public String save()
    {
        String odp = new String(
                "[ " + String.valueOf(kod) + " " + String.valueOf(timeofSuperPower) + " "+ String.valueOf(loadingSuperPower) + " "
                        + String.valueOf(turn) + " " + String.valueOf(strength) + " "
                        + String.valueOf(initiative) + " " + this.position.save() + "] ");
        return odp;
    }
    @Override public void load(String zczyt)
    {
        zczyt = zczyt.substring(2,zczyt.length()-2);
        String buf[] = zczyt.split(" ");
        this.kod = buf[0].charAt(0);
        this.timeofSuperPower = Integer.parseInt(buf[1]);
        this.loadingSuperPower = Integer.parseInt(buf[2]);
        this.turn = Integer.parseInt(buf[3]);
        this.strength = Integer.parseInt(buf[4]);
        this.initiative = Integer.parseInt(buf[5]);
        this.position.load(buf[7],buf[9]);
        this.type = Type.human;


        this.superpower = 0;
        this.nextmove = -1;
        this.color = Color.ORANGE;

    }
    public void getKeyBoard(int next,boolean superpower)
    {
        //odebranie wiadomosci:
            this.nextmove = next;

         if (superpower && issuperPowerLoad == false)
        {

            if (loadingSuperPower == 0)
            {

                //supermoc aktywowana!
                this.issuperPowerLoad=true;
                System.out.println(  "Aktywowano Supermoc!");
                this.timeofSuperPower = durationSuperPower;
                this.superpower = 1;
                this.loadingSuperPower = superPowerRechargeTime;
                return;
            }
        }
    }
    public int getSuperpower() {
        return superpower;
    }

    public int getTimeofSuperPower() {
        return timeofSuperPower;
    }

    public int getLoadingSuperPower() {
        return loadingSuperPower;
    }

    public boolean getIssuperPowerLoad() {
        return issuperPowerLoad;
    }
}




