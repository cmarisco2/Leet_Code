class DuplicateZeros{
    class Solution {
        public void duplicateZeros(int[] arr) {
            int[] dup = new int[arr.length];
            for (int i = 0, j = 0; j < arr.length && i < arr.length; i++, j++) {
                if (arr[i] == 0) {
                    dup[j++] = arr[i];
                }
                if (j >= arr.length)
                    break;
                dup[j] = arr[i];
            }

            int k = 0;
            for (int num : dup) {
                arr[k++] = num;
            }
        }
    }
}