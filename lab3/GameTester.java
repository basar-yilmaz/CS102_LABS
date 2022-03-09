import java.util.ArrayList;
public class GameTester {

    public static void main(String[] args) {
        final int EASY = 1;
        final int MEDIUM = 2;
        final int HARD = 3;

        Game game1 = new Game(MEDIUM);

        GamePlotter plot1 = new GamePlotter(game1);

        game1.play();

        


    }


    // HELPER METHODS

    public static String listToString(ArrayList<EnemyVehicle> arr) {
        String result = "";
        for (EnemyVehicle x : arr) {
            result += x;
        }
        return result;
    }
    
}
