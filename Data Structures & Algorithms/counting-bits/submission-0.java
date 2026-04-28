class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for (int j = 0; j <= n; j++) {
            int c = 0;    
            for (int i = 31; i >= 0; i--) {
                int mask = 1 << i;
                if ((j & mask) != 0) {
                    c++;
                }
            }
            result[j] = c;
        }
        return result;
    }
}
