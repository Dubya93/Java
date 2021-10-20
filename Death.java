import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Death1 here.
 * 
 * Mikal Eddlemon 
 * @version (a version number or a date)
 */
public class Death extends Actor
{
    /**
     * Act - do whatever the Death1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage death = new GreenfootImage("Puddle.png");
    
    public void act() 
    {
        setImage(death);
    }   
}
