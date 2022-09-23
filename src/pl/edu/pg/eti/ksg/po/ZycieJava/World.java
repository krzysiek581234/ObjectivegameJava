package pl.edu.pg.eti.ksg.po.ZycieJava;

import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Organism;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Animals.*;
import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Plants.*;
import pl.edu.pg.eti.ksg.po.ZycieJava.Org.Type;
import pl.edu.pg.eti.ksg.po.ZycieJava.logic.*;
public class World
{
    private int height;
    private int width;
    private int numberofOrganism;
    private int turn;
    public int[][] map;
    public ArrayList <Organism> census;
    public boolean done = false;
    boolean ishuman = false;
    boolean grid = true;
    //private Random rand;

    public World(int height, int width,boolean grid)
    {
        this.turn = 0;
        this.numberofOrganism = 0;
        this.height = height;
        this.width = width;
        this.grid = grid;
        census = new ArrayList<Organism>();
        map = new int[width][height];

        for (int i = 0; i < height*width*8; i++)
        {
            census.add(null);
        }
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++)
            {
                map[i][j] = -1;
            }
        }
    }
    public void iniMapa()
    {
        done = false;
        this.done = false;
        this.turn = 0;
        this.numberofOrganism = 0;
        Random rand = new Random();

        int maxnumberofOrganizm = width * height / 3;
        int maxSameOrg = maxnumberofOrganizm /8;
        int x =0, y =0;
        int numberofWolfes = 0;
        int numberofFox = 0;
        int numberofSheep = 0;
        int numberofTurtle = 0;
        int numberofAntelope = 0;
        int numberofGrass = 0;
        int numberofDandelion = 0;
        int numberofBlueberries = 0;
        int numberofGuarana = 0;
        int numberofBorsch = 1;
        //ADD Human
        do
        {
            x = rand.nextInt(width);
            y = rand.nextInt(height);
        } while (map[x][y] != -1);
        census.set(numberofOrganism, new Human(this.turn, this, new Coordinates(x,y)));
        map[x][y] = numberofOrganism;
        numberofOrganism++;
        ishuman = true;


        while (this.numberofOrganism < maxnumberofOrganizm && rand.nextInt(maxSameOrg)+2 >numberofAntelope)
        {
            do
            {
                x = rand.nextInt(width);
                y = rand.nextInt(height);
            } while (map[x][y] != -1);

            census.set(numberofOrganism,new Antelope(0, this, new Coordinates(x, y)));
            map[x][y] = numberofOrganism;
            numberofOrganism++;
            numberofAntelope++;
        }
        while (this.numberofOrganism < maxnumberofOrganizm && rand.nextInt(maxSameOrg)+2 >numberofFox)
        {
            do
            {
                x = rand.nextInt(width);
                y = rand.nextInt(height);
            } while (map[x][y] != -1);

            census.set(numberofOrganism,new Fox(0, this, new Coordinates(x, y)));
            map[x][y] = numberofOrganism;
            numberofOrganism++;
            numberofFox++;
        }
        while(this.numberofOrganism < maxnumberofOrganizm && rand.nextInt(maxSameOrg)+2 >numberofSheep)
        {
            do
            {
                x = rand.nextInt(width);
                y = rand.nextInt(height);
            } while (map[x][y] != -1);
            census.set(numberofOrganism,new Sheep(0, this, new Coordinates(x, y)));
            map[x][y] = numberofOrganism;
            numberofOrganism++;
            numberofSheep++;
        }
        while (this.numberofOrganism < maxnumberofOrganizm && rand.nextInt(maxSameOrg)+2 >numberofTurtle)
        {
            do
            {
                x = rand.nextInt(width);
                y = rand.nextInt(height);
            } while (map[x][y] != -1);

            census.set(numberofOrganism,new Turtle(0, this, new Coordinates(x, y)));
            map[x][y] = numberofOrganism;
            numberofOrganism++;
            numberofTurtle++;
        }
        while (this.numberofOrganism < maxnumberofOrganizm && rand.nextInt(maxSameOrg)+2 >numberofWolfes)
        {
            do
            {
                x = rand.nextInt(width);
                y = rand.nextInt(height);
            } while (map[x][y] != -1);

            census.set(numberofOrganism,new Wolf(0, this, new Coordinates(x, y)));
            map[x][y] = numberofOrganism;
            numberofOrganism++;
            numberofWolfes++;
        }
        while (this.numberofOrganism < maxnumberofOrganizm && rand.nextInt(maxSameOrg)+2 >numberofGrass)
        {
            do
            {
                x = rand.nextInt(width);
                y = rand.nextInt(height);
            } while (map[x][y] != -1);

            census.set(numberofOrganism,new Grass(0, this, new Coordinates(x, y)));
            map[x][y] = numberofOrganism;
            numberofOrganism++;
            numberofGrass++;
        }
        while (this.numberofOrganism < maxnumberofOrganizm && rand.nextInt(maxSameOrg)+2 >numberofDandelion)
        {
            do
            {
                x = rand.nextInt(width);
                y = rand.nextInt(height);
            } while (map[x][y] != -1);

            census.set(numberofOrganism,new Dandelion(0, this, new Coordinates(x, y)));
            map[x][y] = numberofOrganism;
            numberofOrganism++;
            numberofDandelion++;
        }
        while (this.numberofOrganism < maxnumberofOrganizm && rand.nextInt(maxSameOrg)+2 >numberofGuarana)
        {
            do
            {
                x = rand.nextInt(width);
                y = rand.nextInt(height);
            } while (map[x][y] != -1);

            census.set(numberofOrganism,new Guarana(0, this, new Coordinates(x, y)));
            map[x][y] = numberofOrganism;
            numberofOrganism++;
            numberofGuarana++;
        }
        while (this.numberofOrganism < maxnumberofOrganizm && rand.nextInt(maxSameOrg)+2 >numberofBlueberries)
        {
            do
            {
                x = rand.nextInt(width);
                y = rand.nextInt(height);
            } while (map[x][y] != -1);

            census.set(numberofOrganism,new Blueberries(0, this, new Coordinates(x, y)));
            map[x][y] = numberofOrganism;
            numberofOrganism++;
            numberofBlueberries++;
        }
        while (this.numberofOrganism < maxnumberofOrganizm && rand.nextInt(maxSameOrg)+2 >numberofBorsch)
        {
            do
            {
                x = rand.nextInt(width);
                y = rand.nextInt(height);
            } while (map[x][y] != -1);

            census.set(numberofOrganism,new Borsch(0, this, new Coordinates(x, y)));
            map[x][y] = numberofOrganism;
            numberofOrganism++;
            numberofBorsch++;
        }
        done = true;
        turn++;
    }
    void driveWorld()
    {
        System.out.print(" ____");
        for (int n = 0; n < this.width - 1; n++)
        {
            System.out.print("____");
        }
        System.out.println();
        for (int i = 0; i < height; i++)
        {
            System.out.print("|");
            for (int j = 0; j < width; j++)
            {
                System.out.print(" ");
                if (map[j][i] == -1)
                {
                    System.out.print(" ");
                }
                else
                {
                    System.out.print(census.get(map[j][i]).getKod());
                }
                System.out.print(" ");
                if(j<width-1)
                    System.out.print("|");
            }
            System.out.println("|");
            if (i < height - 1)
            {
                System.out.print("|");
                for (int x = 0; x < width-1; x++)
                {
                    System.out.print("----");
                }
                System.out.print("---");
                System.out.println("|");
            }

        }
        System.out.print(" ____");
        for (int n = 0; n < this.width - 1; n++)
        {
            System.out.print("____");
        }
    }
    public void fun()
    {
        char commend ='x';
        System.out.println();
        System.out.println("press somethink to start");
        //Scanner scan = new Scanner(System.in);
        //String firstName = scan.nextLine();
        System.out.println();
        driveWorld();
        System.out.println();
        System.out.println("----------------------------------");
        System.out.println("            TURN: "+turn);
        System.out.println("----------------------------------");
        makeTurn();
        System.out.println();
        System.out.println("----------------------------------");
        System.out.println("press q to quit");
        System.out.println("press s to save");
        System.out.println("PRESS TO DO NEXT TURN");
        System.out.println("----------------------------------");
        done = true;
    }
    private void makeTurn()
    {
        this.turn++;
        Event Returnevent = null;
        for (int i = 0; i < numberofOrganism; i++)
        {
            if (census.get(i) == null)
                continue;

            if(census.get(i) != null)
                Returnevent = census.get(i).action();

            if (Returnevent != null)
                eventManager(Returnevent);
        }
        sortOrganism();
    }
    public void eventManager(Event event)
    {

        int x = event.getWho().x;
        int y = event.getWho().y;

        int x2 = event.getWhere().x;
        int y2 = event.getWhere().y;
        Event Returnevent = null;
        Organism parent = census.get(map[x][y]);
        Organism child = parent.newChild(this.turn,event.getWhere());
        if (event == null) return;
        switch (event.getWhat())
        {
            default:
                break;
            case move:
                if (map[x][y] !=-1 )
                {
                    //Sprawdzam czy miejsce w które chce sie udac jest puste
                    if (map[event.getWhere().x][event.getWhere().y] == -1 )
                    {
                        Organism org = census.get(map[x][y]);
                        if (org != null && org.reaction(event))
                        {
                            System.out.println(org.getType()+ " " + map[x][y] +" "+ event.getWho().x + " " + event.getWho().y + "->" + event.getWhere().x + " " + event.getWhere().y);
                            int buf = map[event.getWho().x][event.getWho().y];
                            map[event.getWho().x][event.getWho().y] = -1;
                            map[event.getWhere().x][event.getWhere().y] = buf;
                        }
                    }
                    else if (event.getWhere().x == event.getWho().x && event.getWhere().y == event.getWho().y)
                    {
                        break;
                    }
                    else
                    {
                        Organism attacker = census.get(map[x][y]);
                        Organism defender = census.get(map[x2][y2]);
                        Returnevent = defender.collision(attacker);
                        if (Returnevent != null)
                        {
                            eventManager(Returnevent);
                        }
                    }
                }
                break;
            case killALL:
                if (map[x][y] != -1)
                {
                    for (int i = -1; i < 2; i++)
                    {
                        for (int j = -1; j < 2; j++)
                        {
                            if (x + i<this.width && x + i >=0 && y + j >=0 && y+j < this.height && map[x + i][y + j] != -1 && !(i ==0 &&j ==0))
                            {
                                census.get(map[x][y]).printType();
                                System.out.println(" Kill around ");
                                census.get(map[x + i][y + j]).printType();
                                System.out.println("<" + (x + i) + "," + (y + j) + ">");
                                census.set(map[x + i][y + j],null);
                                int buf = map[x + i][y + j];
                                map[x + i][y + j] = -1;
                            }
                        }
                    }
                }
                //driveWorld();
                break;
            case killALLAnimals:
                if (map[x][y] != -1)
                {
                    for (int i = -1; i < 2; i++)
                    {
                        for (int j = -1; j < 2; j++)
                        {
                            if (x + i < this.width && x + i >= 0 && y + j >= 0 && y + j < this.height && map[x + i][y + j] != -1 && !(i == 0 && j == 0))
                            {
                                Type type = census.get(map[x + i][y + j]).getType();
                                if (type == Type.fox || type == Type.antylopa
                                        || type == Type.human || type == Type.wolf
                                        || type == Type.sheep || type == Type.turtle)
                                {
                                    census.get(map[x][y]).printType();
                                    System.out.println(" Borsch poisoned ");
                                    census.get(map[x + i][y + j]).printType();
                                    System.out.println("<" + (x + i) + "," + (y + j) + ">");
                                    census.set(map[x + i][y + j],null);
                                    int buf = map[x + i][y + j];
                                    map[x + i][y + j] = -1;
                                }
                            }
                        }
                    }
                }
                break;
            case kill:
                Organism attacker = census.get(map[x][y]);
                Organism defender = census.get(map[x2][y2]);
                if (attacker.getStrength() > defender.getStrength())
                {
                    Coordinates temp = defender.getPosition();
                    System.out.println(attacker.getType() + " Zabija "+ defender.getType()+ " "+defender.getPosition().x + " " + defender.getPosition().y );

                    census.set(map[event.getWhere().x][event.getWhere().y],null);
                    map[event.getWhere().x][event.getWhere().y] = -1;
                    eventManager(new Event(attacker.getPosition(), Call.move, temp));
                }
                else
                {
                    System.out.println(defender.getType() + " Zabija "+ defender.getType()+ " "+attacker.getPosition().x + " " + defender.getPosition().y );
                    census.set(map[event.getWho().x][event.getWho().y],null);
                    map[event.getWho().x][event.getWho().y] = -1;
                }
                break;
            case create:
                census.set(numberofOrganism,child);

                map[x2][y2] = numberofOrganism;
                numberofOrganism++;
                System.out.println("Create " + parent.getType() +" "+ event.getWhere().x + " " + event.getWhere().y);
                break;
            case poison:
                System.out.println("Blueberries poision ");
                census.get(map[x][y]).printType();
                System.out.println(event.getWhere());
                census.set(map[event.getWho().x][event.getWho().y],null);
                map[event.getWho().x][event.getWho().y] = -1;
                break;
        }
        event = null;
    }
    private void sortOrganism()
    {
        for (int i = 0; i < numberofOrganism; i++)
        {
            for (int j = 1; j < numberofOrganism; j++)
            {
                if (census.get(j - 1) == null || census.get(j) ==null)
                {
                    continue;
                }
                if (census.get(j - 1).getInitiative() < census.get(j).getInitiative())
                {
                    //zamiana j-1 = j
                    Organism temp = census.get(j - 1);
                    census.set(j - 1,census.get(j));
                    census.set(j,temp);
                    this.sortmap(j-1);
                    //map[x][y] =9
                }
                if (census.get(j - 1).getInitiative() == census.get(j).getInitiative())
                {
                    if (census.get(j - 1).getTurn() > census.get(j - 1).getTurn())
                    {
                        Organism temp = census.get(j - 1);
                        census.set(j - 1,census.get(j));
                        census.set(j,temp);
                        this.sortmap(j - 1);
                    }
                }
            }
        }
    }
    private void sortmap(int j)
    {
        int a1 =-1, a2 =-1, b1 =-1, b2 = -1;
        for (int a = 0; a < this.width; a++)
        {
            for (int b = 0; b < height; b++)
            {
                if(map[a][b] == j)
                {
                    a1 = a;
                    b1 = b;
                }
                else if(map[a][b] == j+1)
                {
                    a2 = a;
                    b2 = b;
                }
            }
        }
        map[a1][b1] = map[a2][b2];
        map[a2][b2] = j ;
    }



    public boolean checkcords(int x,int y)
    {
        if (x <= width-1 && x >= 0 && y >= 0 && y <= height-1)
        {
            return true;
        }
        return false;
    }


    public int getHeight()
    {
        return height;
    }
    public int getWidth()
    {
        return width;
    }
    public int getmapCords(int x,int y)
    {
        return map[x][y];
    }
    public int getOrganismStrenghFrommap(int x, int y)
    {
        return census.get(map[x][y]).getStrength();
    }
    public void load(Scanner czytnik) throws InputMismatchException
    {
        this.turn = czytnik.nextInt();
        czytnik.hasNextByte();
        this.numberofOrganism = czytnik.nextInt();
        czytnik.nextLine();
        for (int index = 0; index < numberofOrganism; index++)
        {
            String input = czytnik.nextLine();
            switch (input.charAt(2))
            {
                case 'A':
                    census.set(index,new Antelope(this.turn, this,new Coordinates(0, 0))) ;
                    break;
                case 'C':
                    census.set(index,new Human(this.turn, this,new Coordinates(0, 0))) ;
                    break;
                case 'W':
                    census.set(index,new Wolf(this.turn, this,new Coordinates(0, 0))) ;
                    break;
                case 'S':
                    census.set(index,new Sheep(this.turn, this,new Coordinates(0, 0))) ;
                    break;
                case 'F':
                    census.set(index,new Fox(this.turn, this,new Coordinates(0, 0))) ;
                    break;
                case 'T':
                    census.set(index,new Turtle(this.turn, this,new Coordinates(0, 0))) ;
                    break;
                case 'G':
                    census.set(index,new Grass(this.turn, this,new Coordinates(0, 0))) ;
                    break;
                case '#':
                    census.set(index,new Dandelion(this.turn, this,new Coordinates(0, 0))) ;
                    break;
                case '+':
                    census.set(index,new Guarana(this.turn, this,new Coordinates(0, 0))) ;
                    break;
                case 'B':
                    census.set(index,new Blueberries(this.turn, this,new Coordinates(0, 0))) ;
                    break;
                case 'X':
                    census.set(index,new Borsch(this.turn, this,new Coordinates(0, 0))) ;
                    break;
            }
            census.get(index).load(input);
            map[census.get(index).getPosition().x][census.get(index).getPosition().y] = index;

        }
        //this.okienko.loadPaint();
    }
    public Type getmapType(int x,int y)
    {
        return census.get(map[x][y]).getType();
    }
    public int getTurn(){
        return this.turn;
    }
    public boolean addOrg(int chosen,Coordinates Cords)
    {
        switch(chosen)
        {
            default:
                return false;
            case 0: //Nie Wybrano
                return false;
            case 1: // human
                if (this.ishuman == false)
                {
                    census.set(this.numberofOrganism,new Human(this.turn,this,new Coordinates(Cords)));
                    map[Cords.x][Cords.y] = numberofOrganism;
                    this.numberofOrganism++;
                    this.ishuman = true;
                }
                break;
            case 2:// Owca
                census.set(this.numberofOrganism,new Sheep(this.turn,this,new Coordinates(Cords)));
                map[Cords.x][Cords.y] = numberofOrganism;
                this.numberofOrganism++;
                break;
            case 3:// fox
                census.set(this.numberofOrganism,new Fox(this.turn,this,new Coordinates(Cords)));
                map[Cords.x][Cords.y] = numberofOrganism;
                this.numberofOrganism++;
                break;
            case 4: // wolf
                census.set(this.numberofOrganism,new Wolf(this.turn,this,new Coordinates(Cords)));
                map[Cords.x][Cords.y] = numberofOrganism;
                this.numberofOrganism++;
                break;
            case 5: // turtle
                census.set(this.numberofOrganism,new Turtle(this.turn,this,new Coordinates(Cords)));
                map[Cords.x][Cords.y] = numberofOrganism;
                this.numberofOrganism++;
                break;
            case 6: // Antylopa"
                census.set(this.numberofOrganism,new Antelope(this.turn,this,new Coordinates(Cords)));
                map[Cords.x][Cords.y] = numberofOrganism;
                this.numberofOrganism++;
                break;
            case 7: //grass
                census.set(this.numberofOrganism,new Grass(this.turn,this,new Coordinates(Cords)));
                map[Cords.x][Cords.y] = numberofOrganism;
                this.numberofOrganism++;
                break;
            case 8 : //dandelion
                census.set(this.numberofOrganism,new Dandelion(this.turn,this,new Coordinates(Cords)));
                map[Cords.x][Cords.y] = numberofOrganism;
                this.numberofOrganism++;
                break;
            case 9:// Guarana
                census.set(this.numberofOrganism,new Guarana(this.turn,this,new Coordinates(Cords)));
                map[Cords.x][Cords.y] = numberofOrganism;
                this.numberofOrganism++;
                break;
            case 10:// Blueberries
                census.set(this.numberofOrganism,new Blueberries(this.turn,this,new Coordinates(Cords)));
                map[Cords.x][Cords.y] = numberofOrganism;
                this.numberofOrganism++;
                break;
            case 11://Borsch
                census.set(this.numberofOrganism,new Borsch(this.turn,this,new Coordinates(Cords)));
                map[Cords.x][Cords.y] = numberofOrganism;
                this.numberofOrganism++;
                break;
        }
        return true;
    }
    public void humanmove(int next,boolean supermoc)
    {
        for(int i = 0 ; i < this.numberofOrganism;i++)
        {
            if(this.census.get(i) instanceof Human)
            {
                ((Human)this.census.get(i)).getKeyBoard(next,supermoc);
                break;
            }
        }
    }
    public void save()
    {
        int numofOrg =0;
        FileWriter myWriter;
        try
        {
            myWriter = Main.save();
            //grid
            myWriter.write(String.valueOf( this.grid));
            myWriter.write(System.getProperty( "line.separator" ));
            //M N
            myWriter.write(String.valueOf(this.height));
            myWriter.write(" ");
            myWriter.write(String.valueOf(this.width));
            myWriter.write(System.getProperty( "line.separator" ));
            //tura & ilosc organizmow
            myWriter.write(String.valueOf(this.turn));
            myWriter.write(" ");
            for (Organism organism : census)
            {
                if (organism != null)
                {
                    numofOrg++;
                }
            }
            myWriter.write(String.valueOf(numofOrg));
            myWriter.write(System.getProperty( "line.separator" ));
            //reszta:
            for (int index = 0; index < numberofOrganism; index++)
            {
                if ( census.get(index) !=null)
                {
                    String odp = census.get(index).save();
                    myWriter.write(odp);
                    myWriter.write(System.getProperty( "line.separator" ));
                }

            }
            myWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Nie udało się zapisać gry");
            return;
        }


    }
    public int getnumberofOrg()
    {
        return numberofOrganism;
    }


}

