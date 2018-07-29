import java.awt.event.ActionEvent;
import javax.swing.*;

public class ZeroLogic extends Logic
{
    private JButton zeroButton;
    
    public ZeroLogic(JTextField output, JTextField input, JButton zeroButton)
    {
        super(output, input);
        this.zeroButton = zeroButton;
    }

    @Override
    public void actionPerformed(ActionEvent a)
    {
        super.getOutput().setText("0");
        super.getInput().setText("");
        zeroButton.setEnabled(false);
    }
}