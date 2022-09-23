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

public class Turtle extends Animal
{
    private int StartStrength = 2;
    private int StartInitiative = 1;

    public Turtle(int turnofbirth, World newWorld, Coordinates position) {
        super(turnofbirth, newWorld, position);
        this.kod = 'T';
        this.initiative = this.StartInitiative;
        this.strength = this.StartStrength;
        this.type = Type.turtle;
        this.color = Color.PINK;
    }
    @Override
    public Organism newChild(int tura, Coordinates Position) {
        return new Turtle(turn, myWorld, Position);
    }

    @Override
    public Event action() {
        if (rand.nextInt(4) == 1) {
            Coordinates newCords = new Coordinates(this.position);

            int newx = position.x, newy = position.y;
            int randomx = -1;
            int randomy = -1;
            int notmove = 0;

            do {
                randomx = (rand.nextInt(3)) - 1;
                randomy = (rand.nextInt(3)) - 1;
                notmove++;
                if (this.myWorld.checkcords(newx + randomx, newy + randomy) && (randomx != 0 && randomy != 0)) {
                    if (this.myWorld.getmapCords(newx + randomx, newy + randomy) == -1 || myWorld.getmapType(newx + randomx, newy + randomy) == this.type) {
                        break;
                    } else if (this.myWorld.getOrganismStrenghFrommap(newx + randomx, newy + randomy) <= strength) {
                        break;
                    }
                }
                if (notmove == 10)
                    return null;
            } while (true);
            newCords.newCoordinates(newx + randomx, newy + randomy);
            return new Event(this.position, Call.move, newCords);
        }
        return null;
    }

    @Override
    public Event collision(Organism attacker)
    {
        if (this.type == attacker.getType())
            {
                Coordinates childCords = new Coordinates(this.position);
                int randomx = 0;
                int randomy = 0;
                boolean nospace = true;
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (this.myWorld.checkcords(childCords.x + i, childCords.y + j)
                                && this.myWorld.getmapCords(childCords.x + i, childCords.y + j) == -1) {
                            nospace = false;
                            break;
                        }
                    }
                }
                if (nospace == true)
                    return null;
                do {
                    Random rand = new Random();
                    randomx = (rand.nextInt(3) - 1);
                    randomy = (rand.nextInt(3) - 1);
                    if (this.myWorld.checkcords(childCords.x + randomx, childCords.y + randomy))
                        if (this.myWorld.getmapCords(childCords.x + randomx, childCords.y + randomy) == -1)
                            break;
                }
                while (true);

                childCords.x += randomx;
                childCords.y += randomy;

                return new Event(this.position, Call.create, childCords);
            }
            if (attacker.getStrength() > 5)
            {
                return  new Event(attacker.getPosition(), Call.kill, this.position);
            }
	            else
            {
                System.out.println("Turtle defended himself");
            }
        return null;
    }
}
