public class PermutationInString{
    public boolean checkInclusion(String s1, String s2) {
        int matches = 0;
        int windowLength = s1.length();
        int radix = 26; // base of lowercase alphabetical chars
        if (s2.length() < s1.length())
            return false;

        int[] s1Map = new int[radix];
        int[] s2Map = new int[radix];

        // Build S1 Map
        for (int i = 0; i < windowLength; i++) {
            char key = s1.charAt(i);
            s1Map[charIndex(key)]++;
        }

        // Build S2 Map w/ S1 size -> sliding window
        for (int i = 0; i < windowLength; i++) {
            char key = s2.charAt(i);
            s2Map[charIndex(key)]++;
        }

        // count initial matches
        for (int i = 0; i < radix; i++) {
            if (s1Map[i] == s2Map[i])
                matches++;
        }

        // Check matches while sliding the window:
        int left = 0;
        int right = windowLength - 1;
        for (; right < s2.length() - 1; left++) {
            if (matches == radix)
                return true;
            // update matches if
            // 1) maps equal -> matches++
            // 2) maps arent' equal, but were (off by 1) -> matches--;

            // remove left
            char leftkey = s2.charAt(left);
            s2Map[charIndex(leftkey)]--;
            if (s1Map[charIndex(leftkey)] == s2Map[charIndex(leftkey)])
                matches++;
            else if (s1Map[charIndex(leftkey)] == s2Map[charIndex(leftkey)] + 1)
                matches--;
            // add right
            char rightkey = s2.charAt(++right);
            s2Map[charIndex(rightkey)]++;
            if (s1Map[charIndex(rightkey)] == s2Map[charIndex(rightkey)])
                matches++;
            else if (s1Map[charIndex(rightkey)] == s2Map[charIndex(rightkey)] - 1)
                matches--;
        }

        return matches == radix;
    }

    public int charIndex(char ch) {
        return ch - 'a';
    }
}