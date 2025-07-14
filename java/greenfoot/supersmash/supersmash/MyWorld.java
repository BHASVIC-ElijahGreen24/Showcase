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
        super(1200, 700, 1);
        
        addObject(new bigplat(), getWidth()/2, (int)(getHeight() * 0.75));
        addObject(new smallplat(), (int)(getWidth() * 0.2), getHeight()/2);
        addObject(new smallplat(), getWidth()/2, (int)(getHeight() * 0.35));
        addObject(new smallplat(), (int)(getWidth() * 0.8), getHeight()/2);
        
        addObject(new player(0), (int)(getWidth() * 0.25), (int)(getHeight() * 0.6));
        addObject(new player(1), (int)(getWidth() * 0.75), (int)(getHeight() * 0.6));
    }
}
