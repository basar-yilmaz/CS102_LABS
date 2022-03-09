import java.util.ArrayList;
import java.util.Scanner;

public class Game implements Difficulty{  

    final public int STARTING_DISTANCE = 25;
    final public int MAX_NO_OF_PASSING_ENEMIES = 10;

    private int difficulty;
    public Player pl;
    GamePlotter plotter;

    
    public Game(int difficulty) {
        this.setDifficulty(difficulty);
        pl = new Player();
        for (int i = 0; i < 2 * getDifficulty(); i++) {
            pl.addEnemyVehicle(getNewRandomVehicle());
        }
        plotter = new GamePlotter(this);
    }

    public ArrayList<EnemyVehicle> getEnemies() {
        return pl.enemies();
    }

    public void play() {
        int passingEnemy = 0;
        do {
            Scanner in = new Scanner(System.in);

            printGameState(); 

            System.out.print("Enter x coordinate: ");
            int x_axis = in.nextInt();
            System.out.print("Enter y coordinate: ");
            int y_axis = in.nextInt();

            if (y_axis > STARTING_DISTANCE || x_axis > getDifficulty() * 5) {
                System.out.println();
                System.out.println("!".repeat(61));
                System.out.println("Enter a valid coordinate!!");
                continue;
            }

            pl.attack(x_axis, y_axis, getEnemies());

            for (EnemyVehicle x : this.getEnemies()) {
                x.move();
            }

            int destroy_count = 0;
            for (int i = 0; i < getEnemies().size(); i++) {
                if (getEnemies().get(i).isDestroyed()) {
                    pl.addScore();
                    pl.enemies().remove(i);
                    destroy_count++;
                }
            }
            for (int i = 0; i < destroy_count; i++) {
                pl.enemies().add(getNewRandomVehicle());
            }

            int passing_count = 0;
            for (int i = 0; i < getEnemies().size(); i++) {
                if (getEnemies().get(i).getDistanceToBorder() <= 0) {
                    passingEnemy++;
                    passing_count++;
                    pl.enemies().remove(i);
                }
            }
            for (int i = 0; i < passing_count; i++) {
                pl.enemies().add(getNewRandomVehicle());
            }
                      

        }while(passingEnemy <= MAX_NO_OF_PASSING_ENEMIES);
        
    }

    public void printGameState() {
        System.out.println("~".repeat(61));
        plotter.plot();
        System.out.println(listToString(this.getEnemies()));
    }

    public void enemiesTurn() {
        
    }

    @Override
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;        
    }

    @Override
    public int getDifficulty() {
        return difficulty;
    }

    private EnemyVehicle getNewRandomVehicle() {
        double rn = Math.random();
        if (rn > 0.5) {
            EnemyVehicle obj = new Helicopter(0, getDifficulty() * 5, STARTING_DISTANCE);
            return obj;
        }
        EnemyVehicle obj = new Tank(0, getDifficulty() * 5, STARTING_DISTANCE);
        return obj;
    }

    // HELPER METHODS

    public String listToString(ArrayList<EnemyVehicle> arr) {
        String result = "";
        for (EnemyVehicle x : arr) {
            result += x;
        }
        return result;
    }
    

    
}
