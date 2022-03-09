import java.util.ArrayList;

import java.awt.*;

public class Player {

    //private final double BOMB_RADIUS = 2;
    private final double DAMAGE = 50;

    private ArrayList<EnemyVehicle> enemyVehicles;
    private int score;


    public Player(){
        enemyVehicles = new ArrayList<EnemyVehicle>();
        score = 0;
    }

    public void addEnemyVehicle(EnemyVehicle enemy) {
        enemyVehicles.add(enemy);
    }

    public ArrayList<EnemyVehicle> enemies() {
        return enemyVehicles;
    }

    public void addScore() {
        score = score + 1;
    }

    public void attack(int x, int y, ArrayList<EnemyVehicle> enemies) {
        
        for (EnemyVehicle vehicle : enemies) {
            if (vehicle.getLocation().equals( new Point(x,y) )    ||
                vehicle.getLocation().equals( new Point(x+1,y))   ||
                vehicle.getLocation().equals( new Point(x+2,y))   ||
                vehicle.getLocation().equals( new Point(x-1,y))   ||
                vehicle.getLocation().equals( new Point(x-2,y))   ||
                vehicle.getLocation().equals( new Point(x,y+1))   ||
                vehicle.getLocation().equals( new Point(x,y-1))   ||
                vehicle.getLocation().equals( new Point(x,y-2))   ||
                vehicle.getLocation().equals( new Point(x+1,y+1)) ||
                vehicle.getLocation().equals( new Point(x-1,y+1)) ||
                vehicle.getLocation().equals( new Point(x+1,y-1)) ||
                vehicle.getLocation().equals( new Point(x-1,y-1)) ||
                vehicle.getLocation().equals( new Point(x,y+2) ))  
            {
                vehicle.takeDamage(DAMAGE);
            }
        }
    }
    
}
