package monster.view;

import javax.swing.JOptionPane;

public class MonsterDisplay 
{

	public void displayText(String textToDisplay)
	{
		JOptionPane.showMessageDialog(null, textToDisplay);
	}
	
	public String getResponse(String questionToDisplay)
	{
		
		String answer = "";
		
		answer += JOptionPane.showInputDialog(null, questionToDisplay);
		
		return answer;
	}
}
//this class makes a graphic user interface for the person who is interacting with the program.
