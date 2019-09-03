//The aim of this program is to give an ouput array which is the product of all the values in the given array excluding the value at the same index.
//Time complexity O(N)
//Space Complexity also O(N) for solution 1 (used to find the products in the left and right arrays)
//Space complexity O(1) solution 2
// Tried both in leetcode ran successfully and was also accepted on submission
class Solution {
    public int[] productExceptSelf(int[] nums) {
        //storing the length of the nums array
        int length = nums.length;
        //Holds the product of all left elements 
        int[] L = new int[length];
        //Holds product of all the value to the right of i index
        int[] R = new int[length];
        
        int[] output = new int[length];
        
        //as there are no elements to the left of the first element index would be 0 and value will be 1
        L[0] = 1;
        //for loop to find the product of all the elements to the left of index i 
        for(int i = 1; i<length; i++)
        {
           // as L[i-1] contains the product of all the elements to the left of the i-1 index
           // L[i] would be the product of nums[i-1] and the value at L[i-1]
           L[i] = nums[i-1] * L[i-1];
        }
        
        
        // the right most index would be length-1 as there are no element to the right of the right most index
        //And its value will be assigned as 1
        R[length-1]=1;
        //for loop to find all the product of all the values to the right of the index i
        for (int i = length-2 ; i>=0 ; i--)
        {
            //same logic as the of left hence R[i] should be the product of the value at R[i+1] and nums[i+1]
            R[i] = nums[i+1] * R[i+1];
        }
        
        //Loop for the output array
        for (int i = 0; i< length; i++)
        {
            //L[i] holds the product of all the elements to the left of i except i 
            //R[i] holds the product of all the elements to the right of index i except that of i
            //hence output[i] must be the product of all elements to the left of i and all the elements to the right of i 
            output[i] = L[i] * R[i];
        }
        //Return the output array 
        return output;
    }
}

//solution 2 

class Solution {
    public int[] productExceptSelf(int[] nums) {

        // The length of the input array 
        int length = nums.length;

        // Final answer array to be returned
        int[] answer = new int[length];

        // answer[i] contains the product of all the elements to the left
        // Note: for the element at index '0', there are no elements to the left,
        // so the answer[0] would be 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {

            // answer[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] would give the product of all 
            // elements to the left of index 'i'
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R contains the product of all the elements to the right
        // Note: for the element at index 'length - 1', there are no elements to the right,
        // so the R would be 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {

            // For the index 'i', R would contain the 
            // product of all elements to the right. We update R accordingly
            answer[i] = answer[i] * R;
            R *= nums[i];
        }

        return answer;
    }
}