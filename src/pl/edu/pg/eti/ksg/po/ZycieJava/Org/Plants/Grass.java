package pl.edu.pg.eti.ksg.po.ZycieJava.Org.Plants;

import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Organism;
import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Type;
import pl.edu.pg.eti.ksg.po.ZycieJava.World;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Coordinates;

import java.awt.*;

public class Grass extends Plant
{
    public Grass(int tura, World newWorld, Coordinates Pos)
    {
    super(tura, newWorld, Pos);
    this.kod = 'G';
    this.type = Type.grass;
    this.color = Color.green;
    }
    @Override
    public Organism newChild(int turn, Coordinates Position)
    {
        return new Grass(turn, myWorld, Position);
    }
}
