package pl.edu.pg.eti.ksg.po.ZycieJava.Org.Animals;

import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Animal;
import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Organism;
import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Type;
import pl.edu.pg.eti.ksg.po.ZycieJava.World;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Call;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Coordinates;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Event;

import java.awt.*;

public class Fox extends Animal
{
    private int StartStrength = 3;
    private int StartInitiative = 7;
    public Fox(int turnofbirth, World newWorld, Coordinates position)
    {
        super(turnofbirth, newWorld, position);
        this.kod = 'F';
        this.initiative = this.StartInitiative;
        this.strength = this.StartStrength;
        this.type = Type.fox;
        this.color = Color.magenta;
    }
    @Override
    public Organism newChild(int tura, Coordinates Position)
    {
        return new Fox(turn, myWorld, Position);
    }
    @Override
    public Event action()
    {
        Coordinates newCords =new Coordinates(this.position);
        int newx = position.x, newy = position.y;
        int randomx = -1;
        int	randomy = -1;
        int notmove = 0;

        do
        {
            randomx = (rand.nextInt(3)) - 1;
            randomy = (rand.nextInt(3)) - 1;
            notmove++;
            if (this.myWorld.checkcords(newx + randomx, newy + randomy) &&(randomx != 0 && randomy != 0))
            {
                if(this.myWorld.getmapCords(newx + randomx, newy + randomy) == -1 || myWorld.getmapType(newx + randomx, newy + randomy) == this.type)
                {
                    break;
                }
                else if (this.myWorld.getOrganismStrenghFrommap(newx + randomx, newy + randomy) <= strength)
                {
                    break;
                }
            }
            if (notmove == 10)
                return null;
        } while (true);
        newCords.newCoordinates(newx + randomx, newy + randomy);
        return new Event(this.position, Call.move, newCords);
    }
}
