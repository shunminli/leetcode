class Solution {
    public static int[][] f;

    public int superEggDrop(int K, int N) {
        f = new int[K + 1][N + 1];
        // When you throw in k eggs, you still have N layers and you don't know how many times you need them
        for (int i = 0; i <= K; i++) {
            f[i][0] = 0;
        }
        for (int j = 1; j <= N; j++) {
            f[1][j] = j;
        }
        for (int i = 2; i <= K; i++) {
            int x = 1;
            // maintain X with monotonicity
            for (int j = 1; j <= N; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = x; k <= j; k++) {
                    // The k layer is broken or not broken to a maximum
                    if (f[i - 1][k - 1] >= f[i][j - k]) {
                        x = k;
                        min = Math.min(min, f[i - 1][k - 1] + 1);
                        break;
                    } else {
                        min = Math.min(min, f[i][j - k] + 1);
                    }
                }
                f[i][j] = min;
            }
        }
        return f[K][N];
    }
}
