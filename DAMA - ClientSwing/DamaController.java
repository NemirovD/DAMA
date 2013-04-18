import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.net.*;
import java.io.*;

public class DamaController implements ActionListener{
	DamaView view;
	PrintWriter writer;
	String name;
	
	public DamaController(DamaView view,Socket commSocket, String name){
		try{
			this.view = view;
			this.view.exit.addActionListener(this);
			this.view.inputText.addActionListener(this);
			this.writer = new PrintWriter(commSocket.getOutputStream());
			this.name=name;
		}catch(IOException e){
			;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== view.exit){
			System.exit(0);
		}else if(e.getSource()==view.inputText){
			String text = "["+name+ "]: ";
			text += view.inputText.getText();
			writer.println(text);
			writer.flush();
			view.inputText.selectAll();
		}
	}
}
