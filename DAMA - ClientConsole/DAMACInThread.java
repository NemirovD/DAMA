import java.util.*;
import java.net.*;
import java.io.*;

public class DAMACInThread extends Thread{
	public InputStream in;
	
	public DAMACInThread(Socket commSocket){
		try{
			this.in = commSocket.getInputStream();
		}catch(IOException e){
			;
		}
	}
	
	public void run(){
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			while(true){
				String line = reader.readLine();
				System.out.println(line);
				if(line == null)
					System.exit(0);
			}
		}catch(IOException e){
			;
		}
	}
}
