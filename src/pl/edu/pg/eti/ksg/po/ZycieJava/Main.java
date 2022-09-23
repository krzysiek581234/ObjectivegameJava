package pl.edu.pg.eti.ksg.po.ZycieJava;
import pl.edu.pg.eti.ksg.po.ZycieJava.style.*;
import pl.edu.pg.eti.ksg.po.ZycieJava.World;
import pl.edu.pg.eti.ksg.po.ZycieJava.style.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static final String path = "Saves\\save.txt";
    public static void main(String[] args) {
        int width = 10;
        int height = 10;
        boolean grid = true;

        Menu mainmenu = new Menu(width,height);
        while(mainmenu.isActive() || mainmenu.getnotrun());

        if(mainmenu.getActive(0)== true)
        {
            width = mainmenu.MenugetWidth();
            height = mainmenu.MenugetHeight();
            World funWorld =  new World(height,width,mainmenu.grid);
            Aplication app = new Aplication(funWorld,mainmenu.grid,false);
            while(app.isActive() || app.getnorun());

        }
        if(mainmenu.getActive(1)== true)
        {
            Scanner czytnik;
            try
            {
                czytnik =  Main.load();
            }
            catch(FileNotFoundException e)
            {
                System.out.println("No such file.");
                return;
            }
            //odczytanie danych:
            boolean NewGrid;
            int NewM;
            int NewN;
            try
            {
                NewGrid = czytnik.hasNextBoolean();
                czytnik.nextLine();
                NewM = czytnik.nextInt();
                czytnik.hasNextByte();
                NewN = czytnik.nextInt();
                czytnik.nextLine();

            }
            catch ( InputMismatchException e)
            {
                System.out.println("Mallitious Save File.");
                return;
            }
            World funWorld = new World(NewM, NewN, NewGrid);
            try
            {
                funWorld.load(czytnik);
                Aplication app = new Aplication(funWorld,mainmenu.grid,true);
                while(app.isActive() || app.getnorun());
            }
            catch ( InputMismatchException e)
            {
                System.out.println("Mallitious Save File.");
                return;
            }
            czytnik.close();
        }
        else if(mainmenu.getActive(3)== true)
        {
            return;
        }
        //System.out.println("Krzysztof Madajczak 188674");
    }
    public static FileWriter save() throws IOException
    {
        //zapisanie obecnej gry
        File savePlik = new File(path);
        FileWriter myWriter = new FileWriter(savePlik);
        return myWriter;

    }
    private static Scanner load() throws FileNotFoundException
    {
        //wczytanie starej gry:
        File savePlik = new File(path);
        System.out.println(savePlik.exists());
        Scanner czytnik = new Scanner(savePlik);
        return czytnik;
    }
}
