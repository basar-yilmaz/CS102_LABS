public class Helicopter extends EnemyVehicle {

    

    public Helicopter(int minX, int maxX, int y) {
        super(minX, maxX, y);
        
    }

    public void move() {
        super.move();
        speed += 1;
    }

    public String toString() {
        String result = "--> Position of the Helicopter (x, y) : (";
        result += this.getLocation().getX()+", "+this.getLocation().getY()+")";
        result += " \t Health Points: ";
        result += this.hp;
        return result + "\n";
    }

    @Override
    public String getType() {
        return "Helicopter";
    }
    
    
}
