class Solution {
    public int findMin(int[] nums) {
        int len = nums.length; // 6
        int left = 0; // 0
        int right = len - 1; // 5
        int min = Integer.MAX_VALUE;
        // short circuiting
        if (len == 1) {
            return nums[0];
        }
        // exactly 0 or XN rotations
        if (nums[0] < nums[len-1]) {
            return nums[0];
        }
        while (left < right) { // true
            int mid = left + (right - left) / 2; // 5/2 = 2 |
            int l = nums[left];
            int r = nums[right];
            int m = nums[mid];
            if (l > r) {
                // resultado está entre L e M
                if (r > m) {
                    right = mid;
                    min = Math.min(min, m);
                } else {
                     if (l == m) {
                        min = Math.min(min, r);
                        break;
                    }
                    left = mid;
                }
                // r > m > l -> res entre RL (exatamente 0 ou N rotações, ou seja, array ordenado, ou seja, resultado = nums[0])
            } else if (m > l) {
                return nums[0];
            }
            if (m > l) {
                if (l > r) {
                    left = mid;
                    min = Math.min(min, r);
                }
            }
        }
        return min;
    }
}
