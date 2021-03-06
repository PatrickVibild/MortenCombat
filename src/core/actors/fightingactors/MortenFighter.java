package core.actors.fightingactors;

import com.badlogic.gdx.scenes.scene2d.Stage;
import core.utils.FighterBalanceVariables;
/**
 * EnemyFighter: MortenFighter.
 * Used in the fighting screen and represent an enemy. The class has a constructor that initializes the actor
 * with idle, attack and dead animation.
 */
public class MortenFighter extends EnemyFighters {
    public MortenFighter(Stage s){
        super(s);
        this.setHP( FighterBalanceVariables.MORTENHP);
        this.setMaxHP(FighterBalanceVariables.MORTENMAXHP);
        this.setFighterName(FighterBalanceVariables.MORTENNAME);

        attack = AnimationCreator.createAnimation("assets/Fightingscreen/Boss/Morten-Attack.png", 0.14f,1,4);
        iddle = AnimationCreator.createAnimation("assets/Fightingscreen/Boss/Morten-Idle.png", 0.14f, 1, 8);
        dead = AnimationCreator.createAnimation("assets/Fightingscreen/Boss/Morten-Dead.png", 0.14f, 1, 9);

        setAnimation(iddle);

    }
    /**
     * AttackOne from Morten deal 50 to another figther.
     * @param fighter target fighter we will attack.
     * @return always true.
     */
    @Override
    public boolean attackOne(Fighter fighter){
        int damage = 50;
        fighter.setHP(fighter.getHP()-damage);
        return true;
    }

    /**
     * Attack two makes 55% damage of target current HP
     * @param fighter target fighter we will attack.
     * @return always true.
     */
    @Override
    public boolean attackTwo(Fighter fighter){
//        fighter.setHP((fighter.getHP()*(45)/100));
        if (fighter instanceof Poisonable){
            Poisonable temporalF = (Poisonable)fighter;
            temporalF.poison(2,fighter);
        }
        return true;
    }
    public void updateManaBar() { }
}
