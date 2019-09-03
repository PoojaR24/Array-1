//Time complexity O(m*n)
//space complexity O(1)
//Ran on leet code and accepted. 
public class Solution 
{
    public int[] findDiagonalOrder(int[][] matrix) 
    {
        //Check for empty matrix
        if (matrix == null || matrix.length == 0) return new int[0];
        
        //m is the total number of rows in a matrix and n the total number of columns in the matrix
        int m = matrix.length, n = matrix[0].length;
        
        int[] result = new int[m * n];
        int row = 0, col = 0, d = 0;
        //Increment the col while moving up and decrease the row
        //Increment the row while moving down and decrement the col
        //traversal    //00  01  10  11
        int[][] dirs = {{-1, 1}, {1, -1}};//direction matrix 
        
        for (int i = 0; i < m * n; i++) 
        {
            result[i] = matrix[row][col];
            //System.out.print(result[i]);
            System.out.print("Before: ");
            System.out.print(row);
            System.out.print(col);
            row += dirs[d][0];
            col += dirs[d][1];
            System.out.print("After: ");
            System.out.print(row);
            System.out.print(col);
            
            //if the current row is greater than or equal to total number of rows
            //If out of bottom border
            if (row >= m) 
            { 
                //decrease row increase column by 2 and change the direction by subtracting d from 1
                row = m - 1; 
                col += 2; // change direction.
                d = 1 - d;
            }
            //If the current col > number of columns 
            //if out of right border
            if (col >= n) 
            { 
                //decrement column increase row by 2 change direction
                col = n - 1; 
                row += 2; // change direction.
                d = 1 - d;
            }
            //If current row below 0 then bring row to 0 and assign direction
            //if out of top border
            if (row < 0)  
            { 
                row = 0; // change direction.
                d = 1 - d;
            }
            //If current column is < 0 then bring column to 0 and change direction
            //if out of left border
            if (col < 0)  
            { 
                col = 0; // change direction.
                d = 1 - d;
            }
        }
        
        return result;
    }
}