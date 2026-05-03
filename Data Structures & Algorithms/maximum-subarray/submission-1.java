class Solution {
    public int maxSubArray(int[] nums) {
        // eu vou receber um array nums
        // e preciso retornar a soma do subarray
        // cuja soma é maior
        // diferente de outros problemas greedy, 
        // não posso simplesmente ordenar o array, pois,
        // os exemplos deixam claro que a resposta compreende,
        // o array como é fornecido, mesmo com números negativos dentro
        // do subarray de resposta.
        // 5 min
        // pensei em utilizar prefix sum, mas já descartei, o primeiro exemplo
        // já quebraria 
        // Input: nums = [2,-3,4,-2,2,1,-1,4]
        // output: 8
        // prefix = [2, -1, 3, 1, 3, 4, 3, 7]
        // eu preciso ter a possibilidade de "encolher" o array de entrada
        // quando quiser, como numa sliding window, porque sort e prefix já se provaram ineficazes
        // o problema é que sliding window sem ordem fica difícil de encontrar um critério
        // para crescimento ou encolhimento da janela
        // é como se cada índice de nums tivesse seu prefix sum com todas as combinações possíveis
        // de subarrays "ao seu redor"
        // 10 min
        // vou tentar com nested loops: comparo cada valor atual com um subarray possível até o final do array
        // à cada soma nova comparo e atualio o valor máximo. Retorno ele ao final
        // O(N^2)
        // 11 min comecei a codar
        if (nums.length == 1) {
            return nums[0];
        }
        int maxSum = nums[0];
        int maxVal = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int currSum = nums[i];
            maxVal = Math.max(nums[i], maxVal);
            for (int j = i+1; j < nums.length; j++) {
                currSum += nums[j];
                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }
        // 14 min: passou alguns test cases, falhou neste: [-2,1]
        // 15 min
        // introduzi maxVal e o ternário abaixo:
        return maxSum > maxVal ? maxSum : maxVal;
    }
}
