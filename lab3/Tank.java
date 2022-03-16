public class Tank extends EnemyVehicle{

    public Tank(int minX, int maxX, int y) {
        super(minX, maxX, y);
        //TODO Auto-generated constructor stub
    }

    public void takeDamage(double damage) {
        this.hp -= (damage * 0.5);
    }

    public String toString() {
        String result = "Position of the Tank is (";
        result += (int) getLocation().getX()+", "+(int) getLocation().getY()+")";
        result += ". Health Points: ";
        result += this.hp;
        return result + "\n";
    }

    @Override
    public String getType() {
        return this.getClass().getName();
    }
    
}
