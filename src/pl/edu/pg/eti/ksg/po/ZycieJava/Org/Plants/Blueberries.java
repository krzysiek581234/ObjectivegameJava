package pl.edu.pg.eti.ksg.po.ZycieJava.Org.Plants;

import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Organism;
import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Type;
import pl.edu.pg.eti.ksg.po.ZycieJava.World;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Call;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Coordinates;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Event;

import java.awt.*;

public class Blueberries extends Plant
{
    public Blueberries(int tura, World newWorld, Coordinates Pos)
    {
        super(tura, newWorld, Pos);
        this.kod = 'B';
        this.type = Type.blueberries;
        this.color = Color.blue;
    }
    @Override
    public Organism newChild(int turn, Coordinates Position)
    {
        return new Blueberries(turn, myWorld, Position);
    }
    @Override
    public Event collision(Organism attacker)
    {
        int attackerStrength = attacker.getStrength();

        Event Returnevent = new Event(attacker.getPosition(), Call.kill, this.position);
        this.myWorld.eventManager(Returnevent);

        if (attackerStrength > strength)
        {
            return  new Event(attacker.getPosition(), Call.poison, attacker.getPosition());
        }
        return null;
    }
}
