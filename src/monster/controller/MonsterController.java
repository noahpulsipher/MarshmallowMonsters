package monster.controller;

import monster.model.MarshmallowMonster;
import java.util.Scanner;
import monster.view.MonsterDisplay;

public class MonsterController 
{
	private MonsterDisplay popup;
	
	public MonsterController()
	{
		popup = new MonsterDisplay();
	}
	
	public void start()
	{
		MarshmallowMonster basic = new MarshmallowMonster();
//		System.out.println(basic);
		popup.displayText(basic.toString()); 
		MarshmallowMonster Hobert = new MarshmallowMonster("Hobert", 1, 2, 3.5, true);
//		System.out.println(Hobert);
		popup.displayText(Hobert.toString());
//		System.out.println("I am going to eat one of Hobert's arms");
		popup.displayText("I am going to eat one of Hobert's arms");
		Hobert.setArmCount(Hobert.getArmCount () - 1);
//		System.out.println(Hobert);
		popup.displayText(Hobert.toString());
		
		interactWithMonster(Hobert);
	}
	
	private void interactWithMonster(MarshmallowMonster currentMonster)
	{
		
		Scanner myScanner = new Scanner(System.in);
//		System.out.println("How many arms are you interested in eating? I have " + currentMonster.getArmCount());
		int consumed = 0;
		String response = popup.getResponse(currentMonster.getName() +"wants to know how many eyes you want to eat, please type in how many");
		
		if(isValidInteger(response))
		consumed = Integer.parseInt(response);
		//int consumed = myScanner.nextInt();
		
		//consumed = myScanner.nextInt();
		int armEat = myScanner.nextInt();
		{
			consumed = Integer.parseInt(response);
		}
		
		
		if(armEat == 0)
		{
			//System.out.println("Not hungry? Oh, so sad...");
			popup.displayText(currentMonster.toString());
			popup.getResponse("Not hungry? Oh, so sad...");
		}
		else if(armEat < 0)
		{
			//System.out.println("Reality is hard for you - it is impossible to eat a negative amount");	
			popup.displayText(currentMonster.toString());
			popup.getResponse("Reality is hardd for you - it is impossible to eat a negative amount");
		}
		else if(armEat - currentMonster.getArmCount() > 0)
		{
			//System.out.println("You are not allowed to eat more than exist on me :/ XD");
			popup.displayText(currentMonster.toString());
			popup.getResponse("You are not allowed to eat more than exists on me XD");
		}
		else
		{
			currentMonster.setArmCount(currentMonster.getArmCount() - armEat);
			//System.out.println("OK, now I have this many arms " + currentMonster.getArmCount());
			popup.displayText(currentMonster.toString());
			popup.getResponse("Ok, now I haave this many arms " + currentMonster.getArmCount());
		}
		
		
		//System.out.println("How many eyes do you want to eat? I have " + currentMonster.getEyeCount());
		//consumed  = myScanner.nextInt();
		
		popup.displayText(currentMonster.toString());
		popup.getResponse("How many eyes do you want to eat? I have " + currentMonster.getEyeCount());
		int eyeEat = myScanner.nextInt();
		
		if(eyeEat == 0)
		{
			//System.out.println("Fine, more eyes for me...");	
			popup.displayText(currentMonster.toString());
			popup.getResponse("Fine, more eyes for me...");
		}
		else if(eyeEat < 0)
		{
			//System.out.println("It doesn't work that way");
			popup.displayText(currentMonster.toString());
			popup.getResponse("It doesn't work that way");
		}
		else if(eyeEat - currentMonster.getEyeCount() > 0	)
		{
			//System.out.println("I don't have that many eyes, try again.");
			popup.displayText(currentMonster.toString());
			popup.getResponse("I don't have that many eyes, try again.");
		}
		else
		{
			currentMonster.setEyeCount(currentMonster.getEyeCount() - eyeEat);
			//System.out.println("Cool, now I only have this many eyes " + currentMonster.getEyeCount());
			popup.displayText(currentMonster.toString());
			popup.getResponse("Cool, now I only have this many eyes " + currentMonster.getEyeCount());
		}
		
		System.out.println("How many tentacles do you want to eat? I have " + currentMonster.getTentacleAmount());
		
		
		double food = 0.0;
		String tentacleResponse = popup.getResponse("how many tentacles do you want to eat? I have " + currentMonster.getTentacleAmount());
		if(isValidDouble(tentacleResponse))
		{
			food = Double.parseDouble(tentacleResponse);
		}
		
		if(food == currentMonster.getTentacleAmount())
		{
			System.out.println("You ate all my tentacles!!!");
		}
		else
		{
			System.out.println("More Likely");
		}
		
		popup.displayText("Hi there, ready to play?");
		String answer = popup.getResponse("What is the air speed of a coconut laden swallow?");
		System.out.println(answer);
		
		
		
		
		myScanner.close();
	}
	
	
	
	//Helper methods
	private boolean isValidInteger(String sample)
	{
		boolean valid = false;
		
		try
		{
			Integer.parseInt(sample);
			valid = true;
		}
		catch(NumberFormatException error)
		{
			popup.displayText("You need to input an int, " + sample + " is not valid.");	
		}
		
		
		
		
		return valid;
	
	
	
	
	}



	private boolean isValidDouble(String sampleDouble)
	{
		boolean valid = false;
		
		try
		{
			Double.parseDouble(sampleDouble);
			valid = true;
		}
		catch(NumberFormatException error)
		{
			popup.displayText("You need to type in a double - " + sampleDouble + " is not a valid answer.");
		}
		
		return valid;
	}

	private boolean isValidBoolean(String sampleBoolean)
	{
		boolean valid = false;
		
		try
		{
			Boolean.parseBoolean(sampleBoolean);
			valid = true;
		}
		catch(NumberFormatException error)
		{
			popup.displayText("Type in a boolean value " + sampleBoolean + " does not count.");
		}
		
		return valid;
	}
}




