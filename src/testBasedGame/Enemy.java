package testBasedGame;

import java.util.Random;

public class Enemy extends Creature {

	public Enemy() 
	{
		// Creates an enemy using the getStats method from the super class Creature
		// The 4 input represents the getStats option for enemy stat creation
		this.getStats(4);
		
		Random rand = new Random();
		
		// Places an enemy at a random location on the map when a new instance is generated
		this.position[rand.nextInt(10)][rand.nextInt(10)] = 1;
		
		//Creates valdiation token and do loop to ensure that the enemy is not placed on the users tile
		// This users position has been arbitarly chosen by me and is not generated
		boolean valid = false;
		do
		{
			// If the enemy is placed at the same position of the character a new enemy instance is created
			if (this.position[5][5] == 1)
			{
				this.position[rand.nextInt(10)][rand.nextInt(10)] = 1;
			}
			// Any other postion of the enemy is valid
			else
			{
				valid = true;
			}
		}	
		while(!valid);
		
		
	}

}
