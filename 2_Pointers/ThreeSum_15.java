import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class ThreeSum_15{
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int a = 0;
        LinkedList<List<Integer>> result = new LinkedList<>();

        for (; a < nums.length; a++) {

            int left = a + 1;
            int right = nums.length - 1;
            int target = 0 - nums[a];
            int sum;

            while (left <= right) {
                LinkedList<Integer> sums = new LinkedList<>();
                while (left >= 1 && nums[left - 1] == nums[left])
                    left++;
                while (right <= nums.length - 2 && nums[right] == nums[right + 1])
                    right--;
                sum = nums[left] + nums[right];
                if (sum == target) {
                    sums.add(a);
                    sums.add(left);
                    sums.add(right);
                    result.add(sums);
                } else if (sum < target)
                    left++;
                else
                    right--;

            }
        }
        return result;
    }

    public static void main(String[] args){
        
    }
}