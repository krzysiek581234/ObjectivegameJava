package pl.edu.pg.eti.ksg.po.ZycieJava.Org.Animals;

import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Animal;
import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Organism;
import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Type;
import pl.edu.pg.eti.ksg.po.ZycieJava.World;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Call;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Coordinates;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Event;

import java.awt.*;
import java.util.Random;

public class Antelope extends Animal
{
	int StartStrength = 4;
	int StartInitiative = 4;

    public Antelope(int turnofbirth, World newWorld, Coordinates position)
    {
        super(turnofbirth, newWorld, position);
        this.kod = 'A';
        this.initiative = this.StartInitiative;
        this.strength = this.StartStrength;
        this.type = Type.antylopa;
        this.color = Color.DARK_GRAY;
    }

    @Override
    public Organism newChild(int tura, Coordinates Position)
    {
        return new Antelope(turn, myWorld, Position);
    }
    @Override
    public Event action()
    {
        int nowePole = this.choosefieldAntylope();
        Coordinates nowekordy = new Coordinates(this.position);
        switch (nowePole)
        {
            case -1: //can't move
                return null;
            //break;
            case 0: // RIGHT
                nowekordy.x += 2;
                break;
            case 1: // LEFT
                nowekordy.x -= 2;
                break;
            case 2: // DOWN
                nowekordy.y += 2;
                break;
            case 3: // UP
                nowekordy.y -= 2;
                break;
        }
        return new Event(this.position, Call.move, nowekordy);
    }
    @Override
    public Event collision(Organism attacker)
    {
        Random rand = new Random();
        if (this.getType() == attacker.getType())
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
        if (rand.nextInt(2) == 0)
            return  new Event(attacker.getPosition(), Call.kill, this.position);
        else
            System.out.println("Antelope run away!");
        return null;
    }
    private int choosefieldAntylope()
    {
        //field :  0   0     0    0
        //        UP DOWN LEFT RIGHT
        int maxfield = 4;
        char field = 0x0F; // 1 1 1 1

        if (this.position.x <= 1)
        {
            field = (char) (field & 0xFD); //NO LEFT
            maxfield--;
        }
        if (this.position.x >= this.myWorld.getWidth() - 2)
        {
            field = (char) (field & 0xFE); //NO RIGHT
            maxfield--;
        }
        if (this.position.y <= 1)
        {
            field = (char) (field & 0xF7); //NO UP
            maxfield--;
        }
        if (this.position.y >= this.myWorld.getHeight() - 2)
        {
            field = (char) (field & 0xFB); //NO DOWN
            maxfield--;
        }

        if (maxfield == 0) //gdy zero to nie może sie ruszyć!
            return -1;

        int chosen = 0;
        int numerfield = this.rand.nextInt(maxfield);
        while (numerfield >= 0)
        {
            int bit = field & 0x01; // najmłodszy bit
            if (bit != 0)
                numerfield--;
            field = (char) (field >> 1);
            chosen++;
        }
        return chosen - 1;
    }
}
