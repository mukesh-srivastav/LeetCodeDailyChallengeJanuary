/**
Problem Statement:
You are given an array of distinct integers arr and an array of integer arrays pieces, where the integers in pieces are distinct. Your goal is to form arr by concatenating the arrays in pieces in any order. However, you are not allowed to reorder the integers in each array pieces[i].

Return true if it is possible to form the array arr from pieces. Otherwise, return false.

 

Example 1:

Input: arr = [85], pieces = [[85]]
Output: true
Example 2:

Input: arr = [15,88], pieces = [[88],[15]]
Output: true
Explanation: Concatenate [15] then [88]
Example 3:

Input: arr = [49,18,16], pieces = [[16,18,49]]
Output: false
Explanation: Even though the numbers match, we cannot reorder pieces[0].
Example 4:

Input: arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
Output: true
Explanation: Concatenate [91] then [4,64] then [78]
Example 5:

Input: arr = [1,3,5,7], pieces = [[2,4,6,8]]
Output: false
 

Constraints:

1 <= pieces.length <= arr.length <= 100
sum(pieces[i].length) == arr.length
1 <= pieces[i].length <= arr.length
1 <= arr[i], pieces[i][j] <= 100
The integers in arr are distinct.
The integers in pieces are distinct (i.e., If we flatten pieces in a 1D array, all the integers in this array are distinct).
   Hide Hint #1  
Note that the distinct part means that every position in the array belongs to only one piece
   Hide Hint #2  
Note that you can get the piece every position belongs to naively */

/**
Solution Approach: In pieces, For arrays with single element (1 length), we only need to check if that exists in the arr array or not. 
For multi elements arrays, We need to check all the elements and their positions match in the arr array or not. That's it.
 */
class Day1_CheckArrayFormationThroughConcatenation {
   public boolean canFormArray(int[] arr, int[][] pieces) {
        int hash[] = new int[101];
        Arrays.fill(hash, -1);
        for (int i=0; i<arr.length; i++) {
            hash[arr[i]] = i;
        }
        
        for (int i=0; i<pieces.length; i++) {
            int curr = pieces[i][0];
            for (int j=0; j<pieces[i].length - 1; j++) {
                if (hash[pieces[i][j]] != hash[pieces[i][j+1]] - 1)
                    return false;
                
            }
            
            if (hash[curr] == -1)
                return false;
        }
        
        return true;
    }
}