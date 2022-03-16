class ValidPalindrome_125{
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (!isAlphaNumeric(s.charAt(left))) {
                left++;
                if (left >= s.length())
                    return true;
            }
            while (!isAlphaNumeric(s.charAt(right))) {
                right--;
                if (right < 0)
                    return true;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public boolean isAlphaNumeric(char ch) {
        return ch >= 48 && ch <= 57 || ch >= 65 && ch <= 90 || ch >= 97 && ch <= 122;
    }
}