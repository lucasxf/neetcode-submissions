class Solution {
    public int[] twoSum(int[] nums, int target) {
        // PROBLEM: Find if any value appears at least twice
        // INPUT: int[], OUTPUT: boolean
        // EXAMPLE: [1,2,3,1] → true (1 appears twice)
        // PATTERN: Existence check → HashSet for O(1) lookup
        // APPROACH: HashSet, add each element, return true if add fails
        // COMPLEXITY: O(n) time, O(n) space
        int len = nums.length;
        int i = 0;
        int j = len - 1;
        while (i < len && j > 0) {
            int sum = Math.abs(nums[i]) + Math.abs(nums[j]);
            if (sum == target) {
                return new int[] {i , j};
            }
            if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[] {i ,j};
    }
}
