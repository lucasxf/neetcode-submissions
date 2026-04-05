class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // PROBLEM: preciso agrupar anagramas em coleções de anagramas, ordem é irrelevante
        // INPUT: um array de strings, OUTPUT: uma lista de listas de anagramas
        // PATTERN: para anagramas é possível utilizar o letras[26] do blind problem de anagramas
        // APPROACH: percorro o array original comparando os anagramas entre si. Ao encontrar, salvo na lista auxiliar
        // COMPLEXITY: O(N²) time, O(N) space
        List<List<String>> groupedAnagrams = new ArrayList<>();
        Set<String> wordKeys = new HashSet<>();
        Map<String, List<String>> anagramsPerSortedKeys = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String word1 = strs[i];
            char[] w1Chars = word1.toCharArray();
            char[] w1SortedChars = word1.toCharArray();
            Arrays.sort(w1SortedChars);
            String w1Sorted = new String(w1SortedChars);
            if (anagramsPerSortedKeys.containsKey(w1Sorted)) {
                List<String> currAnagrams = anagramsPerSortedKeys.get(w1Sorted);
                if (!currAnagrams.contains(word1)) {
                    currAnagrams.add(word1);
                }
            } else {
                List<String> newAnagrams = new ArrayList<>();
                newAnagrams.add(word1);
                anagramsPerSortedKeys.put(w1Sorted, newAnagrams);
            }
            int[] letters = new int[26];
            for (int j = i+1; j < strs.length; j++) {
                String word2 = strs[j];
                char[] w2Chars = word2.toCharArray();
                char[] w2SortedChars = word2.toCharArray();
                Arrays.sort(w2SortedChars);
                String w2Sorted = new String(w2SortedChars);
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
                        if (anagramsPerSortedKeys.containsKey(w2Sorted)) {
                            List<String> currAnagrams = anagramsPerSortedKeys.get(w2Sorted);
                            if (!currAnagrams.contains(word2)) {
                                currAnagrams.add(word2);
                            }
                        } else {
                            List<String> newAnagrams = new ArrayList<>();
                            newAnagrams.add(word2);
                            anagramsPerSortedKeys.put(w2Sorted, newAnagrams);
                        }
                        /*
                        if (seenWords.contains(word2)) {
                            continue;
                        } else {
                            seenWords.add(word2);
                        }
                        anagrams.add(word2);
                        */
                    }
                }
            }
            //groupedAnagrams.add(anagrams);
        }
        for (String key : anagramsPerSortedKeys.keySet()) {
            List<String> anagrams = anagramsPerSortedKeys.get(key);
            groupedAnagrams.add(anagrams);
        }
        return groupedAnagrams;
    }
}
