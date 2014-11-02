package UI;

import Logic.Balance;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class WhichRoleListener implements ActionListener {
    
    private Balance balance;
    private JRadioButton vt;
    private JRadioButton nn;
    private JRadioButton miller;
    private JRadioButton mason;
    private JRadioButton innoc;
    private JRadioButton vet;
    private JRadioButton tracker;
    private JRadioButton watcher;
    private JRadioButton vigi;
    private JRadioButton doctor;
    private JRadioButton pcop;
    private JRadioButton jailer;
    private JRadioButton townrb;
    private JRadioButton cop;
    private JRadioButton sk;
    private JRadioButton surv;
    private JRadioButton antitownsurv;
    private JRadioButton assassin;
    private JRadioButton goon;
    private JRadioButton rb;
    private JRadioButton gf;
    private JRadioButton mafiamason;
    private JRadioButton framer;
    private JRadioButton rolecop;

    public WhichRoleListener(Balance balance, JRadioButton vt, JRadioButton nn, JRadioButton miller, JRadioButton mason, JRadioButton innoc, JRadioButton vet, JRadioButton tracker, JRadioButton watcher, JRadioButton vigi, JRadioButton doctor, JRadioButton pcop, JRadioButton jailer, JRadioButton townrb, JRadioButton cop, JRadioButton sk, JRadioButton surv, JRadioButton antitownsurv, JRadioButton assassin, JRadioButton goon, JRadioButton rb, JRadioButton gf, JRadioButton mafiamason, JRadioButton framer, JRadioButton rolecop) {
        this.balance = balance;
        this.vt = vt;
        this.nn = nn;
        this.miller = miller;
        this.mason = mason;
        this.innoc = innoc;
        this.vet = vet;
        this.tracker = tracker;
        this.watcher = watcher;
        this.vigi = vigi;
        this.doctor = doctor;
        this.pcop = pcop;
        this.jailer = jailer;
        this.townrb = townrb;
        this.cop = cop;
        this.sk = sk;
        this.surv = surv;
        this.antitownsurv = antitownsurv;
        this.assassin = assassin;
        this.goon = goon;
        this.rb = rb;
        this.gf = gf;
        this.mafiamason = mafiamason;
        this.framer = framer;
        this.rolecop = rolecop;
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vt) {
            balance.setWhichRoleIsChosen(0);  
        }
        if (e.getSource() == vigi) {
            balance.setWhichRoleIsChosen(3);
        }
        if (e.getSource() == doctor) {
            balance.setWhichRoleIsChosen(2);
        }
        if (e.getSource() == cop) {
            balance.setWhichRoleIsChosen(1);
        }
        if (e.getSource() == goon) {
            balance.setWhichRoleIsChosen(4);
        }
        if (e.getSource() == gf) {
            balance.setWhichRoleIsChosen(5);
        }
        if (e.getSource() == innoc) {
            balance.setWhichRoleIsChosen(6);
        }
        if (e.getSource() == mason) {
            balance.setWhichRoleIsChosen(7);
        }
        if (e.getSource() == pcop) {
            balance.setWhichRoleIsChosen(8);
        }
        if (e.getSource() == jailer) {
            balance.setWhichRoleIsChosen(9);
        }
        if (e.getSource() == assassin) {
            balance.setWhichRoleIsChosen(10);
        }
        if (e.getSource() == vet) {
            balance.setWhichRoleIsChosen(11);
        }
        if (e.getSource() == townrb) {
            balance.setWhichRoleIsChosen(12);
        }
        if (e.getSource() == tracker) {
            balance.setWhichRoleIsChosen(13);
        }
        if (e.getSource() == miller) {
            balance.setWhichRoleIsChosen(14);
        }
        if (e.getSource() == framer ) {
            balance.setWhichRoleIsChosen(15);
        }
        if (e.getSource() == watcher) {
            balance.setWhichRoleIsChosen(16);
        }
        if (e.getSource() == mafiamason) {
            balance.setWhichRoleIsChosen(17);
        }
        if (e.getSource() == nn) {
            balance.setWhichRoleIsChosen(18);
        }
        if (e.getSource() == rolecop) {
            balance.setWhichRoleIsChosen(19);
        }
        if (e.getSource() == sk) {
            balance.setWhichRoleIsChosen(20);
        }
        if (e.getSource() == surv) {
            balance.setWhichRoleIsChosen(21);
        }
        if (e.getSource() == antitownsurv) {
            balance.setWhichRoleIsChosen(22);
        }
        if (e.getSource() == rb) {
            balance.setWhichRoleIsChosen(23);
        }
    }
}