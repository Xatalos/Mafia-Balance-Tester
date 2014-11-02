package Logic;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JLabel;

public class Balance {

    private ArrayList<Role> chosenRoles;
    private ArrayList<Role> allRoles;
    private int whichRoleIsChosen;
    private boolean dayStart;

    public Balance() {
        this.chosenRoles = new ArrayList<Role>();
        this.allRoles = new ArrayList<Role>();
        dayStart = true;
    }

    public ArrayList<Role> getChosenRoles() {
        return chosenRoles;
    }

    public void setChosenRoles(ArrayList<Role> list) {
        chosenRoles = list;
    }

    public ArrayList<Role> getAllRoles() {
        return allRoles;
    }

    public boolean getDayStart() {
        return dayStart;
    }

    public void setDayStart() {
        dayStart = true;
    }

    public void setNightStart() {
        dayStart = false;
    }

    public int howManyPlayers() {
        return chosenRoles.size();
    }

    public double getTeamVictoryOdds(int team) {
        ArrayList<Role> townRoles = new ArrayList<Role>();
        ArrayList<Role> mafiaRoles = new ArrayList<Role>();
        ArrayList<Role> skRoles = new ArrayList<Role>();
        ArrayList<Role> assassinRoles = new ArrayList<Role>();
        ArrayList<Role> survivorRoles = new ArrayList<Role>();
        ArrayList<Role> antitownSurvivorRoles = new ArrayList<Role>();

        for (Role role : chosenRoles) {
            if (role.getTeam() == 1) {
                townRoles.add(role);
            }
            if (role.getTeam() == 6) {
                mafiaRoles.add(role);
            }
            if (role.getTeam() == 2) {
                skRoles.add(role);
            }
            if (role.getTeam() == 5) {
                assassinRoles.add(role);
            }
            if (role.getTeam() == 3) {
                survivorRoles.add(role);
            }
            if (role.getTeam() == 4) {
                antitownSurvivorRoles.add(role);
            }

        }

        double townScore = 0;
        double mafiaScore = 0;
        double skScore = 0;
        double assassinScore = 0;
        double survivorScore = 0;

        for (Role role : townRoles) {
            if (role.equals(getSpecificRole(14)) && chosenRoles.contains(getSpecificRole(1))) {
                mafiaScore += Math.abs(role.getBalancevalue());
            } else if (role.equals(getSpecificRole(16)) && ((chosenRoles.contains(getSpecificRole(13)) || chosenRoles.contains(getSpecificRole(15))))) {
                mafiaScore += Math.abs(role.getBalancevalue());
            } else {
                townScore += Math.abs(role.getBalancevalue());
            }
        }

        for (Role role : mafiaRoles) {
            mafiaScore += Math.abs(role.getBalancevalue());
        }

        for (Role role : antitownSurvivorRoles) {
            mafiaScore += Math.abs(role.getBalancevalue());
        }

        for (Role role : skRoles) {
            skScore += 6;
        }

        for (Role role : assassinRoles) {
            mafiaScore += Math.abs(role.getBalancevalue());
        }

        if (dayStart == false) {
            if (chosenRoles.contains(getSpecificRole(19))) {
                skScore += 2;
            }

            mafiaScore += 3;

        }

        double allScore = townScore + mafiaScore + skScore;

        if (team == 1) {
            if (townRoles.size() == 0) {
                return 0;
            }
            if (mafiaRoles.size() + 1 >= townRoles.size() + skRoles.size() && dayStart == false) {
                return 0;
            }
            if (mafiaRoles.size() >= townRoles.size() + skRoles.size()) {
                return 0;
            }
            if (mafiaRoles.size() + skRoles.size() + antitownSurvivorRoles.size() == 0) {
                return 1;
            }
            return (double) townScore / allScore;
        }

        if (team == 6) {
            if (mafiaRoles.size() == 0) {
                return 0;
            }
            if (mafiaRoles.size() + 1 >= townRoles.size() + skRoles.size() && dayStart == false) {
                return 1;
            }
            if (mafiaRoles.size() >= townRoles.size() + skRoles.size()) {
                return 1;
            }
            return (double) (mafiaScore + assassinScore) / allScore;
        }

        if (team == 2) {
            if (skRoles.size() == 0) {
                return 0;
            }
            if (mafiaRoles.size() >= townRoles.size() + skRoles.size()) {
                return 0;
            }
            return (double) (skScore / skRoles.size()) / allScore;
        }

        if (team == 3) {
            if (survivorRoles.size() == 0) {
                return 0;
            }
            if (!chosenRoles.contains(getSpecificRole(21))) {
                return 0;
            }
            if (mafiaRoles.size() >= townRoles.size() + skRoles.size()) {
                return 1;
            }
            return (double) (townScore + mafiaScore) / allScore / 2.5;
        }

        if (team == 4) {
            if (antitownSurvivorRoles.size() == 0) {
                return 0;
            }
            if (mafiaRoles.size() == 0) {
                return (double) mafiaScore / allScore;
            }
            if (!chosenRoles.contains(getSpecificRole(22))) {
                return 0;
            }
            if (mafiaRoles.size() >= townRoles.size() + skRoles.size()) {
                return 1;
            }
            if (mafiaRoles.size() + 1 >= townRoles.size() + skRoles.size() && dayStart == false) {
                return 1;
            }
            return (double) (mafiaScore / 2) / allScore;
        }

        if (team == 5) {
            if (assassinRoles.size() == 0) {
                return 0;
            }
            if (assassinRoles.size() == 1) {
                return 1;
            }
            return 1 / (double) assassinRoles.size();

        }

        return 0;

    }

    public void addNewRole(String name, double balancevalue, int team) {
        Role role = new Role(name, balancevalue, team);
        allRoles.add(role);
    }

    public Role getSpecificRole(int roleNumber) {
        return allRoles.get(roleNumber);
    }

    public void addChosenRole(int roleNumber) {
        chosenRoles.add(getSpecificRole(roleNumber));
    }

    public void removeChosenRole(int roleNumber) {
        chosenRoles.remove(getSpecificRole(roleNumber));
    }

    public int getWhichRoleIsChosen() {
        return whichRoleIsChosen;
    }

    public void setWhichRoleIsChosen(int roleNumber) {
        whichRoleIsChosen = roleNumber;
    }

    public void rolesInOrder() {
        Collections.sort(chosenRoles, new RolesInOrder());
    }

    public String determineFastestVictoryForTown() {

        if (getTeamVictoryOdds(1) == 0 || getTeamVictoryOdds(1) == 1) {
            return "---";
        }

        ArrayList<Role> townRoles = new ArrayList<Role>();
        ArrayList<Role> mafiaRoles = new ArrayList<Role>();
        ArrayList<Role> skRoles = new ArrayList<Role>();
        ArrayList<Role> assassinRoles = new ArrayList<Role>();
        ArrayList<Role> survivorRoles = new ArrayList<Role>();
        ArrayList<Role> antitownSurvivorRoles = new ArrayList<Role>();
        ArrayList<Role> vigilantes = new ArrayList<Role>();

        for (Role role : chosenRoles) {
            if (role.getTeam() == 1) {
                townRoles.add(role);
            }
            if (role.equals(getSpecificRole(3))) {
                vigilantes.add(role);
            }
            if (role.getTeam() == 6) {
                mafiaRoles.add(role);
            }
            if (role.getTeam() == 2) {
                skRoles.add(role);
            }
            if (role.getTeam() == 5) {
                assassinRoles.add(role);
            }
            if (role.getTeam() == 3) {
                survivorRoles.add(role);
            }
            if (role.getTeam() == 4) {
                antitownSurvivorRoles.add(role);
            }
        }

//        ArrayList<String> dayStartVictoryTimes = new ArrayList<String>();
//        ArrayList<String> nightStartVictoryTimes = new ArrayList<String>();
//        
//        dayStartVictoryTimes.add("D1"); // 0
//        dayStartVictoryTimes.add("N1"); // 1
//        dayStartVictoryTimes.add("D2"); // 2
//        dayStartVictoryTimes.add("N2"); // 3
//        dayStartVictoryTimes.add("D3"); // 4
//        dayStartVictoryTimes.add("N3"); // 5
//        dayStartVictoryTimes.add("D4"); // 6
//        dayStartVictoryTimes.add("N4"); // 7
//        dayStartVictoryTimes.add("D5"); // 8
//        dayStartVictoryTimes.add("N5"); // 9
//        dayStartVictoryTimes.add("D6"); // 10
//        
//        nightStartVictoryTimes.add("N1"); // 0
//        nightStartVictoryTimes.add("D1"); // 1
//        nightStartVictoryTimes.add("N2"); // 2
//        nightStartVictoryTimes.add("D2"); // 3
//        nightStartVictoryTimes.add("N3"); // 4
//        nightStartVictoryTimes.add("D3"); // 5
//        nightStartVictoryTimes.add("N4"); // 6
//        nightStartVictoryTimes.add("D4"); // 7
//        nightStartVictoryTimes.add("N5"); // 8
//        nightStartVictoryTimes.add("D5"); // 9
//        nightStartVictoryTimes.add("N6"); // 10

        String victoryTime = "";

        if (dayStart == true) {
            if (mafiaRoles.size() == 1) {
                victoryTime = "D1";
            } else if (vigilantes.size() + 1 >= mafiaRoles.size()) {
                victoryTime = "N1";
            } else {
                victoryTime = "D" + (mafiaRoles.size() - vigilantes.size());
            }
        }

        if (dayStart == false) {
            if (vigilantes.size() >= mafiaRoles.size()) {
                victoryTime = "N1";
            } else if (mafiaRoles.size() - vigilantes.size() == 1) {
                victoryTime = "D1";
            } else {
                victoryTime = "D" + (mafiaRoles.size() - vigilantes.size());
            }
        }

        return victoryTime;
    }

    public String determineFastestVictoryForMafia(int KP) {

        if (getTeamVictoryOdds(6) == 0 || getTeamVictoryOdds(6) == 1) {
            return "---";
        }

        ArrayList<Role> townRoles = new ArrayList<Role>();
        ArrayList<Role> mafiaRoles = new ArrayList<Role>();
        ArrayList<Role> skRoles = new ArrayList<Role>();
        ArrayList<Role> assassinRoles = new ArrayList<Role>();
        ArrayList<Role> survivorRoles = new ArrayList<Role>();
        ArrayList<Role> antitownSurvivorRoles = new ArrayList<Role>();
        ArrayList<Role> vigilantes = new ArrayList<Role>();

        for (Role role : chosenRoles) {
            if (role.getTeam() == 1) {
                townRoles.add(role);
            }
            if (role.equals(getSpecificRole(3))) {
                vigilantes.add(role);
            }
            if (role.getTeam() == 6) {
                mafiaRoles.add(role);
            }
            if (role.getTeam() == 2) {
                skRoles.add(role);
            }
            if (role.getTeam() == 5) {
                assassinRoles.add(role);
            }
            if (role.getTeam() == 3) {
                survivorRoles.add(role);
            }
            if (role.getTeam() == 4) {
                antitownSurvivorRoles.add(role);
            }
        }

        String victoryTime = "";

        if (dayStart == true) {
            if (KP == 1) {
                if (mafiaRoles.size() + 1 == townRoles.size()) {
                    victoryTime = "D1";
                } else if (mafiaRoles.size() + 2 + vigilantes.size() >= townRoles.size()) {
                    victoryTime = "N1";
                } else {
                    for (int i = 2; i < 30; i = i + 1) {
                        if (mafiaRoles.size() + i + (i - 1) + vigilantes.size() >= townRoles.size()) {
                            return "D" + i;
                        }
                        if (mafiaRoles.size() + i + i + vigilantes.size() >= townRoles.size()) {
                            return "N" + i;
                        }
                    }
                }
            }
            if (KP == 2) {
                if (mafiaRoles.size() + 1 == townRoles.size()) {
                    victoryTime = "D1";
                } else if (mafiaRoles.size() + 3 + vigilantes.size() >= townRoles.size()) {
                    victoryTime = "N1";
                } else {
                    for (int i = 2; i < 30; i = i + 1) {
                        if (mafiaRoles.size() + i + ((i - 1) * 2) + vigilantes.size() >= townRoles.size()) {
                            return "D" + i;
                        }
                        if (mafiaRoles.size() + i + (i * 2) + vigilantes.size() >= townRoles.size()) {
                            return "N" + i;
                        }
                    }
                }
            }
            if (KP == 3) {
                if (mafiaRoles.size() + 1 == townRoles.size()) {
                    victoryTime = "D1";
                } else if (mafiaRoles.size() + 4 + vigilantes.size() >= townRoles.size()) {
                    victoryTime = "N1";
                } else {
                    for (int i = 2; i < 30; i = i + 1) {
                        if (mafiaRoles.size() + i + ((i - 1) * 3) + vigilantes.size() >= townRoles.size()) {
                            return "D" + i;
                        }
                        if (mafiaRoles.size() + i + (i * 3) + vigilantes.size() >= townRoles.size()) {
                            return "N" + i;
                        }
                    }
                }
            }
        }

        if (dayStart == false) {
            if (KP == 1) {
                if (mafiaRoles.size() + 1 + vigilantes.size() >= townRoles.size()) {
                    victoryTime = "N1";
                } else if (mafiaRoles.size() + 2 + vigilantes.size() >= townRoles.size()) {
                    victoryTime = "D1";
                } else {
                    for (int i = 2; i < 30; i = i + 1) {
                        if (mafiaRoles.size() + i + i + vigilantes.size() >= townRoles.size()) {
                            return "N" + i;
                        }
                        if (mafiaRoles.size() + i + i + vigilantes.size() + 1 >= townRoles.size()) {
                            return "D" + i;
                        }
                    }
                }
            }
            if (KP == 2) {
                if (mafiaRoles.size() + 2 + vigilantes.size() >= townRoles.size()) {
                    victoryTime = "N1";
                } else if (mafiaRoles.size() + 3 + vigilantes.size() >= townRoles.size()) {
                    victoryTime = "D1";
                } else {
                    for (int i = 2; i < 30; i = i + 1) {
                        if (mafiaRoles.size() + i + (i * 2) + vigilantes.size() >= townRoles.size()) {
                            return "N" + i;
                        }
                        if (mafiaRoles.size() + i + (i * 2) + vigilantes.size() + 1 >= townRoles.size()) {
                            return "D" + i;
                        }
                    }
                }
            }
            if (KP == 3) {
                if (mafiaRoles.size() + 3 + vigilantes.size() >= townRoles.size()) {
                    victoryTime = "N1";
                } else if (mafiaRoles.size() + 4 + vigilantes.size() >= townRoles.size()) {
                    victoryTime = "D1";
                } else {
                    for (int i = 2; i < 30; i = i + 1) {
                        if (mafiaRoles.size() + i + (i * 3) + vigilantes.size() >= townRoles.size()) {
                            return "N" + i;
                        }
                        if (mafiaRoles.size() + i + (i * 3) + vigilantes.size() + 1 >= townRoles.size()) {
                            return "D" + i;
                        }
                    }
                }
            }
        }

        return victoryTime;
    }

    public double determineTownVsAntitownBalance() {
        double balance = 0;
        if (chosenRoles.contains(getSpecificRole(19)) && dayStart == false) {
            balance -= 4;
        } else if (dayStart == false) {
            balance -= 3;
        }
        for (Role role : chosenRoles) {
            balance += role.getBalancevalue();
        }
        return balance;
    }

    public void implementAllDefaultRoles() {
        allRoles.clear();
        addNewRole("Vanilla Townie", 1, 1); // 0
        addNewRole("Cop", 4, 1); // 1
        addNewRole("Doctor (no self-save)", 3, 1); // 2
        addNewRole("One-Shot Vigilante", 2, 1); // 3
        addNewRole("Mafia Goon", -4.25, 6); // 4
        if (chosenRoles.contains(getSpecificRole(1))) {
            addNewRole("Mafia Godfather", -6, 6); // 5
        } else {
            addNewRole("Mafia Godfather", -4.25, 6); // 5
        }
        addNewRole("Innocent Child", 2, 1); // 6
        addNewRole("Mason", 2, 1); // 7
        addNewRole("Parity Cop (can self-target)", 3, 1); // 8
        addNewRole("Jailkeeper (roleblock+save)", 3, 1); // 9
        addNewRole("Assassin (1 bullet, 1 check/night, NK-immune)", -1, 5); // 10
        addNewRole("Veteran (1 extra HP)", 2, 1); // 11
        addNewRole("Roleblocker (can prevent KP)", 2, 1); // 12
        addNewRole("Tracker", 3, 1); // 13
        if (chosenRoles.contains(getSpecificRole(1)) || chosenRoles.contains(getSpecificRole(8))) {
            addNewRole("Miller", -2, 1); // 14
        } else {
            addNewRole("Miller", 1, 1); // 14
        }
        if (chosenRoles.contains(getSpecificRole(1)) || chosenRoles.contains(getSpecificRole(8))) {
            addNewRole("Mafia Framer", -6, 6); // 15
        } else {
            addNewRole("Mafia Framer", -4.25, 6); // 15
        }
        addNewRole("Watcher", 2, 1); // 16
        if (chosenRoles.contains(getSpecificRole(7))) {
            addNewRole("Mafia Mason", -5, 6); // 17
        } else {
            addNewRole("Mafia Mason", -4.25, 6); // 17
        }
        if (chosenRoles.contains(getSpecificRole(13)) || chosenRoles.contains(getSpecificRole(16))) {
            addNewRole("Nosy Neighbor", -1, 1); // 18
        } else {
            addNewRole("Nosy Neighbor", 1, 1); // 18
        }
        if (chosenRoles.contains(getSpecificRole(1)) || chosenRoles.contains(getSpecificRole(2)) || chosenRoles.contains(getSpecificRole(3)) || chosenRoles.contains(getSpecificRole(8)) || chosenRoles.contains(getSpecificRole(9)) || chosenRoles.contains(getSpecificRole(12)) || chosenRoles.contains(getSpecificRole(13)) || chosenRoles.contains(getSpecificRole(16))) {
            addNewRole("Mafia Rolecop", -6, 6); // 19
        } else {
            addNewRole("Mafia Rolecop", -4.25, 6); // 19
        }
        addNewRole("Serial Killer (check-immunity OR NK-immunity)", -3.5, 2); // 20
        addNewRole("Survivor (only needs to live at endgame)", 0, 3); // 21
        addNewRole("Anti-Town Survivor (needs to live and town to lose)", -3, 4); // 22
        if (chosenRoles.contains(getSpecificRole(1)) || chosenRoles.contains(getSpecificRole(2)) || chosenRoles.contains(getSpecificRole(3)) || chosenRoles.contains(getSpecificRole(8)) || chosenRoles.contains(getSpecificRole(9)) || chosenRoles.contains(getSpecificRole(12)) || chosenRoles.contains(getSpecificRole(13)) || chosenRoles.contains(getSpecificRole(16))) {
            addNewRole("Mafia Roleblocker", -6, 6); // 23
        } else {
            addNewRole("Mafia Roleblocker", -4.25, 6); // 23
        }
    }

    public void generateBalancedDefaultSetup(int players) {
        if (players == 8) {
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(1);
            implementAllDefaultRoles();
            addChosenRole(4);
            addChosenRole(4);
        }

        if (players == 9) {
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(1);
            implementAllDefaultRoles();
            addChosenRole(4);
            addChosenRole(23);
        }

        if (players == 10) {
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(1);
            implementAllDefaultRoles();
            addChosenRole(23);
            addChosenRole(5);
        }

        if (players == 11) {
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(2);
            addChosenRole(1);
            implementAllDefaultRoles();
            addChosenRole(4);
            addChosenRole(4);
            addChosenRole(4);
        }

        if (players == 12) {
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(2);
            addChosenRole(1);
            implementAllDefaultRoles();
            addChosenRole(4);
            addChosenRole(4);
            addChosenRole(23);
        }

        if (players == 13) {
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(2);
            addChosenRole(1);
            implementAllDefaultRoles();
            addChosenRole(4);
            addChosenRole(23);
            addChosenRole(5);
        }

        if (players == 14) {
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(3);
            addChosenRole(2);
            addChosenRole(1);
            implementAllDefaultRoles();
            addChosenRole(4);
            addChosenRole(4);
            addChosenRole(4);
            addChosenRole(4);
        }

        if (players == 15) {
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(3);
            addChosenRole(2);
            addChosenRole(1);
            implementAllDefaultRoles();
            addChosenRole(4);
            addChosenRole(4);
            addChosenRole(4);
            addChosenRole(23);
        }

        if (players == 16) {
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(11);
            addChosenRole(3);
            addChosenRole(2);
            addChosenRole(1);
            implementAllDefaultRoles();
            addChosenRole(4);
            addChosenRole(4);
            addChosenRole(23);
            addChosenRole(5);
        }

        if (players == 17) {
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(11);
            addChosenRole(3);
            addChosenRole(2);
            addChosenRole(1);
            implementAllDefaultRoles();
            addChosenRole(4);
            addChosenRole(4);
            addChosenRole(23);
            addChosenRole(5);
        }

        if (players == 18) {
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(11);
            addChosenRole(3);
            addChosenRole(2);
            addChosenRole(1);
            implementAllDefaultRoles();
            addChosenRole(4);
            addChosenRole(4);
            addChosenRole(23);
            addChosenRole(5);
        }

        if (players == 19) {
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(11);
            addChosenRole(3);
            addChosenRole(2);
            addChosenRole(1);
            implementAllDefaultRoles();
            addChosenRole(4);
            addChosenRole(4);
            addChosenRole(23);
            addChosenRole(5);
        }

        if (players == 20) {
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(11);
            addChosenRole(3);
            addChosenRole(2);
            addChosenRole(1);
            implementAllDefaultRoles();
            addChosenRole(4);
            addChosenRole(4);
            addChosenRole(4);
            addChosenRole(4);
            addChosenRole(4);
        }

        if (players == 21) {
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(11);
            addChosenRole(3);
            addChosenRole(2);
            addChosenRole(1);
            implementAllDefaultRoles();
            addChosenRole(4);
            addChosenRole(4);
            addChosenRole(4);
            addChosenRole(4);
            addChosenRole(23);
        }

        if (players == 22) {
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(11);
            addChosenRole(3);
            addChosenRole(2);
            addChosenRole(1);
            implementAllDefaultRoles();
            addChosenRole(4);
            addChosenRole(4);
            addChosenRole(4);
            addChosenRole(23);
            addChosenRole(5);
        }

        if (players == 23) {
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(11);
            addChosenRole(3);
            addChosenRole(2);
            addChosenRole(1);
            implementAllDefaultRoles();
            addChosenRole(4);
            addChosenRole(4);
            addChosenRole(4);
            addChosenRole(23);
            addChosenRole(5);
        }

        if (players == 24) {
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(0);
            addChosenRole(11);
            addChosenRole(3);
            addChosenRole(2);
            addChosenRole(1);
            implementAllDefaultRoles();
            addChosenRole(4);
            addChosenRole(4);
            addChosenRole(4);
            addChosenRole(23);
            addChosenRole(5);
        }
    }
}
