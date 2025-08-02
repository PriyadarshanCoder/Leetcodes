class Solution {

    boolean isFreqsame(int freq1[], int freq2[]){
        for(int i=0; i<26;i++){
            if(freq1[i] != freq2[i]){
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] freq  = new int[26];
        for(int i=0; i<s1.length(); i++){
            freq[s1.charAt(i) - 'a']++;// -a gives the index of that character in the alphabet
        }
        int windowSize = s1.length();
        for(int i=0; i< s2.length(); i++){
            int windowIdx = 0;
            int[] windowfreq  = new int[26];
            int idx= i;
            while(windowIdx < windowSize && idx < s2.length()){
                windowfreq[s2.charAt(idx) - 'a']++;
                windowIdx++;
                idx++;
            } 

            if(isFreqsame(freq, windowfreq)){
                return true;
            }
        }
        return false;
    }
}
