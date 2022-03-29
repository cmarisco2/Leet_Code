import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class ThreeSum_15{
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int a = 0;
        int left, right,  sum;
        LinkedList<List<Integer>> result = new LinkedList<>();

        for (; a < nums.length; a++) {

            left = a + 1;
            right = nums.length - 1;



            while (left < right) {
                LinkedList<Integer> sums = new LinkedList<>();
                while (left >= 1 && nums[left - 1] == nums[left]){ 
                    left++;
                    if(left > nums.length) break;
                }
                while (right <= nums.length - 2 && nums[right] == nums[right + 1]){
                    right--;
                    if(right < 0) break;
                }
                
                sum = nums[left] + nums[right];
                if (sum + a == 0) {
                    sums.add(a);
                    sums.add(left);
                    sums.add(right);
                    result.add(sums);
                } else if (sum + a < 0){
                    left++;
                }
                else {

                    right--;
                }

            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] numbers = { -1, 0, 1, 2, -1, -4 };
        LinkedList<List<Integer>> ints = (LinkedList<List<Integer>>) threeSum(numbers);
        for(List<Integer> list: ints){
            for(int w : list){
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }
}