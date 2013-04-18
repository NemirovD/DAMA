import java.util.*;
import java.net.*;
import java.io.*;

public class DAMAS{
	public static Vector<PrintWriter> outStreams = new Vector<PrintWriter>();
	public static void main(String[] args){
		try{
			ServerSocket mainSocket = new ServerSocket(9000);
			System.out.println("Server has begun and is now listening...");
			while(true){
				DAMASThread t = new DAMASThread(mainSocket.accept(),outStreams.size());
				outStreams.add(t.writer);
				t.start();
				System.out.println("New Connection Established");
			}
		}catch(IOException e) {
			;
		}
	}
}
