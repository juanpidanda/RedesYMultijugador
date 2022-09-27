import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Random;

public class RPSSocketServer {
//static ServerSocket variable
private static ServerSocket server;
//socket server port on which it will listen
private static int port = 9876;
public static void main(String args[]) throws IOException, ClassNotFoundException{
	RPSGame();
}
public static void RPSGame()throws IOException, ClassNotFoundException{
	server = new ServerSocket(port);
	//User Variables
	String userRPSDecision = "";
	//Server Variables
	boolean continuePlaying = true;
	String serverRPSDecision = "";
	String winner = "";
	while(continuePlaying){
		System.out.println("Waiting for the client request");
		//creating socket and waiting for client connection
		Socket clientSocketInServer = server.accept();
		//read from socket to ObjectInputStream object
		ObjectInputStream ois = new ObjectInputStream(clientSocketInServer.getInputStream());
		userRPSDecision = (String) ois.readObject();
		serverRPSDecision = RandomRPSID();
		System.out.println("Randomizer selected = " + serverRPSDecision);
		//create ObjectOutputStream object
		ObjectOutputStream oos = new ObjectOutputStream(clientSocketInServer.getOutputStream());
		oos.writeObject(serverRPSDecision);
		winner = RPSWinnerSelector(userRPSDecision, serverRPSDecision);
		oos.writeObject(winner);
		//close resources
		ois.close();
		oos.close();
		clientSocketInServer.close();
		continuePlaying = false;
		}
		System.out.println("Shutting down Socket server!!");
		server.close();
}
//Funcion para setear piedra, papel o tijera para el server mediante un random
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
//Funcion que compara la decision del usuario y la del servidor para dar con el ganador
public static String RPSWinnerSelector(String userDecision, String serverDecision){
	System.out.println("Entro a RPSWinnerSelector\n " + " User Decision: " + userDecision + "\n Server Decision: " + serverDecision);
	if(userDecision.equals(serverDecision)){
		return "It's a Tie";
	}
	else{
		switch(userDecision){
		case "r":
			if(serverDecision.equals("p"))
			{
				return "Server";
			}
			else if(serverDecision.equals("s")){
				return "User";
			}
			break;
		case "p":
			if(serverDecision.equals("s"))
			{
				return "Server";
			}
			else if(serverDecision.equals("r")){
				return "User";
			}
			break;
		case "s":
			if(serverDecision.equals("r"))
			{
				return "Server";
			}
			else if(serverDecision.equals("p")){
				return "User";
			}
			break;
		}
	}
	return "problem getting the winner.";
}
}