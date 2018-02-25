import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SUNSET extends JApplet 
{
    // size of the applet window
    private final int MAX_WIDTH = 800;
    private final int MAX_HEIGHT = 600;
    private final int HORIZON = 500;

    // timer
    private final int DELAY = 70;
    private Timer timer;
    
    // background color in applet panel
    private Color backColor;
    // color of the sea
    private Color seaColor;
    
    // rgb values for backColor
    private float r, g, b, alpha;

    // used in setting value for r
    private double time;

    // Y Coordinate of the top of the sun
    private int yCoord;

    private int seaBlue;
    private int seaGreen;
    private int numCalls;
    
    public void init()
    {
        timer = new Timer(DELAY, null);
        timer.addActionListener(new MyTimerListener());
	b = 1.0f;
	r = .7f;
	g = 0.0f;
	yCoord = 50;
	time = 0;
	numCalls = 0;
	backColor = new Color(174, 71, 88); 
	seaBlue = 155;
	seaGreen = 100;
	seaColor = new Color(30, seaGreen, seaBlue); 
	numCalls = 0;
    }

   
    public void start ()
    {
        timer.start();
    }
    
   
    public void stop ()
    {
        timer.stop();
    }
    
   
    public void paint(Graphics g)
    {
	g.setColor(backColor);
	g.fillRect(0, 0, MAX_WIDTH, HORIZON);
	
	if(yCoord < HORIZON) {
            g.setColor(Color.YELLOW);
             g.setFont(new Font("Monospaced", Font.BOLD, 24)); 
            g.drawString("EYE IN THE SKY.....is above you!!", yCoord, 75);
         
            
            g.setColor(Color.black.brighter());
	    g.fillOval(189, yCoord, 47, 40); 
            
            
	    g.setColor(Color.yellow.brighter());
	    g.fillOval(193, yCoord, 40, 40);
            
            g.setColor(Color.blue.brighter());
	    g.fillOval(200, yCoord, 20, 40); 
           
	}
	
	g.setColor(seaColor);
	g.fillRect(0, HORIZON, MAX_WIDTH, MAX_HEIGHT - HORIZON);
    }
    
  
    private class MyTimerListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
	    numCalls++;
	    if(b > 0.003) {
		time += 0.002;
		r = (float)(0.51*Math.sin(Math.PI * time));
		b -= 0.002;
		yCoord += 1;
	    }
	    if(numCalls % 4 == 0) {
		if(seaBlue > 0) seaBlue--;
		if(seaGreen > 0) seaGreen--;
	    }
	    seaColor = new Color(0, seaGreen, seaBlue);
	    
	    backColor = new Color(r,g,b);
	    setBackground(backColor);
            repaint();
           System.out.println("THE EYE IN THE SKY IS WATCHING YOU");
            
        }
    }
}