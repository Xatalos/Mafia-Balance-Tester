package UI;

import Logic.Balance;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;

public class HowManyPlayers implements Runnable {

    private JFrame frame;
    private Balance balance;
    private JComboBox choice;

    public HowManyPlayers(Balance balance) {
        this.balance = balance;
    }

    @Override
    public void run() {
        frame = new JFrame("Mafia Balance Tester");
        frame.setPreferredSize(new Dimension(200, 120));

        createComponents(frame.getContentPane());

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);

        container.add(new JLabel("How many players?"));
        Integer[] howManyPlayers = {8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
        this.choice = new JComboBox(howManyPlayers);
        container.add(choice);
        JButton ok = new JButton("OK");
        container.add(ok);
        HowManyPlayersListener listener = new HowManyPlayersListener(choice, ok, balance, frame);
        ok.addActionListener(listener);

    }
}