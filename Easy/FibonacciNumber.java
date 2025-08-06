public class Solution {
    public int fib(int n) {
        if (n <= 1) return n;

        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }

        return b;
    }
}


public class Solution {
    public int fib(int n) {
        return tailFib(n, 0, 1);
    }

    private int tailFib(int n, int a, int b) {
        if (n == 0) return a;
        if (n == 1) return b;
        return tailFib(n - 1, b, a + b);
    }
}
