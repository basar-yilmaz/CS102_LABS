import java.util.ArrayList;
public class GameTester {

    public static void main(String[] args) {
        final int EASY = 1;
        final int MEDIUM = 2;
        final int HARD = 3;

        Game game1 = new Game(MEDIUM);

        GamePlotter plot1 = new GamePlotter(game1);

        plot1.plot();

        System.out.println(listToString(game1.getEnemies()));

        game1.pl.attack(0, 25, game1.getEnemies());
        

        game1.getEnemies().get(0).move();
        game1.getEnemies().get(1).move();
        game1.getEnemies().get(2).move();
        game1.getEnemies().get(3).move();
        plot1.plot();

        System.out.println(listToString(game1.getEnemies()));

        game1.pl.attack(5, 22, game1.getEnemies());
        

        game1.getEnemies().get(0).move();
        game1.getEnemies().get(1).move();
        game1.getEnemies().get(2).move();
        game1.getEnemies().get(3).move();
        plot1.plot();

        System.out.println(listToString(game1.getEnemies()));

        


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
