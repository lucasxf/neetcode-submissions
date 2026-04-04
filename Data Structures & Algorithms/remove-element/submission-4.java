class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int[] aux = new int[len];
        int j = 0;
        int countVal = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == val) {
                countVal++;
            } else {
                aux[j] = nums[i];
                nums[j] = nums[i];
                j++;
            }
        }
        /*
        for (int i = 0; i < result; i++) {
            nums[i] = aux[i];
        }*/
        return j;
    }
}