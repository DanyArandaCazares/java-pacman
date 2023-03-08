import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1); 
        prepare();
        setBackground("images/BG.PNG");
    }
    
    private void prepare(){
        addObject(new pacman(), 30, 50);
        addObject(new apple(), 275, 210);
        addObject(new cherry(), 510, 150);
        addObject(new strawberry(), 510, 35);
        addObject(new point(), 100, 425);
        addObject(new point(), 200, 425);
        addObject(new point(), 300, 425);
        addObject(new point(), 400, 425);
        addObject(new point(), 500, 425);
        addObject(new point(), 600, 425);
        addObject(new Ghost(), 100, 425);
        addObject(new wall(), 330, 290);
        addObject(new wall(), 330, 250);
        addObject(new wall(), 330, 210);
        addObject(new wall(), 330, 170);
        addObject(new wall(), 330, 130);
        addObject(new wall(), 330, 90);
        addObject(new wall(), 210, 90);
        addObject(new wall(), 170, 90);
        addObject(new wall(), 130, 90);
        addObject(new wall(), 90, 90);
        addObject(new wall(), 90, 130);
        addObject(new wall(), 90, 330);
        addObject(new wall(), 90, 290);
        addObject(new wall(), 130, 330);
        addObject(new wall(), 170, 330);
        addObject(new wall(), 210, 330);
        addObject(new wall(), 250, 330);
        addObject(new wall(), 250, 90);
        addObject(new wall(), 290, 330);
        addObject(new wall(), 210, 210);
        addObject(new wall(), 330, 330);
        addObject(new wall(), 290, 90);
        addObject(new wall(), 450, 170);
        addObject(new wall(), 450, 130);
        addObject(new wall(), 450, 90);
        addObject(new wall(), 490, 90);
        addObject(new wall(), 530, 90);
        addObject(new wall(), 570, 90);
        addObject(new wall(), 570, 130);
        addObject(new wall(), 570, 170);
        addObject(new wall(), 450, 340);
        addObject(new wall(), 570, 300);
        addObject(new wall(), 570, 340);
        addObject(new wall(), 450, 300);
        addObject(new Ghost(), 510, 235);
    }
}
