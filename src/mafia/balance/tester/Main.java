package mafia.balance.tester;

import Logic.Balance;
import Logic.Role;
import UI.BalanceTester;
import UI.HowManyPlayers;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        Balance balance = new Balance();
        balance.implementAllDefaultRoles();
        SwingUtilities.invokeLater(new HowManyPlayers(balance));
    }
}
