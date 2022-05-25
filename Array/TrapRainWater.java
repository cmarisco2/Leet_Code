public class TrapRainWater{
    public int trap(int[] height) {
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
}