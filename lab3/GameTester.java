package lab3;

import java.util.ArrayList;
import java.util.Scanner;
public class GameTester {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Choose the difficulty ( 1 - EASY | 2 - MEDIUM | 3- HARD ): ");
        int choice = in.nextInt();

        Game game1 = new Game(choice);

        game1.play();

        
        in.close();

    }


    // HELPER METHODS

    public static String listToString(ArrayList<EnemyVehicle> arr) {
        String result = "";
        for (EnemyVehicle x : arr) {
            result += x;
        }
        return result;
    }
    
}
