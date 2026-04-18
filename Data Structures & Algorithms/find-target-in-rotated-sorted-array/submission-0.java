class Solution {
    public int search(int[] nums, int target) {
        // problema: eu recebo um vetor ordenado de tamanho N rotacionado de 1 a N vezes
        // e um int target que eu preciso encontrar no vetor
        // se o target for encontrado, retorno a posição dele
        // senão for encontrado, retorno - 1
        // a solução não deve ser brute force/trivial O(N)
        // abordagem:
        // vou inicializar um `int result = -1`
        // e utilizar binary search para identificar a cada comparação
        // se o valor nums[iterador] é igual a target
        // vou dividir o vetor de entrada em vetores menores
        // a condição de parada é encontrar o target ou percorrer o vetor inicial inteiro
        // sempre que o valor ao meio for maior que o target, posso selecionar o vetor à esquerda
        // do contrário, direita
        if (nums.length == 0) {
            return nums[0] == target ? 0 : -1;
        }
        int len = nums.length; // 6
        int result = -1;
        int left = 0;
        int right = len - 1; // 5
        // [3, 4, 5, 6, 1, 2]
        while (left <= right) { // 0 < 5
            int mid = left + (right - left) / 2; // (5-0)/2=2 | 5-3)/2=1 |
            int l = nums[left]; // 3 | 6
            int r = nums[right]; // 2 | 2
            if (nums[mid] == target) { // false | 4
                return mid;
            } else if (l == target) { // false |
                return left;
            } else if (r == target) { // false |
                return right;
            }
            // indica que o vetor foi rotacionado de 1 a N-1 vezes
            // e que o resultado pode estar no vetor à direita do centro dessa iteração
            if (target < l) { // 1 < 5? -> true |
                left = mid + 1; // left = 3
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
