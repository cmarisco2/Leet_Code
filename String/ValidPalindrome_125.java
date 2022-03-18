//? Leetcode Problem #125: 'Valid Palindrome'
//? Difficulty: 'Easy'
//? Description:
// A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

// Given a string s, return true if it is a palindrome, or false otherwise.

//? Examples: 
// Input: s = "A man, a plan, a canal: Panama"
// Output: true
// Explanation: "amanaplanacanalpanama" is a palindrome.

// Input: s = "race a car"
// Output: false
// Explanation: "raceacar" is not a palindrome.

// Input: s = " "
// Output: true
// Explanation: s is an empty string "" after removing non-alphanumeric characters.
// Since an empty string reads the same forward and backward, it is a palindrome.

//? Good Solution:
//* Create String t.
//* Add to string t all chars of String s, IFF Character.isLetterOrDigit(char) passes.
//* Compare the string forwards and backwards (lastChar(t) == firstChar(s))
//? Solution is TC -> O(N), SC -> O(N)

//? Optimal Solution: 
//* Create filter helper function 'isAlphaNumeric' to test ASCII values of chars.
//* Use 2 Pointers in primary function. left = start of s, right = end of s.
//* While(left < right), traverse string (left++, right--)
    //* skip non-alphanumeric chars
    //* compare lower-case alphanumeric chars
//? Solution is TC -> O(N), SC -> O(1)

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