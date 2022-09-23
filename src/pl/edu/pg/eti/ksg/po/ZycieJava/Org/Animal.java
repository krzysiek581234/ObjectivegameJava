package pl.edu.pg.eti.ksg.po.ZycieJava.Org;
import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Organism;
import pl.edu.pg.eti.ksg.po.ZycieJava.World;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Call;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Coordinates;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Event;

import java.util.Random;

public abstract class Animal extends Organism
{
    protected Animal(int turnofbirth, World newWorld, Coordinates position)
    {
        super(turnofbirth, newWorld, position);
    }

    @Override public Event action()
    {
        Coordinates nowekordy = new Coordinates(this.position);
        int newx = position.x, newy = position.y;
        Random rand = new Random();
        int randomx = (rand.nextInt(3) ) - 1;
        int randomy = (rand.nextInt(3) ) - 1;
        if (this.position.x + randomx >=0 && this.position.x + randomx <= this.myWorld.getWidth()-1)
        {
            newx = this.position.x + randomx;
        }
        if (this.position.y + randomy >=0 && this.position.y + randomy <= this.myWorld.getHeight()-1)
        {
            newy = this.position.y + randomy;
        }
        nowekordy.newCoordinates(newx, newy);
        return new Event(this.position, Call.move, nowekordy);
    }
    @Override public boolean reaction(Event event)
    {
        switch (event.getWhat())
        {
            case move:
                if (event.getWho().x == this.position.x && event.getWho().y == this.position.y)
                {
                    this.position = event.getWhere();
                    return true;
                }
                break;
        }
        return false;
    }
    @Override public Event collision(Organism attacker)
    {
        if (this.type == attacker.getType())
        {
            Coordinates childCords = new Coordinates(this.position);
            int randomx =0;
            int randomy =0;
            boolean nospace = true;
            for (int i = -1; i < 2; i++)
            {
                for (int j = -1; j < 2; j++)
                {
                    if (this.myWorld.checkcords(childCords.x + i, childCords.y + j)
                        && this.myWorld.getmapCords(childCords.x + i, childCords.y + j) == -1)
                    {
                        nospace = false;
                        break;
                    }
                }
            }
            if (nospace == true)
                return null;
            do
            {
                Random rand = new Random();
                randomx = (rand.nextInt(3) - 1);
                randomy = (rand.nextInt(3) - 1);
                if (this.myWorld.checkcords(childCords.x + randomx, childCords.y + randomy))
                if (this.myWorld.getmapCords(childCords.x + randomx, childCords.y + randomy) == -1)
                break;
            }
            while (  true);

            childCords.x += randomx;
            childCords.y += randomy;

            return new Event(this.position,Call.create, childCords);
        }
        return  new Event(attacker.getPosition(), Call.kill, this.position);
    }

    @Override public abstract Organism newChild(int tura, Coordinates Pos);

}
