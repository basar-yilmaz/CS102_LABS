import java.util.ArrayList;
import java.awt.*;

public class Player {

    //private final double BOMB_RADIUS = 2;
    private final double DAMAGE = 50;

    private ArrayList<EnemyVehicle> enemyVehicles;


    public Player(){
        enemyVehicles = new ArrayList<EnemyVehicle>();
    }

    public void addEnemyVehicle(EnemyVehicle enemy) {
        enemyVehicles.add(enemy);
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
