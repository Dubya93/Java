import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hero here.
 * 
 * @ Mikal Eddlemon & Warren Wright
 * @ May 12th, 2021
 */
public class Hero extends SmoothMover
{
    private static final int gunReloadTime = 5;
    private int reloadDelayCount;
    
    
    private GreenfootImage hero = new GreenfootImage("Hero.png");
    private GreenfootImage heroleft = new GreenfootImage("Heroleft.png");
    
    public Hero()
    {
        reloadDelayCount = 2;
    }
    
    
    /**
     * Act - do whatever the Hero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       checkKeyPress();
       checkCollision();
       reloadDelayCount++;
    }
    
    private void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("up")) 
        {
            setLocation(getX(), getY()-2);
        }
        
        if (Greenfoot.isKeyDown("down")) 
        {
            setLocation(getX(), getY()+2);
        }
        
        if (Greenfoot.isKeyDown("right")) 
        {
            setLocation(getX()+2, getY());
            setImage(hero);
            
        }
        
        if (Greenfoot.isKeyDown("left")) 
        {
            setLocation(getX()-2, getY());
            setImage(heroleft);
        }
        
        if (Greenfoot.isKeyDown("space")) 
        {
            fire();
        }
    }
    
    private void checkCollision()
    {
        if (isTouching(Zombie.class)) 
        {
            Greenfoot.playSound("slurp.wav");
            ZombieLand zombieland = (ZombieLand) getWorld();
            zombieland.addObject(new Death(), getX(), getY());
            zombieland.removeObject(this);
            zombieland.gameOver();
        }
    }
    
    private void fire() 
    {
        if (getImage() == heroleft && reloadDelayCount >= gunReloadTime) 
        {
            Bullet bullet = new Bullet();
            bullet.setRotation(180);
            getWorld().addObject (bullet, getX(), getY());
            bullet.move(5);
            reloadDelayCount = 0;
            
        }
        
        else if (getImage() == hero && reloadDelayCount >= gunReloadTime) 
            {
                Bullet bullet = new Bullet();
                bullet.setRotation(0);
                getWorld().addObject (bullet, getX(), getY());
                bullet.move(5);
                reloadDelayCount = 0;
            }
        
    }
}
