package core.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import core.utils.MortenKombat;
import core.framework.BaseActor;
import core.framework.BaseScreen;
import core.utils.CharacterCard;
import core.utils.SelectionArea;

/**
 * This is the hero selection screen. Here the player selects the three heroes to take with them into the maze.
 * This is done dragging cards with the different characters on them.
 * This class creates the cards and tells the game what characters the player selected.
 */

public class SelectionScreen extends BaseScreen {

    private BaseScreen menu;
    private int totalHeroes = 0;
    private static SelectionArea[] selectedHeroes = new SelectionArea[3];
    private static CharacterCard[] heroCards = new CharacterCard[6];

    public SelectionScreen(BaseScreen menu) {
        super();
        this.menu = menu;
    }

    @Override
    public void initialize() {

        BaseActor background = new BaseActor(0,0, mainStage);
        background.loadTexture("assets/img/WoodBackground.png");
        background.setSize(800,600);

        BaseActor fighterTitle = new BaseActor(162,390,mainStage);
        fighterTitle.loadTexture("assets/img/FighterHeadLine.png");

        BaseActor mageTitle = new BaseActor(362,390,mainStage);
        mageTitle.loadTexture("assets/img/MageHeadLine.png");

        BaseActor supportTitle = new BaseActor(562,390,mainStage);
        supportTitle.loadTexture("assets/img/SupportHeadLine.png");

        BaseActor dragAndDrop = new BaseActor(160,270, mainStage);
        dragAndDrop.loadTexture("assets/img/DragAndDrop.png");

        for ( int i = 1 ; i < 4 ; i++ ) {
            int pixelX = i * 200 - 50;
            int pixelY = 350;

            selectedHeroes[i-1] = new SelectionArea(pixelX,pixelY,mainStage);
            selectedHeroes[i-1].setHeroType(i);
            selectedHeroes[i-1].setTargetable(true);
        }

        fighterTitle.toFront();
        mageTitle.toFront();
        supportTitle.toFront();

        // create cards
        for ( int t = 1 ; t < 4 ; t++ )
        {
            for ( int n = 1 ; n < 3 ; n++)
            {
                int x = (n * 120 - 100) + (t * 240 - 220);
                int y = 80;

                heroCards[totalHeroes] = new CharacterCard( x, y, mainStage);
                heroCards[totalHeroes].createCard(n,t);
                totalHeroes++;
            }
        }

        // Buttons -----------------------------------------------------------------------------
        Button.ButtonStyle buttonStyle = new Button.ButtonStyle();

        Texture buttonTex = new Texture( Gdx.files.internal("assets/img/buttons/Start.png") );
        TextureRegion buttonRegion = new TextureRegion(buttonTex);
        buttonStyle.up = new TextureRegionDrawable( buttonRegion );
        Button selectionMenuStart = new Button( buttonStyle );

        selectionMenuStart.setPosition(650, 0);
        uiStage.addActor(selectionMenuStart);
        selectionMenuStart.setSize(150,50);

        selectionMenuStart.addListener(
                (Event e) ->
                {
                    if ( !(e instanceof InputEvent) )
                        return false;
                    //mouseover
                    if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) )
                        return false;
                        if (selectedHeroes[0].getHeroNumber() != 0 &&
                            selectedHeroes[1].getHeroNumber() != 0 &&
                            selectedHeroes[2].getHeroNumber() != 0) {
                            MortenKombat.fighterN = selectedHeroes[0].getHeroNumber();
                            MortenKombat.mageN = selectedHeroes[1].getHeroNumber();
                            MortenKombat.supportN = selectedHeroes[2].getHeroNumber();
                            menu.dispose();
                            this.dispose();

                                MortenKombat.setActiveScreen(new TutorialScreen());

                        }
                    return false;
                }
        );

        Button.ButtonStyle buttonStyle1 = new Button.ButtonStyle();

        Texture buttonTex1 = new Texture( Gdx.files.internal("assets/img/buttons/Back.png") );
        TextureRegion buttonRegion1 = new TextureRegion(buttonTex1);
        buttonStyle1.up = new TextureRegionDrawable( buttonRegion1 );
        Button back1 = new Button( buttonStyle1 );

        back1.setPosition(10, 10);
        uiStage.addActor(back1);
        back1.setSize(60,60);

        back1.addListener(
                (Event e) ->
                {
                    if ( !(e instanceof InputEvent) )
                        return false;

                    if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) )
                        return false;
                    this.dispose();
                    MortenKombat.setActiveScreen( menu );
                    return false;
                }
        );
    }
    @Override
    public void update(float dt) {
    }
}
