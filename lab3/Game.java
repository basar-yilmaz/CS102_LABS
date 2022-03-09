import java.util.ArrayList;

public class Game implements Difficulty{  

    final public int STARTING_DISTANCE = 25;
    final public int MAX_NO_OF_PASSING_ENEMIES = 10;

    private int difficulty;
    public Player pl;

    
    public Game(int difficulty) {
        this.setDifficulty(difficulty);
        pl = new Player();
        for (int i = 0; i < 2 * getDifficulty(); i++) {
            pl.addEnemyVehicle(randomVehicleCreator());
        }
    }

    public ArrayList<EnemyVehicle> getEnemies() {
        return pl.enemies();
    }

    @Override
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;        
    }

    @Override
    public int getDifficulty() {
        return difficulty;
    }

    private EnemyVehicle randomVehicleCreator() {
        double rn = Math.random();
        if (rn > 0.5) {
            EnemyVehicle obj = new Helicopter(0, getDifficulty() * 5, STARTING_DISTANCE);
            return obj;
        }
        EnemyVehicle obj = new Tank(0, getDifficulty() * 5, STARTING_DISTANCE);
        return obj;
    }
    

    
}
