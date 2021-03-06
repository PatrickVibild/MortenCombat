package core.utils;

import com.badlogic.gdx.scenes.scene2d.Stage;
import core.framework.DropTargetActor;

/**
 * This is the empty slots for the characters in the SelectionScreen.
 * It is an target area that saves what character have been chosen.
 */

public class SelectionArea extends DropTargetActor {

    private int heroType; //fighter = 1, mage = 2, support = 3.
    private int heroNumber = 0; // fighter 1 or 2, mage 1 or 2, support 1 or 2.

    public SelectionArea(float x, float y, Stage s) {

        super(x, y, s);
        loadTexture("assets/img/CharacterCardEmpty.png");
        setSize(125,200);
        setBoundaryRectangle();

    }

    public int getHeroType()                    { return heroType;              }
    public void setHeroType(int heroType)       { this.heroType = heroType;     }
    public int getHeroNumber()                  { return heroNumber;            }
    public void setHeroNumber(int heroNumber)   { this.heroNumber = heroNumber; }

}
