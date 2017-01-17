package opgave2;

public class Player {
//  attribute declaration
    private String name;
    private int points;

    public Player() {
//      default constructor
        name = "";
        points = 0;
    }

    public Player(String name) {
//      primary constructor, calls the default to make sure points is initialized
        this();
        this.name = name;
    }

//    getters and setters
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}