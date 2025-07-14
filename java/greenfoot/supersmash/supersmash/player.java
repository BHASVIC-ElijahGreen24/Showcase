import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class player extends Actor
{
    /**
     * Act - do whatever the player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int id = -1;
    double x = 0;
    double y = 0;
    double xvel = 0;
    double yvel = 0;
    int dir = 1;
    double hitcooldown = System.currentTimeMillis() / 1000;
    
    public void act() {
        World w = getWorld();
        if(((x == 0 && y == 0) || isAtEdge()) && id == 0) { // set starting stuff for player 1
            x = (int)(w.getWidth() * 0.25);
            y = (int)(w.getHeight() * 0.6);
            xvel = 0;
            yvel = 0;
            setImage(new GreenfootImage("seahorseright.png"));
        } else if(((x == 0 && y == 0) || isAtEdge()) && id == 1) { // set starting stuff for player 2
            x = (int)(w.getWidth() * 0.75);
            y = (int)(w.getHeight() * 0.6);
            xvel = 0;
            yvel = 0;
            setImage(new GreenfootImage("flowerleft.png"));
        }
        
        // vertical motion
        smallplat floaty = (smallplat)getOneObjectAtOffset(0, (int)(getImage().getHeight()/2 + 1), smallplat.class);
        bigplat floor = (bigplat)getOneObjectAtOffset(0, (int)(getImage().getHeight()/2 + 1), bigplat.class);
        
        if(floor == null) {
            yvel += 0.3;
        } else {
            yvel = 0;
            y = floor.getY() - floor.getImage().getHeight()/2 - getImage().getHeight()/2 - 1;
        }
        
        if(((Greenfoot.isKeyDown("w") && id == 0) || (Greenfoot.isKeyDown("up") && id == 1)) && floor != null) {
            yvel = -10;
        }
        
        y += yvel;
        
        if(((Greenfoot.isKeyDown("space") && id == 0) || (Greenfoot.isKeyDown("l") && id == 1)) && hitcooldown - System.currentTimeMillis() / 1000 <= 0) {
            player toattack = (player)getOneObjectAtOffset​(2 * dir, 0, player.class);
            if(toattack != null) {
                toattack.hit(dir * 4, -4);
                hitcooldown = System.currentTimeMillis() / 1000 + 1;
            }
        }
        
        // horizontal motion
        floaty = (smallplat)getOneObjectAtOffset(0, getImage().getHeight()/2, smallplat.class);
        floor = (bigplat)getOneObjectAtOffset(0, getImage().getHeight()/2, bigplat.class);
        
        if(id == 0) {
            if(Greenfoot.isKeyDown("d")) {
                setImage(new GreenfootImage("seahorseright.png"));
                xvel += 0.4;
                dir = 1;
            }
            if(Greenfoot.isKeyDown("a")) {
                setImage(new GreenfootImage("seahorseleft.png"));
                xvel -= 0.4;
                dir = -1;
            }
        } else if(id == 1) {
            if(Greenfoot.isKeyDown("right")) {
                setImage(new GreenfootImage("flowerright.png"));
                xvel += 0.4;
                dir = 1;
            }
            if(Greenfoot.isKeyDown("left")) {
                setImage(new GreenfootImage("flowerleft.png"));
                xvel -= 0.4;
                dir = -1;
            }
        }
        
        xvel *= 0.97;
        
        x += xvel;
        
        if(isTouching(bigplat.class)) {
            x -= xvel;
            xvel = 0;
        }
        
        setLocation((int)x, (int)y);
    }
    
    public player(int ide) {
        id = ide;
    }
    
    public void hit(double xvelm, double yvelm) {
        xvel += xvelm;
        yvel += yvelm;
    }
}
