import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shrub here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shrub extends Actor
{
    private int size;
    
    public Shrub()
    {
        this(1);
    }
    
    public Shrub(int size)
    {
        setSize(size);
    }
    
    public void setSize(int size)
    {
        this.size = size;
    }
    
    public int getSize()
    {
        return size;
    }
       
}    

