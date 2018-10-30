package testBasedGame;

public class CreatureFactory {

	public static Creature getCreature(String type) 
	{
		if (type.equalsIgnoreCase("CHARACTER"))
		{
			return new Character();
		}
		else if (type.equalsIgnoreCase("ENEMY"))
		{
			return new Enemy();
		}
		else 
		{
			return null;
		}
		
	}

}
