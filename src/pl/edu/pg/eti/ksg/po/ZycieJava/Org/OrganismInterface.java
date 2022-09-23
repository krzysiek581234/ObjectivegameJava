package pl.edu.pg.eti.ksg.po.ZycieJava.Org;

import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Coordinates;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.Event;

public interface OrganismInterface
{
    public Event action();
    public Event collision(Organism attacker);
    public boolean reaction(Event event);
    public Organism newChild(int turn,  Coordinates Pos);
    String save();
    void load(String input);
    void addStrength(int strength);
    public char getKod();
    public int getStrength();
    public int getInitiative();
    public int getTurn();
    public void printType();
    Coordinates getPosition();
    Type getType();
}
