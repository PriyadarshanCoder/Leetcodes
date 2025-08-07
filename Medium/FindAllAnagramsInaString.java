class Solution {
    public List<Integer> findAnagrams(String s, String p) {
         List<Integer> result = new ArrayList<>();

        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen) return result;

        int[] pcount = new int[26];
        int[] scount = new int[26];

        // Count characters in p
        for (int i = 0; i < pLen; i++) {
            pcount[p.charAt(i) - 'a']++;
        }

        // Slide over s
        for (int i = 0; i < sLen; i++) {
            scount[s.charAt(i) - 'a']++;

            if (i >= pLen) {
                scount[s.charAt(i - pLen) - 'a']--;
            }

            if (i >= pLen - 1 && isSameCount(pcount, scount)) {
                result.add(i - pLen + 1);
            }
        }

        return result;
    }

    private boolean isSameCount(int[] pcount, int[] scount) {
        for (int i = 0; i < 26; i++) {
            if (pcount[i] != scount[i]) return false;
        }
        return true;
    }
}
