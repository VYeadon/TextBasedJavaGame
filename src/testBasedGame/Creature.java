package testBasedGame;

import java.util.Random;

public abstract class Creature
{
	boolean alive;
	
	public int attack;
	public int defense;
	public int speed;
	public int intelligence;
	public int[][] position;

	String name;
	

	public Creature() 
	{
		// The position array for each creature is generated when a new isntance is created
		this.position = new int[10][10]; 
	}
	
	// Creates stats for both the user character and enemies
	// user stats are generated from three different builds
	// enemy stats are reandomly generated
	public void getStats(int type)
	{
		// no error checking is required for this method as all has been done in the previous method
		// only the three following inputs can pass through

		// Random generator is derived which is used to generate enemy stats
		// It is called here as user stats will be updated based on a levelling system if there is enough time
		Random rand = new Random();

		// ---------------- Warrior class stats ----------------------------------
		if (type == 1)
		{
			this.attack = 10;
			this.defense = 10;
			this.speed = 2;
			this.intelligence = 2;

		}
		// --------------------------------------------------------------------

		// ---------------- Mage class stats ----------------------------------------
		else if (type == 2)
		{
			this.attack = 10;
			this.defense = 10;
			this.speed = 2;
			this.intelligence = 2;

		}

		// ----------------- Rogue Class stats -----------------------------------------
		else if (type == 3)
		{
			this.attack = 10;
			this.defense = 10;
			this.speed = 2;
			this.intelligence = 2;
		}
		// -----------------------------------------------------------------------

		// ------------------ Enemy Class stats ---------------------------------------
		else if (type == 4)
		{
			this.attack = rand.nextInt(10) + 1;
			this.defense = rand.nextInt(10) + 1;
			this.speed = rand.nextInt(10) + 1;
			this.intelligence = rand.nextInt(10) + 1;
		}
		//---------------------------------------------------------------------------	
	}

}
