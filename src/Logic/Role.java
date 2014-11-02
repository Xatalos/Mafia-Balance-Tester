package Logic;

import java.util.Objects;

public class Role implements Comparable<Role> {
    
    private String name;
    private double balancevalue;
    private int team;

    public Role(String name, double balancevalue, int team) {
        this.name = name;
        this.balancevalue = balancevalue;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public double getBalancevalue() {
        return balancevalue;
    }


    public int getTeam() {
        return team;
    }

    @Override
    public String toString() {
        return name + " (" + balancevalue + ")";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.name);
        hash = (int) (43 * hash + this.balancevalue);
        hash = 43 * hash + Objects.hashCode(this.team);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Role other = (Role) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.balancevalue != other.balancevalue) {
            return false;
        }
        if (!Objects.equals(this.team, other.team)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Role role) {
        if (this.team > role.getTeam()) {
            return 1;
        }
        if (role.getTeam() > this.team) {
            return -1;
        }
        if (this.balancevalue > role.getBalancevalue()) {
            return 1;
        }
        if (role.getBalancevalue() > this.balancevalue) {
            return -1;
        }
 
        return 0;
    }

    
    
    
    
}
