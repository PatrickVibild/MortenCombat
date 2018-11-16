package core.actors.fightingactors;

public abstract class Fighter {

    private String fighterName;
    private int HP;
    private int maxHP;

    /**
     * return 1 if the ability is possible
     * return -1 if there is missing resources to make the ability
     * @param fighter target for the attack
     * @return 1: if possible; -1: if not possible.
     */
    abstract public boolean attackOne (Fighter fighter);
    abstract public boolean attackTwo (Fighter fighter);

    public String getFighterName() {
        return fighterName;
    }
    public void setFighterName(String s){
        this.fighterName=s;
    }


    public int getHP() {
        return HP;
    }
    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getMaxHP() {
        return maxHP;
    }
    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

}
