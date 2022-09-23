package pl.edu.pg.eti.ksg.po.ZycieJava.Org.Plants;

import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Organism;
import pl.edu.pg.eti.ksg.po.ZycieJava.World;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Call;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Coordinates;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Event;

public abstract class Plant extends Organism
{
	private int DEFAULTSTARTINITIATIVE = 0;
	private int DEFAULTSTARTSTRENGH = 0;
	private int CHANCEOFSPREDING = 10;
	private int DEFULTSEEDS = 1;
    double chanceofspreding;
    int seeds;
    public Plant(int turnofbirth, World newWorld, Coordinates position)
    {
        super(turnofbirth,newWorld,position);
        this.initiative = this.DEFAULTSTARTSTRENGH;
        this.strength = this.DEFAULTSTARTINITIATIVE;
        this.chanceofspreding = this.CHANCEOFSPREDING;
        this.seeds = this.DEFULTSEEDS;
    };

    @Override
    public Event action()
    {
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

    @Override
    public Event collision(Organism attacker) {
        return  new Event(attacker.getPosition(), Call.kill, this.position);
    }

    @Override
    public boolean reaction(Event event)
    {
        switch (event.getWhat())
        {
            case move:
                return false;
            case poison:
                return false;
        }
        return false;
    }

}
