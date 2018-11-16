package core.framework;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class CharacterCard extends DragAndDropActor {

    public static String[] fighterTypeString = {"Fighter", "Mage", "Support"};

    private int fighterNumber;
    private int fighterType;


    private SelectionArea selectionArea;

    public CharacterCard(float x, float y, Stage s)
    {
        super(x, y, s);
    }

    public void act(float dt)
    {
        super.act(dt);
        boundToWorld();
    }
    public void onDragStart()
    {
        if ( hasSelectionArea() )
        {
            SelectionArea sa = getSelectionArea();
            sa.setTargetable(true);
            clearSelectionArea();
        }
    }
    public void onDrop()
    {
        if ( hasDropTarget() )
        {
            SelectionArea sa = (SelectionArea) getDropTarget();


            moveToActor(sa);
            setSelectionArea(sa);
            sa.setTargetable(false);
        }
    }

    public static String[] getFighterTypeString() {        return fighterTypeString;    }

    public int getFighterNumber() {        return fighterNumber;    }

    public void setFighterNumber(int fighterNumber)
    {
        loadTexture("assets/img/creeperEyesGreen.png");
        this.fighterNumber = fighterNumber;
    }

    public int getFighterType() {        return fighterType;    }

    public void setFighterType(int fighterType) {        this.fighterType = fighterType;    }


    public void setSelectionArea(SelectionArea sa)    {  selectionArea = sa;  }
    public SelectionArea getSelectionArea()    {  return selectionArea;  }
    public void clearSelectionArea()    {  selectionArea = null;  }
    public boolean hasSelectionArea()    {  return selectionArea != null;  }


}
