package core.actors.fightingactors;

public abstract class Champion extends Figther {

    /**
     * return 1 if the ability is possible
     * return -1 if there is missing resources to make the ability
     * @param fighter target for the attack
     * @return 1: if possible; -1: if not possible.
     */
    abstract boolean attackThree (Figther fighter);

}