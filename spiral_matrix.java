//O(n) time complexity
//O(1) space complexity
//Tried in leetcode and accepted on submission
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix.length == 0 || matrix[0].length == 0) return res;
        
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        
        while(true){
            //iterates from 00 to 02 in case of example 1
            //also iterates for 11 for example 1
            for(int i = left; i <= right; i++)
            {
                res.add(matrix[top][i]);
            }
            //Increment top by 1
            top++;
            //Check for boundry conditions
            if(left > right || top > bottom) 
            {
                break;
            }
            //Iterate from 12 to 22 in ex 1 
            for(int i = top; i <= bottom; i++) 
            {
                res.add(matrix[i][right]);
            }
            //decrement right by 1
            right--;
            //Check for boundry condition again
            if(left > right || top > bottom) 
            {
                break;
            }
            
            //Iterate from 21 to 20
            for(int i = right; i >= left; i--) 
            {
                res.add(matrix[bottom][i]);
            }
            //decrement bottom by 1
            bottom--;
            if(left > right || top > bottom) 
            {
                break;
            }
            //Iterate for 10
            for(int i = bottom; i >= top; i--) 
            {
                res.add(matrix[i][left]);
            }
            //Increment left by 1
            left++;
            if(left > right || top > bottom) 
            {
                break;
            }
        }
        
        return res;
    }
    
}