package pl.edu.pg.eti.ksg.po.ZycieJava.Org.Plants;

import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Organism;
import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Type;
import pl.edu.pg.eti.ksg.po.ZycieJava.World;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Coordinates;

import java.awt.*;

public class Dandelion extends Plant
{
    public Dandelion(int tura, World newWorld, Coordinates Pos)
    {
        super(tura, newWorld, Pos);
        this.kod = '#';
        this.seeds = 3;
        this.type = Type.dandelion;
        this.color = Color.white;
    }
    @Override
    public Organism newChild(int turn, Coordinates Position)
    {
        return new Dandelion(turn, myWorld, Position);
    }
}
