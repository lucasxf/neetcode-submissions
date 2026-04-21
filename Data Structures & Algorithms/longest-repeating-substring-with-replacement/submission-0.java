class Solution {
    public int characterReplacement(String s, int k) {
        // você recebe uma string s com caracteres maiúscula (A-Z)
        // e um inteiro k -> que é o limite de quantas substituições
        // podem ser feitas naquela janela
        // o objetivo é retornar o tamanho máximo de uma string
        // que possui apenas o mesmo caracter repetido
        // para preparar essa string, podem ser substituídas até k
        // letras nela para chegar ao resultado
        // abordagem:
        // vou utilizar um mapa para contar o número de ocorrências
        // de um caracter C dentro de uma janela
        // o "limite" de uma janela é o caracter mais frequente nela
        // somado à k substituições (de caracteres com menos ocorrências)
        // sempre que eu atingir esse limite, cresço a janela para direita
        // e encolho a janela à esquerda, bem como, diminuo em 1 o contador
        // de frequência do mapa do caracter à esquerda recém retirado da janela
        // 6 min
        // tamanho da janela = (right - left) + 1
        char[] chars = s.toCharArray();
        Map<Character, Integer> charFrequency = new HashMap<>();
        // inicio a janela com ambos na mesma posição
        int left = 0, right = 0;
        int  len = chars.length - 1;
        int max = 0;
        // O(N)
        while (left <= right && right < len) {
            int replacements = k;
            // enquanto a janela for válida, incremente right
            // o que torna a janela válida?
            // o número de substituições ser > 0
            // O(N*k)
            while (replacements >= 0 && right < len) {
                char curr = chars[right];
                // se a char `c` estiver presente, pegue o contador atual e some com 1
                // senão, adicione a chave e inicie a contagem em 1
                charFrequency.merge(curr, 1, Integer::sum);
                // identifica o caractere mais frequente e sua frequência na janela atual
                Map.Entry<Character, Integer> maxEntry = Collections.max(charFrequency.entrySet(), Map.Entry.comparingByValue());
                char mostFrequentChar = maxEntry.getKey();
                int highestFrequency = maxEntry.getValue();
                // AAABABB
                System.out.printf("char: '%s' appears %d times -> %s%n", mostFrequentChar, highestFrequency, charFrequency);
                // se o caractere atual for diferente do caractere mais frequente da janela
                // decremente o número de substituições em 1
                if (curr != mostFrequentChar) {
                    replacements--;
                }
                //int windowSize = right - left + 1;
                
                // aumenta janela à direita
                right++;
                max = Math.max(max, highestFrequency + k);
            }
            // identifica caractere ao início da janela
            char leftChar = chars[left];
            // decrementa contador dele em 1
            charFrequency.computeIfPresent(leftChar, (key, val) -> val - 1);
            // encolhe janela à esquerda
            left++;
        }
        return max;
    }
}