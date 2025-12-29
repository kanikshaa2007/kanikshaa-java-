class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;

        // Step 1: sort the array
        java.util.Arrays.sort(nums);

        int count = 0;

        // Step 2: fix the largest side
        for (int k = n - 1; k >= 2; k--) {
            int i = 0;
            int j = k - 1;

            // Step 3: two pointers
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    // all pairs from i to j-1 are valid
                    count += (j - i);
                    j--;
                } else {
                    i++;
                }
            }
        }

        return count;
    }
}
