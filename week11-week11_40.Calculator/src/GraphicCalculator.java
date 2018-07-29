
import java.awt.*;
import javax.swing.*;

public class GraphicCalculator implements Runnable {
    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(400,300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        container.setLayout(new GridLayout(3,1));
        JPanel panel = new JPanel(new GridLayout(1,3));
        
        JTextField output = new JTextField("0");
        output.setEnabled(false);
        JTextField input = new JTextField("");
        
        JButton ZButton = new JButton("Z");
        ZButton.addActionListener(new ZeroLogic(output, input, ZButton));
        if(Integer.parseInt(output.getText()) == 0)
            ZButton.setEnabled(false);
        
        JButton plusButton = new JButton("+");
        plusButton.addActionListener(new AddLogic(output, input, ZButton));
        
        JButton minusButton = new JButton("-");
        minusButton.addActionListener(new SubtractLogic(output, input, ZButton));
        
        panel.add(plusButton);
        panel.add(minusButton);
        panel.add(ZButton);
        
        container.add(output);
        container.add(input);
        container.add(panel);
    }

    public JFrame getFrame() {
        return frame;
    }
}