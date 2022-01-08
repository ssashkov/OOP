package Inharitance.hero;

public class Hero {
    private String username;
    private int level;

    public Hero(String username, int level) {
        super();
        this.username = username;
        this.level = level;
    }

    public String getUsername() {
        return this.username;
    }

    public int getLevel() {
        return this.level;
    }

    @Override
    public String toString() {
        return String.format("Type: %s Username: %s Level: %d", getClass().getName(), this.getUsername(), this.getLevel());
    }
}
