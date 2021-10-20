import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * Mikal Eddlemon 
 * @version (a version number or a date)
 */
public class Bullet extends SmoothMover
{
    // bullet looses on life each act
    private int life = 100;
    //damage this bullet does
    private static final int damage = 2;
    
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Bullet()
    { 
        super();
        Greenfoot.playSound("EnergyGun.wav");
    }
    
    public void act()
    {
        life--;
        if(life <= 0)
        {
            getWorld().removeObject(this);
        }
        else
        {
            if (!isAtEdge()) 
            {
            
                move(5);
                checkZombieHit();
            
            }
            else
            {
            getWorld().removeObject(this);
            }
        }
    }
    private void checkZombieHit()
    {
        Zombie zombie = (Zombie) getOneIntersectingObject(Zombie.class);
        if(zombie != null)
        {
            zombie.hit(damage);
            getWorld().removeObject(this);
        }
    }
}
