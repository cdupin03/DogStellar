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

    private final Info info;                                                    // The informations about the stuff object

    /**
     * Stuff Constructor Initialize the name and the description of the stuff.
     * The name and description are controlled by info class
     *
     * @param name the name
     * @param description the description
     */
    public Stuff(String name, String description) {
        info = new Info(name, description);
    }

    /**
     * Give the info from the stuff.
     *
     * @return info is the info object
     */
    public Info getInformation() {
        return info;
    }

}
