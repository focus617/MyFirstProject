import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstGui 
{
	JFrame frame;
	MyDrawPanel drawPanel;
	JButton colorButton;
	JButton labelButton;
	JLabel	label;
	
	int x=70;
	int y=70;
	
    public void go()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        colorButton = new JButton("I'm color button.");
        Font bigFont= new Font("serif", Font.BOLD, 28);
        colorButton.setFont(bigFont);
        colorButton.addActionListener(new ColorListener());
        
        labelButton = new JButton("I'm label button.");
        labelButton.addActionListener(new LabelListener());
        
        label = new JLabel("I'm a label");
        
        drawPanel = new MyDrawPanel();
        drawPanel.setBackground(Color.darkGray);

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.NORTH, labelButton);
        //frame.getContentPane().add(BorderLayout.CENTER, label);
        
        frame.setSize(400,400);
        frame.setVisible(true);
        
        for(int i=0; i<230000; i++){
        	x++;
        	y++;
        	
        	drawPanel.repaint();
        	
        	try{
        		Thread.sleep(50);
        	} catch(Exception ex) {}
        } // for
        
    }

    class ColorListener implements ActionListener 
    {
    	public void actionPerformed(ActionEvent event)
    	{
    		colorButton.setText("Color is Changed!");
    		x=60;
    		y=60;
    		frame.repaint();
    	}
    }
    
    class LabelListener implements ActionListener 
    {
    	public void actionPerformed(ActionEvent event)
    	{
    		labelButton.setText("Clicked!");
    		label.setText("Ouch!");
    	}
    }

    class MyDrawPanel extends JPanel
    {
    	public void paintComponent(Graphics g)
    	{
    		// Todo: refill the color into panel.
    		g.setColor(Color.WHITE);
    		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
    		// Draw new widget
    		Graphics2D g2d = (Graphics2D) g;
		
    		int red   = (int)(Math.random()*255);
    		int green = (int)(Math.random()*255);
    		int blue  = (int)(Math.random()*255);
    		Color startColor = new Color(red, green, blue);
		
    		red   = (int)(Math.random()*255);
    		green = (int)(Math.random()*255);
    		blue  = (int)(Math.random()*255);
    		Color endColor = new Color(red, green, blue);
		
    		GradientPaint gradient = new GradientPaint(100, 100, startColor, 200, 200, endColor);
		
    		g2d.setPaint(gradient);
    		g2d.fillOval(x, y, 100, 100);
    	}
    } //class MyDrawPanel
} //class FirstGui
