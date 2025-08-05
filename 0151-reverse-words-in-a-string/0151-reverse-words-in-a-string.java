class Solution {
    public String reverseWords(String s) {
         // Trim leading and trailing spaces
        s = s.trim();

        // Split by one or more spaces using regex
        String[] words = s.split("\\s+");

        // Use StringBuilder for efficient string concatenation
        StringBuilder reversed = new StringBuilder();

        // Append words in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" ");
            }
        }

        return reversed.toString();
    }
}