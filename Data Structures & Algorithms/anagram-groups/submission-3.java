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
        }
        for (String key : anagramsPerSortedKeys.keySet()) {
            List<String> anagrams = anagramsPerSortedKeys.get(key);
            groupedAnagrams.add(anagrams);
        }
        return groupedAnagrams;
    }
}
