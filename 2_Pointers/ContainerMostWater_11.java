
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