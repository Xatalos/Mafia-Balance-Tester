package UI;

import Logic.Balance;
import Logic.Role;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.datatransfer.*;
import javax.swing.SwingUtilities;
import java.util.Scanner;

public class BalanceTesterListener implements ActionListener {

    private JButton add;
    private JButton remove;
    private JButton removeAll;
    private JButton day;
    private JButton night;
    private JButton rolesFromClipboard;
    private JButton rolesToClipboard;
    private Balance balance;
    private JFrame frame;
    private ArrayList<JLabel> rolesList;
    private JLabel players;
    private JLabel balanceLabel;
    private JLabel dayLabel;
    private JLabel townOddsLabel;
    private JLabel mafiaOddsLabel;
    private JLabel skOddsLabel;
    private JLabel survOddsLabel;
    private JLabel aSurvOddsLabel;
    private JLabel assassinOddsLabel;
    private JLabel fastestTownLabel;
    private JLabel fastestMafiaLabel;
    private JLabel fastestMafiaLabel2;
    private JLabel fastestMafiaLabel3;
    private Box rightSideBox;

    public BalanceTesterListener(JButton add, JButton remove, JButton removeAll, JButton day, JButton night, JButton rolesFromClipboard, JButton rolesToClipboard, Balance balance, JFrame frame, ArrayList<JLabel> rolesList, JLabel players, JLabel balanceLabel, JLabel dayLabel, JLabel townOddsLabel, JLabel mafiaOddsLabel, JLabel skOddsLabel, JLabel survOddsLabel, JLabel aSurvOddsLabel, JLabel assassinOddsLabel, JLabel fastestTownLabel, JLabel fastestMafiaLabel, JLabel fastestMafiaLabel2, JLabel fastestMafiaLabel3, Box rightSideBox) {
        this.add = add;
        this.remove = remove;
        this.removeAll = removeAll;
        this.day = day;
        this.night = night;
        this.rolesFromClipboard = rolesFromClipboard;
        this.rolesToClipboard = rolesToClipboard;
        this.balance = balance;
        this.frame = frame;
        this.rolesList = rolesList;
        this.players = players;
        this.balanceLabel = balanceLabel;
        this.dayLabel = dayLabel;
        this.townOddsLabel = townOddsLabel;
        this.mafiaOddsLabel = mafiaOddsLabel;
        this.skOddsLabel = skOddsLabel;
        this.survOddsLabel = survOddsLabel;
        this.aSurvOddsLabel = aSurvOddsLabel;
        this.assassinOddsLabel = assassinOddsLabel;
        this.fastestTownLabel = fastestTownLabel;
        this.fastestMafiaLabel = fastestMafiaLabel;
        this.fastestMafiaLabel2 = fastestMafiaLabel2;
        this.fastestMafiaLabel3 = fastestMafiaLabel3;
        this.rightSideBox = rightSideBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add) {
            balance.addChosenRole(balance.getWhichRoleIsChosen());
            balance.implementAllDefaultRoles();
            balance.rolesInOrder();

            ArrayList<Role> chosenRoles2 = new ArrayList<Role>();
            
            for (Role role : balance.getChosenRoles()) {
                if (role.getName().equals(balance.getSpecificRole(0).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(0));
                }
                if (role.getName().equals(balance.getSpecificRole(1).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(1));
                }
                if (role.getName().equals(balance.getSpecificRole(2).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(2));
                }
                if (role.getName().equals(balance.getSpecificRole(3).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(3));
                }
                if (role.getName().equals(balance.getSpecificRole(4).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(4));
                }
                if (role.getName().equals(balance.getSpecificRole(5).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(5));
                }
                if (role.getName().equals(balance.getSpecificRole(6).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(6));
                }
                if (role.getName().equals(balance.getSpecificRole(7).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(7));
                }
                if (role.getName().equals(balance.getSpecificRole(8).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(8));
                }
                if (role.getName().equals(balance.getSpecificRole(9).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(9));
                }
                if (role.getName().equals(balance.getSpecificRole(10).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(10));
                }
                if (role.getName().equals(balance.getSpecificRole(11).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(11));
                }
                if (role.getName().equals(balance.getSpecificRole(12).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(12));
                }
                if (role.getName().equals(balance.getSpecificRole(13).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(13));
                }
                if (role.getName().equals(balance.getSpecificRole(14).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(14));
                }
                if (role.getName().equals(balance.getSpecificRole(15).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(15));
                }
                if (role.getName().equals(balance.getSpecificRole(16).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(16));
                }
                if (role.getName().equals(balance.getSpecificRole(17).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(17));
                }
                if (role.getName().equals(balance.getSpecificRole(18).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(18));
                }
                if (role.getName().equals(balance.getSpecificRole(19).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(19));
                }
                if (role.getName().equals(balance.getSpecificRole(20).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(20));
                }
                if (role.getName().equals(balance.getSpecificRole(21).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(21));
                }
                if (role.getName().equals(balance.getSpecificRole(22).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(22));
                }
                if (role.getName().equals(balance.getSpecificRole(23).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(23));
                }

            }

            ArrayList<Role> chosenRoles3 = new ArrayList<Role>();
            balance.setChosenRoles(chosenRoles3);

            for (Role role : chosenRoles2) {
                if (role.getName().equals(balance.getSpecificRole(0).getName())) {
                    balance.addChosenRole(0);
                }
                if (role.getName().equals(balance.getSpecificRole(1).getName())) {
                    balance.addChosenRole(1);
                }
                if (role.getName().equals(balance.getSpecificRole(2).getName())) {
                    balance.addChosenRole(2);
                }
                if (role.getName().equals(balance.getSpecificRole(3).getName())) {
                    balance.addChosenRole(3);
                }
                if (role.getName().equals(balance.getSpecificRole(4).getName())) {
                    balance.addChosenRole(4);
                }
                if (role.getName().equals(balance.getSpecificRole(5).getName())) {
                    balance.addChosenRole(5);
                }
                if (role.getName().equals(balance.getSpecificRole(6).getName())) {
                    balance.addChosenRole(6);
                }
                if (role.getName().equals(balance.getSpecificRole(7).getName())) {
                    balance.addChosenRole(7);
                }
                if (role.getName().equals(balance.getSpecificRole(8).getName())) {
                    balance.addChosenRole(8);
                }
                if (role.getName().equals(balance.getSpecificRole(9).getName())) {
                    balance.addChosenRole(9);
                }
                if (role.getName().equals(balance.getSpecificRole(10).getName())) {
                    balance.addChosenRole(10);
                }
                if (role.getName().equals(balance.getSpecificRole(11).getName())) {
                    balance.addChosenRole(11);
                }
                if (role.getName().equals(balance.getSpecificRole(12).getName())) {
                    balance.addChosenRole(12);
                }
                if (role.getName().equals(balance.getSpecificRole(13).getName())) {
                    balance.addChosenRole(13);
                }
                if (role.getName().equals(balance.getSpecificRole(14).getName())) {
                    balance.addChosenRole(14);
                }
                if (role.getName().equals(balance.getSpecificRole(15).getName())) {
                    balance.addChosenRole(15);
                }
                if (role.getName().equals(balance.getSpecificRole(16).getName())) {
                    balance.addChosenRole(16);
                }
                if (role.getName().equals(balance.getSpecificRole(17).getName())) {
                    balance.addChosenRole(17);
                }
                if (role.getName().equals(balance.getSpecificRole(18).getName())) {
                    balance.addChosenRole(18);
                }
                if (role.getName().equals(balance.getSpecificRole(19).getName())) {
                    balance.addChosenRole(19);
                }
                if (role.getName().equals(balance.getSpecificRole(20).getName())) {
                    balance.addChosenRole(20);
                }
                if (role.getName().equals(balance.getSpecificRole(21).getName())) {
                    balance.addChosenRole(21);
                }
                if (role.getName().equals(balance.getSpecificRole(22).getName())) {
                    balance.addChosenRole(22);
                }
                if (role.getName().equals(balance.getSpecificRole(23).getName())) {
                    balance.addChosenRole(23);
                }
            }

            balance.setChosenRoles(chosenRoles2);

            updateRightSideLabels();
        }

        if (e.getSource() == remove) {
            balance.removeChosenRole(balance.getWhichRoleIsChosen());
            balance.implementAllDefaultRoles();
            balance.rolesInOrder();

            ArrayList<Role> chosenRoles2 = new ArrayList<Role>();

            for (Role role : balance.getChosenRoles()) {
                if (role.getName().equals(balance.getSpecificRole(0).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(0));
                }
                if (role.getName().equals(balance.getSpecificRole(1).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(1));
                }
                if (role.getName().equals(balance.getSpecificRole(2).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(2));
                }
                if (role.getName().equals(balance.getSpecificRole(3).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(3));
                }
                if (role.getName().equals(balance.getSpecificRole(4).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(4));
                }
                if (role.getName().equals(balance.getSpecificRole(5).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(5));
                }
                if (role.getName().equals(balance.getSpecificRole(6).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(6));
                }
                if (role.getName().equals(balance.getSpecificRole(7).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(7));
                }
                if (role.getName().equals(balance.getSpecificRole(8).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(8));
                }
                if (role.getName().equals(balance.getSpecificRole(9).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(9));
                }
                if (role.getName().equals(balance.getSpecificRole(10).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(10));
                }
                if (role.getName().equals(balance.getSpecificRole(11).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(11));
                }
                if (role.getName().equals(balance.getSpecificRole(12).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(12));
                }
                if (role.getName().equals(balance.getSpecificRole(13).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(13));
                }
                if (role.getName().equals(balance.getSpecificRole(14).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(14));
                }
                if (role.getName().equals(balance.getSpecificRole(15).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(15));
                }
                if (role.getName().equals(balance.getSpecificRole(16).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(16));
                }
                if (role.getName().equals(balance.getSpecificRole(17).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(17));
                }
                if (role.getName().equals(balance.getSpecificRole(18).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(18));
                }
                if (role.getName().equals(balance.getSpecificRole(19).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(19));
                }
                if (role.getName().equals(balance.getSpecificRole(20).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(20));
                }
                if (role.getName().equals(balance.getSpecificRole(21).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(21));
                }
                if (role.getName().equals(balance.getSpecificRole(22).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(22));
                }
                if (role.getName().equals(balance.getSpecificRole(23).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(23));
                }

            }
            balance.setChosenRoles(chosenRoles2);

            updateRightSideLabels();
        }
        
        if (e.getSource()
                == removeAll) {
            ArrayList<Role> chosenRoles2 = new ArrayList<Role>();
            balance.setChosenRoles(chosenRoles2);

            updateRightSideLabels();
        }

        if (e.getSource()
                == day) {
            balance.setDayStart();

            updateRightSideLabels();
        }

        if (e.getSource()
                == night) {
            balance.setNightStart();

            updateRightSideLabels();
        }

        if (e.getSource()
                == rolesFromClipboard) {
            String result = "";
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable contents = clipboard.getContents(null);
            boolean hasTransferableText =
                    (contents != null)
                    && contents.isDataFlavorSupported(DataFlavor.stringFlavor);
            if (hasTransferableText) {
                try {
                    result = (String) contents.getTransferData(DataFlavor.stringFlavor);
                } catch (UnsupportedFlavorException | IOException ex) {
                    System.out.println(ex);
                    ex.printStackTrace();
                }


            }
            ArrayList<Role> chosenRoles2 = new ArrayList<Role>();
            balance.setChosenRoles(chosenRoles2);

            Scanner scanner = new Scanner(result);
            String result2 = "";


            while (scanner.hasNextLine()) {
                result2 = scanner.nextLine();
                if (result2.equals(balance.getSpecificRole(0).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(0));
                }
                if (result2.equals(balance.getSpecificRole(1).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(1));
                }
                if (result2.equals(balance.getSpecificRole(2).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(2));
                }
                if (result2.equals(balance.getSpecificRole(3).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(3));
                }
                if (result2.equals(balance.getSpecificRole(4).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(4));
                }
                if (result2.equals(balance.getSpecificRole(5).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(5));
                }
                if (result2.equals(balance.getSpecificRole(6).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(6));
                }
                if (result2.equals(balance.getSpecificRole(7).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(7));
                }
                if (result2.equals(balance.getSpecificRole(8).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(8));
                }
                if (result2.equals(balance.getSpecificRole(9).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(9));
                }
                if (result2.equals(balance.getSpecificRole(10).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(10));
                }
                if (result2.equals(balance.getSpecificRole(11).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(11));
                }
                if (result2.equals(balance.getSpecificRole(12).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(12));
                }
                if (result2.equals(balance.getSpecificRole(13).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(13));
                }
                if (result2.equals(balance.getSpecificRole(14).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(14));
                }
                if (result2.equals(balance.getSpecificRole(15).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(15));
                }
                if (result2.equals(balance.getSpecificRole(16).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(16));
                }
                if (result2.equals(balance.getSpecificRole(17).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(17));
                }
                if (result2.equals(balance.getSpecificRole(18).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(18));
                }
                if (result2.equals(balance.getSpecificRole(19).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(19));
                }
                if (result2.equals(balance.getSpecificRole(20).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(20));
                }
                if (result2.equals(balance.getSpecificRole(21).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(21));
                }
                if (result2.equals(balance.getSpecificRole(22).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(22));
                }
                if (result2.equals(balance.getSpecificRole(23).getName())) {
                    chosenRoles2.add(balance.getSpecificRole(23));
                }

            }

            balance.setChosenRoles(chosenRoles2);
            balance.rolesInOrder();
            balance.implementAllDefaultRoles();

            ArrayList<Role> chosenRoles3 = new ArrayList<Role>();

            for (Role role : balance.getChosenRoles()) {
                if (role.equals(balance.getSpecificRole(0))) {
                    chosenRoles3.add(balance.getSpecificRole(0));
                }
                if (role.equals(balance.getSpecificRole(1))) {
                    chosenRoles3.add(balance.getSpecificRole(1));
                }
                if (role.equals(balance.getSpecificRole(2))) {
                    chosenRoles3.add(balance.getSpecificRole(2));
                }
                if (role.equals(balance.getSpecificRole(3))) {
                    chosenRoles3.add(balance.getSpecificRole(3));
                }
                if (role.equals(balance.getSpecificRole(4))) {
                    chosenRoles3.add(balance.getSpecificRole(4));
                }
                if (role.equals(balance.getSpecificRole(5))) {
                    chosenRoles3.add(balance.getSpecificRole(5));
                }
                if (role.equals(balance.getSpecificRole(6))) {
                    chosenRoles3.add(balance.getSpecificRole(6));
                }
                if (role.equals(balance.getSpecificRole(7))) {
                    chosenRoles3.add(balance.getSpecificRole(7));
                }
                if (role.equals(balance.getSpecificRole(8))) {
                    chosenRoles3.add(balance.getSpecificRole(8));
                }
                if (role.equals(balance.getSpecificRole(9))) {
                    chosenRoles3.add(balance.getSpecificRole(9));
                }
                if (role.equals(balance.getSpecificRole(10))) {
                    chosenRoles3.add(balance.getSpecificRole(10));
                }
                if (role.equals(balance.getSpecificRole(11))) {
                    chosenRoles3.add(balance.getSpecificRole(11));
                }
                if (role.equals(balance.getSpecificRole(12))) {
                    chosenRoles3.add(balance.getSpecificRole(12));
                }
                if (role.equals(balance.getSpecificRole(13))) {
                    chosenRoles3.add(balance.getSpecificRole(13));
                }
                if (role.equals(balance.getSpecificRole(14))) {
                    chosenRoles3.add(balance.getSpecificRole(14));
                }
                if (role.equals(balance.getSpecificRole(15))) {
                    chosenRoles3.add(balance.getSpecificRole(15));
                }
                if (role.equals(balance.getSpecificRole(16))) {
                    chosenRoles3.add(balance.getSpecificRole(16));
                }
                if (role.equals(balance.getSpecificRole(17))) {
                    chosenRoles3.add(balance.getSpecificRole(17));
                }
                if (role.equals(balance.getSpecificRole(18))) {
                    chosenRoles3.add(balance.getSpecificRole(18));
                }
                if (role.equals(balance.getSpecificRole(19))) {
                    chosenRoles3.add(balance.getSpecificRole(19));
                }
                if (role.equals(balance.getSpecificRole(20))) {
                    chosenRoles3.add(balance.getSpecificRole(20));
                }
                if (role.equals(balance.getSpecificRole(21))) {
                    chosenRoles3.add(balance.getSpecificRole(21));
                }
                if (role.equals(balance.getSpecificRole(22))) {
                    chosenRoles3.add(balance.getSpecificRole(22));
                }
                if (role.equals(balance.getSpecificRole(23))) {
                    chosenRoles3.add(balance.getSpecificRole(23));
                }

            }
            balance.setChosenRoles(chosenRoles3);

            updateRightSideLabels();

        }

        if (e.getSource()
                == rolesToClipboard) {
            String exportString = "";
            int x = 0;
            for (Role role : balance.getChosenRoles()) {
                if (x == 0) {
                    exportString += role.getName();
                } else {
                    exportString += "\n" + role.getName();
                }
                x++;
            }
            StringSelection selection = new StringSelection(exportString);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(selection, selection);
        }
    }

    public void updateRightSideLabels() {
        for (JLabel label : rolesList) {
            label.setText("");
        }

        rolesList.clear();

//            String roleToString = "";
//
//            for (Role role : balance.getChosenRoles()) {
//                roleToString = role.toString();
//                if (role.getBalancevalue() > 0 && role.getAmount() >= 1) {
//                    roleToString = role.getAmount() + "x " + role.getName() + " (+" + role.getBalancevalue() + ")";
//                }
//                if (role.getAmount() >= 1 && role.getBalancevalue() <= 0) {
//                    roleToString = role.getAmount() + "x " + role.toString();
//                }
//                rolesList.add(new JLabel(roleToString));
//            }

        String roleToString = "";

        for (Role role : balance.getChosenRoles()) {
            roleToString = role.toString();
            if (role.getBalancevalue() > 0) {
                roleToString = role.getName() + " (+" + role.getBalancevalue() + ")";
            }
            rolesList.add(new JLabel(roleToString));
        }

        players.setText("Players: " + balance.howManyPlayers());
        String balancevalue = "" + balance.determineTownVsAntitownBalance();
        if (balance.determineTownVsAntitownBalance() > 0) {
            balancevalue = "+" + balancevalue;
        }
        balanceLabel.setText("Balance: " + balancevalue);

        String start;
        if (balance.getDayStart() == true) {
            start = "Day Start";
        } else {
            start = "Night Start";
        }
        dayLabel.setText("Day/Night Start: " + start);

        double townOdds = Math.round(balance.getTeamVictoryOdds(1) * 10000.0) / 100.0;
        double skOdds = Math.round(balance.getTeamVictoryOdds(2) * 10000.0) / 100.0;
        double survOdds = Math.round(balance.getTeamVictoryOdds(3) * 10000.0) / 100.0;
        double antitownSurvOdds = Math.round(balance.getTeamVictoryOdds(4) * 10000.0) / 100.0;
        double assassinOdds = Math.round(balance.getTeamVictoryOdds(5) * 10000.0) / 100.0;
        double mafiaOdds = Math.round(balance.getTeamVictoryOdds(6) * 10000.0) / 100.0;

        townOddsLabel.setText("Town Victory Odds: " + townOdds + "%");
        mafiaOddsLabel.setText("Mafia Victory Odds: " + mafiaOdds + "%");
        skOddsLabel.setText("Single Serial Killer Victory Odds: " + skOdds + "%");
        survOddsLabel.setText("Single Survivor Victory Odds: " + survOdds + "%");
        aSurvOddsLabel.setText("Single Anti-Town Survivor Victory Odds: " + antitownSurvOdds + "%");
        assassinOddsLabel.setText("Single Assassin Victory Odds: " + assassinOdds + "%");

        fastestTownLabel.setText("Town: " + balance.determineFastestVictoryForTown());
        fastestMafiaLabel.setText("Mafia (1 KP): " + balance.determineFastestVictoryForMafia(1));
        fastestMafiaLabel2.setText("Mafia (2 KP): " + balance.determineFastestVictoryForMafia(2));
        fastestMafiaLabel3.setText("Mafia (3 KP): " + balance.determineFastestVictoryForMafia(3));

        for (JLabel label : rolesList) {
            rightSideBox.add(label);
        }
    }
}