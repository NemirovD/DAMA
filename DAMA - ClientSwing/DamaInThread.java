import javax.swing.*;
import java.util.*;
import java.net.*;
import java.awt.*;
import java.io.*;

public class DamaInThread extends Thread{
	public BufferedReader reader;
	public JTextArea textArea;
	
	public DamaInThread(Socket commSocket, JTextArea textArea){
		try{
			this.reader = new BufferedReader(new InputStreamReader(commSocket.getInputStream()));
			this.textArea = textArea;
		}catch(IOException e){
			System.out.println(e);
		}
	}
	
	public void run(){
		try{
			while(true){
				String line = reader.readLine();
				textArea.append(line +"\n");
				if(line == null){
					textArea.append("The Server has been shut down\n");
					textArea.append("Press exit to shut down the chat client\n");
				}
			}
		}catch(IOException e){
			;
		}
	}
}
