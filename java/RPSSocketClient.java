import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class RPSSocketClient {
public static void main(String[] args)throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
	//This Scanner get the input of the user
	Scanner userInput = new Scanner(System.in);
	//get the localhost IP address, if server is running on some other IP, you need to use that
	InetAddress host = InetAddress.getLocalHost();
	Socket serverSocketInClient = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	//establish socket connection to server
	serverSocketInClient = new Socket(host.getHostName(), 9876);
	System.out.println("\nWelcome to  Rock, Paper & Scissors Game!\n");
	System.out.println("Please select an option:\n Rock = Type 'r'\n Paper = Type 'p'\n Scissors = Type 's'");
	//write to socket using ObjectOutputStream
	oos = new ObjectOutputStream(serverSocketInClient.getOutputStream());
	String userRPSDecision = userInput.nextLine();
	oos.writeObject(userRPSDecision);
	ois = new ObjectInputStream(serverSocketInClient.getInputStream());
	String serverRPSDecision = (String) ois.readObject();
	System.out.println("\nSelection:\n You selected = " + userRPSDecision + "\n Server selected = " + serverRPSDecision + "\n");
	System.out.println("\n And the Winner is ... " + (String) ois.readObject());
	System.out.println("\nThanks For Playing");
}
}