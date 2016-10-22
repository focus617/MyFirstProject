import javax.swing.*;
import java.awt.event.*;

public class FirstGui implements ActionListener
{
    JButton button;

    public static void main (String[] args)
    {
        FirstGui gui = new FirstGui();
        gui.go();
    }

    public void go()
    {
        JFrame frame = new JFrame();
        button = new JButton("click me");

        button.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(button);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event)
    {
        button.setText("I've been clicked!");
    }
}

