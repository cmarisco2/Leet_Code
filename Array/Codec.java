//? Leetcode Problem 271: Encode & Decode Strings
//? Difficulty: 'Medium'
//? Description:

// Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

//? Example

// input = ["Hello", "World"]

// encode(String[]) -> "5#Hello5#World"
// decode(String) -> ["Hello", "World"]

// output = ["Hello", "World"]

//? Solution Approach: Encode (2 Chars -> len & special char)
    //* stringbuilder to append() 2 chars then append() string
//? Solution Approach: Decode (Sliding window: read len&special left to right)
    //* append the substring after the special char of known length 'len'

//? Time Complexity: O(N)

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Codec{
    // Encodes a list of strings to a single string.
    public static String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for (String s : strs) {
            str.append(s.length());
            str.append("#");
            str.append(s);
        }
        return str.toString();
    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {
        List<String> result = new LinkedList<>();
        int i = 0, len = 0, j;
        String str = "";

        while (i < s.length()) {
            j = i;
            while (s.charAt(j) != '#')
                j++;
            str = s.substring(i, j);
            i = j + 1;
            len = Integer.parseInt(str);
            str = s.substring(i, i + len);
            result.add(str);
            i += len;
        }
        return result;
    }

    public static void main(String[] args){
        String[] list = {"Hello", "World"};
        List<String> li = new LinkedList<>();

        for(String s : list)
            li.add(s);

        System.out.println("\nThe list of strings are: " + Arrays.toString(list)+ "\n");
        
        String code = encode(li);
        
        System.out.println("Array of String encoded is: " + code + "\n");
        
        List<String> decode = decode(code);
        String[] result = new String[decode.size()];
        int index = 0;
        for(String s : decode){
            result[index] = s;
            index++;
        }
        System.out.println("The list of decoded strings are: " + Arrays.toString(result)+ "\n");
    }
}