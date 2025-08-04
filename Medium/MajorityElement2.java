class Solution {
    public List<Integer> majorityElement(int[] nums) {
         int majElement1 = 0, majElement2 = 1, count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == majElement1) count1++;
            else if (num == majElement2) count2++;
            else if (count1 == 0) {
                majElement1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                majElement2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = count2 = 0;
        for (int num : nums) {
            if (num == majElement1) count1++;
            else if (num == majElement2) count2++;
        }

        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        if (count1 > n / 3) res.add(majElement1);
        if (count2 > n / 3) res.add(majElement2);
        return res;
    }
}
