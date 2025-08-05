class Solution {
    public int myAtoi(String s) {
        if (s == null) return 0;

        s = s.trim();
        if (s.length() == 0) return 0;

        int sign = 1;
        int i = 0;
        long ans = 0;

        // Handle sign
        if (s.charAt(0) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(0) == '+') {
            i++;
        }

        // Convert digits
        while (i < s.length()) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) break;

            ans = ans * 10 + (c - '0');

            // Check for overflow
            if (sign == 1 && ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && -ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }

        return (int)(sign * ans);
    }
}