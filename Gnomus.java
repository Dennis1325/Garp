import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gnomus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gnomus extends Actor
{
    /**
     * Act - do whatever the Gnomus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        int random;
        
        move(5);
        if(atWorldEdge()) {
            move(-5);
            if(Greenfoot.getRandomNumber(100) < 50) {
                setRotation(getRotation() + Greenfoot.getRandomNumber(180));
            }
            else {
                setRotation(getRotation() - Greenfoot.getRandomNumber(180));
            }
        }
        else {  //Als je niet aan de rand van de wereld bent.
            random = Greenfoot.getRandomNumber(100);
            if (random < 2) { // 2% kans naar Rechts
                setRotation(getRotation() + Greenfoot.getRandomNumber(180));
            }
            if (random > 98) { // 2% kans naar Links
                setRotation(getRotation() - Greenfoot.getRandomNumber(180));
            }
        }
    }
    protected boolean atWorldEdge(){
        int x, i, y, wx, wy;
        
        x = getX(); //Vraag op waar Gnomus is ten opzichte van de linkerrand
        i = getImage().getWidth()/2; //Vraag de breedte van de afbeelding en deel deze door twee
        if(x <= i) {
            return true;
        }
        //Bovenkant
        y = getY();
        if(y <= i) {
            return true;
        }
        //Rechterkant
        wx = getWorld().getWidth() - i;
        if(x >= wx) {
            return true;
        }
        //Onderkant
        wy = getWorld().getHeight() - i;
        if(y >= wy) {
            return true;
        }
        return false;
    }
}
