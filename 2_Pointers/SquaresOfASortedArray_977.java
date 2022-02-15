class SquaresOfASortedArray_977{
    public static int[] sortedSquares(int[] nums) {
        int j = nums.length - 1;
        int R = j;
        int L = 0;
        int[] aux = new int[j + 1];

        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }

        while (L <= R) {
            if (nums[R] > nums[L]) {
                aux[j] = nums[R];
                R--;
            } else {
                aux[j] = nums[L];
                L++;
            }
            j--;
        }
        return aux;
    }

    public static void main(String[] args){
        int[] nums = { -4, -1, 0, 3, 10 };
        System.out.println("String of Sorted Numbers Given: ");
        System.out.print("[ ");
        for(int num : nums){
            System.out.print(num + " ");
        }
        System.out.println("]");
        System.out.println("Sorted Squares of Numbers Given: ");
        System.out.print("[ ");
        nums = sortedSquares(nums);
        for(int num : nums){
            System.out.print(num + " ");
        }
        System.out.println("]");
    }
}