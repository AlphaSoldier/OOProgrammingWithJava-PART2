package clicker.ui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;
import clicker.applicationlogic.*;
import java.awt.BorderLayout;

public class UserInterface implements Runnable {
    private JFrame frame;


    @Override
    public void run() {
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        JLabel label = new JLabel("0");
        JButton button = new JButton("Click!");
        button.addActionListener(new ClickListener(new PersonalCalculator(), label));
        
        container.add(label, BorderLayout.NORTH);
        container.add(button, BorderLayout.SOUTH);
    }

    public JFrame getFrame() {
        return frame;
    }
}
