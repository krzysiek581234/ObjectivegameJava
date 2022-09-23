package pl.edu.pg.eti.ksg.po.ZycieJava.logic;

public class Coordinates
{
    public int x,y;
    public Coordinates(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
    public void newCoordinates(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
    public Coordinates(Coordinates Cords)
    {
        this.x = Cords.x;
        this.y = Cords.y;
    }
    public boolean compere(int x,int y)
    {
        return (this.x == x && this.y == y) ? true: false;
    }
    public boolean compere(Coordinates Cords)
    {
        return (this.x == Cords.x && this.y == Cords.y) ? true: false;
    }
    public void assignment(Coordinates Cords)
    {
        this.x = Cords.x;
        this.y = Cords.y;
    }
    public String save()
    {
        return "< " + String.valueOf(x) + " , " + String.valueOf(y) + " > ";
    }
    public void load(String zczyt1,String zczyt2)
    {
        this.x = Integer.parseInt(zczyt1);
        this.y = Integer.parseInt(zczyt2);
    }
}
