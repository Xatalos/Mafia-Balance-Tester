package Logic;

import java.util.Comparator;

public class RolesInOrder implements Comparator<Role> {

    @Override
    public int compare(Role role1, Role role2) {
        if (role1.getTeam() == role2.getTeam()) {
            return (int) (Math.abs(role1.getBalancevalue()) - Math.abs(role2.getBalancevalue()));
        }
        return role1.getTeam() - role2.getTeam();
    }
}
