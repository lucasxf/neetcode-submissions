class Solution {
    public int lengthOfLongestSubstring(String s) {
        // problema: maior substring sem caractere repetidos
        // entrada: uma string s. Ex.: "Hello World"
        // saída: o tamanho da maior substring sem caracteres repetidos
        // ex.: 6: " World" (espaço + 5 letras)
        // "     " -> 1 (1 espaço)
        // "aabbcc" -> 2 (ab // bc)
        // complexidade sugerida: O(n) TEMPO -> tamanho "s", O(M) espaço -> caracteres únicos em "s"
        // abordagem: comparação de itens únicos sugere: Map e/ou 2 pointers (convertendo S para um array de chars)
        // vou começar com sliding window da esquerda para direita
        if (s.length() == 1)
            return 1;
        int left = 0, right = 1;
        int maxLength = 0;
        char[] chars = s.toCharArray();
        String curr = "" + s.charAt(0);
        System.out.println("curr: " + curr + " | len: " + s.length());
        while (left <= right && right < chars.length) {
            char start = chars[left];
            char end = chars[right];
            if (!curr.contains("" + end)) {
                curr = s.substring(left, ++right);
            } else {
                curr = s.substring(++left, right);
            }
            maxLength = Math.max(maxLength, right - left);
            System.out.printf("start: %s | end: %s | left: %d | right: %d | max: %d | curr: %s%n", start, end, left,right, maxLength, curr);
        }
        return maxLength;
    }
}
