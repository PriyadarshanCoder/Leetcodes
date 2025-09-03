import java.util.*;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // Step 1: Sort greed factors and cookie sizes
        Arrays.sort(g);
        Arrays.sort(s);
        
        int i = 0; // pointer for children
        int j = 0; // pointer for cookies
        
        // Step 2: Assign cookies greedily
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                // cookie can satisfy child
                i++; // move to next child
            }
            j++; // move to next cookie (either used or too small)
        }
        
        // Step 3: return number of satisfied children
        return i;
    }
}
