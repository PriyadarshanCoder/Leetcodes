class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
         int t = tickets[k];
        int time = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                time += Math.min(tickets[i], t);
            } else {
                time += Math.min(tickets[i], t - 1);
            }
        }
        return time;
    }
}
