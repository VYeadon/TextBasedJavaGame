package testBasedGame;

import java.util.Scanner;

public class Character extends Creature
{
	// Not enough time to implement inventory
	//String[] inventory;

	public Character() 
	{
		
		
		Scanner scan = new Scanner(System.in);
		
		// ------------- Character Creation -----------------
		// Asks the user to input a name
		System.out.println("Please enter a name for your character");
		this.name = scan.nextLine();
		
		// Asks for user to choose class
		// This method calls the getStats from the super Creature class 
		this.chooseClass();
		//---------------------------------------------------------
		
		// Sets player postion to the middle of the map
		this.position[5][5] = 1;
		
	}
	
	// This method is called by the character constructor and lets the user choose a class
	public void chooseClass()
	{		

		// Creates a validation token to allow the user to change class if they are not happy with there selection
		boolean valid = false;
		do 
		{
			// This try is used to ensure that a string is not input instead of an integer
			try
			{

				// Everything within the do loop repeats until the validation token is set to true
					System.out.println("Please choose your class: ");
					System.out.println("<1> Warrior ");
					System.out.println("<2> Mage ");
					System.out.println("<3> Rogue ");
					System.out.println("Please input the relevant number");
					
					Scanner classScan = new Scanner(System.in);
					int type = classScan.nextInt();
					
					// ------------------- Warrior selection -----------------------------
					if (type == 1)
					{
						
						// a second do loop which sends the user back to the screen 
						// which asks if they are happy with there selection if input is invalid
						// cannot get exceptions from string inputs to follow this logic properly
							
						boolean innerValid = false;
						do 
						{
							
							try
							{
								System.out.println("Warriors have high attack and defense but have low intelligence and move slowly ");
								System.out.println("Are you sure you want to use this class? ");
								System.out.println("<1> Yes");
								System.out.println("<2> No");
								int selection = classScan.nextInt();
								
														
								// Loop checks to see whether user is happy with their choice
								// And if so calls the getStats function to generate user stats
								if (selection == 1)
								{
									getStats(type);
									innerValid = true;
									valid = true;
								}
								else if (selection == 2)
								{
									System.out.println("Returning you to the class selection screen ");
									// Setting this inner validation to true breaks the do loop for each specific class
									innerValid = true;
								}
								else if (selection != 1 | selection !=2)
								{
									System.out.println("Invlaid input please enter the numbers shown on the screen only. ");
								}
							}
							
							// This gets stuck in an infinite loop if i do not break this do loop
							catch (java.util.InputMismatchException e)
							{
								System.out.println("Only numbers are valid inputs. Returning you to the class selection screen");
								innerValid = true;
							}
						}
						while (!innerValid);	
					}
					// ------------------------------------------------------------------

					// -------------------- Mage Selection -----------------------------
					else if (type == 2)
					{
						// a second do loop which sends the user back to the screen 
						// which asks if they are happy with there selection if input is invalid
						// cannot get exceptions from string inputs to follow this logic properly
							
						boolean innerValid = false;
						do 
						{
							
							try
							{
								System.out.println("Mages have high intelligence, move at a medium pace but have low attack and defense. ");
								System.out.println("Are you sure you want to use this class? ");
								System.out.println("<1> Yes");
								System.out.println("<2> No");
								int selection = classScan.nextInt();
								
									
								// Loop checks to see whether user is happy with their choice
								// And if so calls the getStats function to generate user stats
								if (selection == 1)
								{
									getStats(type);
									innerValid = true;
									valid = true;
								}
								else if (selection == 2)
								{
									System.out.println("Returning you to the class selection screen ");
									// Setting this inner validation to true breaks the do loop for each specific class
									innerValid = true;
								}
								else if (selection != 1 | selection !=2)
								{
									System.out.println("Invlaid input please enter the numbers shown on the screen only. ");
								}
							}
							
							// This gets stuck in an infinite loop if i do not break this do loop
							catch (java.util.InputMismatchException e)
							{
								System.out.println("Only numbers are valid inputs. Returning you to the class selection screen");
								innerValid = true;
							}
						}
						while (!innerValid);
					}
					//-----------------------------------------------------------------
				
					// -------------------- Rogue Selection ----------------------------
					else if (type == 3)
					{
						// a second do loop which sends the user back to the screen 
						// which asks if they are happy with there selection if input is invalid
						// cannot get exceptions from string inputs to follow this logic properly
							
						boolean innerValid = false;
						do 
						{
							
							try
							{
								System.out.println("Rogues have high speed, medium intelligence but low attack and defense ");
								System.out.println("Are you sure you want to use this class? ");
								System.out.println("<1> Yes");
								System.out.println("<2> No");
								int selection = classScan.nextInt();
								
								
								// Loop checks to see whether user is happy with their choice
								// And if so calls the getStats function to generate user stats
								if (selection == 1)
								{
									getStats(type);
									innerValid = true;
									valid = true;
								}
								else if (selection == 2)
								{
									System.out.println("Returning you to the class selection screen ");
									// Setting this inner validation to true breaks the do loop for each specific class
									innerValid = true;
								}
								else if (selection != 1 | selection !=2)
								{
									System.out.println("Invlaid input please enter the numbers shown on the screen only. ");
								}
							}
							
							// This gets stuck in an infinite loop if i do not break this do loop
							catch (java.util.InputMismatchException e)
							{
								System.out.println("Only numbers are valid inputs. Returning you to the class selection screen");
								innerValid = true;
							}
						}
						while (!innerValid);
					}
					//-----------------------------------------------------------------

					// ------------------- Invalid input --------------------------
					// Prints out error message if user has input a number outside of the range
					else if (type != 1 | type != 2 | type != 3)
					{
						System.out.println("Invlaid input please enter the numbers shown on the screen only. ");
					}
					// ----------------------------------------------------------------
			}	
			catch (java.util.InputMismatchException e)
			{
				System.out.println("Only numbers are valid inputs.");
			}
		}
		while (!valid);
	}
	

}
