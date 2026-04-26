class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int l = nums[left];
            int r = nums[right];
            int m = nums[mid];
            if (l == target) {
                return left;
            } else if (m == target) {
                return mid;
            } else if (r == target) {
                return right;
            }
            // array ordenado -> busca comum
            if (l < r) {
                // procurar na metade da direita
                if (target > m) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // se a rotação (menor valor do array) está à esquerda:
                if (m < r) { 
                    if (target > m) {
                        if (target < r) {
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    } else {
                        right = mid - 1;
                    }
                } else {
                    // rotação à direita
                    if (target < m) {
                        if (target < r) {
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
}
