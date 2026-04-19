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
        int len = nums.length; // 5
        int result = -1;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            int l = nums[left];
            int r = nums[right];
            int m = nums[mid];
            // se o alvo for maior que o meio
            if (target == m) {
                return mid;
            } else if (target == l) {
                return left;
            }
            if (target > m) {
                // e se a metade à direita está em ordem crescente
                if (m < r) {
                    // procure o target à direita
                    left = mid + 1;
                    // se não estiver
                } else {
                    right = mid - 1;
                }
                // se o alvo for menor ou igual ao meio
            } else {
                // e o lado direito estiver ordenado
                if (m < r) {
                    // procure à esquerda
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
       }
       return -1;
    }
}
