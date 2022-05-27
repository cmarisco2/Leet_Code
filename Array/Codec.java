import java.util.LinkedList;
import java.util.List;

public class Codec{
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for (String s : strs) {
            str.append(s.length());
            str.append("#");
            str.append(s);
        }
        return str.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
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
}