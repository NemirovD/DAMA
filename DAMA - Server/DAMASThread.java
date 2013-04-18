import java.io.*;
import java.net.*;
import java.util.*;

public class DAMASThread extends Thread {
	public BufferedReader reader;
	public PrintWriter writer;
	public int no;
	public Socket commSocket;
	
	public DAMASThread(Socket commSocket,int no){
		try{
			this.reader = new BufferedReader(new InputStreamReader(commSocket.getInputStream()));
			this.writer = new PrintWriter(commSocket.getOutputStream());
			this.no = no;
			this.commSocket = commSocket;
		}catch(IOException e){
			;
		}
	}
	
	public void run(){
		try{
			String line;
			writer.println("Connection Established");
			writer.flush();
			while(true){
				line=reader.readLine();
				if(line==null){
					commSocket.close();
					break;
				}
				System.out.println(line);
				for(int i = 0;i<DAMAS.outStreams.size();i++){
						DAMAS.outStreams.get(i).println(line);
						DAMAS.outStreams.get(i).flush();
				}
			}
		}catch(IOException e){
			;
		}
	}
}
