package M1_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerInterfaceDemo implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }
}
