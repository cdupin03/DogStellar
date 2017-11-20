package fr.dogstellar.core;

/**
 * A quest element is element which does nothing to the player.
 * This element can be an object that the player need to progress in the area for example.
 * The infos are enough.
 *
 * @author (G3)
 * @version (01)
 */
public class QuestElement extends Stuff
{
    

    /**
     * Constructor for objects of class QuestElement
     * Call the stuff constructor
     * @param name the name
     * @param description the description
     * 
     */
    public QuestElement(String name, String description)
    {
        super(name, description);
    }
}

