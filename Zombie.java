import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Zombie here.
 * 
 * @ Mikal Eddlemon & Warren Wright
 * @ May 12th, 2021
 */
public class Zombie extends SmoothMover
{
    // Health of the Zombie
    private int health;
    
    
    public Zombie(int health)
    {
        setHealth(health);
    }
    
    public void act()
    {
        checkCollision();
        goTo();
    }
    
    // Code to make the Zombies chase after the Hero.
    public void goTo()
    {
        if (!getWorld().getObjects(Hero.class).isEmpty())
        {
            Hero hero = getWorld().getObjects(Hero.class).get(0);
        
    
            int heroX = hero.getX();
            int heroY = hero.getY();
            turnTowards(heroX, heroY);
            move(1);
        }
    }
    
    
    
    public void hit(int damage)
    {
        health = health - damage;
        if (health <= 1)
        {
            ZombieLand zombieland = (ZombieLand) getWorld();
            zombieland.countScore();
            getWorld().removeObject(this);
        }
                
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public void setHealth(int health)
    {
        this.health = health;
    }
    
    public void checkCollision()
    {
        Shrub s = (Shrub) getOneIntersectingObject(Shrub.class);
        if (s != null)
        {
            int sX = s.getX();
            int sY = s.getY();
            turnTowards(sX+1, sY+1);
            move(-20);
        }
    }
}    

