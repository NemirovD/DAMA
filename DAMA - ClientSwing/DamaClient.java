import java.util.*;
import java.net.*;
import java.io.*;


public class DamaClient {
	public static void main(String[] args) {
		if(args.length!=1){
			System.out.println("Incorrect Usage: DamaClient <name>");
			System.exit(0);
		}
		try{
			Socket commSocket = new Socket("localhost",9000);
		
			DamaView view = new DamaView();
			view.setVisible(true);
		
			DamaInThread t1 = new DamaInThread(commSocket, view.mainText);
			t1.start();
			
			DamaController controller = new DamaController(view,commSocket,args[0]);
		}catch(IOException e){
			System.out.println(e);
		}
	}
}
