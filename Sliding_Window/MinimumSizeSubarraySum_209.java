package Sliding_Window;
class MinimumSizeSubarraySum_209{
    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0, sum = 0, minLength = Integer.MAX_VALUE;
        for (; j < nums.length; j++) {
            sum += nums[j];
            if (i == j)
                sum = nums[j];
            while (sum >= target) {
                minLength = Math.min(minLength, j - i + 1);
                sum -= nums[i++];
            }
        }
        if (minLength == Integer.MAX_VALUE)
            return 0;
        return minLength;
    }

    public static void main(String[] args){
        
    }
}