package UI;

import Logic.Balance;
import Logic.Role;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class BalanceTester implements Runnable, ScrollPaneConstants {

    private JFrame frame;
    private Balance balance;
    private JButton add;
    private JButton remove;
    private JButton removeAll;
    private JButton day;
    private JButton night;
    private JButton rolesFromClipboard;
    private JButton rolesToClipboard;
    private ArrayList<JLabel> rolesList;
    private JLabel chosenRoles;
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

    public BalanceTester(Balance balance) {
        this.balance = balance;
        rolesList = new ArrayList<JLabel>();
        add = new JButton("Add Role");
        remove = new JButton("Remove Role");
        removeAll = new JButton("Remove All Roles");
        day = new JButton("Switch to Day Start");
        night = new JButton("Switch to Night Start");
        rolesFromClipboard = new JButton("Import Roles from Clipboard");
        rolesToClipboard = new JButton("Export Roles to Clipboard");
    }

    @Override
    public void run() {
        frame = new JFrame("Mafia Balance Tester");
        frame.setPreferredSize(new Dimension(900, 1000));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        createComponents(panel);



        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout grid = new GridLayout(1, 2);
        container.setLayout(grid);
        Border empty = new EmptyBorder(0, 20, 0, 0);
        Box rightSide = rightSide();
        Box leftSide = leftSide();
        leftSide.setBorder(empty);
        rightSide.setBorder(empty);
        JScrollPane scroll = new JScrollPane(container, VERTICAL_SCROLLBAR_ALWAYS, HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.getContentPane().add(scroll);
        container.add(leftSide);
        container.add(rightSide);
    }

    public Box leftSide() {
        Box box = new Box(1);
        Font font = new Font("Helvetica", Font.BOLD, 18);
        box.add(Box.createRigidArea(new Dimension(0, 5)));
        JLabel town = new JLabel("Town");
        town.setFont(font);
        box.add(town);
        JRadioButton vt = new JRadioButton("Vanilla Townie (+1)");
        JRadioButton vigi = new JRadioButton("One-Shot Vigilante (+2)");
        JRadioButton doctor = new JRadioButton("Doctor (no self-save) (+3)");
        JRadioButton cop = new JRadioButton("Cop (+4)");
        JRadioButton goon = new JRadioButton("Mafia Goon (-4.25)");
        JRadioButton rb = new JRadioButton("Mafia Roleblocker (-4.25/-6)");
        JRadioButton gf = new JRadioButton("Mafia Godfather (-4.25/-6)");
        JRadioButton sk = new JRadioButton("Serial Killer (check-immunity OR NK-immunity) (-3.5)");
        JRadioButton surv = new JRadioButton("Survivor (only needs to live at endgame) (0)");
        JRadioButton antitownsurv = new JRadioButton("Anti-Town Survivor (needs to live and town to lose) (-3)");
        JRadioButton assassin = new JRadioButton("Assassin (1 bullet, 1 check/night, NK-immune) (-1)");
        JRadioButton innoc = new JRadioButton("Innocent Child (+2)");
        JRadioButton mason = new JRadioButton("Mason (+2)");
        JRadioButton pcop = new JRadioButton("Parity Cop (can self-target) (+3)");
        JRadioButton jailer = new JRadioButton("Jailkeeper (roleblock+save) (+3)");
        JRadioButton vet = new JRadioButton("Veteran (1 extra HP) (+2)");
        JRadioButton townrb = new JRadioButton("Roleblocker (can prevent KP) (+2)");
        JRadioButton tracker = new JRadioButton("Tracker (+3)");
        JRadioButton watcher = new JRadioButton("Watcher (+2)");
        JRadioButton nn = new JRadioButton("Nosy Neighbor (-1/+1)");
        JRadioButton miller = new JRadioButton("Miller (-2/+1)");
        JRadioButton mafiamason = new JRadioButton("Mafia Mason (-4.25/-5)");
        JRadioButton framer = new JRadioButton("Mafia Framer (-4.25/-6)");
        JRadioButton rolecop = new JRadioButton("Mafia Rolecop (-4.25/-6)");
        ButtonGroup group = new ButtonGroup();
        group.add(vt);
        group.add(vigi);
        group.add(doctor);
        group.add(cop);
        group.add(goon);
        group.add(rb);
        group.add(gf);
        group.add(sk);
        group.add(surv);
        group.add(antitownsurv);
        group.add(assassin);
        group.add(innoc);
        group.add(mason);
        group.add(pcop);
        group.add(jailer);
        group.add(vet);
        group.add(townrb);
        group.add(tracker);
        group.add(watcher);
        group.add(nn);
        group.add(miller);
        group.add(mafiamason);
        group.add(framer);
        group.add(rolecop);
        box.add(vt);
        box.add(nn);
        box.add(miller);
        box.add(mason);
        box.add(townrb);
        box.add(innoc);
        box.add(vet);
        box.add(tracker);
        box.add(watcher);
        box.add(vigi);
        box.add(doctor);
        box.add(pcop);
        box.add(jailer);
        box.add(cop);
        box.add(new JLabel(" "));
        JLabel neutral = new JLabel("Neutral");
        neutral.setFont(font);
        box.add(neutral);
        box.add(sk);
        box.add(surv);
        box.add(antitownsurv);
        box.add(assassin);
        box.add(new JLabel(" "));
        JLabel mafia = new JLabel("Mafia");
        mafia.setFont(font);
        box.add(mafia);
        box.add(goon);
        box.add(rb);
        box.add(gf);
        box.add(mafiamason);
        box.add(framer);
        box.add(rolecop);
        box.add(add);
        box.add(remove);
        box.add(removeAll);
        box.add(day);
        box.add(night);
        box.add(rolesFromClipboard);
        box.add(rolesToClipboard);
        BalanceTesterListener listener = new BalanceTesterListener(add, remove, removeAll, day, night, rolesFromClipboard, rolesToClipboard, balance, frame, rolesList, players, balanceLabel, dayLabel, townOddsLabel, mafiaOddsLabel, skOddsLabel, survOddsLabel, aSurvOddsLabel, assassinOddsLabel, fastestTownLabel, fastestMafiaLabel, fastestMafiaLabel2, fastestMafiaLabel3, rightSideBox);
        WhichRoleListener listener2 = new WhichRoleListener(balance, vt, nn, miller, mason, innoc, vet, tracker, watcher, vigi, doctor, pcop, jailer, townrb, cop, sk, surv, antitownsurv, assassin, goon, rb, gf, mafiamason, framer, rolecop);

        vt.addActionListener(listener2);
        vigi.addActionListener(listener2);
        doctor.addActionListener(listener2);
        cop.addActionListener(listener2);
        goon.addActionListener(listener2);
        rb.addActionListener(listener2);
        gf.addActionListener(listener2);
        nn.addActionListener(listener2);
        miller.addActionListener(listener2);
        mason.addActionListener(listener2);
        innoc.addActionListener(listener2);
        vet.addActionListener(listener2);
        tracker.addActionListener(listener2);
        watcher.addActionListener(listener2);
        pcop.addActionListener(listener2);
        jailer.addActionListener(listener2);
        townrb.addActionListener(listener2);
        sk.addActionListener(listener2);
        surv.addActionListener(listener2);
        antitownsurv.addActionListener(listener2);
        assassin.addActionListener(listener2);
        mafiamason.addActionListener(listener2);
        framer.addActionListener(listener2);
        rolecop.addActionListener(listener2);

        add.addActionListener(listener);
        remove.addActionListener(listener);
        removeAll.addActionListener(listener);
        day.addActionListener(listener);
        night.addActionListener(listener);
        rolesFromClipboard.addActionListener(listener);
        rolesToClipboard.addActionListener(listener);

        if (balance.getWhichRoleIsChosen() == 0) {
            vt.setSelected(true);
        }
        if (balance.getWhichRoleIsChosen() == 1) {
            cop.setSelected(true);
        }
        if (balance.getWhichRoleIsChosen() == 2) {
            doctor.setSelected(true);
        }
        if (balance.getWhichRoleIsChosen() == 3) {
            vigi.setSelected(true);
        }
        if (balance.getWhichRoleIsChosen() == 4) {
            goon.setSelected(true);
        }
        if (balance.getWhichRoleIsChosen() == 5) {
            gf.setSelected(true);
        }
        if (balance.getWhichRoleIsChosen() == 6) {
            innoc.setSelected(true);
        }
        if (balance.getWhichRoleIsChosen() == 7) {
            mason.setSelected(true);
        }
        if (balance.getWhichRoleIsChosen() == 8) {
            pcop.setSelected(true);
        }
        if (balance.getWhichRoleIsChosen() == 9) {
            jailer.setSelected(true);
        }
        if (balance.getWhichRoleIsChosen() == 10) {
            assassin.setSelected(true);
        }
        if (balance.getWhichRoleIsChosen() == 11) {
            vet.setSelected(true);
        }
        if (balance.getWhichRoleIsChosen() == 12) {
            townrb.setSelected(true);
        }
        if (balance.getWhichRoleIsChosen() == 13) {
            tracker.setSelected(true);
        }
        if (balance.getWhichRoleIsChosen() == 14) {
            miller.setSelected(true);
        }
        if (balance.getWhichRoleIsChosen() == 15) {
            framer.setSelected(true);
        }
        if (balance.getWhichRoleIsChosen() == 16) {
            watcher.setSelected(true);
        }
        if (balance.getWhichRoleIsChosen() == 17) {
            mafiamason.setSelected(true);
        }
        if (balance.getWhichRoleIsChosen() == 18) {
            nn.setSelected(true);
        }
        if (balance.getWhichRoleIsChosen() == 19) {
            rolecop.setSelected(true);
        }
        if (balance.getWhichRoleIsChosen() == 20) {
            sk.setSelected(true);
        }
        if (balance.getWhichRoleIsChosen() == 21) {
            surv.setSelected(true);
        }
        if (balance.getWhichRoleIsChosen() == 22) {
            antitownsurv.setSelected(true);
        }
        if (balance.getWhichRoleIsChosen() == 23) {
            rb.setSelected(true);
        }

        return box;

    }

    public Box rightSide() {

        rightSideBox = new Box(1);

        Font font = new Font("Helvetica", Font.BOLD, 18);
        Font font2 = new Font("Helvetica", Font.BOLD, 14);

        rightSideBox.add(Box.createRigidArea(new Dimension(0, 5)));

        String roleToString = "";

        for (Role role : balance.getChosenRoles()) {
            roleToString = role.toString();
            if (role.getBalancevalue() > 0) {
                roleToString = role.getName() + " (+" + role.getBalancevalue() + ")";
            }
            
            rolesList.add(new JLabel(roleToString));
        }

        players = new JLabel("Players: " + balance.howManyPlayers());
        String balancevalue = "" + balance.determineTownVsAntitownBalance();
        if (balance.determineTownVsAntitownBalance() > 0) {
            balancevalue = "+" + balancevalue;
        }
        balanceLabel = new JLabel("Balance: " + balancevalue);
        String start;
        if (balance.getDayStart() == true) {
            start = "Day Start";
        } else {
            start = "Night Start";
        }
        dayLabel = new JLabel("Day/Night Start: " + start);

        double townOdds = Math.round(balance.getTeamVictoryOdds(1) * 10000.0) / 100.0;
        double skOdds = Math.round(balance.getTeamVictoryOdds(2) * 10000.0) / 100.0;
        double survOdds = Math.round(balance.getTeamVictoryOdds(3) * 10000.0) / 100.0;
        double antitownSurvOdds = Math.round(balance.getTeamVictoryOdds(4) * 10000.0) / 100.0;
        double assassinOdds = Math.round(balance.getTeamVictoryOdds(5) * 10000.0) / 100.0;
        double mafiaOdds = Math.round(balance.getTeamVictoryOdds(6) * 10000.0) / 100.0;

        townOddsLabel = new JLabel("Town Victory Odds: " + townOdds + "%");
        mafiaOddsLabel = new JLabel("Mafia Victory Odds: " + mafiaOdds + "%");
        skOddsLabel = new JLabel("Single Serial Killer Victory Odds: " + skOdds + "%");
        survOddsLabel = new JLabel("Single Survivor Victory Odds: " + survOdds + "%");
        aSurvOddsLabel = new JLabel("Single Anti-Town Survivor Victory Odds: " + antitownSurvOdds + "%");
        assassinOddsLabel = new JLabel("Single Assassin Victory Odds: " + assassinOdds + "%");
        
        JLabel fastestVictories = new JLabel("Fastest Victories (Neutral Roles Ignored)");
        fastestVictories.setFont(font);
        fastestTownLabel = new JLabel("Town: " + balance.determineFastestVictoryForTown());
        fastestMafiaLabel = new JLabel("Mafia (1 KP): " + balance.determineFastestVictoryForMafia(1));
        fastestMafiaLabel2 = new JLabel("Mafia (2 KP): " + balance.determineFastestVictoryForMafia(2));
        fastestMafiaLabel3 = new JLabel("Mafia (3 KP): " + balance.determineFastestVictoryForMafia(3));

        BalanceTesterListener listener = new BalanceTesterListener(add, remove, removeAll, day, night, rolesFromClipboard, rolesToClipboard, balance, frame, rolesList, players, balanceLabel, dayLabel, townOddsLabel, mafiaOddsLabel, skOddsLabel, survOddsLabel, aSurvOddsLabel, assassinOddsLabel, fastestTownLabel, fastestMafiaLabel, fastestMafiaLabel2, fastestMafiaLabel3, rightSideBox);

        rightSideBox.add(Box.createRigidArea(new Dimension(0, 5)));

        ArrayList<Role> chosenRoles = balance.getChosenRoles();
        players.setFont(font);
        JLabel victoryOdds = new JLabel("Victory Odds");
        victoryOdds.setFont(font);
        dayLabel.setFont(font);
        rightSideBox.add(victoryOdds);

        rightSideBox.add(townOddsLabel);
        rightSideBox.add(mafiaOddsLabel);
        rightSideBox.add(skOddsLabel);
        rightSideBox.add(survOddsLabel);
        rightSideBox.add(aSurvOddsLabel);
        rightSideBox.add(assassinOddsLabel);
        rightSideBox.add(new JLabel(" "));
        rightSideBox.add(fastestVictories);
        rightSideBox.add(fastestTownLabel);
        rightSideBox.add(fastestMafiaLabel);
        rightSideBox.add(fastestMafiaLabel2);
        rightSideBox.add(fastestMafiaLabel3);

        rightSideBox.add(new JLabel(" "));
        rightSideBox.add(dayLabel);
        rightSideBox.add(new JLabel(" "));

        rightSideBox.add(players);
        rightSideBox.add(new JLabel(" "));

        balanceLabel.setFont(font);
        rightSideBox.add(balanceLabel);
        rightSideBox.add(new JLabel(" "));

        JLabel roles = new JLabel("Chosen Roles");
        roles.setFont(font);
        rightSideBox.add(roles);

        for (JLabel label : rolesList) {
            rightSideBox.add(label);
        }

        return rightSideBox;
    }
}
