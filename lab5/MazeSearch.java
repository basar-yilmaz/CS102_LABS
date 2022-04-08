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

      int[][] grid1 = { {1, 0, 0, 0, 0, 0},
                        {1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1} };
      Maze labyrinth = new Maze(grid1);
      labyrinth.portalChoose(1, 2, 2, 4);
      System.out.println("-".repeat(grid1[0].length*2+1));
      System.out.println(labyrinth);
      System.out.println("-".repeat(grid1[0].length*2+1));
      go(labyrinth);


      int[][] grid2 = { {1, 1, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 0},
                        {1, 1, 1, 1, 1, 0},
                        {0, 0, 0, 1, 1, 1} };
      Maze labyrinth2 = new Maze(grid2);
      labyrinth2.portalChoose(1, 2, 2, 3);
      System.out.println("-".repeat(grid2[0].length*2+1));
      System.out.println(labyrinth2);
      System.out.println("-".repeat(grid2[0].length*2+1));
      go(labyrinth2);

      int[][] grid3 = { {1, 1, 1, 1, 1, 1},
                        {0, 1, 1, 1, 1, 1},
                        {0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0, 1} };
      Maze labyrinth3 = new Maze(grid3);
      labyrinth3.portalChoose(0, 3, 3, 3);
      System.out.println("-".repeat(grid3[0].length*2+1));
      System.out.println(labyrinth3);
      System.out.println("-".repeat(grid3[0].length*2+1));
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
      System.out.println("-".repeat(grid4[0].length*2+1));                  
      System.out.println(labyrinth4);        
      System.out.println("-".repeat(grid4[0].length*2+1));
      go(labyrinth4);

      
      }

   //-----------------------------------------------------------------

   //-----------------------------------------------------------------
   public static void go(Maze labyrinth) {
      if (labyrinth.traverse (0, 0))
         System.out.println ("The maze was successfully traversed!");
      else
         System.out.println ("There is no possible path.");
      
      System.out.println (labyrinth);
   }

}
