class Solution {
    public int findMin(int[] nums) {
        int len = nums.length; // 6
        int left = 0; // 0
        int right = len - 1; // 5
        int min = Integer.MAX_VALUE;
        int i = 0;
        if (len == 1) {
            return nums[0];
        }
        while (left < right && i < 20) { // true
            i++;
            int mid = left + (right - left) / 2; // 5/2 = 2 |
            int l = nums[left];
            int r = nums[right];
            int m = nums[mid];
            System.out.printf("left: %d | right: %d | mid: %d | l: %d | r: %d | m: %d | i: %d | min: %d%n", left, right, mid, l, r, m, i, min);
            if (l > r) {
                // resultado está entre L e M
                if (r > m) {
                    right = mid;
                    min = Math.min(min, m);
                    System.out.println("aqui");
                } /*else {
                     if (l == m) {
                        min = Math.min(min, r);
                        break;
                    }
                    left = mid;
                }*/
                // r > m > l -> res entre RL (exatamente 0 ou N rotações, ou seja, array ordenado, ou seja, resultado = nums[0])
            } else if (m > l) {
                return nums[0];
            }
            if (m > l) {
                if (l > r) {
                    System.out.println("M > L > R");
                    left = mid;
                    min = Math.min(min, r);
                }
            }
        }
        return min;
    }
}
