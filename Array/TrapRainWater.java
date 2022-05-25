import java.util.Arrays;

//? Leetcode Problem 42: Trapping Rain Water
//? Difficulty: 'Hard'
//? Description: 
// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

//? Examples:
//? Image: https://leetcode.com/problems/trapping-rain-water/

// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

// Input: height = [4,2,0,3,2,5]
// Output: 9

//? Solution Approach:
//* Prefix/Suffix Array approach
//* @ each given location:
    //* Know maxLeft & maxRight heights
    //* calculate the Units of water at this position

//? Solution Shown:
//* Sum += minimumHeight(maxLeft, maxRight) @ i - height[i]
    //* if negative -> add 0.

//* Need to build maxLeft[] and maxRight[] to know maxheights at a given element i (similar to Prefix Sum)

//? Ex:
//* heights =  [0,1,0,2,1,0,1,3,2,1,2,1]
//* maxLeft =  [0,0,1,1,2,2,2,2,3,3,3,3]
//* maxRight = [3,3,3,3,3,3,3,2,2,2,1,0]
//* minLR  =   [0,0,1,1,2,2,2,2,2,2,1,0]
//* tmpSum = minLR[i] - height[i] -> if >= 0, sum += tmpSum


//? Time Complexity -> O(N)
//? Space Complexity -> O(3*N) == O(N)

public class TrapRainWater{
    public static int trap(int[] height) {
        int sum = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int[] minLR = new int[height.length];
        leftMax[0] = 0;
        rightMax[rightMax.length - 1] = 0;

        // build leftMax array
        for (int i = 1; i < leftMax.length; i++) {
            leftMax[i] = height[i - 1] > leftMax[i - 1] ? height[i - 1] : leftMax[i - 1];
        }

        // build rightMax array
        for (int i = rightMax.length - 2; i >= 0; i--) {
            rightMax[i] = height[i + 1] > rightMax[i + 1] ? height[i + 1] : rightMax[i + 1];
        }

        // build minLR array
        for (int i = 0; i < minLR.length; i++) {
            minLR[i] = Math.min(leftMax[i], rightMax[i]);
        }

        // calculate the sum of the trapped rainwater
        int tempSum = 0;
        for (int i = 0; i < height.length; i++) {
            tempSum = minLR[i] - height[i];
            if (tempSum >= 0)
                sum += tempSum;
        }
        return sum;
    }

    public static void main(String[] args){
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("\nValley heights are: " + Arrays.toString(heights));
        System.out.println("\nThe max amount of water trapped possible is: " + trap(heights) + "\n"); //6
    }
}