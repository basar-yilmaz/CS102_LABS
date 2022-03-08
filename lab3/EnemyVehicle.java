import java.awt.Point;
import java.util.Random;

abstract class EnemyVehicle implements Movable, Destructible {

    private final int BASE_SPEED = 3;

    private Point point;
    protected int speed;

    public EnemyVehicle(int minX, int maxX, int y) {
        Random rn = new Random();
        int random_x = rn.nextInt(maxX-minX+1) + minX;

        this.speed = BASE_SPEED;
        this.point = new Point(random_x, y);

    }

    public int getDistanceToBorder() {
        return (int) this.point.getY();
    }

    abstract String getType();


    @Override
    public boolean isDestroyed() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void takeDamage(double damage) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void move() {
        point.setLocation(point.getX(), point.getY() - this.speed);
    }

    @Override
    public Point getLocation() {
        return this.point; 
    }
    
}
