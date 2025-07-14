import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ambulance here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ambulance extends Actor
{
    /**
     * Act - do whatever the Ambulance wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int x = 172;
    int y = 40;
    String[][] display = new String[y][x];
    int px = 50;
    int py = 20;
    double pvx = 0;
    double pvy = 0;
    
    public void act()
    {
        if(display[0][0] != " ") {
            for(int i = 0; i < y; i++) {
                for(int j = 0; j < x; j++) {
                    display[i][j] = " ";
                }
            }
        }
        
        display[py][px] = " ";
        
        if(Greenfoot.isKeyDown("d")) {
            pvx += 1;
        }
        if(Greenfoot.isKeyDown("a")) {
            pvx -= 1;
        }
        if(Greenfoot.isKeyDown("w")) {
            pvy -= 1;
        }
        if(Greenfoot.isKeyDown("s")) {
            pvy += 1;
        }
        
        pvx *= 0.9;
        pvy *= 0.9;
        
        if(px + (int)pvx > 0 && px + (int)pvx < x) {
            px += (int)pvx;
        }
        if(py + (int)pvy > 0 && py + (int)pvy < y) {
            py += (int)pvy;
        }
        
        display[py][px] = "x";
        
        //System.out.println(new String(new char[x]).replace("\0", "-"));
        for(int i = 0; i < y; i++) {
            String out = "";
            for(int j = 0; j < display[i].length; j++) {
                out += display[i][j];
            }
            System.out.println(out);
        }
        //System.out.println(new String(new char[x]).replace("\0", "-"));
    }
}
