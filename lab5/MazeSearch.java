//********************************************************************
//  MazeSearch.java       Author: Lewis/Loftus
//
//  Demonstrates recursion.
//********************************************************************

public class MazeSearch
{
   //-----------------------------------------------------------------
   //  Creates a new maze, prints its original form, attempts to
   //  solve it, and prints out its final form.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {

      int[][] grid = {  {1,1,1,0,1,1,0,0,0,1,1,1,1},
                        {1,0,1,1,1,0,1,1,1,1,0,0,1},
                        {0,0,0,0,1,0,1,0,1,0,1,0,0},
                        {1,1,1,0,1,1,1,0,1,0,1,1,1},
                        {1,0,1,0,0,0,0,1,1,1,0,0,1},
                        {1,0,1,1,1,1,1,1,0,1,1,1,1},
                        {1,0,0,0,0,0,0,0,0,0,0,0,0},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1} };
      Maze labyrinth = new Maze(grid);
      go(labyrinth);

      int[][] grid1 = { {1, 0, 0, 0, 0, 0},
                        {1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1} };
      Maze labyrinth1 = new Maze(grid1);
      labyrinth1.portalChoose(1, 2, 2, 4);
      go(labyrinth1);


      int[][] grid2 = { {1, 1, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 0},
                        {1, 1, 1, 1, 1, 0},
                        {0, 0, 0, 1, 1, 1} };
      Maze labyrinth2 = new Maze(grid2);
      labyrinth2.portalChoose(1, 2, 2, 3);
      go(labyrinth2);

      int[][] grid3 = { {1, 1, 1, 1, 1, 1},
                        {0, 1, 1, 1, 1, 1},
                        {0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0, 1} };
      Maze labyrinth3 = new Maze(grid3);
      labyrinth3.portalChoose(0, 3, 3, 3);
      go(labyrinth3);
      
      int[][] grid4 = { {1, 1, 0, 1, 1, 1},
                        {0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {1, 1, 0, 0, 1, 1} };
      Maze labyrinth4 = new Maze(grid4);
      labyrinth4.portalChoose(0, 1, 0, 3);
      labyrinth4.portalChoose(1, 5, 4, 0);
      labyrinth4.portalChoose(4, 1, 4, 4);
      go(labyrinth4);

      
      }

   //-----------------------------------------------------------------

   //-----------------------------------------------------------------
   public static void go(Maze labyrinth) {
      System.out.print("-".repeat(labyrinth.getGrid()[0].length*2+1));
      System.out.print(labyrinth);
      if (labyrinth.traverse (0, 0)){
         System.out.println("-".repeat(labyrinth.getGrid()[0].length*2+1));                  
         System.out.println ("The maze was successfully traversed!");
         System.out.print("-".repeat(labyrinth.getGrid()[0].length*2+1));
      }   
      else{
         System.out.println("-".repeat(labyrinth.getGrid()[0].length*2+1));
         System.out.println ("There is no possible path.");
         System.out.print("-".repeat(labyrinth.getGrid()[0].length*2+1));
      }
      System.out.print(labyrinth);
      System.out.print("-".repeat(labyrinth.getGrid()[0].length*2+1));

   }

}
