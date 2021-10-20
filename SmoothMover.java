import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A variation of an actor that maintains precise location (using doubles for the co-ordinates
 * instead of ints). It also maintains a current velocity in form of a velocity vector.
 * 
 * This is a variation of the SmoothMover class presented ealier in the book (version 2.0).
 * This version implements wrap-around movement: when the actor moves out of the world at one
 * side, it enters it again at the opposite edge.
 * 
 * @author Poul Henriksen
 * @author Michael Kölling
 * 
 * @version 2.3
 */
public abstract class SmoothMover extends Actor
{
    
    public SmoothMover()
    {
        
    }
}
    