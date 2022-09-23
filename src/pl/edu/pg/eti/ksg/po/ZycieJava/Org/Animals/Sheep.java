package pl.edu.pg.eti.ksg.po.ZycieJava.Org.Animals;

import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Animal;
import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Organism;
import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Type;
import pl.edu.pg.eti.ksg.po.ZycieJava.World;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Call;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Coordinates;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Event;

import java.awt.*;

public class Sheep extends Animal {
    private int StartStrength = 4;
    private int StartInitiative = 4;

    public Sheep(int turnofbirth, World newWorld, Coordinates position) {
        super(turnofbirth, newWorld, position);
        this.kod = 'S';
        this.initiative = this.StartInitiative;
        this.strength = this.StartStrength;
        this.type = Type.sheep;
        this.color = Color.yellow;
    }

    @Override
    public Organism newChild(int tura, Coordinates Position) {
        return new Sheep(turn, myWorld, Position);
    }
}