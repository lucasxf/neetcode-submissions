class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s
        // normalization
            .replaceAll("[^a-zA-Z0-9]", "")
            .toLowerCase()
            .toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (j > i) {
            if (chars[i++] != chars[j--]) {
                return false;
            }
        }
        return true;
    }
}
