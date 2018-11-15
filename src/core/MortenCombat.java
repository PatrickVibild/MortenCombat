package core;
/**
 *
 */

import core.actors.fightingactors.*;
import core.framework.BaseGame;
import core.screen.LevelScreen;
import core.screen.MainMenuScreen;
import core.screen.MapLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MortenCombat extends BaseGame {
    public  static float volume = 0.5f;
    static private Champion fighterWarrior;
    static private Champion fighterMage;
    static private Champion fighterSupport;
    //fighterWarrior 1
    //fighterWarrior 2
    //fighterWarrior 3
    static LevelScreen[] layout = new LevelScreen[MapLayout.values().length];

    public void importing() throws FileNotFoundException {


        File data = new File("assets\\QnA\\QnAData.txt");
        File data2 = new File("assets\\QnA\\Science.txt");
        File data3 = new File("assets\\QnA\\Geography.txt");
        File data4 = new File("assets\\QnA\\History.txt");
        File data5 = new File("assets\\QnA\\Art.txt");
        File data6 = new File("assets\\QnA\\Sport.txt");
        File data7 = new File("assets\\QnA\\Entertainment.txt");


        ArrayList<ImportQandA> listQScience = new ArrayList<ImportQandA>();
        ArrayList<ImportQandA> listQGeography = new ArrayList<ImportQandA>();
        ArrayList<ImportQandA> listQHistory = new ArrayList<ImportQandA>();
        ArrayList<ImportQandA> listQArt = new ArrayList<ImportQandA>();
        ArrayList<ImportQandA> listQSport = new ArrayList<ImportQandA>();
        ArrayList<ImportQandA> listQEntertainment = new ArrayList<ImportQandA>();

        ImportQandA.filler(5,listQScience,data2);

        ImportQandA a = listQScience.get(2);
//        System.out.println(a.question);
    }

    public void create() {
        fighterWarrior = new WarriorOne();
        fighterMage = new MageOne();
        fighterSupport = new SupportOne();
        //idea is that we have 3 figther choosen by the player

        super.create();
        try {
            importing();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int i = 0;

        for (MapLayout map : MapLayout.values()){
            LevelScreen.mapName = map.getTmx();
            LevelScreen.mapEffect = map.getMapEffect();
            if (map.getLevel() == 0){
                layout[i] = new LevelScreen();
            }else {
                layout[i] = new LevelScreen(layout[map.getLevel() -1]);
            }
            i++;
        }

        MainMenuScreen menu = new MainMenuScreen();
        setActiveScreen( menu );
    }

    public static void startGame(){
        LevelScreen.playMusic();
        setActiveScreen( layout[0] );
    }

    public static Champion getFigtherWarrior(){
        return fighterWarrior;
    }
    public static Champion getFigtherMage(){
        return fighterMage;
    }
    public static Champion getFigtherSupport(){
        return fighterSupport;
    }
}