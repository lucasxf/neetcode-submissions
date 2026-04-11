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
        char[] chars = s.toCharArray();
        int maxLength = 0;
        while (right < s.length()) {
            char l = chars[left]; // z, z, z
            char r = chars[right]; // x, y, z
            String curr = s.substring(left, right); // zx, zxy, zxyz
            System.out.printf("left: %d | right: %d | curr: %s | l: %s | r: %s | max: %d%n", left, right, curr, l, r, maxLength);
            // if valid substring -> update len 
            if (!curr.contains(String.valueOf(r))) { // lógica falha
                right++; // 2, 3
            } else { 
                maxLength = Math.max(maxLength, right - left); // 2, 3
                left++;
            }
        }
        return maxLength;
    }
}
