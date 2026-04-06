class Solution {
    public int[] productExceptSelf(int[] nums) {
        // PROBLEM: preciso multiplicar todos os índices de um array naquela posição com exceção dele próprio.
        // Uma espécie de fatorial, ou melhor, produto auto-excludente
        // INPUT: [1,2,4,6], OUTPUT:[48,24,12,8] -> [2*4*6 (excluiu 1), 1*4*6, 1*2*6, 1*2*4]
        // EXAMPLE: 
        // PATTERN: me parece um problema de two-pointers, 
        // eu consigo executá-lo com operador de divisão, mas a follow-up question
        // diz: "Could you solve it in time without using the division operation?"
        // APPROACH: vou iterar 2 vezes: 
        // a primeira para multiplicar os valores de cada índice e calcular o produto final
        // a segunda para atribuir o produto final para cada índice.
        // me preocupo com números negativos e com o edge case zero,
        // especialmente quando houver intervalos entre os zeros
        // ex.: [1, 0, 2, 3, 4, 0, 5]
        // o problema não especifica se os números são ordenados
        // nem se eles são únicos, então vou assumir que repetições são possíveis
        // COMPLEXITY: O(N) time & space
        // aos 18 min eu li a primeira dica: "A brute-force solution would be to iterate through the array with index i and compute the product of the array except for that index element. This would be an O(n^2) solution. Can you think of a better way?": brute force (eu pulei essa opção diretamente)
        // eu já estava utilizando 2 arrays quando li a hint 2: "Is there a way to avoid the repeated work? Maybe we can store the results of the repeated work in an array.""
        // hint 3: We can use the prefix and suffix technique. First, we iterate from left to right and store the prefix products for each index in a prefix array, excluding the current index's number. Then, we iterate from right to left and store the suffix products for each index in a suffix array, also excluding the current index's number. Can you figure out the solution from here?
        // aos 25 min eu li o hint 4: We can use the stored prefix and suffix products to compute the result array by iterating through the array and simply multiplying the prefix and suffix products at each index.
        // não consegui resolver, minha dúvida é o seguinte: como "Pular/ignorar" o índice atual nos produtos?
        int len = nums.length;
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        int[] result = new int[len];
        int product = 1;
        prefix[0] = 1;
        suffix[len-1] = 1;
        for (int i = 0, j = 1; j < len; i++, j++) {
            product *= nums[i];
            if (nums[i] == 0) {
                prefix[j] = 0;
            } else {
                prefix[j] = product;
            }
        }
        product = 1;
        for (int i = len -1, j = len -2; i > 0; i--, j--) {
            product *= nums[i];
            if (nums[i] == 0) {
                suffix[j] = 0;
            } else {
                suffix[j] = product;
            }
        }   
        for (int i = 0; i < len; i++) {
            //System.out.printf("p: %d | prefix[%d]: %d | suffix[%d]: %d%n", product, i, prefix[i], i, suffix[i]);
            result[i] = prefix[i] * suffix[i];
        }
        return result;
    }
}  
