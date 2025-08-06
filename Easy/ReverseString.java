//both recusrive and linear appeoch

class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            // Swap characters at left and right
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}



// public class Solution {
//     public void reverseString(char[] s) {
//         reverseHelper(s, 0, s.length - 1);
//     }

//     private void reverseHelper(char[] s, int left, int right) {
//         if (left >= right) {
//             return;
//         }

//         // Swap characters
//         char temp = s[left];
//         s[left] = s[right];
//         s[right] = temp;

//         // Recursive call
//         reverseHelper(s, left + 1, right - 1);
//     }
// }
