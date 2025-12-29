class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < dp.length; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = true;
            }
            else {
                break;
            }
        }
        for (int j = 1; j < dp[0].length; j++) {
            if (s2.charAt(j - 1) == s3.charAt(j - 1)) {
                dp[0][j] = true;
            }
            else {
                break;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];

        ////wrong
        // if (s3.length() != s1.length() + s2.length()) {
        //     return false;
        // }
        // if (s1.length() < s2.length()) {
        //     String mid = s1;
        //     s1 = s2;
        //     s2 = mid;
        // }
        // int i = 0;
        // int j = 0;
        // int counts1 = 1;
        // int counts2 = 1;
        // int now = 0;
        // for (int r = 0; r < s3.length(); r++) {
        //     if (i == s1.length()) {
        //         if (s3.charAt(r) != s2.charAt(j)) {
        //             return false;
        //         }
        //         else {
        //             if (now == 0) {
        //                 now = 2;
        //             }
        //             else if (now == 1) {
        //                 now = 2;
        //                 counts2 += 1;
        //             }
        //             j++;
        //         }
        //     }
        //     else if (j == s2.length()) {
        //         if (s3.charAt(r) != s1.charAt(i)) {
        //             return false;
        //         }
        //         else {
        //             if (now == 0) {
        //                 now = 1;
        //             }
        //             else if (now == 2) {
        //                 now = 1;
        //                 counts1 += 1;
        //             }
        //             i++;
        //         }
        //     }
        //     else {
        //         if (now != 2) {
        //             if (s3.charAt(r) == s1.charAt(i)) {
        //                 if (now == 0) {
        //                     now = 1;
        //                 }
        //                 else if (now == 2) {
        //                     now = 1;
        //                     counts1 += 1;
        //                 }
        //                 i++;
        //             }
        //             else if (s3.charAt(r) == s2.charAt(j)) {
        //                 if (now == 0) {
        //                     now = 2;
        //                 }
        //                 else if (now == 1) {
        //                     now = 2;
        //                     counts2 += 1;
        //                 }
        //                 j++;
        //             }
        //             else {
        //                 return false;
        //             }

        //         }
        //         else {
        //             if (s3.charAt(r) == s2.charAt(j)) {
        //                 if (now == 0) {
        //                     now = 2;
        //                 }
        //                 else if (now == 1) {
        //                     now = 2;
        //                     counts2 += 1;
        //                 }
        //                 j++;
        //             }
        //             else if (s3.charAt(r) == s1.charAt(i)) {
        //                 if (now == 0) {
        //                     now = 1;
        //                 }
        //                 else if (now == 2) {
        //                     now = 1;
        //                     counts1 += 1;
        //                 }
        //                 i++;
        //             }
        //             else {
        //                 return false;
        //             }
        //         }
        //     }
        // }

        // if (Math.abs(counts1 - counts2) <= 1) {
        //     return true;
        // }
        // else {
        //     return false;
        // }
        

    }
}
