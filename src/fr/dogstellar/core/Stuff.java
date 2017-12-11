package fr.dogstellar.core;

/**
 * Abstract class Stuff - A stuff is an object which can be in the player
 * equipement. The stuff has a name, a description. The stuff can be carried by
 * the player.
 *
 * @author (G3)
 * @version (01)
 */
public abstract class Stuff {

    private Info info;                                                    // The informations about the stuff object

    /**
     * Give the info from the stuff.
     *
     * @return info is the info object
     */
    public Info getInformation() {
        return info;
    }

}
