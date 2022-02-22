package lab1;

    //-----------------------------------------------------------------
   //  Author: Başar YILMAZ
   //-----------------------------------------------------------------

public class Equation {

    // PART 1/1 //
    private int a, b, c;

    // PART 1/2 //
    public Equation(int a, int b, int c) {

        if (b < 0){
            this.b = -b;
            this.a = -a;
            this.c = -c;
        }
        else{
            this.b = b;
            this.a = a;
            this.c = c; 
        }
        reduceEquation();  
    }

    // PART 1/3 //
    public void reduceEquation() {
        if (a <= 0 && b <= 0 && c <= 0) {
            a *= -1;
            b *= -1;
            c *= -1;
        }
        int common_divider = this.gcd3(a, b, c);
        a /= common_divider;
        b /= common_divider;
        c /= common_divider;
    }

    // PART 2/1 //
    public Equation add(Equation eq2) {
        int newA = this.a + eq2.a;
        int newB = this.b + eq2.b;
        int newC = this.c + eq2.c;

        return new Equation(newA, newB, newC);
    }

    public Equation subtract(Equation eq2) {
        int newA = this.a - eq2.a;
        int newB = this.b - eq2.b;
        int newC = this.c - eq2.c;

        return new Equation(newA, newB, newC);
    }

    // PART 2/2 //
    public String toString() {

        if (b == 0) {
            return a + " = "+ c;
        }
        else if (c == 0) {
            if (b == 1){
                return a + " = "+ "x";
            }
            return a + " = "+ b + "x";
        }
        else if (c < 0) {
            if (b == 1) {
                return a + " = "+"x - " + -c;
            }
            return a + " = "+ b + "x - " + -c;
        }
        else{
            if (b==1) {
                return a + " = "+"x + " + c;
            }
            return a + " = "+ b + "x + " + c;
        }
    }
    
    // PART 2/3 //

    // Overriding the equals method of Object class
    public boolean equals(Object otherEquation) {
        if (otherEquation == null)
            return false;
        if (this.getClass() != otherEquation.getClass())
            return false;
        Equation other = (Equation) otherEquation;
        return a == other.a && b == other.b && c == other.c;
    }

    //helper methods
    private int gcd(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);

        if (x == 0 && y == 0)
            return 1;
        else if (x == 0)
            return y;
        else if (y == 0)
            return x;
        else {
            while (x != y){
                if (x > y)
                    x -= y;
                else
                    y -= x;
                
            }return x;
        }
    }

    private int gcd3(int x, int y, int z) {
        return gcd(x, gcd(y, z));
    }    
}
