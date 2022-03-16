public class Helicopter extends EnemyVehicle {

    final double SPEED_MODIFIER = 1.0;

    

    public Helicopter(int minX, int maxX, int y) {
        super(minX, maxX, y);
        
    }

    public void move() {
        super.move();
        speed += SPEED_MODIFIER;
    }

    public String toString() {
        String result = "Position of the Helicopter is (";
        result += (int) getLocation().getX()+", "+(int) getLocation().getY()+").";
        result += " It is speed modifier is "+ SPEED_MODIFIER;
        result += ". Health Points: ";
        result += this.hp;
        return result + "\n";
    }

    @Override
    public String getType() {
        return this.getClass().getName();
    }
    
    
}
