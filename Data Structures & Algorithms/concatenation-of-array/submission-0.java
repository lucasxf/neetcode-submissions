class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length*2];
        int j = 0;
        for (int i = 0; i < ans.length; i++) {
            ans[i] = nums[j];
            if (j == nums.length - 1) {
                j = 0;
            } else {
                
            j++;
            }
        }
        return ans;
    }
}