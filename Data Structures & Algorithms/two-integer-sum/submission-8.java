class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexPerValue = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (indexPerValue.containsKey(complement)) {
                return new int[] {indexPerValue.get(complement), i};
            }
            indexPerValue.put(nums[i], i);
        }
        throw new IllegalArgumentException("Input array does not have possible result");
    }
}
