import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GarpsWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GarpsWorld extends World
{
    private GreenfootSound sound;
    private Counter counter;
    private EndScore endScore;
    /**
     * Constructor for objects of class GarpsWorld.
     * 
     */
    public GarpsWorld()
    {    
        // Create a new world with 700x500 cells with a cell size of 1x1 pixels.
        super(700, 500, 1); 
        populateTheWorld();
        sound = new GreenfootSound("musicmix.mp3");
    }
    
    protected void populateTheWorld()
    {
        int teller;
        int regel, kolom;
        
        addObject(new Garp(), getWidth()/2, getHeight()/2);
        addObject(new Gnomus(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        for(teller  = 0; teller < 10; teller ++){
            addObject(new Diamond(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
        for(teller  = 0; teller < 6; teller ++){
            addObject(new Rock(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
        for(teller  = 0; teller < 4; teller ++){
            addObject(new Bomb(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
        counter = new Counter();
        regel = getHeight() - counter.getImage().getHeight() / 2 - 2;
        kolom = counter.getImage().getWidth() / 2 + 1;
        addObject(counter, kolom, regel);
        setPaintOrder(Counter.class, Garp.class, Gnomus.class, Diamond.class, Bomb.class, Rock.class);
    }
    
    public void started(){
        endScore = new EndScore();
        sound.playLoop();
    }
     public void stopped(){
         int score;
         score = counter.getScore();
         endScore.setEndImage(score);
         addObject(endScore, getWidth()/2, getHeight()/2);
         
         sound.stop();
    }
    
}
