package core.actors.exploringactors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import core.framework.BaseActor;
/**
 * Exploring actor used in the exploring map.
 * The class has a constructor to initialize the class with animation and sets up the default animation to idle.
 */

public class Morten extends BaseActor{
        private Animation idle;
        private float facingAngle;


    /**
     * Constructor that initialize Morten with the animations and default animation.
     * @param x X coordinates where the actor is created
     * @param y Y coordinates where the actor is created
     * @param s Stage where the actor is created
     */
    public Morten (float x, float y, Stage s)
        {
            super(x,y,s);
            String fileName = "assets/Fightingscreen/Boss/Morten-Idle.png";
            int rows = 1;
            int cols = 8;
            Texture texture = new Texture( Gdx.files.internal(fileName), true);
            int frameWidth = texture.getWidth() / cols;
            int frameHeight = texture.getHeight() / rows;
            float frameDuration = 0.1f;
            TextureRegion[][] temp = TextureRegion.split(texture, frameWidth, frameHeight);
            Array<TextureRegion> textureArray = new Array<TextureRegion>();

            for (int c = 0; c < cols; c++)
                textureArray.add( temp[0][c] );
            idle = new Animation(frameDuration, textureArray, Animation.PlayMode.LOOP_PINGPONG);
            textureArray.clear();

            setAnimation ( idle );
            setScale (1);
            setBoundaryPolygon(8);
            boundToWorld();


        }
    public void act(float dt)
    {
        super.act(dt);

        alignCamera();
        boundToWorld();
        applyPhysics(dt);
    }

    }
