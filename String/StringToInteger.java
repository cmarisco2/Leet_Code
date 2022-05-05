



public class StringToInteger{
    public int myAtoi(String s) {
        int sign = 1, index = 0, currNum = 0, value;
        long res = 0;

        if (s.length() == 0)
            return 0;

        // skip whitespace
        while (index < s.length() && s.charAt(index) == ' ')
            index++;

        // check if the next char has sign data.
        if (index < s.length() && (s.charAt(index) == '-' || s.charAt(index) == '+')) {
            if (s.charAt(index) == '-')
                sign = -1;
            index++;
        }

        // check if next value is a digit
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            currNum = s.charAt(index++) - '0';

            if (sign == 1) {
                res = res * 10 + currNum;
                if (res > Integer.MAX_VALUE) {
                    res = Integer.MAX_VALUE;
                    break;
                }
            } else {
                res = -1 * (Math.abs(res) * 10 + currNum);
                if (res < Integer.MIN_VALUE) {
                    res = Integer.MIN_VALUE;
                    break;
                }
            }
        }
        value = (int) res;

        return value;

    }
}