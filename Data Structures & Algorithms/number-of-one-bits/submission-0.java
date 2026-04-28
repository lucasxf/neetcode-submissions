class Solution {
    public int hammingWeight(int n) {
        StringBuilder result = new StringBuilder();
        int c = 0;
        for (int i = 31; i >= 0; i--) {
            int mask = 1 << i;
            if ((n & mask) != 0) {
                c++;
            }
        }
        return c;
    }
}
