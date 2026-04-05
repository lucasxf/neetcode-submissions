class Solution {
    public int[] twoSum(int[] nums, int target) {
        // PROBLEM: Find if any value appears at least twice
        // INPUT: int[], OUTPUT: boolean
        // EXAMPLE: [1,2,3,1] → true (1 appears twice)
        // PATTERN: Existence check → HashSet for O(1) lookup
        // APPROACH: HashSet, add each element, return true if add fails
        // COMPLEXITY: O(n) time, O(n) space
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                int n = nums[i] + nums[j];
                if (n == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
