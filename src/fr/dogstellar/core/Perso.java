package fr.dogstellar.core;

/**
 * The class Perso. He has a name, a number of LifePoint and number of
 * AttackPoint and an inventory.
 *
 * When a Perso is creating, it is not possible to not have a name and to have
 * negative lifePoint and attackPoint. So at the beginning of the game : the
 * user can give a name or not, at this case the default name is Perso1 the
 * default number of lifePoint and attackPoint is initiate at 10
 *
 * The player can wins and lost lifePoint and attackPoint. The player cannot
 * have more than 10 and less than 0 lifePoint and attackPoint.
 *
 * @author Gp3
 * @version 20/11/2017
 */
public class Perso {

    // instance variables - replace the example below with your own
    private String namePerso;
    private int lifePoint;
    private int attackPoint;
    private QuestElement aMonsterQuest;
    private Stuff aMonsterStuff;
    private boolean isDead = false;

    /**
     * Constructor of the Perso class The user can give a name to the player. If
     * the name is empty, to not have problem there is a default value (Perso1)
     * If the numbers of lifePoint or attackPoint are under 0 and superior to
     * 10, the numbers are automatically initialized to 10.
     *
     * @param nameP is the name(String) of the Perso
     * @param lifeP is the number of lifePoint
     * @param attackP is the number of attackPoint
     */
    public Perso(String nameP, int lifeP, int attackP) {
        if (nameP.isEmpty()) {
            namePerso = "Perso1";
        } else {
            namePerso = nameP;
        }
        if (lifeP <= 0 || lifeP > 10) {
            lifePoint = 10;
        } else {
            lifePoint = lifeP;
        }
        if (attackP <= 0 || attackP > 10) {
            attackPoint = 10;
        } else {
            attackPoint = attackP;
        }
    }

    //The monster constructor
    public Perso(String nameP, int lifeP, int attackP, QuestElement aQuestElement, Stuff aStuffElement) {
        if (nameP.isEmpty()) {
            namePerso = "Perso1";
        } else {
            namePerso = nameP;
        }

        if (lifeP <= 0 || lifeP > 10) {
            lifePoint = 10;
        } else {
            lifePoint = lifeP;
        }

        if (attackP <= 0 || attackP > 10) {
            attackPoint = 10;
        } else {
            attackPoint = attackP;
        }

        aMonsterQuest = aQuestElement;
        aMonsterStuff = aStuffElement;
    }

    /**
     * This method returns the number of lifePoint of the character.
     *
     * @return lifePoint
     */
    public String getNamePerso() {
        return namePerso;
    }

    /**
     * This method returns the number of LifePoint of the character.
     *
     * @return lifePoint
     */
    public int getLifePoint() {
        return lifePoint;
    }

    /**
     * This method returns the number of AttackPoint of the character.
     *
     * @return attackPoint
     */
    public int getAttackPoint() {
        return attackPoint;
    }

    /**
     * This method allows us to modify the number of LifePoint
     *
     * @param lifePoint is the number of lifePoint that we want to add
     */
    public void setLifePoint(int lifePoint) {
        this.lifePoint = lifePoint;
    }

    /**
     * This method allows us to add lifePoint. If we want to increase the number
     * of lifePoint and the result is superior to 10, lifePoint take the value
     * 10.
     *
     * @param point it is the LifePoint that we add the the initial LifePoint
     */
    public void increaseLifePoint(int point) {
        int addition = lifePoint + point;
        if (addition < 10) {
            lifePoint = lifePoint + point;
        } else {
            lifePoint = 10;
        }
    }

    /**
     * This method allows us to delete a number of lifePoint. If we want to
     * decrease the number of lifePoint and the result is inferior to 0,
     * lifePoint take the value 0.
     *
     * @param Point is the number of life point to remove at the player
     */
    public void decreaseLifePoint(int Point) {
        int soustraction = lifePoint - Point;
        if (soustraction < 0) {
            lifePoint = 0;
        } else {
            lifePoint = lifePoint - Point;
        }
    }

    /**
     * This method allows us to add a number of attackPoint. If we want to
     * increase the number of attackPoint and the result is superior to 10,
     * attackPoint take the value 10.
     *
     * @param Point is the number of attack point to add at the player
     */
    public void increaseAttackPoint(int Point) {
        int addition = attackPoint + Point;
        if (addition < 10) {
            attackPoint = attackPoint + Point;
        } else {
            attackPoint = 10;
        }
    }

    /**
     * This method allows us to remove a number of attackPoint. If we want to
     * decrease the number of attackPoint and the result is inferior to 0,
     * attackPoint take the value 0.
     *
     * @param Point is the number of attack point to remove at the player
     */
    public void decreaseAttackPoint(int Point) {
        int soustraction = attackPoint - Point;
        if (soustraction < 0) {
            attackPoint = 0;
        } else {
            attackPoint = attackPoint - Point;
        }
    }

    /**
     * This method allows us to display the information of the perso (name,
     * LifePoint and AttackPoint)
     */
    public void displayInfoPerso() {
        System.out.println(namePerso);
        System.out.println(lifePoint);
        System.out.println(attackPoint);
    }

    /**
     * The monster attack the player with a number of attackPoint
     *
     * @param player it is the player that the monster attack
     * @param attackPoint it is the number of attackPoint that it decided to
     * play
     */
    public void monsterFight(Player player, int attackPoint) {
        Armor armorOfPlayer;
        int compt = 0;
        if (player.hasArmor() == false) {
            player.decreaseLifePoint(attackPoint);
        } else if (player.hasArmor() == true) {
            armorOfPlayer = player.getArmorEquip();
            if (armorOfPlayer.getArmorPoint() > 0) {
                compt = armorOfPlayer.getArmorPoint() - attackPoint;
                if (compt > 0) {
                    armorOfPlayer.decreaseArmorPoint(attackPoint);
                } else {
                    armorOfPlayer.decreaseArmorPoint(armorOfPlayer.getArmorPoint());
                    player.decreaseLifePoint(attackPoint - armorOfPlayer.getArmorPoint());
                }
            } else {
                player.decreaseLifePoint(attackPoint);
            }
        }
    }

    /**
     *
     * To get a the stuff element that the monster have
     *
     * @return aMonsterStuff is the stuff of the monster
     */
    public Stuff getTheMonsterStuff() {
        return aMonsterStuff;
    }

    /**
     * To get a the quest element that the monster have
     *
     * @return aMonsterQuest is the element of the monster
     */
    public QuestElement getMonsterElementQuest() {
        return aMonsterQuest;
    }

    /**
     * To know if the monster is dead
     *
     * @return isDead = true if the monster is dead, false if it is not
     */
    public boolean getIsDead() {
        return (isDead);
    }

    /**
     * To declare the monster as dead
     */
    public void setIsDead() {
        isDead = true;
    }
}