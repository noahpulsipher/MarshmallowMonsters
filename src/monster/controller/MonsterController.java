package monster.controller;

import java.util.List;
import java.util.ArrayList;
import monster.model.MarshmallowMonster;
import java.util.Scanner;
import monster.view.MonsterDisplay;

public class MonsterController 
{
	private MonsterDisplay popup;
	private List<MarshmallowMonster> monsterList;
	
	public MonsterController()
	{
		popup = new MonsterDisplay();
		monsterList = new ArrayList<MarshmallowMonster>();
	}
	
	public void start()
	{
		int count = 0;
//		while(count < 10)
//		{
//	      	popup.displayText("Am I not the coolest???");
//			count +=2;
//		}
		
//		for(int loop = 0; loop < 10; loop += 1)
//		{
//			popup.displayText("This is loop # " + (loop + 1) + " of 10");
//		}
		
		
		
		
		MarshmallowMonster basic = new MarshmallowMonster();
//		System.out.println(basic);
		popup.displayText(basic.toString()); 
		MarshmallowMonster Hobert = new MarshmallowMonster("Hobert", 8, 8, 3.5, true);
//		System.out.println(Hobert);
		popup.displayText(Hobert.toString());
//		System.out.println("I am going to eat one of Hobert's arms");
		popup.displayText("I am going to eat one of Hobert's arms");
		Hobert.setArmCount(Hobert.getArmCount () - 1);
//		System.out.println(Hobert);
		popup.displayText(Hobert.toString());
		
		monsterList.add(basic);
		monsterList.add(Hobert);
		
		interactWithMonster(Hobert);
	}
	
	private void interactWithMonster(MarshmallowMonster currentMonster)
	{
		
		Scanner myScanner = new Scanner(System.in);
//		System.out.println("How many arms are you interested in eating? I have " + currentMonster.getArmCount());
		int consumed = 0;
		String response = popup.getResponse(currentMonster.getName() +"wants to know how many eyes you want to eat, please type in how many");
		
		while(!isValidInteger(response))
		{
			popup.displayText("grr type in a better answe next time");
			response = popup.getResponse("Type in a integer value!!");
		}
		
		
		
		
		if(isValidInteger(response))
			{
			consumed = Integer.parseInt(response);
			}
		currentMonster.setEyeCount(currentMonster.getEyeCount() - consumed);
		popup.displayText("I have this many eyes " + currentMonster.getEyeCount());
		//int consumed = myScanner.nextInt();
		//consumed = myScanner.nextInt();
		//int armEat = myScanner.nextInt();
		
		
		String meal = popup.getResponse("How many arms do you want to eat");
		
		int armEat = 0;
		while(!isValidInteger(meal))
		{
			popup.displayText("nope");
			meal = popup.getResponse("Type in a valid integer.");
		}
		
		armEat = Integer.parseInt(meal);
		
		
		if(armEat == 0)
		{
			//System.out.println("Not hungry? Oh, so sad...");
			popup.displayText("Not hungry? Oh, so sad...");
			
		}
		else if(armEat < 0)
		{
			//System.out.println("Reality is hard for you - it is impossible to eat a negative amount");	
			popup.displayText("Reality is hard for you - it is impossibld to eat a negative amount");
			
		}
		else if(armEat - currentMonster.getArmCount() > 0)
		{
			//System.out.println("You are not allowed to eat more than exist on me :/ XD");
			popup.displayText("You are not allowed to eat more than exists on me XD");
		}
		else
		{
			currentMonster.setArmCount(currentMonster.getArmCount() - armEat);
			//System.out.println("OK, now I have this many arms " + currentMonster.getArmCount());
			popup.displayText("Ok, now I have this many arms " + currentMonster.getArmCount());
		}
		
		
		//System.out.println("How many eyes do you want to eat? I have " + currentMonster.getEyeCount());
		//consumed  = myScanner.nextInt();
		
		String eyeResponse = popup.getResponse("How many eyes do you want to eat? I have " + currentMonster.getEyeCount());
		
		int eyeEat = 0;
		
		while(!isValidInteger(eyeResponse))
		{
			popup.displayText("nope");
			eyeResponse = popup.getResponse("Type in something better");
		}
		eyeEat = Integer.parseInt(eyeResponse);
		
		
		
		//int eyeEat = myScanner.nextInt();
		
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
		else if(eyeEat - currentMonster.getEyeCount() > 0 )
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
			
	}
		
		//System.out.println("How many tentacles do you want to eat? I have " + currentMonster.getTentacleAmount());
		
		
		double food = 0.0;
		String tentacleResponse = popup.getResponse("how many tentacles do you want to eat? I have " + currentMonster.getTentacleAmount());
		
		while(!isValidDouble(tentacleResponse))
		{
			popup.displayText("doesn't work");
			tentacleResponse = popup.getResponse("Type in something better");
		}
		
		
		
		if(isValidDouble(tentacleResponse))
		{
			food = Double.parseDouble(tentacleResponse);
		}
		
		if(food == currentMonster.getTentacleAmount())
		{
			//System.out.println("You ate all my tentacles!!!");
			popup.displayText("You ate all my tentacles");
			
			
		}
		else
		{
		
			//System.out.println("More Likely");
			popup.displayText("More likely");
		}
		
//		popup.displayText("Hi there, ready to play?");
//		String answer = popup.getResponse("What is the air speed of a coconut laden swallow?");
//		System.out.println(answer);
//		
		
		
		
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
//This class is where all the helper methods and former system.out.println methods were. It catches bad responses so that the program doesn't crash.

  

