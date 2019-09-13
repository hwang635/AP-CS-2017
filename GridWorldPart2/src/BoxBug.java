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
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/**
 * A <code>BoxBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class BoxBug extends Bug
{
	private int steps;
	private int sideLength;

	/**
	 * Constructs a box bug that traces a square of a given side length
	 * @param length the side length
	 */
	public BoxBug(int length)
	{
		steps = 0;
		sideLength = length;
	}

	/**
	 * Moves to the next location of the square.
	 */
	/*public void act()
    {
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
            turn();
            turn();
            steps = 0;
        }
    } */

	/**
	 * Tests whether this bug can move forward into a location that is empty or
	 * contains a flower.
	 * @return true if this bug can move.
	 */
	public boolean canMove()
	{
		if(super.canMove() && steps<sideLength) {
			return true;
		} else {
			return false;
		}
	}

	public void move() {
		super.move();
		steps++;
	}

	public void turn() {
		super.turn();
		super.turn();
		steps = 0;
	}

	/**
	 * Adds or subtracts from the sideLength
	 * @param x the integer number that will be added to the sidelength
	 * @post the field sideLength will be modified
	 */
	public void addSideLength(int x) {
		sideLength += x;
	}
	
	public int getSteps() {
		return steps;
	}
}
