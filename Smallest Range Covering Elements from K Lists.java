class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int currentMax = Integer.MIN_VALUE;
        int start = 0, end = Integer.MAX_VALUE;
        
        // Initialize the heap with the first element of each list
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            minHeap.offer(new int[]{val, i, 0}); // {value, listIndex, elementIndex}
            currentMax = Math.max(currentMax, val);
        }
        
        while (minHeap.size() == nums.size()) {
            int[] min = minHeap.poll();
            int minVal = min[0], listIndex = min[1], elementIndex = min[2];
            
            // Update the smallest range
            if (currentMax - minVal < end - start || 
                (currentMax - minVal == end - start && minVal < start)) {
                start = minVal;
                end = currentMax;
            }
            
            // Move to next element in the same list
            if (elementIndex + 1 < nums.get(listIndex).size()) {
                int nextVal = nums.get(listIndex).get(elementIndex + 1);
                minHeap.offer(new int[]{nextVal, listIndex, elementIndex + 1});
                currentMax = Math.max(currentMax, nextVal);
            }
        }
        
        return new int[]{start, end};
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> nums1 = Arrays.asList(
            Arrays.asList(4,10,15,24,26),
            Arrays.asList(0,9,12,20),
            Arrays.asList(5,18,22,30)
        );
        System.out.println(Arrays.toString(sol.smallestRange(nums1))); // [20,24]
        
        List<List<Integer>> nums2 = Arrays.asList(
            Arrays.asList(1,2,3),
            Arrays.asList(1,2,3),
            Arrays.asList(1,2,3)
        );
        System.out.println(Arrays.toString(sol.smallestRange(nums2))); // [1,1]
    }
}
