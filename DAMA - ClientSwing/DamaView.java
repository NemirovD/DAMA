import java.awt.*;
import javax.swing.*;

public class DamaView extends JFrame{
	public JButton exit;
	public JTextArea mainText;
	public JTextField inputText;
	
	public DamaView(){
		exit = new JButton("Exit");
		mainText = new JTextArea();
		mainText.setEditable(false);
		inputText = new JTextField();
		inputText.setPreferredSize(new Dimension(580, 25));
		
		JPanel lowPane = new JPanel();
		lowPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		lowPane.add(inputText);
		lowPane.add(exit);
		
		Container root = this.getContentPane();
		root.setLayout(new BorderLayout());
		mainText.setPreferredSize(new Dimension(640, 480));
		
		root.add(mainText, BorderLayout.CENTER);
		root.add(lowPane, BorderLayout.SOUTH);
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
