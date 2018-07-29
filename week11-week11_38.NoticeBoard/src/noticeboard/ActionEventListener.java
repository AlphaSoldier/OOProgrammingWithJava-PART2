package noticeboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ActionEventListener implements ActionListener
{
    private JTextField source;
    private JLabel destination;

    public ActionEventListener(JTextField source, JLabel destination) {
        this.source = source;
        this.destination = destination;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.destination.setText(this.source.getText());
        this.source.setText("");
    }
}