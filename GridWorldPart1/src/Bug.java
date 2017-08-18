/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 */


import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * A <code>Bug</code> is an actor that can move and turn. It drops flowers as
 * it moves. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class Bug extends Actor
{
	Color bug;
	boolean couldMove;
	//does slightly diff steps every 8, 12 steps
	int steps = 0;
	//counts how many times can't move, turns red every 5th time
	int count = 0;
	
    /**
     * Constructs a red bug.
     */
    public Bug()
    {
    	bug = Color.CYAN;
        setColor(Color.CYAN);
    }

    /**
     * Constructs a bug of a given color.
     * @param bugColor the color for this bug
     */
    public Bug(Color bugColor)
    {
    	setColor(bugColor);
        bug = bugColor;
    }

    /**
     * Moves if it can move, turns otherwise.
     */
    
    public void act()
    {
    	if(couldMove == true)
    		bug = getColor();
        Color Purple = new Color(109,0,139);

        if (canMove()) {
        	if(couldMove == false)
        		setColor(bug);
        	
            move();
            couldMove = true;
            steps++;
            
            if(steps == 8) {
            	turn();
            	if(canMove()) {
            		move();
            		turn();
            	}
            }
            else if(steps == 12) {
            	turnLeft();
            	steps = 0;
            }

        }
        else {
            turn();
            couldMove = false;
            count++;
 
            setColor(Purple);
            
            if(count == 5) {
            	setColor(Color.RED);
            	count = 0;
            }
        }
    }

    /**
     * Turns the bug 45 degrees to the right without changing its location.
     */
    public void turn()
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
        setDirection(getDirection() + Location.HALF_RIGHT);
    }

    public void turnLeft()
    {
        setDirection(getDirection() + Location.HALF_LEFT);
        setDirection(getDirection() + Location.HALF_LEFT);
    }
    /**
     * Moves the bug forward, putting a flower into the location it previously
     * occupied.
     */
    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
        Flower flower = new Flower(getColor());
        flower.putSelfInGrid(gr, loc);
    }

    /**
     * Tests whether this bug can move forward into a location that is empty or
     * contains a flower.
     * @return true if this bug can move.
     */
    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        return (neighbor == null) || (neighbor instanceof Flower);
        // ok to move into empty location or onto flower
        // not ok to move onto any other actor
    }
}
