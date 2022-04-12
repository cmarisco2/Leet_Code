class LongestRepeatingCharacterReplacement{
    public int characterReplacement(String s, int k) {
        int[] letterCount = new int[26]; // Capital English Letters.
        int left = 0, right = 0; // String Scanners.
        int result = 0; // Stores the running max.
        int windowLen = 0; // length of max running window.

        char mostFreqChar = s.charAt(left);
        int maxFreq = 0;
        int limit = windowLen - maxFreq;

        while (limit <= k && right < s.length()) {

            // add key @ R to the array and update its value.
            char key = s.charAt(right);
            letterCount[(int) key - 65]++;

            // Find Max Freq Character and its value;
            for (int i = 0; i < letterCount.length; i++) {
                if (letterCount[i] > maxFreq) {
                    mostFreqChar = (char) (i + 65);
                    maxFreq = letterCount[i];
                }
            }

            // intermediary calculations of window & limit
            windowLen = right - left + 1;
            limit = windowLen - maxFreq;

            // check if limit is exceeded
            while (limit > k) {
                key = s.charAt(left);
                letterCount[(int) key - 65]--;
                left++;
                for (int i = 0; i < letterCount.length; i++) {
                    if (letterCount[i] > maxFreq) {
                        mostFreqChar = (char) (i + 65);
                        maxFreq = letterCount[i];
                    }
                }
                windowLen = right - left + 1;
                limit = windowLen - maxFreq;
            }

            // final calculations of limit and window length.
            windowLen = right - left + 1;
            limit = windowLen - maxFreq;

            // update result.
            result = Math.max(result, windowLen);
            // continue scan.
            right++;
        }

        return result;
    }
}