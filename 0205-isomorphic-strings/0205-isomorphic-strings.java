class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            if (map.containsKey(cs)) {   // Prevent a keys mapping to same value/ multipe value
                if (map.get(cs) != ct) return false;
            } else {
                if (map.containsValue(ct)) return false; // Prevent multiple same value getting add inmap. 
                map.put(cs, ct);
            }
        }

        return true;
    }
}