import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.Graphics2D;

public class Menu implements ActionListener{
	
	private Button button1;
	private Button button2;
	
	//Constructor
	public Menu() {
		button1 = new Button(this, "Button1", 200, 100, 100, 40);
		button2 = new Button(this, "Exit", 300, 200, 100, 40);
	}
	
	public void update() {
		
	}
	
	public void render(Graphics2D graph) {
		button1.render(graph);
		button2.render(graph);
	}
	
	public void mousePressed(MouseEvent event) {
		button1.mousePressed(event);
		button2.mousePressed(event);
	}
	
	public void mouseReleased(MouseEvent event) {
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == button1) {
			System.out.println("Heelo");
		}
		
		if(event.getSource() == button2) {
			System.exit(0);
		}
		
	}


}
