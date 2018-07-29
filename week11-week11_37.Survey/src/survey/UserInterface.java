package survey;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        // Create your app here
        frame = new JFrame("Survey");
        frame.setPreferredSize(new Dimension(200,300));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void createComponents(Container container)
    {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        
        JLabel label1 = new JLabel("Are you?");
        container.add(label1);
        
        JCheckBox yes = new JCheckBox("Yes!");
        container.add(yes);
        
        JCheckBox no = new JCheckBox("No!");
        container.add(no);
        
        JLabel label2 = new JLabel("Why?");
        container.add(label2);
        
        JRadioButton rb1 = new JRadioButton("No reason.");
        JRadioButton rb2 = new JRadioButton("Because it is fun!");
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        
        container.add(rb1);
        container.add(rb2);
        
        JButton done = new JButton("Done!");
        container.add(done);
    }

    public JFrame getFrame() {
        return frame;
    }
}
