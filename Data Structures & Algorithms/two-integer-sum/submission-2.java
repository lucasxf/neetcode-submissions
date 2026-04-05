class Solution {
    public int[] twoSum(int[] nums, int target) {
        // PROBLEM: Find if any value appears at least twice
        // INPUT: int[], OUTPUT: boolean
        // EXAMPLE: [1,2,3,1] → true (1 appears twice)
        // PATTERN: Existence check → HashSet for O(1) lookup
        // APPROACH: HashSet, add each element, return true if add fails
        // COMPLEXITY: O(n) time, O(n) space
        int i = 0;
        int j = 1;
        while (i < nums.length && j < nums.length) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                return new int[] {i , j};
            }
            if (sum < target) {
                j++;
            } else {
                i++;
                j--;
            }
        }
        return new int[] {i ,j};
    }
}
