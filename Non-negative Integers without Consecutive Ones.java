class Solution {
    public int findIntegers(int n) {
      // dp[i] = count of binary strings of length i without consecutive 1s
        int[] dp = new int[32];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < 32; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int result = 0;
        int prevBit = 0;  // previous bit
        int k = 30;       // highest bit position (since n <= 10^9)

        while (k >= 0) {
            if ((n & (1 << k)) != 0) {
                result += dp[k];

                if (prevBit == 1) {
                    return result; // consecutive 1s found
                }

                prevBit = 1;
            } else {
                prevBit = 0;
            }
            k--;
        }

        // include n itself
        return result + 1;   
    }
}
