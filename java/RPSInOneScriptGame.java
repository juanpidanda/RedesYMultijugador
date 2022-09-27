import java.util.Scanner;
import java.util.Random;

public class RPSInOneScriptGame {


public static void main(String args[]){
	RPSGame();
}

public static void RPSGame(){
	//User Variables
	Scanner userInput = new Scanner(System.in);
	String userRPSDecision = "";

	//Server Variables
	String serverRPSDecision = "";

	System.out.println("\nWelcome to  Rock, Paper & Scissors Game!\n");
	System.out.println("Please select an option:\n Rock = Type 'r'\n Paper = Type 'p'\n Scissors = Type 's'");
	userRPSDecision = userInput.nextLine();
	serverRPSDecision = RandomRPSID();
	System.out.println("\nSelection:\n You selected = " + userRPSDecision + "\n Server selected = " + serverRPSDecision + "\n");
	RPSWinnerSelector(userRPSDecision, serverRPSDecision);
	System.out.println("\nThanks For Playing");
}

public static void RPSWinnerSelector(String userDecision, String serverDecision){
	System.out.println("Entro a RPSWinnerSelector");
	if(userDecision == serverDecision){
		System.out.println("It's a Tie");
	}
	else{
		switch(userDecision){
		case "r":
			if(serverDecision == "p") ServerWins();
			else if(serverDecision == "s") UserWins();
			break;
		case "p":
			if(serverDecision == "s") ServerWins();
			else if(serverDecision == "r") UserWins();
			break;
		case "s":
			if(serverDecision == "r") ServerWins();
			else if(serverDecision == "p") UserWins();
			break;
		}
	}
}


public static String RandomRPSID(){
	Random random = new Random();
	Integer serverRandomRPSID;
	String randomToString = "";
	serverRandomRPSID = random.nextInt(0,3);
	switch(serverRandomRPSID){
		case 0:
			randomToString = "r";
			break;
		case 1:
			randomToString = "p";
			break;
		case 2:
			randomToString = "s";
			break;
	}
	return randomToString;
}
public static void ServerWins(){
	System.out.println("--- Server Wins, better luck next time. ---");
}
public static void UserWins(){
	System.out.println("--- You Win, Congatulations!. ---");
}
}