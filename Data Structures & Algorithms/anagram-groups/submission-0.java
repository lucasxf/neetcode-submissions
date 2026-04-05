class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // PROBLEM: preciso agrupar anagramas em coleções de anagramas, ordem é irrelevante
        // INPUT: um array de strings, OUTPUT: uma lista de listas de anagramas
        // PATTERN: para anagramas é possível utilizar o letras[26] do blind problem de anagramas
        // APPROACH: percorro o array original comparando os anagramas entre si. Ao encontrar, salvo na lista auxiliar
        // COMPLEXITY: O(N²) time, O(N) space
        List<List<String>> groupedAnagrams = new ArrayList<>();
        Set<String> seenWords = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            String word1 = strs[i];
            if (seenWords.contains(word1)) {
                continue;
            } else {
                seenWords.add(word1);
            }
            char[] w1Chars = word1.toCharArray();
            List<String> anagrams = new ArrayList<>();
            anagrams.add(word1);
            int[] letters = new int[26];
            for (int j = i; j < strs.length; j++) {
                String word2 = strs[j];
                char[] w2Chars = word2.toCharArray();
                if (w1Chars.length == w2Chars.length) {
                    boolean isAnagram = true;
                    for (int k = 0; k < w2Chars.length; k++) {
                        char c1 = w1Chars[k];
                        char c2 = w2Chars[k];
                        letters[c1 - 'a']++;
                        letters[c2 - 'a']--;
                    }
                    for (int l = 0; l < 26; l++) {
                        if (letters[l] != 0) {
                            isAnagram = false;
                        }
                    }
                    if (isAnagram) {
                        if (seenWords.contains(word2)) {
                            continue;
                        } else {
                            seenWords.add(word2);
                        }
                        anagrams.add(word2);
                    }
                }
            }
            groupedAnagrams.add(anagrams);
        }
        return groupedAnagrams;
    }
}
