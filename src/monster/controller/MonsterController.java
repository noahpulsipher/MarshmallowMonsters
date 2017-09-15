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
		
		System.out.println(currentMonster.getName() + " wants to know how many arms you want to eat, please type in how many");
		int consumed1 = myScanner.nextInt();
		currentMonster.setArmCount(currentMonster.getArmCount() - consumed1);
		System.out.println(currentMonster);
		myScanner.close();
	}
}
