package monster.controller;

import monster.model.MarshmallowMonster;

public class MonsterController 
{
	public void start()
	{
		MarshmallowMonster basic = new MarshmallowMonster();
		System.out.println(basic);
		MarshmallowMonster Hobert = new MarshmallowMonster("Hobert", 8, 6, 5.0, true);
		System.out.println(Hobert);
	}
}
