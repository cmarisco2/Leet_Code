class ReverseString_344{
    public void reverseString(char[] s) {
        // initialize left and right array pointers
        int left = 0, right = s.length - 1;

        // Swap values at left and right until string is reversed.
        while (left < right) {
            swap(s, left, right);
            left++;
            right--;
        }

    }

    public void swap(char[] s, int left, int right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}