import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.util.List;

/**
 * ZombieLand the Game is set in a green field with zombies always spawning. Shoot them to increase your score. If they touch you, you lose!
 * 
 * @ Mikal Eddlemon & Warren Wright
 * @ May 12th, 2021
 */
public class ZombieLand extends World
{

    Counter counter = new Counter("Score: ");
    private int numberOfShrubs = getRandomNumber(6,9);
    private int numberOfZombies = 2;
    private int score = 0;
    private int zombieCount = 0;
    public ZombieLand()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        prepare();
        addObject(counter,50,575);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        
        Hero hero = new Hero();
        addObject(hero,getRandomNumber(550,800) ,getRandomNumber(0,600));
        addShrubs(numberOfShrubs);
        addZombies(numberOfZombies);
    }
    
    private void addShrubs(int count)
    {
        for(int i = 0; i < count; i++) 
        {
            int x = getRandomNumber(300,500);
            int y = getRandomNumber(0,600);
            addObject(new Shrub(), x, y);
        }
    }
    
    private void addZombies(int count)
    {
        for(int j = 0; j < count; j++)
        {
            int x = getRandomNumber(0,250);
            int y = getRandomNumber(0,600);
            addObject(new Zombie(5), x, y);
        }
    }
    
    public void gameOver()
    {
        addObject(new ScoreBoard(score), getWidth()/2, getHeight()/2);
    }
    
    public void countScore()
    {
        score = score +1;
        counter.act();
        counter.getValue();
        counter.add(score);
        counter.setValue(score);
        countZombies();
        addMoreZombies();
    }
    
    public int getRandomNumber(int start, int end)
    {
        int normal = Greenfoot.getRandomNumber(end-start+1);
        return normal+start;
    }
    
    public int countZombies()
    {
        List<Integer> zombies = new ArrayList<Integer>();
        zombieCount = getObjects(Zombie.class).size();
        for(int x = 0; x<= zombieCount; x++)
        {
            zombies.add(x);
        }
        return zombieCount;
    }
    
    public void addMoreZombies()
    {
        
        if(zombieCount <= 1)
        {
            numberOfZombies = numberOfZombies + 1;
            addZombies(numberOfZombies);
        }
    }
}
