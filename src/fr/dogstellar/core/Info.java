package fr.dogstellar.core;

/**
 * The basic informations name and description for some objects. It contains a
 * name which need to be superior to three characters and a description need to
 * be superior to four characters
 *
 *
 * @author G3
 * @version V04
 */
public class Info {

    //The name of the object, must be superior to three characters with no spaces before and after.
    private String name;
    //The overall description of the object, must be superior to 4 characters with no space before and after.
    private String description;

    /**
     * Constructor for objects of class Info Initialize the infos of an object.
     *
     * @param name is the name of the object
     * @param description is the description of the object
     */
    public Info(String name, String description) {
        setName(name);
        setDescription(description);
    }

    /**
     * Method setName set the name of the object, only called by the
     * constructor, must be superior to three characters, with no spaces before
     * and after. If the name is bad, the value of "No Name" is set.
     *
     * @param name the name of the object
     */
    public void setName(String name) {
        if (name.trim().length() >= 3) {
            this.name = name.trim();
        } else {
            this.name = "No Name";
        }
    }

    /**
     * Method setDescription set the description of the object, only called by
     * the constructor, must be superior to four characters, with no spaces
     * before and after. If the description is bad, the value of "No
     * Description" is set.
     *
     * @param description the description to set.
     */
    public void setDescription(String description) {
        if (description.trim().length() >= 4) {
            this.description = description.trim();
        } else {
            this.description = "No Description";
        }
    }

    /**
     * Method getName get the name of the object
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Method getDescription get the description of the object
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

}
