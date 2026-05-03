class Solution {
    public int maxProduct(int[] nums) {
        // eu recebo um array de inteiros nums que estão fora de ordem
        // e podem ser negativos ou positivos.
        // ordenar não resolve
        // sliding window também não resolve, pois, 
        // o critério de expansão/encolhimento da janela é turvo/obscuro
        // se tratando de multiplicação, ainda tem um agravante: 
        // o produto de 2 negativos forma um positivo
        // tal qual o problema "Maximum Subarray", existe uma solução
        // com força bruta. Vou tentar fazer a solução elegante
        // 4 min
        // prefix sum sozinho não é o bastante:
        // Input: nums = [1,2,-3,4]
        // result: 4
        // prefix sum: [1, 2, -6, -24]
        // result: -24 (errado)
        // mas ajuda:
        // nums = [1, 2, -3, 4, -2]
        // prefix sum: [1, 2, -6, 48] 
        // result: 48 (correto)
        // [-5, 10, -3] -> [-5, -50, 150]
        // 7 min: comecei a codar
        // vou utilizar kadane, mas atento aos valores mínimos/negativos também
        if (nums.length == 1) {
            return nums[0];
        }
        int min = nums[0];
        int max = nums[0];
        int product = nums[0];
        int[] products = new int[nums.length];
        products[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // umaa das perguntas que eu quero responder:
            // 1. o produto dos dois menores negativos num subarray
            // é maior que o dos dois maiores positivos?
            
            // menor valor do subarray terminando em i
            min = Math.min(nums[i], min * nums[i]);

            // maior valor do subarray terminando em i
            max = Math.max(nums[i], max * nums[i]);
            products[i] = products[i - 1] * nums[i];
            product = Math.max(products[i], product);
            product = Math.max(nums[i], product);
        }

        return product;
    }
}
