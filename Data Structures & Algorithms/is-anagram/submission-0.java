class Solution {
    public boolean isAnagram(String s, String t) {
        // step 1: restate the problem: verificar se uma string é anagrama de outra
        // step 2: clarify inputs and outputs: strings de entrada, boolean de saída
        // step 3: 1-2 small examples
        // step 4: name the pattern/dsa: comparação de arrays/strings ou verificação de conteúdo (.contains())
        // step 5: state your approach and complexity b4 writing: a princípio eu iria ordernar as 2 strings e compará-las com .equals(). O(n log n) + O(N) 
        // Depois decidi utilizar uma estrutura auxiliar com "push/add" e "pop/remove" O(2N) -> O(N)
        // como 3a abordagem (que percebi no meio do caminho, depois de 13 min), achei melhor utilizar um mapa com contador de ocorrências
        if (s == null || t == null || s.isEmpty() || t.isEmpty() || s.length() != t.length()) {
            return false;
        }
        List<String> letters = new ArrayList<>();
        Map<String, Integer> charOccurrencies = new HashMap<>();
        for (char c : s.toCharArray()) {
            String str = "" + c;
            if (charOccurrencies.containsKey(str)) {
                int count = charOccurrencies.get(str) + 1;
                charOccurrencies.put(str, count);
            } else {
                charOccurrencies.put(str, 1);
            }
        }
        System.out.println(charOccurrencies);
        for (int i = 0, j = 1; j <= t.length(); i++, j++) {
            String key = t.substring(i, j);
            System.out.println("key: " + key + " | j: " + j);
            if (charOccurrencies.containsKey(key)) {
                int count = charOccurrencies.get(key) - 1;
                if (count == 0) {
                    charOccurrencies.remove(key);
                } else {
                    charOccurrencies.put(key, count);
                }
            }
        }
        System.out.println(charOccurrencies);
        return charOccurrencies.isEmpty();
    }
}
