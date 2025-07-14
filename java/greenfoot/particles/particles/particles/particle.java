import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class particle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class particle extends Actor
{
    /**
     * Act - do whatever the particle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    double speed = 0.0001;
    double gravity = -0.2;
    double vx = 0;
    double vy = 0;
    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        double d = 0;
        if(mouse != null) {
            d = Math.pow(Math.pow(Math.abs(getX() - mouse.getX()), 2) + Math.pow(Math.abs(getY() - mouse.getY()), 2), 0.5);
            if(mouse.getX() < getX()) {
                vx = vx - speed * d;
            } else {
                vx = vx + speed * d;
            }
            if(mouse.getY() < getY()) {
                vy = vy - speed * d;
            } else {
                vy = vy + speed * d;
            }
        } else {
            vy = vy - gravity;
        }
        
        int nx = getX() + (int)vx;
        int ny = getY() + (int)vy;
        
        if(nx <= 0 || nx >= getWorld().getWidth()) {
            vx = vx * -0.9;
            nx = getX() + (int)vx;
        }
        if(ny <= 0 || ny >= getWorld().getHeight()) {
            vy = vy * -0.9;
            ny = getY() + (int)vy;
        }
        vx = vx * 0.999;
        vy = vy * 0.999;
        setLocation(nx, ny);
    }
}
