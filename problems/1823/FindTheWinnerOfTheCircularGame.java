class Solution {
    public int findTheWinner(int n, int k) {
        // f[i] means the winner index of i length circle
        // f[i] = (f[i - 1] + k) % i
        // f[1] ==a 0
        int f = 0;
        for (int i = 2; i <= n; i++) {
            f = (f + k) % i;
        }
        return f + 1;
    }
}