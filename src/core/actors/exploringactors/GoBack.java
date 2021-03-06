package core.actors.exploringactors;

import com.badlogic.gdx.scenes.scene2d.Stage;
import core.framework.BaseActor;

/**
 * This is the point where the hero can go back to a previously visited map.
 * When the hero hits this it switches to the previous map.
 */

public class GoBack extends BaseActor
{
    public GoBack(float x, float y, Stage s)
    {
        super(x,y,s);
        loadTexture("assets/img/cavernopening.png");
        setBoundaryPolygon(8);
    }
}