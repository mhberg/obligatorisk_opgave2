package opgave2;

public class Game {
    // object references does not change in this version. Declared as constants
    private final Player PLAYER, HOUSE;
    private final Die DIE;
    private final GameResult GAME_RESULT;

    public Game(Player player) {
//      constructor - takes player as input to allow the game to exist. Also creates die and opponent "House", as well as gameresult set.
        this.PLAYER = player;
        HOUSE = new Player("House");
        DIE = new Die();
        GAME_RESULT = new GameResult(this.PLAYER, HOUSE);
    }

    public GameResult playGame1() {
//      Game variables (results) & sets die sides value
        int playerResult = 0;
        int houseResult = 0;
        DIE.setSides(6);

//      player roll
        for (int i = 0; i < 10; i++) {
            playerResult = playerResult + DIE.throwDie();
        }
//      house roll
        for (int i = 0; i < 10; i++) {
            houseResult = houseResult + DIE.throwDie();
        }

//      sets results for both players
        PLAYER.setPoints(playerResult);
        HOUSE.setPoints(houseResult);

//      checks for winner
        if (playerResult > houseResult) {
            GAME_RESULT.setWin(true);
        } else {
            GAME_RESULT.setWin(false);
        }

        return GAME_RESULT;
    }

    public GameResult playGame2() {
//      Game variables (results)
        int playerResult = 0;
        int houseResult = 0;

//      sets die side value
        DIE.setSides(12);
//      first 5 rolls for player
        for (int i = 0; i < 5; i++) {
            playerResult = playerResult + DIE.throwDie();
        }
//      first 5 rolls for house
        for (int i = 0; i < 5; i++) {
            houseResult = houseResult + DIE.throwDie();
        }

//      sets die sides value
        DIE.setSides(24);
//      next 5 rolls for player
        for (int i = 0; i < 5; i++) {
            playerResult = playerResult + DIE.throwDie();
        }
//      next 5 rolls for house
        for (int i = 0; i < 5; i++) {
            houseResult = houseResult + DIE.throwDie();
        }

//      Checks if the point result is an even number
        if (playerResult % 2 == 0) {
            playerResult = playerResult * 2;
        }

        if (houseResult % 2 == 0) {
            houseResult = houseResult * 2;
        }

//      sets results for both players
        PLAYER.setPoints(playerResult);
        HOUSE.setPoints(houseResult);

//      checks for winner
        if (playerResult > houseResult) {
            GAME_RESULT.setWin(true);
        } else {
            GAME_RESULT.setWin(false);
        }

        return GAME_RESULT;
    }

    public GameResult playGame3() {
//      Game variables (results) & sets die sides value
        int playerResult, houseResult;
        DIE.setSides(6);

//      throws die for both players once
        playerResult = DIE.throwDie();
        houseResult = DIE.throwDie();

//      sets next die sides value from first throw result for both players
        if (playerResult <= 3) {
            DIE.setSides(12);
        } else {
            DIE.setSides(10);
        }
        playerResult = playerResult + DIE.throwDie();

        if (houseResult <= 3) {
            DIE.setSides(12);
        } else {
            DIE.setSides(10);
        }
        houseResult = houseResult + DIE.throwDie();

//      sets results for both players
        PLAYER.setPoints(playerResult);
        HOUSE.setPoints(houseResult);

//      checks for winner
        if (playerResult < houseResult) {
            GAME_RESULT.setWin(true);
        } else {
            GAME_RESULT.setWin(false);
        }

        return GAME_RESULT;
    }
}