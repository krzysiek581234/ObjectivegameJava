package pl.edu.pg.eti.ksg.po.ZycieJava.logic;

public class Event
{
    protected Coordinates Who;
    protected Coordinates Where;
    protected Call What;
    public Event(Coordinates who, Call what, Coordinates where)
    {
        this.Who = new Coordinates(who);
        this.Where = new Coordinates(where);
        this.What = what;
    }
    public Call getWhat()
    {
        return this.What;
    }
    public Coordinates getWho()
    {
        return this.Who;
    }
    public Coordinates getWhere()
    {
        return this.Where;
    }
}
