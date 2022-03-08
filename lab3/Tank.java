public class Tank extends EnemyVehicle{

    public Tank(int minX, int maxX, int y) {
        super(minX, maxX, y);
        //TODO Auto-generated constructor stub
    }

    public void takeDamage(double damage) {

    }

    public String toString() {
        String result = "Position of the Tank (x, y) : ";
        return result + this.getLocation();
    }

    @Override
    public String getType() {
        return "Tank";
    }
    
}
