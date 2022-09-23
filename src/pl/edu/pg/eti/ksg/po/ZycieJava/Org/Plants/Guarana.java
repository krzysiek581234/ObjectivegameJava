package pl.edu.pg.eti.ksg.po.ZycieJava.Org.Plants;

import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Organism;
import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Type;
import pl.edu.pg.eti.ksg.po.ZycieJava.World;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Call;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Coordinates;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Event;

import java.awt.*;

public class Guarana extends Plant
{
    public Guarana(int tura, World newWorld, Coordinates Pos)
    {
        super(tura, newWorld, Pos);
        this.kod = '+';
        this.type = Type.guarana;
        this.color = Color.black;
    }
    @Override
    public Organism newChild(int turn, Coordinates Position)
    {
        return new Dandelion(turn, myWorld, Position);
    }
    @Override
    public Event collision(Organism attacker)
    {
        attacker.addStrength(3);
        return  new Event(attacker.getPosition(), Call.kill, this.position);
    }
}
