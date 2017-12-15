package fr.dogstellar.game;

import java.util.Random;

import fr.dogstellar.core.*;
import fr.dogstellar.view.GeneralWindow;
import fr.dogstellar.view.Popup;
import fr.dogstellar.view.StartGame;

/**
 * This class allow to play the fight between a monster and a player At the
 * beginning of the fight the player can decide to fight or not the monster. If
 * he decide to fight, he begin the fight. While one of the people (monster or
 * player) is not dead the fight will continued At the end of the fight the
 * player can win or lost the fight. If the player win the fight he win a
 * partOfShip and maybe a otherStuff. If the player lost the game, the lifePoint
 * of the monster is reinitialize.
 *
 * @author GP3
 * @version 21/11/2017
 *
 */
public final class Fight {

    private static Perso monster; // the monster
    private static Player player; //the player
    private boolean end; //true if the end is reached

    /**
     * Is the constructor of Fight. It contains all the step of a fight.
     * It manages the attacks of the player and the monster
     * If the player loose, he recovers its life point and go back to the ship
     * If the monster loose, it signaled as dead and give its objects to the player.
     * 
     *
     * @param myMonster is the monster to fight
     * @param myPlayer is the player that fight
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
                end = true;
                break;
            }
            StartGame.getInterf().addMessageToConsole("PLAYER ATTACK !");
            monster.monsterFight(player, monster.getAttackPoint());
            StartGame.getInterf().addMessageToConsole("     The monster has " + monster.getLifePoint() + " life point");
            StartGame.getInterf().addMessageToConsole("MONSTER ATTACK !");
            if (player.hasArmor()) {
                StartGame.getInterf().addMessageToConsole("     Your armor has now " + player.getArmorEquip().getArmorPoint() + " life point");
            }

            StartGame.getInterf().addMessageToConsole("     Now you have " + player.getLifePoint() + " life point");
            StartGame.getInterf().getDisplay().refreshDisplay();
            if (player.getLifePoint() == 0) {
                monster.setLifePoint(pointLifeMonster); // If the player lost the fight, the monster LifePoint is reinitialized as the beginning of the fight
                StartGame.getInterf().addMessageToConsole(player.getNamePerso() + " is dead ! You are returned in your ship");
                Popup retourVaisseau = new Popup("You are dead, you are going back to the ship");
                StartGame.getInterf().getTheWindow().returnToFirstMap();
                StartGame.getPlayer().setLifePoint(StartGame.getLifePoint());

                // !!!!!!!!!!!!!! Call method return to ship !!!!!!!!!!!!!!!!!!
                end = true;
                StartGame.getInterf().getDisplay().refreshDisplay();
                break;
            }

        }
        endFight();
    }
    
    /**
     * get the end the of fight.
     * @return the end (true if it is reached)
     */
    public boolean getEnd() {
        return (end);
    }
    
    /**
     * Allows to end the fight properly.
     */
    public void endFight() {
        if (getEnd() == true) {
            GeneralWindow myNewWindow = StartGame.getInterf().getTheWindow();
            StartGame.getInterf().setWindow(myNewWindow);
        }
    }
}
