import java.awt.event.*;
import javax.swing.*;

public abstract class Logic implements ActionListener
{
    private JTextField output;
    private JTextField input;
    
    public Logic(JTextField output, JTextField input)
    {
        this.output = output;
        this.input = input;
    }
    
    public JTextField getInput()
    {
        return input;
    }

    public JTextField getOutput() {
        return output;
    }
    
    @Override
    public abstract void actionPerformed(ActionEvent a);
}