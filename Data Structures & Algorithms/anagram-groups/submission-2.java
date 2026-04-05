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
        // strs = ["", ""]
        for (int i = 0; i < strs.length; i++) {
            String word = strs[i]; // ""
            char[] chars = word.toCharArray(); // [',']
            char[] sortedChars = word.toCharArray();  // [',']
            Arrays.sort(sortedChars);  // [',']
            String sortedWord = new String(sortedChars);  // ""
            anagramsPerSortedKeys.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
            /*
            if (anagramsPerSortedKeys.containsKey(sortedWord)) { // false
                List<String> currAnagrams = anagramsPerSortedKeys.get(sortedWord);
                currAnagrams.add(word1);
            } else {
                List<String> newAnagrams = new ArrayList<>(); // []
                newAnagrams.add(word); // [""]
                anagramsPerSortedKeys.put(w1Sorted, newAnagrams); // {"", [""]}
            }*/
            //int[] letters = new int[26]; // [0,...,0]
            
        }
        /*
        for (int i = 0; i < strs.length; i++) {
            String word1 = strs[i]; // ""
            char[] w1Chars = word1.toCharArray(); // [',']
            char[] w1SortedChars = word1.toCharArray();  // [',']
            Arrays.sort(w1SortedChars);  // [',']
            String w1Sorted = new String(w1SortedChars);  // ""
            if (anagramsPerSortedKeys.containsKey(w1Sorted)) { // false
                List<String> currAnagrams = anagramsPerSortedKeys.get(w1Sorted);
                if (!currAnagrams.contains(word1)) {
                    currAnagrams.add(word1);
                }
            } else {
                List<String> newAnagrams = new ArrayList<>(); // []
                newAnagrams.add(word1); // [""]
                anagramsPerSortedKeys.put(w1Sorted, newAnagrams); // {"", [""]}
            }
            int[] letters = new int[26]; // [0,...,0]
            for (int j = i+1; j < strs.length; j++) {
                String word2 = strs[j]; // ""
                char[] w2Chars = word2.toCharArray(); // [',']
                char[] w2SortedChars = word2.toCharArray(); // [',']
                Arrays.sort(w2SortedChars); // [',']
                String w2Sorted = new String(w2SortedChars); // ""
                if (w1Chars.length == w2Chars.length) { // true
                    boolean isAnagram = true;
                    for (int k = 0; k < w2Chars.length; k++) {
                        char c1 = w1Chars[k]; // ""
                        char c2 = w2Chars[k]; // ""
                        letters[c1 - 'a']++; // 0 + 1 = 1
                        letters[c2 - 'a']--; // 1 - 1 = 0
                    }
                    for (int l = 0; l < 26; l++) {
                        if (letters[l] != 0) {
                            isAnagram = false;
                        }
                    }
                    if (isAnagram) { // true
                        if (anagramsPerSortedKeys.containsKey(w2Sorted)) { // true
                            List<String> currAnagrams = anagramsPerSortedKeys.get(w2Sorted);
                            if (i != j) {
                                currAnagrams.add(word2);
                            }
                        } else {
                            List<String> newAnagrams = new ArrayList<>();
                            newAnagrams.add(word2);
                            anagramsPerSortedKeys.put(w2Sorted, newAnagrams);
                        }
                    }
                }
            }
            //groupedAnagrams.add(anagrams);
        }*/
        for (String key : anagramsPerSortedKeys.keySet()) {
            List<String> anagrams = anagramsPerSortedKeys.get(key);
            groupedAnagrams.add(anagrams);
        }
        return groupedAnagrams;
    }
}
