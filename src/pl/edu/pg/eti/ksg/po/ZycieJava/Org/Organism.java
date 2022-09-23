package pl.edu.pg.eti.ksg.po.ZycieJava.Org;

import pl.edu.pg.eti.ksg.po.ZycieJava.World;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Coordinates;

import java.awt.*;
import java.util.Random;

public abstract class Organism implements OrganismInterface
{
    protected Color color;
    public char kod;
    protected int strength, initiative, turn;
    protected Coordinates position;
    protected Type type;
    protected World myWorld;
    protected Random rand;
    public Organism(int turnofbirth, World newWorld, Coordinates position)
    {
        this.turn = turnofbirth;
        this.myWorld = newWorld;
        this.position = position;
        this.strength = 0;
        this.initiative = 0;
        rand = new Random();
    }
    public void addStrength(int str)
    {
        this.strength += str;
    }
    public char getKod(){ return this.kod; }
    public Type getType()
    {
        return this.type;
    }
    public void printType()
    {
        System.out.println(type);
    }
    public int getStrength() { return this.strength; }
    public int getInitiative(){ return this.initiative; }
    public int getTurn() { return this.turn;}
    public Color getColor(){return this.color;}
    public Coordinates getPosition(){ return this.position; }
    public void load(String input)
    {
        input = input.substring(2,input.length()-2);
        String buf[] = input.split(" ");
        this.kod =  buf[0].charAt(0);
        this.turn = Integer.parseInt(buf[1]);
        this.strength = Integer.parseInt(buf[2]);
        this.initiative = Integer.parseInt(buf[3]);
        this.position.load(buf[5],buf[7]);

    }
    public String save()
    {
        String odp = new String(
                "[ " + String.valueOf(kod) + " " + String.valueOf(turn) + " " + String.valueOf(strength) + " "
                        + String.valueOf(initiative) + " " + this.position.save() + "] ");
        return odp;
    }
}
