package pl.edu.pg.eti.ksg.po.ZycieJava.Org.Plants;

import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Animal;
import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Organism;
import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Type;
import pl.edu.pg.eti.ksg.po.ZycieJava.World;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Call;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Coordinates;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Event;

import java.awt.*;

public class Borsch extends Plant
{
    public Borsch(int tura, World newWorld, Coordinates Pos)
    {
        super(tura,newWorld,Pos);
        this.kod = 'X';
        this.type = Type.Borsch;
        this.color = Color.red;
    }
    @Override
    public Organism newChild(int turn, Coordinates Position)
    {
        return new Borsch(turn, myWorld, Position);
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
    @Override
    public Event action()
    {
        Event Returnevent = new Event(this.position, Call.killALLAnimals, this.position);
        this.myWorld.eventManager(Returnevent);
        for (int g = 0; g < seeds; g++)
        {
            if (rand.nextInt(100) <= chanceofspreding)
            {
                Coordinates childCords = new Coordinates(this.position);
                int randomx = 0;
                int randomy = 0;
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
                    randomx = rand.nextInt(3) - 1;
                    randomy = rand.nextInt(3) - 1;
                    if (this.myWorld.checkcords(childCords.x + randomx, childCords.y + randomy))
                    {
                        if (this.myWorld.getmapCords(childCords.x + randomx, childCords.y + randomy) == -1)
                        {
                            break;
                        }
                    }

                } while (true);

                childCords.x = childCords.x + randomx;
                childCords.y = childCords.y + randomy;
                return new Event(this.position, Call.create, childCords);
            }
        }
        return null;
    }

}
