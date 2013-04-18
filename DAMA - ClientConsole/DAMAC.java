import java.util.*;
import java.net.*;
import java.io.*;

public class DAMAC{
	public static void main(String[] args) throws IOException{
		Socket commSocket = new Socket("localhost",9000);
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to DAMA - David's Awesome Messaging App");
		System.out.println("Enter your chat handle to begin.");
		String line = scan.nextLine();
		System.out.println("Hello, "+line+", you may now begin chatting");
		
		DAMACInThread iT = new DAMACInThread(commSocket);
		DAMACOutThread oT = new DAMACOutThread(commSocket,line);
		iT.start();
		oT.start();
		
	}
}
