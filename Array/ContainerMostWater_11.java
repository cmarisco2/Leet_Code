//? Leetcode Problem 11: 'Container with Most Water'
//? Difficulty: 'Medium'
//? Description:

// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

// Find two lines that together with the x-axis form a container, such that the container contains the most water.

// Return the maximum amount of water a container can store.

// Notice that you may not slant the container.

//? Examples:
// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49
// Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

// Input: height = [1,1]
// Output: 1

//? Solution Approach: 2 Pointers
//* Linear Structure (array)
//* BF takeaway is: min(height) is limiting component in area calc.
//* Width is maximized by having the greatest distance between elements in the array indices.

//? Solution Notes:
//* 1) Left & Right Pointers start at opposite ends of array.
//* 2) Area = minHeight(left, right) * diffOfIndices(left, right)
//* 3) Keep track of max area calculated on each iteration.

//? Time Complexity: O(N)
//? Space Complexity: O(1)
class ContainerMostWater_11{
    public int maxArea(int[] height) {
        int vert, width, area, maxArea = 0, left = 0, right = height.length - 1;

        while (left < right) {
            vert = Math.min(height[left], height[right]);
            width = right - left;
            area = vert * width;
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }
}