class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int countVal = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                len--;
            }
        }
        int j = 0;
        int[] aux = new int[len];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                aux[j] = nums[i];
                j++;
            }
        }
        for (int i = 0; i < len; i++) {
            nums[i] = aux[i];
        }
        return len;
    }
}