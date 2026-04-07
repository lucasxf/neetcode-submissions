class Solution {
    public int longestConsecutive(int[] nums) {
        /*
Given an array of integers nums, return the length of the longest consecutive sequence of elements that can be formed.

A consecutive sequence is a sequence of elements in which each element is exactly 1 greater than the previous element. The elements do not have to be consecutive in the original array.

You must write an algorithm that runs in O(n) time.
        */
        // PROBLEM: encontrar a maior sequência de números em ordem crescente 
        // (incremento exatamente igual a 1) dentro de um array
        // INPUT: um array, OUTPUT: o tamanho da sequência
        // EXAMPLE: input [0,3,2,5,4,6,1,1] | output: 7 -> 0, 1, 2, 3, 4, 5, 6
        // CONSTRAINT: o algoritmo deve ter tempo O(N), o array original pode estar
        // fora de ordem
        // PATTERN: me parece que two pointers e/ou sliding window podem ajudar
        // APPROACH: 
        // 1. pensei em fazer algumas iterações comparando os dois ponteiros
        // geralmente no sliding window, ambos ponteiros andam apenas para direita
        // mas nesse problema me parece que precisarei de um tipo de "sanfona"
        // um algoritmo de acordeon onde o ponteiro da esquerda pode ir para direita
        // mas o ponteiro da direita pode ir e voltar pelo array
        // ordenação em arrays custa O(N log N) de tempo, então precisei descartá-la
        // 2. pensei em fazer um mapa de listas:
        // Map<Integer, List<Integer>>  onde cada chave é um valor do array de entrada
        // e cada lista possui exatamente 2 números: um inteiro maior em 1 do que
        // a chave e outro inteiro menor em exatamente 1.
        // ex.: mapa = {5: [4, 6]}
        // depois eu iteraria pelo vetor identificando se ele possui 
        // descartei a abordagem aos 12 min
        // li a hint 1 aos 12 min: A brute force solution would be to consider every element from the array as the start of the sequence and count the length of the sequence formed with that starting element. This would be an O(n^2) solution. Can you think of a better way?
        // hint 2: Is there any way to identify the start of a sequence? For example, in [1, 2, 3, 10, 11, 12], only 1 and 10 are the beginning of a sequence. Instead of trying to form a sequence for every number, we should only consider numbers like 1 and 10.
        // hint 3 (única dica realmente valiosa, mas que eu já havia pensado parcialmente com o mapa): We can consider a number num as the start of a sequence if and only if num - 1 does not exist in the given array. We iterate through the array and only start building the sequence if it is the start of a sequence. This avoids repeated work. We can use a hash set for O(1) lookups by converting the array to a hash set.
        // abordagem 3:
        // 1o loop: armazeno todos os valores do array no set
        // 2o loop, 1a iteração: vejo que valores do array + 1 estão no set
        // 2o loop: enquanto valor+1 existir no set, incremento o resultado
        // 2o loop: quando valor +1 não existir mais, "salvo" o maior resultado até agora Math.max(a,b)
        // 2o loop: depois de salvar, "pulo" para o próximo índice do array
        // terminei de escrever a 3a abordagem aos 19 min e comecei a codar
        // COMPLEXITY: me parece O(N * log N amortizado)
        Set<Integer> uniqueNums = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            uniqueNums.add(nums[i]);
        }
        int result = 0;
        for (int n : uniqueNums) {
            int curr = 1;
            if (uniqueNums.contains(n-1)) {
                continue;
            }
            n += 1;
            while (uniqueNums.contains(n)) {
                curr++;
                n++;
            }
            result = Math.max(result, curr);
        }
        return result;

    }
}
