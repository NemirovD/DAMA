import java.util.*;
import java.net.*;
import java.io.*;

public class DAMACOutThread extends Thread{
	public OutputStream out;
	public String name;
	public Socket commSocket;
	
	public DAMACOutThread(Socket commSocket,String name){
		try{
			this.out = commSocket.getOutputStream();
			this.name = name;
			this.commSocket = commSocket;
		}catch(IOException e){
			;
		}
	}
	
	public void run(){
			PrintWriter writer = new PrintWriter(out);
			Scanner scan = new Scanner(System.in);
			String line;
			while(true){
				line = "["+name+ "]: ";
				line += scan.nextLine();
				if(line.charAt(0)=='/'){
					parsecommand(line);
				}else{
					writer.println(line);
					writer.flush();
				}
				System.out.print("\033[A");
			}
	}
	
	public void parsecommand(String command){
		String cmd[] = command.split(" ");
		try{
			if(cmd[0].equals("/exit")){
				commSocket.close();
				System.exit(0);
			}
		}catch(IOException e){
				;
		}
	}
}
