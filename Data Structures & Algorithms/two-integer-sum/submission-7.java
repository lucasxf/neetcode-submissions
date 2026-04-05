class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complementMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (complementMap.get(complement) != null) {
                return new int[] {complementMap.get(complement), i};
            }
            complementMap.put(nums[i], i);
        }
        return null;
    }
}
