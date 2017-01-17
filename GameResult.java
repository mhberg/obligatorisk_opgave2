package opgave2;

/** Begrundelse for opbygningen:
 * 
 * GameResult klassen indeholder den nødvendige toString, men også en set metode til min boolean værdi. Denne metode bliver kaldt i slutningen af
 * game metoderne i klassen Game, for at videregive informationen om hvem der har vundet i det pågældende spil fra Game til GameResult.
 * Vær opmærksom på, at mit program kun opretter et objekt af hver klasse (undtaget Player-klassen) i et sjovt forsøg på at se om jeg kunne
 * komprimere det en smule. Jeg har i denne sammenhæng lavet en ekstra metode i Die setSides() som tillader mig at ændre terningens-værdi 
 * ved et simpelt metode kald, i stedet for at have mange objekter.
 * 
 * Alternativt kunne jeg havde kodet det som jeg egentlig forstår opgavens formål, nemlig at efterligne situationen i virkeligheden. I dette tilfælde
 * ville jeg ændre Game til at oprette og initialisere flere Die-objekter (et per terning-type). Jeg ville også lade hver game metode oprette et nyt
 * GameResult objekt, således at hvert game har sit eget "result set" så at sige. Her kan man passende udvide GameResult constructoren til også at
 * modtage en boolean som repræsenterer om spilleren har vundet eller ej, i stedet for at have en set metode.
 * 
 * Med programmets nuværende funktionalitet, bliver resultatet det samme. I tilfælde af program-udvidelser hvor den nuværende opbygning kan blive
 * et problem, vil jeg opdatere med ovenstående funktionalitet.  #jobsecurity
 * 
 * PS. mit UML diagram er også for mit eget program.
 */

public class GameResult {
//  attribute declaration
    Player player, house;
    boolean win;

    public GameResult() {
//  default constructor, initialize the boolean
        win = false;
    }

    public GameResult(Player player, Player house) {
//      primary constructor that takes player and house from the game played as input
        this();
        this.player = player;
        this.house = house;
    }

    @Override
    public String toString() {
//      Game result toString
        String out = "--GAME RESULT--\n";
        out = out + player.getName() + ": " + player.getPoints() + "\t";
        out = out + house.getName() + ": " + house.getPoints() + "\n";
        
        if (win == true){
            out = out + "--YOU WIN (^_^)/--";
        } else {
            out = out + "--HOUSE WINS (._. )--";
        }
        return out;
    }
    
//      getters and setters
    public void setWin(boolean win){
        this.win = win;
    }
    
    public boolean getWin(boolean win){
        return this.win;
    }
}