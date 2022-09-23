package pl.edu.pg.eti.ksg.po.ZycieJava.Org.Animals;

import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Animal;
import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Organism;
import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Type;
import pl.edu.pg.eti.ksg.po.ZycieJava.World;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Coordinates;

import java.awt.*;

public class Wolf extends Animal {
    private int StartStrength = 9;
    private int StartInitiative = 5;

    public Wolf(int turnofbirth, World newWorld, Coordinates position) {
        super(turnofbirth, newWorld, position);
        this.kod = 'W';
        this.initiative = this.StartInitiative;
        this.strength = this.StartStrength;
        this.type = Type.wolf;
        this.color = Color.gray;
    }

    @Override
    public Organism newChild(int tura, Coordinates Position) {
        return new Wolf(turn, myWorld, Position);
    }
}
