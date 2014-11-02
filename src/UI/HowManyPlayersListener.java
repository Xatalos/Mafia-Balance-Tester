package UI;

import Logic.Balance;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class HowManyPlayersListener implements ActionListener {

    private JComboBox choice;
    private JButton ok;
    private Balance balance;
    JFrame frame;

    public HowManyPlayersListener(JComboBox choice, JButton ok, Balance balance, JFrame frame) {
        this.choice = choice;
        this.ok = ok;
        this.balance = balance;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        balance.generateBalancedDefaultSetup(choice.getSelectedIndex() + 8);
        frame.setVisible(false);
        SwingUtilities.invokeLater(new BalanceTester(balance));
    }
}
