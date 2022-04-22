package lab5;
import java.util.ArrayList;

//********************************************************************
//  Maze.java       Author: Lewis/Loftus 
//  Edited by Başar YILMAZ
//
//  Represents a maze of characters. The goal is to get from the
//  top left corner to the bottom right, following a path of 1s.
//********************************************************************

public class Maze
{
   private final int TRIED = 3;
   private final int PATH = 7;

   private ArrayList<int[]> portLocations = new ArrayList<int[]>();
   private int[][] grid;

   public Maze(int[][] arr) {
      this.grid = arr;
   }

   public int[][] getGrid() {
       return grid;
   }

   //-----------------------------------------------------------------
   //  Attempts to recursively traverse the maze. Inserts special
   //  characters indicating locations that have been tried and that
   //  eventually become part of the solution.
   //-----------------------------------------------------------------
   public boolean traverse (int row, int column)
   {
      boolean done = false;
      
      if (valid (row, column))
      {
         grid[row][column] = TRIED;  // this cell has been tried

         if (row == grid.length-1 && column == grid[0].length-1)
            done = true;  // the maze is solved
         else
         {
            done = traverse (row+1, column);     // down
            if (!done)
               done = traverse (row, column+1);  // right
            if (!done)
               done = traverse (row-1, column);  // up
            if (!done)
               done = traverse (row, column-1);  // left
            if (!done && portalCheck(row, column))
               done = traverse(outRow(row, column), outColumn(row, column));
         }

         if (done)  // this location is part of the final path
            grid[row][column] = PATH;
      }
      
      return done;
   }

   // location is portal ?
   private boolean portalCheck(int row, int column) {
      for (int i = 0; i < portLocations.size(); i++) {
         if (portLocations.get(i)[0] == row && portLocations.get(i)[1] == column) {
            return true;
         }
      }
      return false;
   }

   private int outRow(int row, int column) {
      for (int i = 0; i < portLocations.size(); i++) {
         if (portLocations.get(i)[0] == row && portLocations.get(i)[1] == column) {
            return portLocations.get(i)[2];
         }
      }
      return -1;
   }

   private int outColumn(int row, int column) {
      for (int i = 0; i < portLocations.size(); i++) {
         if (portLocations.get(i)[0] == row && portLocations.get(i)[1] == column) {
            return portLocations.get(i)[3];
         }
      }
      return -1;
   }

   public void portalChoose(int row1, int column1, int row2, int column2) {
      // portalLocations = [[row1, column1, row2, column2], [row3, column3, row4, column4]]
      portLocations.add(new int[] {row1, column1, row2, column2});
   }
   
   //-----------------------------------------------------------------
   //  Determines if a specific location is valid.
   //-----------------------------------------------------------------
   private boolean valid (int row, int column)
   {
      boolean result = false;
 
      // check if cell is in the bounds of the matrix
      if (row >= 0 && row < grid.length &&
          column >= 0 && column < grid[row].length)

         //  check if cell is not blocked and not previously tried
         if (grid[row][column] == 1)
            result = true;

      return result;
   }

   //-----------------------------------------------------------------
   //  Returns the maze as a string.
   //-----------------------------------------------------------------
   public String toString ()
   {
      String result = "\n";

      for (int row=0; row < grid.length; row++)
      {
         for (int column=0; column < grid[row].length; column++)
            result += grid[row][column] + " ";
         result += "\n";
      }

      return result;
   }
}
