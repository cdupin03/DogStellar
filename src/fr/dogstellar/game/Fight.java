package fr.dogstellar.game;

import java.util.Random;

import fr.dogstellar.core.*;
import fr.dogstellar.view.GeneralWindow;
import fr.dogstellar.view.Popup;
import fr.dogstellar.view.StartGame;
import fr.dogstellar.view.Window;

/**
 * This method allow to play the fight between a monster and a player At the
 * beginning of the fight the player can decide to fight or not the monster. If
 * he decide to fight, he begin the fight. While one of the people (monster or
 * player) is not dead the fight will continued At the end of the fight the
 * player can win or lost the fight. If the player win the fight he win a
 * partOfShip and maybe a otherStuff (with 1 chance /2) If the player lost the
 * game, the lifePoint of the monster is reinitialize.
 *
 * @param myMonster it is the perso that the player fight
 * @param myPlayer it is the player of the game that fight the monster
 * @param partOfShip it is the partOfShip that the player win when he win the
 * fight
 * @param otherStuff it is the stuff that the player can win when he win the
 * fight and with a probability 1/2
 * @author GP3
 * @version 21/11/2017
 *
 */
public class Fight {

    private static Perso monster;
    private static Player player;
    private boolean end;
    private static Perso monsterDead = new Perso("Null", 0, 0);

    /**
     * Is the constructor of Fight
     */
    public Fight(Perso myMonster, Player myPlayer) {
        monster = myMonster;
        player = myPlayer;
        Random r = new Random();
        //if yes :
        //Fight newFight = new Fight(myMonster, myPlayer);
        int pointLifeMonster = monster.getLifePoint();//It is the lifePoint of Monster in the beginning the fight

        while (monster.getLifePoint() != 0 && player.getLifePoint() != 0) {
            player.playerFight(monster, player.getAttackPoint());
            if (monster.getLifePoint() == 0) {
                StartGame.getInterf().addMessageToConsole(monster.getNamePerso() + " is dead ! You are the winner");
                player.addStuff(monster.getMonsterElementQuest(), 1); //The player win a partOfShip when he win
                StartGame.getInterf().addMessageToConsole("You win a piece of ship");
                boolean percent = r.nextBoolean();  //The player can win a otherStuff or not according to a random boolean
                if (percent == true) {
                    player.addStuff(monster.getTheMonsterStuff(), 1);
                    StartGame.getInterf().addMessageToConsole("You win also a stuff ! Look your inventory");
                }
                monster.setIsDead();
                //System.out.println("the monster is dead" + monster.getIsDead());
                end = new Boolean(true);
                break;
            }
            StartGame.getInterf().addMessageToConsole("PLAYER ATTACK !");
            monster.monsterFight(player, monster.getAttackPoint());
            StartGame.getInterf().addMessageToConsole("     Now you have " + player.getLifePoint() + " life point");
            StartGame.getInterf().addMessageToConsole("MONSTER ATTACK !");
            StartGame.getInterf().addMessageToConsole("     Now you have " + player.getLifePoint() + " life point");
            StartGame.getInterf().getDisplay().refreshDisplay();
            if (player.getLifePoint() == 0) {
                monster.setLifePoint(pointLifeMonster); // If the player lost the fight, the monster LifePoint is reinitialized as the beginning of the fight
                StartGame.getInterf().addMessageToConsole(player.getNamePerso() + " is dead ! You are returned in your ship");
                Popup retourVaisseau = new Popup("You are dead, you are going back to the ship");
                StartGame.getInterf().getTheWindow().returnToFirstMap();
                StartGame.getPlayer().setLifePoint(StartGame.getLifePoint());
                StartGame.getInterf().getDisplay().refreshDisplay(); 

                // !!!!!!!!!!!!!! Call method return to ship !!!!!!!!!!!!!!!!!!
                end = new Boolean(true);
                break;
            }

        }
        endFight();
    }

    public boolean getEnd() {
        return (end);
    }

    public void endFight() {
        if (getEnd() == true) {
            GeneralWindow myNewWindow = StartGame.getInterf().getTheWindow();
            StartGame.getInterf().setWindow(myNewWindow);

        }
    }
}
