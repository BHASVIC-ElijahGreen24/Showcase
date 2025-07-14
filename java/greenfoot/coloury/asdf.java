import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class asdf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class asdf extends Actor
{
    /**
     * Act - do whatever the asdf wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    double time = 1;
    public void act()
    {
        World w = getWorld();
        GreenfootImage img = new GreenfootImage(w.getWidth(), w.getHeight());
        GreenfootImage bg = w.getBackground();
        MouseInfo mouse = Greenfoot.getMouseInfo();
        double d = 0;
        if(mouse != null) {
            for(int x = 0; x < w.getWidth(); x++) {
                for(int y = 0; y < w.getHeight(); y++) {
                    d = Math.pow(Math.pow(Math.abs(x - mouse.getX()), 2) + Math.pow(Math.abs(y - mouse.getY()), 2), 0.5);
                    double xymod = (x + y - w.getWidth() / 2 - w.getHeight() / 2);
                    Color clr = new Color((int)Math.abs((d + time) * (xymod + 150) * 0.006) % 200 + 20, (int)Math.abs((d + time) * (xymod) * 0.006) % 200 + 20, (int)Math.abs((d + time) * (xymod + 100) * 0.006) % 200 + 20);
                    img.setColorAt(x,y,clr);
                }
            }
            //time = time * 1.02;
        }
        bg.drawImage(img, 0, 0);
    }
}
