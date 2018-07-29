import java.awt.event.ActionEvent;
import javax.swing.*;

public class SubtractLogic extends Logic
{
    private JButton zeroButton;
    
    public SubtractLogic(JTextField output, JTextField input, JButton zeroButton)
    {
        super(output, input);
        this.zeroButton = zeroButton;
    }

    @Override
    public void actionPerformed(ActionEvent a)
    {
        try
        {
            int input = Integer.parseInt(super.getInput().getText());
            int output = Integer.parseInt(super.getOutput().getText());
            
            output -= input;
            
            super.getOutput().setText(Integer.toString(output));
            super.getInput().setText("");
            
            if(output == 0)
                zeroButton.setEnabled(false);
            else
                zeroButton.setEnabled(true);
        }
        catch(NumberFormatException nfe)
        {
            super.getInput().setText("");
        }
    }
}