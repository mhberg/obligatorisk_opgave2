package opgave2;

public class Die {
//  attribute declaration
    private int sides;

    public Die() {
//      default constructor with initial value 6
        sides = 6;
    }

    public Die(int sides) {
//      primary constructor with # of sides as input
        this.sides = sides;
    }

    public int throwDie() {
//      method for rolling a die - runs a Math.random * number of sides on die. Does not allow 0.0 as result, as dice roll atleast 1.
        double result = Math.random();
        while (result < 0.1) {
            result = Math.random();
        }
        return (int) (result * sides);
    }
    
//      getters and setters
    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }
}