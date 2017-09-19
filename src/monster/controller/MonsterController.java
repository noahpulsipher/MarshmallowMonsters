package monster.controller;

import monster.model.MarshmallowMonster;
import java.util.Scanner;

public class MonsterController 
{
	public void start()
	{
		MarshmallowMonster basic = new MarshmallowMonster();
		System.out.println(basic);
		MarshmallowMonster Hobert = new MarshmallowMonster("Hobert", 1, 2, 3.5, true);
		System.out.println(Hobert);
		System.out.println("I am going to eat one of Hobert's arms");
		Hobert.setArmCount(Hobert.getArmCount () - 1);
		System.out.println(Hobert);
		
		interactWithMonster(Hobert);
	}
	
	private void interactWithMonster(MarshmallowMonster currentMonster)
	{
		Scanner myScanner = new Scanner(System.in);
		System.out.println(currentMonster.getName() + " wants to know how many eyes you want to eat, please type in how many");
		int consumed = myScanner.nextInt();
		currentMonster.setEyeCount(currentMonster.getEyeCount() - consumed);
		System.out.println(currentMonster);
		
		System.out.println("How many arms are you interested in eating? I have " + currentMonster.getArmCount());
		//consumed = myScanner.nextInt();
		int armEat = myScanner.nextInt();
		
		if(armEat == 0)
		{
			System.out.println("Not hungry? Oh, so sad...");
		}
		else if(armEat < 0)
		{
			System.out.println("Reality is hard for you - it is impossible to eat a negative amount");	
		}
		else if(armEat - currentMonster.getArmCount() > 0)
		{
			System.out.println("You are not allowed to eat more than exist on me :/ XD");
		}
		else
		{
			currentMonster.setArmCount(currentMonster.getArmCount() - armEat);
			System.out.println("OK, now I have this many arms " + currentMonster.getArmCount());
		}
		
		
		System.out.println("How many eyes do you want to eat? I have " + currentMonster.getEyeCount());
		//consumed  = myScanner.nextInt();
		int eyeEat = myScanner.nextInt();
		
		if(eyeEat == 0)
		{
			System.out.println("Fine, more eyes for me...");	
		}
		else if(eyeEat < 0)
		{
			System.out.println("It doesn't work that way");
		}
		else if(eyeEat - currentMonster.getEyeCount() > 0	)
		{
			System.out.println("I don't have that many eyes, try again.");
		}
		else
		{
			currentMonster.setEyeCount(currentMonster.getEyeCount() - eyeEat);
			System.out.println("Cool, now I only have this many eyes " + currentMonster.getEyeCount());
		}
		
		myScanner.close();
	}
}
