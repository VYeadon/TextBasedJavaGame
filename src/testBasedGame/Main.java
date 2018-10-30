package testBasedGame;

import java.util.Scanner;

// imports the class needed to compare if the two position arrays are equal
import java.util.Arrays;


public class Main {
	
	public static void main(String[] args)
	{	
		Main thisRun = new Main();
		
		thisRun.runThrough();
	}
	
	
	// This method runs through the flow of the game
	// gives the introduction invoking other methods to carry out the gameplay
	public void runThrough()
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to your adventure... ");
		
		// Create user character
		Creature player = CreatureFactory.getCreature("CHARACTER");
		
		// Creates an enemy character with its postion
		// Checking has been implemented in enemy constructor
		// Checking ensures that enemy is not placed at the user postition
		Creature enemy = CreatureFactory.getCreature("ENEMY");
		
		// introduction when the game is started
		System.out.println(player.name + " you have been tasked to kill a monster haunting a local village. ");
		System.out.println();
		System.out.println("You set out at night. It's the only time the monster reveals itself. ");
		System.out.println();
		System.out.println("Your journey starts on a dark and dreary plain. ");
		System.out.println();
		System.out.println("You can't see much. ");
		System.out.println();
		System.out.println("Luckily you have a magic compass that will point you in the direction of the monster. ");
		
		// initlises the position arrays
		// Gets the players position
		int[] playerPosition = this.getCreaturePosition(player);
		// Gets the enemy's position 
		int[] enemyPosition = this.getCreaturePosition(enemy);
		// introductry use of compass to let player know how far away the enemy is
		// The magic compass is called to find the distance from the enemy
		this.magicCompass(playerPosition, enemyPosition);
		
		// main gameplay loop which the player will stay in
		// the loop breaks once the player and enemy are within the same tile
		// at this point combot is initilised
		this.mainLoop(playerPosition, enemyPosition);		
		
	}
	
	// This is the main gameplay loop which consists of moving and using the magic compass
	// More options would be added if the time permitted
	public void mainLoop(int[] playerPosition, int[] enemyPosition)
	{
		
		// main gameplay loop where the player can search for the monster by moving and using the magic compass
		boolean valid = false;
		do
		{
			try
			{
				// empty print is used to help space out text
				System.out.println();
				System.out.println("What would you like to do next: ");
				System.out.println("<1> Move. ");
				System.out.println("<2> Use magic compass. ");
				
				Scanner scan1 = new Scanner(System.in);
				int userInput = scan1.nextInt();
				
				// This block takes the user input and calls the relevant function
				// Testing a switch statement instead of do while 
				switch(userInput)
				{
				case 1 :
					// moves the player
					this.moveCreature(playerPosition);
					
					// if the player is in the same block as the enemy after moving combat is initlised
					if (Arrays.equals(playerPosition, enemyPosition))
					{
						this.combat();
						valid = true;
					}
					break;
				case 2 :
					this.magicCompass(playerPosition, enemyPosition);
					break;
				default :
					System.out.println("Invlaid input please enter the numbers shown on the screen only. ");	
				}
				
			}
			catch (java.util.InputMismatchException e)
			{
				System.out.println("Only numbers are valid inputs. Please enter the numbers shown on the screen only");
			}
		}
		while (!valid);
	}
	
	// This method moves a creature
	public void moveCreature(int[] creaturePosition)
	{
		boolean valid = false;
		do 
		{
			try 
			{
				System.out.println("Which direction would you like to move: ");
				System.out.println("<1> North ");
				System.out.println("<2> East ");
				System.out.println("<3> South ");
				System.out.println("<4> West ");
				System.out.println("Please input the relevant number. ");
				
				Scanner scan = new Scanner(System.in);
				int inputDirection = scan.nextInt();
				
				// ------------- North direction -----------------------
				if (inputDirection == 1)
				{
					creaturePosition[1] = creaturePosition[1] + 1;
					System.out.println("You have moved north. ");
					valid = true;
				}
				// -----------------------------------------------------
				
				// -------------- East Direction ----------------------
				else if (inputDirection == 2)
				{
					creaturePosition[0] = creaturePosition[0] + 1;
					System.out.println("You have moved east. ");
					valid = true;
				}
				// ---------------------------------------------------
				
				// -------------- South direction -----------------------
				else if (inputDirection == 3)
				{
					creaturePosition[1] = creaturePosition[1] - 1;
					System.out.println("You have moved south. ");
					valid = true;
				}
				// ----------------------------------------------------
				
				// -------------- West direction -------------------
				else if (inputDirection == 4)
				{
					creaturePosition[0] = creaturePosition[0] - 1;
					System.out.println("You have moved west. ");
					valid = true;
				}
				// --------------------------------------------------
				
				// -------------- Out of bounds input checking ------
				else if (inputDirection != 1 | inputDirection != 2 | inputDirection != 3 | inputDirection != 4 )
				{
					System.out.println("Invlaid input please enter the numbers shown on the screen only. ");
				}
				// ----------------------------------------------------
			}
			catch (java.util.InputMismatchException e)
			{
				System.out.println("Only numbers are valid inputs. Please enter the numbers shown on the screen only");
			}
		}
		while (!valid);
	}

	// This method gets the creatures position from the 2D position array
	// This 2D array is generated when a new instance of creature is generated
	// This method is overcomplicated 
	// could be removed by initilising the position array in the same manner as it is converted using this metthod
	// not enough time to change the code to accomadate it
	// Gets the position of any character, could be extended for objects
	public int[] getCreaturePosition(Creature creature)
	{
		// initlises X and Y coordinates in an array, ordered respectively
		int creatureXY[] = {0,0};
		
		// Finds the position of the creature on the map
		// Saves the position as an X and Y Coordinate
		for (int i = 0; i < creature.position.length; i++)
		{
			for (int j = 0; j < creature.position.length; j++)
			{
				if (creature.position[i][j] == 1)
				{
					creatureXY[0] = i;
					creatureXY[1] = j;
					
					return creatureXY;

				}
			}
		}
		return null;
	}
		
	// Magic compass finds how far the enemy is from the palyer
	public void magicCompass(int[] playerPosition, int[] enemyPosition)
	{
		
		// ------------------ Calculate distance between player and enemy -----------------------------
		int dx = enemyPosition[0] - playerPosition[0];
		int dy = enemyPosition[1] - playerPosition[1];
		
		double distance = Math.sqrt((dx*dx)+(dy*dy));
		// -------------------------------------------------------------------------------------------
		
		System.out.println("You can sense a presence. It is " + distance + "m away.");
			
	}

	// Combat method inisiated after moving when the playerPosition equals the enemyPosition
	// Combat method is not complete
	public void combat()
	{
		System.out.println("You have encountered the creature. ");
		System.out.println("It's a bloody biggun");
		
	}
}

