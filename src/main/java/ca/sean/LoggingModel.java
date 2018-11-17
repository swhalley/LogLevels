package ca.sean;

public class LoggingModel {

    private String name;
    private String level;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}