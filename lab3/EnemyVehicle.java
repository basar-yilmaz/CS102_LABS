package lab3;

import java.awt.Point;
import java.util.Random;

abstract class EnemyVehicle implements Movable, Destructible {

    private final int BASE_SPEED = 3;
    private final double HEALTH_POINTS = 100;


    private Point point;
    protected int speed;
    protected double hp;

    public EnemyVehicle(int minX, int maxX, int y) {
        Random rn = new Random();
        int random_x = rn.nextInt(maxX-minX) + minX;

        this.speed = BASE_SPEED;
        this.point = new Point(random_x, y);
        this.hp = HEALTH_POINTS;
    }

    public int getDistanceToBorder() {
        return (int) point.getY();
    }

    abstract String getType();

    @Override
    public boolean isDestroyed() {
        if (hp <= 0)
            return true;
        return false;
    }

    @Override
    public void takeDamage(double damage) {
        this.hp -= damage; 
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
